package naitiveClient;

import com.google.common.util.concurrent.ServiceManager;
import dagger.Component;
import naitiveClient.module.ArgsModule;
import naitiveClient.module.AwsModule;
import naitiveClient.module.NettyModule;
import naitiveClient.module.ServiceManagerModule;
import uk.co.bbc.cliargs.ArgvParser;

import javax.inject.Inject;
import javax.inject.Singleton;

@Component(modules = {
        ArgsModule.class,
        ServiceManagerModule.class,
        NettyModule.class,
        AwsModule.class
})

@Singleton
interface MainExecComponent {
    Main main();
}

public class Main {

    public static void main(String[] args) throws Exception {
        MainExecComponent mainComponent;
        try {
            mainComponent = DaggerMainExecComponent.builder()
                    .argsModule(new ArgsModule(args))
                    .build();
        } catch (ArgvParser.CmdLineValidationException ex) {
            System.err.println(ex.getMessage());
            System.exit(2);
            throw new AssertionError("unreachable");
        }

        Main main = mainComponent.main();
        main.start();
    }

    private final ServiceManager serviceManager;

    @Inject
    public Main(ServiceManager serviceManager) { this.serviceManager = serviceManager; }

    void start() throws Exception {
        serviceManager.startAsync();
        serviceManager.awaitStopped();
    }
}
