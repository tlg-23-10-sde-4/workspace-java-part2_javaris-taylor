package com.entertainment;

import org.junit.Before;
import org.junit.Test;

import java.util.function.DoubleToIntFunction;

import static org.junit.Assert.*;

public class TelevisionTest {

    private Television tv1;
    private Television tv2;

    @Before
    public void setUp(){
        tv1  = new Television("Sony", 50);
        tv2  = new Television("Sony", 50);
    }

    @Test
    public void hashCode_equalObjectsHaveEqualHashCodes() {
        assertEquals(tv1.hashCode(), tv2.hashCode());
    }

    @Test
    public void equals_shouldReturnTrue_allPropertiesSame() {
        assertEquals(tv1, tv2);
    }

    @Test
    public void setVolume_shouldStoreValue_whenValid_lowerBound() {
        tv1.setVolume(0);
        assertEquals(0, tv1.getVolume());
    }

    @Test
    public void setVolume_shouldStoreValue_whenValid_upperBound() {
        tv2.setVolume(100);
        assertEquals(100, tv2.getVolume());
    }

    @Test(expected = IllegalArgumentException.class) // dictates what failure is expected
    public void setVolume_shouldThrowIllegalArgument_whenInvalid_lowerBound() {
        tv1.setVolume(-1); // this should trigger the exception
    }

    @Test
    public void setVolume_shouldThrowIllegalArgument_whenInvalid_upperBound() {
        try{
            tv1.setVolume(101); // this should trigger the exception
        }
        catch(IllegalArgumentException e) {
            String expected = "Invalid volume: 101. Allowed range: [0,100].";
            assertEquals(expected, e.getMessage());
        }

    }

    @Test
    public void changeChannel_shouldStoreValue_whenValid_lowerBound() throws InvalidChannelException{
        tv1.changeChannel(1);
        assertEquals(1, tv1.getCurrentChannel());
    }

    @Test
    public void changeChannel_shouldStoreValue_whenValid_upperBound() throws InvalidChannelException {
        tv1.changeChannel(999);
        assertEquals(999, tv1.getCurrentChannel());
    }

    @Test(expected = InvalidChannelException.class)
    public void changeChannel_shouldThrowInvalidChannelException_whenInvalid_lowerBound() throws InvalidChannelException{
            tv1.changeChannel(-1);
    }

    @Test
    public void changeChannel_shouldThrowInvalidChannelException_whenInvalid_upperBound() throws InvalidChannelException {
        try{
            tv1.changeChannel(1000);
        }
        catch(InvalidChannelException e) {
            String expected = "Invalid channel: 1000. Allowed range: [1,999].";
            assertEquals(expected, e.getMessage());
        }
    }


    @Test
    public void compareTo_shouldReturnFalse_whenNotEquals() {

    }

    @Test
    public void equals_shouldReturnFalse_differentBrand_sameVolume_sameDisplay() {
        tv2.setBrand("LG");
        assertNotEquals(tv1, tv2);

    }

    @Test
    public void equals_shouldReturnFalse_sameBrand_differentVolume_sameDisplay() {
        tv2.setVolume(90);
        assertNotSame(tv1, tv2);
    }

    @Test
    public void equals_shouldReturnFalse_sameBrand_sameVolume_differentDisplay() {
        tv2.setDisplay(DisplayType.CRT);
        assertFalse(tv1.equals(tv2));
    }

    public void testEquals() {
        tv1.setBrand("LG");
    }

}