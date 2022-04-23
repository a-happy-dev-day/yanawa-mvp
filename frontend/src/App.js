import "./App.css";
import { Routes, Route } from "react-router-dom";
import HobbyChoice from "./pages/HobbyChoice";
import LevelCheck from "./pages/LevelCheck";
import LevelYear from "./pages/LevelYear.js";

function App() {
  return (
    <div>
      <Routes>
        <Route path='/hobbychoice' element={<HobbyChoice />} />
        <Route path='/levelyear' element={<LevelYear />} />
        <Route path='/levelcheck' element={<LevelCheck />} />
      </Routes>
    </div>
  );
}

export default App;
