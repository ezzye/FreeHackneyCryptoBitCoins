package naitiveClient.module;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;
import naitiveClient.context.Args;
import uk.co.bbc.ec2userdata.UserDataParser;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class AwsModule_ProvideUserDataParserFactory implements Factory<UserDataParser> {
  private final AwsModule module;

  private final Provider<Args> argsProvider;

  public AwsModule_ProvideUserDataParserFactory(AwsModule module, Provider<Args> argsProvider) {
    assert module != null;
    this.module = module;
    assert argsProvider != null;
    this.argsProvider = argsProvider;
  }

  @Override
  public UserDataParser get() {
    return Preconditions.checkNotNull(
        module.provideUserDataParser(argsProvider.get()),
        "Cannot return null from a non-@Nullable @Provides method");
  }

  public static Factory<UserDataParser> create(AwsModule module, Provider<Args> argsProvider) {
    return new AwsModule_ProvideUserDataParserFactory(module, argsProvider);
  }
}
