var webpack = require('webpack');

module.exports = {
    entry: './src/main.ts',
    output: {
        path: './bundles',
        filename: 'app.bundle.js'
    },
    module: {
        loaders: [
            {test: /\.ts$/, loader: 'ts-loader', exclude: /node_modules/}
        ]
    },
    resolve: {
        extensions: ['.js', '.ts']
    }
};

