package machine;

import java.util.Arrays;
import java.util.Scanner;

public class CoffeeMachine {
    final static Scanner scanner = new Scanner(System.in);

    public static void printContents(int[] sup) {
        System.out.printf(
                "The coffee machine has:\n" +
                        "%d of water\n" +
                        "%d of milk\n" +
                        "%d of coffee beans\n" +
                        "%d of disposable cups\n" +
                        "%d of money\n\n",
                        sup[0], sup[1], sup[2], sup[3], sup[4]
        );
    }

    public static int[] fill() {
        int water, milk, coffee, cups;
        System.out.println("Write how many ml of water do you want to add:");
        water = scanner.nextInt();
        System.out.println("Write how many ml of milk do you want to add:");
        milk = scanner.nextInt();
        System.out.println("Write how many grams of coffee beans do you want to add:");
        coffee = scanner.nextInt();
        System.out.println("Write how many disposable cups of coffee do you want to add:");
        cups = scanner.nextInt();
        System.out.println();
        return new int[]{water, milk, coffee, cups, 0};
    }

    public static int take(int money) {
        System.out.printf("I gave you $%d\n\n", money);
        return 0;
    }

    public static int[] buy(int[] sup) {
        System.out.println("What do you want to buy?" +
                " 1 - espresso, " +
                "2 - latte, " +
                "3 - cappuccino, " +
                "back - to main menu");
        String option = scanner.nextLine();
        switch (option) {
            case "1":
                return make(sup, new int[]{250, 0, 16, 1, -4});
            case "2":
                return make(sup, new int[]{350, 75, 20, 1, -7});
            case "3":
                return make(sup, new int[]{200, 100, 12, 1, -6});
            case "back":
                return sup;
        }
        return sup;
    }

    public static int[] make(int[] sup, int[] dem) {
        int[] arr = new int[5];
        Arrays.setAll(arr, i -> sup[i] - dem[i]);
        if (enough(arr)) {
            System.out.println("I have enough resources, making you a coffee!\n");
            return arr;
        }
        System.out.println("Sorry, not enough resources!\n");
        return sup;
    }

    public static boolean enough(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] < 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String action;
        int[] sup = new int[] {400, 540, 120, 9, 550};
        while (true) {
            System.out.println("Write action (buy, fill, take, remaining, exit):");
            action = scanner.nextLine().toLowerCase();
            switch (action) {
                case "fill": {
                    int[] arr = fill();
                    Arrays.setAll(sup, i -> sup[i] + arr[i]);
                    break;
                }
                case "take": {
                    sup[4] = take(sup[4]);
                    break;
                }
                case "buy": {
                    int[] arr = buy(sup);
                    Arrays.setAll(sup, i -> sup[i] = arr[i]);
                    break;
                }
                case "remaining": {
                    printContents(sup);
                    break;
                }
                case "exit": {
                    return;
                }
            }
        }
    }
}
