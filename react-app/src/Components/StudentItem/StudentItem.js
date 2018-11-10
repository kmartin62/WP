import React from 'react'

export default class StudentItem extends React.Component{

    render() {
        return (
            <li key={"this.props.students.studentId"} className="list-group-item" onClick={this.props.onclick}>
            <div className="container">
                <div className="row">
                    <div className="col-sm" >
                        {this.props.student.name}
                    </div>
                    <div className="col-sm">
                        {this.props.student.surname}
                    </div>
                </div>
            </div>
            </li>
        );
    }
}