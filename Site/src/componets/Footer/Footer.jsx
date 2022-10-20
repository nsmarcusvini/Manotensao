import React from 'react'
import './Footer.css'
import git from '../../assets/github.png'
import insta from '../../assets/instagram.png'
import link from '../../assets/linkedin.png'

export const Footer = () => {
  return (
    <div className='Footer'>
      <hr />
      <div className="footer-icon">
        <span className="mano">
          © ManoTensao, Inc. 2022. We love our users!
        </span>
        <div className="icon">
        <span className="follow">
          Follow us:
        </span>
          <img src={git} alt="" />
          <img src={insta} alt="" />
          <img src={link} alt="" />
        </div>
      </div>
    </div>
  )
}
