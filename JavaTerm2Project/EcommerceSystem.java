package JavaTerm2Project;
import javax.swing.*;
import java.util.Scanner;
public class EcommerceSystem {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        ElectronicProduct smartphone = new ElectronicProduct(1, "smartphone", 599.9f, "Samsung", 1);
        ClothingProduct tShirt = new ClothingProduct(2, "T-Shirt", 19.99f, "Medium", "Cotton");
        BookProduct OOP = new BookProduct(3, "OOP", 39.99f, "O'Reilly","X Publications");   //Test products

        int id;
        String name, address;

        id = Math.abs(Integer.parseInt(JOptionPane.showInputDialog("Welcome to the store! Please enter your ID")));
        name = JOptionPane.showInputDialog("Please enter your name");
        address = JOptionPane.showInputDialog("Please enter your address");

        Customer cust = new Customer(id, name, address);

        int count = Integer.parseInt(JOptionPane.showInputDialog("How many products do you want to add to your cart?"));

        Cart cart = new Cart(id, count);
        cart.set_nProducts(count);
        Product[] products = new Product[count];
        cart.setArr(products);                      // Setting up the cart of products

        for (int i = 0; i < count; i++) {
            int choice = 0;

            while (choice > 3 || choice < 1)
                choice = Integer.parseInt(JOptionPane.showInputDialog("Which product to add?  1- Smartphone   2- T-Shirt   3-OOP"));
                                                                                        // Picking what products to add to cart
            if (choice == 1)
                cart.addProduct(smartphone);
            else if (choice == 2)
                cart.addProduct(tShirt);
            else
                cart.addProduct(OOP);           // Adding the product to cart
        }

        Order order = new Order(id, cart.getArr());         // Setting up the order
        int placeOrder = cart.placeOrder();

        JFrame frame = new JFrame("Thank you");
        JPanel panel = new JPanel();

        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ImageIcon image = new ImageIcon("C:\\Users\\HP\\Downloads\\icon-Copy-2.jpg");
        JTextArea thanks = new JTextArea(10, 30);
        thanks.setEditable(false);
        thanks.setText("Thanks for shopping!");
        panel.add(thanks);
        frame.getContentPane().add(panel);
        frame.setIconImage(image.getImage());           // Text to show in case customer does not order

        if (placeOrder == 1)
            order.printOrderInfo(cart);             // Final receipt of the added products
        else
            frame.setVisible(true);             // Frame properties

    }
}
