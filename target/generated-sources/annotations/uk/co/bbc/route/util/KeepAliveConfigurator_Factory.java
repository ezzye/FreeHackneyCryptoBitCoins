package uk.co.bbc.route.util;

import dagger.internal.Factory;
import javax.annotation.Generated;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public enum KeepAliveConfigurator_Factory implements Factory<KeepAliveConfigurator> {
  INSTANCE;

  @Override
  public KeepAliveConfigurator get() {
    return new KeepAliveConfigurator();
  }

  public static Factory<KeepAliveConfigurator> create() {
    return INSTANCE;
  }
}
