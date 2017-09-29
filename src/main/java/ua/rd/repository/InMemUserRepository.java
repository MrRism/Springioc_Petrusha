package ua.rd.repository;

import java.util.Arrays;
import java.util.List;
import javax.annotation.PostConstruct;
import org.springframework.stereotype.Repository;
import ua.rd.domain.User;
import ua.rd.services.TimelineOperationsService;

/**
 * Created on 28.09.2017.
 *
 * @author Serhii Petrusha aka Mr_Rism
 */
@Repository("tweetRepository")
public class InMemUserRepository implements UserRepository {

  private List<User> users;

  private TweetRepository tweetRepository;



  @PostConstruct
  private void init(){

    users = Arrays.asList(
        new User("Vasilii"),
        new User("Vladlen"),
        new User("Romeo")
    );

  }



  @Override
  public List<User> allUsers() {
    return users;
  }
}
