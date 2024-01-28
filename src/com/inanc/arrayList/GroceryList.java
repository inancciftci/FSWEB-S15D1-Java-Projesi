package com.inanc.arrayList;
import java.util.ArrayList;
import java.util.Collections;

public class GroceryList {

    private ArrayList<String> items;

    public GroceryList() {
        this.items = new ArrayList<>();
    }

    public void addItems(String items) {
        String[] splitItems = splitItems(items);
        for (String item : splitItems) {
            String trimmedItem = item.trim();
            if (checkItemIsInList(trimmedItem)) {
                System.out.println("girilen item listede mevcut: " + item);
            } else {
                this.items.add(trimmedItem);
                sortItems();
            }
        }
    }

    private static String[] splitItems(String items) {
        String[] splitItems = items.split(",");
        return splitItems;
    }

    public void removeItems(String items) {
        String[] splitItems = splitItems(items);
        for (String item : splitItems) {
            String trimmedItem = item.trim();
            if (!checkItemIsInList(trimmedItem)) {
                System.out.println("Bu item zaten mevcut değil: " + item);
            } else {
                this.items.remove(trimmedItem);
                //sortItems();
            }
        }
    }

    public void printSorted(){
        System.out.println("Mevcut pazar listesi: ");
        for (String item : this.items){
            System.out.println(item);
        }
    }

    public boolean checkItemIsInList(String item) {
        return items.contains(item);
    }

    public void sortItems() {
        Collections.sort(this.items);
    }
}