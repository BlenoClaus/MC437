import React, {Component} from 'react'

import BasePage from './BasePage'

import UserForm from '../components/user/UserForm'

import {setCurrentAuth, setCurrentUser, getCurrentUser, getCurrentAuth} from '../utils/auth'

class ProfilePage extends Component {

  constructor(props) {
    super(props);

    this.state = {

    };
    this.createUser = this.createUser.bind(this);
  }

  fetchCurrentUser () {
    const auth = getCurrentAuth();
    if (!auth) {
      return;
    }

    $.ajax({
      method: "POST",
      contentType: "application/json",
      data: JSON.stringify(auth),
      url : API_URL + "client/me",
     }).done( (data) => {
       if(data) {
         setCurrentUser(data);
         this.setState({
           currentUser : data
         })
       }
     })
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
    if (!this.state.currentUser) {
      this.fetchCurrentUser();
    }
    return (
      <BasePage>
        <UserForm submitUser={() => {console.log("tryed to update profile");}} currentUser={this.state.currentUser} editing/>
      </BasePage>
    )
  }
}

export default ProfilePage;
