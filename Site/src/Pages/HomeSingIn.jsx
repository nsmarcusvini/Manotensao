import React from 'react'
import { Comments } from '../componets/Comments/Comments'
import { Footer } from '../componets/Footer/Footer'
import { HeaderHomeLogin } from '../componets/HeaderHomeLogin/HeaderHomeLogin'
import { LogoInfo } from '../componets/LogoInfo/LogoInfo'
import { Mano } from '../componets/Mano/Mano'
import { Meet } from '../componets/Meet/Meet'
import { PlansLogin } from '../componets/PlansLogin/PlansLogin'

export const HomeSingIn = () => {
    return (
        <>
            <HeaderHomeLogin />
            <Mano />
            <Meet />
            <PlansLogin />
            <Comments />
            <LogoInfo />
            <Footer />
        </>
    )
}
