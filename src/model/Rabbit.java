package model;
public class Rabbit extends Pet
{
  private String dietType;
  private String housingType;

  public Rabbit(int petID, String name, String species, String breed, int age, String gender, String color, String healthStatus, String vaccinationStatus, String notes, String dietType, String housingType)
  {
    super(petID, name, "Rabbit", breed, age, gender, color, healthStatus, vaccinationStatus, notes);
    this.dietType = dietType;
    this.housingType = housingType;
  }

  public String getDietType()
  {
    return dietType;
  }
  public void setDietType(String dietType)
  {
    this.dietType = dietType;
  }
  public String getHousingType()
  {
    return housingType;
  }
  public void setHousingType(String housingType)
  {
    this.housingType = housingType;
  }

  @Override
  public String toString()
  {
    return getName() + " (Rabbit - " + getBreed() + ")";
  }
}
