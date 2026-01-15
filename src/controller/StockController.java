/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

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
        productList.add(new ProductModel("P003", "Pixel 8", "Google", "Mobile", 75000, 8));
        productList.add(new ProductModel("P004", "MacBook Air", "Apple", "Laptop", 150000, 3));
        productList.add(new ProductModel("P005", "Galaxy Tab", "Samsung", "Tablet", 45000, 12));
        productList.add(new ProductModel("P006", "Sony XM5", "Sony", "Headphone", 35000, 15));

        for (ProductModel p : productList) {
            addToRecent(p);
        }
    }

    // Create (Insert)
    public void addProduct(ProductModel product) {
        productList.add(product);
    }

    // Read (Get All)
    public LinkedList<ProductModel> getAllProducts() {
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

    // SELECTION SORT (Sort by ID)
    public void sortById() {
        int n = productList.size();
        for (int i = 0; i < n - 1; i++) {
            int min_idx = i;
            for (int j = i + 1; j < n; j++) {
                // Compare IDs (String comparison)
                String id1 = productList.get(j).getProductId().toLowerCase();
                String id2 = productList.get(min_idx).getProductId().toLowerCase();

                if (id1.compareTo(id2) < 0) {
                    min_idx = j;
                }
            }
            // Swap the found minimum element with the first element
            ProductModel temp = productList.get(min_idx);
            productList.set(min_idx, productList.get(i));
            productList.set(i, temp);
        }
    }

    // BUBBLE SORT (Sort by Price)
    public void sortByPrice() {
        int n = productList.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                // Compare Prices
                if (productList.get(j).getPrice() > productList.get(j + 1).getPrice()) {
                    // Swap productList[j] and productList[j+1]
                    ProductModel temp = productList.get(j);
                    productList.set(j, productList.get(j + 1));
                    productList.set(j + 1, temp);
                }
            }
        }
    }

    public ProductModel binarySearchById(String searchValue) {
        // Binary Search REQUIRES a sorted list to work.
        sortById();

        int low = 0;
        int high = productList.size() - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            String midId = productList.get(mid).getProductId();

            // Compare search value with middle element
            int result = midId.compareToIgnoreCase(searchValue);

            if (result == 0) {
                return productList.get(mid); // Found
            }
            if (result < 0) {
                low = mid + 1; // If result is smaller, ignore left half
            } else {
                high = mid - 1; // If result is greater, ignore right half
            }
        }
        return null; // Not found
    }

    // LINEAR SEARCH (Model Number or Price)
    public ProductModel linearSearch(String query) {
        // Iterate through the entire list (Linear Search algorithm)
        for (ProductModel p : productList) {

            // 1. Check Model Number (Case insensitive)
            if (p.getModelNumber().equalsIgnoreCase(query)) {
                return p;
            }

            // 2. Check Price (Convert double to String for comparison)
            // matching "1200" or "1200.0"
            String priceStr = String.valueOf(p.getPrice());
            if (priceStr.equals(query) || priceStr.replace(".0", "").equals(query)) {
                return p;
            }

            // 3. (Optional) You can keep ID search here too if you want
            if (p.getProductId().equalsIgnoreCase(query)) {
                return p;
            }
        }
        return null; // Not found
    }

    public LinkedList<ProductModel> searchProducts(String query) {
        LinkedList<ProductModel> results = new LinkedList<>();
        String lowerQuery = query.toLowerCase().trim();

        for (ProductModel p : productList) {
            // check Brand, Model, and Category.
            if (p.getBrand().toLowerCase().contains(lowerQuery) ||
                    p.getModelNumber().toLowerCase().contains(lowerQuery) ||
                    p.getCategory().toLowerCase().contains(lowerQuery)) {

                results.add(p);
            }
        }
        return results;
    }

    // Create a list to hold RECENT items (Limited to 5)
    private LinkedList<ProductModel> recentList = new LinkedList<>();

    // Method to add to this list (Call this when you add a product)
    public void addToRecent(ProductModel p) {
        // Add to the FRONT (Newest first) -> Stack behavior
        recentList.addFirst(p);

        // Ensure we only keep the last 5 items
        if (recentList.size() > 5) {
            recentList.removeLast(); // Remove the oldest
        }
    }

    // Getter for the view to access
    public LinkedList<ProductModel> getRecentList() {
        return recentList;
    }
}