package strategy;

public class GovernmentDiscount extends DiscountStrategy
{
	public String getName() { return "Government"; }

	@Override
	public double getDiscount(int quantity, double price) 
	{
		double discount = 0.1;

		 if (price > 10000 || quantity > 200)
	         discount = 0.2;

		 return discount;
	}
}
