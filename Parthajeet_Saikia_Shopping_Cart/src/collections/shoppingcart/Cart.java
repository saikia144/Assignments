package collections.shoppingcart;

import java.util.HashMap;
import java.util.Map;

public class Cart {
    private Map<Integer, Integer> cartItems = new HashMap<Integer, Integer>();
    private Products products;
    
    public Cart(Products products) {
        this.products = products;
    }
    
    public void addToCart(int productId, int quantity) {
        if (cartItems.containsKey(productId)) {
            int currentQuantity = cartItems.get(productId);
            cartItems.put(productId, currentQuantity + quantity);
        } else {
            cartItems.put(productId, quantity);
        }
    }
    
    public void removeFromCart(int productId, int quantity) {
        if (cartItems.containsKey(productId)) {
            int currentQuantity = cartItems.get(productId);
            if (currentQuantity <= quantity) {
                cartItems.remove(productId);
            } else {
                cartItems.put(productId, currentQuantity - quantity);
            }
        }
    }
    
    public double calculateTotal() {
        double total = 0;
        for (Map.Entry<Integer, Integer> entry : cartItems.entrySet()) {
            int productId = entry.getKey();
            int quantity = entry.getValue();
            Product product = products.getProductList().get(productId - 1);
            total += product.getPrice() * quantity;
        }
        return total;
    }
    
    public void printCartItems() {
        System.out.println("Product\t\tQuantity\tPrice");
        for (Map.Entry<Integer, Integer> entry : cartItems.entrySet()) {
            int productId = entry.getKey();
            int quantity = entry.getValue();
            Product product = products.getProductList().get(productId - 1);
            System.out.println(product.getProductName() + "\t\t" + quantity + "\t\t" + product.getPrice());
        }
    }
}
