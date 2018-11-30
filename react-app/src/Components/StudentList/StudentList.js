import React from 'react'
import StudentItem from "../StudentItem/StudentItem.js";


export default class StudentList extends React.Component{

    render() {
        return (
            <div>
                {this.props.student.map((item, index) => {

                    const selectObject = () => {
                        this.props.changeBoolean(item)
                        console.log(item)
                    }

                    return(<StudentItem key={index} student={item} changeBoolean={selectObject}/>)
                })}
            </div>
        );
    }
}