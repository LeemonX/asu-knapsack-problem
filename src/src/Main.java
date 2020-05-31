import org.w3c.dom.ls.LSOutput;

import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter knapsack size(int):");
        int size = sc.nextInt();

        knapsack sack = new knapsack(size);

        System.out.println("Enter item amount(int). Weight and value will be set automatically");
        int itemAmount = sc.nextInt();
        sack.addItems(itemAmount);

        sack.items.sort(Collections.reverseOrder());
        sack.showItems();

        System.out.println("Greedy algorithm result: ");
        sack.greedy(sack.items);

        System.out.println("Please wait, it may take some time if item amount more than 10 <3");
        System.out.println("Brute force result: ");
        sack.makeAllSets(sack.items);

        sack.bruteForce();
        sc.close();
    }
}
