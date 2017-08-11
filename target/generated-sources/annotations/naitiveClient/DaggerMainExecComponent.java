package naitiveClient;

import com.google.common.util.concurrent.Service;
import com.google.common.util.concurrent.ServiceManager;
import dagger.internal.DoubleCheck;
import dagger.internal.MembersInjectors;
import dagger.internal.Preconditions;
import dagger.internal.SetFactory;
import io.netty.handler.ssl.SslContext;
import java.util.Set;
import javax.annotation.Generated;
import javax.inject.Provider;
import naitiveClient.context.Args;
import naitiveClient.module.ArgsModule;
import naitiveClient.module.ArgsModule_ProvideArgsFactory;
import naitiveClient.module.ArgsModule_ProvideContextSupplierFactory;
import naitiveClient.module.AwsModule;
import naitiveClient.module.AwsModule_ProvideUserDataParserFactory;
import naitiveClient.module.NettyModule;
import naitiveClient.module.NettyModule_ProvideNettyContextServiceFactory;
import naitiveClient.module.NettyModule_ProvideServerCertFactory;
import naitiveClient.module.NettyModule_ProvideSslContextFactory;
import naitiveClient.module.NettyModule_ProvideTrustStoreFactory;
import naitiveClient.module.ServiceManagerModule;
import naitiveClient.module.ServiceManagerModule_ProvideServiceManagerFactory;
import naitiveClient.module.ServiceManagerModule_ProvideUncaughtExceptionHandlerFactory;
import uk.co.bbc.contextsupplier.ContextSupplier;
import uk.co.bbc.ec2userdata.UserDataParser;
import uk.co.bbc.route.handler.HealthCheckHandler_Factory;
import uk.co.bbc.route.handler.NotFoundHandler_Factory;
import uk.co.bbc.route.util.CertDetails;
import uk.co.bbc.route.util.KeepAliveConfigurator_Factory;
import uk.co.bbc.snapshotable_stats.ext.ConnectionStatsLogger;
import uk.co.bbc.snapshotable_stats.ext.ConnectionStatsLogger_Factory;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class DaggerMainExecComponent implements MainExecComponent {
  private Provider<Args> provideArgsProvider;

  private Provider<UserDataParser> provideUserDataParserProvider;

  private Provider<ContextSupplier<Args>> provideContextSupplierProvider;

  private Provider<ConnectionStatsLogger> connectionStatsLoggerProvider;

  private Provider<NaitiveClientHttpChannelInitializer> naitiveClientHttpChannelInitializerProvider;

  private Provider<CertDetails> provideServerCertProvider;

  private Provider<CertDetails> provideTrustStoreProvider;

  private Provider<SslContext> provideSslContextProvider;

  private Provider<NaitiveClientHttpsChannelInitializer>
      naitiveClientHttpsChannelInitializerProvider;

  private Provider<Service> provideNettyContextServiceProvider;

  private Provider<Set<Service>> setOfServiceProvider;

  private Provider<Thread.UncaughtExceptionHandler> provideUncaughtExceptionHandlerProvider;

  private Provider<ServiceManager> provideServiceManagerProvider;

  private Provider<Main> mainProvider;

  private DaggerMainExecComponent(Builder builder) {
    assert builder != null;
    initialize(builder);
  }

  public static Builder builder() {
    return new Builder();
  }

  @SuppressWarnings("unchecked")
  private void initialize(final Builder builder) {

    this.provideArgsProvider =
        DoubleCheck.provider(ArgsModule_ProvideArgsFactory.create(builder.argsModule));

    this.provideUserDataParserProvider =
        DoubleCheck.provider(
            AwsModule_ProvideUserDataParserFactory.create(builder.awsModule, provideArgsProvider));

    this.provideContextSupplierProvider =
        ArgsModule_ProvideContextSupplierFactory.create(
            builder.argsModule, provideArgsProvider, provideUserDataParserProvider);

    this.connectionStatsLoggerProvider =
        DoubleCheck.provider(ConnectionStatsLogger_Factory.create());

    this.naitiveClientHttpChannelInitializerProvider =
        NaitiveClientHttpChannelInitializer_Factory.create(
            MembersInjectors.<NaitiveClientHttpChannelInitializer>noOp(),
            HealthCheckHandler_Factory.create(),
            NotFoundHandler_Factory.create(),
            connectionStatsLoggerProvider,
            KeepAliveConfigurator_Factory.create());

    this.provideServerCertProvider =
        NettyModule_ProvideServerCertFactory.create(
            builder.nettyModule, provideContextSupplierProvider);

    this.provideTrustStoreProvider =
        NettyModule_ProvideTrustStoreFactory.create(
            builder.nettyModule, provideContextSupplierProvider);

    this.provideSslContextProvider =
        NettyModule_ProvideSslContextFactory.create(
            builder.nettyModule, provideServerCertProvider, provideTrustStoreProvider);

    this.naitiveClientHttpsChannelInitializerProvider =
        NaitiveClientHttpsChannelInitializer_Factory.create(
            MembersInjectors.<NaitiveClientHttpsChannelInitializer>noOp(),
            HealthCheckHandler_Factory.create(),
            NotFoundHandler_Factory.create(),
            connectionStatsLoggerProvider,
            KeepAliveConfigurator_Factory.create(),
            provideSslContextProvider);

    this.provideNettyContextServiceProvider =
        NettyModule_ProvideNettyContextServiceFactory.create(
            builder.nettyModule,
            provideContextSupplierProvider,
            naitiveClientHttpChannelInitializerProvider,
            naitiveClientHttpsChannelInitializerProvider);

    this.setOfServiceProvider =
        SetFactory.<Service>builder(1, 0).addProvider(provideNettyContextServiceProvider).build();

    this.provideUncaughtExceptionHandlerProvider =
        DoubleCheck.provider(
            ServiceManagerModule_ProvideUncaughtExceptionHandlerFactory.create(
                builder.serviceManagerModule));

    this.provideServiceManagerProvider =
        DoubleCheck.provider(
            ServiceManagerModule_ProvideServiceManagerFactory.create(
                builder.serviceManagerModule,
                setOfServiceProvider,
                provideUncaughtExceptionHandlerProvider));

    this.mainProvider = Main_Factory.create(provideServiceManagerProvider);
  }

  @Override
  public Main main() {
    return mainProvider.get();
  }

  public static final class Builder {
    private ArgsModule argsModule;

    private AwsModule awsModule;

    private NettyModule nettyModule;

    private ServiceManagerModule serviceManagerModule;

    private Builder() {}

    public MainExecComponent build() {
      if (argsModule == null) {
        throw new IllegalStateException(ArgsModule.class.getCanonicalName() + " must be set");
      }
      if (awsModule == null) {
        this.awsModule = new AwsModule();
      }
      if (nettyModule == null) {
        this.nettyModule = new NettyModule();
      }
      if (serviceManagerModule == null) {
        this.serviceManagerModule = new ServiceManagerModule();
      }
      return new DaggerMainExecComponent(this);
    }

    public Builder argsModule(ArgsModule argsModule) {
      this.argsModule = Preconditions.checkNotNull(argsModule);
      return this;
    }

    public Builder serviceManagerModule(ServiceManagerModule serviceManagerModule) {
      this.serviceManagerModule = Preconditions.checkNotNull(serviceManagerModule);
      return this;
    }

    public Builder nettyModule(NettyModule nettyModule) {
      this.nettyModule = Preconditions.checkNotNull(nettyModule);
      return this;
    }

    public Builder awsModule(AwsModule awsModule) {
      this.awsModule = Preconditions.checkNotNull(awsModule);
      return this;
    }
  }
}
