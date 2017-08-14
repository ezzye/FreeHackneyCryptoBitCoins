package naitiveClient.naitiveClientAPI;

import naitiveClient.model.LambdaBlock;

import java.util.ArrayList;
import java.util.List;

public class LambdaBlockChainFactory {

    private static LambdaBlockChainFactory instance = null;
    private List<LambdaBlock> blockChain;

    //constructor
    protected LambdaBlockChainFactory() {
        this.blockChain = new ArrayList<LambdaBlock>();
        this.blockChain.add(0, LambdaBlock.genesis());
    }

    //Singleton pattern (not threadsafe)
    public static LambdaBlockChainFactory getLambdaBlockChainFactory() {
        if(instance == null) {
            instance = new LambdaBlockChainFactory();
        }
        return instance;
    }

    //Get blockchain
    public List<LambdaBlock> getBlockChain() {
        return this.blockChain;
    }

    //Get latest block
    public LambdaBlock latestBlock() {
        return this.blockChain.get(blockChain.size()-1);
    }

}
