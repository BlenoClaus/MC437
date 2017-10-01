import React from 'react';
import axios from 'axios';

class ProductAdd extends React.Component {

	constructor(props) {
		super(props);

		this.
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

	render() {
		return (
			<div className="product-add-container">
				<h5>Adicionar novo produto</h5>

				<form>
					<div className="form-group">
						<label htmlFor="name">Nome</label>
						<br />
						<input type="text" name="name" id="name" />
					</div>

					<div className="form-group">
						<label htmlFor="description">Descrição</label>
						<br />
						<input type="text" name="description" id="description" />
					</div>

					<div className="form-group">
						<label htmlFor="price">Preço</label>
						<br />
						<input type="text" name="price" id="price" />
					</div>

					<div className="form-group">
						<label htmlFor="category">Categoria</label>
						<br />
						<input type="text" name="category" id="category" />
					</div>

					<div className="form-group">
						<label htmlFor="image">URL Imagem</label>
						<br />
						<input type="text" name="image" id="image" />
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