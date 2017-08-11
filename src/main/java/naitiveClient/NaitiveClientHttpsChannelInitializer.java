package naitiveClient;

import io.netty.channel.ChannelPipeline;
import io.netty.handler.ssl.SslContext;
import uk.co.bbc.route.handler.HealthCheckHandler;
import uk.co.bbc.route.handler.NotFoundHandler;
import uk.co.bbc.route.handler.framework.NettyChannelInitializer;
import uk.co.bbc.route.handler.framework.RouteHandler;
import uk.co.bbc.route.handler.framework.RouterFactory;
import uk.co.bbc.route.handler.framework.StartRouting;
import uk.co.bbc.route.util.KeepAliveConfigurator;
import uk.co.bbc.route.util.UriValueKey;
import uk.co.bbc.snapshotable_stats.ext.ConnectionStatsLogger;

import javax.annotation.Nullable;
import javax.inject.Inject;

import static io.netty.handler.codec.http.HttpMethod.GET;

//This need to have a naitiveClient routehandler to make response to for mock lambda see availabilityReader.

public class NaitiveClientHttpsChannelInitializer extends NettyChannelInitializer {

    @Inject
    NaitiveClientHttpsChannelInitializer(
            HealthCheckHandler healthCheckHandler,
            NotFoundHandler notFoundHandler,
            ConnectionStatsLogger connectionStatsLogger,
            KeepAliveConfigurator keepAliveConfigurator,
            @Nullable SslContext sslContext
    ) {
        super(
                null,
                healthCheckHandler,
                notFoundHandler,
                connectionStatsLogger,
null,
                keepAliveConfigurator,
                sslContext
        );
    }


    protected void addRouting(ChannelPipeline pipeline) {
        new RouterFactory().router(pipeline)
                .custom(p -> p.addLast(new StartRouting()))
                .route()
                    .uri("/healthcheck")
                    .handle(GET, this.healthCheckHandler)
                .next()
                .end(this.notFoundHandler);
    }
}
