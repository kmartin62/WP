import React from 'react'

export default class Sibiling extends React.Component{
    render() {
        return (
            <div>
                <h1>Hey my name is {this.props.name}!</h1>
            </div>
        );
    }
}