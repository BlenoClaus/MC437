var webpack = require('webpack')

module.exports = {
  entry : './index.js',

  output : {
    path:__dirname + "/build",
    filename: 'bundle.js',
  },

  devServer : {
    inline : true,
    port : 8080,
    historyApiFallback: true,
  },

  module : {
    loaders: [
       {
         test: /\.(js|jsx)$/,
          loader:'babel-loader',
          exclude: ["./node_modules/"]
       },
       {
         test: /\.scss$/,
         loaders: ['style-loader', 'css-loader', 'sass-loader'],
         exclude: ["./node_modules/"]
       },
       {
         test: /\.(png|jpg|gif)$/,
         loader : 'file-loader',
         options : {
           name : "/[path][name].[ext]"
         }
       }
     ]
   },
   plugins: [
     new webpack.DefinePlugin({
       API_URL : JSON.stringify("http://localhost:8084/")
     }),
   ],
}
