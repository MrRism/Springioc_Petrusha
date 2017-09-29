package ua.rd.services;

import java.util.ArrayList;
import java.util.List;
import ua.rd.domain.User;
import ua.rd.repository.UserRepository;

/**
 * Created on 24.09.2017.
 *
 * @author Serhii Petrusha aka Mr_Rism
 */
public class UserOperationsService implements UserOperations {

  private UserRepository userRepository;

  public UserOperationsService(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @Override
  public List<User> getUsers() {

    List<User> allUsers = new ArrayList<>();
    userRepository.allUsers().iterator().forEachRemaining(allUsers::add);

    return allUsers;
  }


  @Override
  public User getUser(int index) {
    return getUsers().get(index);
  }
}
