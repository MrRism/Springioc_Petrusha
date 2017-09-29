package ua.rd.repository;

import ua.rd.domain.Tweet;

/**
 * Created on 9/11/2017.
 *
 * @author Serhii Petrusha aka Mr_Rism
 */
public interface TweetRepository {

  Iterable<Tweet> allTweets();


}
