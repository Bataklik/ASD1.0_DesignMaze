package domein;

import persistentie.PersistentieController;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class BierWinkel {

    private final List<Bier> bieren;
    private PersistentieController pc = new PersistentieController();

    public BierWinkel() throws IOException {
        bieren = pc.inlezenBieren("bieren.txt");
    }

    //TODO type Map aanvullen
    public Map<String, Bier> opzettenOverzichtBierPerNaam() {
        return bieren
                .stream().collect(Collectors.toMap(Bier::getNaam, bier -> bier));
    }


    //TODO type Map aanvullen  opzettenAantalBierenPerSoort
    public Map<String, Long> opzettenAantalBierenPerSoort() {
        return bieren.stream()
                .collect(Collectors.groupingBy(Bier::getSoort,
                        Collectors.counting()));
    }

    public Map<String, List<Bier>> opzettenOverzichtBierenPerSoort() {
        return bieren.stream()
                .collect(Collectors.groupingBy(Bier::getSoort)
                );
    }

}
