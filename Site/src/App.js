import './App.css';
import { Comments } from './componets/Comments/Comments';
import { Footer } from './componets/Footer/Footer';
import { LogoInfo } from './componets/LogoInfo/LogoInfo';
import { Mano } from './componets/Mano/Mano';
import { Meet } from './componets/Meet/Meet';
import { Plans } from './componets/Plans/Plans';
import { Rota } from './routes';
import Chat from './componets/Chat/Chat';
import Proposta from './componets/Proposta/Proposta';
import SignUpForm from './componets/Cadastro/SignUpForm';
import ProfilePage from './componets/Profile/ProfilePage';
import SideNavBar from './componets/SideNavBar/SideNavBar';
import Connect from './componets/Chat/Connect';


function App() {
  return (
    <div className="App">
      <Rota />
       {/* <Mano />
      <Meet />
      <Plans />
      <Comments />
      <LogoInfo />
      <Footer />
      <Rota /> */}
      {/*  <SignUpForm/> */}
      {/* <ProfilePage />
      <SideNavBar/> */}
      {/* <Proposta/> */}
      {/* <Chat/> */}
      {/* <Connect/> */}
    </div>
  );
}

export default App;
