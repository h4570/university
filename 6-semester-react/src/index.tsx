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
import Admin from './app/components/admin/admin';
import Navigation from './app/components/navigation/navigation';
import Stories from './app/components/stories/stories';
import { StoryOrigin } from './app/enums/story-origin-enum';
import { ApiStoryService } from './app/services/api.story.service';
import { AppStoryService } from './app/services/app.story.service';

const root = ReactDOM.createRoot(
  document.getElementById('root') as HTMLElement
);
root.render(
  // <React.StrictMode>
  <Router>
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet" />
    <Navigation></Navigation>
    <Routes>
      <Route path="/app-stories" element={<Stories origin={StoryOrigin.app} service={new AppStoryService()} />}></Route>
      <Route path="/admin" element={<Admin />}> </Route>
      <Route path="/" element={<Stories origin={StoryOrigin.api} service={new ApiStoryService()} />}> </Route>
    </Routes>
  </Router>
  // </React.StrictMode>
);

// If you want to start measuring performance in your app, pass a function
// to log results (for example: reportWebVitals(console.log))
// or send to an analytics endpoint. Learn more: https://bit.ly/CRA-vitals
reportWebVitals();
