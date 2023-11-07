/*
 * This code is sample code, provided as-is, and we make no
 * warranties as to its correctness or suitability for
 * any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright LearningPatterns Inc.
 */
package com.javatunes.billing;

/**
 * European orders are taxed as follows:
 *  VAT is 17% of taxable amount.
 *  Luxury tax is an additional 25% on amount over $100.
 *  
 * TODO: implement this algorithm.
 */
public class EuropeTax implements TaxCalculator{

    private static double VAT = .17;
    private static double LUX = .25;
    private static double LUX_THRESH = 100.0;

    @Override
    public double taxAmount(double taxable) {
        double result = taxable * VAT;
        if(taxable > LUX_THRESH) {
            result += (taxable - LUX_THRESH) * LUX;
        }
        return result;
    }
}