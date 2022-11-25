import React, { useState, useEffect } from 'react';
import { BsBagCheckFill } from 'react-icons/bs';
import { RiInstagramFill } from 'react-icons/ri'
import { BsLinkedin } from 'react-icons/bs'
import { runFireworks } from './Confetti';
import { useNavigate } from 'react-router-dom'
import './Sucess.css'

export const Sucess = () => {

    const navigate = useNavigate();

    useEffect(() => {
        runFireworks();
    }, []);

    return (
        <div className='sucessAll'>
            <div className="sucess">
                <div className="boxSucess">
                    <BsBagCheckFill />
                    <h2 className="thanks">Obrigado por se juntar a  <span className="manoThanks"> ManoTensão</span></h2>
                    <span className="verify">Verifique seu e-mail</span>
                    <p className="question">Se houver qualquer duvida, por favor entre em contato <span className="emailThanks">centralduvidas@manotensao.com</span></p>
                    <button className="voltaThanks" onClick={() => navigate("/")}>Voltar</button>
                </div>
            </div>
            <div className="direct">
                <span className="direction">2022 ManoTensão todos os direitos autorizados</span>
                <div className="iconsMidia">
                    <h3><RiInstagramFill /></h3>
                    <h3><BsLinkedin /> </h3>
                </div>
            </div>
        </div>
    )
}
