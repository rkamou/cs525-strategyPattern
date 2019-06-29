/**
 * 
 */
package strategy;

/**
 * @author 610151
 *
 */
class Charitable extends DiscountStrategy {

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "Charitable";
	}

	@Override
	public double getDiscount(int quantity, double unitPrice) { 
		Double basePrice = quantity*unitPrice;
		Double ret = 0.0;
		
		// TODO Auto-generated method stub
		if (0 < basePrice && basePrice <= 1000) {
			if (quantity < 2000)
				ret = 0.9;
		}
		if (1000 < basePrice && basePrice <= 8500) {
			if (quantity < 2000)
				ret = 0.8;
		}
		if (8500 < basePrice && basePrice <= 50000) {
			if (quantity < 2000)
				ret = 0.7;
		}
		if (50000 < basePrice && basePrice <= 100000) {
			if (quantity < 2000)
				ret = 0.5;
		}
		if (basePrice > 100000) {
			ret = 0.0;
		}

		if (quantity > 2000)
			ret = 0.0;

		return ret;
	}

}
