import axios from 'axios';
import React, {useState} from 'react';
import { useNavigate  } from 'react-router-dom';

function SignUp() {
    const [username, setName] = useState("")
    const [password, setPassword] = useState("")
    const [email, setEmail] = useState("")
    const history = useNavigate
    
    async function signup() {

        let item={username,email,password};
        console.warn(item);

        await axios.post("http://localhost:8110/api/auth/user/signup",
            item);

        history.push("/add");
    }
    return (
        <div className="signUp-container">
            <div className="account section">
                <div className="container">
                <div className="row justify-content-center">
                    <div className="col-lg-6">
                    <div className="login-form border p-5">
                        <div className="text-center heading">
                        <h2 className="mb-2">Sign Up</h2>
                        <p className="lead">Already have an account? <a href="/login" style={{color:'#fb5c42'}}> Login now</a></p>
                        </div>
            
                        <form action="#" className='form'>
                        <div className="form-group mb-4">
                            <label for="#">Enter Email Address</label>
                            <input value={email} onChange={(e) => setEmail(e.target.value)} type="text" className="form-control" placeholder="Enter Email Address"/>
                        </div>
                        <div className="form-group mb-4">
                            <label for="#">Enter username</label>
                            <input value={username} onChange={(e) => setName(e.target.value)} type="text" className="form-control" placeholder="Enter Username"/> 
                        </div>
                        <div className="form-group mb-4">
                            <label for="#">Enter Password</label>
                            <input value={password} onChange={(e) => setPassword(e.target.value)} type="password" className="form-control" placeholder="Enter Password"/> 
                        </div>
                        <div className="form-group">
                            <label for="#">Confirm Password</label>
                            <input type="password" className="form-control" placeholder="Confirm Password" /> 
                        </div>
            
                        <a onClick={signup} className="btn btn-main mt-3 btn-block" style={{backgroundColor:'#fb5c42'}}>Signup</a>
                        </form>
                    </div>
                    </div>
                </div>
                </div>
            </div>
        </div>
    )
}
export default SignUp