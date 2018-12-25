const url = "http://localhost:8080/students"

export const getStudents = () => {
    return fetch(url);
};

export const createStudent = (student) => {
    return fetch(url, {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify({
            name: student.name,
            studyProgram:  student.studyProgram.name
            
        })
    });
};

export const updateStudent = (student) => {
    return fetch(url + "/" + student.index, {
        method: "PATCH"
    })
};

export const deleteStudent = (student) => {
    return fetch(url + "/" + student.index, {
        method: "DELETE",
        headers: {
            "Content-Type":"application-json"
        }
    })
};