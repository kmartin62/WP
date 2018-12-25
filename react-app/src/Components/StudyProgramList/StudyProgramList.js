import React from 'react';
import StudyprogramItem from '../StudyprogramItem/StudyprogramItem.js'

export default class StudyProgramList extends React.Component{

    render() {
        return (
            <div>
                {this.props.studyprogram.map((item, id) => {

                    // const selectObject = () => {
                    //     this.props.changeBoolean(item)
                    //     console.log(item)
                    // }

                    return(<StudyprogramItem key={id} studyprogram={item}/>)
                })}
            </div>
        );
    }


}