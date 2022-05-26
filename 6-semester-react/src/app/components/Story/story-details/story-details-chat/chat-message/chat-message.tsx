import { useState } from 'react';
import { StoryComment } from '../../../../../models/story-comment.model';
import './chat-message.scss';

interface ChatMessageProperties {
  comment: StoryComment;
}

interface ChatMessageChatState { }

const ChatMessage = ({ comment }: ChatMessageProperties) => {
  const [state, setState] = useState<ChatMessageChatState>({});

  return (
    <div className="col-12">
      {comment.username}: {comment.content}
    </div>
  )
}

export default ChatMessage;
