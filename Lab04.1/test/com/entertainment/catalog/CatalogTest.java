/*
 * This code is sample code, provided as-is, and we make no
 * warranties as to its correctness or suitability for
 * any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright LearningPatterns Inc.
 */
package com.entertainment.catalog;

import static org.junit.Assert.*;
import java.util.Collection;
import java.util.Map;

import org.junit.Test;
import com.entertainment.Television;

public class CatalogTest {


  @Test(expected = UnsupportedOperationException.class)
  public void getInventory_shouldReturnReadOnlyCollection() {
    Collection<Television> tvs = Catalog.getInventory(); // should be read only
    tvs.clear(); // should throw exception
  }

  @Test
  public void findByBrands_shouldReturnPopulatedMap_whenBrandsPassed() {
    String brand1 = "Sony";
    String brand2 = "Zenith";
    Map<String, Collection<Television>> tvMap = Catalog.findByBrands(brand1, brand2);
    assertEquals(2, tvMap.size());
    Collection<Television> sonyTvs = tvMap.get(brand1);
    verifyCollection(brand1, sonyTvs);
    Collection<Television> zenithTvs = tvMap.get(brand2);
    verifyCollection(brand2, zenithTvs);
  }
  private void verifyCollection(String brand, Collection<Television> tvs) {
    for(Television tv : tvs) {
      assertEquals(brand, tv.getBrand());
    }
  }

  @Test
  public void findByBrands_shouldReturnNoValues_whenWrongBrands() {
    String badBrand = "Funky";
    String badBrand2 = "Funky2";
    Map<String,Collection<Television>> tvMap = Catalog.findByBrands(badBrand, badBrand2);
    assertEquals(0, tvMap.get(badBrand).size());
    assertEquals(0, tvMap.get(badBrand2).size());
  }

  @Test
  public void findByBrands_shouldReturnEmptyMap_noBrandsPassed() {
    Map<String,Collection<Television>> tvMap = Catalog.findByBrands();
    assertTrue(tvMap.isEmpty());
  }

  /**
   * Contract: a no-matches result should be an empty collection (not null).
   */
  @Test
  public void findByBrand_shouldReturnEmptyCollection_whenBrandNotFound() {
    Collection<Television> tvs = Catalog.findByBrand("NO-MATCHES");
    assertNotNull(tvs);
    assertTrue(tvs.isEmpty());
  }

  @Test
  public void findByBrand_shouldReturnCollection_whenBrandFound() {
    String brand = "Sony";
    Collection<Television> tvs = Catalog.findByBrand(brand);
    assertEquals(7, tvs.size());
    for(Television tv : tvs) {
      assertEquals(brand, tv.getBrand());
    }
  }
}