import { useStory } from '../../stores/story.store';
import LoadingBox from '../LoadingBox/LoadingBox';
import './Story.scss';
import StoryDetails from './StoryDetails/StoryDetails';
import { STORY_LOADING_BOX_PROPS } from './StoryLoadingBoxShapes';

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
