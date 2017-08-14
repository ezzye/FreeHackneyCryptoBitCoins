package naitiveClient.dynamo;

import com.amazonaws.services.dynamodbv2.document.Item;

public interface Itemisable {
    Item itemise();
}
