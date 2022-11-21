import React, { useState } from 'react'
import './Header.css'
import { Link } from 'react-scroll'
import { useNavigate } from 'react-router-dom'

export const Header = () => {

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

            <a className='list'><Link to="manos" spy={true} smooth={true} offset={0} duration={500} onClick={closeMenu}>Home</Link></a>
            <a className='list'><Link to="meet" spy={true} smooth={true} offset={-90} duration={500} onClick={closeMenu}>Serviços</Link></a>
            <a className='list'><Link to="plan" spy={true} smooth={true} offset={-90} duration={500} onClick={closeMenu}>Planos</Link></a>
            <a className='list'><Link to="comment" spy={true} smooth={true} offset={-110} duration={500} onClick={closeMenu}>Conheça</Link></a>
            <a className="list" onClick={() => navigate("/cadastro")}>Cadastre-se</a>

          </ul>
        </div>
      </div>
    </div>
  )
}
