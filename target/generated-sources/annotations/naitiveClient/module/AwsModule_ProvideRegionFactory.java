package naitiveClient.module;

import com.amazonaws.regions.Region;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;
import naitiveClient.context.Args;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class AwsModule_ProvideRegionFactory implements Factory<Region> {
  private final AwsModule module;

  private final Provider<Args> argsProvider;

  public AwsModule_ProvideRegionFactory(AwsModule module, Provider<Args> argsProvider) {
    assert module != null;
    this.module = module;
    assert argsProvider != null;
    this.argsProvider = argsProvider;
  }

  @Override
  public Region get() {
    return Preconditions.checkNotNull(
        module.provideRegion(argsProvider.get()),
        "Cannot return null from a non-@Nullable @Provides method");
  }

  public static Factory<Region> create(AwsModule module, Provider<Args> argsProvider) {
    return new AwsModule_ProvideRegionFactory(module, argsProvider);
  }
}
