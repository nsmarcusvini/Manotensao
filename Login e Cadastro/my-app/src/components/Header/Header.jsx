import React from 'react'
import './Header.css'

export const Header = () => {
  return (
    <div className='header'>
        <h1 className='logo'>ManoTensao</h1>

        <ul className='menu'>
            <li>Serviços</li>
            <li>Conheça</li>
            <li>Planos</li>
            <li>Cadastres-se</li>
        </ul>
    </div>
  )
}

export default Header;
