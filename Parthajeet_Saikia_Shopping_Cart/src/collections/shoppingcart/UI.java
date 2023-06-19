package collections.shoppingcart;

import java.util.Scanner;

public class UI {
    private Scanner scanner = new Scanner(System.in);
    private Products products;
    private Cart cart;

    public UI() {
        products = new Products();
        products.addProduct(new Product(1, "Product 1", 10));
        products.addProduct(new Product(2, "Product 2", 20));
        products.addProduct(new Product(3, "Product 3", 30));
        cart = new Cart(products);
    }

    public void start() {
        boolean exit = false;
        while (!exit) {
            System.out.println("1. Add to cart");
            System.out.println("2. Remove from cart");
            System.out.println("3. View cart");
            System.out.println("4. Checkout");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    addToCart();
                    break;
                case 2:
                    removeFromCart();
                    break;
                case 3:
                    viewCart();
                    break;
                case 4:
                    checkout();
                    break;
                case 5:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
            System.out.println();
        }
    }

    private void addToCart() {
        System.out.print("Enter the product ID: ");
        int productId = scanner.nextInt();
        System.out.print("Enter the quantity: ");
        int quantity = scanner.nextInt();
        cart.addToCart(productId, quantity);
        System.out.println("Product added to cart successfully.");
    }

    private void removeFromCart() {
        System.out.print("Enter the product ID: ");
        int productId = scanner.nextInt();
        System.out.print("Enter the quantity: ");
        int quantity = scanner.nextInt();
        cart.removeFromCart(productId, quantity);
        System.out.println("Product removed from cart successfully.");
    }

    private void viewCart() {
        if (cart.calculateTotal() == 0) {
            System.out.println("Your cart is empty.");
        } else {
            System.out.println("Your cart:");
            cart.printCartItems();
            System.out.println("Total: " + cart.calculateTotal());
        }
    }

    private void checkout() {
        if (cart.calculateTotal() == 0) {
            System.out.println("Your cart is empty.");
        } else {
            System.out.println("Your cart:");
            cart.printCartItems();
            System.out.println("Total: " + cart.calculateTotal());
            System.out.println("Thank you for shopping with us!");
            cart = new Cart(products);
        }
    }
}
