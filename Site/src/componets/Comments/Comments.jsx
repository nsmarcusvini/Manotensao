import React, { useState } from 'react'
import './Comments.css'
import setaDireita from '../../assets/seta.png'
import setaEsquerda from '../../assets/seta-esquerda.png'
import { CommentsData } from './CommentsData'
import { motion } from 'framer-motion'

export const Comments = () => {
    const [selected, setSelected] = useState(0)
    const cLenght = CommentsData.length

    const transition = { type: 'spring', duration: 3 }

    return (
        <div className='comments' id='comment'>
            <div className="blur come-blur"></div>
            <div className="commentsTitle">
                <span className='titleCom'>
                    Você está em boa companhia
                </span>
                <span className="textCom">
                    Nossos profissionais e clientes possuem as melhores avaliações e comentários. Acompanhe
                </span>
            </div>
            <div className="cima">
                <div className="arrow">
                    <img
                        onClick={() => {
                            selected === 0 ? setSelected(cLenght - 1) : setSelected((prev) => prev - 1)
                        }}
                        src={setaEsquerda} alt="" />
                </div>
                <motion.img
                    key={selected}
                    initial={{ opacity: 0, x: 30 }}
                    animate={{ opacity: 1, x: 0 }}
                    exit={{ opacity: 0, x: -30 }}
                    transition={transition}
                    src={CommentsData[selected].image} alt="" />
                <div className="arrow">
                    <img
                        onClick={() => {
                            selected === cLenght - 1 ? setSelected(0) : setSelected((prev) => prev + 1)
                        }}

                        src={setaDireita} alt="" />
                </div>
            </div>
            <div className="baixo">
                <motion.span

                    className='commentsTwo'>
                    {CommentsData[selected].name}
                </motion.span>
                <motion.span
                    // key={selected}
                    // initial={{ opacity: 0, x: 30 }}
                    // animate={{ opacity: 1, x: 0 }}
                    // exit={{ opacity: 0, x: -30 }}
                    // transition={transition}
                    className="commentsThree">
                    {CommentsData[selected].status}
                </motion.span>
                <motion.span
                    key={selected}
                    initial={{ opacity: 0, x: 30 }}
                    animate={{ opacity: 1, x: 0 }}
                    exit={{ opacity: 0, x: -30 }}
                    transition={transition}
                    className='commentsOne'>
                    {CommentsData[selected].review}
                </motion.span>
            </div>
            <motion.div
                key={selected}
                initial={{ opacity: 0, x: 30 }}
                animate={{ opacity: 1, x: 0 }}
                exit={{ opacity: 0, x: -30 }}
                transition={transition}
                className="iconBaixo">
                <div className="imageBaixo">
                    <img src={CommentsData[selected].image2} alt="" />
                    <span>
                        {CommentsData[selected].status2}
                    </span>
                </div>
                <div
                    className="textoBaixo">
                    <img src={CommentsData[selected].image3} alt="" />
                    <span>
                        {CommentsData[selected].status3}
                    </span>
                </div>
            </motion.div>
        </div>
    )
}
