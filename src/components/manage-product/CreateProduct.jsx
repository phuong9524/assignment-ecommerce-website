import axios from 'axios';
import React, { useState , useEffect} from 'react'
import {useNavigate} from 'react-router-dom';
import * as ReactBootStrap from 'react-bootstrap'

const CreateProduct = () => {

  const [name, setName] = useState("");
  const [desc, setDesc] = useState("");
  const [price, setPrice] = useState(Number);
  const [image, setImage] = useState("assets/images/defaultImage.png");
  const [categoryName, setCategoryName] = useState("");
  const [loading, setLoading] = useState(false);
  const history = useNavigate();
  
  async function addProduct() {
    let item = {name, desc, price, image, categoryName};
    console.log(item)
    await fetch("http://localhost:8110/api/admin/product", {
        method: 'POST',
        headers: {
            "Content-Type": "application/json",
            "Accept":'application/json'
        },
        body: JSON.stringify(item)
    });
    history('/manage-product')

    
}

const [data, setData] = useState([]);
    useEffect(() => {
      const getProduct = async () => {
        let result = await fetch(`http://localhost:8110/api/user/category`);
      result = await result.json();
      setData(result)
      }
      getProduct();
    }, [])

    const [imageSelected, setimageSelected] = useState();
    const uploadImage = () => {
      const formData = new FormData()
      formData.append("file", imageSelected)
      formData.append("upload_preset","dweeibvh")

      axios.post("https://api.cloudinary.com/v1_1/dwsae4gmt/image/upload", formData).then((response) => {
        setImage(response['data'].url);
        console.log(image)
      });
      setLoading(false);
    };

    useEffect(() => {
      uploadImage();
    }, []);

    const handleSelect = (e) => {
      console.log(e)
      setCategoryName(e.value)
      console.log(categoryName)
    }




  return (
    <div>
       <div className="row justify-content-center">
                    <div className="col-lg-6">
                    <div className="login-form border p-5">
                        <div className="text-center heading">
                        <h2 className="mb-2">Create Product</h2>
                        </div>
            
                        <form action="#">
                          <div className='row'>
                            <div className='col'>
                        <div className="form-group mb-4">
                            <label for="#">Enter Name</label>
                            <input onChange={(e) => setName(e.target.value)} type="text" className="form-control" placeholder="Enter Product Name" />
                        </div>
                        <div className="form-group">
                            <label for="#">Enter Description</label>
                            <input onChange={(e) => setDesc(e.target.value)} type="text" className="form-control" placeholder="Enter Description" /> 
                        </div>
                        <div className="form-group">
                            <label for="#">Enter Price</label>
                            <input onChange={(e) => setPrice(e.target.value)} type="number" className="form-control" placeholder="Enter Price"/>
                        </div>
                        <div className="form-group">
                            <label for="image">Choose Category </label>
                
                            <select id="image" onChange={handleSelect} >
                              {data.map((item) => 
                                <option>{item.categoryName}</option>
                              )}
                            </select>
                        </div>
    
                            </div>
                            <div className='col'>
                            <div class="custom-file"> 
                              <input 
                                  type="file" 
                                  onChange={(event) => {
                                    setimageSelected(event.target.files[0]);
                                  }}
                                  class="custom-file-input" id="customFile"/>
                                 
                                  <div className='text-center'>
                                  <br></br>
                                  {loading ? 
                                    
                                    <ReactBootStrap.Spinner animation='border'/>
                                    : 
                                    <img src={image} alt={"your product"} style={{width:500}}/>
                                  }
                                    <br></br>
                                    <br></br>
                                <button onClick={uploadImage}> Upload Image</button>
                                </div>
                              <label class="custom-file-label" for="customFile">Choose file</label>
                            </div>
                            </div>
                        </div>
                        <a onClick={addProduct} className="btn btn-main mt-3 btn-block" style={{backgroundColor:'#fb5c42'}}>Add Product</a>
                        </form>
                    </div>
                    </div>
                </div>
    </div>
  )
}

export default CreateProduct