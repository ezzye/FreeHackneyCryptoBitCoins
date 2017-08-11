package uk.co.bbc.snapshotable_stats.ext;

import dagger.internal.Factory;
import javax.annotation.Generated;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public enum ConnectionStatsLogger_Factory implements Factory<ConnectionStatsLogger> {
  INSTANCE;

  @Override
  public ConnectionStatsLogger get() {
    return new ConnectionStatsLogger();
  }

  public static Factory<ConnectionStatsLogger> create() {
    return INSTANCE;
  }
}
