package naitiveClient.module;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;
import naitiveClient.context.Args;
import uk.co.bbc.contextsupplier.ContextSupplier;
import uk.co.bbc.ec2userdata.UserDataParser;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class ArgsModule_ProvideContextSupplierFactory
    implements Factory<ContextSupplier<Args>> {
  private final ArgsModule module;

  private final Provider<Args> argsProvider;

  private final Provider<UserDataParser> userDataParserProvider;

  public ArgsModule_ProvideContextSupplierFactory(
      ArgsModule module,
      Provider<Args> argsProvider,
      Provider<UserDataParser> userDataParserProvider) {
    assert module != null;
    this.module = module;
    assert argsProvider != null;
    this.argsProvider = argsProvider;
    assert userDataParserProvider != null;
    this.userDataParserProvider = userDataParserProvider;
  }

  @Override
  public ContextSupplier<Args> get() {
    return Preconditions.checkNotNull(
        module.provideContextSupplier(argsProvider.get(), userDataParserProvider.get()),
        "Cannot return null from a non-@Nullable @Provides method");
  }

  public static Factory<ContextSupplier<Args>> create(
      ArgsModule module,
      Provider<Args> argsProvider,
      Provider<UserDataParser> userDataParserProvider) {
    return new ArgsModule_ProvideContextSupplierFactory(
        module, argsProvider, userDataParserProvider);
  }
}
