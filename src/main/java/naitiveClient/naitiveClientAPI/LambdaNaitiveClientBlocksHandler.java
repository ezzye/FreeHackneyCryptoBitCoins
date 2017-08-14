package naitiveClient.naitiveClientAPI;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.serverless.model.ApiGatewayResponse;
import com.serverless.model.Response;
import naitiveClient.model.LambdaBlock;
import org.apache.log4j.Logger;

import java.util.HashMap;
import java.util.List;
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


    public LambdaNaitiveClientBlocksHandler() {
    }

    @Override
    public ApiGatewayResponse handleRequest(Map<String, Object> input, Context context) {
        LOG.info("received: " + input);
        final LambdaBlockChainFactory lambdaBlockChainFactory = LambdaBlockChainFactory.getLambdaBlockChainFactory();
        final List<LambdaBlock> blockChain = lambdaBlockChainFactory.getBlockChain();
        final String message = blockChain.get(0).toString();
        Response responseBody = new Response(message);
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
