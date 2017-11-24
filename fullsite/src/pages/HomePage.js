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
      url : API_URL + "product/search?size=30&query=" + (query ? query : ""),
   }).done( (data) => {
     this.setState({
       products : data.content
     })
   })
  }

  componentDidMount () {
    this.searchProducts(this.props.match.params.query);
  }

  componentWillReceiveProps (nextProps) {
    if (nextProps.location != this.props.location) {
      this.searchProducts(nextProps.match.params.query);
    }
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
