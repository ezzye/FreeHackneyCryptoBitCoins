package naitiveClient.module;

import dagger.internal.Factory;
import io.netty.handler.ssl.SslContext;
import javax.annotation.Generated;
import javax.annotation.Nullable;
import javax.inject.Provider;
import uk.co.bbc.route.util.CertDetails;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class NettyModule_ProvideSslContextFactory implements Factory<SslContext> {
  private final NettyModule module;

  private final Provider<CertDetails> serverProvider;

  private final Provider<CertDetails> trustProvider;

  public NettyModule_ProvideSslContextFactory(
      NettyModule module,
      Provider<CertDetails> serverProvider,
      Provider<CertDetails> trustProvider) {
    assert module != null;
    this.module = module;
    assert serverProvider != null;
    this.serverProvider = serverProvider;
    assert trustProvider != null;
    this.trustProvider = trustProvider;
  }

  @Override
  @Nullable
  public SslContext get() {
    return module.provideSslContext(serverProvider.get(), trustProvider.get());
  }

  public static Factory<SslContext> create(
      NettyModule module,
      Provider<CertDetails> serverProvider,
      Provider<CertDetails> trustProvider) {
    return new NettyModule_ProvideSslContextFactory(module, serverProvider, trustProvider);
  }
}
