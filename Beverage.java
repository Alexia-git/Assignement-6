/*
 * Class: CMSC203 
 * Instructor:Farnaz Eivazi
 * Description: (Give a brief description for each Class)
 * Due: MM/DD/YYYY
 * Platform/compiler:
 * I pledge that I have completed the programming  
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here:Alexia Majano
*/

public abstract class Beverage {

	String bevName;
	Type type;
	Size size;
	final double basePrice = 2.0;
	final double sizeUpPrice = 0.5;

	public Beverage(String bevName, Type type, Size size) {
		this.bevName = bevName;
		this.type = type;
		this.size = size;
	}
	public double getBasePrice() {

		return basePrice;
	}
	public Type getType() {

		return type;
	}

	public Size getSize() {

		return size ;

	}
	public String getbevName() {

		return bevName;

	}
	public double addSizePrice() {
		if(this.size == Size.SMALL){
			return basePrice;
		}else if (this.size == Size.MEDIUM)
		{
			return basePrice + 0.5;
		}else if(this.size== Size.LARGE)
			return basePrice + 1;
		return 0;
	}
	public abstract double calcPrice();
	
	 @Override
		public String toString() {
			
			return bevName +" ,"+ size;
			
		}
	 @Override
	    public boolean equals(Object anotherBev) {
	    	 Beverage beverage = (Beverage) anotherBev;
	        if (this == anotherBev) return true;
	        if (anotherBev == null || getClass() != anotherBev.getClass()) return false;
	       
	        if (!bevName.equals(beverage.bevName)) return false;
	        if (!type.equals(beverage.type)) return false;
	        return size.equals(beverage.size);
	    }

}