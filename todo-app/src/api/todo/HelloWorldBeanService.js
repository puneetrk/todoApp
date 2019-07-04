import axios from "axios";

class HelloWorldBeanService {

    executeHelloWorldService(name) {

        console.log('executed service')
        return axios.get(`http://localhost:8080/hello-world/user/${name}`)
    }




}

export default new HelloWorldBeanService()