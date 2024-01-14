package domein;

import persistentie.PersistentieController;

import java.io.File;

public class DomeinController {

    private final PersistentieController pc = new PersistentieController();

    public void persisteerBierGegevensAlsObject(String tekstFileNaam, String objectFileNaam) {
        //TODO zie stap3
        File txtFile = new File(tekstFileNaam);
        File datFile = new File(objectFileNaam);
        MyListIterable<Bier> myList = pc.leesBieren(txtFile);
        pc.persisteerObject(myList, datFile);
    }

}
