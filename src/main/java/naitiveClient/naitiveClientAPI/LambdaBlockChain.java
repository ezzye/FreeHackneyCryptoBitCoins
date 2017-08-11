package naitiveClient.naitiveClientAPI;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

public class LambdaBlockChain {

    private LambdaBlock block;

    private List<LambdaBlock> blockChain;

    @Inject
    public LambdaBlockChain() {
        this.block = block.genesis();
        this.blockChain = new ArrayList<LambdaBlock>();
    }

    public List<LambdaBlock> getBlockChain() {
        return blockChain;
    }

    public LambdaBlock latestBlock() {
        return this.blockChain.get(blockChain.size()-1);
    }

    @Override
    public String toString() {
        return "BlockChain{" +
                "block=" + block +
                ", blockChain=" + blockChain +
                '}';
    }
}
