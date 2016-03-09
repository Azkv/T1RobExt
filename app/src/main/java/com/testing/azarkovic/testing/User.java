package com.testing.azarkovic.testing;

/**
 * Created by azarkovic on 7.3.2016..
 */
public class User
{
    private String uid,name,surname,arrivalDate,language,room;
    public User(String uid, String name, String surname, String arrivalDate, String language, String room )
    {
        this.uid = uid;
        this.name = name;
        this.surname = surname;
        this.arrivalDate = arrivalDate;
        this.language = language;
        this.room = room;
    }

    //G / S

    public String getUid() {
        return uid;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getArrivalDate() {
        return arrivalDate;
    }

    public String getLanguage() {
        return language;
    }

    public String getRoom() {
        return room;
    }
}
