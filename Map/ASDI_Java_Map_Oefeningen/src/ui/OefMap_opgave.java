package ui;

import java.util.*;

class Auteur {

    private String naam, voornaam;

    public Auteur(String naam, String voornaam) {
        setNaam(naam);
        setVoornaam(voornaam);
    }

    public String getNaam() {
        return naam;
    }

    public String getVoornaam() {
        return voornaam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public void setVoornaam(String voornaam) {
        this.voornaam = voornaam;
    }

    @Override
    public String toString() {
        return String.format("%s %s", naam, voornaam);
    }
}

public class OefMap_opgave {

    public OefMap_opgave() {

        // we zullen een hashmap gebruiken waarbij auteursid de sleutel is en
        // de waarde is naam en voornaam van Auteur.
        //Cre�er de lege hashMap "auteurs"; de sleutel is van type Integer, de waarde van type Auteur
        Map<Integer, Auteur> auteurs = new HashMap<>();
        //----------------------------------------------------------------------------------

        //Voeg toe aan de hashmap: auteursID = 9876, naam = Gosling, voornaam = James
        //Voeg toe aan de hashmap: auteursID = 5648, naam = Chapman, voornaam = Steve
        auteurs.put(9876, new Auteur("Gosling", "James"));
        auteurs.put(5648, new Auteur("Chapman", "Steve"));
        auteurs.put(1233, new Auteur("Doe", "John"));

        //-------------------------------------------------------------------------------

        //Wijzig de voornaam van Chapman: John ipv Steve4
        String teZoeknNaam = "Chapman";
        String teVeranderenVoornaam = "John";
        for (Map.Entry<Integer, Auteur> ingang : auteurs.entrySet()) {
            if (ingang.getValue().getNaam() == teZoeknNaam) {
                ingang.getValue().setNaam(teVeranderenVoornaam);
                break;
            }
        }
        //----------------------------------------------

        //Komt de auteursID 1234 voor in de hashmap
        //-----------------------------------------
        Integer teZoekenKey = 1234;
        if (auteurs.containsKey(teZoekenKey)) {
            System.out.println("--- Zoek auteur: ");
            System.out.println("auteursID 1234 komt voor\n");
        } else {
            System.out.println("--- Zoek auteur: ");
            System.out.println("auteursID 1234 komt niet voor\n");
        }

        //Toon de naam en voornaam van auteursID 5648
        //-------------------------------------------

        Auteur auteur = auteurs.get(5648);
        if (auteur != null) {
            System.out.println("--- Zoek auteur: ");
            System.out.println(auteur);
        }

        toonAlleAuteurs(auteurs);

        //Alle auteursID's worden in stijgende volgorde weergegeven.
        //  1) de hashMap kopiëren naar een treeMap (= 1 instructie)
        //  2) roep de methode toonAlleSleutels op.
        toonAlleSleutels(auteurs);
        //---------------------------------------------------------------

    }

    public void toonAlleSleutels(Map<Integer, Auteur> map) {
        System.out.println("--- toonAlleSleutels");
        //Alle sleutels van de map worden op het scherm weergegeven.
        // Stap 1: Kopiëren naar een TreeMap voor gesorteerde sleutels
        TreeMap<Integer, Auteur> gesorteerdeMap = new TreeMap<>(map);

        for (Integer sleutel : gesorteerdeMap.keySet()) {
            System.out.println("AuteursID: " + sleutel);
        }
        //---------------------------------------------------------------

        System.out.println();
    }

    public void toonAlleAuteurs(Map<Integer, Auteur> map) {
        System.out.println("--- toonAlleAuteurs");
        /*Alle gegevens van de map worden op het scherm weergegeven.
		Per lijn wordt een auteursnr, naam en voornaam weergegeven.*/
        map.forEach((key, value) -> System.out.printf("%d, %S, %s%n", key, value.getNaam(), value
                .getVoornaam()));
        //---------------------------------------------------------------

        System.out.println();
    }

    public static void main(String args[]) {
        new OefMap_opgave();
    }
}
