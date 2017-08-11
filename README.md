/**
 * Main used for testing, exposing a url to mock lambda, while naitiveClientBlocksHandler used for API gateway (so build with main class)
 * Make fat jar using: 'mvn assembly:assembly -DdescriptorId=jar-with-dependencies package'; for running lambda with POM without main class.
 * Use main class POM for running main lambda mock.
 */

 use `serverless deploy --aws-profile zanonexp1_dev`  to deploy