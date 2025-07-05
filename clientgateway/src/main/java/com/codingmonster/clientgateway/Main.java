package com.codingmonster.clientgateway;

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
    configs.aeron.clientgateway.instances.forEach(
        (config) ->
            new ClientGatewayQuickFixJRunner(
                config.pub_streamId, config.pub_channel, config.cfg_file));
    LOGGER.info("started clientgateway");
  }
}
