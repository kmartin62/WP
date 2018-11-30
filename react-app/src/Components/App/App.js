import React, { Component } from 'react';
import StudentItem from "../StudentItem/StudentItem.js"

import './App.css';
import {listStudents} from "../../repository/studentRepository";

class App extends Component {

    constructor(props){
        super(props);
        this.state = {
            student: listStudents()
        }
    }

    deleteUser = (index, e) =>{
        const users = Object.assign([], this.state.student); // napravi duplikat array
        users.splice(index, 1);   // najdi go index i pomrdni ja celata niza za 1
        this.setState({student:users}) // zameni ja starata niza so novata
    }

    changeUser = (indeks, e) => {
        const index = this.state.student.findIndex((user) => {
            return user.Indeks === indeks
        });

        const user = Object.assign([], this.state.student[index]);

        user.Ime = e.target.value;
        console.log(user.Ime);

        const users = Object.assign([], this.state.student)

        users[index] = user;

        this.setState({student:users})


    }


  render() {


    return (
       <div className="App">
           <ul>
               {
                   this.state.student.map((student, index) => {
                       return (<StudentItem
                           prezime={student.Prezime}
                           key={student.Indeks}
                           delEvent={this.deleteUser.bind(this, index)}
                           changeEvent={this.changeUser.bind(this, student.Indeks)}
                       >{student.Ime}</StudentItem>)
                   })
               }
           </ul>
       </div>
    )



  }
}

export default App;
