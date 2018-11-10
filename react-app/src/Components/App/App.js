import React, { Component } from 'react';
import StudentManager from '../StudentManager/StudentManager.js';
import {listStudents} from "../../repository/studentRepository";
import StudentList from "../StudentList/StudentList.js";


import './App.css';

class App extends Component {

    constructor(props){
        super(props);

        this.state = {
            student: listStudents()
        }

    }

    onAddNewStudent = (item, e) => {
        this.setState( state => {
            return {student:[...state.student, item]};
        });
    }

  render() {

    return (
        <div className="App">
        <div className="container">
            <div className="row">
                <div className="col-md-12">
                    <StudentManager onNewStudent={this.onAddNewStudent}/>
                </div>
            </div>

            <div className="row">
                <div className="col-md-12">
                    <StudentList students={this.state.student}/>
                </div>
            </div>
        </div>
        </div>
    );



  }
}

export default App;
