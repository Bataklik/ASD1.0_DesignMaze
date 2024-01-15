package domein;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.security.SecureRandom;
import java.util.stream.IntStream;

public class FactuurMap {

    private final SecureRandom random = new SecureRandom();
    int aantal = random.nextInt(2, 4); // een getal tussen 2 en 3 wordt gegenereerd
        
    public double[] geefBedragen(String ondernemingsNummer) {
        double[] bedragen = new double[aantal];
        IntStream.range(0, aantal)
                .forEach(i -> {
                    //genereer een getal tussen 0 en 1000 [0, 1000[
                	double bedrag = random.nextDouble(1000);
                    
                    //afronden tot 2 cijfers na de komma
                    BigDecimal bd = new BigDecimal(bedrag); 
                    bd = bd.setScale(2, RoundingMode.CEILING);
                    bedrag = bd.doubleValue();
                    
                    bedragen[i] = bedrag;
                    });     
        return bedragen;
    }
}
