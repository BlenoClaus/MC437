import React from 'react';

class ProductDetail extends React.Component {

	render() {
		return (
			<div>
				<h2> Product {this.props.match.params.productId} </h2>
			</div>
		);
	}
}

export default ProductDetail;