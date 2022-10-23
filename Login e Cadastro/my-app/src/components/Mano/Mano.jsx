import React from 'react'
import { Header } from '../Header/Header'
import './Mano.css'
import back from '../../assets/fundo.mp4'

export const Mano = () => {
  return (
    <div className='mano'>
      <div className="home">
        <Header />
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
          <span className="buttonA">
            <a href="#">Consulte nossos serviços</a>
          </span>
        </div>
      </div>
      <div className="black"></div>
      <video src={back} autoPlay loop muted />
    </div>
  )
}
