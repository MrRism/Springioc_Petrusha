package ua.rd.repository;

import java.util.Arrays;
import java.util.List;
import ua.rd.domain.Tweet;

/**
 * Created on 9/11/2017.
 *
 * @author Serhii Petrusha aka Mr_Rism
 */
public class InMemTweetRepository implements TweetRepository {

  private List<Tweet> tweets;

  {
    tweets = Arrays.asList(
        new Tweet( "message",1L, null),new Tweet( "message",2L, null));

  }

  @Override
  public Iterable<Tweet> allTweets() {
    return tweets;
  }
}
