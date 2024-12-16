
public class Alcohol extends Beverage
{
	private boolean isWeekend;
	private double weekendCost = 0.60 ;
	
	public Alcohol(String bevName, Size size, boolean isWeekend)
	{
		 super(bevName, Type.ALCOHOL, size);
		 this.isWeekend=isWeekend;
	}
	public Alcohol(String bevName, Size size)
	{
		 super(bevName, Type.ALCOHOL, size);
	
	}
	
	public boolean isWeekend() {
        return isWeekend;
    }
	  @Override
	    public double calcPrice() {
	        double price = addSizePrice(); 
	        if (isWeekend) {
	            price += weekendCost; 
	        }
	        return price;
	    }
	  @Override
		 public String toString() {

			
				return getbevName() + "," + getSize() + " ,"+ isWeekend()+" ," + calcPrice();
		 }
	  public boolean equals(Object anotherBev)
		{
			Alcohol alcohol = (Alcohol)anotherBev;
			return super.equals(anotherBev) && this.isWeekend == alcohol.isWeekend;
		}
	
}
