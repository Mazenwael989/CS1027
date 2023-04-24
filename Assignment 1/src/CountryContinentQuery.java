///////////////////////////////////////////////////////////////////
//   Mazen Baioumy, 250924925                                   //
//   mbaioumy@uwo.ca                           					//
//   Assignment 1, CS1027, 2018                                	//
/////////////////////////////////////////////////////////////////


//create class and create private int to allow access by object of same class and create country array and continent
public class CountryContinentQuery {
	
	private String countryName;
	private String continentName;
	private int countryPopulation;
	private int countryArea;
	private int countryCt=0;
	private int continentCt=0;
	private int defualtSize = 30;
	Country[] countryArray = new Country[defualtSize];
	Continent[] continentArray = new Continent[defualtSize];

//A constructor method CountryContinentQuery that 3 parameters creating an instance for the class
public CountryContinentQuery(Country[] countryArray, Continent[] continentArray, int Ct) {
	this.countryArray=countryArray.clone();
	this.continentArray=continentArray.clone();
	this.continentCt = Ct;
	this.countryCt= Ct;
}

//returns a string containing list of all countries in each continent name parameter.
public String getCountriesOnContinent(String continentName) {
		String countriesCont = "";
		String noCounts = "No countries found";
		for (int i=0; i<continentCt; i++) {
			if (continentArray[i].getContinentName().equals(continentName)) {
				countriesCont = countriesCont + String.format("%-5s,", continentArray[i].getCountryName());
			}
		}
		if (countriesCont == "") {
			return noCounts;
		
		}else {
			return countriesCont;	
		}
}

//returns the population of all countries on a continent name parameter.
public String getPopulationOfContinent(String continentName) {
	String countPops = "";
	String noRes = "No result for population are found";
	for(int i=0; i < continentCt; i++) {
		if (continentArray[i].getContinentName().equals(continentName)) {
			int index = 0;
			boolean found = false;
			while (index < countryCt && !found) {
				if(continentArray[i].getCountryName().equals(countryArray[index].getName())) {
					found = true;
					countPops = countPops + String.format("%-5s: %-5d \n", continentArray[i].getCountryName(), countryArray[index].getPopulation());
				
				}else {
					index++;	
				}		
			}
		}
	}
	if (countPops == ""){
		return noRes;
	
	}else {	
		return countPops;
	}
	
	
}

//
public String toString() {
	String toStringString = "";
	String noRes = "No results were found";
	for (int i=0; i<continentCt; i++) {
		for(int x=0; x<continentCt; x++) {
			if(continentArray[i].getCountryName().equals(countryArray[x].getName())) {
				toStringString = toStringString + String.format("Country Name: %-3s, Located in: %-3s, Population: %-3d, Area: %-3d \n" , countryArray[x].getName(), continentArray[i].getContinentName(), countryArray[x].getPopulation(), countryArray[x].getArea());
			}
			
		}
	}
	if (toStringString == "") {
		return noRes;
	
	}else {
		return toStringString;
		
	}


}


}