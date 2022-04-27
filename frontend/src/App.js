
// import logo from './logo.svg';
import './App.css';
import { Container } from 'react-bootstrap';
import { Route, Routes } from 'react-router-dom';
import { Reset } from "styled-reset";
import Header from './components/Header';
import Footer from './components/Footer';
import SaveForm from './pages/match/SaveForm';
import MyPage from './pages/user/MyPage';
import Main from './pages/match/Main';
import Detail from './pages/match/Detail';
import Chatting from './pages/chat/Chatting';
import AlarmMessage from './pages/alarm/AlarmMessage';
import UpdateForm from './pages/match/UpdateForm';
import HobbyChoicePage from "./pages/HobbyChoicePage.js";
import LevelCheckPage from "./pages/LevelCheckPage.js";
import LevelYearPage from "./pages/LevelYearPage.js";
import LevelResultPage from "./pages/LevelResultPage.js";
import SplashPage from "./pages/SplashPage.js";
import LoginPage from "./pages/LoginPage";
import RegisterPage from "./pages/RegisterPage";


function App() {
  return (
    <div>

      <Header></Header>
      <Container>
      <Reset />
        <Routes>
          <Route path="/" element={<Main />} />
          <Route path="/saveForm" element={<SaveForm />} />
          <Route path="/api/matching/:id" element={<Detail />} />
          <Route path="/updateForm/:id" element={<UpdateForm />} />
          <Route path="/alarm" element={<AlarmMessage />} />
          <Route path="/chatting" element={<Chatting />} />
          <Route path="/myPage" element={<MyPage />} />
          {/*           회원 > 가입 , 로그인 관련 페이지
          <Route path="/loginForm" element={'<LoginForm />'} />
          <Route path="/joinForm" element={'<JoinForm />'} /> */}
          <Route path='/' element={<SplashPage />} />
          <Route path='/login' element={<LoginPage />} />
          <Route path='/hobbychoice' element={<HobbyChoicePage />} />
          <Route path='/levelyear' element={<LevelYearPage />} />
          <Route path='/levelcheck' element={<LevelCheckPage />} />
          <Route path='/levelresult' element={<LevelResultPage />} />
          <Route path='/register' element={<RegisterPage />} />
        </Routes>
      </Container>
      <Footer></Footer>

    </div>
  );
}

export default App;
