import React, {Component} from 'react'

require("../../stylesheets/components/productCard.scss");
class ProductCard extends Component {

  getPriceLabel (price) {
    var intValue = price.toString().slice(0,-2);
    if (!intValue) {
      intValue = '0';
    }
    var decimalValue = price.toString().slice(-2);
    if (!decimalValue) {
      decimalValue = '00';
    } else if (decimalValue.length == 1) {
      decimalValue = '0'+decimalValue;
    }

    return 'R$ '+intValue+','+decimalValue;
  }

  render () {
    const {product} = this.props;
    return (
      <div className="product-card">
        <div className="image-container">
          <img src={product.images[0].url}/>
        </div>
        <div className="product-name-box">
          {product.name}
        </div>
        <div className="product-price-box">
          {this.getPriceLabel(product.price)}
        </div>
      </div>
    )
  }
}

export default ProductCard;
