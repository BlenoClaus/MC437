import React from 'react';
import ReactDOM from 'react-dom';
import App from './App.js';
import {IntlProvider, FormattedMessage, addLocaleData } from 'react-intl';
import localeMessages from './src/translations/translationData.json';
// import router from './src/router'

//Adicionar idiomas suportados
const languages = require('./src/constants/Languages');
for (var i = 0; i < languages.length; i++) {
  let locale = require('react-intl/locale-data/'+languages[i]);
  addLocaleData(locale);
}

//Detecting UI language
var localeCode;

if (navigator.languages && navigator.languages[0]){
  localeCode = navigator.languages[0];
} else if (navigator.languages) {
  localeCode = navigator.languages;
} else if (navigator.userLanguage) {
  localeCode = navigator.userLanguage
}

if (!(localeCode in languages)) {
  localeCode = localeCode.toLowerCase().split(/[_-]+/)[0];
}

if (!(localeCode in languages)) {
  localeCode = languages[0];
}

ReactDOM.render(<App />, document.getElementById('app'));
