package naitiveClient.module;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;
import naitiveClient.context.Args;
import uk.co.bbc.contextsupplier.ContextSupplier;
import uk.co.bbc.route.util.CertDetails;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class NettyModule_ProvideClientCertFactory implements Factory<CertDetails> {
  private final NettyModule module;

  private final Provider<ContextSupplier<Args>> contextSupplierProvider;

  public NettyModule_ProvideClientCertFactory(
      NettyModule module, Provider<ContextSupplier<Args>> contextSupplierProvider) {
    assert module != null;
    this.module = module;
    assert contextSupplierProvider != null;
    this.contextSupplierProvider = contextSupplierProvider;
  }

  @Override
  public CertDetails get() {
    return Preconditions.checkNotNull(
        module.provideClientCert(contextSupplierProvider.get()),
        "Cannot return null from a non-@Nullable @Provides method");
  }

  public static Factory<CertDetails> create(
      NettyModule module, Provider<ContextSupplier<Args>> contextSupplierProvider) {
    return new NettyModule_ProvideClientCertFactory(module, contextSupplierProvider);
  }
}
