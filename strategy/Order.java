package strategy;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Order {
	private double price;
	private int quantity;
	private List<DiscountStrategy> discountStrategies = new ArrayList<DiscountStrategy>();

	public Order(double unitPrice, int quantity) {
		this.price = unitPrice;
		this.quantity = quantity;
	}

	public double getPrice() {
		return price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void addDiscountStrategy(DiscountStrategy discountStrategy) {
		this.discountStrategies.add(discountStrategy);
	}
	
	public void clearDiscountStrategies() {
		this.discountStrategies.clear();
	}

	public double getDiscountedPrice() {
		double discountedPrice = 0; // Calculated price after discount is applied
		//double discount = 0; // Discount that apply for this order. None by default. 
		List<Double> discount = discountStrategies.stream().map(z->z.getDiscount(quantity, price)).collect(Collectors.toList());
		discountedPrice = quantity * price;
		for (Double d : discount) {
			discountedPrice = discountedPrice* (1 - d);
		}
		return discountedPrice;
	}

	public String getDiscountType() { 
		return discountStrategies.stream().map(z->z.getName()).reduce((a,b)->a+" + "+b).orElse("No discount");
	}

	public String show() {
		StringBuilder descr = new StringBuilder();

		descr.append("Quantity: ").append(quantity).append(", Unit price: ").append(price).append(" = ")
				.append(quantity * price).append(", with discount: ").append(getDiscountType()).append(":\t")
				.append(String.format("%.0f", getDiscountedPrice())).append("\n");

		return descr.toString();

	}
}
