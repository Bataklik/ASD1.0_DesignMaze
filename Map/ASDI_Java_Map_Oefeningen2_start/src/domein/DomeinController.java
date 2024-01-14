package domein;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class DomeinController {

    private final BierWinkel bierWinkel;

    public DomeinController() throws IOException {
        bierWinkel = new BierWinkel();
    }

    public String opzettenBierPerNaam() {
        // TODO
        StringBuilder result = new StringBuilder();
        Map<String, Bier> bierOpNaam = bierWinkel
                .opzettenOverzichtBierPerNaam();
        for (Map.Entry<String, Bier> bierEntry : bierOpNaam.entrySet()) {
            result.append(String.format("%s = naam = %s, soort = %s, brouwerij = %s, alcoholgehalte = %.2f, beoordeling = %.1f", bierEntry.getKey(),
                    bierEntry.getValue().getNaam(),
                    bierEntry.getValue().getSoort(),
                    bierEntry.getValue().getBrouwerij(),
                    bierEntry.getValue().getAlcoholgehalte(),
                    bierEntry.getValue().getBeoordeling()));
            result.append("\n");
        }
        return result.toString();
    }

    public String opzettenAantalBierenPerSoort() {
        StringBuilder result = new StringBuilder();

        Map<String, Long> aantalBierenPerSoort = bierWinkel
                .opzettenAantalBierenPerSoort();
        for (Map.Entry<String, Long> entry : aantalBierenPerSoort.entrySet()) {
            result.append(String.format("%s, %d", entry.getKey(), entry.getValue()));
            result.append("\n");
        }

        return result.toString();

    }

    public String opzettenOverzichtBierenPerSoort() {
        //TODO
        String result = "";
        Map<String, List<Bier>> bierenPerSoort = bierWinkel.opzettenOverzichtBierenPerSoort();

        return null;
    }


    //TODO na hoofdstuk generics 
    //--> generieke oplossing "overzichtToString" methode
    //


}
