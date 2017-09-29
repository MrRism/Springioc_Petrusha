package ua.rd.domain;

/**
 * Created on 9/11/2017.
 *
 * @author Serhii Petrusha aka Mr_Rism
 */
public class Tweet {

  private String txt;

  private Long tweetId;

  private User user;

  public Tweet() {
  }

  public Tweet(String txt, User user) {
    this.txt = txt;
    this.user = user;
  }

  public Tweet(String txt, Long tweetId, User user) {
    this.txt = txt;
    this.tweetId = tweetId;
    this.user = user;

  }

  public String getTxt() {
    return txt;
  }

  public void setTxt(String txt) {
    this.txt = txt;
  }

  public Long getTweetId() {
    return tweetId;
  }

  public void setTweetId(Long tweetId) {
    this.tweetId = tweetId;
  }

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }
}
