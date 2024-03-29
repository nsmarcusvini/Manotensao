import React from 'react';
import { useState } from 'react'
import './Proposta.css';
import arrow from '../../assets/arrow-foward.svg'
import woman from '../../assets/woman.jpg';
import share from '../../assets/share-social-outline.svg';
import alert from '../../assets/alert-circle-outline.svg';
import { Footer } from '../Footer/Footer';
import { motion } from 'framer-motion'
import { DataReview } from './DataReview';
import { LikeButton } from '../Search/HeartLike';
import { useNavigate } from 'react-router-dom';

function Proposta() {

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

                <div className="containerProposta">

                    <img className='pic' src={woman} />

                    <div className="right">

                        <p className='name'>Maria Silva</p>

                        <div className="tool_icons">
                            <LikeButton />
                            <img src={share} />
                            <img src={alert} />
                        </div>
                        <button className='btnFazerProposta'>Fazer uma proposta</button>
                        <button className='btnConversar'>Conversar com Maria</button>

                        <div className="desc_prestador">
                            <p className='desc'>Lorem, ipsum dolor sit amet consectetur adipisicing elit. Ipsam, animi repellat possimus maiores commodi atque? Debitis laudantium explicabo, aliquam tempore, fugit voluptates</p>
                        </div>
                        <div className="info_valor">
                            <span className='valor'>R$ 90</span>
                            <span className='desc_valor'>por diária</span>
                        </div>
                        <div className="disponivel"></div>
                    </div>

                    <h3 className='reviewTitle'>Avaliações</h3>
                    <div className="reviews">
                        <img className='arrow' src={arrow} alt="" onClick={() => {
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
export default Proposta;