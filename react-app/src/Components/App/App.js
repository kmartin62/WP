import React, { Component } from 'react';
import Children from '../Children/Children.js';
import Sibiling from '../Sibiling/Sibiling.js';
import StudentManager from '../StudentManager/StudentManager.js';
import {listStudents} from "../../repository/studentRepository";
import StudentList from "../StudentList/StudentList.js";


import './App.css';

class App extends Component {

    constructor(props){
        super(props);
        this.state = { name: "Martin" };
        this.changeName = this.changeName.bind(this);
        // this.state = {
        //     student: listStudents()
        //}

    }

    onAddNewStudent = (item, e) => {
        this.setState( state => {
            return {student:[...state.student, item]};
        });
    }

    changeName(newName){
        this.setState({
            name: newName
        });
    }

  render() {

    return (
        <div>
        <Children name={this.state.name} onChange={this.changeName}/>
        <Sibiling name={this.state.name}/>
        </div>
        // {/*<div className="App">*/}
        // {/*<div className="container">*/}
        //     {/*<div className="row">*/}
        //         {/*<div className="col-md-12">*/}
        //             {/*<StudentManager onNewStudent={this.onAddNewStudent}/>*/}
        //         {/*</div>*/}
        //     {/*</div>*/}
        //
        //     {/*<div className="row">*/}
        //         {/*<div className="col-md-12">*/}
        //             {/*<StudentList students={this.state.student}/>*/}
        //         {/*</div>*/}
        //     {/*</div>*/}
        // {/*</div>*/}
        // {/*</div>*/}
    )



  }
}

export default App;
