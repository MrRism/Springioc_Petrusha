package ua.rd.services;

import java.util.Collection;
import java.util.List;
import ua.rd.domain.Tweet;
import ua.rd.domain.User;

/**
 * Created on 27.09.2017.
 *
 * @author Serhii Petrusha aka Mr_Rism
 */
public interface TimelineOperations {

  void twitting(String text);

  void reTwitting(String text, Tweet tweet);

  void like(Tweet tweet);

  Collection<Tweet> getUserTimeline();


}
