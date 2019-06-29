package strategy;

public class Application
{
    public static void main(String[] args)
    {
        Order order = new Order(120, 220);

    	EducationalDiscount educationalDiscount = new EducationalDiscount();
    	GovernmentDiscount governmentDiscount = new GovernmentDiscount();
    	Charitable charitable = new Charitable();
         
    	// No discount first
        System.out.println(order.show());
        
    	order.addDiscountStrategy(educationalDiscount);
    	System.out.println(order.show());
        
    	order.clearDiscountStrategies();
    	order.addDiscountStrategy(governmentDiscount);
    	System.out.println(order.show());
    	
    	order.clearDiscountStrategies();
    	order.addDiscountStrategy(charitable);
    	System.out.println(order.show());
    	
    	System.out.println();
    	System.out.println("Another Order for extra Credit:");
    	Order order2 = new Order(700, 300);
    	order2.addDiscountStrategy(educationalDiscount);
    	order2.addDiscountStrategy(governmentDiscount);
    	order2.addDiscountStrategy(charitable);
    	System.out.println(order2.show());
    	
    	System.out.println();
    }
    
 }
