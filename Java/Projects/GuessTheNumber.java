package Java.Projects;

import java.util.*;

public class GuessTheNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int value = 1 + (int) (100 * Math.random());

        int trial = 7;
        boolean isGuessed = false;

        while (!isGuessed) {
            System.out.print("Guess my number between 1 to 100 in " + trial + " attempts : ");
            int num = sc.nextInt();
            if (value > num) {
                System.out.println("My number is greater than yours " + num + ", guess higher.");
            } else if (value < num) {
                System.out.println("My number is lesser than yours " + num + ", guess lower.");
            } else {
                System.out.println("Wow! Guess matched - " + num + ". Well Done");
                isGuessed = true;
            }
            trial--;
            if (trial == 0 && !isGuessed) {
                System.out.println("oho! Trial Expired.");
                System.out.print("Do you want to go on in this round (yes/no): ");
                String keep = sc.next();
                if (keep.equalsIgnoreCase("yes")) {
                    trial = 7;
                    System.out.println("Another 7 attempts restore.");
                } else {
                    System.out.println("Game Over! The correct number was: " + value);
                    break;
                }
            }
        }
        sc.close();
    }
}
