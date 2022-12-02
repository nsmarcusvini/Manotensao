import React from 'react'
import './PlansInfo.css'
import SetaPlan from '../../assets/setaPlans.png'
import Logo from '../../assets/Logo Construção E Reparos (2).png'
import Fatura from '../../assets/fatura.png'
import { useNavigate } from 'react-router-dom'
import Boleto from '../../assets/boletoBasic.pdf'
import { Formik, Form } from 'formik';
import { PlansValidate } from '../PlansInfoPro/PlansValidate'
import * as Yup from 'yup';

export const PlansInfo = () => {

  const validate = Yup.object({
    nameCard: Yup.string()
      .required('Necessário nome do cartão'),
    numeroCard: Yup.string()
      .max(16, 'São necessários 16 caracteres')
      .required('Necessário número do cartão'),
    email: Yup.string()
      .email('Email inválido')
      .required('Email é necessário'),
    cvc: Yup.string()
      .max(3, 'São necessários 3 caracteres')
      .required('CVC necessário'),
    dataCard: Yup.string()
      .max(5, 'São necessários 5 caracteres')
      .required('Data necessária'),
  })

  const navigate = useNavigate();

  return (
    <Formik
      initialValues={{
        nameCard: '',
        numeroCard: '',
        email: '',
        cvc: '',
        dataCard: ''
      }}
      validationSchema={validate}
      onSubmit={values => {
        console.log(values)
      }}
    >
      {formik => (
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
                  R$109,99
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
                <PlansValidate type="email" name="email" />
              </div>
              <div className="informationCard">
                <span className="payCard">Informações do cartão</span>
                <PlansValidate type="text" className="numberCard" placeholder='1234 1234 1234 1234' mask={"9999 9999 9999 9999"} name="numeroCard" />
                <div className="inputCard">
                  <PlansValidate type="text" className="dateCard" placeholder='MM/YY' maxLength={5} name="dataCard" />
                  <PlansValidate type="text" className="cvcCard" placeholder='CVC' maxLength={3} pattern="([0-9]{3}" name="cvc" />
                </div>
              </div>
              <div className="cardName">
                <span className="nameCard">Nome do cartão</span>
                <PlansValidate type="text" name="nameCard" />
              </div>
              <button type='submit' className="cardButton" onClick={() => navigate("/sucess")} id="btnPro">Pagar</button>
            </div>
          </div>
        </div>
      )}
    </Formik>
  )
}