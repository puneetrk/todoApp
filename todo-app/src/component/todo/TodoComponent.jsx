import React, {Component} from 'react'
import { Formik, Form, Field, ErrorMessage } from 'formik';
import moment from 'moment';
import TodoDataService from '../../api/todo/TodoDataService.js'
import AuthenticationService from './AuthenticationService.js';

class TodoComponent extends Component {

    constructor(props){
        super(props)
        this.state = {
            id : this.props.match.params.id,
            description : '',
            label : '',
            taskStatus : '',
            targetDate : moment(new Date()).format('YYYY-MM-DD')
        }

        this.onSubmit = this.onSubmit.bind(this)
        this.validate = this.validate.bind(this)
        
    }

    componentDidMount(){

        if(this.state.id===-1){
            return
        }            
        let username = AuthenticationService.getLoggedInUser();
        TodoDataService.retrieveUserTodoById(username,this.state.id)
        .then(
            response => this.setState({
                description : response.data.description,
                label : response.data.label,
                taskStatus : response.data.taskStatus,
                targetDate : moment(response.data.targetDate).format('YYYY-MM-DD')
            }) 
        )
    }
    validate(values){
        console.log('validate')
        let errors={}
        if(!values.description){
            errors.description = 'Enter a desciprion'
        } else if(values.description.length < 5)
        {
            errors.description = 'desciprion shall be atleast 5 characters'
        }

        if(!moment(values.targetDate).isValid()){
            errors.targetDate = "Enter Valid TargetDate"
        }
        return errors
    }
    onSubmit(values){
        console.log('onSubmit')
        let username = AuthenticationService.getLoggedInUser();
        if(this.state.id===-1){
            TodoDataService.createUserTodo(username,{
                description : values.description,
                label : values.label,
                taskStatus : values.taskStatus,
                targetDate : values.targetDate
            })
            .then( () => {this.props.history.push('/todos')})

        }else {
            TodoDataService.updateUserTodo(username,this.state.id,{
                id : this.state.id,
                description : values.description,
                label : values.label,
                taskStatus : values.taskStatus,
                targetDate : values.targetDate
            })
            .then( () => {this.props.history.push('/todos')})

        }
        
        
    }
    render()
    {
        let {description,label,taskStatus,targetDate} = this.state
        return (
            <div>
                <h1>Todo</h1>
                <div className='container'>
                    <Formik
                        initialValues={{
                            description,
                            label,
                            taskStatus,
                            targetDate
                        }}
                        
                        onSubmit = {this.onSubmit}
                        validate = {this.validate}
                        validateOnChange={false}
                        validateOnBlur={false}
                        enableReinitialize={true}>
                        {
                            (props) => (
                                <Form>
                                    <ErrorMessage name="description" component="div" className="alert alert-warning"/>
                                    <ErrorMessage name="targetDate" component="div" className="alert alert-warning"/>
                                    <fieldset className="form-group">
                                        <label>Description</label>
                                        <Field className="form-control" type="text" name="description"/>
                                    </fieldset>
                                   
                                    <fieldset className="form-group">
                                        <label for="select1">Labels:</label>
                                        <Field className="form-control" component="select" name="label">
                                        <option value="">select</option>
                                            <option value="Personal">Personal</option>
                                            <option value="Work">Work</option>
                                            <option value="Shopping">Shopping</option>
                                            <option value="Others">Others</option>
                                        </Field>
                                    
                                    </fieldset>
                                    <fieldset className="form-group">
                                        <label for="select1">Status:</label>
                                        <Field className="form-control" component="select" name="taskStatus">
                                        <option value="">select</option>
                                            <option value="New">New</option>
                                            <option value="InProgress">In Progress</option>
                                            <option value="Completed">Completed</option>
                                        </Field>
                                    
                                    </fieldset>
                                    
                                    <fieldset className="form-group">
                                        <label>Due Date</label>
                                        <Field className="form-control" type="Date" name="targetDate"/>
                                    </fieldset>

                                   
                                    <button className="btn btn-success" type="submit">Save</button>
                                </Form>
                            )
                        }
                    </Formik>
                </div>
            
        </div>
        )
        
    }
}

export default TodoComponent;