import React from 'react'
import './Comments.css'
import photo from '../../assets/man2.jpg'
import photo2 from '../../assets/woman2.2.jpg'
import photo3 from '../../assets/woman3.3.jpg'
import aspas from '../../assets/aspas.png'
import stars from '../../assets/stars2.png'
import stars2 from '../../assets/stars.png'

export const Comments = () => {
    return (
        <div className='comments'>
            <div className="blur come-blur"></div>
            {/* <div className="blur come-blur2"></div> */}
            <div className="commentsTitle">
                <span className='titleCom'>
                    Você está em boa companhia
                </span>
                <span className="textCom">
                    Nossos profissionais e clientes possuem as melhores avaliações e comentários. Acompanhe
                </span>
            </div>
            <div className="commentsBox">
                <div className="boxBox1">
                    <div className="box1">
                        <div className="box">
                            <img src={photo2} alt="" />
                            <div className="message">
                                <span className="aspa">
                                    <img src={aspas} alt="" />
                                </span>
                                Me senti mais segura em <br />
                                contratar um pintor para <br />
                                o meu apartamento com as <br />
                                avaliações do profissional <br />
                                exibidas no site.
                            </div>
                        </div>
                        <div className="name">
                            <div className="namee">
                                <span className="name2">
                                    -Lana Ribeiro, usuária do ManoTensão
                                </span>
                                <span className="aspa2">
                                    <img src={aspas} alt="" />
                                </span>
                            </div>
                        </div>
                    </div>
                    <div className="stars">
                        <img src={stars} alt="" />
                    </div>
                </div>
                <div className="boxBox2">
                    <div className="box2">
                        <div className="box">
                            <img src={photo3} alt="" />
                            <div className="message">
                                <span className="aspa">
                                    <img src={aspas} alt="" />
                                </span>
                                Depois de conhecer a <br />
                                ManoTensão, nunca mais me <br />
                                precisei me preocupar em <br />
                                achar um bom profissional.
                            </div>
                        </div>
                        <div className="name">
                            <div className="namee">
                                <span className="name2">
                                    -Marina Oliveira, usuária do ManoTensão
                                </span>
                                <span className="aspa2">
                                    <img src={aspas} alt="" />
                                </span>
                            </div>
                        </div>
                    </div>
                    <div className="stars">
                        <img src={stars} alt="" />
                    </div>
                </div>
            </div>
            <div className="commentBox">
                <div className="box3">
                    <div className="box">
                        <img src={photo} alt="" />
                        <div className="message">
                            <span className="aspa">
                                <img src={aspas} alt="" />
                            </span>
                            Foi muito fácil encontrar um <br />
                            eletricista, o serviço foi <br />
                            muito bom e o processo <br />
                            foi simples. <br />
                            Recomendo a plataforma!
                        </div>
                    </div>
                    <div className="name">
                        <div className="namee">
                            <span className="name2">
                                -João Alves, usuário do ManoTensão
                            </span>
                            <span className="aspa2">
                                <img src={aspas} alt="" />
                            </span>
                        </div>
                    </div>
                </div>
                <div className="stars">
                        <img src={stars2} alt="" />
                    </div>
            </div>
        </div>
    )
}
