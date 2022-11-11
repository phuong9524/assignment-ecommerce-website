import React,{useEffect, useState} from 'react'
import {Table} from 'react-bootstrap'
import Button from 'react-bootstrap/Button';
import axios from "axios";

const ListProduct = () => {

  function dateFormat(d) {
    let date = new Date(d),
        month = '' + (date.getMonth() + 1),
        day = '' + date.getDate(),
        year = date.getFullYear();

    if (month.length < 2) 
        month = '0' + month;
    if (day.length < 2) 
        day = '0' + day;

    return [year, month, day].join('-');
  }
  
    const [data, setData] = useState([]);
    useEffect(() => {
      const getListProduct = async () => {
      let result = await fetch(`http://localhost:8110/api/admin/product?pageNumber=0`);
      result = await result.json();
      setData(result)
      }
      getListProduct();
    }, [])

    const [valueDelete, setValueDelete] = useState("");

    function deleteProduct(value) {
      console.log(value)
      axios.delete(`https://localhost:8110/api/admin/product/delete/${value}`)
      
    };

  console.warn("result", data)
  return (
    <>
      <div style={{textAlign: "center", fontWeight: "bold", fontSize: "larger"}}>List Product</div>
      <br></br>
      <Table className='TableProduct'>
        <tr>
          <td>Id</td>
          <td>Name</td>
          <td>Price</td>
          <td>Category</td>
          <td>Creation Date</td>
          <td>Last Time Modified</td>
          <td>Image</td>
          <td>Delete</td>
          
        </tr>
        {
          data.map((item) => 
            <tr>
                <td>{item.id}</td>
                <td>{item.name}</td>
                <td>${item.price}</td>
                <td>{item.categoryName}</td>
                <td>{dateFormat(item.creationDate).toString()}</td>
                <td>{dateFormat(item.lastModifiedDate).toString()}</td>
                <td><img style={{width:100}} src={item.image} alt={item.name}/></td>
                <td>
                  <button 
                      className='btn btn-outline-dark fa fa-trash' 
                      value={item.id}
        
                      onClick={deleteProduct(data.value)}
                  ></button>
                </td>
            </tr>
          )}

      </Table>
    </>
  )
}

export default ListProduct