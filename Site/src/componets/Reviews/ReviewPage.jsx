import React from 'react';
import './Review.css'

function Reviews() {
    return (

        <div className='bodyReview'>
            <h2>Avalie o serviço de: nome</h2>


            <form className='formReview'>

                <label>
                    O que achou do serviço?
                    <input className='comentario' type='textarea' name='comentario'></input>
                </label>

                <label>
                    Dê uma nota ao prestador:
                    <select className='nota' name='nota'>
                        <option value=""></option>
                    </select>
                </label>




            </form>

        </div>


    )
}

export default Reviews;