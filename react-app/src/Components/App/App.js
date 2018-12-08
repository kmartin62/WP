import React, { Component } from 'react';
import './App.css';
import {listStudents} from "../../repository/studentRepository";
import StudentList from "../StudentList/StudentList.js";
// import StudentItem from "../StudentItem/StudentItem.js";
import EditStudentDetails from "../EditStudentDetails/EditStudentDetails.js";

class App extends Component {

    constructor(props){
        super(props);
        this.state = {
            student: listStudents(),
            status: true,
            tmp: []
        }
        this.changeBoolean = this.changeBoolean.bind(this);
    }

    changeBoolean(newObject){
        //this.setState({status: true})
        this.setState({tmp: newObject})

    }

  render() {

        let tmp;
        if(this.state.status){
            tmp = (<div>
                <EditStudentDetails student={this.state.tmp}/>
            </div>);
        }

    return (
       <div className="App">
           <div>
               <StudentList student={this.state.student} changeBoolean={this.changeBoolean}/>
           </div>
           {tmp}
       </div>
    )
  }
}

export default App;
