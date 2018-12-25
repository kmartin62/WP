import React from 'react';

export default class StudyProgramManager extends React.Component{

    constructor(props) {
        super(props);

    }


    onFormSubmit = (e) => {
        e.preventDefault();

        this.props.onNewStudyProgram({
            name: e.target.name.value
        })

        console.log(e.target.name.value)

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
                        <div className="col-md-4">
                            {renderButton()}
                        </div>
                    </div>
                </div>
            </form>
        );
    }


}