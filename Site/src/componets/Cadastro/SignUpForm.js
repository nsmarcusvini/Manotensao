import React, { useState } from "react";
import alicate from '../../assets/muieeletrica.jpg';
import pint from '../../assets/encana.jpg';
import fblogo from '../../assets/fblogo.png';
import instagram from '../../assets/instagram1.png';
import google from '../../assets/google.png';
import useForm from './useForm';
import api from '../../axios.js';
import './SignUp.css';
import toast from "react-hot-toast";

const SignUpForm = ({ submitForm }) => {
  const { handleChange, handleFormSubmit, values, errors, validation } = useForm(submitForm);
  const [addclass, setaddclass] = useState("");

  const [tipo, setTipo] = useState("prestador");

  function onChangeValue(event) {
    setTipo(event.target.value);
    console.log(event.target.value);
  }

  function logar(event){
    event.preventDefault();
    var tipoUsuario = "cliente";
    var email = "limagabrielsilva11@gmail.com"
    var senha = "1234Lima"

    if(tipoUsuario == "prestador"){
      console.log("entrei no prestador");
      console.log(api);
      api
        .post(`/prestadores/autenticacao-prestador/${email}/${senha}`)
        .then((res) => {
          console.log(res);
          window.sessionStorage.setItem("user", JSON.stringify(res.data)); // JSON.parse(sessionStorage.user).nome
          window.location.href = 'http://localhost:3000/search';
        }).catch((err) => {
          console.log(err);
        })
    } else if(tipoUsuario == "cliente"){
      api
        .post(`/clientes/autenticacao-cliente/${email}/${senha}`)
        .then((res) => {
          console.log(res);
          window.sessionStorage.setItem("user", JSON.stringify(res.data)); // JSON.parse(sessionStorage.user).nome
          window.location.href = 'http://localhost:3000/search';
        }).catch((err) => {
          console.log(err);
        })
    }
    }

  function cadastrar(event) {
    event.preventDefault();
    var tipoUsuario = "prestador";

    const novoUsuario = {
      nome: "Gabriel",
      email: "limagabrielsilva11@gmail.com",
      senha: "1234LimaTeste1",
    };

    if(tipoUsuario == "prestador"){
      api
      .post(`/prestadores`, novoUsuario)
      .then((res) => {
        console.log(res);
        window.sessionStorage.setItem("user", JSON.stringify(res.data)); // JSON.parse(sessionStorage.user).nome
        window.location.href = 'http://localhost:3000/search';
      }).catch((err) => {
        console.log(err);
      })
    }else if(tipoUsuario == "cliente"){
      console.log(novoUsuario)
      console.log(api)
      api
      .post(`/clientes`, novoUsuario)
      .then((res) => {
        console.log(res);
        window.sessionStorage.setItem("user", JSON.stringify(res.data)); // JSON.parse(sessionStorage.user).nome
        window.location.href = 'http://localhost:3000/search';
      }).catch((err) => {
        console.log(err);
      });
  }
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
              />
              {errors.nomecompleto && <p className="error">{errors.nomecompleto}</p>}

              <label className="label">Email</label>
              <input
                required
                className="input"
                type="email"
                name="email"
              />
              {errors.email && <p className="error">{errors.email}</p>}

              <label className="label">Senha</label>
              <input
                required
                className="input"
                type="password"
                name="senha"
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
            <form className="formLogin" action="#" onSubmit={logar}>
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
              />
              {errors.email && <p className="error">{errors.email}</p>}

              <label className="label">Senha</label>
              <input
                required
                className="input"
                type="password"
                name="senha"
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