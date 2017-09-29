package ua.rd.ioc;

import java.util.Map;

public class JavaMapConfig implements Config {

  private Map<String, Map<String, Object>> beanDescriptions;

//    public JavaMapConfig(List<String> beanDescriptions) {
//        this(beanDescriptions.stream().collect(Collectors.toMap(p-> p, p -> String.class)));
//
//
//
//    }

  public JavaMapConfig(Map<String, Map<String, Object>> beanDescriptions) {
    this.beanDescriptions = beanDescriptions;
  }

  private BeanDefinition beanDefinition(Map.Entry<String, Map<String, Object>> descriptionEntry
  ) {
    return new SimpleBeanDefinition(
        descriptionEntry.getKey(),
        (Class<?>) descriptionEntry.getValue().get("type"),
        (boolean) descriptionEntry.getValue().get("isPrototype")
    );

  }

  @Override
  public BeanDefinition[] beanDefinitions() {
    BeanDefinition[] beanDefinitions = beanDescriptions.entrySet().stream()
        .map(this::beanDefinition)
        .toArray(BeanDefinition[]::new);
//                beanDescriptions.stream()
//               .map(this::beanDefinition)
//               .toArray(BeanDefinition[]::new);
//        int i= 0;
//        for (String s : beanDescriptions.keySet()
//        ) {
//            beanDefinitions[i++]=new BeanDefinition() {
//                @Override
//                public String getBeanName() {
//                    return s;
//                }
//
//                @Override
//                public Class<?> getBeanType() {
//                    return beanDescriptions.get(s);
//                }
//            };
//
//        }

    return beanDefinitions;
  }


}
