package com.testing.azarkovic.testing;

import java.io.Serializable;

/**
 * Created by azarkovic on 3.3.2016..
 */
public class Person implements Serializable
{
    public static final String SERIALIZATION_KEY = "person_key";


    private String name,title;
    private int imgRes;


    public Person(String name, String title, int imgRes)
    {
        setName(name);
        setTitle(title);
        setImgRes(imgRes);
    }


    //G/S
    public String getName() {
        return name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getImgRes() {
        return imgRes;
    }

    public void setImgRes(int imgRes) {
        this.imgRes = imgRes;
    }

    public void setName(String name) {
        this.name = name;

    }
}
