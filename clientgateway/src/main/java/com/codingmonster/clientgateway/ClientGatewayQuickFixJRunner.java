package com.codingmonster.clientgateway;

import io.aeron.Aeron;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ClientGatewayQuickFixJRunner {

  private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

  public ClientGatewayQuickFixJRunner(int pubStreamId, String pubChannel, String cfgFile) {
    try (Aeron aeron = Aeron.connect()) {
      new ClientGatewayQuickFixJService(aeron, pubChannel, pubStreamId, cfgFile);
    }
  }
}
