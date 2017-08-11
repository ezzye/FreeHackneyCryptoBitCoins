package naitiveClient.module;

import com.google.common.util.concurrent.Service;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;
import naitiveClient.NaitiveClientHttpChannelInitializer;
import naitiveClient.NaitiveClientHttpsChannelInitializer;
import naitiveClient.context.Args;
import uk.co.bbc.contextsupplier.ContextSupplier;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class NettyModule_ProvideNettyContextServiceFactory implements Factory<Service> {
  private final NettyModule module;

  private final Provider<ContextSupplier<Args>> contextSupplierProvider;

  private final Provider<NaitiveClientHttpChannelInitializer> httpChannelInitializerProvider;

  private final Provider<NaitiveClientHttpsChannelInitializer> httpsChannelInitializerProvider;

  public NettyModule_ProvideNettyContextServiceFactory(
      NettyModule module,
      Provider<ContextSupplier<Args>> contextSupplierProvider,
      Provider<NaitiveClientHttpChannelInitializer> httpChannelInitializerProvider,
      Provider<NaitiveClientHttpsChannelInitializer> httpsChannelInitializerProvider) {
    assert module != null;
    this.module = module;
    assert contextSupplierProvider != null;
    this.contextSupplierProvider = contextSupplierProvider;
    assert httpChannelInitializerProvider != null;
    this.httpChannelInitializerProvider = httpChannelInitializerProvider;
    assert httpsChannelInitializerProvider != null;
    this.httpsChannelInitializerProvider = httpsChannelInitializerProvider;
  }

  @Override
  public Service get() {
    return Preconditions.checkNotNull(
        module.provideNettyContextService(
            contextSupplierProvider.get(),
            httpChannelInitializerProvider.get(),
            httpsChannelInitializerProvider.get()),
        "Cannot return null from a non-@Nullable @Provides method");
  }

  public static Factory<Service> create(
      NettyModule module,
      Provider<ContextSupplier<Args>> contextSupplierProvider,
      Provider<NaitiveClientHttpChannelInitializer> httpChannelInitializerProvider,
      Provider<NaitiveClientHttpsChannelInitializer> httpsChannelInitializerProvider) {
    return new NettyModule_ProvideNettyContextServiceFactory(
        module,
        contextSupplierProvider,
        httpChannelInitializerProvider,
        httpsChannelInitializerProvider);
  }
}
