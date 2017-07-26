package model;

import java.util.Date;

public class User {
    private static int ordinalNumber = 0;
    private int number;
    private Name name;
    private String password;
    private String emailAddress;
    private String IDNumber;
    private Double age;
    private Date creationTime;
    OrdersCollection orders;

    public User(String firstName, String lastName, String password, String emailAddress, String IDNumber, Double age) {
        this.name = new Name(firstName, lastName);
        this.password = password;
        this.emailAddress = emailAddress;
        this.IDNumber = IDNumber;
        this.age = age;
        this.number = ++ordinalNumber;
        creationTime = new Date();
        orders.create();
    }

}
