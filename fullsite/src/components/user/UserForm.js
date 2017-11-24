import React, {Component} from 'react'

require("../../stylesheets/components/userForm.scss")
class UserForm extends Component {

  constructor(props) {
    super(props);

    this.state = {
      username : (props.currentUser && props.currentUser.username) ? props.currentUser.username : "",
      name : (props.currentUser && props.currentUser.name) ? props.currentUser.name : "",
      password: (props.currentUser && props.currentUser.password) ? props.currentUser.password : "",
      phone: (props.currentUser && props.currentUser.phone) ? props.currentUser.phone : "",
      cpf: (props.currentUser && props.currentUser.cpf) ? props.currentUser.cpf : "",
      email: (props.currentUser && props.currentUser.email) ? props.currentUser.email : ""
    };

    this.handleUsernameChange = this.handleUsernameChange.bind(this);
    this.handleNameChange = this.handleNameChange.bind(this);
    this.handlePasswordChange = this.handlePasswordChange.bind(this);
    this.handlePhoneChange = this.handlePhoneChange.bind(this);
    this.handleCpfChange = this.handleCpfChange.bind(this);
    this.handleEmailChange = this.handleEmailChange.bind(this);
    this.handleFormSubmit = this.handleFormSubmit.bind(this);
  }

  componentWillReceiveProps(nextProps) {
    if (!this.props.currentUser && nextProps.currentUser) {
      this.setState ({
        username : nextProps.currentUser.username,
        name : nextProps.currentUser.name,
        password: nextProps.currentUser.password,
        phone: nextProps.currentUser.phone,
        cpf: nextProps.currentUser.cpf,
        email: nextProps.currentUser.email
      });
    }
  }

  handleUsernameChange (e) {
    this.setState ({
      username : e.target.value
    })
  }

  handleNameChange (e) {
    this.setState ({
      name : e.target.value
    })
  }

  handlePasswordChange (e) {
    this.setState ({
      password : e.target.value
    })
  }

  handlePhoneChange (e) {
    this.setState ({
      phone : e.target.value
    })
  }

  handleCpfChange (e) {
    this.setState ({
      cpf : e.target.value
    })
  }

  handleEmailChange (e) {
    this.setState ({
      email : e.target.value
    })
  }

  handleFormSubmit (e) {
    e.preventDefault();
    const user = {
      username : this.state.username,
      name : this.state.name,
      password: this.state.password,
      phone: this.state.phone,
      cpf: this.state.cpf,
      email: this.state.email
    }

    this.props.submitUser(user);
  }

  render() {
    return(
      <div className="user-form">
        <form onSubmit={this.handleFormSubmit}>

          <label>
            <div className="input-label">
              Usuário:
            </div>
            <input type="text" value={this.state.username} onChange={this.handleUsernameChange} />
          </label>

          <label>
            <div className="input-label">
              Nome:
            </div>
            <input type="text" value={this.state.name} onChange={this.handleNameChange} />
          </label>

          <label>
            <div className="input-label">
              Senha:
            </div>
            <input type="password" value={this.state.password} onChange={this.handlePasswordChange} />
          </label>

          <label>
            <div className="input-label">
              telefone:
            </div>
            <input type="text" value={this.state.phone} onChange={this.handlePhoneChange} />
          </label>

          <label>
            <div className="input-label">
              CPF:
            </div>
            <input type="text" value={this.state.cpf} onChange={this.handleCpfChange} />
          </label>

          <label>
            <div className="input-label">
              Email:
            </div>
            <input type="text" value={this.state.email} onChange={this.handleEmailChange} />
          </label>

          {!this.props.editing &&
          <input type="submit" value="Registrar" />}
        </form>
      </div>
    )
  }
}

export default UserForm;
