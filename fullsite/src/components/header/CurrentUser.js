import React, {Component} from 'react'
import {getCurrentAuth, getCurrentUser, setCurrentUser, logout} from '../../utils/auth'
import {Link} from 'react-router-dom'

require("../../stylesheets/components/currentUser.scss")
class CurrentUser extends Component {

  constructor (props) {
    super(props);

    this.state = {
      currentUser : getCurrentUser(),
      visibleMenu : false
    }

    this.displayMenu = this.displayMenu.bind(this);
    this.hideMenu = this.hideMenu.bind(this);
    this.logoff = this.logoff.bind(this);
  }

  componentDidMount () {
    if (getCurrentAuth() && !this.state.currentUser) {
      this.fetchCurrentUser();
    }
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

  displayMenu() {
    this.setState({
      visibleMenu : true
    })
  }

  hideMenu() {
    this.setState({
      visibleMenu : false
    })
  }

  logoff () {
    logout();
    this.hideMenu();
  }

  render() {
    const currentAuth = getCurrentAuth();
    if (!currentAuth) {
      return (
        <div className="authentication-link right-item">
          <Link className="login-link" to="/login">
            <span>Login</span>
          </Link>
          <span>/</span>
          <Link className="register-link" to="/register">
            Register
          </Link>
        </div>
      )
    } else {
      const currentUser = this.state.currentUser
      if (currentUser) {
        return (
          <div className="profile-thumb right-item" onMouseEnter={this.displayMenu} onMouseLeave={this.hideMenu}>
            <div>
              Bem vindo, {currentUser.name}
            </div>
            {this.state.visibleMenu &&
              <ul>
                <li className="menu-item">
                  <Link to="/profile">
                    perfil
                  </Link>
                </li>
                <li className="menu-item logout" onClick={this.logoff}>
                  logout
                </li>
              </ul>
            }

          </div>
        )
      } else {
        return (
          <div className="profile-loading right-item">
            <span>FetchingProfile</span>
            <i className="fa fa-spin fa-spinner"/>
          </div>
        )
      }
    }
  }
}

export default CurrentUser;
