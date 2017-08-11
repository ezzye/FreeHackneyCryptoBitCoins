package naitiveClient.module;

import com.amazonaws.regions.Region;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;
import naitiveClient.context.Args;
import uk.co.bbc.contextsupplier.ContextSupplier;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class AwsModule_ProvideDynamoDBFactory implements Factory<DynamoDB> {
  private final AwsModule module;

  private final Provider<Region> regionProvider;

  private final Provider<ContextSupplier<Args>> supplierProvider;

  public AwsModule_ProvideDynamoDBFactory(
      AwsModule module,
      Provider<Region> regionProvider,
      Provider<ContextSupplier<Args>> supplierProvider) {
    assert module != null;
    this.module = module;
    assert regionProvider != null;
    this.regionProvider = regionProvider;
    assert supplierProvider != null;
    this.supplierProvider = supplierProvider;
  }

  @Override
  public DynamoDB get() {
    return Preconditions.checkNotNull(
        module.provideDynamoDB(regionProvider.get(), supplierProvider.get()),
        "Cannot return null from a non-@Nullable @Provides method");
  }

  public static Factory<DynamoDB> create(
      AwsModule module,
      Provider<Region> regionProvider,
      Provider<ContextSupplier<Args>> supplierProvider) {
    return new AwsModule_ProvideDynamoDBFactory(module, regionProvider, supplierProvider);
  }
}
