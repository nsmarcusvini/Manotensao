import React, { useState } from 'react'
import { Header } from '../Header/Header'
import './Mano.css'
import back from '../../assets/fundo.mp4'
import { Link } from 'react-scroll'


export const Mano = () => {

  const [click, setClick] = useState(false)
  const closeMenu = () => setClick(false)
  
  return (
    <div className='mano' id='manos'>
        <Header />
      <div className="home">
        <div className="manoTexto">
          <div>
            <span className='tensao'>ManoTensao</span>
            <div className="title">
              <span className='titleSpan'>
                Precisando de uma mão?
              </span>
            </div>
            <div className="text">
              <span className='textSpan'>
                Suas dificuldades acabaram com a ManoTensão, <br />
                encontre já o melhor para você!
              </span>
            </div>
          </div>
        </div>
        <div className="conheca">

            <a className='butn butn1'><Link to="comment" spy={true} smooth={true} offset={-110} duration={500} onClick={closeMenu}>Conheça os nossos serviços</Link></a>

        </div>
      </div>
      <div className="black"></div>
      <video src={back} autoPlay loop muted />
    </div>
  )
}
