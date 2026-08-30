package dao;

import model.Admin;
import model.Staff;
import.User;

import java.util.List;

public class UserDAO {
  private static final String FILE = "dta/users.dat";

  //Seeds the two default accounts the first time the app runs.
  public List <User> getAll() {
    List<User> list = FileHandler.load(FILE);
    if (list.isEmpty()){
      list.add(new Admin("U001", "admin", "admin123", "System Administrator"));
      list.add(new Staff("U002", "staff", "staff123", "Dr. Perera"));
      FileHandler.save(FILE, list);
    }
    return list;
  }

  public User authenticate(String username, String password){
    for (User u : getAll ()) {
      if (u.getUsername().equals(username) && u.getPassword().equals(password)) {
        return u;
      }
    }
    return null;
  }
}
