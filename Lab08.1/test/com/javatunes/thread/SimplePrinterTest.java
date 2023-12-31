/*
 * This code is sample code, provided as-is, and we make no
 * warranties as to its correctness or suitability for
 * any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright LearningPatterns Inc.
 */
package com.javatunes.thread;

public class SimplePrinterTest {

  public static void main(String[] args) {
    Thread thd1 = new Thread(new SimplePrinter()); // Simple Printer IS-A runnable
    thd1.start();
    
    // create another Thread, passing in a lambda as its Runnable - then start it
    Thread thd2 = new Thread( () -> System.out.println("Lambda as the runnable"));
    thd2.start();

  }
}