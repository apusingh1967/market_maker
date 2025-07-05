package com.codingmonster.executionalgos;

import com.codingmonster.common.AppConfig;
import com.codingmonster.common.ConfigReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main implements Runnable {
  private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

  public static void main(String[] args) {
    new Main().run();
  }

  @Override
  public void run() {
    String env = System.getenv("ENV");
    if (env == null) {
      env = System.getProperty("env", "dev"); // default to dev
    }

    AppConfig configs = ConfigReader.getConfig(env);
    configs.aeron.executionalgos.instances.forEach(
        (config) ->
            new ExecutionAlgosAgentRunner(
                    config.sub_streamId,
                    config.pub_streamId,
                    config.sub_channel,
                    config.pub_channel)
                .start());
    LOGGER.info("started executionalgos");
  }
}
