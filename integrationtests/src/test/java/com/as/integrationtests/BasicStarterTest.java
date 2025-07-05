package com.as.integrationtests;

import com.as.marketdata.StartMarketData;
import org.junit.jupiter.api.Test;

public class BasicStarterTest {

  @Test
  public void start() {
    new StartMarketData().start();
  }
}
