package cn.spring.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

/**
 * 测试生命周期的Bean
 *
 * @author macFmc
 * @date 2019/10/9-17:45
 */
public class FmcBean implements InitializingBean, DisposableBean, BeanNameAware, BeanFactoryAware {
    private String name;
    private int age;
    /**
     * 实现了BeanNameAware接口，Spring可以将BeanName注入该属性中
     */
    private String beanName;
    /**
     * 实现了BeanFactory接口，Spring可将BeanFactory注入该属性中
     */
    private BeanFactory beanFactory;

    public FmcBean() {
        System.out.println("【Bean构造方法】学生类的无参构造方法");
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("FmcBean{");
        sb.append("name='").append(name).append('\'');
        sb.append(", age=").append(age);
        sb.append(", beanName='").append(beanName).append('\'');
        sb.append(", beanFactory=").append(beanFactory);
        sb.append('}');
        return sb.toString();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        System.out.println("【set注入】注入学生的name属性");
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        System.out.println("【set注入】注入学生的age属性");
        this.age = age;
    }

    /**
     * 自己编写的初始化方法
     */
    public void myInit() {
        System.out.println("【init-method】调用init-method属性配置的初始化方法");
    }

    /**
     * 自己编写的销毁方法
     */
    public void myDestroy() {
        System.out.println("【destroy-method】调用destroy-method属性配置的销毁方法");
    }

    /**
     * BeanFactoryAware接口的方法
     *
     * @param beanFactory
     * @throws BeansException
     */
    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        this.beanFactory = beanFactory;
        System.out.println("【BeanFactoryAware接口】调用BeanFactoryAware的setBeanFactory方法得到beanFactory引用");
    }

    /**
     * BeanNameAware接口的方法
     *
     * @param name
     */
    @Override
    public void setBeanName(String name) {
        this.beanName = name;
        System.out.println("【BeanNameAware接口】调用BeanNameAware的setBeanName方法得到Bean的名称");
    }

    /**
     * InitializingBean接口的方法
     *
     * @throws Exception
     */
    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("【InitializingBean接口】调用InitializingBean接口的afterPropertiesSet方法");
    }

    /**
     * DisposableBean接口的方法
     *
     * @throws Exception
     */
    @Override
    public void destroy() throws Exception {
        System.out.println("【DisposableBean接口】调用DisposableBean接口的destroy方法");
    }
}