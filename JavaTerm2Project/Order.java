package JavaTerm2Project;

import javax.swing.*;
public class Order {
    private int customerId;
    private static int orderId = 0;
    private int nProducts;
    private Product[] prod = new Product[nProducts];
    private float totalPrice;
    public Order(int customerId, Product[] prod) {
        this.customerId = customerId;
        this.prod = prod;
    }
    public static int getOrderId() {
        return orderId;
}
    public void printOrderInfo(Cart cart) {
        orderId++;
        // Create JFrame
        JFrame frame = new JFrame("Order");

        // Create JPanel for order details
        JPanel panel = new JPanel();

        JTextArea orderDetails = new JTextArea(10, 30);
        orderDetails.setEditable(false); // makes it non-editable

        String order = "";
        for (int i = 0; i < cart.get_nProducts(); i++) {
            order =  order + cart.getArr()[i].name + " - $" + cart.getArr()[i].price + '\n';
        }

        String orderID = "Order ID: " + orderId + '\n';
        String customerID = "Customer ID: " + cart.getCustomerId() + '\n';
        String products = "Products: \n";
        String totalPrice = "Total Price: $" + cart.calculatePrice() + '\n';           // Order details
        
        orderDetails.setText(orderID + customerID + products + order + totalPrice + "Thanks for shopping!");        // Set order details text
        
        panel.add(orderDetails);        // Add order details text area to the panel
        
        frame.getContentPane().add(panel);          // Add panel to the frame
        ImageIcon image = new ImageIcon("C:\\Users\\HP\\Downloads\\icon-Copy-2.jpg");
        frame.setIconImage(image.getImage());
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);                 // Set frame properties
    }
}
