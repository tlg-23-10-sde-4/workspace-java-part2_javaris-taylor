package com.duckrace;

import java.util.Collection;

class DuckRacerTest {
        public static void main(String[] args) {


                DuckRacer racer = new DuckRacer(14, "Scott");
                System.out.println(racer);
                racer.win(Reward.PRIZES);
                racer.win(Reward.PRIZES);
                racer.win(Reward.DEBIT_CARD);

                System.out.println(racer);
                System.out.println();

                // to show the read only view to the underlying collection
                Collection<Reward> racerRewards = racer.getRewards();
                System.out.println(racerRewards); // should see 4
                racer.win(Reward.DEBIT_CARD);
                racer.win(Reward.DEBIT_CARD);
                System.out.println(racerRewards);
        }


}