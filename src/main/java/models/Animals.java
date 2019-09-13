package models;

import java.util.Objects;

public class Animals {

    private String name;
    private int id;

    public Animals(String name){
        this.name = name;
    }

    @Override
    public boolean equals(Object otherAnimal) {
        if (this == otherAnimal) return true;
        if (otherAnimal == null || getClass() != otherAnimal.getClass()) return false;
        Animals animals = (Animals) otherAnimal;
        return name.equals(animals.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    public String getName() {
        return name;
    }

}
