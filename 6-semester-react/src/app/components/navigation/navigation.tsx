import { useState } from 'react';
import { useNavigate } from 'react-router-dom';
import './navigation.scss';

const NAV_ITEMS: NavigationState[] = [
  { name: 'Hacker news', path: '/' },
  { name: 'App news', path: '/app-stories' },
  { name: 'Admin', path: '/admin' },
];

interface NavigationState {
  name: string;
  path: string;
}

const Navigation = () => {
  const navigate = useNavigate();
  const [state, setState] = useState<NavigationState>(NAV_ITEMS[0]);

  const onHackerNewsClick = () => {
    changeRoute(NAV_ITEMS[0]);
  }

  const onAppNewsClick = () => {
    changeRoute(NAV_ITEMS[1]);
  }

  const onAdminClick = () => {
    changeRoute(NAV_ITEMS[2]);
  }

  const changeRoute = (itm: NavigationState) => {
    setState(itm);
    navigate(itm.path);
  }

  return <div className='container navigation-container'>
    <div className="row">
      <div className="col-9">
        <button className='material-button nav-btn' onClick={onHackerNewsClick}>
          Hacker news
        </button>
        <button className='material-button nav-btn' onClick={onAppNewsClick}>
          App news
        </button>
        <button className='material-button nav-btn' onClick={onAdminClick}>
          Admin
        </button>
      </div>
      <div className="col-3 nav-right">
        <div className='nav-right-text'>{state.name}</div>
      </div>
    </div>
  </div>

}

export default Navigation;