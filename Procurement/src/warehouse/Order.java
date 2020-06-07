package warehouse;

public class Order {

	private Product prod;
	private int quantity;
	private Supplier supp;
    private String ORDn;
    private boolean deliveryState;
    
	public Order(Product prod, int quantity, Supplier supp, Integer orderNumber) {
		this.prod = prod;
		this.quantity = quantity;
		this.supp = supp;
		this.ORDn = "ORD"+orderNumber;
		this.deliveryState = false;
		prod.addOrders(this);
	}

	public String getCode() {
		return ORDn;
	}

	public boolean delivered() {
		return this.deliveryState;
	}
	
	

	public Product getProd() {
		return prod;
	}

	public int getQuantity() {
		return quantity;
	}

	public String getProductCode() {
		return this.getProd().getCode();
	}
	public Supplier getSupp() {
		return supp;
	}
	public String getSupplierName() {
		return this.getSupp().getNome();
	}

	public void setDelivered() throws MultipleDelivery {
		if(this.deliveryState == true)
			throw new MultipleDelivery();
		this.deliveryState = true;
		
		this.prod.increaseQuantity(this.quantity);
	}

	public String toString() {
		return "Order " + this.ORDn + " for " + this.quantity + " of " + this.prod.getCode() + " : " 
				+ this.prod.getDescription() + " from " + this.supp.getNome();
	}
}
