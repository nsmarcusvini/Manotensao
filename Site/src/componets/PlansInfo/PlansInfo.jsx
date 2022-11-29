import React from 'react'
import './PlansInfo.css'
import SetaPlan from '../../assets/setaPlans.png'
import Logo from '../../assets/Logo Construção E Reparos (2).png'
import Fatura from '../../assets/fatura.png'
import ReactInputMask from 'react-input-mask'
import { useNavigate } from 'react-router-dom'
import Boleto from '../../assets/boletoBasic.pdf'

export const PlansInfo = () => {

  const navigate = useNavigate();

  return (
    <div className='plansInfoAll'>
      <div className="plansInfo">
        <div className="product">
          <div className="backPlan">
            <img src={SetaPlan} alt="" onClick={() => navigate("/home")} />
            <img src={Logo} alt="" />
          </div>
          <div className="informationPlan">
            <span className="nameProdutuc">
              Plano BASIC
            </span>
            <span className="sale">
              R$29,99
            </span>
          </div>
          <div className="power">
            <span className="powerBy">Power by </span>
            <span className="by">ManoTensao</span>
          </div>
        </div>
        <div className="payments">
          <div className="boleto">
            <a href={Boleto} download className='bolDown'>
              <div className="bolButton">
                <img src={Fatura} alt="" />
                <span className="boletoButton">Boleto</span>
              </div>
            </a>
          </div>
          <span className="or">──────────────── Ou pague com o cartão ────────────────</span>
          <div className="cardEmail">
            <span className="payEmail">E-mail</span>
            <input type="text" />
          </div>
          <div className="informationCard">
            <span className="payCard">Informações do cartão</span>
            <ReactInputMask type="text" className="numberCard" placeholder='1234 1234 1234 1234' mask={"9999 9999 9999 9999"} />
            <div className="inputCard">
              <input type="text" className="dateCard" placeholder='MM/YY' maxLength={5} />
              <input type="text" className="cvcCard" placeholder='CVC' maxLength={3} pattern="([0-9]{3}" />
            </div>
          </div>
          <div className="cardName">
            <span className="nameCard">Nome do cartão</span>
            <input type="text" />
          </div>
          <button className="cardButton" onClick={() => navigate("/sucess")} id="btnInfo">Pagar</button>
        </div>
      </div>
    </div>
  )
}