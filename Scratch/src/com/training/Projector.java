package com.training;

class Projector {
    public Projector() {
        System.out.println("Projector ctor invoked");
    }

    // this executes when the Class loads Projector.class into memory
    static {
        System.out.println("Projector.Class Loaded into memory");
    }

}