package com.codingmonster.marketmaker;

import java.io.*;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.locks.ReentrantLock;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class OrderIdGenerator {

  private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());
  private final AtomicLong nextId;
  private final File idFile;
  private final ReentrantLock fileLock = new ReentrantLock();

  public OrderIdGenerator(String path) {
    this.idFile = new File(path);
    long startingId = 0;
    try {
      startingId = readLastIdFromFile();
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
    this.nextId = new AtomicLong(startingId);
  }

  public long nextId() {
    long id = nextId.getAndIncrement();
    saveLastIdToFile(id);
    return id;
  }

  private long readLastIdFromFile() throws IOException {
    if (!idFile.exists()) return 1;
    try (BufferedReader reader = new BufferedReader(new FileReader(idFile))) {
      return Long.parseLong(reader.readLine().trim()) + 1; // start from next
    }
  }

  private void saveLastIdToFile(long id) {
    fileLock.lock();
    try (BufferedWriter writer = new BufferedWriter(new FileWriter(idFile))) {
      writer.write(Long.toString(id));
    } catch (IOException e) {
      e.printStackTrace(); // or proper logging
    } finally {
      fileLock.unlock();
    }
  }
}
