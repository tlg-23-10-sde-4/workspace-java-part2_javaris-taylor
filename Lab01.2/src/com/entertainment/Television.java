package com.entertainment;

public class Television {
        private String brand;
        private int volume;
        private Tuner tuner = new Tuner(); //instantiated internally

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

        @Override
        public String toString() {
                return "Television{" +
                        "brand='" + getBrand() + '\'' +
                        ", volume=" + getVolume() +
                        ", tuner=" + getCurrentChannel() +
                        '}';
        }
}