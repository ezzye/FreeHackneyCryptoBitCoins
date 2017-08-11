package naitiveClient.naitiveClientAPI;

import javax.inject.Inject;

public class LambdaBlock {

    private int index;
    private String previousHash;
    private Long timestamp;
    private String data;
    private String hash;

    @Inject
    public LambdaBlock(int index, String previousHash, Long timestamp, String data, String hash) {
        this.index = index;
        this.previousHash = previousHash;
        this.timestamp = timestamp;
        this.data = data;
        this.hash = hash;
    }

    public LambdaBlock genesis() {
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
        return "Block{" +
                "index=" + index +
                ", previousHash='" + previousHash + '\'' +
                ", timestamp=" + timestamp +
                ", data='" + data + '\'' +
                ", hash='" + hash + '\'' +
                '}';
    }
}
