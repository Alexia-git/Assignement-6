
public class Smoothie extends Beverage 
{
	private int numOfFruits;
	private boolean addProtein;
	private double addedProtein = 1.50;
	private double addedFruit = 0.50;
	
	public Smoothie(String bevName, Size size, int numOfFruits, boolean addProtein) {
        super(bevName, Type.SMOOTHIE, size);  
        this.numOfFruits = numOfFruits;
        this.addProtein = addProtein;
    }
	 public int getNumOfFruits() {
	        return numOfFruits;
	 }
	    
	    public boolean getAddProtein() {
	        return addProtein;
	    }
	    @Override
	    public double calcPrice() {
	        double price = addSizePrice();
	        price += numOfFruits *addedFruit;   
	        if (addProtein == true) {
	            price += addedProtein; 
	        }
	        return price;
	    }
	    public String toString() {
			 return getbevName() +" "+ getSize() +
		                " " + addProtein +
		                " " + numOfFruits +
		                " " + calcPrice();
		      
			
		}
	    public boolean equals(Object anotherBev) {
			
			Smoothie smoothie = (Smoothie) anotherBev;
			return super.equals(anotherBev) && this.addProtein == smoothie.addProtein && this.numOfFruits == smoothie.numOfFruits;
		}





}
