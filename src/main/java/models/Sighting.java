package models;

public class Sighting {

    private String location;
    private String rangerName;
    private int animalId;


    public Sighting(String rangerName, String location){
        this.location = location;
        this.rangerName = rangerName;
    }



    public String getRangerName() {
        return rangerName;
    }

}
