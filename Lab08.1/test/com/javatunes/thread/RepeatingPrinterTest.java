/*
 * This code is sample code, provided as-is, and we make no
 * warranties as to its correctness or suitability for
 * any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright LearningPatterns Inc.
 */
package com.javatunes.thread;

public class RepeatingPrinterTest {

  public static void main(String[] args) {
    // Thread thd1 = new Thread(new RepeatingPrinter());
    // thd1.start();
    

    // TODO: create another Thread, passing in a lambda as its Runnable - then start it
    Thread thd2 = new Thread( () -> {
      while (true) {
        System.out.println("RepeatingPrinter.run");
        try {
          Thread.sleep(1000);
        }
        catch (InterruptedException e) {
        }
      }
    } );
  }
}