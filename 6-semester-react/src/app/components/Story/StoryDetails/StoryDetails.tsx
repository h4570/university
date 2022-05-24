import { DateTime } from 'luxon';
import { StoryModel } from '../../../models/story.model';
import './StoryDetails.scss';

interface StoryDetailsProperties {
  story: StoryModel
}

const StoryDetails = ({ story }: StoryDetailsProperties) => {
  return (
    <div className="row">

      <div className="col-12">
        <div className="title">
          <span className="title-text">
            <a href={story.url} target="about_blank">{story.title}</a>
          </span>
        </div>
      </div>

      <div className="col-6">
        <span className="material-icons news-icon">sports_score</span>
        {story.score}
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
