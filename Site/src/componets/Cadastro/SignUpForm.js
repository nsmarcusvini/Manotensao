import React, { useState } from "react";
import alicate from '../../assets/muieeletrica.jpg';
import pint from '../../assets/encana.jpg';
import fblogo from '../../assets/fblogo.png';
import instagram from '../../assets/instagram1.png';
import google from '../../assets/google.png';
import useForm from './useForm';
import './SignUp.css';

const SignUpForm = ({ submitForm }) => {
  const { handleChange, handleFormSubmit, values, errors, validation } = useForm(submitForm);
  const [addclass, setaddclass] = useState("");

  const [tipo, setTipo] = useState("prestador");

  function onChangeValue(event) {
    setTipo(event.target.value);
    console.log(event.target.value);
  }


  function cadastrar(event) {
    event.preventDefault();

    const novoUsuario = {
      nome: event.target.nome.value,
      email: event.target.email.value,
      senha: event.target.senha.value,
      tipoUsuario: event.target.tipoUsuario.value,
    };

  }
  
  return (
    <>

      <div className="bodyForm">
        <div className={`containerForm ${addclass}`} id="containerForm">
          <div className="form-container sign-up-container">
            <form className="formCadastrar" action="#" onSubmit={cadastrar}>
              <h1 className="h1">Criar conta</h1>
              <div className="social-container">
                <img src={google} className="social" />
                <img src={fblogo} className="social" />
                <img src={instagram} className="social" />
              </div>
              <span className="span">or crie sua conta com email</span>
              <label className="label"></label>

              <label className="label">Nome</label>
              <input
                required
                className="input"
                type="text"
                name="nomecompleto"
                value={values.nomecompleto}
              />
              {errors.nomecompleto && <p className="error">{errors.nomecompleto}</p>}

              <label className="label">Email</label>
              <input
                required
                className="input"
                type="email"
                name="email"
                value={values.email}
              />
              {errors.email && <p className="error">{errors.email}</p>}

              <label className="label">Senha</label>
              <input
                required
                className="input"
                type="password"
                name="senha"
                value={values.senha}
              />
              {errors.senha && <p className="error">{errors.senha}</p>}

              <div className="tipoUsuario" onChange={onChangeValue}>
                <input
                  required
                  type="radio"
                  id="prestador"
                  name="tipo"
                  value="prestador"
                  checked={tipo === 'prestador'}
                />Sou prestador

                <input
                  required
                  type="radio"
                  id="cliente"
                  name="tipo"
                  value="cliente"
                  checked={tipo === 'cliente'} />Quero contratar
              </div>

              <button className="submit" type="submit">Continuar</button>
              <div className="a">
              </div>
            </form>

          </div>
          <div className="form-container sign-in-container">
            <form className="formLogin" action="#" /* onClick={login} */>
              <h1 className="h1">Entrar</h1>
              <div className="social-container">
                <img src={google} className="social" />
                <img src={fblogo} className="social" />
                <img src={instagram} className="social" />
              </div>
              <span className="span">ou use seu login</span>
              <label className="label">Email</label>
              <input
                required
                className="input"
                type="email"
                name="email"
                value={values.email}
              />
              {errors.email && <p className="error">{errors.email}</p>}

              <label className="label">Senha</label>
              <input
                required
                className="input"
                type="password"
                name="senha"
                value={values.senha}
              />
              {errors.senha && <p className="error">{errors.senha}</p>}

              <a className="esqueciSenha" href="#">Esqueci minha senha</a>
              <button className="submit" type="submit">Continuar</button>
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
        </div>
      </div>
    </>
  );
};

export default SignUpForm;