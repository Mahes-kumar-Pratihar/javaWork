import java.util.List;

import warehouse.*;

public class Example {

	public static void main(String[] args) throws InvalidSupplier, MultipleDelivery {
		Warehouse m = new Warehouse();

		Product banane = m.newProduct("BNN", "Banane");
		banane.setQuantity(33);
		Product kiwi = m.newProduct("KWI", "Kiwi");
		kiwi.setQuantity(44);

		Supplier chiquita = m.newSupplier("CQT", "Chiquita");
		Supplier delmonte = m.newSupplier("DMT", "Del Monte");

		chiquita.newSupply(banane);
		chiquita.newSupply(kiwi);

		delmonte.newSupply(banane);

		Order ord1 = m.issueOrder(banane, 67, chiquita);
		Order ord2 = m.issueOrder(kiwi, 100, chiquita);
		Order ord3 = m.issueOrder(banane, 120, delmonte);
		
		System.out.println("Order's Codes");
		System.out.println(ord1.getCode());
		System.out.println(ord2.getCode());
		System.out.println();
		
		System.out.println("Order's toString");
		System.out.println(ord1.toString());
		System.out.println(ord2.toString());
		
		System.out.println();
		System.out.println("Pending orders in Warehouse");
		
		List<Order> o = m.pendingOrders();
		o.stream().forEach(System.out::println);
		System.out.println();
		System.out.println();
		
		List<Order> p = banane.pendingOrders();
		p.stream().forEach(System.out::println);
		ord1.setDelivered();

		System.out.println(ord2.toString());

	}
}
