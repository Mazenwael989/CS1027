///////////////////////////////////////////////////////////////////
//   Mazen Baioumy, 250924925                                   ///
//   mbaioumy@uwo.ca                           					///
//   Assignment 1, CS1027, 2018                                	///
///////////////////////////////////////////////////////////////////


//Create country class
public class Country {
	
	String name;
	int population;
	int area;

//constructor method country, which uses name of country, with population and area
public Country(String name, int population, int area) {
	this.name = name;
	this.population = population;
	this.area = area;
	
	
}
//getter method to get the name of a country
public String getName() {
	return name;
}
//getter method to get the population of country
public int getPopulation() {
	return population;
}
//getter method to get the area of country
public int getArea() {
	return area;
}
//getter method for the population density of a country
public double getPopulationDensity() {
	double popDensity = ((double)population)/area;
	return popDensity;
}
//Setter method to set the population of a country
public void setPopulation(int newPopulation) {
	this.population =  newPopulation;
}
//Setter method to set area of a certain country
public void setArea(int newArea) {
	this.area = newArea;
}
// a tostring to return a string containing the values of an instance of class
public String toString() {
String FirstToString= String.format("The country's name is: %-20s \n", this.getName()) +
String.format("The country's population is: %-10d \n", this.getPopulation()) +
String.format("The country's area is: %-10d \n" ,this.getArea()) +
String.format("The country's population density is: %.2f \n", this.getPopulationDensity());
return FirstToString;
}
}