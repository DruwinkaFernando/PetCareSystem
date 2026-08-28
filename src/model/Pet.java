package model;
{
  //Atributes
  private int petID;
  private String name;
  private String species;
  private String breed;
  private int age;
  private String gender;
  private String color;
  private String healthStatus;
  private String vaccinationStatus;
  private String notes;

  //Constructor
  public Pet(int petID, String name, String species, String breed, int age, String gender, String color, String healthStatus, String vaccinationStatus, String notes)
  {
    this.petID = petID;
    this.name = name;
    this.species = species;
    this.breed = breed;
    this.age = age;
    this.gender = gender;
    this.color = color;
    this.healthStatus = healthStatus;
    this.vaccinationStatus = vaccinationStatus;
    this.notes = notes;
  }

  //Getter
  public int getPetID()
  {
    return petID;
  }
  public String getName()
  {
    return name;
  }
  public String getSpecies()
  {
    return species;
  }
  public String getBreed()
  {
    return breed;
  }
  public int getAge()
  {
    return age;
  }
  public String getGender()
  {
     return gender;
  }     
  public String getColor()
  {
    return color;
   }     
  public String getHealthStatus()
  {
    return healthStatus;
  }     
  public String getVaccinationStatus()
  {
    return vaccinationStatus;
  }
  public String getNotes()
  {
    return notes;
  }

  //Setters
  public void setPetID(int petID)
  {
    this.petID = petID;
  }
  public void setName(String name)
  {
    this.name = name;
  }
  public void setSpecies(String species)
  {
    this.species = species;
  }
  public void setBreed(String  breed)
  {
    this.breed = breed;
  }
  public void setAge(int age)
  {
    if (age >= 0)
    {
          this.age = age;
    }
  }
  public void setGender(String gender)
  {
     this.gender = gender;
  }
  public void setColor(String color)
  {
    this.color = color;
  }
  public void setHealthStatus(String healthStatus)
  {
    this.healthStatus = healthStatus;
  }
  public void setVaccinationStatus(String vaccinationStatus)
  {
    this.vaccinationStatus = vaccinationStatus;
  }
  public void setNotes(String notes)
  {
    this.notes = notes;
  }

  //Display Pet Information
  public String getPetDetails()
  {
    return "Pet ID: " + petID 
            + "\nName: " + name
            + "\nSpecies: " + species
            + "\nAge: " + age
            + "\nGender: " + gender
            + "\nColor: " + color
            + "\nHealthStatus: " + healthStatus
            + "\nVaccinationStatus: " + vaccinationStatus
            + "\nNotes: " + notes;    
 }
  
  //toString()
  @Override
  public String toString()
    {
      return name + " (" + species + " - " + breed ")";
    }
}
