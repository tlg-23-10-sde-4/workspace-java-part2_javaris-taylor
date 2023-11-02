package com.duckrace;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

class DuckRacer {

    private int id;
    private String name;
    // private int wins;
    private Collection<Reward> rewards = new ArrayList<>();

    public DuckRacer(int id, String name) {
        this.id = id;
        setName(name);
    }

    // business ("action") methods

    public void win(Reward reward) {
        rewards.add(reward);
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public int getWins() {
        return rewards.size();
    }

    public Collection<Reward> getRewards() {
        return Collections.unmodifiableCollection(rewards);
    }

    public String toString() {
        return String.format("%s: id= %s, name= %s, wins= %s, rewards= %s",
                getClass().getSimpleName(), getId(), getName(), getWins(), getRewards());
    }


}