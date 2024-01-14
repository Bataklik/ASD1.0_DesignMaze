package persistentie;

import domein.Bier;
import domein.MyListIterable;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Scanner;
import java.util.stream.Stream;

public class BierMapper {

    public MyListIterable<Bier> leesBieren(File bestandNaam) {
        MyListIterable<Bier> bieren = new MyListIterable<>();
        try (Stream<String> stream = Files.lines(bestandNaam.toPath())) {
            stream.forEach(regel -> {
                Scanner scanner = new Scanner(regel);
                String bierNaam = scanner.next();
                scanner.next();
                double alcohol = scanner.nextDouble();
                bieren.insertAtBack(new Bier(bierNaam, alcohol));
            });
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
            ex.printStackTrace();
        }
        return bieren;
    }

}
