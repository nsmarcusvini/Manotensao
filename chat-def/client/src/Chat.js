import React, { useEffect, useState } from "react";
import homi from '../src/assets/homi.webp';


function Chat({ socket, username, room }) {
    const [currentMessage, setCurrentMessage] = useState("");
    const [messageList, setMessageList] = useState([]);

    const sendMessage = async () => {
        if (currentMessage !== "") {
            const messageData = {
                room: room,
                author: username,
                message: currentMessage,
                time:
                    new Date(Date.now()).getHours() +
                    ":" +
                    new Date(Date.now()).getMinutes(),
            };

            await socket.emit("send_message", messageData);
            setMessageList((list) => [...list, messageData]);
            setCurrentMessage("");
        }
    };

    useEffect(() => {
        socket.on("receive_message", (data) => {
            setMessageList((list) => [...list, data]);
        });
    }, [socket]);

    return (
        <>

            <div className="container">
                <div className="chat-window">
                    <img src="" />
                    <div className="left">
                        <div className="searchbar">
                            <h2 className="title-search">Conversas</h2>
                            <input className="ipt-search" placeholder="Search..."></input>
                        </div>
                        <div className="chat1">
                            <img src={homi}></img>
                            <p className="name1">João</p>
                            <p className="text1">A blu ble bluble</p>
                            <div class="timer">12 sec</div>
                        </div>
                    </div>


                    <div className="right">
                        <div className="chat-header">
                            <p>Conversa com {username}</p>
                            <button className="proposta">Editar proposta</button>
                        </div>
                        <div className="chat-body">
                            <div className="message-container">
                                {messageList.map((messageContent) => {
                                    return (
                                        <div
                                            className="message"
                                            id={username === messageContent.author ? "you" : "other"}
                                        >
                                            <div>
                                                <div className="message-content">
                                                    <p>{messageContent.message}</p>
                                                </div>
                                                <div className="message-meta">
                                                    <p id="time">{messageContent.time}</p>
                                                    <p id="author">{messageContent.author}</p>
                                                </div>
                                            </div>
                                        </div>
                                    );
                                })}
                            </div>
                        </div>

                        <div className="chat-footer">
        <input
          type="text"
          value={currentMessage}
          placeholder="Hey..."
          onChange={(event) => {
            setCurrentMessage(event.target.value);
          }}
          onKeyPress={(event) => {
            event.key === "Enter" && sendMessage();
          }}
        />
        <button onClick={sendMessage}></button>
      </div>




                        {/*                     <div className="right">
                        <div className="header-chat">
                            <h2>Chat com {username}</h2>
                            <button className="proposta">Editar proposta</button>
                        </div>
                        <div className="messages-chat">
                            {messageList.map((messageContent) => {
                                return (
                                    <div
                                        className="message"
                                        id={username === messageContent.author ? "you" : "other"}
                                    >
                                        <div>
                                            <div className="message-content">
                                                <p>{messageContent.message}</p>
                                            </div>
                                            <div className="message-meta">
                                                <p id="time">{messageContent.time}</p>
                                                <p id="author">{messageContent.author}</p>
                                            </div>
                                        </div>
                                    </div>
                                );
                            })}

                            <div className="chat-footer">
                                <input
                                    type="text"
                                    value={currentMessage}
                                    placeholder="Digite sua mensagem"
                                    onChange={(event) => {
                                        setCurrentMessage(event.target.value);
                                    }}
                                    onKeyPress={(event) => {
                                        event.key === "Enter" && sendMessage();
                                    }} />
                                <button onClick={sendMessage}></button>
                            </div>
                        </div>
                    </div>

 */}</div>
                </div>

            </div>

        </>
    );
}

export default Chat;
