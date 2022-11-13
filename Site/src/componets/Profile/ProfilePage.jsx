import React, { useState } from 'react';
import notification from '../../assets/notifications.svg';
import homi from '../../assets/man.jpg';
import ProfileForm from './ProfileForm';
import style from '../Profile/Profile.css';

function ProfilePage() {
    return <div className={`${style.profile}`}>

        <><div className='header'>
            <span className='title'>ManoTensao</span>
            <img className='noti' src={notification} />
        </div><div className='container'>

                <div className='pic'>
                     <img src={homi} />
                    <p>Fulano da Silva</p>
                    <span>email@email.com</span>
                    <button>Escolher foto</button>
                </div>
                <div className='menu-info'>
                    <ProfileForm />
                </div>

            </div>
        </>
    </div>


}

export default ProfilePage;