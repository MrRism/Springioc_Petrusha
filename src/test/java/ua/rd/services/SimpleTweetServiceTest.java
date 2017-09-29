package ua.rd.services;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.ContextHierarchy;
import org.springframework.test.context.junit4.SpringRunner;
import ua.rd.RepositoryConfig;
import ua.rd.ServiceConfig;
import ua.rd.repository.TweetRepository;

/**
 * Created on 9/28/2017.
 *
 * @author Serhii Petrusha aka Mr_Rism
 */
@RunWith(SpringRunner.class)
@DirtiesContext(classMode = ClassMode.BEFORE_EACH_TEST_METHOD)
//@ContextConfiguration(classes = {RepositoryConfig.class})
@ContextHierarchy({
    @ContextConfiguration(locations = "classpath:repoContext.xml"),
    @ContextConfiguration(classes = ServiceConfig.class)

})
@ActiveProfiles("dev")
public class SimpleTweetServiceTest {

//  @Autowired
//  TweetRepository tweetRepository;
  @Autowired
  TweetService tweetService;

  public SimpleTweetServiceTest() {
    System.out.println("constr test");
//    throw new RuntimeException();


  }

  @Test
  public void newTweetTweetsNotEqual() throws Exception {

//    TweetRepository tweetRepository = mock(TweetRepository.class);
//    TweetService tweetService = new SimpleTweetService(tweetRepository);

    assertNotSame(tweetService.newTweet(),tweetService.newTweet());


  }
  @Test
  public void newTweetTweetsNotNull() throws Exception {

//    TweetRepository tweetRepository = mock(TweetRepository.class);
//    TweetService tweetService = new SimpleTweetService(tweetRepository);
    System.out.println(tweetService.newTweet().getTxt());
    assertNotNull(tweetService);


  }

}