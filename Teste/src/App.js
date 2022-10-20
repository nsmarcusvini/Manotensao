import './App.css';
import { Comments } from './componets/Comments/Comments';
import { Mano } from './componets/Mano/Mano';
import { Meet } from './componets/Meet/Meet';
import { Plans } from './componets/Plans/Plans';
function App() {
  return (
    <div className="App">
      <Mano />
      <Meet />
      <Plans />
      <Comments />
    </div>
  );
}

export default App;
