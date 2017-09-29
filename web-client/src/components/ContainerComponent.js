import React from 'react';
import {BrowserRouter, Route, Link, Switch} from 'react-router-dom';

import NotFound from './NotFoundComponent.js';

import Nav from './NavComponent.js';
import Home from './HomeComponent.js'
import Products from './products/ProductsComponent.js'
import Stocks from './stocks/StocksComponent.js'
import Suppliers from './suppliers/SuppliersComponent.js'

class Container extends React.Component {

	render() {
		return (
			<div>
				<div className="container">
					<Nav />
					<Switch>
						<Route exact path="/" component={Home} />
						<Route path="/products" component={Products} />
						<Route path="/stocks" component={Stocks} />
						<Route path="/suppliers" component={Suppliers} />
						<Route component={NotFound} />
					</Switch>
				</div>
			</div>
		);
	}
}

export default Container;