import React, { useState, useEffect } from 'react';
import {useNavigate} from 'react-router-dom';

function Login() {
    const [username, setUsername] = useState("");
    const [password, setPassword] = useState("");
    const [islogin, setIsLogin] = useState(false);

    const history = useNavigate();
    useEffect(() => {
        if (localStorage.getItem('user-info')) {
            history("/", {type: islogin})
        }
    }, [history])

    async function login() {
        let item = {username, password};
        let result = await fetch("http://localhost:8110/api/user/auth/signin", {
            method: 'POST',
            headers: {
                "Content-Type": "application/json",
                "Accept":'application/json'
            },
            body: JSON.stringify(item)
        });
        result = await result.json();
        localStorage.setItem("user-info",JSON.stringify(result))
        setIsLogin(true);
        history("/", {type: islogin})
    }

    

    return (
        <div className="login-container">
            <div className="account section">
                <div className="container">
                <div className="row justify-content-center">
                    <div className="col-lg-6">
                    <div className="login-form border p-5">
                        <div className="text-center heading">
                        <h2 className="mb-2">Login</h2>
                        <p className="lead">Don’t have an account? <a href="/register" style={{color:'#fb5c42'}}>Create a free account</a></p>
                        </div>
            
                        <form action="#">
                        <div className="form-group mb-4">
                            <label for="#">Enter Username</label>
                            <input onChange={(e) => setUsername(e.target.value)} type="text" className="form-control" placeholder="Enter Username" />
                        </div>
                        <div className="form-group">
                            <label for="#">Enter Password</label>
                            <a className="float-right" href="" style={{color:'#fb5c42'}}>Forget password?</a>
                            <input onChange={(e) => setPassword(e.target.value)} type="password" className="form-control" placeholder="Enter Password" /> 
                        </div>
            
                        <a onClick={login} className="btn btn-main mt-3 btn-block" style={{backgroundColor:'#fb5c42'}}>Login</a>
                        </form>
                    </div>
                    </div>
                </div>
                </div>
            </div>
        </div>
    )
}
export default Login