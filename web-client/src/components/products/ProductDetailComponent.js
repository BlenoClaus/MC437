import React from 'react';
import axios from 'axios';
import Server from '../../constants/server.js';

class ProductDetail extends React.Component {

	constructor(props) {
		super(props);

		this.state = {
			loading: true,
			product: {}
		};
	}

	componentDidMount() {
		var self = this;

		axios.get(Server.WS_URL + "product/" + this.props.match.params.productId, {
				headers: { Authorization: Server.API_KEY }
			})
			.then(function(response) {
				console.log(response.data.name);
				self.setState({
					loading: false,
					product: response.data
				});
			});
	}

	render() {
		if(this.state.loading) {
			return (
				<div>
					<h2> Carregando... </h2>
				</div>
			);
		} else {
			return (
				<div className="product-detail-container">
					<h2> {this.state.product.name} </h2>
					<div className="row">
						<img src={this.state.product.images[0].url} />

						<div className="col com-details">
							<div className="row">
								<span className="description">{this.state.product.description}</span>
							</div>
							<div className="row">
								<span className="price">R$ {this.state.product.price.toLocaleString('pt-br')}</span>
							</div>
							<div className="row">
								<span className="cat">Categoria: {this.state.product.category}</span>
							</div>
							<div className="row">
								<a href="#" className="edit">Editar</a>
							</div>
						</div>
					</div>
				</div>
			);
		}
	}
}

export default ProductDetail;