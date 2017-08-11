package naitiveClient.module;

import dagger.Module;
import dagger.Provides;
import naitiveClient.context.Args;
import uk.co.bbc.cliargs.ArgvParser;
import uk.co.bbc.contextsupplier.ContextSupplier;
import uk.co.bbc.ec2userdata.UserDataParser;

import javax.inject.Singleton;

@Module
public class ArgsModule {
    private final Args args = new Args();

    public ArgsModule(String[] rawArgs) throws ArgvParser.CmdLineValidationException {
        ArgvParser parser = new ArgvParser();
        parser.parse(rawArgs, args);
    }

    @Provides
    @Singleton
    public Args provideArgs() {
        return args;
    }

    @Provides
    public ContextSupplier<Args> provideContextSupplier(Args args, UserDataParser userDataParser) {
        return new ContextSupplier<>(args, userDataParser);
    }
}
