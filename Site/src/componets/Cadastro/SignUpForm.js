import React, { useState } from "react";
import alicate from '../../assets/ali.png';
import pint from '../../assets/pint.png';
import fblogo from '../../assets/fblogo.png';
import instagram from '../../assets/instagram1.png';
import google from '../../assets/google.png';
import useForm from './useForm';
import '../Cadastro/SignUp.css';


const SignUpForm = ({ submitForm }) => {
  const { handleChange, handleFormSubmit, values, errors, validation } = useForm(submitForm);
  const [addclass, setaddclass] = useState("");  

  const [tipo, setTipo] = useState("prestador");

  function onChangeValue(event) {
    setTipo(event.target.value);
    console.log(event.target.value);
  }


  return (
    <>
      <div className={`container ${addclass} ${styles.signUp}`} id="container" >
        <div className="form-container sign-up-container">
          <form action="#">
            <h1>Criar conta</h1>
            <div className="social-container">
              <img src={google} className="social" />
              <img src={fblogo} className="social" />
              <img src={instagram} className="social" />
            </div>
            <span>or crie sua conta com email</span>
            <label className="label"></label>

            <label className="label">Nome</label>
            <input
              className="input"
              type="text"
              name="nomecompleto"
              value={values.nomecompleto}
              onChange={handleChange} />
            {errors.nomecompleto && <p className="error">{errors.nomecompleto}</p>}

            <label className="label">Email</label>
            <input
              className="input"
              type="email"
              name="email"
              value={values.email}
              onChange={handleChange} />
            {errors.email && <p className="error">{errors.email}</p>}

            <label className="label">Senha</label>
            <input
              className="input"
              type="password"
              name="senha"
              value={values.senha}
              onChange={handleChange} />
            {errors.senha && <p className="error">{errors.senha}</p>}

            <div className="tipoUsuario" onChange={onChangeValue}>
              <input 
              type="radio" 
              id="prestador" 
              name="tipo" 
              value="prestador" 
              checked={tipo === 'prestador'} 
             />Sou prestador

              <input 
              type="radio" 
              id="cliente" 
              name="tipo" 
              value="cliente" 
              checked={tipo === 'cliente'} />Quero contratar
            </div>

            <button className="submit" onClick={handleFormSubmit}>Continuar</button>
            <div className="a">
            </div>
          </form>

        </div>
        <div className="form-container sign-in-container">
          <form action="#">
            <h1>Entrar</h1>
            <div className="social-container">
              <img src={google} className="social" />
              <img src={fblogo} className="social" />
              <img src={instagram} className="social" />
            </div>
            <span>ou use seu login</span>
            <label className="label">Email</label>
            <input
              className="input"
              type="email"
              name="email"
              value={values.email}
              onChange={handleChange} />
            {errors.email && <p className="error">{errors.email}</p>}

            <label className="label">Senha</label>
            <input
              className="input"
              type="password"
              name="senha"
              value={values.senha}
              onChange={handleChange} />
            {errors.senha && <p className="error">{errors.senha}</p>}

            <a href="#">Esqueci minha senha</a>
            <button className="submit" onClick={handleFormSubmit}>Continuar</button>
            <div className="a">
            </div>
          </form>
        </div>

        <div className="overlay-container">
          <div className="overlay">
            <div className="overlay-panel overlay-left">
              <img className="pintora" src={pint} alt="pintora" />
              <button className="ghost" id="signIn" onClick={() => setaddclass()}>Já tenho conta</button>
            </div>

            <div className="overlay-panel overlay-right">
              <div className="imagem">
                <img className="alicate" src={alicate} alt="pintora" />
              </div>
              <button className="ghost" id="signUp" onClick={() => setaddclass("right-panel-active")}>Cadastre-se</button>
            </div>
          </div>
        </div>
      </div></>
  );
};

export default SignUpForm;