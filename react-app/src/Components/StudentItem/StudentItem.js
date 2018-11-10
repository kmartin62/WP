import React from 'react'


export default class StudentItem extends React.Component {

    constructor(props) {
        super(props);
    }

    render() {
        return (
            <div className="container">
                <div className="row">
            <div className="col-sm">{this.props.student.Ime}</div>
            <div className="col-sm">{this.props.student.Prezime}</div>
            <div className="col-sm">{this.props.student.Nasoka}</div>
                    <div className="col-sm">{this.props.student.Indeks}</div>
                </div>
            </div>
    );


    }
}