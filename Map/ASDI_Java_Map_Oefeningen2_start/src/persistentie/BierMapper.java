package persistentie;

import domein.Bier;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BierMapper {

    public List<Bier> inlezenBieren(String naamBestand) throws IOException {
        File bestand = new File(naamBestand);
        List<Bier> bieren = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(bestand))) {
            while (reader.ready()) {
                String regel = reader.readLine();
                String[] data = regel.split(" ");
                String naam = data[0];
                String soort = data[1];
                double alcoholGehalte = Double.parseDouble(data[2].replace(",","."));
                double beoordeling = Double.parseDouble(data[3].replace(",","."));
                String brouwerij = data[4];

                Bier bier = new Bier(naam,
                        soort, alcoholGehalte,
                        beoordeling, brouwerij);
                bieren.add(bier);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return bieren;
    }
}