package models;

import java.util.List;
import java.util.Objects;
import org.sql2o.*;

public class Animals {

    private String name;
    private int id;
    private int bodyTemp;
    private int age;


    public static final int MAX_BODY_TEMP = 40;
    public static final int MAX_ANIMAL_AGE = 70;
    public static final int MIN_ALL_LEVELS = 0;


    public Animals(String name){
        this.name = name;
        this.bodyTemp = MAX_BODY_TEMP / 2 ;
        this.age = MAX_ANIMAL_AGE / 2;

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

    public String ageStage(){
        String stage = "";
        if(age <= MAX_ANIMAL_AGE / 2){
            stage = "young";
        }else if(age > MAX_ANIMAL_AGE / 2){
            stage = "adult";
        }else if(age == 0){
            stage = "newborn";
        }
        return stage;
    }

    public void ageing (){
        if(age >= MAX_ANIMAL_AGE){
            throw new UnsupportedOperationException("The animal is overgrowm!!");
        }

        age++;
    }

    public String healthStatus(){
        String status = "";
        if(bodyTemp <= MAX_BODY_TEMP / 2){
            status = "ill";
        }else if(bodyTemp >= MAX_BODY_TEMP /2){
            status = "healthy";
        }else {
            status = "okay";
        }
        return status;
    }

    public void tempRising(){
        if(bodyTemp >= MAX_BODY_TEMP){
            throw new UnsupportedOperationException("The animal's body temperature is too high!");
        }
        bodyTemp ++;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public int getBodyTemp() {
        return bodyTemp;
    }

    public int getAge() {
        return age;
    }

}
