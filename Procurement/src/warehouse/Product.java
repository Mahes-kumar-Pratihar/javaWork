package warehouse;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Product {
	private String code;
	private String description;
	private int quantity;
    private List<Supplier> suppliersOfProduct = new ArrayList<>();
    private List<Order> ordered = new ArrayList<>();
    
	public Product(String code, String description) {
		this.code = code;
		this.description = description;
		this.quantity = 0;
	}

	public String getCode() {
		return code;
	}

	public String getDescription() {
		return this.description;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public void decreaseQuantity() {
		this.quantity--;
	}

	public void increaseQuantity(int quantity) {
		this.quantity += quantity;
	}
	public int getQuantity() {
		return this.quantity;
	}

	public void addProductSupplier(Supplier supplier) {
		this.suppliersOfProduct.add(supplier);
	}
	
	public List<Supplier> suppliers() {
		return this.suppliersOfProduct.stream()
				.sorted(Comparator.comparing(Supplier::getNome))
				.collect(Collectors.toList());
	}

	public void addOrders(Order order) {
		this.ordered.add(order);
	}
	public List<Order> getOrdersForProduct(){
		return new ArrayList<Order>(this.ordered);
	}
	
	
	public List<Order> pendingOrders() {
		return this.ordered.stream()
				.filter(o -> !o.delivered())
				.sorted(Comparator.comparing(Order::getQuantity).reversed())
				.collect(Collectors.toList());
	}
}







