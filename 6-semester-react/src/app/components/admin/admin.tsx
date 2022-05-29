import { DbStoryInfoMapper } from '../../mappers/db-story-info.mapper';
import { DatabaseService } from '../../services/database.service';
import './admin.scss';

const db = new DatabaseService();

const Admin = () => {

  const onResetHackerCommentsClick = () => {
    const appStoriesIds = db.getAppStories().map(c => c.id);
    const hackerInfos = db.getStoryInfos().filter(c => !appStoriesIds.includes(c.storyId));
    hackerInfos.forEach(info => {
      info.comments = [];
      db.saveStoryInfo(info.storyId, info);
    });
    alert('Gotowe!');
  }

  const onResetHackerScoresClick = () => {
    const appStoriesIds = db.getAppStories().map(c => c.id);
    const hackerInfos = db.getStoryInfos().filter(c => !appStoriesIds.includes(c.storyId));
    hackerInfos.forEach(info => {
      info.appScore = 0;
      db.saveStoryInfo(info.storyId, info);
    });
    alert('Gotowe!');
  }

  const onResetAppCommentsClick = () => {
    const appStoriesIds = db.getAppStories().map(c => c.id);
    const appInfos = db.getStoryInfos().filter(c => appStoriesIds.includes(c.storyId));
    appInfos.forEach(info => {
      info.comments = [];
      db.saveStoryInfo(info.storyId, info);
    });
    alert('Gotowe!');
  }

  const onResetAppScoresClick = () => {
    const appStoriesIds = db.getAppStories().map(c => c.id);
    const appInfos = db.getStoryInfos().filter(c => appStoriesIds.includes(c.storyId));
    appInfos.forEach(info => {
      info.appScore = 0;
      db.saveStoryInfo(info.storyId, info);
    });
    alert('Gotowe!');
  }

  const onRemoveAllAppNewsClick = () => {
    db.clearAppStories();
    alert('Gotowe!');
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
      </div>
    </div>
  </div>

}

export default Admin;