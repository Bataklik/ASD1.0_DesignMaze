package persistentie;

import domein.Bier;

import java.io.IOException;
import java.util.List;

public class PersistentieController {

    private BierMapper bierMapper;

    public List<Bier> inlezenBieren(String naamBestand) throws IOException {
        if (bierMapper == null) {
            bierMapper = new BierMapper();
        }
        return bierMapper.inlezenBieren(naamBestand);
    }

}
