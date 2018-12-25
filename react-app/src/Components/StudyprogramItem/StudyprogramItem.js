import React from 'react';

export default class StudyprogramItem extends React.Component{

    render() {
        return (
            <li onClick={this.handleEvent} key={"this.props.studyprogram.id"} className="list-group-item">
                <div className="container">
                    <div className="col-sm">
                        {this.props.studyprogram.name}
                    </div>
                </div>
            </li>
        );
    }

}