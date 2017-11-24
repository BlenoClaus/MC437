import React,{Component} from 'react'

import SearchBar from '../utils/SearchBar'
import logo from '../../img/logo.png'
import CurrentUser from './CurrentUser'

import {Link, withRouter} from 'react-router-dom'

require("../../stylesheets/components/header.scss")
class Header extends Component {

  constructor(props) {
    super(props);
    this.searchProducts = this.searchProducts.bind(this);
  }

  rotate () {
    $("#app").addClass("fa fa-spin")
  }

  searchProducts(query) {
    this.props.history.push("/search/"+query);
  }

  render() {
    return (
      <div className="main-header">
        <Link to="/">
          <img src={logo} className="logo-header"/>
        </Link>
        <SearchBar search={this.searchProducts}/>
        <CurrentUser/>
      </div>
    )
  }
}

export default withRouter(Header);
