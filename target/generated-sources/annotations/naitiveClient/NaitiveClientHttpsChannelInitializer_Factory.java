package naitiveClient;

import dagger.MembersInjector;
import dagger.internal.Factory;
import dagger.internal.MembersInjectors;
import io.netty.handler.ssl.SslContext;
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
public final class NaitiveClientHttpsChannelInitializer_Factory
    implements Factory<NaitiveClientHttpsChannelInitializer> {
  private final MembersInjector<NaitiveClientHttpsChannelInitializer>
      naitiveClientHttpsChannelInitializerMembersInjector;

  private final Provider<HealthCheckHandler> healthCheckHandlerProvider;

  private final Provider<NotFoundHandler> notFoundHandlerProvider;

  private final Provider<ConnectionStatsLogger> connectionStatsLoggerProvider;

  private final Provider<KeepAliveConfigurator> keepAliveConfiguratorProvider;

  private final Provider<SslContext> sslContextProvider;

  public NaitiveClientHttpsChannelInitializer_Factory(
      MembersInjector<NaitiveClientHttpsChannelInitializer>
          naitiveClientHttpsChannelInitializerMembersInjector,
      Provider<HealthCheckHandler> healthCheckHandlerProvider,
      Provider<NotFoundHandler> notFoundHandlerProvider,
      Provider<ConnectionStatsLogger> connectionStatsLoggerProvider,
      Provider<KeepAliveConfigurator> keepAliveConfiguratorProvider,
      Provider<SslContext> sslContextProvider) {
    assert naitiveClientHttpsChannelInitializerMembersInjector != null;
    this.naitiveClientHttpsChannelInitializerMembersInjector =
        naitiveClientHttpsChannelInitializerMembersInjector;
    assert healthCheckHandlerProvider != null;
    this.healthCheckHandlerProvider = healthCheckHandlerProvider;
    assert notFoundHandlerProvider != null;
    this.notFoundHandlerProvider = notFoundHandlerProvider;
    assert connectionStatsLoggerProvider != null;
    this.connectionStatsLoggerProvider = connectionStatsLoggerProvider;
    assert keepAliveConfiguratorProvider != null;
    this.keepAliveConfiguratorProvider = keepAliveConfiguratorProvider;
    assert sslContextProvider != null;
    this.sslContextProvider = sslContextProvider;
  }

  @Override
  public NaitiveClientHttpsChannelInitializer get() {
    return MembersInjectors.injectMembers(
        naitiveClientHttpsChannelInitializerMembersInjector,
        new NaitiveClientHttpsChannelInitializer(
            healthCheckHandlerProvider.get(),
            notFoundHandlerProvider.get(),
            connectionStatsLoggerProvider.get(),
            keepAliveConfiguratorProvider.get(),
            sslContextProvider.get()));
  }

  public static Factory<NaitiveClientHttpsChannelInitializer> create(
      MembersInjector<NaitiveClientHttpsChannelInitializer>
          naitiveClientHttpsChannelInitializerMembersInjector,
      Provider<HealthCheckHandler> healthCheckHandlerProvider,
      Provider<NotFoundHandler> notFoundHandlerProvider,
      Provider<ConnectionStatsLogger> connectionStatsLoggerProvider,
      Provider<KeepAliveConfigurator> keepAliveConfiguratorProvider,
      Provider<SslContext> sslContextProvider) {
    return new NaitiveClientHttpsChannelInitializer_Factory(
        naitiveClientHttpsChannelInitializerMembersInjector,
        healthCheckHandlerProvider,
        notFoundHandlerProvider,
        connectionStatsLoggerProvider,
        keepAliveConfiguratorProvider,
        sslContextProvider);
  }
}
