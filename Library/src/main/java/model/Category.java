package model;

import java.util.List;

public class Category {
    private static int ordinalNumber = 0;

    private CategoryName categoryName;
    private int number;
    List<Product> products;

    public Category(CategoryName categoryName) {
        this.categoryName = categoryName;
        this.number = ++ordinalNumber;
    }
}
