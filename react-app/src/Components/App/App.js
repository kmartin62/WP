import React, { Component } from 'react';
import StudentItem from '../StudentItem/StudentItem.js';
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

  render() {

    return (
        <div>
        <StudentList items={this.state.student}/>
        </div>
    );



  }
}

export default App;
