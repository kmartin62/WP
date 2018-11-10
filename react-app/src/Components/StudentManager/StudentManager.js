import React from 'react'

export default class StudentManager extends React.Component{



    onFormSubmit = (e) => {

        if(document.getElementById("txt1").value === "" || document.getElementById("txt2").value === "" ||
            document.getElementById("txt3").value === "" || document.getElementById("txt4").value === ""){
            e.preventDefault();
            return;
        }

        e.preventDefault();

        this.props.onNewStudent({
            Ime: e.target.Ime.value,
            Prezime: e.target.Prezime.value,
            Nasoka: e.target.Nasoka.value,
            Indeks: e.target.Indeks.value
        });

        console.log(e.target.Ime.value);
        console.log(e.target.Prezime.value);
        console.log(e.target.Nasoka.value);
        console.log(e.target.Indeks.value);
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
                            <input id={"txt1"} name={"Ime"} placeholder={"Vnesi ime"} type={"text"} className="form-control" />
                        </div>

                        <div className="col-md-3">
                            <input id={"txt2"} name={"Prezime"} placeholder={"Vnesi prezime"} type={"text"} className="form-control" />
                        </div>

                        <div className="col-md-3">
                            <input id={"txt3"} name={"Nasoka"} placeholder={"Vnesi nasoka"} type={"text"} className="form-control" />
                        </div>

                        <div className="col-md-3">
                            <input id={"txt4"} name={"Indeks"} placeholder={"Vnesi indeks"} type={"text"} className="form-control" />
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