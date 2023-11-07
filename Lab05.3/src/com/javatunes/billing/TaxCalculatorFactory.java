package com.javatunes.billing;

import java.util.Map;
import java.util.TreeMap;

public class TaxCalculatorFactory {
    TreeMap<Location, TaxCalculator> locationCache = new TreeMap<>();

    private TaxCalculatorFactory() {

    }

    /*
     * Consider implementinga  "cache" of TaxCalculator objects
     *
     * If I have not created the object, then i'll create it here with new.
     *
     * if I already have the object, fetch it from the cache and return it, do not create a new one.
     */
    public static TaxCalculator getTaxCalculator(Location location)  {
        TaxCalculator calc = null;

        switch(location) {
            case ONLINE:
                calc = new OnlineTax();
                break;
            case USA:
                calc = new USATax();
                break;
            case EUROPE:
                calc = new EuropeTax();
        }
        return calc;
    }

}