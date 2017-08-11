package naitiveClient.module;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class ServiceManagerModule_ProvideUncaughtExceptionHandlerFactory
    implements Factory<Thread.UncaughtExceptionHandler> {
  private final ServiceManagerModule module;

  public ServiceManagerModule_ProvideUncaughtExceptionHandlerFactory(ServiceManagerModule module) {
    assert module != null;
    this.module = module;
  }

  @Override
  public Thread.UncaughtExceptionHandler get() {
    return Preconditions.checkNotNull(
        module.provideUncaughtExceptionHandler(),
        "Cannot return null from a non-@Nullable @Provides method");
  }

  public static Factory<Thread.UncaughtExceptionHandler> create(ServiceManagerModule module) {
    return new ServiceManagerModule_ProvideUncaughtExceptionHandlerFactory(module);
  }
}
