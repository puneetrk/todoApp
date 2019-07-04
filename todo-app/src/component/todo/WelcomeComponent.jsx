import React, { Component} from 'react'
import {Link} from 'react-router-dom'
import HelloWorldBeanService from '../../api/todo/HelloWorldBeanService.js'

class WelcomeComponent extends Component {

    constructor(props){
        super(props)

        this.getNewMessage = this.getNewMessage.bind(this)
        this.state = {
            welcomeMessage:'',
            errorMessage:'',
            hasErrorOccured:false

        }
        this.handleSuccussfulResponse = this.handleSuccussfulResponse.bind(this)
        this.handleError = this.handleError.bind(this)

    }
    render(){
        return (
            <>
                <h1>Welcome!</h1>
                <div className="container">
                    {this.state.hasErrorOccured && 
                        <div className="alert alert-warning">{this.state.errorMessage}</div>}
                    
                </div>
                <div className="container">
                    Welcome {this.props.match.params.name} 
                    <br></br>
                    <Link to='/todos'>Manage</Link> your Todo List
                </div>
                
                <div className="container">
                    {this.state.welcomeMessage}
                </div>
            </>
        )
        
    }
    getNewMessage(){
        console.log('Inside getNewMessage')
        HelloWorldBeanService.executeHelloWorldService(this.props.match.params.name)
        .then(response => this.handleSuccussfulResponse(response))
        .catch(error => this.handleError(error))

    }

    handleSuccussfulResponse(response){

        console.log(response)
        this.setState({welcomeMessage : response.data.message})
    }
    handleError(error){

       // console.log(error.response.data.message)
        let errorMessage = ''
        if(error.message)
            errorMessage += error.message
        
        if(error.response && error.response.data){
            errorMessage += error.response.data.message
        }

        this.setState({welcomeMessage : errorMessage})

        // this.setState({
        //     errorMessage : errorMessage,
        //     hasErrorOccured : true
        // })
    }
}

export default WelcomeComponent;