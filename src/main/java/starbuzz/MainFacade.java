package starbuzz;

public class MainFacade {
    public static void main(String[] args) {
        CoffeeMachineFacade coffeeMachineFacade = new CoffeeMachineFacade();
        coffeeMachineFacade.makeHouseBlendWithMilkAndWhip(CoffeeSize.SMALL);
        coffeeMachineFacade.makeDarkRoastWithSoyAndMocha(CoffeeSize.LARGE);
        coffeeMachineFacade.makeEspressoWithMochaSoyAndWhip(CoffeeSize.MEDIUM);
    }
}