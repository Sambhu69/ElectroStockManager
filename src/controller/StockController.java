/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

/**
 *
 * @author ACER
 */
import model.ProductModel;
import java.util.LinkedList;

public class StockController {
    // This list acts as your temporary database
    private LinkedList<ProductModel> productList;

    public StockController() {
        this.productList = new LinkedList<>();
        // Add some dummy data for testing
        productList.add(new ProductModel("P001", "S24 Ultra", "Samsung", "Mobile", 120000, 10));
        productList.add(new ProductModel("P002", "SmartTV 55", "TCL", "TV", 80000, 5));
        productList.add(new ProductModel("P003", "SmartTV 55", "TCL", "TV", 80000, 5));
        productList.add(new ProductModel("P004", "SmartTV 55", "TCL", "TV", 80000, 5));
        productList.add(new ProductModel("P005", "SmartTV 55", "TCL", "TV", 80000, 5));
        productList.add(new ProductModel("P006", "SmartTV 55", "TCL", "TV", 80000, 5));
    }

    // Create (Insert)
    public void addProduct(ProductModel product) {
        productList.add(product);
    }

    // Read (Get All)
    public LinkedList<ProductModel> getAllProducts() { // <--- Return type changed
        return productList;
    }

    // Update
    public boolean updateProduct(String id, ProductModel newDetails) {
        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i).getProductId().equals(id)) {
                productList.set(i, newDetails);
                return true;
            }
        }
        return false;
    }

    // Delete
    public boolean deleteProduct(String id) {
        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i).getProductId().equals(id)) {
                productList.remove(i);
                return true;
            }
        }
        return false;
    }

    // Search by ID
    public ProductModel searchProductById(String id) {
        for (ProductModel p : productList) {
            if (p.getProductId().equals(id)) {
                return p;
            }
        }
        return null;
    }
}