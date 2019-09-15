package models;
import org.junit.Rule;

import org.junit.Test;

import static org.junit.Assert.*;

public class SightingTest {
    @Rule
    public DatabaseRule database = new DatabaseRule();//checkout database rule uses


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

    @Test
    public void save_insertsObjectsToTheDatabase_Sighting() {
        Sighting testSighting = setUpNewSighting();
        testSighting.save();
        assertTrue(Sighting.all().get(0).equals(testSighting));

    }

    @Test
    public void all_returnsAllInstancesOfSighting_Sighting() {
        Sighting firstSighting = setUpNewSighting();
        firstSighting.save();
        Sighting secondSighting = new Sighting("Ken","Zone B");
        secondSighting.save();
        assertEquals(true,Sighting.all().get(0).equals(firstSighting));
        assertEquals(true,Sighting.all().get(1).equals(secondSighting));

    }

    public Sighting setUpNewSighting(){
        return new Sighting("Morris","Zone A");
    }


}