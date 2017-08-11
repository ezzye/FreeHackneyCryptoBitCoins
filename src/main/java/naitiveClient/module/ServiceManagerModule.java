package naitiveClient.module;

import com.google.common.util.concurrent.Service;
import com.google.common.util.concurrent.ServiceManager;
import com.google.common.util.concurrent.UncaughtExceptionHandlers;
import dagger.Module;
import dagger.Provides;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Singleton;
import java.util.Set;

@Module
public class ServiceManagerModule {
    private static final Logger LOGGER = LoggerFactory.getLogger(ServiceManagerModule.class);

    @Provides
    @Singleton
    public Thread.UncaughtExceptionHandler provideUncaughtExceptionHandler() {
        return UncaughtExceptionHandlers.systemExit();
    }

    @Provides
    @Singleton
    public ServiceManager provideServiceManager(
            Set<Service> services,
            Thread.UncaughtExceptionHandler uncaughtExceptionHandler
    ) {
        ServiceManager serviceManager = new ServiceManager(services);
        serviceManager.addListener(new ServiceManager.Listener() {
            @Override public void healthy() {
                serviceManager.startupTimes().entrySet()
                        .forEach(e -> LOGGER.info("{} started in {}ms", e.getKey(), e.getValue()));
                LOGGER.info("Component Ready");
            }

            @Override public void failure(Service service) {
                uncaughtExceptionHandler.uncaughtException(Thread.currentThread(), service.failureCause());
            }
        });

        Runtime.getRuntime().addShutdownHook(new Thread(() -> serviceManager.stopAsync().awaitStopped()));

        return serviceManager;
    }
}