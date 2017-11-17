import React, {Component} from 'react'
import BasePage from './BasePage'
import ProductGrid from '../components/product/ProductGrid'


class HomePage extends Component {

  constructor (props) {
    super(props);
    this.state = {
      products : []
    }

    this.searchProducts = this.searchProducts.bind(this);
  }

  searchProducts (query) {
    $.ajax({
      url : API_URL + "product/search?size=30&query=" + query,
   }).done( (data) => {
     this.setState({
       products : data.content
     })
   })
  }

  componentDidMount () {
    this.searchProducts("");
  }

  render() {
    return (
      <BasePage headerSearch={this.searchProducts}>
        <ProductGrid
          products={this.state.products}
        />
      </BasePage>
    )
  }
}

export default HomePage;
