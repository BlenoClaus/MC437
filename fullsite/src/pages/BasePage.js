import React, {Component} from 'react'

import Header from '../components/header/Header'
import Footer from '../components/footer/Footer'

require('../stylesheets/pages/basePage.scss')

class BasePage extends Component {

  render() {
    return (
      <div className="base-page">
        <Header headerSearch={this.props.headerSearch}/>
        <div className="base-page-content">
          {this.props.children}
        </div>
        <Footer/>
      </div>
    )
  }
}

export default BasePage;
