import React from 'react'
import './Search.css'
import Lupa from '../../assets/search.svg'
import Star from '../../assets/star-icon.png'
import Mulher from '../../assets/woman2.2.jpg'
import Star5 from '../../assets/star5.png'
import { LikeButton } from './HeartLike'
import { Footer } from '../Footer/Footer'
import api from '../../axios.js';

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

function pesquisarPorServico(){
    var tipoServico = 3;
    var tiposServicos = [];

    if(tipoServico === 1){
        tiposServicos = [1,4,5,7];
    } else if (tipoServico === 2){
        tiposServicos = [2,4,6,7];
    } else if(tipoServico === 3){
        tiposServicos = [3,5,6,7];
    }

    api
        .get(`/prestadores/filtro-por-servico/${tiposServicos[0]}/${tiposServicos[1]}/${tiposServicos[2]}/${tiposServicos[3]}`)
        .then((res) => {
          console.log(res);
          var prestadores = res.data;
          console.log(prestadores[0]);
        }).catch((err) => {
          console.log(err);
        })

}

export const Search = () => {
    return (
        <div className='search-all'>
            <div className="search">logar
                <div className="busca">
                    <div className="find">
                        Encontre um prestador perto de você
                    </div>
                    <div className="buscas">
                    <div className="select">
                        <img src={Lupa} alt="" />
                        <select name="" id="" onChange={pesquisarPorServico}>
                            <option selected disabled value="">Escolha um serviço</option>
                            <option value="1">Pintura</option>
                            <option value="2">Hidráulica</option>
                            <option value="3">Elétrica</option>
                        </select>
                    </div>
                    <div className="select sele">
                        <img src={Star} alt="" />
                        <select name="" id="">
                            <option selected disabled value="">Mais avaliados</option>
                            <option value="">5 estrelas</option>
                            <option value="">4 estrelas</option>
                            <option value="">3 estrelas</option>
                            <option value="">2 estrelas</option>
                            <option value="">1 estrelas</option>
                        </select>
                    </div>
                    </div>
                </div>
                <div className="providerss">
                    <div className="allProvi">
                        <div className="provider">
                            <div className="distance">
                                <span className="distan">
                                    0.8KM
                                </span>
                            </div>
                            <img src={Mulher} alt="" />
                            <div className="nameBar">
                                <span className="barName">
                                    Lana Ribeiro
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
            </div>
            <Footer />
        </div>
    )
}
