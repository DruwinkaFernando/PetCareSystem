package model;

import java.io.Serializable;

public class Appointment implements Serializable{
  private static final long serialVersionUID = 1L;

  private String apptId;
  private String date;
  private String time;
  private String petId;
  private String service;
  private String status; //Pending /confirmed /completed

  public Appointment(String apptId,String date,String time,String petId,String service,String Status){
    this.apptId = apptId;
    this.date = date;
    this.time = time;
    this.petId = petId;
    this.service = service;
    this.status = Status;
  }
  public String getApptId(){return apptId;}
  public void setApptId(String apptId){this.apptId = apptId;}
  public String getDate(){return date;}
  public void setDate(String date){this.date=date;}
  public String getTime(){return time;}
  public void setTime(String time){this.time = time;}
  public String getPetId(){return petId;}
  public void setPetId(String petId){this.petId = petId;}
  public String getService(){return service;}
  public void setService(String service){this.service = service;}
  public String getStatus(){return status;}
  public void setStatus(String status){this.status = status; }
}
