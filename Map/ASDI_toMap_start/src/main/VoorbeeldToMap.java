package main;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.function.Function;
import java.util.stream.Collectors;

import domein.Sporter;

public class VoorbeeldToMap {

	public static void main(String[] args)
	{
		new VoorbeeldToMap().voorbeeld();
	}
	
	public void voorbeeld()
	{
		List<Sporter> sportersLijst = 
			List.of(new Sporter(789, "Keters", "Jan"),
					new Sporter(123, "Blondee","Ann"), 
					new Sporter(456, "Keters", "Ann"),
					new Sporter(147, "Vandriessche","Els"));
		
		System.out.printf("vertrekpunt lijst%n%s%n%n", sportersLijst);
		//van lijst naar map (per lidnummer - lidnummer is uniek)
		Map<Integer, Sporter> mapPerLidnummer = sportersLijst.stream().
				collect(Collectors.toMap(
						Sporter::getLidNr, Function.identity()));
		
		System.out.printf(String.format("per lidnummer%n%s%n%n", 
				geefMapAlsString(mapPerLidnummer)));
		

		try
		{
			//Poging van lijst naar map (per voornaam, waarde 1 sporter)
			Map<String, Sporter> mapPerVoornaam = sportersLijst.stream().
					collect(Collectors.toMap(
							Sporter::getVoornaam, Function.identity()));
			System.out.println(Function.identity());
			System.out.println();
		}catch(IllegalStateException e)
		{
			System.out.printf("poging per voornaam, waarde 1 sporter%n%s%n%n",e.getMessage());
		}
		
		//van lijst naar map (per voornaam, waarde 1 Sporter). 
		Map<String, Sporter> mapPerVoornaam = sportersLijst.stream().
				collect(Collectors.toMap(
						Sporter::getVoornaam, Function.identity(), 
						(voornaam1, voornaam2) -> voornaam1));
		
		System.out.printf(String.format("per voornaam, waarde 1 sporter%n%s%n%n", 
				geefMapAlsString(mapPerVoornaam)));
		
		//van lijst naar map (per naam, waarde 1 Sporter), gesorteerd per sleutel
		Map<String, Sporter> mapPerNaam = sportersLijst.stream().
				collect(Collectors.toMap(
						Sporter::getNaam, Function.identity(), 
						(naam1, naam2) -> naam1, TreeMap::new));
		
		System.out.printf(String.format("per naam, waarde 1 sporter, gesorteerd op sleutel%n%s%n%n", 
				geefMapAlsString(mapPerNaam)));
		
		//van lijst naar map (per lidnummer - lidnummer is uniek), gesorteerd per sleutel
		Map<Integer, Sporter> mapPerLidnummer2 = sportersLijst.stream().
				collect(Collectors.toMap(
						Sporter::getLidNr, Function.identity(),
						(key1, key2) -> key1, TreeMap::new));
		
		System.out.printf(String.format("per lidnummer, gesorteerd op sleutel%n%s%n%n", 
				geefMapAlsString(mapPerLidnummer2)));
	}
	
	public <K,V> String geefMapAlsString(Map<K,V> eenMap)
	{
		return eenMap.entrySet().stream().
			map(entry -> String.format("sleutel: %-12s waarde: %-15s", entry.getKey(), entry.getValue())).
					collect(Collectors.joining("\n"));
	}
}