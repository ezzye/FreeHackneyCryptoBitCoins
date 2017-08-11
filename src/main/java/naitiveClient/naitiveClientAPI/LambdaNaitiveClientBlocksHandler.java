package naitiveClient.naitiveClientAPI;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.serverless.model.ApiGatewayResponse;
import com.serverless.model.Response;
import org.apache.log4j.Logger;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Servlet to handle get blocks requests to naitiveClient server
 *
 * Get blockchain
 *
 * curl http://localhost:3001/blocks
 *
 * then return new genesis block
 *
 *
 */


public class LambdaNaitiveClientBlocksHandler implements RequestHandler<Map<String, Object>, ApiGatewayResponse>{

    private static final Logger LOG = Logger.getLogger(LambdaNaitiveClientBlocksHandler.class);

    private LambdaBlockChain lambdaBlockChain;

    public LambdaNaitiveClientBlocksHandler() {
    }

    @Override
    public ApiGatewayResponse handleRequest(Map<String, Object> input, Context context) {
        LOG.info("received: " + input);

        //get  block chain
        //if no block chain then create one
        //get request
        //if request /blocks then return blockchain

        //For test print out request/input object/map
//        System.out.println("***********************************************");
//        System.out.print(Arrays.toString(input.entrySet().toArray()));
//        System.out.println("***********************************************");

        // return blockchain with genesis block
        String blockString = lambdaBlockChain.toString();

        Response responseBody = new Response(blockString);
        Map<String, String> headers = new HashMap<>();
        headers.put("X-Powered-By", "AWS Lambda & Serverless");
        headers.put("Content-Type", "application/json");
        return ApiGatewayResponse.builder()
                .setStatusCode(200)
                .setObjectBody(responseBody)
                .setHeaders(headers)
                .build();
    }

}
