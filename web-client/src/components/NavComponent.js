import React from 'react';

class Nav extends React.Component {

	render() {
		return (
			<nav className="navbar navbar-light bg-light">

				<ul className="nav nav-pills mr-auto">
					<li className="nav-item">
						<a className="nav-link" href="/products">Produtos</a>
					</li>
					<li className="nav-item">
						<a className="nav-link" href="/stocks">Estoque</a>
					</li>
					<li className="nav-item">
						<a className="nav-link" href="/suppliers">Fornecedor</a>
					</li>
				</ul>
			</nav>
		);
	}
}

export default Nav;