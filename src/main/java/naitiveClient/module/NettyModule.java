package naitiveClient.module;

import com.google.common.util.concurrent.Service;
import dagger.Module;
import dagger.Provides;
import dagger.multibindings.IntoSet;
import io.netty.handler.ssl.SslContext;
import naitiveClient.NaitiveClientHttpChannelInitializer;
import naitiveClient.NaitiveClientHttpsChannelInitializer;
import naitiveClient.context.Args;
import naitiveClient.context.ContextProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import uk.co.bbc.contextsupplier.ContextSupplier;
import uk.co.bbc.contextsupplier.PropertyValue;
import uk.co.bbc.route.handler.framework.NettyContextService;
import uk.co.bbc.route.util.CertDetails;
import uk.co.bbc.route.util.SslContextSupplier;

import javax.annotation.Nullable;
import javax.inject.Named;
import javax.net.ssl.SSLException;
import java.util.Optional;

@Module
public class NettyModule {
    private static final Logger LOGGER = LoggerFactory.getLogger(NettyModule.class);

    public static final String NAME_SERVER_CERT = "server-cert";
    public static final String NAME_TRUST_STORE = "trust-store";
    public static final String NAME_CLIENT_CERT = "client-cert";

    @Provides @IntoSet
    Service provideNettyContextService(
            ContextSupplier<Args> contextSupplier,
            NaitiveClientHttpChannelInitializer httpChannelInitializer,
            NaitiveClientHttpsChannelInitializer httpsChannelInitializer
    ) {
        String bind = contextSupplier.get(ContextProperties.StringProperty.BIND);
        int httpPort = contextSupplier.get(ContextProperties.IntegerProperty.HTTP_PORT_NUM);
        int httpsPort = contextSupplier.get(ContextProperties.IntegerProperty.HTTPS_PORT_NUM);
        return new NettyContextService(
                bind,
                httpPort,
                httpsPort,
                httpChannelInitializer,
                httpsChannelInitializer,
                null
        );
    }

    @Provides @Named(NAME_SERVER_CERT)
    CertDetails provideServerCert(ContextSupplier<Args> contextSupplier) {
        return genericProvideCert(contextSupplier, "ServerCert", ContextProperties.StringProperty.SERVER_CERT, ContextProperties.StringProperty.SERVER_CERT_PASS);
    }

    @Provides @Named(NAME_TRUST_STORE)
    CertDetails provideTrustStore(ContextSupplier<Args> contextSupplier) {
        return genericProvideCert(contextSupplier, "TrustStore", ContextProperties.StringProperty.TRUST_STORE, ContextProperties.StringProperty.TRUST_STORE_PASS);
    }

    @Provides @Named(NAME_CLIENT_CERT)
    CertDetails provideClientCert(ContextSupplier<Args> contextSupplier) {
        return genericProvideCert(contextSupplier, "ClientCert", ContextProperties.StringProperty.CLIENT_CERT, ContextProperties.StringProperty.CLIENT_CERT_PASS);
    }

    private CertDetails genericProvideCert(
            ContextSupplier<Args> contextSupplier,
            String name, PropertyValue<Args, String> cert, PropertyValue<Args, String> certPass) {
       return new CertDetails(name,  contextSupplier.getOptional(cert),  contextSupplier.getOptional(certPass));
    }

    @Provides @Nullable
    SslContext provideSslContext(
            @Named(NAME_SERVER_CERT) CertDetails server,
            @Named(NAME_TRUST_STORE) CertDetails trust
    ) {
        try {
            Optional<SslContext> sslContext =
                    new SslContextSupplier()
                            .serverCert(server.getCert(), server.getPass())
                            .trustStore(trust.getCert(), trust.getPass())
                            .supply();
            return sslContext.isPresent() ? sslContext.get() : null;
        } catch (SSLException e) {
            // TODO: 07/03/2017 How should this be handled
            e.printStackTrace();
            return null;
        }
    }

}
