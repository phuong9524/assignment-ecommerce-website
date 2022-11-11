import React, { useState, useEffect } from "react";
import Skeleton from "react-loading-skeleton";
import { NavLink } from "react-router-dom";
import { useDispatch } from 'react-redux';
import { addCart } from '../../redux/action';

const NewArrivals = () => {
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
      "http://localhost:8110/api/user/products/latest"
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
const ShowProducts = () => {
  return (
    <>
      {data.map((product) => {
        return (
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
                  <NavLink href="#" style={{textDecoration:"none"}}>{product.name}</NavLink>
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
      <section className="section products-main">
        <div className="container">
          <div className="row justify-content-center">
            <div className="col-lg-8">
              <div className="title text-center">
                <h2>New arrivals</h2>
                <p>The best Online sales to shop these weekend</p>
              </div>
            </div>
          </div>

          <div className="row">
          {loading ? <Loading /> : <ShowProducts />}
          </div>
        </div>
      </section>
        
  )
}

export default NewArrivals