import java.util.ArrayList;
import java.util.Scanner;

public class ShoppingCart {
    private ArrayList<Product> cart;

    public ShoppingCart() {
        cart = new ArrayList<>();
    }

    public void addProduct(Product product) {
        cart.add(product);
    }

    public void removeProduct(int index) {
        cart.remove(index);
    }

    public double getTotalPrice() {
        double totalPrice = 0;
        for (Product product : cart) {
            totalPrice += product.getPrice();
        }
        return totalPrice;
    }

    public void displayCart() {
        System.out.println("Items in the cart:");
        for (int i = 0; i < cart.size(); i++) {
            System.out.println((i + 1) + ". " + cart.get(i).getName() + " - $" + cart.get(i).getPrice());
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ShoppingCart cart = new ShoppingCart();

        Product[] products = {
                new Product("Product 1", 10.99),
                new Product("Product 2", 20.49),
                new Product("Product 3", 5.99),
                new Product("Product 4", 15.79),
                new Product("Product 5", 8.99),
                new Product("Product 6", 12.49),
                new Product("Product 7", 6.99),
                new Product("Product 8", 18.99),
                new Product("Product 9", 9.49),
                new Product("Product 10", 11.99)
        };

        // Display available products
        System.out.println("Available products:");
        for (int i = 0; i < products.length; i++) {
            System.out.println((i + 1) + ". " + products[i].getName() + " - $" + products[i].getPrice());
        }

        boolean done = false;
        while (!done) {
            System.out.print("Select a product (0 to exit): ");
            int choice = scanner.nextInt();
            if (choice == 0) {
                done = true;
            } else if (choice > 0 && choice <= products.length) {
                cart.addProduct(products[choice - 1]);
                System.out.println("Product added to cart.");
            } else {
                System.out.println("Invalid option.");
            }
        }

        cart.displayCart();

        // Calculate and display total price
        System.out.println("Total price: $" + cart.getTotalPrice());

        // Remove product from cart (optional)
        System.out.print("Do you want to remove a product from the cart? (yes/no): ");
        String deleteChoice = scanner.next();
        if (deleteChoice.equalsIgnoreCase("yes")) {
            System.out.print("Enter the number of the product you want to remove: ");
            int deleteIndex = scanner.nextInt();
            cart.removeProduct(deleteIndex - 1);
            System.out.println("Product removed from cart.");
            // Display updated cart
            cart.displayCart();
            // Calculate and display updated total price
            System.out.println("Updated total price: $" + cart.getTotalPrice());
        }

        scanner.close();
    }
}