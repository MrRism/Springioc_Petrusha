package ua.rd.services;

import java.util.List;
import ua.rd.domain.User;

/**
 * Created on 27.09.2017.
 *
 * @author Serhii Petrusha aka Mr_Rism
 */
public interface UserOperations {

  List<User> getUsers();
  User getUser(int index);


}
