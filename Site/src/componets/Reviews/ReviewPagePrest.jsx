import React from 'react';
import { useNavigate } from 'react-router-dom'
import './Review.css'
import { Footer } from '../Footer/Footer'


function ReviewsPrest() {

  

    const navigate = useNavigate();

    function avaliar(e) {
        e.preventDefault();

        const dadosAvaliacao = {
            nota: e.target.elements.nota.value,
            comentario: e.target.elements.comentario.value
        }
        console.log(dadosAvaliacao)

        if (dadosAvaliacao.nota != null) {
            navigate("/avaliado")
        }
        else {

        }

    }




    return (



        <div className='bodyReview'>


            <div className="container">
                <div className="con">
                    <h1 className='logoHeader'>ManoTensao</h1>
                    <ul className='menu'>
                        <a className="list" onClick={() => navigate("/home")}>Home</a>
                        <a className='list' onClick={() => navigate("/connect")}>Chat</a>
                        <a className='list' onClick={() => navigate("/search")}>Pesquisar</a>

                    </ul>
                </div>
            </div>

            <h2 className='h2Review'>Avalie: nome</h2>


            <form className='formReview' onSubmit={avaliar}>

                <label className='lblReview'>
                    Dê uma nota ao prestador:
                    <input required className='nota' name='nota' type='number' max={5} min={1} />

                </label>

                <label className='lblReview'>
                    O que achou do serviço?
                    <textarea className='comentario' name='comentario'></textarea>
                </label>


                <button className='enviar' type='submit'>Avaliar!</button>



            </form>
            <Footer />

        </div>


    )
}

export default ReviewsPrest;