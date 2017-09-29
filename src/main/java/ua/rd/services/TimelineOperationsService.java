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
// user ??

  public TimelineOperationsService(Iterable<Tweet> tweets) {
    this.tweets = tweets;
  }
  // TODO to timeline do

  @Override
  public void twitting(String text) {

  }

  @Override
  public void reTwitting(String text, Tweet tweet) {

  }

  @Override
  public void like(Tweet tweet) {

    tweet.getTweetOperations().like();

  }

  @Override
  public Collection<Tweet> getUserTimeline() {

    return userTimeline;

  }

  protected void addToTimeline(Tweet tweet) {
    userTimeline.add(tweet);

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
