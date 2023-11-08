package com.duckrace;

class Race {
    int id = 0;
    int minimumRacers = 1;

    public int raceWinner(int max){
        double clientScaled = (Math.random() * (max - minimumRacers + 1)); //
        double raised = clientScaled + minimumRacers;
        id = (int) raised;
        return id;
    }


}