package models;

import java.util.List;
import java.util.Objects;
import org.sql2o.*;

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

    public void save(){
        try(Connection con = DB.sql2o.open()) {
            String sql = "INSERT INTO animals (name) VALUES (:name)";
             this.id = (int) con.createQuery(sql,true)
                    .addParameter("name",this.name)
                    .executeUpdate()
                     .getKey();


        }
    }
    public static List<Animals> all() {
        String sql = "SELECT * FROM animals";
        try(Connection con = DB.sql2o.open()){
            return con.createQuery(sql).executeAndFetch(Animals.class);
        }
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

}
