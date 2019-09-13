package models;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class AnimalsTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void animals_instantiatesCorrectly_true() {
        Animals animal = setUpNewAnimal();
        assertTrue(animal instanceof Animals);
    }

    @Test
    public void getName_animalsInstantiatesWithName_true() {
        Animals animal = setUpNewAnimal();
        assertEquals("Baboon", animal.getName());

    }
    public Animals setUpNewAnimal(){
        return new Animals ("Baboon");
    }
}