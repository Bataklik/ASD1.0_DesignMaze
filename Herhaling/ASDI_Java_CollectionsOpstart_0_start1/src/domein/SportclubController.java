package domein;

public class SportclubController {

	private SporterBeheerder sporterBeheerder;

	public SportclubController() {
		sporterBeheerder = new SporterBeheerder();
	}
	
//TODO uncomment OEF GENERICS
//	public String geefSportersPerLidnr() {
//		return sporterBeheerder.geefSportersPerLidnr();
//	}
//
//	public String geefSportersPerAantalReductiebonnen() {
//		return sporterBeheerder.geefSportersPerAantalReductiebonnen();
//	}

	public String geefSporters() {
		throw new UnsupportedOperationException();
	}

	//TODO OEF GENERICS...
}
