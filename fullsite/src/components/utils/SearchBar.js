import React, {Component} from 'react'


import {withRouter} from 'react-router-dom'

require('../../stylesheets/components/searchBar.scss');
class SearchBar extends Component {

  constructor(props) {
    super(props);

    this.state = {
      query : this.props.match.params.query ? this.props.match.params.query : ""
    }

    this.searchButtonClicked = this.searchButtonClicked.bind(this);
    this.searchQueryChanged = this.searchQueryChanged.bind(this);
    this.keyPressed = this.keyPressed.bind(this);
  }

  searchButtonClicked () {
    this.props.search(this.state.query);
  }


  keyPressed(e) {
    if(e.key == "Enter") {
      this.searchButtonClicked();
    }
  }

  searchQueryChanged (e) {
    this.setState({
      query : e.target.value
    })
  }

  render () {
    const {query} = this.state
    return (
      <div className="search-bar">
        <input type="text" onChange={this.searchQueryChanged}  onKeyPress={this.keyPressed} value={query}/>
        <button className="fa fa-search" onClick={this.searchButtonClicked}/>
      </div>
    )
  }
}

export default withRouter(SearchBar);
