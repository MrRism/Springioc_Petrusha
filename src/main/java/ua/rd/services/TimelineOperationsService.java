package ua.rd.services;


import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Deque;
import ua.rd.domain.Tweet;
import ua.rd.domain.User;


/**
 * Created on 24.09.2017.
 *
 * @author Serhii Petrusha aka Mr_Rism
 */
public class TimelineOperationsService implements TimelineOperations {

  private Iterable<Tweet> tweets;

  private Deque<Tweet> userTimeline = new ArrayDeque<>();

  private SimpleTweetService simpleTweetService;

  private User user;


  public TimelineOperationsService(Iterable<Tweet> tweets) {
    this.tweets = tweets;
    for (Tweet tweet : tweets
        ) {
      if (user != null) {
        if (tweet.getUser().equals(user)) {
          addToTimeline(tweet);
        }
      }
    }
  }
  // TODO to timeline do

  @Override
  public void twitting(String text) {
    Tweet tweet = newTweet();
    tweet.setTxt(text);
    tweet.setUser(user);
    tweet.setTweetOperations(newTweetOperations(tweet));
    addToTimeline(tweet);

  }

  @Override
  public void reTwitting(String text, Tweet tweet) {

    Tweet newTweet = newTweet();
    tweet.getTweetOperations().reTweet();
    newTweet.setTxt(
        "ReTweet \""+
            tweet.getTxt()+
            "\" "
            +text
    );
    newTweet.setUser(user);
    newTweet.setTweetOperations(newTweetOperations(newTweet));
    addToTimeline(newTweet);

  }

  @Override
  public void like(Tweet tweet) {

    tweet.getTweetOperations().like();

  }

  @Override
  public Collection<Tweet> getUserTimeline() {

    return userTimeline;

  }

  private void addToTimeline(Tweet tweet) {
    userTimeline.add(tweet);

  }

  protected void setUser(User user) {
    this.user = user;
  }

  protected Tweet newTweet(){
    return null;
  }
  protected TweetOperations newTweetOperations(Tweet tweet){
    return null;
  }

//  public TimelineOperationsService(Iterable<Tweet> tweets) {
//    this.tweets = tweets;
//  }
//
//  public void twitting(Tweet tweet){
//    userTimeline.add(new TweetOperationsService(tweet));
//
//  }
//
//  public void reTwitting(Tweet tweet){
//    TweetOperationsService tweetOperationsT = new TweetOperationsService(tweet);
//    tweetOperationsT.reTweet();
//    userTimeline.add(tweetOperationsT);
//
//  }
//  public void like(Tweet tweet){
//    TweetOperationsService tweetOperationsT = new TweetOperationsService(tweet);
//    tweetOperationsT.like();
//    userTimeline.add(tweetOperationsT);
//
//  }
//
//  public Object getLastActivity(){
//    return userTimeline.getLast();
//  }

}
