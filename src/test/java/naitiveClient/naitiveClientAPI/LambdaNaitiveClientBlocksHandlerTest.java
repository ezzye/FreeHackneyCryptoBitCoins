package naitiveClient.naitiveClientAPI;

import com.amazonaws.services.lambda.runtime.Context;
import com.serverless.model.ApiGatewayResponse;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Map;

@RunWith(MockitoJUnitRunner.class)
public class LambdaNaitiveClientBlocksHandlerTest {

    public LambdaBlockChainFactory lambdaBlockChainFactory;
    public LambdaNaitiveClientBlocksHandler handler;
    @Mock Map<String, Object> input;
    @Mock Context context;




    @Before
    public void setUp() throws Exception {
        this.handler = new LambdaNaitiveClientBlocksHandler();
    }

    @Test
    public void handleRequestTest() throws Exception {
        //methods under test
        ApiGatewayResponse expected = handler.handleRequest(input,context);
        System.out.println(expected.getBody().toString());
    }

}