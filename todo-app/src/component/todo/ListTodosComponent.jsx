import React, { Component} from 'react'
import AuthenticationService from './AuthenticationService';
import TodoDataService from '../../api/todo/TodoDataService';
import moment from 'moment'

class ListTodosComponent extends Component {

    constructor(props)
    {
        console.log('constructor')
        super(props)
        this.state = {
            todos : [],
            message : null
        }

        this.deleteUserTodo = this.deleteUserTodo.bind(this)
        this.refreshTodos = this.refreshTodos.bind(this)
        this.updateUserTodo = this.updateUserTodo.bind(this)
        this.createUserTodo = this.createUserTodo.bind(this)
    }

    // Mount the details after constructor
    componentDidMount() {
        console.log('componentDidMount')
        this.refreshTodos()
    }

    refreshTodos(){

        let username = AuthenticationService.getLoggedInUser()
        TodoDataService.retrieveAllTodos(username)
        .then(
            response => {
                console.log(response)
                this.setState( {todos : response.data})
            }
        )
    }

    componentWillUnmount(){
        console.log('componentWillUnmount')
    }

    shouldComponentUpdate(nextProps,nextState){
        console.log('shouldComponentUpdate')
        // console.log(nextProps)
        // console.log(nextState)
        return true
    }
 
    deleteUserTodo(id) {
        
        let username = AuthenticationService.getLoggedInUser()
        TodoDataService.deleteUserTodo(username,id)
        .then(
            response => {

                this.setState({message :`Delete of todo-${id} successful`})
                this.refreshTodos();
            }
            
        )
    }

    updateUserTodo(id) {
        
        // console.log(`Id: ${id}`)
        this.props.history.push(`todos/${id}`)
        
    }

    createUserTodo(){
        console.log('createUserTodo')
        this.props.history.push('/todos/-1')
    }

    render(){
        console.log('render')
        return (<div>
            <h1>Todo List</h1>
            {this.state.message && <div className='alert alert-success'>{this.state.message}</div>}
            <div className="container">
                <table className="table">
                    <thead>
                        <tr>
                            <th>Label</th>
                            <th>Description</th>
                            <th>Status</th>
                            <th>Due Date</th>
                            <th>Update</th>
                            <th>Delete</th>

                        </tr>
                    </thead>
                    <tbody>
                        {
                            this.state.todos.map(
                                todo => 
                                    <tr key={todo.id}>
                                        <td>{todo.label}</td>
                                        <td>{todo.description}</td>
                                        <td>{todo.taskStatus}</td>
                                        <td>{moment(todo.targetDate).format('YYYY-MM-DD')}</td>
                                        <td><button className="btn btn-success" onClick={() => this.updateUserTodo(todo.id)} >Update</button></td>
                                        <td><button className="btn btn-warning" onClick={() => this.deleteUserTodo(todo.id)} >Delete</button></td>
                                    </tr>
                            )

                        }
                        
                    </tbody>
                </table>
            </div>
            <div className="row">
                <button className='btn btn-success' onClick={this.createUserTodo} >Add</button>
            </div>
            
        </div>)
    }
}

export default ListTodosComponent