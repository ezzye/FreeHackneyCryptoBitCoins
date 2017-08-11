package naitiveClient.module;

import com.amazonaws.regions.Region;
import com.amazonaws.services.s3.AmazonS3;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class AwsModule_ProvideAmazonS3Factory implements Factory<AmazonS3> {
  private final AwsModule module;

  private final Provider<Region> regionProvider;

  public AwsModule_ProvideAmazonS3Factory(AwsModule module, Provider<Region> regionProvider) {
    assert module != null;
    this.module = module;
    assert regionProvider != null;
    this.regionProvider = regionProvider;
  }

  @Override
  public AmazonS3 get() {
    return Preconditions.checkNotNull(
        module.provideAmazonS3(regionProvider.get()),
        "Cannot return null from a non-@Nullable @Provides method");
  }

  public static Factory<AmazonS3> create(AwsModule module, Provider<Region> regionProvider) {
    return new AwsModule_ProvideAmazonS3Factory(module, regionProvider);
  }
}
