import "./App.css";
import Home from "./components/Home";
import Navbar from "./components/Navbar";
import { Routes , Route, useParams } from "react-router-dom";
import Products from "./components/item/Products";
import Product from "./components/item/Product";
import Footer from "./components/Footer";
import Login from "./components/auth/Login";
import SignUp from "./components/auth/Signup";
import { Component, useState } from "react";
import Admin from "./components/admin/Admin";
import ManageProduct from "./components/manage-product/ManageProduct";
import Category from "./components/admin/Category";
import Customer from "./components/users/Customer";


function App() {

  const ProductWrapper = ({products}) => {
    const {id} = useParams();
    return <Product data={products[id]}/>
  }
  const [showNav, setShowNav] = useState(true);
  
  return (
    <>
    { showNav &&
      <Navbar />
    }
      <Routes >
        <Route path="/" element={<Home/>} />
        <Route path="/products" element={<Products/>} />
        <Route path="/:id" element={<ProductWrapper products={'products'} />} />
        <Route path="/login" element={<Login/>}/>
        <Route path="/register" element={<SignUp />}/>
        <Route path="/admin"  element={<Admin funcNav={setShowNav}/>}/>
        <Route path="/manage-product" element={<ManageProduct/>}/>
        <Route path="/category" element={<Category/>}/>
        <Route path="/customer" element={<Customer/>}/>
      </Routes >
      {showNav &&
        <Footer/>
      } 
    </>
  );
}


export default App;
