package org.veggie;

import java.util.ArrayList;
import java.util.List;

class RadishSortTest {
    public static void main(String[] args) {
        List<Radish> radishes = new ArrayList<>();

        System.out.println("Original Order");
        // color, size, tailLength, sprouts
        radishes.add(new Radish("red",      2.1,    1.0,   0));
        radishes.add(new Radish("black",    1.0,      0,   3));
        radishes.add(new Radish("red",      2.5,    4.2,   0));
        radishes.add(new Radish("pink",     0.7,    3.2,   2));

        dump(radishes);
        System.out.println();
        System.out.println("Natural Order");
        radishes.sort(null); // passing null means do by natural order
        dump(radishes);

        System.out.println();
        System.out.println("color, using Comparator");
        radishes.sort(new RadishColorComparator());
        dump(radishes);

        System.out.println();
        System.out.println("sprouts, using RadishSproutsComparator");
        radishes.sort(new RadishSproutsComparator());
        dump(radishes);

    }

    private static void dump(List<Radish> radishes) {
        for(Radish radish : radishes) {
            System.out.println(radish); // toString automatically called
        }
    }

}