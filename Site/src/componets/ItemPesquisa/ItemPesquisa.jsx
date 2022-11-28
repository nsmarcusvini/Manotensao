import React, { useState } from "react";
import api from '../../axios'
import { LikeButton } from "../Search/HeartLike";
import User from '../../assets/user.jpg'
import Star from '../../assets/star.svg'

export const ItemPesquisa = (props) => {

    const [nome, setNome] = useState(props.nome);
    const [email, setEmail] = useState(props.email);
    const [imagem, setImagem] = useState(props.imagem);
    const [estrela, setEstrela] = useState(props.estrela);

    const [editavel, setEditavel] = useState(false);

    function editar() {
        const prestadorEditada = {
            nome: nome,
            email: email,
            imagem: imagem,
            estrela: estrela

        };

        api
            .put(`/${props.id}`, prestadorEditada)
            .then((res) => {
                alert("Usuário criado");
                setEditavel(false);
            })
            .catch((erro) => {
                alert("Algo deu errado!");
                console.log(erro);
            });

        console.log(prestadorEditada);
    }

    const cardImage = imagem ? imagem : User

    console.log(imagem)

    return (
        <>

            <div className="allProvi">
                <div className="provider">
                    <div className="distance">
                        <span className="distan">
                            0.8KM
                        </span>
                    </div>
                    <img src={cardImage} alt="" className="persona" />
                    <div className="nameBar">
                        <div className="nomePrestadorBar">
                            <span className="barName">
                                {nome}
                            </span>
                        </div>
                        <div className="stars">
                            {Array.from({ length: props.estrela }, () => (
                                <img src={Star} className="star" />
                            ))}
                        </div>
                    </div>
                </div>
                <div className="buttons">
                    <button className='sendMensa'>Enviar mensagem</button>
                    <LikeButton />
                </div>
            </div>

        </>
    );
}
