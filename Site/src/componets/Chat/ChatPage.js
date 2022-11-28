import React, { useEffect, useState } from "react";
import homi from '../../assets/man2.jpg';
import { Modal, ModalHeader, ModalBody } from "reactstrap";
import { Row, Col } from "reactstrap";
import { useNavigate } from 'react-router-dom'


function ChatPage({ socket, username, room }) {
    const [currentMessage, setCurrentMessage] = useState("");
    const [messageList, setMessageList] = useState([]);

    const navigate = useNavigate();


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


    const [isDoneOpen, setDoneIsOpen] = useState(false);
    const togglePopUpDone = (e) => {

        const dados = {
            tipoServico: e.target.elements.campo1.value,
            descServico: e.target.elements.campo2.value,
            data: e.target.elements.campo3.value,
        }

        if(dados.tipoServico != null || dados.descServico != null || dados.data != null) {
            setDoneIsOpen(!isDoneOpen);
        }

    }


    const [modal, setModal] = useState(false);
    const togglePopUp = () => {
        setModal(!modal);
    }


    return (
        <>

            <div className="containerChat">
                <div className="chat-window">
                    <img src="" />
                    <div className="leftChat">
                        <div className="searchbar">
                            <h2 className="title-search">Conversas</h2>
                            <input className="ipt-search" placeholder="Search..."></input>
                        </div>
                        <div className="chat1">
                            <img className="imgChat" src={homi}></img>
                            <p className="name1">João</p>
                            <p className="text1">A blu ble bluble</p>
                            <div class="timer">12 sec</div>
                        </div>
                    </div>


                    <div className="rightChat">
                        <div className="chat-header">
                            <p className="cvCom">Conversa com {username}</p>
                            <button className="proposta" onClick={togglePopUp}>Editar proposta</button>
                            <button className="verPerfil" onClick={() => navigate("/profile")}>Ver Perfil</button>
                        </div>


                        <div >
                            <Modal
                                size="lg"
                                isOpen={modal}
                                toggle={() => setModal(!modal)}>
                                <ModalHeader
                                    /* togglePopUp={() => setModal(!modal)} */>

                                </ModalHeader>
                                <div className="modal">
                                    <ModalBody>
                                        <form className="formModal">
                                            <h2 className="titleFazerProposta">Fazer uma proposta</h2>
                                            <Row>
                                                <Col lg={12}>
                                                    <div className="campo1">
                                                        <label className='tipoDoServico'>
                                                            Tipo serviço
                                                        </label>
                                                        <select required className="selectServicos">
                                                            <option value="">Selecione...</option>
                                                            <option value="pintura">Pintura</option>
                                                            <option value="eletrica">Elétrica</option>
                                                            <option value="hidraulica">Hidráulica</option>
                                                        </select>
                                                    </div>
                                                </Col>

                                                <Col lg={12}>
                                                    <div className="campo2">
                                                        <label className="descDoServ">Descrição do serviço </label>
                                                        <textarea required className="descDoServico"></textarea>
                                                    </div>
                                                </Col>

                                                <Col lg={12}>
                                                    <div className="campo3">
                                                        <label className="de">De</label>
                                                        <input required type="date" className="dataDe"></input>
                                                        <label className="ate">Até</label>
                                                        <input required type="date" className="dataAte"></input>
                                                    </div>
                                                </Col>
                                                <Col lg={12}>
                                                    <div className="campo4">
                                                        <label className="termos">Estou ciente e aceito os termos e condições </label>
                                                        <input required className="checkbox" type="checkbox"></input>
                                                    </div>
                                                </Col>
                                            </Row>
                                            <button className="enviarProposta" onClick={togglePopUpDone}>Gerar proposta</button>
                                        </form>
                                    </ModalBody>
                                </div>
                            </Modal>
                        </div>

                        <Modal
                            size="lg"
                            isOpen={isDoneOpen}
                            toggle={() => setDoneIsOpen(!isDoneOpen)}>

                            <ModalBody>
                                <h2 className="concluido">Sua proposta foi enviada!</h2>
                            </ModalBody>
                        </Modal>

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
                                className="iptFooter"
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
                            <button className="btnSendMessage" onClick={sendMessage}></button>
                        </div>
                    </div>
                </div>
            </div>

        </>
    );
}



export default ChatPage;
