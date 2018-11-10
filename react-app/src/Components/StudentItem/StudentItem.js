import React from 'react'


export default class StudentItem extends React.Component {



    render() {
        return (
            <li key="{this.props.student.Indeks}" className="list-group-item">
            <div className="container">
                <div className="row">
            <div className="col-sm">{this.props.student.Ime}</div>
            <div className="col-sm">{this.props.student.Prezime}</div>
            {/*<div className="col-sm">{this.props.item.Nasoka}</div>*/}
                    {/*<div className="col-sm">{this.props.item.Indeks}</div>*/}
                </div>
            </div>
        </li>
    );


    }
}