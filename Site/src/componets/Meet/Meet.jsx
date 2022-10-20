import React from 'react'
import './Meet.css'

export const Meet = () => {
    return (
        <div className='Meet' id='meet'>
            <div className="titleMeet">
                <span className="titleM">
                    Para prestadores de serviço e clientes
                </span>
            </div>
            <div className="providers">
                <div className="join">
                    <div className="photoJoin"></div>
                    <span className="titleJoin">
                        Profissionais Qualificados
                    </span>
                    <span className="textJoin">
                        A ManoTensão reune os melhores <br />
                        profissionais nas áreas de serviços <br />
                        domésticos como pintura, hidráulica e <br />
                        elétrica. Os prestadores são verificados e <br />
                        avaliados pelos consumidores.
                    </span>
                </div>
                <div className="satisfied">
                    <div className="photoSatisfied"></div>
                    <span className="titleSatisfied">
                        Usuários Satisfeitos
                    </span>
                    <span className="textSatisfied">
                    Com a ManoTensão fica fácil e prático <br />
                    encontrar serviços para seu <br />
                    apartamento. Realizando seu cadastro, <br />
                    já estará a poucos passos de encontrar <br />
                    o serviço que precisa!
                    </span>
                </div>
            </div>
        </div>
    )
}
