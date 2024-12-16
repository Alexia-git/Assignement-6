
public class Customer 
{
	String name;
	int age;

	public Customer(String name, int age) {
		this.name = name;
		this.age = age;
	}
	public Customer(Customer c) //copy of the constructor
	{
		this.name = c.name;  
		this.age = c.age;    
	}
	 public int getAge() {
	        return age;
	    }

	  
	    public String getName() {
	        return name;
	    }

	   
	    public void setAge(int age) {
	        this.age = age;
	    }

	    
	    public void setName(String name) {
	        this.name = name;
	    }
	    @Override
	    public String toString() {
	        return  getName()+" "+ getAge();
	        		
	  
	
	    }


}
