package persistentie;

import domein.Bier;
import domein.MyListIterable;

import java.io.File;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.nio.file.Files;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PersistentieController {

   private BierMapper bierMapper;

    public MyListIterable<Bier> leesBieren(File bestandNaam) {
        if (bierMapper == null) {
            bierMapper = new BierMapper();
        }
        return bierMapper.leesBieren(bestandNaam);
    }
     
    //TODO stap 3, maak de methode generiek
    public void persisteerObject(Object object, File bestandNaam) {
        try (ObjectOutputStream out = new ObjectOutputStream(Files.newOutputStream(bestandNaam.toPath()))) {
            out.writeObject(object);
        } catch (IOException ex) {
            Logger.getLogger(BierMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
