/*
 * This code is sample code, provided AS-IS, and we make NO
 * warranties as to its correctness or suitability for any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright LearningPatterns Inc.
 */
package com.javatunes.thread;

public class MessagePrinterClient {

  public static void main(String[] args) {
    // TODO: create two instances of your thread subclass and start them up
    MessagePrinter printer1 = new MessagePrinter("Roses are Red", 15, 1000);
    MessagePrinter printer2 = new MessagePrinter("Violets are Blue", 5, 3000);
    MessagePrinter printer3 = new MessagePrinter("For some reason Coffee", 5, 3000);
    MessagePrinter printer4 = new MessagePrinter("Makes me Poo", 3, 5000);

    printer1.start();
    printer2.start();
    printer3.start();
    printer4.start();
  }
}