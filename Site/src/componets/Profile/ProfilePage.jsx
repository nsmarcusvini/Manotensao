import React, { useState } from 'react';
import { useForm } from 'react-hook-form';
import { useNavigate } from 'react-router-dom'
import './Profile.css';
import api from '../../axios.js';
//import Button from '@material-ui/core/Button';
import { MDBFile } from 'mdb-react-ui-kit';
import Uploader from './Uploader';

function ProfilePage() {

    const navigate = useNavigate();

    const { register, setValue, setFocus } = useForm();


    const hiddenFileInput = React.useRef(null);

    const handleChange = event => {
    };

    const handleClick = event => {
        hiddenFileInput.current.click();
    };


    const viaCep = (e) => {
        const cep = e.target.value.replace(/\D/g, '');
        console.log(cep);

        fetch(`https://viacep.com.br/ws/${cep}/json/`)
            .then(res => res.json()).then(data => {
                console.log(data);
                setValue('bairro', data.bairro);
                setValue('logradouro', data.logradouro);
                setFocus('numero');
            });
    }




    function atualizar(e) {

        e.preventDefault();

        const dados = {
            nome: e.target.elements.nome.value,
            cpf: e.target.elements.cpf.value,
            dtNascimento: e.target.elements.dtNascimento.value,
            email: e.target.elements.email.value,
            telefone: e.target.elements.celular.value,
            cep: e.target.elements.cep.value,
            bairro: e.target.elements.bairro.value,
            rua: e.target.elements.logradouro.value,
            numero: e.target.elements.numero.value,
            complemento: e.target.elements.complemento.value,
            senha: JSON.parse(sessionStorage.user).senha,
        }

        if(sessionStorage.tipoUsuario == "prestador"){
            api
            .put(`/prestadores/${JSON.parse(sessionStorage.user).id}`, dados)
            .then((res) => {
                console.log(res);
                window.sessionStorage.setItem("user", JSON.stringify(res.data));
                alert("Cadastro atualizado!")
            }).catch((err) => {
                console.log(err);
            })
        } else if(sessionStorage.tipoUsuario == "cliente"){
            api
            .put(`/clientes/${JSON.parse(sessionStorage.user).id}`, dados)
            .then((res) => {
                console.log(res);
                window.sessionStorage.setItem("user", JSON.stringify(res.data));
                alert("Cadastro atualizado!")
            }).catch((err) => {
                console.log(err);
            })
        }
        
        console.log(dados);

    }

    /*     function carregarPagina() {
            // = JSON.parse(sessionStorage.user).nome;
            // = JSON.parse(sessionStorage.user).cpf;
            // = JSON.parse(sessionStorage.user).dtNascimento;
            // = JSON.parse(sessionStorage.user).nome;
            // = JSON.parse(sessionStorage.user).nome;
            // = JSON.parse(sessionStorage.user).nome;
            // = JSON.parse(sessionStorage.user).nome;
            // = JSON.parse(sessionStorage.user).nome;
            // = JSON.parse(sessionStorage.user).nome;
            // = JSON.parse(sessionStorage.user).nome;
        } */

    return (

        <div className="body">
            <div className="container">
                <div className="con">
                    <h1 className='logoHeader'>ManoTensao</h1>
                    <ul className='menu'>
                        <a className="list" onClick={() => navigate("/home")}>Home</a>
                        <a className='list' onClick={() => navigate("/chat")}>Chat</a>
                        <a className='list' onClick={() => navigate("/search")}>Pesquisar</a>

                    </ul>
                </div>
            </div>
            <div className='containerProfile'>
                <div className='pic'>
                    <img src={JSON.parse(sessionStorage.user).urlFoto} />
                    <p>{JSON.parse(sessionStorage.user).nome}</p>
                    <span>{JSON.parse(sessionStorage.user).email}</span>
                    <input type="file"
                        accept="image/*"
                        style={{ display: 'none' }}
                        id="root"

                    />
                    <Uploader/>


                </div>
                <div className='menu-info'>
                    <div className="bodyPro" id="bodyPro" >
                        <h2 className='titleForm'>Configurar Perfil</h2>
                        <form className="formProfile" action='#' onSubmit={atualizar}>
                            <div className='personal_info'>
                                <label className="info_contato">Informações de contato</label>

                                <label>
                                    Nome
                                    <input required className="nome" type="text" name='nome' value={JSON.parse(sessionStorage.user).nome} />
                                </label>


                                <label>
                                    CPF
                                    <input required className="cpf" type="text" name='cpf' value={JSON.parse(sessionStorage.user).cpf} />
                                </label>

                                <label className='dtNasc'>
                                    Data de Nascimento
                                    <input required className="dtNascimento" type="date" name='dtNascimento' value={JSON.parse(sessionStorage.user).dtNascimento} />
                                </label>

                                <label>
                                    Email
                                    <input required className="email" type="email" name='email' value={JSON.parse(sessionStorage.user).email} />
                                </label>

                                <label>
                                    Celular
                                    <input required className="celular" type="text" name='celular' value={JSON.parse(sessionStorage.user).telefone} />
                                </label>
                            </div>

                            <div className="adress_info">
                                <label className="info_adress">Endereço</label>

                                <label>
                                    CEP
                                    <input required className="cep" type="text" {...register("cep")} onBlur={viaCep} name="cep" value={JSON.parse(sessionStorage.user).cep} />
                                </label>

                                <label>
                                    Bairro
                                    <input required className="bairro" {...register("bairro")} type="text" name='bairro' value={JSON.parse(sessionStorage.user).bairro} />
                                </label>

                                <label>
                                    Logradouro
                                    <input required className="logradouro" {...register("logradouro")} type="text" name='logradouro' value={JSON.parse(sessionStorage.user).rua} />
                                </label>

                                <label>
                                    Número
                                    <input required className="number" type="text" name='numero' value={JSON.parse(sessionStorage.user).numero} />
                                </label>

                                <label>
                                    Complemento
                                    <input required className="complemento" type="text" name='complemento' value={JSON.parse(sessionStorage.user).complemento} />
                                </label>
                            </div>


                            <button className="btnAtt" type="submit" id="animate.css"> Atualizar dados</button>



                            <button className='importTxt'>Importar carta de apresentação</button>

                        </form>
                    </div>

                </div>
            </div>
        </div >

    )
}


export default ProfilePage;