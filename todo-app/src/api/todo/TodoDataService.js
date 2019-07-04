import axios from "axios";
import { JPA_API_URL } from '../../Constants'

class TodoDataService {
    retrieveAllTodos(username){
        return axios.get(`${JPA_API_URL}/users/${username}/todos`)
    }

    retrieveUserTodoById(username,id){
        console.log('TodoDataService.deleteUserTodo'+'username'+username+':id:'+id)
        return axios.get(`${JPA_API_URL}/users/${username}/todos/${id}`)
    }

    deleteUserTodo(username,id){
        console.log('TodoDataService.deleteUserTodo'+'username'+username+':id:'+id)
        return axios.delete(`${JPA_API_URL}/users/${username}/todos/${id}`)
    }

    updateUserTodo(username,id,todo){
        console.log('TodoDataService.deleteUserTodo'+'username'+username+':id:'+id)
        return axios.put(`${JPA_API_URL}/users/${username}/todos/${id}`,todo)
    }

    createUserTodo(username,todo){
        console.log('TodoDataService.deleteUserTodo'+'username'+username)
        return axios.post(`${JPA_API_URL}/users/${username}/todos`,todo)
    }
    

}

export default new TodoDataService();