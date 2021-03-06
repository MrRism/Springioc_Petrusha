package ua.rd.services;

import java.util.List;
import ua.rd.domain.Tweet;
import ua.rd.domain.User;

/**
 * Created on 27.09.2017.
 *
 * @author Serhii Petrusha aka Mr_Rism
 */
public interface TweetOperations {

  int getLikeCount();
  int getReTweetCount();
  String getText();
  Tweet reply(User... users);
  List<User> getMentions();


  void reTweet();

  void like();
}
