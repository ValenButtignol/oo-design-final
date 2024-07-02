package template.barista;

public class Main {
	public static void main(String[] args) {
 
		CaffeineBeverage tea = new Tea();
		CaffeineBeverage coffee = new Coffee();
		CaffeineBeverage redCoffee = new RedCoffee();
		CaffeineBeverage blackCoffee = new BlackCoffee();
 
		System.out.println("\nMaking tea...");
		tea.prepareRecipe();
 
		System.out.println("\nMaking coffee...");
		coffee.prepareRecipe();

		System.out.println("\nMaking a red coffee");
		redCoffee.prepareRecipe();

		System.out.println("\n Making a black coffee");
		blackCoffee.prepareRecipe();
	}
}