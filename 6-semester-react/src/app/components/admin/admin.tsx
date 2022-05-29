import { useState } from 'react';
import { useNavigate } from 'react-router-dom';
import './admin.scss';

const Admin = () => {
  const navigate = useNavigate();
  const [state, setState] = useState();

  const click = () => {
    navigate('/');
  }

  return <div onClick={click}>
    Hello from Route2
  </div>

}

export default Admin;