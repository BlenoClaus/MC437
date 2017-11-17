import React,{Component} from 'react'

import SearchBar from '../utils/SearchBar'
import logo from '../../img/logo.png'

require("../../stylesheets/components/header.scss")
class Header extends Component {

  rotate () {
    $("#app").addClass("fa fa-spin")
  }

  render() {
    return (
      <div className="main-header">
      <img src={logo} className="logo-header" onClick={this.rotate}/>
      <SearchBar search={this.props.headerSearch}/>
      </div>
    )
  }
}

export default Header;
