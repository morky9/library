package model;

public class Product implements Comparable<Product> {
    private String name;
    private String sku; // TODO: uniqe!
    private Double price;
    private int qty;
    private CategoryName category;

    public Product(String name, String sku, Double price, int qty, CategoryName category) {
        this.name = name;
        this.sku = sku;
        this.price = price;
        this.qty = qty;
        this.category = category;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public void setCategory(CategoryName category) {
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public String getSku() {
        return sku;
    }

    public Double getPrice() {
        return price;
    }

    public int getQty() {
        return qty;
    }

    public CategoryName getCategory() {
        return category;
    }

    @Override
    public int compareTo(Product o) {
        return this.sku.compareTo(o.sku);
    }
}
