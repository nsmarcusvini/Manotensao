import React, { useState } from 'react'
import './Search.css'
import Lupa from '../../assets/search.svg'
import { Footer } from '../Footer/Footer'
import api from '../../axios.js';
import { ItemPesquisa } from '../ItemPesquisa/ItemPesquisa'
import { useEffect } from 'react';

// function geolocalização(){
//     var axios = require('axios');

// var config = {
//   method: 'get',
//   url: `https://maps.googleapis.com/maps/api/distancematrix/json?origins=${08121-640}&destinations${06065-180}&mode=bicycling&language=fr-FR&key=YOUR_API_KEY`,
//   headers: { }
// };

// axios(config)
// .then(function (response) {
//   console.log(JSON.stringify(response.data));
// })
// .catch(function (error) {
//   console.log(error);
// });
// }


async function pesquisarPorServico(select) {
    var tipoServico = select;
    var tiposServicos = [];
    var melhores = false;

    if (tipoServico == "1") {
        tiposServicos = [1, 4, 5, 7];
    } else if (tipoServico == "2") {
        tiposServicos = [2, 4, 6, 7];
    } else if (tipoServico == "3") {
        tiposServicos = [3, 5, 6, 7];
    }

    let prestadores = [];

    if (melhores === false) {
        await api
            .get(`/prestadores/filtro-por-servico/${tiposServicos[0]}/${tiposServicos[1]}/${tiposServicos[2]}/${tiposServicos[3]}`)
            .then((res) => {
                prestadores = res.data;

            }).catch((err) => {
                console.log(err);
            })
    } else {
        api
            .get(`/avaliacoes-prestadores/melhores-por-servico/${tiposServicos[0]}/${tiposServicos[1]}/${tiposServicos[2]}/${tiposServicos[3]}`)
            .then((res) => {
                console.log(res);
                prestadores = res.data;
            }).catch((err) => {
                console.log(err);
            })
    }

    return prestadores;

}


async function pesquisarPorAvaliacao(checkbox, select) {

    var tipoServico = select;
    var tiposServicos = [];
    // if(melhores == true){

    let prestadores = []

    // console.log(tipoServico)

    if (tipoServico == null) {
        await api
            .get(`/avaliacoes-prestadores/melhores`)
            .then((res) => {
                // console.log("1", res);
                prestadores = res.data;
            }).catch((err) => {
                console.log(err);
            })
    } else {
        if (tipoServico == "1") {
            tiposServicos = [1, 4, 5, 7];
        } else if (tipoServico == "2") {
            tiposServicos = [2, 4, 6, 7];
        } else if (tipoServico == "3") {
            tiposServicos = [3, 5, 6, 7];
        }

        await api
            .get(`/avaliacoes-prestadores/melhores-por-servico/${tiposServicos[0]}/${tiposServicos[1]}/${tiposServicos[2]}/${tiposServicos[3]}`)
            .then((res) => {
                // console.log("2", res);
                prestadores = res.data;
            }).catch((err) => {
                console.log(err);
            })
    }

    console.log(prestadores)

    return prestadores

    // } else {}

}

export const Search = () => {

    const [servico, setServico] = useState([])
    const [select, setSelect] = useState()
    const [checkbox, setCheckbox] = useState(false)

    useEffect(() => {
        const fetchData = async () => {
            const test = await pesquisarPorServico(select)
            // console.log(test)
            setServico(test)
        }
        fetchData()
    }, [select]
    )

    useEffect(() => {
        const fetchData = async () => {
            const test = await pesquisarPorAvaliacao(checkbox, select)
            // console.log(test)
            setServico(test)
        }
        fetchData()
        // console.log(servico)
    }, [checkbox]
    )

    return (
        <div className='search-all'>
            <div className="search">
                <div className="busca">
                    <div className="find">
                        Encontre um prestador perto de você
                    </div>
                    <div className="buscas">
                        <div className="select">
                            <img src={Lupa} alt="" />
                            <select name="" id="" onChange={(e) => setSelect(e.target.value)}>
                                <option selected disabled value="">Escolha um serviço</option>
                                <option value="1">Pintura</option>
                                <option value="2">Hidráulica</option>
                                <option value="3">Elétrica</option>
                            </select>
                        </div>
                        <div className="sele">
                            <label htmlFor='avaliados' className="mais">
                                <div className="switch">
                                    <input type="checkbox" value="false" name='avaliados' id='avaliados' className='avaliados' onClick={() => setCheckbox(!checkbox)} />
                                    <span className="switchButton"></span>
                                </div>
                                <span className="melhores">Mais avaliados</span>
                            </label>
                        </div>
                    </div>
                </div>

                <div className="cradsPrestador">
                    {servico?.map(prestador => (
                        <ItemPesquisa
                            nome={prestador.nome}
                            imagem={prestador.urlFoto}
                            estrela={prestador.media}
                        />
                    ))}
                </div>
            </div>
            <Footer />
        </div>
    )
}
