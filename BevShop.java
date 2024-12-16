import java.util.ArrayList;

public class BevShop implements BevShopInterface {
	private int numOfAlcohol;
	Order currentOrder;
	private ArrayList<Order> orders;

	public BevShop() //default constructor
	{
		orders = new ArrayList<>();
	}
	public boolean isValidTime(int time)
	{
		return time >= 8 && time <= 23;
	}
	public int getMaxNumOfFruits()
	{
		return MAX_FRUIT;
	}
	public int getMinAgeForAlcohol()
	{
		return MIN_AGE_FOR_ALCOHOL;
	}
	@Override
	public boolean isMaxFruit(int numOfFruits) {
		return numOfFruits > getMaxNumOfFruits();
	}
	@Override
	public int getMaxOrderForAlcohol() {

		return MAX_ORDER_FOR_ALCOHOL;
	}
	@Override
	public boolean isEligibleForMore() {
		if (numOfAlcohol < MAX_ORDER_FOR_ALCOHOL) 
		{ 
			return true;
		}
		return false;
	}
	@Override
	public int getNumOfAlcoholDrink() {

		return numOfAlcohol;
	}
	@Override
	public boolean isValidAge(int age) {
		if (age > MIN_AGE_FOR_ALCOHOL)
		{ 
			return true; 
		}
		return false;
	}
	@Override
    public void startNewOrder(int time, Day day, String customerName, int customerAge) {
        if (isValidTime(time)) {
        	Order other = new Order(time, day, new Customer(customerName, customerAge));
    		orders.add(other);
    		currentOrder = other;

        }
    }
	 @Override
	    public void processCoffeeOrder(String bevName, Size size, boolean extraShot, boolean extraSyrup) {
		 currentOrder.addNewBeverage(bevName, size, extraShot, extraSyrup);
	    }

	 @Override
	    public void processAlcoholOrder(String bevName, Size size) {
		 if (isEligibleForMore()) 
		 { 
	            Alcohol alcohol = new Alcohol(bevName, size);
	            getCurrentOrder().addNewBeverage(bevName, size);
	            numOfAlcohol++;  // Increase the count
	        } else {
	            System.out.println("Maximum alcohol");
	        }
	    }
	    
	
	 @Override
	    public void processSmoothieOrder(String bevName, Size size, int numOfFruits, boolean addProtein) {
		 currentOrder.addNewBeverage(bevName, size, numOfFruits, addProtein);
	    }
	@Override
	public int findOrder(int orderNo) {
		for (int i = 0; i < orders.size(); i++) {// goes through the order 
			if (orders.get(i).getOrderNo() == orderNo) {
				return i;
			}
		}
		return -1;
	}
	@Override
	public double totalOrderPrice(int orderNo)
	{
		double total = 0;
		for(Order order: orders)
		{
			if(order.getOrderNo() == orderNo)
				total = order.calcOrderTotal();
		}
		return total;
	}
	@Override
	public double totalMonthlySale()
	{
		double totalSale = 0;
		for (Order order : orders) {
			totalSale += order.calcOrderTotal();
		}
		return totalSale;		
	}
	@Override
	public int totalNumOfMonthlyOrders()
	{
		return orders.size();
	}
	@Override
	public Order getCurrentOrder()
	{
		return orders.get(0);
	}
	@Override
    public Order getOrderAtIndex(int index) {
        if (index >= 0 && index < orders.size()) {
            return orders.get(index);  // Return order at the specified index
        }
        return null;  
    }
	@Override
	public void sortOrders() {
		for (int i = 0; i < orders.size(); i++) {
			int min = i;
			for (int j = i + 1; j < orders.size(); j++) {
				if (orders.get(j).getOrderNo() < orders.get(min).getOrderNo()) {
					min = j;
				}
			}

			Order change = orders.get(min);
			orders.set(min, orders.get(i));
			orders.set(i, change);
		}
	}
	public String toString()
	{
		return orders.toString() + " \n Total Sale: " + totalMonthlySale();
	}






}
