///////////////////////////////////////////////////////////////////
//   Mazen Baioumy, 250924925                                   //
//   mbaioumy@uwo.ca                           					//
//   Assignment 1, CS1027, 2018                                	//
/////////////////////////////////////////////////////////////////

//Create continent class that hold information about names of countries in each continent
public class Continent {
	String countryName;
	String continentName;

	
//create a string with country name and continent name
public Continent(String countryName, String continentName) {
	this.countryName = countryName;
	this.continentName = continentName;
}
//the getter methods allow us to access the country and continent name of an object
// create a getter method to get country name
public String getCountryName() {
	return countryName;
}
// create a getter method to get continent name
public String getContinentName() {
	return continentName;
}
// create a setter method to set the country name 
public void setCountryName(String newCountry) {
	this.countryName = newCountry;
}
// create a setter method to set the continent name
public void setContinentName(String newContinent) {
	this.continentName = newContinent;
// the setter methods allows us to set the country and continent names of an object from parameter
}

public String toString() {
String SecondToString = String.format("The name of the country is: %-20s \n", this.getCountryName()) +
String.format("The name of the continent it's in is: %-20s \n" , this.getContinentName());
//string to string returns string containing value of instance os class

return SecondToString;
}
}
