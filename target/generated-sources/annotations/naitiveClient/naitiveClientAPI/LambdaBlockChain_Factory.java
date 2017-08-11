package naitiveClient.naitiveClientAPI;

import dagger.internal.Factory;
import javax.annotation.Generated;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public enum LambdaBlockChain_Factory implements Factory<LambdaBlockChain> {
  INSTANCE;

  @Override
  public LambdaBlockChain get() {
    return new LambdaBlockChain();
  }

  public static Factory<LambdaBlockChain> create() {
    return INSTANCE;
  }
}
