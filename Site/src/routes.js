 import React from 'react'
import { BrowserRouter, Routes, Route } from 'react-router-dom'
import SignUpForm from './componets/Cadastro/SignUpForm'
import Chat from './componets/Chat/Chat'
import { PlansInfo } from './componets/PlansInfo/PlansInfo'
import { Search } from './componets/Search/Search'
import { Home } from './Pages/Home'
import { Profile } from './Pages/Profile'

export const Rota = () => {
  return (
    <BrowserRouter>
    <Routes>
        <Route path = "/usuario" element = {<Search />} />
        <Route path = "/cadastro" element = {<SignUpForm />} />
        <Route path = "/profile" element = {<Profile />} />
        <Route path = "/chat" element = {<Chat />} />
        <Route path = "/planos" element = {<PlansInfo />} />
        <Route path = "/" element = {<Home />} />
    </Routes>
    </BrowserRouter>
  )
}