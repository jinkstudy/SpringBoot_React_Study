import axios from "axios";
import { GET_ERRORS, GET_PROJECT_TASKS } from './types'

//새로운 project추가  with error 핸들링
export const addProjectTask = (project_task, history) => async dispatch => {
    try {
        await axios.post("http://localhost:8080/api/board", project_task);
        history.push("/");
        dispatch({
            type: GET_ERRORS,
            payload: {}
        })
    } catch (error) {
        console.log(error.response)
        dispatch({
            type: GET_ERRORS,
            payload: error.response.data
        })
    }

}

//목록 가져오기
export const getBacklog = () => async dispatch => {
    const res = await axios.get("http://localhost:8080/api/board/all")
    console.log(res)
    dispatch({
        type: GET_PROJECT_TASKS,
        payload: res.data
    })
}