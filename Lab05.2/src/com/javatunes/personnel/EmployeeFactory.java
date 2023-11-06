/*
 * This code is sample code, provided as-is, and we make no
 * warranties as to its correctness or suitability for
 * any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright LearningPatterns Inc.
 */
package com.javatunes.personnel;

import java.sql.Date;
import java.util.Map;

public class EmployeeFactory {

    // prevent direct instantiation - this is an all-static factory class
    private EmployeeFactory() {
    }

    /**
     * TODO: given the input map, create and return the correct object (with its properties set).
     * If the input map's "type" value is not "HE" or "SE", throw IllegalArgumentException with a suitable message.
     */
    public static Employee createEmployee(Map<String, String> inputMap) throws IllegalArgumentException {

        // read the indicator out of the map
        String type = inputMap.get("type");

        if(!"HE".equals(type) && !"SE".equals(type)) {
            throw new IllegalArgumentException("Invalid Type: " + type + ". Must be SE or HE.");
        }
        else{
            Employee emp = null;
            String name = inputMap.get("name");
            Date hireDate = Date.valueOf(inputMap.get("hireDate"));

            if("SE".equals(type)) {
                Double salary = Double.valueOf(inputMap.get("salary"));
                return emp = new SalariedEmployee(name, hireDate, salary);
            }
            else {
                Double rate = Double.valueOf(inputMap.get("rate"));
                Double hours = Double.valueOf(inputMap.get("hours"));
                return emp = new HourlyEmployee(name, hireDate, rate, hours);
            }
        }
    }
}