package uk.co.bbc.route.handler;

import dagger.internal.Factory;
import javax.annotation.Generated;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public enum HealthCheckHandler_Factory implements Factory<HealthCheckHandler> {
  INSTANCE;

  @Override
  public HealthCheckHandler get() {
    return new HealthCheckHandler();
  }

  public static Factory<HealthCheckHandler> create() {
    return INSTANCE;
  }
}
