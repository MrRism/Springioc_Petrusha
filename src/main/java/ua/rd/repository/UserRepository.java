package ua.rd.repository;

import ua.rd.domain.User;

/**
 * Created on 28.09.2017.
 *
 * @author Serhii Petrusha aka Mr_Rism
 */
public interface UserRepository {

  Iterable<User> allUsers();

}
