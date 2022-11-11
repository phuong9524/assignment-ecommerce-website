import React from "react";
import Header from "./Header";

const Home = () => {
  return (
    <div className="hero">
      {/* <div className="card bg-dark text-white border-0">
        <img src="/assets/images/slideshow1-3.jpg" className="card-img" alt="Background" height="550px" />
        <div className="card-img-overlay d-flex flex-column justify-content-center">
            <div className="container">
                <h5 className="card-title display-3 fw-bolder mb-0">NEW SEASON ARRIVALS</h5>
                <p className="card-text">
                    CHECK OUT ALL THE TRENDS
                </p>
            </div>
        </div>
      </div> */}
      <Header/>
    </div>
  );
};

export default Home;
