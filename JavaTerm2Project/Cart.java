package JavaTerm2Project;

import javax.swing.*;
import java.util.Scanner;

public class Cart {
    Scanner input = new Scanner(System.in);

    private int customerId;
    private int nProducts;
    private Product[] arr = new Product[nProducts];
    private static int counter = 0;
    private static int orderId;

    public Cart(int customerId, int nProducts) {
        this.customerId = customerId;
        this.nProducts = nProducts;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public int get_nProducts() {
        return nProducts;
    }

    public void set_nProducts(int nProducts) {
        this.nProducts = nProducts;
    }

    public Product[] getArr() {
        return arr;
    }

    public void setArr(Product[] arr) {
        this.arr = arr;
    }

    public void addProduct(Product prod) {
        arr[counter] = prod;
        counter++;
    }

    public void removeProduct(Product prod) {
    for(int i = 0; i < nProducts; i++) {
        if (arr[i] == prod)
            arr[i] = null;
    }
    }
    public float calculatePrice() {
        float sum = 0;
        for (int i = 0; i < nProducts; i++)
            sum+=arr[i].price;
        return sum;
    }
    public int placeOrder() {
        int choice = 0;
        while(choice != 1 && choice != 2)
            choice = Integer.parseInt(JOptionPane.showInputDialog("Your total is $" + calculatePrice() + "." + " Would you like to place the order? 1- Yes   2- No"));

        return choice;
    }
}
