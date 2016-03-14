package com.testing.azarkovic.testing.Database.Model;

import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.util.Date;


/**
 * Created by azarkovic on 7.3.2016..
 */
@DatabaseTable(tableName = "user")
public class User
{
    public static final String UUID = "uuid";
    public static final String NAME = "name";
    public static final String SURNAME = "surname";
    public static final String ARRIVAL_DATE = "arrival_date";
    public static final String LANGUAGE = "language";
    public static final String ROOM = "room";

    @DatabaseField(columnName = UUID, dataType = DataType.STRING, width = 36)
    private String uuid;
    @DatabaseField(columnName = NAME, dataType = DataType.STRING, width = 45)
    private String name;
    @DatabaseField(columnName = SURNAME, dataType = DataType.STRING, width = 45)
    private String surname;
    @DatabaseField(columnName = ARRIVAL_DATE, dataType = DataType.STRING)
    private String arrivalDate;
    @DatabaseField(columnName = LANGUAGE, dataType = DataType.STRING, width = 45)
    private String language;
    @DatabaseField(columnName = ROOM, dataType = DataType.STRING, width = 45)
    private String room;

    public User(){};

    public User(String uuid, String name, String surname, String arrivalDate, String language, String room) {
        this.uuid = uuid;
        this.name = name;
        this.surname = surname;
        this.arrivalDate = arrivalDate;
        this.language = language;
        this.room = room;
    }

    //G / S


    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(String arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }
}
