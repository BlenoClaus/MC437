import React from 'react';
import axios from 'axios';

class ProductAdd extends React.Component {

	constructor(props) {
		super(props);

		this.handleSubmit = this.handleSubmit.bind(this);
		this.handleChange = this.handleChange.bind(this);
	}

	handleSubmit(event) {
		event.preventDefault();

		axios.post(Server.WS_URL + "product/" + this.props.match.params.productId, {
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

	handleChange(event) {
		console.log(event.target.name);
	}

	render() {
		return (
			<div className="product-add-container">
				<h5>Adicionar novo produto</h5>

				<form>
					<div className="form-group">
						<label htmlFor="name">Nome</label>
						<br />
						<input type="text" name="name" id="name" onChange={this.handleChange} />
					</div>

					<div className="form-group">
						<label htmlFor="description">Descrição</label>
						<br />
						<input type="text" name="description" id="description" onChange={this.handleChange} />
					</div>

					<div className="form-group">
						<label htmlFor="price">Preço</label>
						<br />
						<input type="text" name="price" id="price" onChange={this.handleChange} />
					</div>

					<div className="form-group">
						<label htmlFor="category">Categoria</label>
						<br />
						<input type="text" name="category" id="category" onChange={this.handleChange} />
					</div>

					<div className="form-group">
						<label htmlFor="image">URL Imagem</label>
						<br />
						<input type="text" name="image" id="image" onChange={this.handleChange} />
					</div>

					<div className="form-group">
						<button type="submit" className="btn btn-primary">Adicionar</button>
					</div>
				</form>
			</div>
		);
	}
}

export default ProductAdd;