package domein;

import repository.SporterDao;
import repository.SporterDaoJpa;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class SporterBeheerder {

    private SporterDao sporterDao;
    private Collection<Sporter> sportersLijst;
    private Map sportersPerLidnummer;
    private Map sporterPerAantalReductiebonnen;

    // TODO OEF MAP extra attributen

    public SporterBeheerder() {
        sporterDao = new SporterDaoJpa();
        sportersLijst = sporterDao.findAll();
        // TODO OEF MAP
        maakOverzichten();
    }

    public Collection<Sporter> getSportersLijst() {
        return Collections.unmodifiableCollection(sportersLijst);
    }

    // TODO OEF MAP extra methoden
    public void maakOverzichten() {
        sportersPerLidnummer = sportersLijst.stream()
                .collect(Collectors.toMap(Sporter::getLidNr, Function.identity()));
        sporterPerAantalReductiebonnen = sportersLijst.stream()
                .collect(Collectors.groupingBy(sporter -> (long) sporter.getReductiebonLijst().size(),
                        Collectors.toList()));

    }

    // VRAAG 6
    public Sporter geefEenSporterMetGegevenReductiebon(Reductiebon bon) {
        return sportersLijst.stream().filter(sporter -> sporter.getReductiebonLijst().contains(bon)).findAny()
                .orElse(null);
    }

    // EXTRA vraag1
    public List<Reductiebon> geefAlleReductiebonnenMetKortingsPercentageX(List<Integer> kortingspercentage) {
        return sportersLijst.stream().map(Sporter::getReductiebonLijst).flatMap(Collection::stream)
                .filter(bon -> kortingspercentage.contains(bon.getPercentage())).collect(Collectors.toList());
    }

    // EXTRA vraag2
    public void verwijderAlleSportersMetReductiebonMetPercX(int perc) {
        sportersLijst.removeIf(
                s -> s.getReductiebonLijst().stream().filter(bon -> bon.getPercentage() == perc).count() != 0);
    }

    public String geefSportersPerLidnr() {
        throw new UnsupportedOperationException();
    }

    public String geefSportersPerAantalReductiebonnen() {
        throw new UnsupportedOperationException();
    }

    // OEF GENERICS
    // methode geefAlleSleutelsWaarden

}
