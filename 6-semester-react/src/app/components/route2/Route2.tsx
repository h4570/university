import { useState } from 'react';
import { useNavigate } from 'react-router-dom';
import './Route2.scss';

const Route2 = () => {
  const navigate = useNavigate();
  const [state, setState] = useState();

  const click = () => {
    navigate('/');
  }

  return <div onClick={click}>
    Hello from Route2
  </div>

}

export default Route2;