import React from 'react'
import { BrowserRouter, Routes, Route } from 'react-router-dom'
import { ConnectPage } from './Pages/Connect'
import { PlansInfo } from './componets/PlansInfo/PlansInfo'
import { PlansInfoPremium } from './componets/PlansInfoPremium/PlansInfoPremium'
import { PlansInfoPro } from './componets/PlansInfoPro/PlansInfoPro'
import { Sucess } from './componets/Sucess/Sucess'
import { Home } from './Pages/Home'
import { HomeSingIn } from './Pages/HomeSingIn'
import { Login } from './Pages/Login'
import { Profile } from './Pages/Profile'
import { User } from './Pages/User'
import { Proposta } from './Pages/Proposta'
import { PropostaClient } from './Pages/PropostaCliente'
import { ReviewPrestador } from './Pages/ReviewPrestador'
import  Avaliado  from './componets/Reviews/Avaliado'
import { ReviewCliente } from './Pages/ReviewCliente'
 
export const Rota = () => {
  return (
    <BrowserRouter>
    <Routes>
        <Route path = "/sucess" element = {<Sucess />} />
        <Route path = "/plans-premium" element = {<PlansInfoPremium />} />
        <Route path = "/plans-pro" element = {<PlansInfoPro />} />
        <Route path = "/plans-basic" element = {<PlansInfo />} />
        <Route path = "/search" element = {<User />} />
        <Route path = "/cadastro" element = {<Login />} />
        <Route path = "/profile" element = {<Profile />} />
        <Route path = "/connect" element = {<ConnectPage />} />
        <Route path = "/planos" element = {<PlansInfo />} />
        <Route path = "/home" element = {<HomeSingIn />} />
        <Route path = "/proposta" element = {<Proposta />} />
        <Route path = "/propostaClient" element = {<PropostaClient />} />
        <Route path = "/reviewprestador" element = {<ReviewPrestador />} />
        <Route path = "/reviewcliente" element = {<ReviewCliente />} />
        <Route path = "/" element = {<Home />} />
        <Route path = "/avaliado" element = {<Avaliado />} />
    </Routes>
    </BrowserRouter>
  )
}