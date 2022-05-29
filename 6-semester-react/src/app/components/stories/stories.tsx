import { useEffect, useState } from 'react';
import { Subscription } from 'rxjs';
import { StoryOrigin } from '../../enums/story-origin-enum';
import { IStoryService } from '../../interfaces/story-service';
import { StoryInfo } from '../../models/story-info.model';
import { StoryModel } from '../../models/story.model';
import { ApiStoryService } from '../../services/api.story.service';
import { AppStoryService } from '../../services/app.story.service';
import { DatabaseService } from '../../services/database.service';
import { useStories } from '../../stores/stories.store';
import Story from '../story/story';
import './stories.scss';

interface StoriesProperties {
  service: IStoryService;
  origin: StoryOrigin;
}

interface StoriesState {
  newStoryTitle: string;
  newStoryUrl: string;
  search: string;
  origin: StoryOrigin;
  from: number;
  to: number;
  hiddenIds: number[];
}

const dbService = new DatabaseService();
let sub = new Subscription();

const Stories = ({ service, origin }: StoriesProperties) => {
  const step = 30;
  const getHiddenIds = () => dbService.getStoryInfos().filter(c => c.isHidden).map(c => c.storyId);

  const [state, setState] = useState<StoriesState>({
    newStoryTitle: '',
    newStoryUrl: '',
    search: '',
    origin,
    from: 1,
    to: step,
    hiddenIds: getHiddenIds(),
  });

  const { stories, fetch } = useStories(origin, state.search);
  const max = stories.length;

  useEffect(() => {
    if (!sub.closed) {
      sub.unsubscribe();
      sub = new Subscription();
    }

    sub.add(service.onStoryChange$.subscribe(() => {
      setState({
        ...state,
        newStoryTitle: '',
        newStoryUrl: '',
        hiddenIds: getHiddenIds()
      });
      fetch(state.search);
    }));

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

  const onAddNewsClick = (e: any) => {
    e.preventDefault();
    const isTitleValid = state.newStoryTitle?.length >= 5 && state.newStoryTitle?.length <= 100;
    const isUrlValid = state.newStoryUrl?.length >= 5 && state.newStoryUrl?.length <= 100;
    if (!isTitleValid || !isUrlValid) {
      alert('Formularz nieprawidłowy');
      return;
    }

    const appService = service as AppStoryService;
    const newStory = new StoryModel();

    newStory.title = state.newStoryTitle;
    newStory.url = state.newStoryUrl;

    const info = new StoryInfo();
    info.storyId = newStory.id;
    newStory.info = info;

    appService.save(newStory);
  }

  const handleTitleChange = (e: any) => {
    setState({ ...state, newStoryTitle: e.target.value });
  }

  const handleUrlChange = (e: any) => {
    setState({ ...state, newStoryUrl: e.target.value });
  }

  const handleSearchChange = (e: any) => {
    setState({ ...state, search: e.target.value });
    fetch(e.target.value);
  }

  return (<div>
    <div className="container main-container">

      <div className="stories">

        {origin === StoryOrigin.app && <div className="add-story">
          <form>
            <div className="row">

              <div className="col-3">
                <label className="has-float-label w-100">
                  <input placeholder=" " className='w-100' minLength={5} maxLength={100} type="text" value={state.newStoryTitle} required={true} onChange={handleTitleChange} />
                  <span className="label">News *</span>
                </label>
              </div>

              <div className="col-3">
                <label className="has-float-label w-100">
                  <input placeholder=" " className='w-100' minLength={5} maxLength={100} type="text" value={state.newStoryUrl} required={true} onChange={handleUrlChange} />
                  <span className="label">Url *</span>
                </label>
              </div>

              <div className="col-4">
                <span className='material-icons add-news-icon' onClick={onAddNewsClick}>add</span>
              </div>

              <div className="col-2">
                <label className="has-float-label w-100">
                  <input placeholder=" " className='w-100' minLength={1} maxLength={100} type="text" value={state.search} required={false} onChange={handleSearchChange} />
                  <span className="label">Search</span>
                </label>
              </div>

            </div>
          </form>
        </div>}

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

const AppStories = () => Stories({ service: new AppStoryService(), origin: StoryOrigin.app });
const ApiStories = () => Stories({ service: new ApiStoryService(), origin: StoryOrigin.api });

export { ApiStories, AppStories };
