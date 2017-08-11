package naitiveClient;

import com.google.common.util.concurrent.ServiceManager;
import dagger.internal.Factory;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class Main_Factory implements Factory<Main> {
  private final Provider<ServiceManager> serviceManagerProvider;

  public Main_Factory(Provider<ServiceManager> serviceManagerProvider) {
    assert serviceManagerProvider != null;
    this.serviceManagerProvider = serviceManagerProvider;
  }

  @Override
  public Main get() {
    return new Main(serviceManagerProvider.get());
  }

  public static Factory<Main> create(Provider<ServiceManager> serviceManagerProvider) {
    return new Main_Factory(serviceManagerProvider);
  }
}
