import React, { Component } from 'react';
import './App.css';
import StudentList from "../StudentList/StudentList.js";
import {getStudyPrograms, onNewStudyProgram} from "../../repository/myStudyProgramApi";
import EditStudentDetails from "../EditStudentDetails/EditStudentDetails.js";
import {getStudents, createStudent, updateStudent} from "../../repository/myStudentApi";
import StudentManager from "../StudentManager/StudentManager";
import StudyProgramList from "../StudyProgramList/StudyProgramList.js";
import StudyProgramManager from "../StudyProgramManager/StudyProgramManager.js";

class App extends Component {

    constructor(props){
        super(props);
        this.state = {
            student: [],
            studyProgram: [],
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

    return (
       <div className="App">
           <div>
               <StudentList student={this.state.student} changeBoolean={this.changeBoolean}/>
           </div>
           <div>
               <StudentManager onNewStudent={this.onNewStudent}/>
           </div>
           <div>
               <EditStudentDetails student={this.state.tmp} onSubmit={this.onUpdateStudent}/>
           </div>


           <div>
               <StudyProgramList studyprogram = {this.state.studyProgram}/>
           </div>
           <div>
               {/*<StudyProgramManager onNewStudyProgram={this.onNewStudyProgram()}/>*/}
            <StudyProgramManager/>
           </div>
       </div>
    )
  }

  componentDidMount() {
           this.loadData();
  }


    loadData = () => {

           getStudents()
               .then(response => response.json())
               .then((data) => {
                   console.log(data)
                   this.setState(() => ({
                       student: data
                   }))
               })

        getStudyPrograms()
            .then(response => response.json())
            .then((data) => {
                this.setState(() => ({
                    studyProgram: data
                }))
            })



  }

  onNewStudent = (student) => {
           createStudent(student)
               .then(response => {
                   this.loadData();
               })
  };

               // onNewStudyProgram = (studyProgram) => {
               //     onNewStudyProgram(studyProgram)
               //         .then(response => {
               //             this.loadData();
               //         });
               // }

    onUpdateStudent = (student) => {
        updateStudent(student)
            .then(() => {
                this.loadData()
            });
    }

}

export default App;
