import React from 'react'
import {BrowserRouter, Route, Link, Switch} from 'react-router-dom';

import HomePage from './pages/HomePage'
import RegisterPage from './pages/RegisterPage'
import ProfilePage from './pages/ProfilePage'
import ProductPage from './pages/ProductPage'
import TransactionPage from './pages/TransactionPage'
import LoginPage from './pages/LoginPage'

require('./stylesheets/base/base.scss');
export default (

  <BrowserRouter>
    <div>
      <Route exact path='/' component={HomePage}/>
      <Route path='/search/:query' component={HomePage}/>
      <Route exact path='/register' component={RegisterPage}/>
      <Route exact path='/profile' component={ProfilePage}/>
      <Route exact path='/login' component={LoginPage}/>
      <Route exact path='/transaction' component={TransactionPage}/>
      <Route path='/product/:productId' component={ProductPage}/>
    </div>
  </BrowserRouter>

)
