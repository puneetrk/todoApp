import axios from 'axios'
import {API_URL}  from '../../Constants'

export const USER_NAME_SESSION_ATTRIBUTE_NAME = 'authenticatedUser'

class AuthentificationService {

    executeBasicAuthService(username,password)
    {
        let basicAuthHeader = this.createaBasicAuthToken(username,password)

        return axios.get(`${API_URL}/basicauth`,{
            headers : {
                authorization : basicAuthHeader
            }
        })
    }

    executeJwtAuthService(username,password)
    {
          return axios.post(`${API_URL}/authenticate`,{
            username,
            password
        })
    }

    createaBasicAuthToken(username,password){
        let basicAuthHeader = 'Basic '+window.btoa(username+":"+password)
        return basicAuthHeader

    }
    registerSuccessfullLogin(username,password)
    {
        let basicAuthHeader = this.createaBasicAuthToken(username,password)
        
        sessionStorage.setItem(USER_NAME_SESSION_ATTRIBUTE_NAME,username);
        this.setUpAxiosInterceptors(basicAuthHeader)
    }

    registerSuccessfullLoginForJwt(username,token)
    {
        sessionStorage.setItem(USER_NAME_SESSION_ATTRIBUTE_NAME,username);
        this.setUpAxiosInterceptors(this.createJwtToken(token))
    }

    createJwtToken(token){
        return 'Bearer '+token
    }

    logout(){

        sessionStorage.removeItem(USER_NAME_SESSION_ATTRIBUTE_NAME);
    }

    isUserLoggedIn(){
        let user = sessionStorage.getItem(USER_NAME_SESSION_ATTRIBUTE_NAME)
        if(user===null)
            return false;
        return true;
    }

    getLoggedInUser(){
        let user = sessionStorage.getItem(USER_NAME_SESSION_ATTRIBUTE_NAME)
        if(user===null)
            return '';
        return user;
    }

    setUpAxiosInterceptors(token){

        axios.interceptors.request.use(
            (config) => {
                if(this.isUserLoggedIn()){
                    config.headers.authorization = token
                }
                return config

            }
        )
    }
}

export default new AuthentificationService()