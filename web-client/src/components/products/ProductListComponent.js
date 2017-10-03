import React from 'react';
import axios from 'axios';
import Server from '../../constants/server.js';
import {Redirect} from 'react-router-dom';

class ProductList extends React.Component {

	constructor(props) {
		super(props);

		this.state = {
			loading: true,
			productList: {}
		};

		this.sendToProduct = this.sendToProduct.bind(this);
		this.changeProduct = this.changeProduct.bind(this);
	}

	componentDidMount() {
		var self = this;

		axios.get(Server.WS_URL + "product/", {
				headers: { Authorization: Server.API_KEY }
			})
			.then(function(response) {
				self.setState({
					loading: false,
					productList: response.data.content,
				});
			});
	}

	sendToProduct(event) {
		window.location = "products/" + this.state.selectedProduct;
	}

	changeProduct(event) {
		this.state.selectedProduct = event.target.value;
	}

	render() {
		if(this.state.loading == true) {
			return (
				<div className="product-list-container">	
					<span></span>
				</div>
			);
		} else {
			var products = [];
			var numProducts = this.state.productList.length;

			if(numProducts == 0) {
				return (
					<div className="product-list-container">	
						<span>Nenhum produto encontrado.</span>
					</div>
				);
			} else {

				this.state.selectedProduct = 1;

				for(var i = 0; i < numProducts; i++) {
					var product = this.state.productList[i];
					products.push(<option key={product.id} value={product.id}>{product.name}</option>);
				}

				return (
					<div className="product-list-container">	
						<select name="products" onChange={this.changeProduct}>
							{products}
						</select>
						<button onClick={this.sendToProduct} className="btn btn-primary">
							Ver detalhes
						</button>
					</div>
				);
			}
		}
	}
}

export default ProductList;