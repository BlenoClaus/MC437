import React, {Component} from 'react'

import {setCurrentAuth} from '../../utils/auth'

import {withRouter} from 'react-router-dom'

require("../../stylesheets/components/loginForm.scss");
class LoginForm extends Component {

  constructor(props) {
    super(props);

    this.state = {
      cpf : "",
      password : ""
    }

    this.handleCpfChange = this.handleCpfChange.bind(this);
    this.handlePasswordChange = this.handlePasswordChange.bind(this);
    this.handleFormSubmit = this.handleFormSubmit.bind(this )
  }

  handleCpfChange (e) {
    this.setState({
      cpf : e.target.value
    })
  }

  handlePasswordChange (e) {
    this.setState({
      password : e.target.value
    })
  }

  handleFormSubmit (e) {

    e.preventDefault();

    const login = {
      cpf : this.state.cpf,
      password : this.state.password
    }


    $.ajax({
      method: "POST",
      contentType: "application/json",
      data: JSON.stringify(login),
      url : API_URL + "client/login",
     }).done( (data) => {
       if(data.id && data.token) {
         setCurrentAuth(data);
         this.props.history.push("/");
       }
     })
  }

  render() {
    return (
      <div className="login-form">
        <form onSubmit={this.handleFormSubmit}>
          <label>
            <div className="input-label">
              CPF:
            </div>
            <input type="text" value={this.state.cpf} onChange={this.handleCpfChange} />
          </label>

          <label>
            <div className="input-label">
              Senha:
            </div>
            <input type="password" value={this.state.password} onChange={this.handlePasswordChange} />
          </label>
          <input type="submit" value="Registrar" />
        </form>
      </div>
    )
  }
}

export default withRouter(LoginForm);
