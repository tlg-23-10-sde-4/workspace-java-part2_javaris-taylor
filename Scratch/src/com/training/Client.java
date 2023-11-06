package com.training;

class Client {
    public static void main(String[] args) {
//        Instructor inst1 = new Instructor("Jay", 2); // class loader loads instructor.class which initializes that static (shared) Projector
//        System.out.println(inst1.getName());
//        Instructor inst2 = new Instructor("Eduardo", 5);
//        System.out.println(inst2.getName());
        Instructor.touch();
    }

}