import React from 'react'

export default class EditStudentDetails extends React.Component{

    onFormSubmit = (e) => {

        e.preventDefault();
        console.log("I'm in!")
        this.props.onUpdateStudent(

            this.setState({name: e.target.txt1.value}),
            this.setState({lastName: e.target.txt2.value}),
            this.setState({studyProgram: e.target.txt3.value}),
            this.setState({index: e.target.txt4.value})

            // name: e.target.txt1.value,
            // lastName: e.target.txt2.value,
            // studyProgram: e.target.txt3.value,
            // index: e.target.txt4.value
        );

        console.log(e.target.txt1.value);
        console.log(e.target.txt2.value);
        console.log(e.target.txt3.value);
        console.log(e.target.txt4.value);
    }

    render() {
        let sp =  this.props.student.studyProgram != null ? this.props.student.studyProgram.name : '';
        console.log('Editing: ' + sp);
        return (
            <form onSubmit={this.onFormSubmit}>
            <div>
                <div>
                    <input type={"text"} id={"txt1"} defaultValue={this.props.student.name}/>
                </div>
                <div>
                    <input type={"text"} id={"txt2"} defaultValue={this.props.student.lastName}/>
                </div>
                <div>
                    <input type={"text"} id={"txt3"} defaultValue={this.props.student.index}/>
                </div>
                <div>
                    <input type={"text"} id={"txt4"} defaultValue={sp}/>
                </div>
                <div>
                    <button type={"submit"}>Edit</button>
                </div>
            </div>
            </form>
        );
    }
}