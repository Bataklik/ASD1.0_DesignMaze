package ui;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class OefFruitMap_opgave {

       public static void main(String args[]) {
              String kist[][] = { { "appel", "peer", "citroen", "kiwi", "perzik" },
                            { "banaan", "mango", "citroen", "kiwi", "zespri", "pruim" },
                            { "peche", "lichi", "kriek", "kers", "papaya" } };

              List<String> list = Arrays.stream(kist)
                            .flatMap(Arrays::stream)
                            .sorted()
                            .collect(Collectors.toList());
              String[] mand = list
                            .stream()
                            .filter(f -> !f.startsWith("p"))
                            .toArray(String[]::new);
              System.out.println("--- List ---");
              System.out.println(list);
              System.out.println("--- mand ---");
              System.out.println(Arrays.stream(mand).toList());
              Scanner in = new Scanner(System.in);

              // declaratie + creatie map
              // ------------------------------
              Map<String, Double> fruit = new TreeMap<>();

              /*
               * Berg de fruit list van vorige oefeningen in een boom
               * op zodat dubbels ge�limineerd worden.
               * Er moet ook de mogelijkheid zijn de bijhorende prijs
               * (decimale waarde) bij te houden.
               */
              // ------------------------------------------------------------
              list.stream()
                            .distinct()
                            .forEach(f -> fruit.put(f, 0.0));
              System.out.println("--- fruit ---");
              System.out.println(fruit);
              /*
               * Doorloop de boom in lexicaal oplopende volgorde en vraag
               * telkens de bijhorende prijs, die je mee in de boom opbergt.
               */
              // ------------------------------------------------------------
              fruit.forEach((f, p) -> {
                     System.out.printf("Prijs van %s : ", "VUL IN");
                     // double prijs = in.nextDouble();
                     double prijs = new Random().nextDouble(10) + 1;
                     fruit.put(f, prijs);
              });

              /*
               * Druk vervolgens de volledige lijst in twee
               * kolommen (naam : prijs) in lexicaal oplopende volgorde af
               * op het scherm.
               */
              // ------------------------------------------------------------
              System.out.println("\nFruitlijst met prijzen:");
              fruit.forEach((naam, prijs) -> System.out.printf("%s\t%.2f%n", naam, prijs));
       }
}
