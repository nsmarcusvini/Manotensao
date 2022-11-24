 import React from 'react'
import { BrowserRouter, Routes, Route } from 'react-router-dom'
import Chat from './componets/Chat/Chat'
import { PlansInfo } from './componets/PlansInfo/PlansInfo'
import { PlansInfoPremium } from './componets/PlansInfoPremium/PlansInfoPremium'
import { PlansInfoPro } from './componets/PlansInfoPro/PlansInfoPro'
import { Home } from './Pages/Home'
import { HomeSingIn } from './Pages/HomeSingIn'
import { Login } from './Pages/Login'
import { Profile } from './Pages/Profile'
import { User } from './Pages/User'

export const Rota = () => {
  return (
    <BrowserRouter>
    <Routes>
        <Route path = "/plans-premium" element = {<PlansInfoPremium />} />
        <Route path = "/plans-pro" element = {<PlansInfoPro />} />
        <Route path = "/plans-basic" element = {<PlansInfo />} />
        <Route path = "/search" element = {<User />} />
        <Route path = "/cadastro" element = {<Login />} />
        <Route path = "/profile" element = {<Profile />} />
        <Route path = "/chat" element = {<Chat />} />
        <Route path = "/planos" element = {<PlansInfo />} />
        <Route path = "/home" element = {<HomeSingIn />} />
        <Route path = "/" element = {<Home />} />
    </Routes>
    </BrowserRouter>
  )
}