package naitiveClient.module;

import com.amazonaws.regions.Region;
import com.amazonaws.services.sns.AmazonSNS;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class AwsModule_ProvideAmazonSNSFactory implements Factory<AmazonSNS> {
  private final AwsModule module;

  private final Provider<Region> regionProvider;

  public AwsModule_ProvideAmazonSNSFactory(AwsModule module, Provider<Region> regionProvider) {
    assert module != null;
    this.module = module;
    assert regionProvider != null;
    this.regionProvider = regionProvider;
  }

  @Override
  public AmazonSNS get() {
    return Preconditions.checkNotNull(
        module.provideAmazonSNS(regionProvider.get()),
        "Cannot return null from a non-@Nullable @Provides method");
  }

  public static Factory<AmazonSNS> create(AwsModule module, Provider<Region> regionProvider) {
    return new AwsModule_ProvideAmazonSNSFactory(module, regionProvider);
  }
}
