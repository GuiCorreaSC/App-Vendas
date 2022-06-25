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

public class Program {

	public static void main(String[] args) throws ParseException {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy");

		System.out.print("Enter cliente data:\r\n" + "Name:");
		String name = sc.nextLine();

		System.out.print("Email: ");
		String email = sc.next();

		System.out.print("Birth date (DD/MM/YYYY): ");
		Date birthDate = sdf.parse(sc.next());

		Client client = new Client(name, email, birthDate);

		System.out.print("Enter order data:\r\n" + "Status: ");
		OrderStatus status = OrderStatus.valueOf(sc.next());

		Order order = new Order(new Date(), status, client);

		System.out.println("How many items to this order? ");
		int items = sc.nextInt();

		for (int i = 1; i <= items; i++) {
			System.out.println("Enter #" + i + " item data: \n" + "Product name: ");
			sc.nextLine();
			String nam_produto = sc.nextLine();
			System.out.println("Product price: ");
			Double price = sc.nextDouble();
			Product product = new Product(nam_produto, price);

			System.out.println("Quantity: ");
			int qtd_produto = sc.nextInt();
			OrderItem orderitem = new OrderItem(qtd_produto, price, product);
			order.additem(orderitem);
		}
		System.out.println();
		System.out.println("ORDER SUMARY: ");
		System.out.println(order);

		sc.close();
	}

}