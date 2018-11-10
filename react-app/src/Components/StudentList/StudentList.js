import React from 'react'
import StudentItem from "../StudentItem/StudentItem";

export default class StudentList extends React.Component{

    constructor(props){
        super(props);
    }

    render(){

        const listItems = this.props.items.map((item, index) => {
            return (
                <StudentItem key={index} item={item}/>
            )
        })


        return (
            <div>
                <ul>
                    {listItems}
                </ul>
            </div>
        )

    }

}