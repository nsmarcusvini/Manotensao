import React, { useState } from 'react'
import { useNavigate } from 'react-router-dom'
import './HeaderLogin.css'

export const HeaderLogin = () => {

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
                        <a className='list' onClick={() => navigate("/")}>Voltar</a>

                    </ul>
                </div>
            </div>
    </div>
  )
}
