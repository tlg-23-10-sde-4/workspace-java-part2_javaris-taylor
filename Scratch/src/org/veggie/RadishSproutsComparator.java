package org.veggie;

import java.util.Comparator;

class RadishSproutsComparator implements Comparator<Radish> {

    @Override
    public int compare(Radish radish1, Radish radish2) {
        return Integer.compare(radish1.getSprouts(), radish2.getSprouts());
    }
}