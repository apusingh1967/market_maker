package com.codingmonster.common;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import java.io.IOException;
import java.io.InputStream;

public class ConfigReader {

  public static AppConfig getConfig(String env) {
    ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
    try {
      InputStream input =
          AppConfig.class.getClassLoader().getResourceAsStream(env + "/config.yaml");
      return mapper.readValue(input, AppConfig.class);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }
}
