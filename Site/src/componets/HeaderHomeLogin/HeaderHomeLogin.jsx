import React, { useState } from 'react'
import { useNavigate } from 'react-router-dom'
import './HeaderHomeLogin.css'

export const HeaderHomeLogin = () => {

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

  return (
    <div className={color ? 'header header-bg' : 'header'}>
        <div className="container">
                <div className="con">
                    <h1 className='logoHeader'>ManoTensao</h1>
                    <ul className='menu'>
                        <a className="list" onClick={() => navigate("/profile")}>Perfil</a>
                        <a className='list' onClick={() => navigate("/chat")}>Chat</a>
                        <a className='list' onClick={() => navigate("/search")}>Pesquisar</a>
                        <a className='list' onClick={() => navigate("/")}>Sair</a>

                    </ul>
                </div>
            </div>
    </div>
  )
}
