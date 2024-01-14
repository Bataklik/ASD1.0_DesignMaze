package domein;

public class Sporter {

	private int lidNr;
	private String naam;
    private String voornaam;
    
	public Sporter(int lidNr, String naam, String voornaam) {
		setLidNr(lidNr);
		setNaam(naam);
		setVoornaam(voornaam);
	}

	public int getLidNr() {
		return lidNr;
	}

	private void setLidNr(int lidNr) {
		this.lidNr = lidNr;
	}

	public String getNaam() {
		return naam;
	}

	private void setNaam(String naam) {
		this.naam = naam;
	}

	public String getVoornaam() {
		return voornaam;
	}

	private void setVoornaam(String voornaam) {
		this.voornaam = voornaam;
	}
	
	@Override
	public String toString()
	{
		return String.format("%s %s", naam, voornaam);
	}
}
