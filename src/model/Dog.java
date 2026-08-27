package model;
public class Dog extends Pet
{
  private String trainingStatus;
  private String exerciseNeeds;

  public Dog(int petID, String name, String species, String breed, int age, String gender, String color, String healthStatus, String vaccinationStatus, String notes, String trainingStatus, String exerciseNeeds)
  {
    super(petID, name, "Dog", breed, age, gender, color, healthStatus, vaccinationStatus, notes);
    this.trainingStatus = trainingStatus;
    this.exerciseNeeds = exerciseNeeds;
  }

  public String GetTrainingStatus()
  {
    return trainingStatus;
  }
  public void setTrainingStatus(String trainingStatus)
  {
    this.trainingStatus = trainingStatus;
  }
  public String GetExerciseNeeds()
  {
    return exerciseNeeds;
  }
  public void setExerciseNeeds(String exerciseNeeds)
  {
    this.exerciseNeeds = exerciseNeeds;
  }

  @Override
  public String toString()
  {
    return getName() + " (Dog - " + getBreed() + ")";
  }
}
