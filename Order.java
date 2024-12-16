import java.util.ArrayList;
import java.util.Random;


public class Order implements OrderInterface, Comparable<Order> 
{
	private int orderNo;
	private int orderTime;
	private Day orderDay;
	private Customer customer;
	private ArrayList <Beverage> bev; 

	public Order(int orderTime, Day orderDay, Customer cust) {
		this.orderDay = orderDay;
		this.orderTime = orderTime;
		this.customer = cust;
		this.orderNo = generateOrder(); 
		bev = new ArrayList<>();
	}

	public int generateOrder() {
		Random random = new Random();
		return 10000 + random.nextInt(80000);  
	}
	public int getOrderNo() {
		return orderNo;
	}
	public int getOrderTime() {
		return orderTime;
	}
	public Day getOrderDay() {
		return orderDay;
	}
	public Customer getCustomer() {
		return customer;
	}
	@Override
	public boolean isWeekend() {
		if (orderDay == Day.SATURDAY || orderDay == Day.SUNDAY) { 
			return true;
		}
		return false;
	}
	@Override
	public Beverage getBeverage(int itemNo) {
		 
		return bev.get(itemNo);
	}
	 public int getTotalItems() {
	        return bev.size();
	    }
	 @Override
		public void addNewBeverage(String bevName, Size size, boolean extraShot, boolean extraSyrup) {
		 bev.add(new Coffee(bevName, size, extraShot, extraSyrup));

		}
	 @Override //alchol
		public void addNewBeverage(String bevName, Size size) {
			boolean isWeekend = false;
			if (orderDay == Day.SATURDAY || orderDay == Day.SUNDAY) { 
				isWeekend = true; 
			}
			bev.add(new Alcohol(bevName, size));

		}
	 @Override
		public void addNewBeverage(String bevName, Size size, int numOfFruits, boolean addProtein) {
		 bev.add(new Smoothie(bevName, size, numOfFruits, addProtein));

		}
	 @Override
	    public double calcOrderTotal() {
	        double total = 0;
	        for (Beverage bev : bev) {
	            total += bev.calcPrice();
	        }
	        return total;
	    }
	  @Override
	    public int findNumOfBeveType(Type type) {
	        int count = 0;
	        for (Beverage bev : bev) {
	            if (bev.getType() == type) {
	                count++;
	            }
	        }
	        return count;
	    }
	  public String toString() {
			return orderDay.toString() + "," + orderTime + customer.toString() + "," + "The Order Number: " + orderNo
					+ bev.toString() + calcOrderTotal(); 
	  }
	  @Override
		public int compareTo(Order order) {
			if (orderNo > order.orderNo) { 
				return 1; 
			} else if (orderNo < order.orderNo) { 
				return -1; 
			} else {
				return 0;
			}
		} 
	  

}
