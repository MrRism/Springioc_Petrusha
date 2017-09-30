package ua.rd.services;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import ua.rd.domain.Tweet;
import ua.rd.domain.User;

/**
 * Created on 24.09.2017.
 *
 * @author Serhii Petrusha aka Mr_Rism
 */
public class TweetOperationsService implements TweetOperations {

  protected int reTweetCount;
  private Tweet tweet;
  private int likesCount;
  private String text;


  private Set<User> mentions;//?

  public TweetOperationsService(Tweet tweet) {

    if (tweet.getTxt().length() > 140) {

      throw new RuntimeException("Tweet are too long");
    } else {
      text = tweet.getTxt();
    }
    this.tweet = tweet;

  }

  public void like() {
    likesCount++;
  }

  @Override
  public void reTweet() {
    reTweetCount++;
  }

  @Override
  public int getLikeCount() {
    return likesCount;
  }

  @Override
  public int getReTweetCount() {
    return reTweetCount;
  }

  @Override
  public String getText() {
    return null;
  }

  public Tweet reply(User... users) {
    mentions.addAll(Arrays.asList(users));

    return null;
  }

  @Override
  public List<User> getMentions() {
    return new ArrayList<>(mentions);
  }



}
