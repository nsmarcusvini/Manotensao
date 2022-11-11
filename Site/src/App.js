import './App.css';
import { Comments } from './componets/Comments/Comments';
import { Footer } from './componets/Footer/Footer';
import { LogoInfo } from './componets/LogoInfo/LogoInfo';
import { Mano } from './componets/Mano/Mano';
import { Meet } from './componets/Meet/Meet';
import { Plans } from './componets/Plans/Plans';
import { Search } from './componets/Search/Search';
import { Rota } from './routes';

import SignUpForm from './componets/Cadastro/SignUpForm';


function App() {
  return (
    <div className="App">
      {/* <Rota /> */}
      <Mano />
      <Meet />
      <Plans />
      <Comments />
      <LogoInfo />
      <Footer />
     {/*  <SignUpForm/> */}
    </div>
  );
}

export default App;
