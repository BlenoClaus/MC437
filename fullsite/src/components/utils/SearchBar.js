import React, {Component} from 'react'

require('../../stylesheets/components/searchBar.scss');
class SearchBar extends Component {

  constructor(props) {
    super(props);

    this.state = {
      query : ""
    }

    this.searchButtonClicked = this.searchButtonClicked.bind(this);
    this.searchQueryChanged = this.searchQueryChanged.bind(this);
  }

  searchButtonClicked (e) {
    this.props.search(this.state.query);
  }

  searchQueryChanged (e) {
    this.setState({
      query : e.target.value
    })
  }

  render () {
    return (
      <div className="search-bar">
        <input type="text" onChange={this.searchQueryChanged}/>
        <button className="fa fa-search" onClick={this.searchButtonClicked}/>
      </div>
    )
  }
}

export default SearchBar;
