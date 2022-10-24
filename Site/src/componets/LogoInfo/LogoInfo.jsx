import React from 'react'
import './LogoInfo.css'
import logo from '../../assets/Logo Construção E Reparos (2).png'

export const LogoInfo = () => {
    return (
        <div className='logoInfo'>
            <div className="infor">
                <img src={logo} alt="" />
                <div className="infox">
                    <div className="mobile">
                        <span className='titleInfo'>
                            App Mobile
                        </span>
                        <span className='textInfo'>
                            IOS <br />
                            Android
                        </span>
                    </div>
                    <div className="comuni">
                        <span className='titleInfo'>
                            Comunidade
                        </span>
                        <span className='textInfo'>
                            Avaliações <br />
                            Sobre contratar <br />
                            Sobre atender
                        </span>
                    </div>
                    <div className="empre">
                        <span className='titleInfo'>
                            Empresa
                        </span>
                        <span className='textInfo'>
                            Sobre nós <br />
                            Fale com a gente <br />
                            Nossa história
                        </span>
                    </div>
                </div>
            </div>
        </div>
    )
}
