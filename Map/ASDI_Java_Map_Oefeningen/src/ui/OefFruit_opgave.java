package ui;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class CollectionOperaties {

    // methode verwijderOpLetter
    // -------------------------
    public static void verwijderOpLetter(List<String> list, char p) {
        list.removeIf(f -> f.startsWith(String.valueOf(p)));
    }

    // methode verwijderSequence
    // -------------------------
    public static void verwijderSequence(List<String> list, String kiwi) {
        list.removeIf(f -> f.contains("kiwi"));
    }

    // uitbreiding opgave Fruit addOrdered
    // -------------------------------------
}

public class OefFruit_opgave {

    public static void main(String args[]) {
        String[][] kist = { { "appel", "peer", "citroen", "kiwi", "perzik" },
                { "banaan", "mango", "citroen", "kiwi", "zespri", "pruim" },
                { "peche", "lichi", "kriek", "kers", "papaya" } };

        List<String> list = Arrays.stream(kist)
                .flatMap(Arrays::stream)
                .collect(Collectors.toCollection(ArrayList::new));
        String[] mand = list.stream()
                .distinct()
                .toArray(String[]::new);

        // Toon de inhoud van de array "kist"
        // ----------------------------------
        System.out.println(list);
        System.out.println(Arrays.toString(mand));

        // Voeg de verschillende kisten samen in een ArrayList list.
        // --------------------------------------------------------

        CollectionOperaties.verwijderOpLetter(list, 'p');
        System.out.println("na verwijder letter ('p') :  " + list + "\n");

        CollectionOperaties.verwijderSequence(list, "kiwi");
        System.out.println("na verwijder sequence (kiwi) : " + list + "\n");

        // Plaats het resultaat terug in een array mand en sorteer die oplopend.
        // ---------------------------------------------------------------------
        mand = list.stream()
                .sorted()
                .toArray(String[]::new);

        // Toon de inhoud van de array "mand"
        // ----------------------------------
        System.out.println(Arrays.toString(mand));

    }
}
