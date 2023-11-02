package com.entertainment;

import java.util.Objects;

/*
 * To be consistent with equals, whatever fields we use for equals() and hashCode(),
 * we must use the same fields for natural order.
 *
 * That means we'll switch to a primary sort key 'brand', when tied brak tie
 * volume sort key
 */
public class Television implements Comparable<Television> {
        private String brand;
        private int volume;
        private Tuner tuner = new Tuner(); //instantiated internally
        private int instanceCount;
        private int instance;
        // constructors

        public Television() {

        }

        public Television(String brand, int volume) {
                this();
                setBrand(brand);
                setVolume(volume);
        }

        // business methods
        public int getCurrentChannel() {
                return tuner.getChannel();
        }
        public void changeChannel(int channel) {
                tuner.setChannel(channel);
        }


        // accessor methods
        public String getBrand() {
                return brand;
        }

        public void setBrand(String brand) {
                this.brand = brand;
        }

        public int getVolume() {
                return volume;
        }

        public void setVolume(int volume) {
                this.volume = volume;
        }

        public int getInstance() {
                return instance;
        }

        public void setInstance(int instance) {
                this.instance = instance;
        }

        @Override
        public int hashCode() {
                /*
                 * This is a poorly written hash function because it easily yields hash collisions
                 * A hash collision is when "different" objects have the same hash code
                 */
//                return getBrand().length() + getVolume();
                return Objects.hash(getBrand(), getVolume());
        }
        @Override
        public boolean equals(Object obj) {
               boolean result = false;

               // proceed only if 'obj' is really referencing a Television object
                if(this.getClass() ==  obj.getClass()) {
                        // safely downcast 'obj' to more specefic reference Television
                        Television other =  (Television) obj;

                        // do the checks : business equality is defined by brand, volume being the same
                        result = Objects.equals(this.getBrand(), other.getBrand()) &&
                                this.getVolume() == other.getVolume();
                }

                return result;
        }


        @Override
        public int compareTo(Television other) {
                int result = this.getBrand().compareTo(other.getBrand());
                if(result == 0) {
                        result = Integer.compare(this.getVolume(), other.getVolume());
                }
                return result;
        }

        @Override
        public String toString() {
                return "Television{" +
                        "brand='" + getBrand() + '\'' +
                        ", volume=" + getVolume() +
                        ", tuner=" + getCurrentChannel() +
                        '}';
        }


}