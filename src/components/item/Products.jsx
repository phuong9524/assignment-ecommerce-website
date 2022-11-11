import React, { useState, useEffect } from "react";
import Skeleton from "react-loading-skeleton";
import { NavLink } from "react-router-dom";
import { useDispatch } from 'react-redux';
import { addCart } from '../../redux/action';

const Products = () => {

  const dispatch = useDispatch();
    const addProduct = (product) => {
        dispatch(addCart(product));
    }

  const [data, setData] = useState([]);
  const [filter, setFilter] = useState(data);
  const [loading, setLoading] = useState(false);
  let componentMounted = true;

  useEffect(() => {
    const getProducts = async () => {
      setLoading(true);
      const respone = await fetch(
        "http://localhost:8110/api/user/products/get?pageNumber=0"
      );
      if (componentMounted) {
        setData(await respone.clone().json());
        setFilter(await respone.json());
        setLoading(false);
        console.log(filter);
      }

      return () => {
        componentMounted = false;
      };
    };

    getProducts();
  }, []);

  const Loading = () => {
    return  (
    <>
        <div className="col-md-3">
            <Skeleton height={350}/>
        </div>
        <div className="col-md-3">
            <Skeleton height={350}/>
        </div>
        <div className="col-md-3">
            <Skeleton height={350}/>
        </div>
        <div className="col-md-3">
            <Skeleton height={350}/>
        </div>
    </>
    );
  };

  const filterProduct = (cat) => {
    const updatedList = data.filter((x) =>x.categoryName === cat);
    setFilter(updatedList);
  }


  const ShowProducts = () => {
    return (
      <>
        <div className="buttons d-flex justify-content-center mb-5 pb-5">
          <button className="btn btn-outline-dark me-2" onClick={() =>setFilter(data)}>New Shoes</button>
          <button className="btn btn-outline-dark me-2" onClick={() =>filterProduct("Men")}>Men's Shoes</button>
          <button className="btn btn-outline-dark me-2" onClick={() =>filterProduct("Women")}>Women's Shoes</button>
          <button className="btn btn-outline-dark me-2" onClick={() =>filterProduct("Kids")}>Kids's Shoes</button>
        </div>
        {filter.map((product) => {
        
          return (
            // <>
            //   <div className="col-md-3 mb-4">
            //     <div className="card h-100 text-center p-4" key={product.id}>
            //       <img src={product.image} className="card-img-top" alt={product.name} height="200" />
            //       <div className="card-body">
            //         <h5 className="card-title mb-0">{product.name?.substring(0,12)}...</h5>
            //         <p className="card-text lead fw-bold">
            //           ${product.price}
            //         </p>
            //         <NavLink to={`/${product.id}`} className="btn btn-outline-dark">
            //           Buy now
            //         </NavLink>
            //       </div>
            //     </div>
            //   </div>
            // </>
            <>
            <div className="col-lg-3 col-12 col-md-6 col-sm-6 mb-5">
              <div className="product">
                <div className="product-wrap">
                  <NavLink to={`/${product.id}`}>
                    <img
                      className="img-fluid w-100 mb-3 img-first"
                      src={product.image}
                      alt="product-img"
                      width="600px"
                      height="600px"
                    />
                  </NavLink>
                </div>
                <div className="product-hover-overlay">
                  <NavLink href="#" onClick={() =>addProduct(product)}>
                    <i className="tf-ion-android-cart"></i>
                  </NavLink>
                  <NavLink href="#">
                    <i className="tf-ion-ios-heart"></i>
                  </NavLink>
                </div>
                <div className="product-info">
                  <h2 className="product-title h5 mb-0">
                    <NavLink to={`/${product.id}`} style={{textDecoration:"none"}}>{product.name}</NavLink>
                  </h2>
                  <span className="price card-text lead fw-bold">${product.price}</span>
                </div>
              </div>
            </div>
          </>
          );
        })}
      </>
    );
  };

  return (
    // <div>
    //   <div className="container my-5 py-5">
    //     <div className="row">
    //       <div className="col-12 mb-5">
    //         <h1 className="display-6 fw-bolder text-center">Latest Product</h1>
    //         <hr></hr>
    //       </div>
    //     </div>
    //     <div className="row justify-content-center">
    //       {loading ? <Loading /> : <ShowProducts />}
    //     </div>
    //   </div>
    // </div>
    <section className="section products-main">
    <div className="container">
      <div className="row justify-content-center">
        <div className="col-lg-8">
          <div className="display-6 fw-bolder text-center">
            <h1>Latest Product</h1>
            <hr></hr>
          </div>
        </div>
      </div>

      <div className="row">
      {loading ? <Loading /> : <ShowProducts />}
      </div>
    </div>
  </section>
  );
};

export default Products;
