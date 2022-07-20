package application;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.enums.OrderStatus;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) throws ParseException {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        System.out.println("Enter client data:");
        System.out.print("Name: ");
        String clientName = sc.nextLine();
        System.out.print("Email: ");
        String clientEmail = sc.nextLine();
        System.out.print("Birth date (DD/MM/YYYY): ");
        Date clientBirthDate = sdf.parse(sc.next());
        System.out.println("Enter order data:");
        System.out.print("Status: ");
        String orderStatus = sc.next();
        System.out.print("How many items to this order? ");
        int n = sc.nextInt();

        Client client = new Client(clientName,clientEmail,clientBirthDate);
        Date date = new Date();
        OrderStatus status = OrderStatus.valueOf(orderStatus);

        Order order = new Order(date, status, client);

        for (int i=1;i<=n;i++){
            System.out.println("Enter #"+i+" data:");
            System.out.print("Product name: ");
            sc.nextLine();
            String productName = sc.nextLine();
            System.out.print("Product price: ");
            double productPrice = sc.nextDouble();
            System.out.print("Quantity: ");
            int productQuantity = sc.nextInt();

            OrderItem item = new OrderItem(productQuantity,productPrice,new Product(productName,productPrice));
            order.addItem(item);
        }

        System.out.println(order);

    }
}
