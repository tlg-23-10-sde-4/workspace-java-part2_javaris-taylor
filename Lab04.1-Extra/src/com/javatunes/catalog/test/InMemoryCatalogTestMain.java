/*
 * This code is sample code, provided as-is, and we make no
 * warranties as to its correctness or suitability for any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright LearningPatterns Inc.
 */

package com.javatunes.catalog.test;

import com.javatunes.catalog.Catalog;
import com.javatunes.catalog.InMemoryCatalog;
import com.javatunes.catalog.MusicCategory;
import com.javatunes.catalog.MusicItem;

import java.util.Collection;

class InMemoryCatalogTestMain {

    /*
     * One by one, complete each test method below, and then "activate" it by
     * uncommenting the call to that method in main().
     *
     * Once you see that the test method verifies the corresponding business method
     * works correctly, you can comment out that call in main() and proceed to the next one.
     */
    public static void main(String[] args) {
        // testFindById();
        // testFindByKeyword();
       // testFindByCategory();
        // testSize();
        // testGetAll();

        // Task Methods
        // testFindSelfTitled();
        // testFindCheapRock();
        // testNumberInGenre();
        // lowCostAverage();
        // testCheapestInGenre();
        //testAverageGenrePrice();
        // testPriceCheck();
        // testGenreCheck();
        // testGenreTitles();
        // testPriceCheckAdvanced();
    }

    private static void testFindSelfTitled() {
        InMemoryCatalog catalog = new InMemoryCatalog();
        dump(catalog.findSelfTitled());
    }
    private static void testFindCheapRock() {
        InMemoryCatalog catalog = new InMemoryCatalog();
        dump(catalog.findCheapRock(14));
    }

    private static void testNumberInGenre() {
        InMemoryCatalog catalog = new InMemoryCatalog();
        System.out.println(catalog.numberInGenre(MusicCategory.BLUES));
    }

    private static void lowCostAverage() {
        InMemoryCatalog catalog = new InMemoryCatalog();
        System.out.println(Math.round(catalog.lowCostAverage()));
    }

    private static void testCheapestInGenre() {
        InMemoryCatalog catalog = new InMemoryCatalog();
        System.out.println(catalog.cheapestInGenre(MusicCategory.ROCK));
    }

    private static void testAverageGenrePrice() {
        InMemoryCatalog catalog = new InMemoryCatalog();
        System.out.println(catalog.averageGenrePrice(MusicCategory.POP));
    }

    private static void testPriceCheck() {
        InMemoryCatalog catalog = new InMemoryCatalog();
        System.out.println(catalog.priceCheck(12));
    }

    private static void testGenreCheck() {
        InMemoryCatalog catalog = new InMemoryCatalog();
        System.out.println(catalog.genreCheck(MusicCategory.RAP));
    }

    private static void testGenreTitles() {
        InMemoryCatalog catalog = new InMemoryCatalog();
        System.out.println(catalog.genreTitles(MusicCategory.ROCK));
    }

    private static void testPriceCheckAdvanced() {
        InMemoryCatalog catalog = new InMemoryCatalog();
        dump(catalog.priceCheckAdvanced(12));
    }

    private static void testFindById() {
        InMemoryCatalog catalog = new InMemoryCatalog();

        MusicItem found = catalog.findById(9L);
        System.out.println(found);

        MusicItem notfound = catalog.findById(20L);
        System.out.println(notfound);
    }

    private static void testFindByKeyword() {
    }

    private static void testFindByCategory() {
        InMemoryCatalog catalog = new InMemoryCatalog();

        Collection<MusicItem> popItems = catalog.findByCategory(MusicCategory.POP);
        dump(popItems);
    }

    private static void testSize() {
    }

    private static void testGetAll() {
    }
    // helper method to show collection vertically
    private static void dump(Collection<MusicItem> items) {
        for(MusicItem item : items) {
            System.out.println(item);
        }

    }
}