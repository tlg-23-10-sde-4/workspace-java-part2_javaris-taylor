package com.training;

class Instructor {
   // shared among all Instructor objects
    private static final Projector projector = new Projector();

    // instance variables for each instructor object
    private final String name;
    private final int yearsExperience;

    public Instructor(String name, int yearsExperience) {
        System.out.println("Instructor ctor Called");
        this.name = name;
        this.yearsExperience = yearsExperience;
    }

    public static void touch() {
        System.out.println("Instructor touch() method called");
    }

    // accessor methods (Read-Only)
    public String getName() {
        return name;
    }

    public int getYearsExperience() {
        return yearsExperience;
    }

    static {
        System.out.println("Static fields initialized, Instructor.class loaded into memory");
    }
}