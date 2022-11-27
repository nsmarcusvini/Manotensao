import React from 'react'
import './Search.css'
import Lupa from '../../assets/search.svg'
import Mulher from '../../assets/woman2.2.jpg'
import Star5 from '../../assets/star5.png'
import { LikeButton } from './HeartLike'
import { Footer } from '../Footer/Footer'

function pesquisarPorServico(){
    
}

export const Search = () => {
    return (
        <div className='search-all'>
            <div className="search">
                <div className="busca">
                    <div className="find">
                        Encontre um prestador perto de você
                    </div>
                    <div className="select">
                        <img src={Lupa} alt="" />
                        <select name="" id="" onChange={pesquisarPorServico}>
                            <option selected disabled value="">Escolha um serviço</option>
                            <option value="">Eletétrica</option>
                            <option value="">Hidráulica</option>
                            <option value="">Pintura</option>
                        </select>
                    </div>
                </div>
                <div className="providerss">
                    <div className="allProvi">
                        <div className="provider">
                            <div className="distance">
                                <span className="distan">
                                    0.8KM
                                </span>
                            </div>
                            <img src={Mulher} alt="" />
                            <div className="nameBar">
                                <span className="barName">
                                    Lana Ribeiro
                                </span>
                                <img src={Star5} alt="" />
                            </div>
                        </div>
                        <div className="buttons">
                            <button className='sendMensa'>Enviar mensagem</button>
                            <LikeButton />
                        </div>
                    </div>
                </div>
            </div>
            <Footer />
        </div>
    )
}
