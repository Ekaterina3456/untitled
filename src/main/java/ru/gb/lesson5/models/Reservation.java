package ru.gb.lesson5.models;

import java.util.Date;

public class Reservation {

    private static int counter = 1000;

    private final int id;

    private String name;

    private Date date;

    public Reservation(Date date, String name) {
        this.name = name;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Date getDate() {
        return date;
    }

    {
        id = ++counter;
    }
}
