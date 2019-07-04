import React, { Component} from 'react'
import AuthenticationService from './AuthenticationService'

class LoginComponent extends Component {

    constructor(props){
        super(props)

        this.state = {
            username : 'puneet',
            password : '',
            hasloginFailed : false,
            showSuccessMsg : false
        }

        this.handleChange = this.handleChange.bind(this);
        this.loginClicked = this.loginClicked.bind(this);
    }
    render() {
        return (
            <div>
                {this.state.hasloginFailed && <div className="alert alert-warning">Invalid Credentials</div>}
                {/*this.state.showSuccessMsg && <div>Logged in successfully </div>*/}
                <h1>Login</h1>
                <div className="container">
                    UserName: <input type='text' name='username' value={this.state.username} onChange={this.handleChange}/>
                    Password: <input type='password' name='password' value={this.state.password} onChange={this.handleChange} />
                    <button className="btn btn-success" onClick={this.loginClicked}>Login</button>
               </div>

            </div>
        )
    }

    loginClicked(){

       AuthenticationService.executeJwtAuthService(this.state.username,this.state.password)
        .then((response) =>{
            AuthenticationService.registerSuccessfullLoginForJwt(this.state.username,response.data.token);
            this.props.history.push(`/welcome/${this.state.username}`)
        })
        .catch( () => {
            this.setState({
                hasloginFailed:true,
                showSuccessMsg : false
                })

        }
            )

    }

   handleChange(event){

        console.log(event.target);
        this.setState(
            {
                [event.target.name] : event.target.value
            }
        )

    }

    handlePasswordChange(event){

        console.log(event.target.value);
        this.setState({
            password : event.target.value
        })

    }
}

export default LoginComponent;