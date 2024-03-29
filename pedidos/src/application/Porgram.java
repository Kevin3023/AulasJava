package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.enums.OrderStatus;

public class Porgram {

	public static void main(String[] args) throws ParseException {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		
		System.out.println("Enter cliente data: ");
		System.out.print("Name: ");
		String name = sc.nextLine();
		
		System.out.print("Email: ");
		String email = sc.nextLine();
		
		System.out.print("Birth date (DD/MM/YYYY): ");
		Date BirthDate = sdf.parse(sc.next());
		
		Client client = new Client(name, email, BirthDate);
		
		
		
		System.out.println("Enter order data: ");
		System.out.print("Status: ");
		String status = sc.next();
		
		Order order = new Order(client, new Date(), OrderStatus.valueOf(status));
		
		System.out.print("How many items to this order? ");
		int quantidadeItens = sc.nextInt();
		
		for(int i = 1; i<= quantidadeItens; i++) {
			System.out.println("Enter #" + i + " item data:");
			System.out.print("Product name: ");
			String productName = sc.next();
			System.out.print("Product price: ");
			Double productPrice = sc.nextDouble();
			System.out.print("Quantity: ");
			int quantity = sc.nextInt();
			
			Product product = new Product(productName, productPrice);
			OrderItem orderItem = new OrderItem(quantity, productPrice, product);
			
			order.addItem(orderItem);
		}
		
		System.out.println(order);
		
		
		sc.close();
	}

}
