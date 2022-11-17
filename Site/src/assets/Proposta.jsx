import React from 'react';
import './Proposta.css';
import SideNavBar from '../SideNavBar/SideNavBar';
import notification from '../assets/notifications.svg'
import arrow from '../assets/arrow-foward.svg'
import woman from '../assets/woman.jpg';
import heart from '../assets/heart-outline.svg';
import share from '../assets/share-social-outline.svg';
import alert from '../assets/alert-circle-outline.svg';
import { Footer } from '../Footer/Footer';
import woman2 from '../assets/woman2.jpeg'

function Proposta() {
    return (

        <div className='body'>

            <div className="main">
                <SideNavBar />
                <div className='header'>
                    <span className='title'>ManoTensao</span>
                    <img className='noti' src={notification} />
                    <img className='user' src={woman2}/>
                </div>


                <div className="container">

                    <div className='left'>

                        <img className='pic' src={woman} />

                    </div>

                    <div className="right">

                        <p className='name'>Maria Silva</p>

                        <div className="tool_icons">
                            <img src={heart} alt="" />
                            <img src={share} />
                            <img src={alert} />
                        </div>
                        <button className='btnFazerProposta'>Fazer uma proposta</button>
                        <button className='btnConversar'>Conversar com Maria</button>

                        <div className="desc_prestador">
                            <p className='desc'>Lorem, ipsum dolor sit amet consectetur adipisicing elit. Ipsam, animi repellat possimus maiores commodi atque? Debitis laudantium explicabo, aliquam tempore, fugit voluptates</p>
                        </div>
                        <div className="info_valor">
                            <span className='valor'>R$ 90</span>
                            <span className='desc_valor'>por diária</span>
                        </div>
                        <div className="disponivel"></div>
                    </div>

                    <div className="reviews">
                        <div className="comment">
                            <p className='usuario1'>Usuário 1</p>
                            <img className='arrow' src={arrow} alt="" />
                            <p className='texto'>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Tempore sapiente excepturi quo error ipsa, eum voluptatem accusamus neque explicabo rem in quia commodi perferendis.</p>
                            <p className='nota' >Nota 4</p>
                        </div>
                    </div>


                </div>

            </div>

            <Footer />
        </div>
    )

}
export default Proposta;