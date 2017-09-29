import React from 'react';

import ProductAdd from './ProductAddComponent.js';
import ProductList from './ProductListComponent.js';

class ProductsIndex extends React.Component {
	render() {
		return (
			<div>
				<h2>Produtos</h2>

				<ProductList />
				<ProductAdd />

			</div>
		)
	}
}

export default ProductsIndex;