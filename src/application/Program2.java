package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.ImportedProduct;
import entities.Product;
import entities.UsedProduct;

public class Program2 {



	public static void main(String[] args) throws ParseException {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy");

		List<Product> produ = new ArrayList<>();
		
		System.out.println("How many items to this order? ");
		int items = sc.nextInt();
		
		for (int i = 1; i <= items; i++) {
			System.out.println("Common, used or imported (c/u/i)? ");
			char cui = sc.next().charAt(0);
		
			System.out.println("Enter #" + i + " item data: \n" + "Product name: ");
			sc.nextLine();
			String nam_produto = sc.nextLine();
			System.out.println("Product price: ");
			Double price = sc.nextDouble();
			
			if (cui == 'u') {
				System.out.println("Manufacture date (DD/MM/YYYY): ");
				Date date = sdf.parse(sc.next());
				produ.add(new UsedProduct(nam_produto, price, date));
				
			}
			else if (cui == 'i') {
				System.out.println("Customs fee: ");
				Double cust = sc.nextDouble();
				produ.add(new ImportedProduct(nam_produto, price, cust));
			}
			else {
				
				produ.add(new Product(nam_produto, price));
			}
		}
		
		System.out.println("PRICE TAG");
		for (Product prod : produ) {
		
		System.out.println(prod.priceTag());
		}

	}

}