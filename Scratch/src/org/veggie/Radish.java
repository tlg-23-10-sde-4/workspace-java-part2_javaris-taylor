package org.veggie;

class Radish implements Comparable<Radish>{

    private String color;
    private double size;
    private double tailLength;
    private int sprouts;


    // constructer


    public Radish(String color, double size, double tailLength, int sprouts) {
        setColor(color);
        setSize(size);
        setTailLength(tailLength);
        setSprouts(sprouts);
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
    }

    public double getTailLength() {
        return tailLength;
    }

    public void setTailLength(double tailLength) {
        this.tailLength = tailLength;
    }

    public int getSprouts() {
        return sprouts;
    }

    public void setSprouts(int sprouts) {
        this.sprouts = sprouts;
    }

    // Natural order is defined by size (double).
    @Override
    public int compareTo(Radish other) {
        return Double.compare(this.getSize(), other.getSize());
    }

    @Override
    public String toString() {
        return  getClass().getSimpleName() + ":" +
                "color=" + getColor() +
                ", size=" + getSize() +
                ", tailLength=" + getTailLength() +
                ", sprouts=" + getSprouts();
    }
}