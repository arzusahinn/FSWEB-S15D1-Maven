package org.example.models;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Grocery {

    public static List<String> groceryList = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void startGrocery() {
        boolean quit = false;
        while (!quit) {
            System.out.println("\n0: Uygulamayı durdur");
            System.out.println("1: Eleman ekle");
            System.out.println("2: Eleman çıkar");
            System.out.print("Seçiminizi giriniz: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Boş satırı tüket

            switch (choice) {
                case 0:
                    quit = true;
                    System.out.println("Uygulama durduruluyor.");
                    break;
                case 1:
                    System.out.print("Eklenmesini istediğiniz elemanları giriniz: ");
                    addItems(scanner.nextLine());
                    printSorted();
                    break;
                case 2:
                    System.out.print("Çıkarılmasını istediğiniz elemanları giriniz: ");
                    removeItems(scanner.nextLine());
                    printSorted();
                    break;
                default:
                    System.out.println("Geçersiz seçim.");
            }
        }
    }

    public static void addItems(String input) {
        List<String> itemsToAdd = Arrays.stream(input.split(","))
                .map(String::trim)
                .collect(Collectors.toList());

        for (String item : itemsToAdd) {
            if (!groceryList.contains(item)) {
                groceryList.add(item);
            } else {
                System.out.println(item + " zaten listede mevcut.");
            }
        }
        Collections.sort(groceryList);
    }

    public static void removeItems(String input) {
        List<String> itemsToRemove = Arrays.stream(input.split(","))
                .map(String::trim)
                .collect(Collectors.toList());

        for (String item : itemsToRemove) {
            if (groceryList.contains(item)) {
                groceryList.remove(item);
            } else {
                System.out.println(item + " listede bulunamadı.");
            }
        }
        Collections.sort(groceryList);
    }

    public static boolean checkItemIsInList(String product) {
        return groceryList.contains(product);
    }

    public static void printSorted() {
        Collections.sort(groceryList);
        System.out.println("Sıralanmış Liste: " + groceryList);
    }
}