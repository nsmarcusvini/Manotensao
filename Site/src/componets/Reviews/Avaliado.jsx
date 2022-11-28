import React from 'react';
import { useNavigate } from 'react-router-dom'
import './Review.css'
import { Footer } from '../Footer/Footer'

function Avaliado() {

    const navigate = useNavigate();

    return (



        <div className='bodyReview'>


            <div className="container">
                <div className="con">
                    <h1 className='logoHeader'>ManoTensao</h1>
                    <ul className='menu'>
                        <a className="list" onClick={() => navigate("/home")}>Home</a>
                        <a className='list' onClick={() => navigate("/chat")}>Chat</a>
                        <a className='list' onClick={() => navigate("/search")}>Pesquisar</a>

                    </ul>
                </div>
            </div>

            <div className="divAvaliado">
                <h2 className='h2Avaliado'>Sua avaliação foi enviada!</h2>
                <button className='voltar' onClick={() => navigate("/search")}>Voltar</button>
            </div>

            <Footer />

        </div>


    )
}

export default Avaliado;