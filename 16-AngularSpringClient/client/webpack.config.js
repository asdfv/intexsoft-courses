var webpack = require('webpack');

module.exports = {
    entry: {
        app: './src/main.ts',
        polyfill: './src/polyfill.ts'
    },
    output: {
        filename: './bundles/[name].bundle.js'
    },
    module: {
        loaders: [
            {
                test: /\.(html|css)$/,
                loader: 'raw-loader',
            },
            {
                test: /\.ts$/,
                loaders: ['ts-loader'],
                exclude: /node_modules/,
            }
        ]
    },
    resolve: {
        extensions: ['.ts', '.js']
    },
    devServer: {
        port: 3000,
        proxy: {'/userapp/api/*': 'http://localhost:8080/'}
    }
};
