import { useState } from 'react';
import { StoryComment } from '../../../../models/story-comment.model';
import { StoryModel } from '../../../../models/story.model';
import { AutoStoryService } from '../../../../services/auto.story.service';
import ChatMessage from './chat-message/chat-message';
import './story-details-chat.scss';

interface StoryDetailsChatProperties {
  story: StoryModel
}

interface StoryDetailsChatState {
  comments: StoryComment[];
  commentContent: string;
}

const storyService = new AutoStoryService();

const StoryDetailsChat = ({ story }: StoryDetailsChatProperties) => {
  const [state, setState] = useState<StoryDetailsChatState>({ comments: story.info.comments, commentContent: '' });

  const onAddClick = (e: any) => {
    e.preventDefault();

    const comment = new StoryComment();
    comment.username = 'Sandro';
    comment.content = state.commentContent;
    story.info.comments.push(comment);
    storyService.save(story);

    setState({
      commentContent: '',
      comments: story.info.comments
    })
  }

  const handleChange = (e: any) => {
    setState({ ...state, commentContent: e.target.value });
  }

  return (
    <div className="col-12">
      <div className="row">
        <div className="col-12">
          <form>
            <div className="row">
              <div className="col-6">
                <textarea className="comment-content" value={state.commentContent} onChange={handleChange}></textarea>
              </div>
              <div className="col-6">
                <span className='material-icons add-comment-icon' onClick={onAddClick}>add</span>
              </div>
            </div>
          </form>
        </div>

        <div className="col-12">
          {state.comments.map(comment => <ChatMessage key={comment.id} comment={comment}></ChatMessage>)}
        </div>
      </div>
    </div>
  )
}

export default StoryDetailsChat;
