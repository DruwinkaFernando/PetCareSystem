package model;
public class Cat extends Pet
{
  private String indoorOutdoor;
  private boolean litterTrained;

  public Cat(int petID, String name, String species, String breed, int age, String gender, String color, String healthStatus, String vaccinationStatus, String notes, String indoorOutdoor, boolean litterTrained)
  {
    super(petID, name, "Cat", breed, age, gender, color, healthStatus, vaccinationStatus, notes);
    this.indoorOutdoor = indoorOutdoor;
    this.litterTrained = litterTrained;
  }

  public String getIndoorOutdoor()
  {
    return indoorOutdoor;
  }
  public void setIndoorOutdoor(String indoorOutdoor)
  {
    this.indoorOutdoor = indoorOutdoor;
  }
  public String getLitterTrained()
  {
    return litterTrained;
  }
  public void setLitterTrained(boolean litterTrained)
  {
    this.litterTrained = litterTrained;
  }

  @Override
  public String toString()
  {
    return getName() + " (Cat - " + getBreed() + ")";
  }
}
