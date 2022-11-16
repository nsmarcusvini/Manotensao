import React from 'react'
import './Meet.css'
import Pincel from '../../assets/pincel.png'
import Wite from '../../assets/water-pipe.png'
import Raio from '../../assets/cerca.png'

export const Meet = () => {
    return (
        <div className='Meet' id='meet'>
            {/* <div className="blur meet-blur"></div> */}
            <div className="titleMeet">
                <span className="titleM">
                    Para prestadores de serviço e clientes
                </span>
            </div>
            <div className="providers">
                <div className="boxesHome">
                    <div className='boxHome boxes'>
                        <div className="satisfeito">
                            <span className='boxHomesTitleG'>
                            Usuários Satisfeitos
                            </span>
                            <span className='boxHomesTextG'>
                            Com a ManoTensão fica fácil e prático <br />
                            encontrar serviços para seu <br />
                            apartamento. Realizando seu cadastro, <br />
                            já estará a poucos passos de encontrar <br />
                            o serviço que precisa!
                            </span>
                        </div>
                    </div>
                    <div className='boxHome boxes2'>
                        <div className="qualificados">
                            <span className='boxHomesTitle'>
                            Profissionais Qualificados
                            </span>
                            <span className='boxHomesText'>
                            A ManoTensão reune os melhores <br />
                            profissionais nas áreas de serviços <br />
                            domésticos como pintura, hidráulica e <br />
                            elétrica. Os prestadores são verificados e <br />
                            avaliados pelos consumidores. 
                            </span>
                        </div>
                    </div>
                </div>
                <div className="boxesHome2">
                    <div className='boxHome2'>
                        <div className="hidra">
                            <img src={Wite} alt="" />
                            <span className='boxHomeTitle'>
                                Reparos Hidráulicos
                            </span>
                            <span className='boxHomeText'>
                                Reformas <br />
                                hidráulicas em geral <br />
                                da melhor <br />
                                qualidade
                            </span>
                        </div>
                    </div>
                    <div className='boxHome2'>
                        <div className="gerais">
                            <img src={Pincel} alt="" />
                            <span className='boxHomeTitle'>
                                Pinturas Gerais
                            </span>
                            <span className='boxHomeText'>
                                Renove seu <br />
                                ambiene com <br />
                                novas  cores e <br />
                                profissionais  de <br />
                                primeira
                            </span>
                        </div>
                    </div>
                    <div className='boxHome2'>
                        <div className="eletrico">
                            <img src={Raio} alt="" />
                            <span className='boxHomeTitle'>
                                Serviços Elétricos
                            </span>
                            <span className='boxHomeText'>
                                Troca de fiação e <br />
                                reparos <br />
                                eleétricos com <br />
                                nossos <br />
                                profissionais
                            </span>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    )
}
