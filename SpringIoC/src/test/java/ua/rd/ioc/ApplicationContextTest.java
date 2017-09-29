package ua.rd.ioc;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertSame;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.junit.Ignore;
import org.junit.Test;

public class ApplicationContextTest {

  @Test(expected = NoSuchBeanException.class)
  public void getBeanWithEmptyContext() throws Exception {
    Context context = new ApplicationContext();
    context.getBean("abc");
  }

  @Test
  public void getBeanDefinitionNamesWithEmptyContext() throws Exception {
    //given
    Context context = new ApplicationContext();

    //when
    String[] actual = context.getBeanDefinitionNames();

    //tnen
    String[] expected = {};
    assertArrayEquals(expected, actual);
  }

  @Test
  public void getBeanDefinitionNamesWithOneBeanDefinition() throws Exception {
    String beanName = "FirstBean";
    List<String> beanDescriptions = Arrays.asList(beanName);
    Config config = new JavaMapConfig(convertTestListToMap(beanDescriptions));
    Context context = new ApplicationContext(config);

    String[] actual = context.getBeanDefinitionNames();

    String[] expected = {beanName};
    assertArrayEquals(expected, actual);
  }

  @Test
  public void getBeanDefinitionNamesWithSeveralBeanDefinitions() throws Exception {
    String beanName1 = "FirstBean";
    String beanName2 = "SecondBean";
    List<String> beanDescriptions = Arrays.asList(beanName1, beanName2);
    Config config = new JavaMapConfig(convertTestListToMap(beanDescriptions));
    Context context = new ApplicationContext(config);

    String[] actual = context.getBeanDefinitionNames();

    String[] expected = {beanName1, beanName2};
    assertArrayEquals(expected, actual);
  }

  @Test
  public void getBeanDefinitionNamesWithEmptyBeanDefinition() throws Exception {
    List<String> beanDescriptions = Collections.emptyList();
    Config config = new JavaMapConfig(convertTestListToMap(beanDescriptions));
    Context context = new ApplicationContext(config);

    String[] actual = context.getBeanDefinitionNames();

    String[] expected = {};
    assertArrayEquals(expected, actual);
  }

  @Test
  public void getBeanWithOneBeanDefinitionWithoutType() throws Exception {
    String beanName = "FirstBean";
    List<String> beanDescriptions = Arrays.asList(beanName);
    Config config = new JavaMapConfig(convertTestListToMap(beanDescriptions));
    Context context = new ApplicationContext(config);

    Object bean = context.getBean(beanName);
    //


  }
  @Ignore
  @Test
  public void getBeanWithOneBeanDefinition() throws Exception {
    String beanName = "FirstBean";
    Class<TestBean> beanType = TestBean.class;

//    Map<String, Class<?>> beanDescriptions =
//        new HashMap<String, Class<?>>() {{
//          put(beanName, beanType);
//        }};
    Map<String, Map<String, Object>> beanDescriptions =
        new HashMap<String, Map<String, Object>>() {{
          put(beanName, new HashMap<String, Object>() {{
            put("class", beanType);
          }});
        }};

    //TuPLE

    Config config = new JavaMapConfig(beanDescriptions);
    Context context = new ApplicationContext(config);

    assertEquals(TestBean.class, context.getBean(beanName).getClass());
  }

  @Ignore
  @Test
  public void getBeanIsSingleton() throws Exception {
    String beanName = "FirstBean";
    Class<TestBean> beanType = TestBean.class;

//    Map<String, Class<?>> beanDescriptions =
//        new HashMap<String, Class<?>>() {{
//          put(beanName, beanType);
//        }};
    Map<String, Map<String, Object>> beanDescriptions =
        new HashMap<String, Map<String, Object>>() {{
          put(beanName, new HashMap<String, Object>() {{
            put("class", beanType);
          }});
        }};

    //TuPLE

    Config config = new JavaMapConfig(beanDescriptions);
    Context context = new ApplicationContext(config);

    TestBean bean1 = (TestBean) context.getBean(beanName);
    TestBean bean2 = (TestBean) context.getBean(beanName);

    assertSame(bean1, bean2);
  }

  public void getBeanIsPrototype() throws Exception {
    String beanName = "FirstBean";
    Class<TestBean> beanType = TestBean.class;

//    Map<String, Class<?>> beanDescriptions =
//        new HashMap<String, Class<?>>() {{
//          put(beanName, beanType);
//        }};
    Map<String, Map<String, Object>> beanDescriptions =
        new HashMap<String, Map<String, Object>>() {{
          put(beanName, new HashMap<String, Object>() {{
            put("class", beanType);
            put("isPrototype", true);
          }});
        }};

    //TuPLE

    Config config = new JavaMapConfig(beanDescriptions);
    Context context = new ApplicationContext(config);

    TestBean bean1 = (TestBean) context.getBean(beanName);
    TestBean bean2 = (TestBean) context.getBean(beanName);

    assertNotSame(bean1, bean2);
  }


  @Test
  public void getBeanNotSameInstanceSameClassBeans() throws Exception {
    String beanName1 = "FirstBean";
    String beanName2 = "SecondBean";
    Class<TestBean> beanType = TestBean.class;

//    Map<String, Class<?>> beanDescriptions =
//        new HashMap<String, Class<?>>() {{
//          put(beanName, beanType);
//        }};
    Map<String, Map<String, Object>> beanDescriptions =
        new HashMap<String, Map<String, Object>>() {{
          put(beanName1, new HashMap<String, Object>() {{
            put("class", beanType);
          }});
          put(beanName2, new HashMap<String, Object>() {{
            put("class", beanType);
          }});
        }};

    //TuPLE

    Config config = new JavaMapConfig(beanDescriptions);
    Context context = new ApplicationContext(config);

    TestBean bean1 = (TestBean) context.getBean(beanName1);
    TestBean bean2 = (TestBean) context.getBean(beanName2);

    assertSame(bean1, bean2);
  }

  private Map<String, Map<String, Object>> convertTestListToMap(
      List<String> beanDescriptionWithBeanNamesOnly) {

    return beanDescriptionWithBeanNamesOnly.stream()
        .collect(
            Collectors.toMap(
                beanName -> beanName,
                beanName -> new HashMap<String, Object>(){{put("type", String.class);}}));


  }

  static class TestBean {


  }
}