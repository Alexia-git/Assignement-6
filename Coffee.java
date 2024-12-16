
public class Coffee extends Beverage  
{
	private boolean extraShot;
    private boolean extraSyrup;
   
    public Coffee(String bevName, Size size, boolean extraShot, boolean extraSyrup)
    {
    	super(bevName,Type.COFFEE, size);
    	 this.extraShot = extraShot;
         this.extraSyrup = extraSyrup;
    }
    public boolean getExtraShot() {
        return extraShot;
    }

    public boolean getExtraSyrup() {
        return extraSyrup;
    }
    @Override

    public double calcPrice() {
        double price = addSizePrice();
        if (extraShot) {
            price += 0.50;  
        }
        if (extraSyrup) {
            price += 0.50;  
        }
        return price;
    }
    @Override
    public String toString() {
    	return  
				getbevName() + " " +
                getSize()+ " "+ extraShot +
                " " + extraSyrup+ " "+calcPrice();            
	} 
    @Override
    public boolean equals(Object anotherBev) {
        if (this == anotherBev) return true;
        if (anotherBev == null || getClass() != anotherBev.getClass()) return false;
        if (!super.equals(anotherBev)) return false;  
        Coffee coffee = (Coffee) anotherBev;
        return extraShot == coffee.extraShot && extraSyrup == coffee.extraSyrup;
    }
}
