import React from 'react'
import StudentItem from "../StudentItem/StudentItem";

export default class StudentList extends React.Component{



    render(){

        const listItems = this.props.students.map((item, index) => {
            return (
                <StudentItem key={index} student={item}/>
            )
        });


        return (
            <div>
                <ul>
                    {listItems}
                </ul>
            </div>
        )

    }

}