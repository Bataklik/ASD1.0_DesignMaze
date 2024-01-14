package main;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

//Gegeven:

abstract class Dier {
}

interface Huisdier {
}

class Hond extends Dier implements Huisdier {
}

class Kat extends Dier implements Huisdier {
}

class Leeuw extends Dier {
}

//Gevraagd:
//schrijf een klasse die een set van Kat, Hond of Huisdier kan bevatten
class VerzamelingHuisdier<E extends Huisdier>
//------
{
    //attribuut "huisdieren" = set van Kat, Hond of Huisdier
    private Set<E> huisdieren = new HashSet<>();
    //--------------------------------------------------------------------------

    //getHuisdieren
    public Set<E> getHuisdieren() {
        return Collections.unmodifiableSet(huisdieren);
    }
    //-------------------

    //methode add: een dier toevoegen in de set
    public void add(E dier){
        huisdieren.add(dier);
    }
    //------------------------------------------------------------
}

class Tools {
    //Methode bevatHuisdier met twee argumenten: een huisdier en een set van Kat, Hond of Huisdier.
    //Geeft true terug indien het huisdier in de set voorkomt, anders false.
//    public <E extends Huisdier> boolean bevatHuisdier(E dier, Collection<E> dieren) {
//        return dieren.contains(dier);
//    }
    //Schrijf de static methode bevatHuisdier d.m.v. wildcards
    public static boolean bevatHuisdier(Huisdier dier, Collection<? extends Huisdier> dieren){
        return dieren.contains(dier);
    }
    //---------------------------------------------------------------------------------------
    //schrijf de static methode bevatHuisdier2 d.m.v. generieke methode
    public static <E extends Huisdier> boolean bevatHuisdier2(Huisdier huisdier, Set<E> huisdierSet){
        return huisdierSet.contains(huisdier);
    }
    //---------------------------------------------------------------------------------------

    //Schrijf de static methode geefAantal. 1 argument: Een set van Kat, Dier, Huisdier of Object.
    public static <T> int geefAantal(Set<T> dieren){
        return dieren.size();
    }
    //Aantal elementen van de set wordt teruggegeven.
    //---------------------------------------------------------------------------------------
}

public class Generieke_klasse_opgave {

    public static void main(String args[]) {
        Kat kat = new Kat();
        Hond hond = new Hond();
        Huisdier huisdier = new Hond();

        VerzamelingHuisdier<Kat> katten = new VerzamelingHuisdier<>();
        katten.add(kat);
        VerzamelingHuisdier<Hond> honden = new VerzamelingHuisdier<>();

        VerzamelingHuisdier<Huisdier> huisdieren = new VerzamelingHuisdier<>();
        huisdieren.add(huisdier);

        boolean komtVoor = Tools.bevatHuisdier(kat, katten.getHuisdieren());
        System.out.printf("correct = true;  %s%n", komtVoor);
        komtVoor = Tools.bevatHuisdier(hond, honden.getHuisdieren());
        System.out.printf("correct = false;  %s%n", komtVoor);
        komtVoor = Tools.bevatHuisdier(huisdier, huisdieren.getHuisdieren());
        System.out.printf("correct = true;  %s%n", komtVoor);
        //compileerfout: komtVoor = Tools.bevatHuisdier(kat, new HashSet<Dier>());

        komtVoor = Tools.bevatHuisdier2(kat, katten.getHuisdieren());
        System.out.printf("correct = true;  %s%n", komtVoor);
        komtVoor = Tools.bevatHuisdier2(hond, honden.getHuisdieren());
        System.out.printf("correct = false;  %s%n", komtVoor);
        komtVoor = Tools.bevatHuisdier2(huisdier, huisdieren.getHuisdieren());
        System.out.printf("correct = true;  %s%n", komtVoor);

        int aantalKatten = Tools.geefAantal(katten.getHuisdieren());
        int aantalHuisdieren = Tools.geefAantal(huisdieren.getHuisdieren());

        Set<Dier> dieren = Set.of(new Leeuw(), new Hond());
        int aantalDieren = Tools.geefAantal(dieren);

        int aantalObjecten = Tools.geefAantal(new HashSet<Object>());

        System.out.printf("correct = 1;  %d%ncorrect = 1;  %d%ncorrect = 2;  %d%ncorrect = 0;  %d%n", aantalKatten,
                aantalHuisdieren, aantalDieren, aantalObjecten);
    }

}


