import java.util.Scanner;


public class BevShopDriverApp 
{
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);


		BevShop bevShop = new BevShop();//create instance 

		//output from program
		System.out.println("The current order in process can have at most " + bevShop.getMaxOrderForAlcohol() + " alcoholic beverages.");
		System.out.println("The minimum age to order alcohol drink is " + bevShop.getMinAgeForAlcohol());

		while (true) {
			System.out.println("\nWould you please start a new order? (y/n): ");
			String response = scanner.nextLine();
			if (response.equalsIgnoreCase("n")) break;

			System.out.println("Start please a new order:");
			System.out.println("Your Total Order for now is 0.0");

			System.out.print("Would you please enter your name: ");
			String name = scanner.nextLine();
			System.out.print("Would you please enter your age: ");
			int age = scanner.nextInt();
			scanner.nextLine(); //next line

			Customer newCustomer = new Customer(name, age); //customer instance
			bevShop.startNewOrder(9, Day.MONDAY, name, age);

			if (age >= bevShop.getMinAgeForAlcohol()) {
				System.out.println("Your age is above " + bevShop.getMinAgeForAlcohol() + " and you are eligible to order alcohol.");
			} else {
				System.out.println("you cannot drink");
			}

		
			for (int i = 1; i <= bevShop.getMaxOrderForAlcohol(); i++) {
				if (bevShop.isEligibleForMore()) {
					System.out.println("Would you please add an alcohol drink (y/n): ");
					response = scanner.nextLine();
					if (response.equalsIgnoreCase("y")) {
						System.out.print("Enter the alcohol drink name: ");
						String alcoholName = scanner.nextLine();
						System.out.print("Enter the alcohol size (SMALL, MEDIUM, LARGE): ");
						String sizeString = scanner.nextLine();
						Size alcoholSize = Size.valueOf(sizeString.toUpperCase());//uppercase the size
						bevShop.processAlcoholOrder(alcoholName, alcoholSize);
						System.out.println("The current order of drinks is " + bevShop.getCurrentOrder().getTotalItems());
						System.out.println("The Total Price on the Order: " + bevShop.totalOrderPrice(bevShop.getCurrentOrder().getOrderNo()));//gets the total order
					} else {
						break;
					}
					
				}
			}

			// Coffee order
			System.out.println("Would you please add a COFFEE to your order (y/n): ");
			response = scanner.nextLine();
			if (response.equalsIgnoreCase("y")) {
				System.out.print("Enter coffee name: ");
				String coffeeName = scanner.nextLine();
				System.out.print("Enter coffee size (SMALL, MEDIUM, LARGE): ");
				String coffeeSizeString = scanner.nextLine();
				Size coffeeSize = Size.valueOf(coffeeSizeString.toUpperCase());
				System.out.print("Extra shot? (y/n): ");
			    boolean extraShot = scanner.nextLine().equalsIgnoreCase("y");
			    
			    System.out.print("Extra syrup? (y/n): ");
			    boolean extraSyrup = scanner.nextLine().equalsIgnoreCase("y");
			    
				bevShop.processCoffeeOrder(coffeeName, coffeeSize, extraShot, extraSyrup);
				System.out.println("Total items on your order is " + bevShop.getCurrentOrder().getTotalItems());
				System.out.println("The Total Price on the Order: " + bevShop.totalOrderPrice(bevShop.getCurrentOrder().getOrderNo()));
			}

			// smoothie order
			System.out.println("Would you please add a SMOOTHIE to your order (y/n): ");
			response = scanner.nextLine();
			if (response.equalsIgnoreCase("y")) {
				System.out.print("Enter smoothie name: ");
				String smoothieName = scanner.nextLine();
				System.out.print("Enter smoothie size (SMALL, MEDIUM, LARGE): ");
				String smoothieSizeString = scanner.nextLine();
				Size smoothieSize = Size.valueOf(smoothieSizeString.toUpperCase());
				System.out.print("Enter the number of fruits: ");
				int numOfFruits = scanner.nextInt();
				scanner.nextLine(); 
				System.out.print("Add protein? (y/n): ");
				boolean addProtein = scanner.nextLine().equalsIgnoreCase("y");
				scanner.nextLine(); // Consume newline

				if (bevShop.isMaxFruit(numOfFruits)) {
					System.out.println("You reached a Maximum.");
				} else {
					bevShop.processSmoothieOrder(smoothieName, smoothieSize, numOfFruits, addProtein);
					System.out.println("Total Price on the Order: " + bevShop.totalOrderPrice(bevShop.getCurrentOrder().getOrderNo()));
				}
			}

			System.out.println("#------------------------------------#");
			System.out.println("Total price on the second Order: " + bevShop.totalOrderPrice(bevShop.getOrderAtIndex(1).getOrderNo()));
			System.out.println("Total amount for all Orders: " + bevShop.totalMonthlySale());
		}

		scanner.close();
		System.out.println("Thank you for using BevShop!");
	}
}





