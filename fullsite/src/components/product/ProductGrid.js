import React, {Component} from 'react'
import ProductCard from './ProductCard'

import {Grid, Row, Col} from 'react-bootstrap'

import {Link} from "react-router-dom"

require('../../stylesheets/components/productGrid.scss')

class ProductGrid extends Component {

  render () {
    const {products} = this.props;
    return (
      <div className="product-grid">
        <Grid>
          <Row>
          {products.map((value) => {
            return (
              <Col key={value.id} xl={2} lg={3} md={4} sm={6} xs={12}>
                <Link to={"product/" + value.id}>
                  <ProductCard product={value}/>
                </Link>
              </Col>
            )
          })}
          </Row>
        </Grid>
      </div>
    )
  }
}

export default ProductGrid;
