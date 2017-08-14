package naitiveClient.model;

import com.amazonaws.services.dynamodbv2.document.Item;
import com.fasterxml.jackson.annotation.JsonProperty;
import naitiveClient.dynamo.Itemisable;
import naitiveClient.dynamo.ItemiserUtil;

import static naitiveClient.dynamo.ItemiserUtil.Itemiser.addInt;
import static naitiveClient.dynamo.ItemiserUtil.Itemiser.addLong;
import static naitiveClient.dynamo.ItemiserUtil.Itemiser.addString;

public class LambdaBlock implements Itemisable {

    public static final String PARTITION_ID = "partition_id";
    public static final String INDEX = "index";
    public static final String PREVIOUS_HASH = "previousHash";
    public static final String TIME_STAMP = "timestamp";
    public static final String DATA = "data";


    @JsonProperty(PARTITION_ID)
    private String hash;

    @JsonProperty(INDEX)
    private int index;

    @JsonProperty(PREVIOUS_HASH)
    private String previousHash;

    @JsonProperty(TIME_STAMP)
    private Long timestamp;

    @JsonProperty(DATA)
    private String data;


    public LambdaBlock(int index, String previousHash, Long timestamp, String data, String hash) {
        this.index = index;
        this.previousHash = previousHash;
        this.timestamp = timestamp;
        this.data = data;
        this.hash = hash;
    }

    public String getHash() {
        return hash;
    }

    public Integer getIndex() {
        return index;
    }

    public String getPreviousHash() {
        return previousHash;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public String getData() {
        return data;
    }

    public static LambdaBlock genesis() {
        return new LambdaBlock(
                0,
                "0",
                1465154705L,
                "my genesis block!!",
                "816534932c2b7154836da6afc367695e6337db8a921823784c14378abed4f7d7"
        );
    }

    @Override
    public String toString() {
        return "LambdaBlock{" +
                "index=" + index +
                ", previousHash='" + previousHash + '\'' +
                ", timestamp=" + timestamp +
                ", data='" + data + '\'' +
                ", hash='" + hash + '\'' +
                '}';
    }

    @Override
    public Item itemise() {
        return new ItemiserUtil.Itemiser(new Item())
                .ifPresent(hash, addString(PARTITION_ID))
                .ifPresent(index, addInt(INDEX))
                .ifPresent(previousHash, addString(PREVIOUS_HASH))
                .ifPresent(timestamp, addLong(TIME_STAMP))
                .ifPresent(data, addString(DATA))
                .build();
    }
}
