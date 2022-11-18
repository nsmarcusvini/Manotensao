import React from 'react';
import { useState } from 'react'
import './Proposta.css';
import SideNavBar from '../SideNavBar/SideNavBar';
import notification from '../../assets/notifications.svg'
import arrow from '../../assets/arrow-foward.svg'
import woman from '../../assets/woman.jpg';
import heart from '../../assets/heart-outline.svg';
import share from '../../assets/share-social-outline.svg';
import alert from '../../assets/alert-circle-outline.svg';
import { Footer } from '../Footer/Footer';
import woman2 from '../../assets/woman2.jpeg'
import { motion } from 'framer-motion'
import { DataReview } from './DataReview';

function Proposta() {

    const [selected, setSelected] = useState(0)
    const cLenght = DataReview.length

    const transition = { type: 'spring', duration: 3 }



    return (

        <div className='body'>

            <div className="main">

                {/* <SideNavBar /> */}

                <div className='header'>
                    <span className='title'>ManoTensao</span>
                    <img className='noti' src={notification} />
                    <img className='user' src={woman2} />
                </div>


                <div className="containerProposta">

                    <img className='pic' src={woman} />

                    <div className="right">

                        <p className='name'>Maria Silva</p>

                        <div className="tool_icons">
                            <img src={heart} alt="" />
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

                    <div className="makeAReview">
                        <h4 className='makeAReviewTitle'>Você contratou este prestador em (data). Deixe aqui sua avaliação</h4>
                        
                        <label className='labelReview' id='rate'>Nota: </label>
                        <input type="number" min="1" max="5" className='newRate'></input>
                        
                        <label className='labelReview' id='reviewText'>Sua avaliação: </label>
                        <input className='newReview'></input>

                        <button className='submitReview'>Enviar</button>
                    </div>


                </div>
            </div>
        </div>







    )

}
export default Proposta;