package warehouse;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Supplier {
	private String code;
	private String name;
	private List<Product> productsSupply = new ArrayList<>();
	
	public Supplier(String code, String name) {
		this.code = code;
		this.name = name;
	}

	public String getCodice(){
	
		return code;
	}

	public String getNome(){
		return name;
	}
	
	public void newSupply(Product product){
		this.productsSupply.add(product);
		product.addProductSupplier(this);
		
	}
	
	public List<Product> supplies(){
		return this.productsSupply.stream()
				.sorted(Comparator.comparing(Product::getDescription))
				.collect(Collectors.toList());
	}
}
