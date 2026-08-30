package model;

import java.io.Serializable;

public class Pet implements Serializable {
    private static final long serialVersionUID = 1L;

    private String petId;
    private String name;
    private String species;
    private String breed;
    private int age;
    private String gender;
    private String ownerId;

    public Pet(String petId, String name, String species, String breed, int age, String gender, String ownerId) {
        this.petId = petId;
        this.name = name;
        this.species = species;
        this.breed = breed;
        this.age = age;
        this.gender = gender;
        this.ownerId = ownerId;
    }

    public String getPetId() { return petId; }
    public void setPetId(String petId) { this.petId = petId; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getSpecies() { return species; }
    public void setSpecies(String species) { this.species = species; }
    public String getBreed() { return breed; }
    public void setBreed(String breed) { this.breed = breed; }
    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }
    public String getGender() { return gender; }
    public void setGender(String gender) { this.gender = gender; }
    public String getOwnerId() { return ownerId; }
    public void setOwnerId(String ownerId) { this.ownerId = ownerId; }
}
