package org.veggie;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class RadishSortTestLambda {
    public static void main(String[] args) {
        List<Radish> radishes = new ArrayList<>();

        // color, size, tailLength, sprouts
        radishes.add(new Radish("red",      2.1,    1.0,   0));
        radishes.add(new Radish("black",    1.0,      0,   3));
        radishes.add(new Radish("red",      2.5,    4.2,   0));
        radishes.add(new Radish("pink",     0.7,    3.2,   2));

        System.out.println("Original Order");
        dump(radishes);
        System.out.println();

        System.out.println("tail length");
        radishes.sort( (r1, r2) -> Double.compare(r1.getTailLength(), r2.getTailLength()));
        dump(radishes);
        System.out.println();

        System.out.println("tail length descending");
        radishes.sort( (r2, r1) -> Double.compare(r1.getTailLength(), r2.getTailLength()));
        dump(radishes);
        System.out.println();

        System.out.println("number of sprouts");
        radishes.sort( (r1, r2) -> Double.compare(r1.getSprouts(), r2.getSprouts()));
        dump(radishes);
        System.out.println();

        System.out.println("color natural");
        radishes.sort( (r1, r2) -> r1.getColor().compareTo(r2.getColor()));

    }
// dump method
    private static void dump(List<Radish> radishes) {
        for(Radish radish : radishes) {
            System.out.println(radish); // toString automatically called
        }
    }

}