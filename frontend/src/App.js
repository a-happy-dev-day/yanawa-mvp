import "./App.css";
import { Routes, Route } from "react-router-dom";
import { Reset } from "styled-reset";

import HobbyChoice from "./pages/HobbyChoice";
import LevelCheck from "./pages/LevelCheck";
import LevelYear from "./pages/LevelYear.js";
import LevelResult from "./pages/LevelResult";
import Splash from "./pages/Splash";

function App() {
  return (
    <div>
      <Reset />
      <Routes>
        <Route path='/' element={<Splash />} />
        <Route path='/hobbychoice' element={<HobbyChoice />} />
        <Route path='/levelyear' element={<LevelYear />} />
        <Route path='/levelcheck' element={<LevelCheck />} />
        <Route path='/levelresult' element={<LevelResult />} />
      </Routes>
    </div>
  );
}

export default App;
