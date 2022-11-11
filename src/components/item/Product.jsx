import React, {useState, useEffect} from 'react';
import { useDispatch } from 'react-redux';
import { addCart } from '../../redux/action';
import Skeleton from 'react-loading-skeleton';
import { useParams } from 'react-router';
import { NavLink, useNavigate} from 'react-router-dom';
import axios from "axios";

const Product = () => {

    function Star({yellow}) {
        return (
            <svg className={yellow ? 'yellowStar' : ''} height="35" width="35" clip-rule="evenodd" fill-rule="evenodd" stroke-linejoin="round" stroke-miterlimit="2" viewBox="0 0 24 24" xmlns="http://www.w3.org/2000/svg"><path d="m11.322 2.923c.126-.259.39-.423.678-.423.289 0 .552.164.678.423.974 1.998 2.65 5.44 2.65 5.44s3.811.524 6.022.829c.403.055.65.396.65.747 0 .19-.072.383-.231.536-1.61 1.538-4.382 4.191-4.382 4.191s.677 3.767 1.069 5.952c.083.462-.275.882-.742.882-.122 0-.244-.029-.355-.089-1.968-1.048-5.359-2.851-5.359-2.851s-3.391 1.803-5.359 2.851c-.111.06-.234.089-.356.089-.465 0-.825-.421-.741-.882.393-2.185 1.07-5.952 1.07-5.952s-2.773-2.653-4.382-4.191c-.16-.153-.232-.346-.232-.535 0-.352.249-.694.651-.748 2.211-.305 6.021-.829 6.021-.829s1.677-3.442 2.65-5.44zm.678 2.033-2.361 4.792-5.246.719 3.848 3.643-.948 5.255 4.707-2.505 4.707 2.505-.951-5.236 3.851-3.662-5.314-.756z" fill-rule="nonzero"/></svg>
        );
    }

    const id = useParams();
    const [product, setProduct] = useState([]);
    const [loading, setLoading] = useState(false);

    const dispatch = useDispatch();
    const addProduct = (product) => {
        dispatch(addCart(product));
    }

    const [hoverIndex, setHoverIndex] = useState(0);
    const [rating, setRating] = useState(0);
    const history = useNavigate();
    
    useEffect(() => {
        const getProduct = async () => {
            setLoading(true);
            const response = await fetch(`http://localhost:8110/api/user/products/get/2`);
            setProduct(await response.json());
            setLoading(false);
        }
        getProduct();
    }, [id]);

    async function rate(rate, productId) {

        const userInfo = JSON.parse(localStorage.getItem('user-info'));
        

        if (userInfo !== null) {
            if (userInfo.hasOwnProperty["username"] !== false) {
                const username = userInfo['username'];
                let item={rate, username, productId};
                console.warn(item);
                await axios.post("http://localhost:8110/user/api/rating",
                    item);
            }
        } else {
            history("/login");
        }

    }

    const Loading = () => {
        return(
            <>
                <div className="col-md-6">
                    <Skeleton height={400}/>
                </div>
                <div className="col-md-6" style={{lineHeight:2}}>
                    <Skeleton height={50} width={300}/>
                    <Skeleton height={75} />
                    <Skeleton height={25} width={150}/>
                    <Skeleton height={50}/>
                    <Skeleton height={150}/>
                    <Skeleton height={50} width={100}/>
                    <Skeleton height={50} width={100} style={{marginLeft:6}}/>
                </div>
                <div className="col-md-6">
                    <Skeleton height={400}/>
                </div>
                <div className="col-md-6">
                    <Skeleton height={400}/>
                </div>
            </>
        )
    }
    const ShowProduct = () => {
        return(
            <>
                <div className='col-md-6'>
                    <img src={product.image} alt={product.name}
                    height="480px" width="500px"/>
                </div>
                <div className="col-md-6">
                    <h4 className='text-uppercase text-black-50'>
                        {product.categoryDesc}
                    </h4>
                    <h1 className='display-5'>
                        {product.name}
                    </h1>
                    <p className="lead fw-bolder ">
                        Rating {product.avgRate}
                        <i className='fa fa-star'></i>
                    </p>
                    <h3 className='display-6 fw-bold my-4'>
                        $ {product.price}
                    </h3>
                    <p className="lead">
                        {product.desc}
                    </p>
                    <button className='btn btn-outline-dark px-4 py-2' onClick={() =>addProduct(product)}>
                        Add to Cart
                    </button>
                     <NavLink to={{
                        pathname: "/rating",
                        state: {model: true}
                    }} className='btn btn-dark ms-2 px-3 py-2'>
                        Go to Cart
                    </NavLink>
                    <div>
                        <p className='display-2 starList'>
                            {[1,2,3,4,5].map((index) => {
                                return (
                                    <li 
                                        onMouseEnter={() => setHoverIndex(index)} 
                                        onMouseLeave={() => setHoverIndex(0)}
                                        onClick={() => {setRating(index); rate(index, product.id)}}
                                        className='starListItem'
                                    >
                                        <Star yellow={(index <= hoverIndex) || (index <= rating)}/>
                                    </li>
                                    
                                )
                            })}
                        
                        </p>
                    </div>
                   
                </div>
            </>
        )
    }

  return (
    <div>
        <div className='container py-5'>
            <div className='row'>
                {loading ? <Loading/> : <ShowProduct/>}
            </div>
        </div>
    </div>
  )
}

export default Product;
