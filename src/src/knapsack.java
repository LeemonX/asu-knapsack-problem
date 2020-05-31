import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class knapsack {
    private List<item> treasures;
    public List<item> items;
    private int size;
    private int Mvalue;

    public knapsack(int size) {
        this.size = size;
    }

    private int totalWeight(List<item> items) {
        int lootWeight = 0;

        for (item i : items) {
            lootWeight += i.getWeight();
        }

        return lootWeight;
    }

    private int totalValue(List<item> items) {
        int lootPrice = 0;

        for (item i : items) {
            lootPrice += i.getValue();
        }

        return lootPrice;
    }

    private void checkSet(List<item> items) {
        if (treasures == null) {
            if (totalWeight(items) <= size) {
                treasures = items;
                Mvalue = totalValue(items);
            }
        } else {
            if (totalWeight(items) <= size && totalValue(items) > Mvalue) {
                treasures = items;
                Mvalue = totalValue(items);
            }
        }
    }

    public void makeAllSets(List<item> items) {
        if (items.size() > 0)
            checkSet(items);
        for (int i = 0; i < items.size(); i++) {
            List<item> newSet = new ArrayList<>(items);
            newSet.remove(i);
            makeAllSets(newSet);
        }
    }

    public void bruteForce() {
        int weight = 0;
        int value = 0;


        for(item i : treasures){
            weight += i.getWeight();
            value += i.getValue();
        }
        printAll(weight, value);
        itemPrint(treasures);
    }


    public void addItems(int amount) {
        Random rand = new Random();
        items = new ArrayList<>();


        for (int i = 0; i < amount; i++) {
            items.add(new item(rand.nextInt(7)+1, rand.nextInt(100)));
        }

    }

    public void showItems() {
        System.out.println("Item list: ");
        itemPrint(items);
    }

    public void greedy(List<item> list){
        int totalWeight = size;

        List<item> taken = new ArrayList<>();
        for (item i: list) {
            if (i.getWeight() <= totalWeight) {
                taken.add(i);
                totalWeight -= i.getWeight();
            }
        }

        int weight= 0;
        int value = 0;
        for (item i : taken) {
            weight += i.getWeight();
            value += i.getValue();
        }

        printAll(weight, value);
        itemPrint(taken);
    }

    public void printAll(int weight, int value){
        System.out.println("Total weight: " + weight + " | Total value:" + value);
    }

    public void itemPrint(List<item> list){
        int counter = 1;
        for(item i : list)
            System.out.print("Item-"+ counter++ + "| weight: " + i.getWeight() + " value:" + i.getValue() + "\n");
        System.out.println("=================================");
    }
}
