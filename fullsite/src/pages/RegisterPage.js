import React, {Component} from 'react'

import BasePage from './BasePage'

import UserForm from '../components/user/UserForm'

import {setCurrentAuth} from '../utils/auth'

class RegisterPage extends Component {

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
        <UserForm submitUser={this.createUser}/>
      </BasePage>
    )
  }
}

export default RegisterPage;
