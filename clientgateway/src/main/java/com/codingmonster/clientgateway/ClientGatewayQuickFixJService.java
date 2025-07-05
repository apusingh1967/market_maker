package com.codingmonster.clientgateway;

import com.codingmonster.common.sbe.*;
import io.aeron.Aeron;
import io.aeron.Publication;
import java.nio.ByteBuffer;
import java.util.concurrent.CountDownLatch;
import org.agrona.concurrent.IdleStrategy;
import org.agrona.concurrent.UnsafeBuffer;
import org.agrona.concurrent.YieldingIdleStrategy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import quickfix.*;

public class ClientGatewayQuickFixJService implements Application {

  private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());
  private final Aeron aeron;
  private final Publication publication;
  private final UnsafeBuffer sendBuffer = new UnsafeBuffer(ByteBuffer.allocateDirect(256));

  private final MessageHeaderEncoder headerEncoder = new MessageHeaderEncoder();
  private final MessageHeaderDecoder headerDecoder = new MessageHeaderDecoder();
  private final NewOrderMessageEncoder orderEncoder = new NewOrderMessageEncoder();
  private final NewOrderMessageDecoder orderMessageDecoder = new NewOrderMessageDecoder();
  private final IdleStrategy idleStrategy = new YieldingIdleStrategy();
  private int orderId;

  private SocketInitiator initiator;

  public ClientGatewayQuickFixJService(
      Aeron aeron, String pubChannel, int pubStreamId, String cfgFile) {
    this.aeron = aeron;
    this.publication = aeron.addPublication(pubChannel, pubStreamId);
    try {
      SessionSettings settings = new SessionSettings(cfgFile);
      Application application = this;
      MessageStoreFactory storeFactory = new FileStoreFactory(settings);
      LogFactory logFactory = new FileLogFactory(settings);
      MessageFactory messageFactory = new DefaultMessageFactory();

      initiator =
          new SocketInitiator(application, storeFactory, settings, logFactory, messageFactory);
      initiator.start();
      new CountDownLatch(1).await();
    } catch (Exception e) {

    }
  }

  @Override
  public void onCreate(SessionID sessionId) {}

  @Override
  public void onLogon(SessionID sessionId) {}

  @Override
  public void onLogout(SessionID sessionId) {}

  @Override
  public void toAdmin(Message message, SessionID sessionId) {}

  @Override
  public void fromAdmin(Message message, SessionID sessionId)
      throws FieldNotFound, IncorrectDataFormat, IncorrectTagValue, RejectLogon {}

  @Override
  public void toApp(Message message, SessionID sessionId) throws DoNotSend {}

  @Override
  public void fromApp(Message message, SessionID sessionId)
      throws FieldNotFound, IncorrectDataFormat, IncorrectTagValue, UnsupportedMessageType {}
}
