package model;

import java.util.Arrays;
import java.util.List;

//INHERITANCE: Admin"is-a" User, and Extends it with full access.
public Class Admin extends User {
  private static final long serialVersioUID = 1l;

  public Admin(String userId, String username,String password,String fullName){
    super(userId,username,password,fullName);
    }
    @Override
      public String getRole(){
        return "Admin";
    }
    @Override
      public List<String>getAccessibleModules(){
      //admin sees every module in the sidebar
      return Arrays.asList("Dashboard","Pets","Owners","Appointments","Billings","Reports","Settings");
      }
  }
