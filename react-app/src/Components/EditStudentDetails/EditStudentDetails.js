import React from 'react'
// import StudentList from '../StudentList/StudentList.js'

export default class EditStudentDetails extends React.Component{

    constructor(props) {
        super(props);

        this.state = {
            s1: this.props.student.name
        }
    }


    render() {
        return (
            <form>
                <div className="wrapper">
                    <div className="row">
                        <div className="col-md-3">
                            <input name={"name"} value={this.props.s.name} type={"text"} className="form-control" />
                        </div>

                        <div className="col-md-3">
                            <input name={"surname"} defaultValue={this.props.student.surname} type={"text"} className="form-control" />
                        </div>

                        <div className="col-md-3">
                            <input name={"major"} type={"text"} className="form-control" />
                        </div>

                        <div className="col-md-3">
                            <input name={"indeks"} defaultValue={this.props.student.indeks} type={"text"} className="form-control" />
                        </div>
                        <div className="col-md-3">
                            <button type={"submit"} className="btn btn-outline-danger">Edit</button>
                        </div>

                    </div>
                </div>
            </form>
        );
    }
}