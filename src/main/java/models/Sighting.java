package models;

import org.sql2o.*;
import java.util.List;
import java.util.Objects;

public class Sighting {

    private String location;
    private String name;
    private int animalId;
    private int id;



    public Sighting(String name, String location){
        this.location = location;
        this.name = name;
       // this.animalId = animalId;
    }

    @Override
    public boolean equals(Object otherSighting) {
        if (this == otherSighting) return true;
        if (otherSighting == null || getClass() != otherSighting.getClass()) return false;
        Sighting sighting = (Sighting) otherSighting;
        return Objects.equals(location, sighting.location) &&
                Objects.equals(name, sighting.name);
    }

    public void save(){
        try(Connection con = DB.sql2o.open()) {
            String sql = "INSERT INTO sightings (name,location) VALUES (:name,:location)";
            this.id = (int) con.createQuery(sql,true)
                    .addParameter("name",this.name)
                    .addParameter("location",this.location)
                    .executeUpdate()
                    .getKey();


        }
    }
    public static List<Sighting> all(){
        String sql = "SELECT * FROM sightings";
        try(Connection con = DB.sql2o.open()){
            return con.createQuery(sql).executeAndFetch(Sighting.class);

        }
    }

    @Override
    public int hashCode() {
        return Objects.hash(location, name);
    }

    public String getRangerName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public int getId() {
        return id;
    }
}
