package machine;
import java.util.Scanner;

public class CoffeeMachine {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        CoffeeMachine coffeeMachine = new CoffeeMachine();

        label:
        while (true) {
            System.out.println("Choose type of action: buy/fill/take/clean/remaining/exit:");
            String choice = scanner.nextLine();
            switch (choice) {
                case "buy":
                    if (coffeeMachine.useCounter >= 10){
                        System.out.println("I need cleaning!");
                    }
                    else {
                        coffeeMachine.buy();
                    }
                    break;
                case "fill":
                    coffeeMachine.fill();
                    break;
                case "take":
                    coffeeMachine.take();
                    break;
                case "remaining":
                    coffeeMachine.remaining();
                    break;
                case "clean":
                    coffeeMachine.clean();
                    break;
                case "exit":
                    break label;
            }
        }
    }

    int water = 400;
    int milk = 540;
    int coffee = 120;
    int cups = 9;
    int money = 550;
    int useCounter = 0;

    void remaining(){
        System.out.println("The coffee machine has: ");
        System.out.println(water + " ml of water");
        System.out.println(milk + " ml of milk");
        System.out.println(coffee + " g of coffee beans");
        System.out.println(cups + " disposable cups");
        System.out.println("$" + money + " of money");
    }

    void buy(){
        Coffee espresso = new Coffee(250, 0, 16, 4);
        Coffee latte = new Coffee(350, 75, 20, 7);
        Coffee cappuccino = new Coffee(200, 100, 12, 6);

        Scanner scanner = new Scanner(System.in);
        System.out.println("Select coffee type: 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu: ");
        String coffeeType = scanner.nextLine();
        switch (coffeeType) {
            case "1" -> {
                if (water < espresso.water) {
                    System.out.println("Sorry, not enough water!");
                } else if (coffee < espresso.coffee) {
                    System.out.println("Sorry, not enough coffee beans!");
                } else if (cups < 1) {
                    System.out.println("Sorry, not enough cups!");
                } else {
                    System.out.println("I have enough resources, making you a coffee!");
                    water -= 250;
                    coffee -= 16;
                    cups--;
                    money += 4;
                    useCounter++;
                }
            }
            case "2" -> {
                if (water < latte.water) {
                    System.out.println("Sorry, not enough water!");
                } else if (coffee < latte.coffee) {
                    System.out.println("Sorry, not enough coffee beans!");
                } else if (cups < 1) {
                    System.out.println("Sorry, not enough cups!");
                } else if (milk < latte.milk) {
                    System.out.println("Sorry, not enough milk!");
                } else {
                    System.out.println("I have enough resources, making you a coffee!");
                    water -= 350;
                    milk -= 75;
                    coffee -= 20;
                    cups--;
                    money += 7;
                    useCounter++;
                }
            }
            case "3" -> {
                if (water < cappuccino.water) {
                    System.out.println("Sorry, not enough water!");
                } else if (coffee < cappuccino.coffee) {
                    System.out.println("Sorry, not enough coffee beans!");
                } else if (cups < 1) {
                    System.out.println("Sorry, not enough cups!");
                } else if (milk < cappuccino.milk) {
                    System.out.println("Sorry, not enough milk!");
                } else {
                    System.out.println("I have enough resources, making you a coffee!");
                    water -= 200;
                    milk -= 100;
                    coffee -= 12;
                    cups--;
                    money += 6;
                    useCounter++;
                }
            }
            case "back" -> {
            }
        }
    }

    void fill (){
        Scanner scanner = new Scanner(System.in);
        System.out.println("How many ml of water you want to add?");
        int addWater = scanner.nextInt();
        water += addWater;
        System.out.println("How many ml of milk you want to add?");
        int addMilk = scanner.nextInt();
        milk += addMilk;
        System.out.println("How many grams of coffee beans you want to add?");
        int addCoffee = scanner.nextInt();
        coffee += addCoffee;
        System.out.println("How many disposable cups you want to add?");
        int addCups = scanner.nextInt();
        cups += addCups;
    }

    void take(){
        System.out.printf("I gave you $%d\n", money);
        money -= money;
    }

    void clean (){
        useCounter = 0;
        System.out.println("I Have been cleaned!");
    }

}