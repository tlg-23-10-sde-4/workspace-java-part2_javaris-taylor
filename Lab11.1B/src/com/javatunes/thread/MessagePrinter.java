/*
 * This code is sample code, provided AS-IS, and we make NO
 * warranties as to its correctness or suitability for any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright LearningPatterns Inc.
 */
package com.javatunes.thread;

public class  MessagePrinter extends Thread {
  private final String message;
  private String threadName = "Jay's Poem Printer ";
  private static int id;
  private int count;
  private long interval;

  public MessagePrinter(String message) {
    this.message = message;
    setName(threadName + ++id);
  }
  public MessagePrinter(String message, int count, long interval) {
    this(message);
    this.count = count;
    this.interval = interval;
    // TODO: set the thread name [important when debugging]

  }
  
  /**
   * TODO: implement run() as follows:
   * It should loop 10 times, printing the 'message' field to stdout,
   * then pausing for some interval (in millis) that you choose.
   * 
   * Use a try/catch to call Thread.sleep(interval) for the pause.
   * The sleep() method throws InterruptedException, which you need to catch.
   * You can either leave the catch block empty, or print the exception to stdout.
   */
  public void run() {
    for(int i = 0; i < count; i++) {
      System.out.println(getName() + ": " + message);
      try {
        Thread.sleep(interval); // pause for designated time
      }
      catch(Exception e) {

      }

    }
  }
}