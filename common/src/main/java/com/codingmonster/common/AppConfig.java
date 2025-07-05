package com.codingmonster.common;

import java.util.List;

public class AppConfig {
  public AeronConfig aeron;

  public static class AeronConfig {
    public Component clientgateway;
    public Component executionalgos;
    public Component marketdata;
    public Component marketmaker;
    public Component matchingengine;
    public Component pricer;
  }

  public static class Component {
    public List<StreamConfig> instances;
  }

  public static class StreamConfig {
    public String sub_channel;
    public int sub_streamId;
    public String pub_channel;
    public int pub_streamId;
    public String id_file_path;

    public String cfg_file;
  }
}
