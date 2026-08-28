package model;
public class Bird extends Pet
{
  private String featherCondition;
  private String beakCondition;

  public Bird(int petID, String name, String species, String breed, int age, String gender, String color, String healthStatus, String vaccinationStatus, String notes, String featherCondition, String beakCondition)
  {
    super(petID, name, "Bird", breed, age, gender, color, healthStatus, vaccinationStatus, notes);
    this.featherCondition = featherCondition;
    this.beakCondition = beakCondition;
  }

  public String getFeatherCondition()
  {
    return featherCondition;
  }
  public void setFeatherCondition(String featherCondition)
  {
    this.featherCondition = featherCondition;
  }
  public String getBeakCondition()
  {
    return beakCondition;
  }
  public void setBeakCondition(String beakCondition)
  {
    this.beakCondition = beakCondition;
  }

  @Override
  public String toString()
  {
    return getName() + " (Bird - " + getBreed() + ")";
  }
}
