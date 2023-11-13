package com.javatunes.personnel;

import org.junit.Before;
import org.junit.Test;

import java.sql.Date;

import static org.junit.Assert.*;

public class EmployeeTest {
    private Employee emp1;
    private Employee emp2;

    @Before
    public void setUp() {
//        emp1 = new DummyEmployee("Mary Lou", Date.valueOf("1999-01-02"));
//        emp2 = new DummyEmployee("Mary Lou", Date.valueOf("1999-01-02"));
        emp1 = new Employee("Mary Lou", Date.valueOf("1999-01-02")) {
            @Override
            public double pay() {  return 0;
            }
            @Override
            public double payTaxes() { return 0; }
        };
        emp2 = new Employee("Mary Lou", Date.valueOf("1999-01-02")) {
            @Override
            public double pay() {  return 0;
            }
            @Override
            public double payTaxes() { return 0; }
        };
    }

    @Test
    public void hashCode_equalObjectsMustHaveEqualHashCodes() {
        assertEquals(emp1.hashCode(), emp2.hashCode());
    }

    @Test
    public void equals_shouldReturnFalse_differentName_sameHireDate() {
        emp2.setName("NotMaryLOU");
        assertNotEquals(emp1, emp2);
    }

    @Test
    public void equals_shouldReturnFalse_sameName_differentHireDate() {
        emp2.setHireDate(Date.valueOf("2030-10-10"));
        assertNotEquals(emp1, emp2);
    }

    @Test
    public void equals_shouldReturnTrue_allPropertiesSame() {
        assertEquals(emp1, emp2);
    }

    // NAMED, MEMBER-
    private class DummyEmployee extends Employee {
        public DummyEmployee(String name, Date hireDate) {
        }

        public double pay() {return 0;}
        public double payTaxes() {return 0;}
    }
}