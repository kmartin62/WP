import React from 'react'

export default class StudentItem extends React.Component{

    constructor(props) {
        super(props);
        this.handleEvent = this.handleEvent.bind(this);
    }


    handleEvent = () => {
        this.props.changeBoolean();
    }

    render() {

        return (
                <li onClick={this.handleEvent} key={"this.props.student.Indeks"} className="list-group-item">
                    <div className="container">
                    <div className="col-sm">
                    {this.props.student.Ime}
                    </div>
                        <div className="col-sm">
                    {this.props.student.Prezime}
                        </div>
                    </div>
                </li>
        );
    }
}