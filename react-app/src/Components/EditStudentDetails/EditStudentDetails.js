import React from 'react'

export default class EditStudentDetails extends React.Component{

    render() {
        return (
            <form>
            <div>
                <div>
                    <input type={"text"} id={"txt1"} defaultValue={this.props.student.Ime}/>
                </div>
                <div>
                    <input type={"text"} id={"txt2"} defaultValue={this.props.student.Prezime}/>
                </div>
                <div>
                    <input type={"text"} id={"txt3"} defaultValue={this.props.student.Indeks}/>
                </div>
                <div>
                    <input type={"text"} id={"txt4"} defaultValue={this.props.student.Nasoka}/>
                </div>
                <div>
                    <button type={"submit"}>Click</button>
                </div>
            </div>
            </form>
        );
    }
}