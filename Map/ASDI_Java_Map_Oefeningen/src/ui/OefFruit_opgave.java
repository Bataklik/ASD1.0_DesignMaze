package ui;

import java.util.*;

class CollectionOperaties {

    //methode verwijderOpLetter
    public static void verwijderOpLetter(List<String> list, char p) {
        // Iterator gebruiken om door de lijst te itereren
        Iterator<String> iterator = list.iterator();

        // Itereren over de lijst met behulp van een iterator
        while (iterator.hasNext()) {
            String huidigElement = iterator.next();

            // Controleren of het huidige element met de letter 'p' begint
            if (huidigElement.charAt(0) == p) {
                // Verwijder het element
                iterator.remove();
            }
        }
    }


    //-------------------------

    //methode verwijderSequence
    public static void verwijderSequence(List<String> list, String kiwi) {
        // Iterator gebruiken om door de lijst te itereren
        Iterator<String> iterator = list.iterator();

        // Itereren over de lijst met behulp van een iterator
        while (iterator.hasNext()) {
            String huidigFruit = iterator.next();

            // Controleren of het huidige element overeenkomt met "kiwi"
            if (huidigFruit.equals(kiwi)) {
                // Verwijder het element
                iterator.remove();
            }
        }
    }
    //-------------------------

    //uitbreiding opgave Fruit   addOrdered
    //-------------------------------------
}

public class OefFruit_opgave {

    public static void main(String[] args) {
        Random random = new Random();
        String kist[][] = {{"appel", "peer", "citroen", "kiwi", "perzik"},
                {"banaan", "mango", "citroen", "kiwi", "zespri", "pruim"},
                {"peche", "lichi", "kriek", "kers", "papaya"}};

        List<String> list = new ArrayList<>();

        for (String[] k : kist) {
            list.addAll(Arrays.asList(k));
        }

       // String mand[];

        TreeMap<String, Double> fruit = new TreeMap<>();
        list.forEach(el -> {
            System.out.println("--- el");
            System.out.println(el);
            fruit.put(el, null);
        });
        Scanner in = new Scanner(System.in);

        fruit.forEach((k,v) ->{
            double prijs =1 + random.nextDouble() * 19;;
            fruit.replace(k, prijs);
            System.out.println();
        });

        //Toon de inhoud van de array "kist"
        //----------------------------------

        //Voeg de verschillende kisten samen in een ArrayList list.
        //--------------------------------------------------------


        CollectionOperaties.verwijderOpLetter(list, 'p');
        System.out.println("na verwijder letter ('p') :  " + list + "\n");

        CollectionOperaties.verwijderSequence(list, "kiwi");
        System.out.println("na verwijder sequence (kiwi) : " + list + "\n");

        //Plaats het resultaat terug in een array mand en sorteer die oplopend.
        //---------------------------------------------------------------------


        //Toon de inhoud van de array "mand"
        //----------------------------------
        System.out.printf("%10s\t%10s\n", "NAAM", "PRIJS");
        fruit.forEach((k,v)->{
            System.out.printf("%s\t%.2f%n", k,v)  ;
        });

    }
}
