import React from 'react'
import { BrowserRouter, Routes, Route } from 'react-router-dom'
// import { Mano } from './componets/Mano/Mano'
import { Search } from './componets/Search/Search'

export const Rota = () => {
  return (
    <BrowserRouter>
    <Routes>
        <Route path = "/usuario" element = {<Search />} />
        {/* <Route path = "/home" element = {<Mano />} /> */}
    </Routes>
    </BrowserRouter>
  )
}
