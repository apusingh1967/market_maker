package com.codingmonster.marketmaker;

import io.aeron.Aeron;
import org.agrona.concurrent.Agent;
import org.agrona.concurrent.AgentRunner;
import org.agrona.concurrent.YieldingIdleStrategy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MarketMakerAgentRunner {

  private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

  private final int subStreamId;
  private final int pubStreamId;
  private final String pubChannel;
  private final String subChannel;
  private final String idFilePath;

  public MarketMakerAgentRunner(
      int subStreamId, int pubStreamId, String subChannel, String pubChannel, String idFilePath) {
    this.subStreamId = subStreamId;
    this.pubStreamId = pubStreamId;
    this.subChannel = subChannel;
    this.pubChannel = pubChannel;
    this.idFilePath = idFilePath;
  }

  void start() {
    try (Aeron aeron = Aeron.connect()) {
      Agent agent =
          new MarketMakerAgent(aeron, pubChannel, pubStreamId, subChannel, subStreamId, idFilePath);
      AgentRunner runner =
          new AgentRunner(
              new YieldingIdleStrategy(), // Low-latency idle
              Throwable::printStackTrace, // Error handler
              null, // Optional metrics
              agent);
      AgentRunner.startOnThread(runner);
    }
  }
}
