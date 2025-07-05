package com.codingmonster.marketmaker;

import com.codingmonster.common.AppConfig;
import com.codingmonster.common.ConfigReader;
import java.io.File;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main implements Runnable {
  private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

  public static void main(String[] args) {
    new Main().run();
  }

  @Override
  public void run() {
    final String env =
        System.getenv("ENV") == null ? "dev" : System.getenv("ENV"); // default to dev

    AppConfig configs = ConfigReader.getConfig(env);
    configs.aeron.marketmaker.instances.forEach(
        (config) -> {
          String idFilePath = config.id_file_path;
          if (env.equals("dev")) {
            idFilePath = System.getProperty("user.home") + File.separator + idFilePath;
          }
          new MarketMakerAgentRunner(
                  config.sub_streamId,
                  config.pub_streamId,
                  config.sub_channel,
                  config.pub_channel,
                  idFilePath)
              .start();
        });
    LOGGER.info("started marketmaker");
  }
}
