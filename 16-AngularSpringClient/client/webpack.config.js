
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
                test: /\.ts$/,
                loaders: ['ts-loader', 'angular2-template-loader']
            },
            {
                test: /\.(html|css)$/,
                loader: 'raw-loader'
            }
        ]
    },
    resolve: {
        extensions: ['.ts', '.js']
    },
    devServer: {
        port: 3000,
        proxy: {'/api/*': 'http://localhost:8080/userapp/'}
    }
};
