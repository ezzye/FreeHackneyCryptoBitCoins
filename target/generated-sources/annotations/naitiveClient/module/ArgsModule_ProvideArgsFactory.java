package naitiveClient.module;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import naitiveClient.context.Args;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class ArgsModule_ProvideArgsFactory implements Factory<Args> {
  private final ArgsModule module;

  public ArgsModule_ProvideArgsFactory(ArgsModule module) {
    assert module != null;
    this.module = module;
  }

  @Override
  public Args get() {
    return Preconditions.checkNotNull(
        module.provideArgs(), "Cannot return null from a non-@Nullable @Provides method");
  }

  public static Factory<Args> create(ArgsModule module) {
    return new ArgsModule_ProvideArgsFactory(module);
  }
}
