import React, { useState } from "react";
import api from '../../axios'

export const ItemPesquisa = () => {

    const [nome, setNome] = useState(props.nome);
    const [email, setEmail] = useState(props.email);
    const [imagem, setImagem] = useState(props.capa);

    const [editavel, setEditavel] = useState(false);

    function editar() {
        const prestadorEditada = {
            nome: nomeInput,
            email: emailInput,
            imagem: imagemInput
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

    return (
        <>
            <div className="providerss">
                <div className="allProvi">
                    <div className="provider">
                        <div className="distance">
                            <span className="distan">
                                0.8KM
                            </span>
                        </div>
                        <img alt=""
                            disabled={!editavel}
                            defaultValue={imagemInput}
                            onChange={(e) => setImagem(e.target.value)} />
                        <div className="nameBar">
                            <span className="barName" disabled={!editavel}
                                type="text"
                                defaultValue={nomeInput}
                                onChange={(e) => setNome(e.target.value)}>
                                {props.nome}
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
        </>
    );
}
