package naitiveClient.naitiveClientAPI;

import dagger.internal.Factory;
import naitiveClient.model.LambdaBlock;

import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class LambdaBlock_Factory implements Factory<LambdaBlock> {
  private final Provider<Integer> indexProvider;

  private final Provider<String> dataAndHashAndPreviousHashProvider;

  private final Provider<Long> timestampProvider;

  public LambdaBlock_Factory(
      Provider<Integer> indexProvider,
      Provider<String> dataAndHashAndPreviousHashProvider,
      Provider<Long> timestampProvider) {
    assert indexProvider != null;
    this.indexProvider = indexProvider;
    assert dataAndHashAndPreviousHashProvider != null;
    this.dataAndHashAndPreviousHashProvider = dataAndHashAndPreviousHashProvider;
    assert timestampProvider != null;
    this.timestampProvider = timestampProvider;
  }

  @Override
  public LambdaBlock get() {
    return new LambdaBlock(
        indexProvider.get(),
        dataAndHashAndPreviousHashProvider.get(),
        timestampProvider.get(),
        dataAndHashAndPreviousHashProvider.get(),
        dataAndHashAndPreviousHashProvider.get());
  }

  public static Factory<LambdaBlock> create(
      Provider<Integer> indexProvider,
      Provider<String> dataAndHashAndPreviousHashProvider,
      Provider<Long> timestampProvider) {
    return new LambdaBlock_Factory(
        indexProvider, dataAndHashAndPreviousHashProvider, timestampProvider);
  }
}
