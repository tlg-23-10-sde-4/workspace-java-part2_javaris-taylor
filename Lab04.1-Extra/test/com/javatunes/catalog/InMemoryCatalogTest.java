package com.javatunes.catalog;


import org.junit.Before;
import org.junit.Test;

import java.util.Collection;

import static org.junit.Assert.*;

public class InMemoryCatalogTest {

    private InMemoryCatalog catalog;
    @Before
    public void setUp(){
        catalog = new InMemoryCatalog();
    }

    // The test for the  non-tasks methods from InMemoryCatalog assignment
    @Test
    public void findByCategory_shouldReturnCollection_whenCategoryFound() {
        Collection<MusicItem> items = catalog.findByCategory(MusicCategory.POP);
        assertEquals(4, items.size());
        
        for (MusicItem item : items) {
            assertEquals(MusicCategory.POP, item.getMusicCategory());
        }
    }

    @Test
    public void findByCategory_shouldReturnEmptyCollection_categoryNotFound() {
        Collection<MusicItem> items = catalog.findByCategory(MusicCategory.JAZZ);
        assertEquals(0, items.size());
        assertTrue((items.isEmpty()));
    }

    @Test
    public void findById_ShouldReturnItem_whenFound() {
        MusicItem item = catalog.findById(18L);
        assertEquals(1, item.getId().longValue());
    }

    @Test
    public void findById_shouldReturnNull_whenNotFound() {
        MusicItem item = catalog.findById(19L);
        assertNull(item);
    }
    
    // Tests for the extra tasks from the InMemoryCatalog assignment

    @Test
    public void findSelfTitled_shouldReturnCollection_withArtistSameAsTitle() {
        Collection<MusicItem> items = catalog.findSelfTitled();

        assertEquals(2, items.size());
        for(MusicItem item : items) {
            assertEquals(item.getArtist(), item.getTitle());
        }
    }

    @Test
    public void numberInGenre_shouldReturnCorrectResult() {
        int result = catalog.numberInGenre(MusicCategory.POP);
        assertEquals(4, result);
    }

    @Test
    public void lowCostAverage_shouldReturnAverage_whenGivenCatalog() {
        double result = catalog.lowCostAverage();
        assertEquals(15.30, result, .01);
    }
}