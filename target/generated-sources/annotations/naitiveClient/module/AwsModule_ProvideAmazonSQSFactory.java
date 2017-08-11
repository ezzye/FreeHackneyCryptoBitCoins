package naitiveClient.module;

import com.amazonaws.regions.Region;
import com.amazonaws.services.sqs.AmazonSQS;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class AwsModule_ProvideAmazonSQSFactory implements Factory<AmazonSQS> {
  private final AwsModule module;

  private final Provider<Region> regionProvider;

  public AwsModule_ProvideAmazonSQSFactory(AwsModule module, Provider<Region> regionProvider) {
    assert module != null;
    this.module = module;
    assert regionProvider != null;
    this.regionProvider = regionProvider;
  }

  @Override
  public AmazonSQS get() {
    return Preconditions.checkNotNull(
        module.provideAmazonSQS(regionProvider.get()),
        "Cannot return null from a non-@Nullable @Provides method");
  }

  public static Factory<AmazonSQS> create(AwsModule module, Provider<Region> regionProvider) {
    return new AwsModule_ProvideAmazonSQSFactory(module, regionProvider);
  }
}
