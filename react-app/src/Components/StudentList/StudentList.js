import React from 'react'
import StudentItem from "../StudentItem/StudentItem";

export default class StudentList extends React.Component{

    render() {

        const listStudents = this.props.students.map((item, index) => {
            // console.log(item);
            // console.log(index);

            const test = () => {
                console.log(item)
            }

            return (
                <StudentItem key={index} student={item} onclick={test}/>
            )
        });

        return (
            <div>
                {listStudents}
            </div>
        );
    }

}