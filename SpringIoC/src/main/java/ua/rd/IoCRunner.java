package ua.rd;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import ua.rd.ioc.Config;
import ua.rd.repository.InMemTweetRepository;

public class IoCRunner {

  public static void main(String[] args) {
    Map<String, Map<String, Object>> beanDescriptions =
        new HashMap<String, Map<String, Object>>() {{
          put("tweetRepo", new HashMap<String, Object>() {{
            put("class", InMemTweetRepository.class);
            put("isPrototype", false);
          }});
        }};

    Config config

  }

}