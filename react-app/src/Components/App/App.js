import React, { Component } from 'react';
import './App.css';
import StudentList from '../StudentList/StudentList';
import {listStudents} from "../../repository/studentRepository";

class App extends Component {

    constructor(props) {
        super(props);

        this.state = {
            students: listStudents()
        };
    }


    render() {



    return (
        <div className="App">
            <StudentList students={this.state.students}/>
        </div>

    );
  }
}

export default App;
