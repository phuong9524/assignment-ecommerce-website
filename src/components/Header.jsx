import { NavLink } from "react-router-dom";
import NewArrivals from "./item/NewArrivals";

function Header() {
  return (
    <div className="home-container">
      <div className="main-slider slider slick-initialized slick-slider">
        <div
          className="slider-item"
          style={{
            backgroundImage: "url('assets/images/banner-1.jpg')",
            backgroundPosition: "50%",
            backgroundRepeat: "no-repeat",
          }}
        >
          <div className="container">
            <div className="row">
              <div className="col-lg-6 col-12 offset-lg-6 offset-md-6">
                <div className="slider-caption">
                  <span className="lead">Trendy shoes</span>
                  <h1 className="mt-2 mb-5">
                    <span className="text-color">Winter </span>Collection
                  </h1>
                  <NavLink
                    to="/products"
                    className="cta"
                    style={{ color: "black",
                              textDecoration: 'none'}}
                  >
                    <span>Shop now</span>
                    <svg width="13px" height="10px" viewBox="0 0 13 10">
                      <path d="M1,5 L11,5"></path>
                      <polyline points="8 1 12 5 8 9"></polyline>
                    </svg>
                  </NavLink>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
      <NewArrivals/>

      {/* <section className="section products-main">
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
            <div className="col-lg-3 col-12 col-md-6 col-sm-6 mb-5">
              <div className="product">
                <div className="product-wrap">
                  <a href="/product">
                    <img
                      className="img-fluid w-100 mb-3 img-first"
                      src="assets/images/322.jpg"
                      alt="product-img"
                    />
                  </a>
                </div>
                <div className="product-hover-overlay">
                  <a href="#">
                    <i className="tf-ion-android-cart"></i>
                  </a>
                  <a href="#">
                    <i className="tf-ion-ios-heart"></i>
                  </a>
                </div>
                <div className="product-info">
                  <h2 className="product-title h5 mb-0">
                    <a href="#">Floral Kirby</a>
                  </h2>
                  <span className="price">$329.10</span>
                </div>
              </div>
            </div>
          </div>
        </div>
      </section> */}

      <section className="section">
      <div className="container">
      <div className="bg-image" 
      style={{
      backgroundImage: "url('assets/images/counter.jpg')",
      height: "400px",
      
      }}>
      
      </div>
      
      </div>
      </section>
     
      <section className="section products-list">
        <div className="container">
          <div className="row">
            <div className="col-sm-3">
              <div className="card">
                <img src="assets/images/ad1.jpg" className="card-img-top" alt="..."></img>
                <div className="card-body">
                  <h5 className="card-title">ULTRABOOTS SIZE GUIDE</h5>
                  <p className="card-text">
                  Upgrade your runs with the adidas Ultraboost. Read our size guide to discover the differences between each Ultraboost version to find the perfect shoe for you.
                  </p>
                  <a href="#" className="btn btn-primary">
                  Learn more
                  </a>
                </div>
              </div>
            </div>
            <div className="col-sm-3">
              <div className="card">
              <img src="assets/images/ad-3.jpg" className="card-img-top" alt="..."></img>
                <div className="card-body">
                  <h5 className="card-title">BEST SHOES FOR THE GYM</h5>
                  <p className="card-text">
                  Find out what shoes are actually best for your gym workouts with adidas top picks. Should choose what you like and comfortable.
                  </p>
                  <a href="#" className="btn btn-primary ">
                    Learn more
                  </a>
                </div>
              </div>
            </div>
            <div className="col-sm-3">
              <div className="card">
                <img src="assets/images/ad-2.jpg" className="card-img-top" alt="..."></img>
                <div className="card-body">
                  <h5 className="card-title">FORUM SIZE GUIDE</h5>
                  <p className="card-text">
                  Curious about where to start with adidas Forum sizing? Look no further to learn about how the iconic sneakers fit before even trying them on.
                  </p>
                  <a href="#" className="btn btn-primary">
                  Learn more
                  </a>
                </div>
              </div>
            </div>
            <div className="col-sm-3">
              <div className="card">
                <img src="assets/images/ad-4.jpg" className="card-img-top" alt="..."></img>
                <div className="card-body">
                  <h5 className="card-title">HOW TO CHOOSE RUNNING SHOES</h5>
                  <p className="card-text">
                  Wondering how to choose the right running shoes? Team up with adidas and use our running shoe finder to choose your ideal running shoe.
                  </p>
                  <a href="#" className="btn btn-primary">
                  Learn more
                  </a>
                </div>
              </div>
            </div>
      
          </div>
        </div>
      </section>
    </div>
  );
}
export default Header;
