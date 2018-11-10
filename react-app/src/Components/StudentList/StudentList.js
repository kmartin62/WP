import React from 'react'
import StudentItem from "../StudentItem/StudentItem";
import EditStudentDetails from '../EditStudentDetails/EditStudentDetails.js'

export default class StudentList extends React.Component{

    render() {

        // var helpObject = {};
        //
        // const onClicker = (e) => {
        //     console.log(e.target.name);
        // }

        return (
            <div>
                <div>
                {this.props.students.map((item, index) =>
                <StudentItem key={index} student={item} onclick={onClicker}/>)}
                </div>

                <div>
                    {/*<EditStudentDetails/>*/}
                </div>
            </div>

        );
    }

}