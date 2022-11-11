import React from 'react'
import Tab from 'react-bootstrap/Tab';
import Tabs from 'react-bootstrap/Tabs';
import CreateProduct from './CreateProduct';
import DetailProduct from './DetailProduct';
import ListProduct from './ListProduct';

const ManageProductMenu = () => {
    
  return (
    
    <Tabs
    defaultActiveKey="list"
    id="uncontrolled-tab-example"
    className="mb-3"
  >
    <Tab eventKey="list" title="List">
    <ListProduct/>
    </Tab>
    <Tab eventKey="detail" title="Detail">
      <DetailProduct/>
    </Tab>
    <Tab eventKey="create" title="Create">
      <CreateProduct/>
    </Tab>
  </Tabs>
  )
}

export default ManageProductMenu