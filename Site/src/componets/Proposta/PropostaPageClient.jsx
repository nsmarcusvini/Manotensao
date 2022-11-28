import React from 'react';
import { useState } from 'react'
import './Proposta.css';
import arrow from '../../assets/arrow-foward.svg'
import man from '../../assets/man2.jpg';
import share from '../../assets/share-social-outline.svg';
import alert from '../../assets/alert-circle-outline.svg';
import { Footer } from '../Footer/Footer';
import { motion } from 'framer-motion'
import { DataReview } from './DataReview';
import { LikeButton } from '../Search/HeartLike';
import { useNavigate } from 'react-router-dom';

function PropostaPageClient() {

    const [selected, setSelected] = useState(0)
    const cLenght = DataReview.length

    const transition = { type: 'spring', duration: 3 }

    const navigate = useNavigate();


    return (

        <div className='bodyProposta'>

            <div className="main">

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

                <div className="containerPropostaClient">

                    <img className='picClient' src={man} />

                    <div className="rightClient">

                        <p className='nameClient'>João Oliveira</p>

                        <div className="tool_iconsClient">
                            <LikeButton />
                            <img src={share} />
                            <img src={alert} />
                        </div>
                        <button className='btnConversarClient'>Conversar com João</button>
                    </div>

                    <h3 className='reviewTitleClient'>Avaliações</h3>
                    <div className="reviewsClient">
                        <img className='arrowClient' src={arrow} alt="" onClick={() => {
                            selected === 0 ? setSelected(cLenght - 1) : setSelected((prev) => prev - 1)
                        }} />

                        <div className="baixo">
                            <motion.span

                                className='commentsTwoProposta'>
                                {DataReview[selected].name}
                            </motion.span>
                            <motion.span
                                // key={selected}
                                // initial={{ opacity: 0, x: 30 }}
                                // animate={{ opacity: 1, x: 0 }}
                                // exit={{ opacity: 0, x: -30 }}
                                // transition={transition}
                                className="commentsThreeProposta">
                                {DataReview[selected].status}
                            </motion.span>
                            <motion.span
                                key={selected}
                                initial={{ opacity: 0, x: 30 }}
                                animate={{ opacity: 1, x: 0 }}
                                exit={{ opacity: 0, x: -30 }}
                                transition={transition}
                                className='commentsOneProposta'>
                                {DataReview[selected].review}
                            </motion.span>
                        </div>
                        <motion.div
                            key={selected}
                            initial={{ opacity: 0, x: 30 }}
                            animate={{ opacity: 1, x: 0 }}
                            exit={{ opacity: 0, x: -30 }}
                            transition={transition}
                            className="iconBaixo">
                            <div
                                className="textoBaixo">
                                <span>
                                </span>
                            </div>
                        </motion.div>
                    </div>
                </div>
            </div>
            <Footer />
        </div>
    )

}
export default PropostaPageClient;