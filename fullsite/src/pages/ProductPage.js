import React, {Component} from 'react'
import BasePage from './BasePage'
import {Grid, Row, Col, Carousel, Modal, Button} from 'react-bootstrap';


import {getCurrentAuth} from '../utils/auth'

require("../stylesheets/pages/productPage.scss")
class ProductPage extends Component {

  constructor(props) {
    super(props);

    this.state = {
      displayModal : false,

      amountParcel : 1,
  		cardNumber : "",
  		cardHolder : "",
  		expirationDate : "",
  		cardSecurity : ""
    }

    this.handleCardNumber = this.handleCardNumber.bind(this);
    this.handleCardHolder = this.handleCardHolder.bind(this);
    this.handleCardSecurity = this.handleCardSecurity.bind(this);
    this.handleExpirationDate = this.handleExpirationDate.bind(this);
    this.handleFormSubmit = this.handleFormSubmit.bind(this);
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

  fetchProduct (productId) {
    $.ajax({
      url : API_URL + "product/"+productId,
   }).done( (data) => {
     this.setState({
       product : data
     })
   })
  }

  componentDidMount() {
    this.fetchProduct(this.props.match.params.productId)
  }

  handleCardNumber (e) {
    const value = e.target.value;
    this.setState({
      cardNumber : value
    })
  }

  handleCardHolder (e) {
    const value = e.target.value;
    this.setState({
      cardHolder : value
    })
  }

  handleCardSecurity (e) {
    const value = e.target.value;
    this.setState({
      cardSecurity : value
    })
  }

  handleExpirationDate (e) {
    const value = e.target.value;
    this.setState({
      expirationDate : value
    })
  }

  handleFormSubmit() {
    const { amountParcel, cardNumber, cardHolder, expirationDate, cardSecurity} = this.state;
    if(!amountParcel || !cardNumber || !cardHolder || !expirationDate || !cardSecurity) {
      alert("Há campos vazios");
    }

    const auth = getCurrentAuth();

    const body = {
      clientId : auth.id,
      productId : this.state.product.id,
      request : {
        amountParcel : amountParcel,
        cardNumber : cardNumber,
        cardHolder : cardHolder,
        expirationDate : expirationDate,
        cardSecurity : cardSecurity
      }
    }

    $.ajax({
      method: "POST",
      contentType: "application/json",
      data: JSON.stringify(body),
      url : API_URL + "payment",
    }).done( (data, res) => {
        if(res == "nocontent") {
          this.props.history.push("/transaction");
       }
     })
  }

  render () {
    const {product, displayModal} = this.state;

    if(!product) {
      return (
        <BasePage>
          <div className="product-details-container">
            <i className="fa fa-spinner fa-spin fa-5x"/>
          </div>
        </BasePage>
      )
    }
    return (
      <BasePage>
        <div className="product-details-container">
          <h1 className="product-name">
            {product.name}
          </h1>
          <div className="product-thumb">
            <Carousel interval={7000}>
              {product.images &&
                product.images.map(v => {
                  return (
                    <Carousel.Item key={v.url}>
                      <img src={v.url} className="thumb-image"/>
                    </Carousel.Item>
                  );
                })
              }
            </Carousel>
          </div>
          <div className="product-description">
            {product.description}
          </div>
          <div className="product-price-box">
            {this.getPriceLabel(product.price)}
          </div>

          <div>
            <button className="buy-button" onClick={() => {this.setState({displayModal: true})}}>
              Comprar
            </button>
          </div>
        </div>

        {displayModal &&
          <Modal.Dialog>
            <Modal.Header>
              <Modal.Title>Informações de pagamento</Modal.Title>
            </Modal.Header>

            <Modal.Body>
              <form onSubmit={(e) => {e.preventDefault()}} className="card-form">
                <label className="card-form-label">
                  <div className="input-label">
                    Card Number:
                  </div>
                  <input type="text" value={this.state.cardNumber} onChange={this.handleCardNumber} />
                </label>

                <label  className="card-form-label">
                  <div className="input-label">
                    Proprietário cartão:
                  </div>
                  <input type="text" value={this.state.cardHolder} onChange={this.handleCardHolder} />
                </label>

                <label  className="card-form-label">
                  <div className="input-label">
                    Código de segurança:
                  </div>
                  <input type="text" value={this.state.cardSecurity} onChange={this.handleCardSecurity} />
                </label>

                <label  className="card-form-label">
                  <div className="input-label">
                    Data de validade:
                  </div>
                  <input type="date" value={this.state.expirationDate} onChange={this.handleExpirationDate} />
                </label>
              </form>
            </Modal.Body>

            <Modal.Footer>
              <Button>Close</Button>
              <Button bsStyle="primary" onClick={this.handleFormSubmit}>Finalizar compra</Button>
            </Modal.Footer>

          </Modal.Dialog>
        }
      </BasePage>
    )
  }
}

export default ProductPage;
