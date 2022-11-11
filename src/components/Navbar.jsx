import React from "react";
import { NavLink } from "react-router-dom";
import { useSelector } from "react-redux";
import {useNavigate} from 'react-router-dom';

const Navbar = () => {
  
  const state = useSelector((state) => state.handleCart)
  const userInfo = JSON.parse(localStorage.getItem('user-info'))
  const history = useNavigate();

  function isAdmin() {
    if (userInfo !== null) {
      if (userInfo.hasOwnProperty["username"] !== false) {
        if (userInfo['roles'].includes("ROLE_ADMIN") === true){
          return <NavLink to="/admin" className="btn btn-outline-dark ms-2" >
                    <i className="fa fa-arrow-circle-o-right"></i> Admin
                  </NavLink>
        }
      }
    } 
  }


  const logout = () => {
    localStorage.removeItem('user-info');
    history("/")
  }

  function IsLogin() {
    if (userInfo !== null) {
      if (userInfo.hasOwnProperty['username'] !== false) {
               return <a onClick={logout} className="btn btn-outline-dark">
               <i className="fa fa-sign-out me-1"></i> Logout
               </a>
      }
    }
    return  <NavLink to="/login" className="btn btn-outline-dark ">
                <i className="fa fa-sign-in me-1"></i> Login
              </NavLink>
     
    }
  return (
    <div>
      <nav className="navbar navbar-expand-lg navbar-light bg-white w-100 navigation" id="navbar">
        <div className="container">
          <NavLink className="navbar-brand fw-bold fs-4" to="/">
            WINTER COLLECTION
          </NavLink>
          <button
            className="navbar-toggler"
            type="button"
            data-bs-toggle="collapse"
            data-bs-target="#navbarSupportedContent"
            aria-controls="navbarSupportedContent"
            aria-expanded="false"
            aria-label="Toggle navigation"
          >
            <span className="navbar-toggler-icon"></span>
          </button>
          <div className="collapse navbar-collapse" id="navbarSupportedContent">
            <ul className="navbar-nav mx-auto mb-2 mb-lg-0">
              <li className="nav-item">
                <NavLink className="nav-link active" aria-current="page" to="/">
                  Home
                </NavLink>
              </li>
              <li className="nav-item">
                <NavLink className="nav-link" to="/products">
                  Products
                </NavLink>
              </li>
              <li className="nav-item">
                <NavLink className="nav-link" to="/about">
                  About
                </NavLink>
              </li>
              <li className="nav-item">
                <NavLink className="nav-link" to="/contact">
                  Contact
                </NavLink>
              </li>
            </ul>
            <div className="buttons">
                {IsLogin()}
                <NavLink to="/register" className="btn btn-outline-dark ms-2">
                    <i className="fa fa-user-plus me-1"></i> Register
                </NavLink>
                <NavLink to="/cart" className="btn btn-outline-dark ms-2">
                    <i className="fa fa-shopping-cart me-1"></i> Cart ({state.length})
                </NavLink>
                {isAdmin()}
                
            </div>
          </div>
        </div>
      </nav>
    </div>
  );
};

export default Navbar;
