package model;

import java.util.Date;
import java.util.List;

public class Order {
    private static int ordinalNumber = 0;

    private int number;
    private Name user;
    private Date executionDate;
    private Date intendedShipmentDate;
    private Double priceTotal;
    List<Product> products;


    public Order(Name user) {
        this.user = user;
        this.number = ++ordinalNumber;
    }

}
