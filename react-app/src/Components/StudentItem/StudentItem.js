import React from 'react'

const studentItem = (props) => {
    return (<li>
        <span>ime: {props.children} prezime: {props.prezime}</span>
        <input onChange={props.changeEvent} value={props.children}/>
        <button onClick={props.delEvent}>x</button>
    </li>)
}

export default studentItem;