package model;

import java.util.Arrays;
import java.util.List;

//INHERITANCE: Staff (Veterinary Staff)"is-a" User,but with restricted access.
//Together with Admin , this shows POlYmorphism: the sane method name
//getAccessibleModules()behaves differently per subclass.
public class Staff extends User{
  private static final long SerivalVersionUID = 1L;

  PUBLIC Staff(String userId,String username,String password,String fullName){
    super(userId,username,password,fullName);
  }
  @Override
  public String getRole(){
    return"Veterinary Staff";
  }
  @Override
  public List<String>gatAccessibleModules(){
    //Staff cannot see Billing/Reports/Settings
    return Arrays.asList("Dashboard","Pets","Owners","Appointments");
  }
}
