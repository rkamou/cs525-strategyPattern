package strategy;

public class EducationalDiscount extends DiscountStrategy
{
	public String getName() { return "Educational"; }
	
	@Override
	public double getDiscount(int quantity, double unitPrice) 
	{
		return 0.5;
	}
}
