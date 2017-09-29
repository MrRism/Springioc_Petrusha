package ua.rd;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ua.rd.repository.InMemTweetRepository;
import ua.rd.repository.InMemUserRepository;
import ua.rd.repository.TweetRepository;
import ua.rd.repository.UserRepository;

@Configuration
public class RepositoryConfig {

    @Bean(initMethod = "init")
    public TweetRepository tweetRepository() {
        return new InMemTweetRepository();
    }

    @Bean(initMethod = "init")
    public UserRepository userRepository() {
        return new InMemUserRepository();
    }

}
