package warehouse;

import java.util.*;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.function.Predicate;

public class Warehouse {

	private Map<String, Product> products = new HashMap<>();
	private Map<String, Supplier> suppliers = new HashMap<>();
	private Map<String, Order> orders = new HashMap<>();
	
	private int orderNumber = 1;

	public Product newProduct(String code, String description) {
		Product product = new Product(code, description);
		this.products.put(code, product);
		return product;
	}

	public Collection<Product> products() {
		return this.products.values();
	}

	public Product findProduct(String code) {
		return this.products.get(code);
	}

	public Supplier newSupplier(String code, String name) {
	    Supplier s = new Supplier(code, name);
	    this.suppliers.put(code, s);
		return s;
	}

	public Supplier findSupplier(String code) {
		return this.suppliers.get(code);
	}

	public Order issueOrder(Product prod, int quantity, Supplier supp) throws InvalidSupplier {
		if(!supp.supplies().contains(prod))
			throw new InvalidSupplier();
		
		Order o = new Order(prod, quantity, supp, orderNumber++);
		this.orders.put(o.getCode(), o);
		
		return o;
	}

	public Order findOrder(String code) {
		return this.orders.get(code);
	}

	public List<Order> pendingOrders() {
		return this.orders.values().stream()
				.filter(x -> !x.delivered())
				.sorted(Comparator.comparing(Order::getProductCode))
				.collect(Collectors.toList());
	}

	public Map<String, List<Order>> ordersByProduct() {
		
		Map<String, List<Order>> o = new HashMap<>();
		
		for(Product p : this.products.values()) {
			o.put(p.getCode(), p.getOrdersForProduct());
		}
		return o;
	}

	public Map<String, Long> orderNBySupplier() {
		return this.orders.values().stream()
				.filter(o -> o.delivered())
				.collect(Collectors.groupingBy( x -> x.getSupp().getNome(), TreeMap::new,
						Collectors.counting()));
	}

	public List<String> countDeliveredByProduct() {
		Map<String, Long> p = this.orders.values().stream()
				             .filter(Order::delivered)
				             .collect(Collectors.groupingBy(Order::getProductCode, Collectors.counting()));
	    Map<Long, String> m = new TreeMap<>();
	    
	    for(Map.Entry<String, Long> e : p.entrySet()) {
	    	m.put(e.getValue(), e.getKey());
	    }
	    
		//return  m.entrySet().stream()
			//	.map(x -> x.getKey() + x.getValue())
			//	.collect(Collectors.toList());
	    return this.orders.values().stream()
	             .filter(Order::delivered)
	             .collect(Collectors.groupingBy(Order::getProductCode, Collectors.counting()))
	             .entrySet().stream()
	             .sorted(Comparator.comparing(Map.Entry<String, Long>::getValue).reversed())
	             .map(x -> x.getValue()+" "+x.getKey())
	             .collect(Collectors.toList());
	}
}
