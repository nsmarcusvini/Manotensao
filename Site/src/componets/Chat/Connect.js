import "./Chat.css";
import io from "socket.io-client";
import { useState } from "react";
import ChatPage from "./ChatPage";
import { useNavigate } from "react-router-dom";
import { Footer } from "../Footer/Footer";

const socket = io.connect("http://3-215-198-136:3001");

function Connect() {
  const navigate = useNavigate();

  const [username, setUsername] = useState("");
  const [room, setRoom] = useState("");
  const [showChat, setShowChat] = useState(false);

  const joinRoom = () => {
    if (username !== "" && room !== "") {
      socket.emit("join_room", room);
      setShowChat(true);
    }
  };

  return (


    <div className="Connect">

      <div className="container">
        <div className="con">
          <h1 className='logoHeader'>ManoTensao</h1>
          <ul className='menu'>
            <a className="list" onClick={() => navigate("/home")}>Home</a>
            <a className='list' onClick={() => navigate("/chat")}>Chat</a>
            <a className='list' onClick={() => navigate("/search")}>Pesquisar</a>
          </ul>
        </div>
      </div>

      {/*  {!showChat ? (
        <div className="joinChatContainer">
          <h3>Join A Chat</h3>
          <input
            type="text"
            placeholder="John..."
            onChange={(event) => {
              setUsername(event.target.value);
            }}
          />
          <input
            type="text"
            placeholder="Room ID..."
            onChange={(event) => {
              setRoom(event.target.value);
            }}
          />
          <button onClick={joinRoom}>Join A Room</button>
        </div> 
      ) : (
        )} */}

      <ChatPage socket={socket} username={username} room={room} />

      <Footer/>
    </div>
  );
}

export default Connect;
