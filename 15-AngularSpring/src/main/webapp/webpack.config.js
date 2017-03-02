var webpack = require('webpack');

module.exports = {
    entry: './src/main.ts',
    output: {
        path: './bundles',
        filename: 'app.bundle.js'
    },
    module: {
        loaders: [
            {
                test: /\.(html|css)$/,
                loader: 'raw-loader'
            },
            {
                test: /\.ts$/,
                loaders: ['ts-loader', 'angular2-template-loader'],
                exclude: /node_modules/
            }
        ]
    },
    resolve: {
        extensions: ['.js', '.ts']
    }
};

