const url = "http://localhost:8080/study_programs"

export const getStudyPrograms = () => {
    return fetch(url);
}


// export const onNewStudyProgram = (studyProgram) => {
//     return fetch(url, {
//         method: "POST",
//         headers: {
//             "Content-Type": "application/json"
//         },
//         body: JSON.stringify({
//             name: studyProgram.name
//         })
//     })
// }

export const deleteStudyProgram = (studyProgram) => {
    return fetch(url + "/" + studyProgram.id, {
        method: "DELETE",
        headers: {
            "Content-Type": "application/json"
        }
    })
};