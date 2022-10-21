import './App.css';
import { Comments } from './componets/Comments/Comments';
import { Footer } from './componets/Footer/Footer';
import { LogoInfo } from './componets/LogoInfo/LogoInfo';
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
      <LogoInfo />
      <Footer />
    </div>
  );
}

export default App;
