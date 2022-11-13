import React from 'react';
/* import styles from '../Profile.css'; */
import '../Profile.css'

function Input({type, text, name, id, placeholder, handleOnChance, value}) {
    return (
        <div /* className={`inputs ${styles.profile}`} */>
            <label htmlFor={name}>{text}</label>
            <input
                type={type}
                name={name}
                id={id}
                placeholder={placeholder}
                onChange={handleOnChance}
                value={value}
            />
        </div>



    )
}

export default Input;