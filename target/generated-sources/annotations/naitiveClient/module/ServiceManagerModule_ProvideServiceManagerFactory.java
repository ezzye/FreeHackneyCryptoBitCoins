package naitiveClient.module;

import com.google.common.util.concurrent.Service;
import com.google.common.util.concurrent.ServiceManager;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import java.util.Set;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class ServiceManagerModule_ProvideServiceManagerFactory
    implements Factory<ServiceManager> {
  private final ServiceManagerModule module;

  private final Provider<Set<Service>> servicesProvider;

  private final Provider<Thread.UncaughtExceptionHandler> uncaughtExceptionHandlerProvider;

  public ServiceManagerModule_ProvideServiceManagerFactory(
      ServiceManagerModule module,
      Provider<Set<Service>> servicesProvider,
      Provider<Thread.UncaughtExceptionHandler> uncaughtExceptionHandlerProvider) {
    assert module != null;
    this.module = module;
    assert servicesProvider != null;
    this.servicesProvider = servicesProvider;
    assert uncaughtExceptionHandlerProvider != null;
    this.uncaughtExceptionHandlerProvider = uncaughtExceptionHandlerProvider;
  }

  @Override
  public ServiceManager get() {
    return Preconditions.checkNotNull(
        module.provideServiceManager(
            servicesProvider.get(), uncaughtExceptionHandlerProvider.get()),
        "Cannot return null from a non-@Nullable @Provides method");
  }

  public static Factory<ServiceManager> create(
      ServiceManagerModule module,
      Provider<Set<Service>> servicesProvider,
      Provider<Thread.UncaughtExceptionHandler> uncaughtExceptionHandlerProvider) {
    return new ServiceManagerModule_ProvideServiceManagerFactory(
        module, servicesProvider, uncaughtExceptionHandlerProvider);
  }
}
