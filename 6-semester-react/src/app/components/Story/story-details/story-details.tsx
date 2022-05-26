import { DateTime } from 'luxon';
import { useEffect, useState } from 'react';
import { StoryModel } from '../../../models/story.model';
import { AutoStoryService } from '../../../services/auto.story.service';
import StoryDetailsChat from './story-details-chat/story-details-chat';
import './story-details.scss';

interface StoryDetailsProperties {
  story: StoryModel
}

interface StoryDetailsState {
  score: number;
  chatOpened: boolean;
  timeToDisplay: string;
  commentsLength: number;
}

const storyService = new AutoStoryService();

const getTimeToDisplay = (story: StoryModel) => story.info.isModified
  ? story.info.modificationDate.toLocaleString(DateTime.DATETIME_FULL)
  : story.time.toLocaleString(DateTime.DATETIME_FULL);


const StoryDetails = ({ story }: StoryDetailsProperties) => {
  const [state, setState] = useState<StoryDetailsState>({
    score: story.score + story.info.appScore,
    chatOpened: false,
    timeToDisplay: getTimeToDisplay(story),
    commentsLength: story.info.comments.length
  });

  useEffect(() => {
    storyService.onStoryChange$.subscribe((stories) => {
      if (stories.find(s => s.id === story.id)) {
        setState(getFreshState());
      }
    });
  }, []);

  const getFreshState = (): StoryDetailsState => {
    return {
      chatOpened: true,
      score: story.score + story.info.appScore,
      timeToDisplay: getTimeToDisplay(story),
      commentsLength: story.info.comments.length
    }
  }

  const onCloseClick = () => {
    story.info.isHidden = true;
    storyService.save(story);
  }

  const onChangeScoreClick = () => {
    if (story.info.appScore === 0) {
      story.info.appScore++;
      storyService.save(story);
      setState({
        ...state,
        timeToDisplay: getTimeToDisplay(story),
        score: story.score + story.info.appScore
      })
    }
  }

  const onOpenChatClick = () => {
    setState({
      ...state,
      timeToDisplay: getTimeToDisplay(story),
      chatOpened: !state.chatOpened
    })
  }

  return (
    <div className="row">

      <div className="col-12">
        <div className="title">
          <span className="title-text">
            <a href={story.url} target="about_blank">{story.title}</a>
          </span>
          <div className="hide-btn">
            <span className="material-icons close-btn" onClick={onCloseClick}>close</span>
          </div>
        </div>
      </div>

      <div className="col-6">
        <span className="material-icons news-icon">sports_score</span>
        {state.score}
        <span className="material-icons change-score-icon" onClick={onChangeScoreClick}>arrow_drop_up</span>
        <span className="material-icons open-chat-icon" onClick={onOpenChatClick}>chat</span>
        <span className='comments-count'>{state.commentsLength}</span>
      </div>
      <div className="col-6 creator-container">
        <span className="date-text">{state.timeToDisplay}&nbsp;</span>
        <span className="material-icons news-icon">person</span>
        {story.by}
      </div>

      {state.chatOpened && <StoryDetailsChat story={story}></StoryDetailsChat>}
    </div>
  )
}

export default StoryDetails;
