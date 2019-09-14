package models;

import org.junit.Test;

import static org.junit.Assert.*;

public class SightingTest {

    @Test
    public void sighting_instantiatesCorrectly_true() {
        Sighting testSighting = setUpNewSighting();
        assertTrue(testSighting instanceof Sighting);
    }

    @Test
    public void getRangerName_returnsRangerNameInstance_true() {
        Sighting testSighting = setUpNewSighting();
        assertEquals("Morris",testSighting.getRangerName());
    }

    @Test
    public void getLocation_returnsLocationOnClassInitialization_true() {
        Sighting testSighting = setUpNewSighting();
        assertEquals("Zone A",testSighting.getLocation());
    }

    public Sighting setUpNewSighting(){
        return new Sighting("Morris","Zone A");
    }


}