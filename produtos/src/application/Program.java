package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.ImportedProduct;
import entities.Product;
import entities.UsedProduct;

public class Program {

	public static void main(String[] args) throws ParseException {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Date data = new Date();
		Double custom = 0.0;
		String name = "";
		String nameI = "";
		String nameU = "";
		Double price = 0.0;
		Double priceI = 0.0;
		Double priceU = 0.0;

		System.out.print("Enter the number of products: ");
		int n = sc.nextInt();

		for (int i = 1; i <= n; i++) {
			System.out.println("Enter #" + i + " item data:");
			System.out.print("Common, used or imported (c, u, i)? ");
			char type = sc.next().charAt(0);

			if (type == 'u') {
				System.out.print("Name: ");
				nameU = sc.next();

				System.out.print("Price: ");
				priceU = sc.nextDouble();
				
				System.out.print("Manufacture date (DD/MM/YYYY): ");
				data = sdf.parse(sc.next());
			}

			else if (type == 'i') {
				System.out.print("Name: ");
				nameI = sc.next();

				System.out.print("Price: ");
				priceI = sc.nextDouble();
				
				System.out.print("Customs fee: ");
				custom = sc.nextDouble();

			}

			else {
				System.out.print("Name: ");
				name = sc.next();

				System.out.print("Price: ");
				price = sc.nextDouble();
			}

		}
		Product usado = new UsedProduct(nameU, priceU, data);
		Product importado = new ImportedProduct(nameI, priceI, custom);
		Product produto = new Product(name, price);

		System.out.println("\nPRICE TAGS:");
		System.out.print(importado.priceTag());
		System.out.print(produto.priceTag());
		System.out.print(usado.priceTag());

		sc.close();
	}

}
