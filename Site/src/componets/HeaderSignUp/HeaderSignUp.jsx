import React, { useState } from 'react'
import './HeaderSignUp.css'
import api from '../../axios.js'
import { useNavigate } from 'react-router-dom'

export const HeaderSignUp = () => {

    const navigate = useNavigate();

    const [click, setClick] = useState(false)
    const closeMenu = () => setClick(false)

    const [color, setColor] = useState(false)
    const changeColor = () => {
        if (window.scrollY >= 100) {
            setColor(true)
        } else {
            setColor(false)
        }
    }
    window.addEventListener('scroll', changeColor)

    function logoff(){
        try{
            api
            .delete(`/prestadores/logoff-prestador/${JSON.parse(sessionStorage.user).id}`)
            .then(() => {
                window.sessionStorage.setItem("user", "");
                window.sessionStorage.setItem("tipoUsuario", "");
              window.location.href = 'http://localhost:3000';
            })
        }catch(err){
            api
            .delete(`/clientes/logoff-cliente/${JSON.parse(sessionStorage.user).id}`)
            .then(() => {
                window.sessionStorage.setItem("user", "");
                window.sessionStorage.setItem("tipoUsuario", "");
              window.location.href = 'http://localhost:3000';
            }).catch((err) => {
                console.log(err);
            })
        }
        
    }

    return (
        <div className={color ? 'header header-bg' : 'header'}>
            <div className="container">
                <div className="con">
                    <h1 className='logoHeader'>ManoTensao</h1>
                    <ul className='menu'>
                    <a className="list" onClick={() => navigate("/home")}>Home</a>
                    <a className="list" onClick={() => navigate("/profile")}>Perfil</a>
                        <a className='list' onClick={() => navigate("/chat")}>Chat</a>
                        <a className='list' onClick={logoff}>Sair</a>

                    </ul>
                </div>
            </div>
        </div>
    )
}
