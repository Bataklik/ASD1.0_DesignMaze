package domein;

import java.util.Arrays;

public class Rekening {

    private String rekeningnummer;

    public Rekening(String rekeningnummer) throws Exception {
        setRekeningnummer(rekeningnummer);
    }

    private void setRekeningnummer(String rekeningnummer) throws Exception {
        if (!isGeenRekeningnummer(rekeningnummer))
            throw new IllegalArgumentException("Invalide rekeningnummer");
        this.rekeningnummer = rekeningnummer;
    }

    public String getRekeningnummer() {
        return rekeningnummer;
    }

    private boolean isGeenRekeningnummer(String rekeningnummer) throws Exception {
        String[] rekeningArray = rekeningnummer.split("-");
        if (rekeningArray.length != 3) throw new IllegalArgumentException("Volledige rekening slechte formaat");
        if (rekeningArray[0].length() != 3) throw new IllegalArgumentException("Eerste deel van rekeningnummer moet drie lang zijn");
        if (rekeningArray[1].length() != 7) throw new IllegalArgumentException("Tweede deel van rekeningnummer moet zeven lang zijn");
        if (rekeningArray[2].length() != 2) throw new IllegalArgumentException("Derde deel van rekeningnummer moet twee lang zijn");
        long rekeningBerekening = Long.parseLong(rekeningArray[0] + rekeningArray[1]);
        long rekeningLaatste = Long.parseLong(rekeningArray[2]);
        return rekeningBerekening % 97 == rekeningLaatste;
    }
}