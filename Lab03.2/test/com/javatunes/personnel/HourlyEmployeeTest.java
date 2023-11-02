package com.javatunes.personnel;

import org.junit.Before;
import org.junit.Test;

import java.sql.Date;

import static org.junit.Assert.*;

public class HourlyEmployeeTest {
    private HourlyEmployee emp;
    private HourlyEmployee emp2;

    @Before
    public void setUp(){
       emp = new HourlyEmployee("Annie", Date.valueOf("2007-01-22"), 40.0, 30.0);
       emp2 = new HourlyEmployee("Annie", Date.valueOf("2007-01-22"), 40.0, 30.0);
    }

    @Test
    public void hashCode_equalObjectsMustHaveEqualHashCodes() {
        assertEquals(emp.hashCode(), emp2.hashCode());
    }

    @Test
    public void shouldReturnTrue_allPropertiesSame() {
        assertEquals(emp, emp2);
    }

    @Test
    public void shouldReturnFalse_differentNames_sameHireDate_samePay() {
        emp2.setName("NotAnnie");
        assertNotEquals(emp, emp2);
    }

    @Test
    public void shouldReturnFalse_sameName_differentHireDate_samePay() {
        emp2.setHireDate(Date.valueOf("2020-01-01"));
        assertNotEquals(emp, emp2);
    }

    @Test
    public void shouldReturnFalse_sameName_sameHireDate_differentPay() {
        emp2.setRate(38.0);
        assertNotEquals(emp, emp2);
    }

    @Test
    public void testPay() {
        assertEquals(1200, emp.getRate() * emp.getHours(), 0.01);
    }

    @Test
    public void testPayTaxes() {
        assertEquals(300, emp.payTaxes(), .001);

    }
}