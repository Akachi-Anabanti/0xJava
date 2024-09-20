package shopper.src.main.java.models;

import shopper.src.main.java.BaseClass;

public class Product extends BaseClass{
    private String productName;
    private String ProductTag = "default";
    private Integer productQuantity = 0;

    public Product(String productName) {
        this.productName = productName;
    }

    public void save() {
        save();
    }
}