import { useStories } from '../../stores/stories.store';
import Story from '../Story/Story';
import './Home.scss';

const Home = () => {
  const { stories } = useStories();
  let from = 1;
  let to = 2;
  const max = stories.length;

  return (<div>
    Hello from Home

    <div className="container">
      <div className="row">
        {stories.slice(from - 1, to).map(id => <Story key={id} id={id}></Story>)}
      </div>
    </div>
  </div>)
}

export default Home;
