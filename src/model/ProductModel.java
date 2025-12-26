/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

public class ProductModel {
    private String productId;
    private String modelNumber;
    private String brand;
    private String category;
    private double price;
    private int stock;

    public ProductModel(String productId, String modelNumber, String brand, String category, double price, int stock) {
        this.productId = productId;
        this.modelNumber = modelNumber;
        this.brand = brand;
        this.category = category;
        this.price = price;
        this.stock = stock;
    }

    // Getters and Setters
    public String getProductId() { return productId; }
    public void setProductId(String productId) { this.productId = productId; }

    public String getModelNumber() { return modelNumber; }
    public void setModelNumber(String modelNumber) { this.modelNumber = modelNumber; }

    public String getBrand() { return brand; }
    public void setBrand(String brand) { this.brand = brand; }

    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }

    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }

    public int getStock() { return stock; }
    public void setStock(int stock) { this.stock = stock; }
}
