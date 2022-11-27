import React, { useState } from 'react';
import notification from '../../assets/notifications.svg';
import homi from '../../assets/man.jpg';
import { useForm } from 'react-hook-form';
import { useNavigate } from 'react-router-dom'
import './Profile.css';

function ProfilePage() {

    const navigate = useNavigate();

    const { register, handleSubmit, setValue, setFocus } = useForm();

    const onSubmit = (e) => {
        console.log(e);
    }

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
        sobrenome: e.target.elements.sobrenome.value,
        cpf: e.target.elements.cpf.value,
        dtNascimento: e.target.elements.dtNascimento.value,
        email: e.target.elements.email.value,
        celular: e.target.elements.celular.value,
    
        cep: e.target.elements.cep.value,
        bairro: e.target.elements.bairro.value,
        logradouro: e.target.elements.logradouro.value,
        numero: e.target.elements.numero.value,
        complemento: e.target.elements.complemento.value
    }

    console.log(dados);

    }



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
                    <img src={homi} />
                    <p>Fulano da Silva</p>
                    <span>email@email.com</span>
                    <button>Escolher foto</button>
                </div>
                <div className='menu-info'>
                    <div className="bodyPro" id="bodyPro" >
                        <h2 className='titleForm'>Configurar Perfil</h2>
                        <form className="formProfile" action='#' onSubmit={atualizar}>
                            <div className='personal_info'>
                                <label className="info_contato">Informações de contato</label>

                                <label>
                                    Nome
                                    <input required className="nome" type="text" name='nome' />
                                </label>

                                <label>
                                    Sobrenome
                                    <input required className="sobrenome" type="text" name='sobrenome' />
                                </label>

                                <label>
                                    CPF
                                    <input required className="cpf" type="text" name='cpf'/>
                                </label>

                                <label className='dtNasc'>
                                    Data de Nascimento
                                    <input required className="dtNascimento" type="date" name='dtNascimento' />
                                </label>

                                <label>
                                    Email
                                    <input required className="email" type="email" name='email' />
                                </label>

                                <label>
                                    Celular
                                    <input required className="celular" type="text" name='celular' />
                                </label>
                            </div>

                            <div className="adress_info">
                                <label className="info_adress">Endereço</label>

                                <label>
                                    CEP
                                    <input required className="cep" type="text" {...register("cep")} onBlur={viaCep} name="cep" />
                                </label>

                                <label>
                                    Bairro
                                    <input required className="bairro" {...register("bairro")} type="text" name='bairro'/>
                                </label>

                                <label>
                                    Logradouro
                                    <input required className="logradouro" {...register("logradouro")} type="text" name='logradouro'/>
                                </label>

                                <label>
                                    Número
                                    <input required className="number" type="text" name='numero'/>
                                </label>

                                <label>
                                    Complemento
                                    <input required className="complemento" type="text" name='complemento'/>
                                </label>
                            </div>


                            <button className="btnAtt" type="submit">Atualizar dados</button>
                            <button className='importTxt'>Importar carta de apresentação</button>

                        </form>
                    </div>
                </div>
            </div>
        </div>

    )
}

export default ProfilePage;