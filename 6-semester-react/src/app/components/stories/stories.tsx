import { useEffect, useState } from 'react';
import { StoryOrigin } from '../../enums/story-origin-enum';
import { IStoryService } from '../../interfaces/story-service';
import { DatabaseService } from '../../services/database.service';
import { useStories } from '../../stores/stories.store';
import Story from '../story/story';
import './stories.scss';

interface StoriesProperties {
  service: IStoryService;
  origin: StoryOrigin;
}

interface StoriesState {
  origin: StoryOrigin;
  from: number;
  to: number;
  hiddenIds: number[];
}

const dbService = new DatabaseService();

const Stories = ({ service, origin }: StoriesProperties) => {
  const { stories } = useStories(origin);
  const max = stories.length;
  const step = 30;
  const getHiddenIds = () => dbService.getStoryInfos().filter(c => c.isHidden).map(c => c.storyId);

  const [state, setState] = useState<StoriesState>({
    origin,
    from: 1,
    to: step,
    hiddenIds: getHiddenIds(),
  });

  useEffect(() => {
    service.onStoryChange$.subscribe(() => {
      setState({ ...state, hiddenIds: getHiddenIds() })
    });
  }, [origin]);

  const onPaginatorLeftClick = () => {
    if (state.from > 1) {
      setState({
        ...state,
        from: state.from - step,
        to: state.to - step,
      })
    }
  }

  const onPaginatorRightClick = () => {
    if (state.to < max) {
      setState({
        ...state,
        from: state.from + step,
        to: state.to + step,
      })
    }
  }

  return (<div>
    <div className="container main-container">

      <div className="stories">
        <div className="list">
          <div className="row">
            {
              stories
                .slice(state.from - 1, state.to)
                .filter(c => !state.hiddenIds.includes(c))
                .map(id => <Story key={id} id={id} origin={origin}></Story>)
            }
          </div>
        </div>

        <div className="pagination">
          <div className="row">
            <div className="col-12">
              <div className="paginator">
                <span className="page-info">
                  {state.from}-{state.to} of {max}
                </span>

                <button className='material-button btn-left' onClick={onPaginatorLeftClick}>
                  <span className="material-icons button-icon">arrow_back</span>
                </button>

                <button className='material-button' onClick={onPaginatorRightClick}>
                  <span className="material-icons button-icon">arrow_forward</span>
                </button>
              </div>
            </div>
          </div>
        </div>
      </div>

    </div>
  </div>)
}

export default Stories;
