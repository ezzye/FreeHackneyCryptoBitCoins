package naitiveClient.dynamo;


import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Table;
import com.amazonaws.services.dynamodbv2.document.spec.PutItemSpec;
import naitiveClient.context.Args;
import uk.co.bbc.contextsupplier.ContextSupplier;

import javax.inject.Inject;

import static naitiveClient.context.ContextProperties.StringProperty.DYNAMO_TABLE;

public class DynamoDbClient {

    private final Table table;

    @Inject
    public DynamoDbClient(ContextSupplier<Args> contextSupplier, DynamoDB dynamoDB) {
        this.table = dynamoDB.getTable(contextSupplier.get(DYNAMO_TABLE));
    }

    public void storeRecord(PutItemSpec putItemSpec) {
        this.table.putItem(putItemSpec);
    }
}
