// import logo from './logo.svg';
import "./App.css";
import { Route, Routes } from "react-router-dom";
import { Reset } from "styled-reset";
import SaveForm from "./pages/match/SaveForm";
import MyPage from "./pages/user/MyPage";
import Main from "./pages/match/Main";
import Detail from "./pages/match/Detail";
import Chatting from "./pages/chat/Chatting";
import AlarmMessage from "./pages/alarm/AlarmMessage";
import UpdateForm from "./pages/match/UpdateForm";
import HobbyChoicePage from "./pages/HobbyChoicePage.js";
import LevelCheckPage from "./pages/LevelCheckPage.js";
import LevelYearPage from "./pages/LevelYearPage.js";
import LevelResultPage from "./pages/LevelResultPage.js";
import SplashPage from "./pages/SplashPage.js";
import LoginPage from "./pages/LoginPage";
import RegisterPage from "./pages/RegisterPage";
import Layout from "./components/Layout";

function App() {
  return (
    <div>
      <Reset />
      <Routes>
        <Route element={<Layout />}>
          <Route path='/main' element={<Main />} />
          <Route path='/saveForm' element={<SaveForm />} />
          <Route path='/api/matching/:id' element={<Detail />} />
          <Route path='/updateForm/:id' element={<UpdateForm />} />
          <Route path='/alarm' element={<AlarmMessage />} />
          <Route path='/chatting' element={<Chatting />} />
          <Route path='/myPage' element={<MyPage />} />
        </Route>
        <Route path='/' element={<SplashPage />} />
        <Route path='/login' element={<LoginPage />} />
        <Route path='/hobbychoice' element={<HobbyChoicePage />} />
        <Route path='/levelyear' element={<LevelYearPage />} />
        <Route path='/levelcheck' element={<LevelCheckPage />} />
        <Route path='/levelresult' element={<LevelResultPage />} />
        <Route path='/register' element={<RegisterPage />} />
      </Routes>
    </div>
  );
}

export default App;
