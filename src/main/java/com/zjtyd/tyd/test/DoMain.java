package com.zjtyd.tyd.test;

import com.zjtyd.tyd.bean.Address;
import com.zjtyd.tyd.bean.Employee;
import com.zjtyd.tyd.bean.ProductTest;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Calendar;

/**
 * Created with IntelliJ IDEA.
 * User: Abbot
 * Date: 2017-10-25
 * Time: 02:57
 * Description:
 */
public class DoMain
{
    public static void main(String[] args)
    {
        ApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"config.xml"});
        ProductTest product = context.getBean("product", ProductTest.class);

        product.setName("Excellent snake oil");
        System.out.println("product: " + product.getName());


    }

    @Test
    public void testGetInstance()
    {
        ApplicationContext context = new ClassPathXmlApplicationContext("calendar.xml");
        Calendar calendar = context.getBean("calendar", Calendar.class);
        System.out.println(calendar.getTime());
    }

    @Test
    public void testConstructors()
    {
        ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
        ProductTest featureProduct = context.getBean("featureProduct", ProductTest.class);
        ProductTest featureProduct2 = context.getBean("featureProduct2", ProductTest.class);
        System.out.println("featureProduct " + featureProduct.getName() + ":" + featureProduct.getDescription() + ":"
                + featureProduct
                .getPrice());
        System.out.println("featureProduct2 " + featureProduct2.getName() + ":" + featureProduct2.getDescription() +
                ":" + featureProduct2
                .getPrice());

    }


    @Test
    public void testAddressEmployee()
    {
        ApplicationContext context = new ClassPathXmlApplicationContext("AddressEmployee.xml");
        Address address = context.getBean("address", Address.class);

        Employee employee1 = context.getBean("employee1", Employee.class);

        System.out.println(address.toString());

        System.out.println(employee1.toString());
    }
}
