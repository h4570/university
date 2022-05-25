import ReactDOM from 'react-dom/client';
import './index.scss';
import './bootstrap-grid.scss';
import './material-stuff.scss';
import reportWebVitals from './reportWebVitals';
import {
  BrowserRouter as Router,
  Routes,
  Route,
} from "react-router-dom";
import Route2 from './app/components/route2/Route2';
import Route1 from './app/components/route1/Route1';
import Home from './app/components/home/Home';

const root = ReactDOM.createRoot(
  document.getElementById('root') as HTMLElement
);
root.render(
  // <React.StrictMode>
  <Router>
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet" />
    <Routes>
      <Route path="/route1" element={<Route1 />}></Route>
      <Route path="/route2" element={<Route2 />}> </Route>
      <Route path="/" element={<Home />}> </Route>
    </Routes>
  </Router>
  // </React.StrictMode>
);

// If you want to start measuring performance in your app, pass a function
// to log results (for example: reportWebVitals(console.log))
// or send to an analytics endpoint. Learn more: https://bit.ly/CRA-vitals
reportWebVitals();
