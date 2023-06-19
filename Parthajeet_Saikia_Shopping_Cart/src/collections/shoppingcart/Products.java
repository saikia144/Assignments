package collections.shoppingcart;

import java.util.ArrayList;

public class Products {
    private ArrayList<Product> productList = new ArrayList<Product>();
    
    public void addProduct(Product product) {
        productList.add(product);
    }
    
    public ArrayList<Product> getProductList() {
        return productList;
    }
}
