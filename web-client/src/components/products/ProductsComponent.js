import React from 'react';
import {BrowserRouter, Route, Link, Switch} from 'react-router-dom';

import ProductsIndex from './ProductsIndexComponent.js'
import ProductDetail from './ProductDetailComponent.js'

class Products extends React.Component {

	render() {
		return (
			<div>	
				<Switch>
					<Route exact path="/products" component={ProductsIndex} />
					<Route exact path="/products/:productId" component={ProductDetail} />
				</Switch>
			</div>
		);
	}
}

export default Products;