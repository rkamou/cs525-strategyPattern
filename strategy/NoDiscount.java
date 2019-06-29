package strategy;

public class NoDiscount extends DiscountStrategy
{
	public String getName() { return "No Discount"; }
	
 	@Override
	public double getDiscount(int quantity, double unitPrice) 
	{
		return 0;
	}
}
