import { DateTime } from 'luxon';
import { useState } from 'react';
import { StoryModel } from '../../../models/story.model';
import { AutoStoryService } from '../../../services/auto.story.service';
import './StoryDetails.scss';

interface StoryDetailsProperties {
  story: StoryModel
}

interface StoryDetailsState {
  score: number;
}

const appService = new AutoStoryService();

const StoryDetails = ({ story }: StoryDetailsProperties) => {
  const [state, setState] = useState<StoryDetailsState>({ score: story.score + story.info.appScore });

  const onCloseClick = () => {
    story.info.isHidden = true;
    appService.save(story);
  }

  const onChangeScoreClick = () => {
    if (story.info.appScore === 0) {
      story.info.appScore++;
      appService.save(story);
      setState({
        score: story.score + story.info.appScore
      })
    }
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
      </div>
      <div className="col-6 creator-container">
        <span className="date-text">{story.time.toLocaleString(DateTime.DATE_HUGE)}&nbsp;</span>
        <span className="material-icons news-icon">person</span>
        {story.by}
      </div>

    </div>
  )
}

export default StoryDetails;
