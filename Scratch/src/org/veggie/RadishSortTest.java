package org.veggie;

import java.util.ArrayList;
import java.util.Comparator;
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
        // Natural Order
        System.out.println("Natural Order");
        radishes.sort(null); // passing null means do by natural order
        dump(radishes);
        System.out.println();
        // Color Order
        System.out.println("color, using Comparator");
        //radishes.sort(new RadishColorComparator());
        radishes.sort(new Comparator<Radish>(){ // sort by color, via anonymous class
            @Override
            public int compare(Radish r1, Radish r2) {
                return r1.getColor().compareTo(r2.getColor());
            }
        });
        dump(radishes);
        System.out.println();
        // Sprout Order
        System.out.println("sprouts, using RadishSproutsComparator");
        radishes.sort(new RadishSproutsComparator());
        dump(radishes);
        System.out.println();
        // TailLength Order
        System.out.println("sort by TailLength, via anonymous class");
        radishes.sort(new Comparator<Radish>() {

            @Override
            public int compare(Radish r1, Radish r2)  {  // anonymous class hijacks the compare method and inputs its own arguments- allows a "new" interface in a way
                return Double.compare(r1.getTailLength(), r2.getTailLength());
            }

        });
        dump(radishes);
        System.out.println();

    }
// dump method
    private static void dump(List<Radish> radishes) {
        for(Radish radish : radishes) {
            System.out.println(radish); // toString automatically called
        }
    }

}