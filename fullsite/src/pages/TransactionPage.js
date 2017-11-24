import React, {Component} from 'react'
import BasePage from './BasePage'
import ProductGrid from '../components/product/ProductGrid'

import {Table} from 'react-bootstrap'

import {getCurrentAuth} from '../utils/auth'

import {Link} from 'react-router-dom'

class HomePage extends Component {

  constructor (props) {
    super(props);
    this.state = {
    }

    this.fetchHistory = this.fetchHistory.bind(this);
  }

  fetchHistory () {

    const auth = getCurrentAuth();

    $.ajax({
      url : API_URL + "payment/history/" + auth.id,
   }).done( (data) => {
     this.setState({
       history : data
     })
   })
  }

  componentDidMount () {
    this.fetchHistory();
  }

  componentWillReceiveProps (nextProps) {
    if (nextProps.location != this.props.location) {
      this.fetchHistory;
    }
  }

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

  render() {
    const {history} = this.state;
    if(!history) {
      return (
        <BasePage>
          <div className="product-details-container">
            <i className="fa fa-spinner fa-spin fa-5x"/>
          </div>
        </BasePage>
      )
    }
    return (
      <BasePage headerSearch={this.searchProducts}>
        <div className="product-details-container">

        <Table striped bordered condensed hover>
          <thead>
            <tr>
              <th>#</th>
              <th>Produto</th>
              <th>Preço</th>
              <th>Status</th>
            </tr>
          </thead>
          <tbody>
            {history.map((v) => {
              console.log(v);
              return (
                <tr key={v.transacao.Id}>
                  <td>{v.transacao.Id}</td>
                  <td style={{textAlign: "left", paddingLeft:"15px"}}>
                    <Link to={"/product/"+ v.product.id}>
                      {v.product.name.length > 50 ? v.product.name : v.product.name.slice(0, 50)}
                    </Link>
                  </td>
                  <td className="product-price-box" style={{fontSize: "1em"}}>{this.getPriceLabel(v.product.price)}</td>
                  <td>{v.transacao.estado_transacao}</td>
                </tr>
              )
            })}
          </tbody>
        </Table>
        </div>
      </BasePage>
    )
  }
}

export default HomePage;
