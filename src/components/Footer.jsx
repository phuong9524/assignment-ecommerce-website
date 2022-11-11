function Footer() {
  return (
    <div className="footer-container">
      <section className="features border-top">
        <div className="container">
          <div className="row">
            <div className="col-lg-3 col-sm-6 col-md-6">
              <div className="feature-block">
                <i className="tf-ion-android-bicycle"></i>
                <div className="content">
                  <h5>Free Shipping</h5>
                  <p>On all order over $39.00</p>
                </div>
              </div>
            </div>
            <div className="col-lg-3 col-sm-6 col-md-6">
              <div className="feature-block">
                <i className="tf-wallet"></i>
                <div className="content">
                  <h5>30 Days Return</h5>
                  <p>Money back Guarantee</p>
                </div>
              </div>
            </div>
            <div className="col-lg-3 col-sm-6 col-md-6">
              <div className="feature-block">
                <i className="tf-key"></i>
                <div className="content">
                  <h5>Secure Checkout</h5>
                  <p>100% Protected by paypal</p>
                </div>
              </div>
            </div>
            <div className="col-lg-3 col-sm-6 col-md-6">
              <div className="feature-block">
                <i className="tf-clock"></i>
                <div className="content">
                  <h5>24/7 Support</h5>
                  <p>All time customer support </p>
                </div>
              </div>
            </div>
          </div>
        </div>
      </section>
      <footer className="footer">
        <div className="container">
          <div className="row">
            <div className="col-md-6 col-lg-4 col-sm-6 mb-5 mb-lg-0 text-center text-sm-left mr-auto">
              <div className="footer-widget">
                <h4 className="mb-4">E-Shop</h4>
                <p className="lead">Everything you need, we have it</p>

                <div className="">
                  <p className="mb-0">
                    <strong>Location : </strong>Ho Chi Minh, Viet Nam
                  </p>
                  <p>
                    <strong>Support Email : </strong> phuong@email.com
                  </p>
                </div>
              </div>
            </div>

            <div className="col-md-6 col-lg-2 col-sm-6 mb-5 mb-lg-0 text-center text-sm-left">
              <div className="footer-widget">
                <h4 className="mb-4">Category</h4>
                <ul className="pl-0 list-unstyled mb-0">
                  <li>
                    <a href="#">Men's Fashion</a>
                  </li>
                  <li>
                    <a href="#">Women's Fashion</a>
                  </li>
                  <li>
                    <a href="#">Kids Fashion</a>
                  </li>
                  <li>
                    <a href="#">Accessories</a>
                  </li>
                  <li>
                    <a href="#">Shoe Collection</a>
                  </li>
                </ul>
              </div>
            </div>

            <div className="col-md-6 col-lg-2 col-sm-6 mb-5 mb-lg-0 text-center text-sm-left">
              <div className="footer-widget">
                <h4 className="mb-4">Useful Link</h4>
                <ul className="pl-0 list-unstyled mb-0">
                  <li>
                    <a href="#">News &amp; Tips</a>
                  </li>
                  <li>
                    <a href="#">About Us</a>
                  </li>
                  <li>
                    <a href="#">Support</a>
                  </li>
                  <li>
                    <a href="#">Our Shop</a>
                  </li>
                  <li>
                    <a href="#">Contact Us</a>
                  </li>
                </ul>
              </div>
            </div>

            <div className="col-md-6 col-lg-3 col-sm-6 text-center text-sm-left">
              <div className="footer-widget">
                <h4 className="mb-4">Opening Hours</h4>
                <ul className="pl-0 list-unstyled mb-5">
                  <li className="d-lg-flex justify-content-between">
                    Monday-Friday <span>8.00-20.00</span>
                  </li>
                  <li className="d-lg-flex justify-content-between">
                    Saturday <span>10.00-20.00</span>
                  </li>
                  <li className="d-lg-flex justify-content-between">
                    Sunday <span>12-20.00</span>
                  </li>
                </ul>

                <h5>Call Now : +(89) 239-668</h5>
              </div>
            </div>
          </div>
        </div>
      </footer>

      <div className="footer-btm py-4 ">
        <div className="container">
          <div className="row ">
            <div className="col-lg-6">
              <p className="copyright mb-0 ">
                @ Copyright Reserved to therichpost &amp; made by{" "}
                <a href="https://therichpost.com/">therichpost</a>
              </p>
            </div>
            <div className="col-lg-6">
              <ul className="list-inline mb-0 footer-btm-links text-lg-right mt-2 mt-lg-0">
                <li className="list-inline-item">
                  <a href="#">Privacy Policy</a>
                </li>
                <li className="list-inline-item">
                  <a href="#">Terms &amp; Conditions</a>
                </li>
                <li className="list-inline-item">
                  <a href="#">Cookie Policy</a>
                </li>
                <li className="list-inline-item">
                  <a href="#">Terms of Sale</a>
                </li>
              </ul>
            </div>
          </div>
        </div>
      </div>
    </div>
  );
}

export default Footer;
