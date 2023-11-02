package com.javatunes.personnel;

import org.junit.Before;
import org.junit.Test;

import java.sql.Date;

import static org.junit.Assert.*;

public class SalariedEmployeeTest {
    private SalariedEmployee emp;
    private SalariedEmployee emp2;

    @Before
    public void setUp(){
        emp = new SalariedEmployee("John", Date.valueOf("2020-01-22"), 1500.0);
        emp2= new SalariedEmployee("John", Date.valueOf("2020-01-22"), 1500.0);
    }

    @Test
    public void hashCode_equalObjectsMustHaveEqualHashCodes() {
        assertEquals(emp.hashCode(), emp2.hashCode());
    }
    @Test
    public void equals_shouldReturnFalse_differentName_sameHireDate_sameSalary() {
        emp2.setName("NotLogan");
        assertNotEquals(emp, emp2);
    }

    @Test
    public void equals_shouldReturnFalse_sameName_differentHireDate_sameSalary() {
        emp2.setHireDate(Date.valueOf("2020-02-06"));
        assertNotEquals(emp, emp2);
    }

    @Test
    public void equals_shouldReturnFalse_sameName_sameHireDate_differentSalary() {
        emp2.setSalary(1000.0);
        assertNotEquals(emp, emp2);
    }

    @Test
    public void equals_ShouldReturnTrue_allPropertiesSame() {
        assertEquals(emp, emp2);
        // assertTrue(emp.equals(emp2)); alternative assertion.
    }

    @Test
    public void testPay() {
        assertEquals(1500.0, emp.getSalary(), 0.01);

    }

    @Test
    public void testPayTaxes() {
        assertEquals(450, emp.payTaxes(), .001); // assertEquals(expected, actual, (differenceInDecimal) delineation)

    }
}