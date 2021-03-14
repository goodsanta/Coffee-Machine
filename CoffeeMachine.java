package machine;

import java.util.Scanner;

public class CoffeeMachine {

    static boolean flag = false;
    static int[] machine = new int[]{400, 540, 120, 9, 550};
    static State state = State.MAIN_MENU;

    enum State {
        MAIN_MENU,
        COFFEE_MENU,
    }

    public static void buyCoffee(int[] machine, String typeOfCoffee) {
        switch (typeOfCoffee) {
            case "1": {
                if (machine[0] < 250) {
                    System.out.println("Sorry, not enough water!\n");
                } else if (machine[2] < 16) {
                    System.out.println("Sorry, not enough coffee beans!\n");
                } else if (machine[3] < 1) {
                    System.out.println("Sorry, not enough cups\n");
                } else {
                    System.out.println("I have enough resources, making you a coffee!\n");
                    machine[0] -= 250;
                    machine[2] -= 16;
                    machine[3] -= 1;
                    machine[4] += 4;
                }
                state = State.MAIN_MENU;
                break;
            }
            case "2": {
                if (machine[0] < 350) {
                    System.out.println("Sorry, not enough water!\n");
                } else if (machine[1] < 75) {
                    System.out.println("Sorry, not enough milk\n");
                } else if (machine[2] < 20) {
                    System.out.println("Sorry, not enough coffee beans!\n");
                } else if (machine[3] < 1) {
                    System.out.println("Sorry, not enough cups\n");
                } else {
                    System.out.println("I have enough resources, making you a coffee!\n");
                    machine[0] -= 350;
                    machine[1] -= 75;
                    machine[2] -= 20;
                    machine[3] -= 1;
                    machine[4] += 7;
                }
                state = State.MAIN_MENU;
                break;
            }
            case "3": {
                if (machine[0] < 200) {
                    System.out.println("Sorry, not enough water!\n");
                } else if (machine[1] < 100) {
                    System.out.println("Sorry, not enough milk\n");
                } else if (machine[2] < 12) {
                    System.out.println("Sorry, not enough coffee beans!\n");
                } else if (machine[3] < 1) {
                    System.out.println("Sorry, not enough cups\n");
                } else {
                    System.out.println("I have enough resources, making you a coffee!\n");
                    machine[0] -= 200;
                    machine[1] -= 100;
                    machine[2] -= 12;
                    machine[3] -= 1;
                    machine[4] += 6;
                }
                state = State.MAIN_MENU;
                break;
            }
            case "back":
                state = State.MAIN_MENU;
                break;
        }
    }

    public static void fillUp(int[] machine) {
        Scanner scanner = new Scanner(System.in);
        int amount;

        System.out.println("Write how many ml of water do you want to add:");
        amount = scanner.nextInt();
        machine[0] += amount;

        System.out.println("Write how many ml of milk do you want to add:");
        amount = scanner.nextInt();
        machine[1] += amount;

        System.out.println("Write how many grams of coffee beans do you want to add:");
        amount = scanner.nextInt();
        machine[2] += amount;

        System.out.println("Write how many disposable cups of coffee do you want to add:");
        amount = scanner.nextInt();
        machine[3] += amount;
    }

    public static void takeMoney(int[] machine) {
        System.out.printf("I gave you $%d%n%n", machine[4]);
        machine[4] = 0;
    }

    public static void showRemaining(int[] machine) {
        System.out.println("The coffee machine has:");
        System.out.printf("%d of water%n", machine[0]);
        System.out.printf("%d of milk%n", machine[1]);
        System.out.printf("%d of coffee beans%n", machine[2]);
        System.out.printf("%d of disposable cups%n", machine[3]);
        System.out.printf("$%d of money%n%n", machine[4]);
    }

    public static void process(String action) {
        System.out.println();

        if (state == State.MAIN_MENU) {
            switch (action) {
                case "buy":
                    System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:");
                    state = State.COFFEE_MENU;
                    break;
                case "fill":
                    fillUp(machine);
                    break;
                case "take":
                    takeMoney(machine);
                    break;
                case "remaining":
                    showRemaining(machine);
                    break;
                case "exit":
                    flag = true;
                    break;
            }
        }

        if (state == State.COFFEE_MENU) {
            buyCoffee(machine, action);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (!flag) {
            if (state == State.MAIN_MENU) {
                System.out.println("Write action (buy, fill, take, remaining, exit):");
            }
            String action = scanner.next();
            process(action);
        }
    }
}
