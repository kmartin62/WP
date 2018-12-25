import React from 'react'

export default class StudentManager extends React.Component{


    constructor(props) {
        super(props);

    }


    onFormSubmit = (e) => {

        if(document.getElementById("txt1").value === "" || document.getElementById("txt2").value === "" ||
            document.getElementById("txt3").value === "" || document.getElementById("txt4").value === ""){
            e.preventDefault();
            return;
        }

        e.preventDefault();

        this.props.onNewStudent({
            name: e.target.name.value,
            lastName: e.target.lastName.value,
            studyProgram: e.target.studyProgram.value,
            index: e.target.index.value
        });

        console.log(e.target.name.value);
        console.log(e.target.lastName.value);
        console.log(e.target.studyProgram.value);
        console.log(e.target.index.value);

    }

    render() {

        const renderButton = () => {
            return (
                <button type={"submit"} className="btn btn-group-lg">Add</button>
            );
        }

        return (
            <form onSubmit={this.onFormSubmit}>
                <div className="wrapper">
                    <div className="row">
                        <div className="col-md-3">
                            <input id={"txt1"} name={"name"} placeholder={"Vnesi ime"} type={"text"} className="form-control" />
                        </div>

                        <div className="col-md-3">
                            <input id={"txt2"} name={"lastName"} placeholder={"Vnesi prezime"} type={"text"} className="form-control" />
                        </div>

                        <div className="col-md-3">
                            <input id={"txt3"} name={"studyProgram"} placeholder={"Vnesi nasoka"} type={"text"} className="form-control" />
                        </div>

                        <div className="col-md-3">
                            <input id={"txt4"} name={"index"} placeholder={"Vnesi indeks"} type={"text"} className="form-control" />
                        </div>

                        <div className="col-md-4">
                            {renderButton()}
                        </div>

                    </div>

                </div>
            </form>
        );
    }


}