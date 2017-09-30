package ua.rd;

import java.util.List;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ua.rd.domain.Tweet;
import ua.rd.domain.User;
import ua.rd.services.SimpleTweetService;
import ua.rd.services.TweetService;
import ua.rd.services.UserOperationsService;

public class JavaBasedConfigRunner {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext repoContext =
                new AnnotationConfigApplicationContext(RepositoryConfig.class);

        AnnotationConfigApplicationContext serviceContext =
                new AnnotationConfigApplicationContext();
        serviceContext.setParent(repoContext);
        serviceContext.register(ServiceConfig.class);
        serviceContext.refresh();


        System.out.println("************");
        System.out.println("Warning! Code smells really badly!");
        System.out.println("************");

        UserOperationsService userOperationsService = serviceContext.getBean(UserOperationsService.class);
        List<User> users = userOperationsService.getUsers();
        User subjectUser1 = users.get(0);
        subjectUser1.getTimelineOperations().twitting("My new tweet!");
        subjectUser1.getTimelineOperations().getUserTimeline().forEach(System.out::println);

        Tweet subjectTweet1 = null;
        for (Tweet tweet:subjectUser1.getTimelineOperations().getUserTimeline()
        ) {
            subjectTweet1 = tweet;

            tweet.getTweetOperations().like();

            System.out.println("[!]Tweet like count: " + tweet.getTweetOperations().getLikeCount());

        }
        User subjectUser2 = users.get(2);
        subjectUser2.getTimelineOperations().reTwitting("My comment",subjectTweet1);
        for (Tweet tweet:subjectUser2.getTimelineOperations().getUserTimeline()
        ) {
            System.out.println(tweet);

        }
        System.out.println("[!]Retweet count: " +subjectTweet1.getTweetOperations().getReTweetCount());





    }
}
