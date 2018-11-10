import React, { Component } from 'react';
import StudentItem from '../StudentItem/StudentItem.js';

import './App.css';

class App extends Component {

    constructor(props){
        super(props);


    }

  render() {

      let student1 = {
          Ime: "Martin",
          Prezime: "Kostadinov",
          Nasoka: "KNI",
          Indeks: "161159"
      }

      let student2 = {
          Ime: "Darko",
          Prezime: "Darkovski",
          Nasoka: "KNI",
          Indeks: "151234"
      }

      let student3 = {
          Ime: "Marko",
          Prezime: "Kostadinov",
          Nasoka: "IKI",
          Indeks: "512345"
      }

    return (
        <div>
        <StudentItem student={student1}/>
        <StudentItem student={student2}/>
            <StudentItem student={student3}/>
        </div>
    );



  }
}

export default App;
