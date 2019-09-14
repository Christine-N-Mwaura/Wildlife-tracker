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
    public void getName_returnsRangerNameInstance_true() {
        Sighting testSighting = setUpNewSighting();
        assertEquals("Morris",testSighting.getRangerName());
    }

    public Sighting setUpNewSighting(){
        return new Sighting("Morris","Zone A");
    }

}