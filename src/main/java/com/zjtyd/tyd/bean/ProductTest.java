package com.zjtyd.tyd.bean;

/**
 * Created with IntelliJ IDEA.
 * User: Abbot
 * Date: 2017-10-25
 * Time: 02:46
 * Description:
 */
public class ProductTest
{
    private static final long serialVersionUID= 748392348L;
    private String name;
    private String description;
    private float price;

    public ProductTest()
    {
    }

    public ProductTest(String name, String description, float price)
    {
        this.name = name;
        this.description = description;
        this.price = price;
    }


    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public float getPrice()
    {
        return price;
    }

    public void setPrice(float price)
    {
        this.price = price;
    }
}
