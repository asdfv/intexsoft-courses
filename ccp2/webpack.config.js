var CommonsChunkPlugin = require('webpack/lib/optimize/CommonsChunkPlugin');
var HtmlWebpackPlugin = require('html-webpack-plugin');

module.exports = {

    entry: {
        app1: './1.js',
        app2: './2.js',
        app3: './3.js'

    },
    output: {
        filename: './bundles/bundle.[name].js'
    },

    resolve: {
        extensions: [ '.js']
    },

    plugins: [
        new HtmlWebpackPlugin({
            template: './index.template.html'
        }),
        new CommonsChunkPlugin({
            names: ['app2', 'app1', 'app3'],
            minChunks: 2
        }),
        //new CommonsChunkPlugin({
        //    names: ['app1'],
        //    minChunks: 2
        //})
    ]
};
