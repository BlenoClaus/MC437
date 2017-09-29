import React from 'react';
import {FormattedMessage} from 'react-intl';
import {BrowserRouter, Route, Link, Switch} from 'react-router-dom';

import Container from './src/components/ContainerComponent.js';

import NotFound from './src/components/NotFoundComponent.js';

import './src/stylesheets/main.scss';


class App extends React.Component {

   render() {

      return (
        <BrowserRouter>
        	<Switch>
				<Route path="/" component={Container} />
				<Route component={NotFound} />
			</Switch>
		</BrowserRouter>
      );
   }
}

export default App;
