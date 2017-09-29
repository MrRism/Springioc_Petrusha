package ua.rd.ioc;

/**
 * Created on 9/11/2017.
 *
 * @author Serhii Petrusha aka Mr_Rism
 */
public class SimpleBeanDefinition implements BeanDefinition{

  private String beanName;

  private Class<?> beanType;

  private boolean isPrototype;

  public SimpleBeanDefinition(String beanName, Class<?> beanType, boolean isPrototype) {
    this.beanName = beanName;
    this.beanType = beanType;
    this.isPrototype = isPrototype;
  }
  public SimpleBeanDefinition(String beanName, Class<?> beanType) {
    this.beanName = beanName;
    this.beanType = beanType;
    this.isPrototype = false;
  }

  public void setBeanName(String beanName) {
    this.beanName = beanName;
  }

  public void setBeanType(Class<?> beanType) {
    this.beanType = beanType;
  }

  public void setPrototype(boolean prototype) {
    isPrototype = prototype;
  }

  @Override
  public String getBeanName() {
    return beanName;
  }

  @Override
  public Class<?> getBeanType() {
    return beanType;
  }

  @Override
  public boolean isPrototype() {
    return isPrototype;
  }
}
