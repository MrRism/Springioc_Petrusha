package ua.rd;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.beans.propertyeditors.StringArrayPropertyEditor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.Scope;
import org.springframework.core.env.Environment;
import ua.rd.domain.Tweet;
import ua.rd.domain.User;
import ua.rd.repository.TweetRepository;
import ua.rd.repository.UserRepository;
import ua.rd.services.SimpleTweetService;
import ua.rd.services.TimelineOperationsService;
import ua.rd.services.TweetOperations;
import ua.rd.services.TweetOperationsService;
import ua.rd.services.TweetService;
import ua.rd.services.UserOperationsService;

@Configuration
public class ServiceConfig {

  @Autowired
  UserRepository userRepository;
  @Autowired
  private TweetRepository tweetRepository;
  @Autowired
  private Environment env;

  @Bean

  public UserOperationsService userOperations() {
    return new UserOperationsService(userRepository){

      @PostConstruct
      protected void generateTimelineOperation() {
        List<User> allUsers = new ArrayList<>();
        userRepository.allUsers().iterator().forEachRemaining(allUsers::add);
        allUsers.forEach(n-> n.setTimelineOperations(timelineOperations(n)));
      }
    };
  }

  @Bean
  @Scope("prototype")
  @Lookup
  @Lazy
  public TimelineOperationsService timelineOperations(User user) {
    return new TimelineOperationsService(tweetRepository.allTweets()) {




      @Override
      protected Tweet newTweet() {
        setUser(user);
        return tweet();
      }

      @Override
      protected TweetOperations newTweetOperations(Tweet tweet)
      {
        setUser(user);
        return tweetOperations(tweet);
      }
    };
  }

  @Bean
  @Scope("prototype")
  @Profile("default")
  public Tweet tweet() {
    return new Tweet();
  }

  @Bean("tweet")
  @Scope("prototype")
  @Profile("dev")
  public Tweet tweetDev() {
    Tweet tweet = new Tweet();
    tweet.setTweetId(1L);
    if (Arrays.asList(env.getActiveProfiles()).contains("test")) {
      tweet.setTxt("Dev + Test Text");
    } else {
      tweet.setTxt("Dev Text");
    }
    return tweet;
  }

  @Bean
  public User user() {
    User generatedUser = new User("noName");
    generatedUser.setTimelineOperations(timelineOperations(generatedUser));
    return generatedUser;

  }

  @Bean
  @Scope("prototype")
  public TweetOperationsService tweetOperations(Tweet tweet) {
    return new TweetOperationsService(tweet);
  }

  @Bean
  public TweetService tweetService() {
    TweetService tweetService =
        new SimpleTweetService(tweetRepository) {
          @Override
          public Tweet newTweet() {
            return tweet();
          }
        };

    return tweetService;
  }

}
