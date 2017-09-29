package ua.rd.services;

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


  private Tweet[] mentions;//?

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

  public Tweet reply(Tweet tweet) {

    return null;
  }

  @Override
  public User getMentions() {
    return null;
  }

  @Override
  public void setMentions(User user) {

  }


}
