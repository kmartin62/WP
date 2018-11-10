import React, { Component } from 'react';
import './App.css';
import StudentList from '../StudentList/StudentList';
import {listStudents} from "../../repository/studentRepository";
import EditStudentDetails from "../EditStudentDetails/EditStudentDetails.js";

class App extends Component {

    constructor(props) {
        super(props);

        this.state = {
            students: listStudents(),
            s: {
                name: "Abdul",
                surname: "Hello",
                major: "AAA",
                indeks: "123123"
            }
        }
        }

    render() {
        console.log("RENDERED")

    return (
        <div className="App">
            <div>
            <StudentList students={this.state.students}/>
            </div>

            {/*<div>*/}
                {/*<EditStudentDetails student={this.state.s}/>*/}
            {/*</div>*/}
        </div>

    );
  }
}

export default App;
