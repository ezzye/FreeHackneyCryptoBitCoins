package naitiveClient;

import io.netty.channel.ChannelPipeline;
import uk.co.bbc.route.handler.HealthCheckHandler;
import uk.co.bbc.route.handler.NotFoundHandler;
import uk.co.bbc.route.handler.framework.NettyChannelInitializer;
import uk.co.bbc.route.handler.framework.RouterFactory;
import uk.co.bbc.route.handler.framework.StartRouting;
import uk.co.bbc.route.util.KeepAliveConfigurator;
import uk.co.bbc.snapshotable_stats.ext.ConnectionStatsLogger;

import javax.inject.Inject;

import static io.netty.handler.codec.http.HttpMethod.GET;

public class NaitiveClientHttpChannelInitializer extends NettyChannelInitializer {

    @Inject
    NaitiveClientHttpChannelInitializer(
            HealthCheckHandler healthCheckHandler,
            NotFoundHandler notFoundHandler,
            ConnectionStatsLogger connectionStatsLogger,
            KeepAliveConfigurator keepAliveConfigurator
    ) {
        super(
                null,
                healthCheckHandler,
                notFoundHandler,
                connectionStatsLogger,
null,
                keepAliveConfigurator,
                null
        );
    }

    protected void addRouting(ChannelPipeline pipeline) {
        new RouterFactory().router(pipeline)
                .custom(p -> p.addLast(new StartRouting()))
                .route()
                    .uri("/status")
                    .handle(GET, healthCheckHandler)
                .next()
                .route()
                    .uri("/healthcheck")
                    .handle(GET, healthCheckHandler)
                .next()
                .route()
                    .uri("/.*")
                    .handle(GET, notFoundHandler)
                .next()
                .end(notFoundHandler);
    }
}
