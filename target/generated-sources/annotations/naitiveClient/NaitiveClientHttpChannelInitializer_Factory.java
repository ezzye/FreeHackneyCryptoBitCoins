package naitiveClient;

import dagger.MembersInjector;
import dagger.internal.Factory;
import dagger.internal.MembersInjectors;
import javax.annotation.Generated;
import javax.inject.Provider;
import uk.co.bbc.route.handler.HealthCheckHandler;
import uk.co.bbc.route.handler.NotFoundHandler;
import uk.co.bbc.route.util.KeepAliveConfigurator;
import uk.co.bbc.snapshotable_stats.ext.ConnectionStatsLogger;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class NaitiveClientHttpChannelInitializer_Factory
    implements Factory<NaitiveClientHttpChannelInitializer> {
  private final MembersInjector<NaitiveClientHttpChannelInitializer>
      naitiveClientHttpChannelInitializerMembersInjector;

  private final Provider<HealthCheckHandler> healthCheckHandlerProvider;

  private final Provider<NotFoundHandler> notFoundHandlerProvider;

  private final Provider<ConnectionStatsLogger> connectionStatsLoggerProvider;

  private final Provider<KeepAliveConfigurator> keepAliveConfiguratorProvider;

  public NaitiveClientHttpChannelInitializer_Factory(
      MembersInjector<NaitiveClientHttpChannelInitializer>
          naitiveClientHttpChannelInitializerMembersInjector,
      Provider<HealthCheckHandler> healthCheckHandlerProvider,
      Provider<NotFoundHandler> notFoundHandlerProvider,
      Provider<ConnectionStatsLogger> connectionStatsLoggerProvider,
      Provider<KeepAliveConfigurator> keepAliveConfiguratorProvider) {
    assert naitiveClientHttpChannelInitializerMembersInjector != null;
    this.naitiveClientHttpChannelInitializerMembersInjector =
        naitiveClientHttpChannelInitializerMembersInjector;
    assert healthCheckHandlerProvider != null;
    this.healthCheckHandlerProvider = healthCheckHandlerProvider;
    assert notFoundHandlerProvider != null;
    this.notFoundHandlerProvider = notFoundHandlerProvider;
    assert connectionStatsLoggerProvider != null;
    this.connectionStatsLoggerProvider = connectionStatsLoggerProvider;
    assert keepAliveConfiguratorProvider != null;
    this.keepAliveConfiguratorProvider = keepAliveConfiguratorProvider;
  }

  @Override
  public NaitiveClientHttpChannelInitializer get() {
    return MembersInjectors.injectMembers(
        naitiveClientHttpChannelInitializerMembersInjector,
        new NaitiveClientHttpChannelInitializer(
            healthCheckHandlerProvider.get(),
            notFoundHandlerProvider.get(),
            connectionStatsLoggerProvider.get(),
            keepAliveConfiguratorProvider.get()));
  }

  public static Factory<NaitiveClientHttpChannelInitializer> create(
      MembersInjector<NaitiveClientHttpChannelInitializer>
          naitiveClientHttpChannelInitializerMembersInjector,
      Provider<HealthCheckHandler> healthCheckHandlerProvider,
      Provider<NotFoundHandler> notFoundHandlerProvider,
      Provider<ConnectionStatsLogger> connectionStatsLoggerProvider,
      Provider<KeepAliveConfigurator> keepAliveConfiguratorProvider) {
    return new NaitiveClientHttpChannelInitializer_Factory(
        naitiveClientHttpChannelInitializerMembersInjector,
        healthCheckHandlerProvider,
        notFoundHandlerProvider,
        connectionStatsLoggerProvider,
        keepAliveConfiguratorProvider);
  }
}
