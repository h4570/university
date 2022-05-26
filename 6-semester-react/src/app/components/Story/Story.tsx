import './story.scss';
import { useStory } from '../../stores/story.store';
import LoadingBox from '../loading-box/loading-box';
import StoryDetails from './story-details/story-details';
import { STORY_LOADING_BOX_PROPS } from './consts/story-loading-box-shapes';

interface StoryProperties {
  id: number
}

const Story = ({ id }: StoryProperties) => {
  const { story } = useStory(id);

  let result;
  if (story) {
    result = <StoryDetails story={story}></StoryDetails>
  } else {
    result = <LoadingBox props={STORY_LOADING_BOX_PROPS}></LoadingBox>
  }

  return (
    <div className="col-12 story-container">
      {result}
    </div>
  )
}

export default Story;
