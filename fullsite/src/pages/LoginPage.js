import React, {Component} from 'react'

import BasePage from './BasePage'

import LoginForm from '../components/user/LoginForm'

import {setCurrentAuth} from '../utils/auth'

class LoginPage extends Component {

  constructor(props) {
    super(props);

    this.createUser = this.createUser.bind(this);
  }

  createUser (user) {

    $.ajax({
      method: "POST",
      contentType: "application/json",
      data: JSON.stringify(user),
      url : API_URL + "client/create",
     }).done( (data) => {
       if(data.id && data.token) {
         setCurrentAuth(data);
         this.props.history.push("/");
       }
     })
  }

  render () {
    return (
      <BasePage>
        <LoginForm/>
      </BasePage>
    )
  }
}

export default LoginPage;
