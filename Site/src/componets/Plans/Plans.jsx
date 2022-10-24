import React from 'react'
import './Plans.css'
import basicIcon from '../../assets/chave-de-boca-verde2.svg'
import premiumIcon from '../../assets/crown2.svg'
import proIcon from '../../assets/tool-verde2.svg'
import check from '../../assets/whiteTick.png'

export const Plans = () => {
  return (
    <div className='plans' id='plan'>
      <div className="plansTitle" style={{ gap: '2rem' }}>
        <span className='plansTitle'>Venha trabalhar conosco</span>
      </div>
      <div className="plansCard">
        <div className="basic">
          <img src={basicIcon} alt="" />
          <span className="titlePlan">
            PLANO BÁSICO
          </span>
          <span className="price">
            R$100<span className='year'>/ano</span>
          </span>
          <div className="informations">
            <div className="checks">
              <img src={check} alt="" />
              <img src={check} alt="" />
            </div>
            <div className="infos">
              <span className="info">Envie mensagens sem cobrança</span>
              <span className="info">Obtenha nosso template de orçamento</span>
            </div>
          </div>
          <button className="btn">Junte-se</button>
        </div>
        <div className="premium">
          <img src={premiumIcon} alt="" />
          <span className="titlePlan">
            PLANO PREMIUM
          </span>
          <span className="price">
            R$300<span className='year'>/ano</span>
          </span>
          <div className="informations">
            <div className="checks">
              <img src={check} alt="" />
              <img src={check} alt="" />
              <img src={check} alt="" />
            </div>
            <div className="infos">
              <span className="info">Envie mensagens sem cobrança</span>
              <span className="info">Obtenha nosso template de orçamento</span>
              <span className="info">Obtenha nosso template de orçamento</span>
            </div>
          </div>
          <button className="btn">Junte-se</button>
        </div>
        <div className="pro">
          <img src={proIcon} alt="" />
          <span className="titlePlan">
            PLANO PRO
          </span>
          <span className="price">
            R$260<span className='year'>/ano</span>
          </span>
          <div className="informations">
            <div className="checks">
              <img src={check} alt="" />
              <img src={check} alt="" />
            </div>
            <div className="infos">
              <span className="info">Envie mensagens sem cobrança</span>
              <span className="info">Obtenha nosso template de orçamento</span>
            </div>
          </div>
          <button className="btn">Junte-se</button>
        </div>
      </div>
    </div>
  )
}
