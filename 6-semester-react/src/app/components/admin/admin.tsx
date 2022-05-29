import { useState } from 'react';
import { DbStoryInfo } from '../../models/db-story-info.model';
import { DatabaseService } from '../../services/database.service';
import './admin.scss';

const db = new DatabaseService();

interface AdminState {
  hackerScores: number;
  hackerComments: number;
  appScores: number;
  appComments: number;
  appNews: number;
  info: string;
}

const Admin = () => {

  const getAppInfos = (): DbStoryInfo[] => {
    const appStoriesIds = db.getAppStories().map(c => c.id);
    const appInfos = db.getStoryInfos().filter(c => appStoriesIds.includes(c.storyId));
    return appInfos;
  }

  const getHackerInfos = (): DbStoryInfo[] => {
    const appStoriesIds = db.getAppStories().map(c => c.id);
    const hackerInfos = db.getStoryInfos().filter(c => !appStoriesIds.includes(c.storyId));
    return hackerInfos;
  }

  const getFreshState = (): AdminState => {
    return {
      hackerScores: getHackerInfos().map(info => info.appScore).reduce((acc, cur) => acc + cur, 0),
      hackerComments: getHackerInfos().map(info => info.comments.length).reduce((acc, cur) => acc + cur, 0),
      appScores: getAppInfos().map(info => info.appScore).reduce((acc, cur) => acc + cur, 0),
      appComments: getAppInfos().map(info => info.comments.length).reduce((acc, cur) => acc + cur, 0),
      appNews: getAppInfos().length,
      info: ''
    };
  }

  const [state, setState] = useState<AdminState>(getFreshState());

  const onResetHackerCommentsClick = () => {
    getHackerInfos().forEach(info => {
      info.comments = [];
      db.saveStoryInfo(info.storyId, info);
    });
    showNotification('Gotowe!');
  }

  const onResetHackerScoresClick = () => {
    getHackerInfos().forEach(info => {
      info.appScore = 0;
      db.saveStoryInfo(info.storyId, info);
    });
    showNotification('Gotowe!');
  }

  const onResetAppCommentsClick = () => {
    getAppInfos().forEach(info => {
      info.comments = [];
      db.saveStoryInfo(info.storyId, info);
    });
    showNotification('Gotowe!');
  }

  const onResetAppScoresClick = () => {
    getAppInfos().forEach(info => {
      info.appScore = 0;
      db.saveStoryInfo(info.storyId, info);
    });
    showNotification('Gotowe!');
  }

  const onRemoveAllAppNewsClick = () => {
    db.clearAppStories();
    showNotification('Gotowe!');
  }

  const showNotification = (text: string) => {
    setState({
      ...getFreshState(),
      info: text
    });
    setTimeout(() => {
      setState({
        ...getFreshState(),
        info: ''
      });
    }, 1500);
  }

  return <div className="container main-container">
    <div className="admin-panel">
      <div className="row">
        <div className="col-6">
          <h3>Hacker news</h3>

          <button className='material-button nav-btn' onClick={onResetHackerCommentsClick}>
            Reset comments
          </button>

          <button className='material-button nav-btn' onClick={onResetHackerScoresClick}>
            Reset scores
          </button>

        </div>

        <div className="col-6">
          <h3>App news</h3>

          <button className='material-button nav-btn' onClick={onResetAppCommentsClick}>
            Reset comments
          </button>

          <button className='material-button nav-btn' onClick={onResetAppScoresClick}>
            Reset scores
          </button>

          <button className='material-button nav-btn' onClick={onRemoveAllAppNewsClick}>
            Remove all
          </button>

        </div>

        <div className="col-12">
          <h3>Stats</h3>
          <p>Hacker comments: {state.hackerComments}</p>
          <p>Hacker scores: {state.hackerScores}</p>
          <p>App comments: {state.appComments}</p>
          <p>App scores: {state.appScores}</p>
          <p>App news: {state.appNews}</p>
        </div>

        {state.info && <div className="col-12 admin-notification">
          <h2>{state.info}</h2>
        </div>}
      </div>
    </div>
  </div>

}

export default Admin;