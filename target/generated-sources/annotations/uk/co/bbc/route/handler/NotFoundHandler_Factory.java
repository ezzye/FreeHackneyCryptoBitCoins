package uk.co.bbc.route.handler;

import dagger.internal.Factory;
import javax.annotation.Generated;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public enum NotFoundHandler_Factory implements Factory<NotFoundHandler> {
  INSTANCE;

  @Override
  public NotFoundHandler get() {
    return new NotFoundHandler();
  }

  public static Factory<NotFoundHandler> create() {
    return INSTANCE;
  }
}
