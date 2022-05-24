import { useNavigate } from 'react-router-dom';
import './Route1.scss';

const Route1 = () => {
  const navigate = useNavigate();

  const click = () => {
    navigate('/route2');
  }

  return <div onClick={click}>
    Hello from Route1
  </div>

}

export default Route1;
