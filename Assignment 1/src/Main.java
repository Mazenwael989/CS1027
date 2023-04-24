import java.io.*;
import java.util.*;

public class Main {

public static void main(String[] args)
{
String countryName;
String continentName;
int countryPopulation;
int countryArea;
int countryCt=0;
int continentCt=0;
final int DEFAULT_SIZE = 30;
StringTokenizer tokenizer;
Country[] countryArray = new Country[DEFAULT_SIZE];
Continent[] continentArray = new Continent[DEFAULT_SIZE];


InStringFile countryReader=new InStringFile("country.txt");
// Read country.txt line by line and creat a country object for each line
System.out.format("%n");
System.out.format("country.txt%n");
System.out.format("-----------%n");
// Use do-while statement to setup country object
do {
   String countryLine = countryReader.read();
   tokenizer=new StringTokenizer(countryLine);
   countryName=tokenizer.nextToken();
   countryPopulation=Integer.parseInt(tokenizer.nextToken());
   countryArea=Integer.parseInt(tokenizer.nextToken());
   // Make a country object and copy into the array countryArray
   countryArray[countryCt]=new Country(countryName,countryPopulation,countryArea);
   System.out.format("%3d %-72s%n",countryCt,countryArray[countryCt].toString());
   countryCt++;
   } while (!countryReader.endOfFile());
System.out.format("%d country datasets read%n%n",countryCt);
countryReader.close();

InStringFile continentReader=new InStringFile("continent.txt");
// Read continent.txt line by line and creat a continent object for each line
System.out.format("%n");
System.out.format("continent.txt%n");
System.out.format("-------------%n");
// Use do-while statement to setup continent object
do {
   String continentLine = continentReader.read();
   tokenizer=new StringTokenizer(continentLine);
   countryName=tokenizer.nextToken();
   continentName=tokenizer.nextToken();
   // Make a contenient object and copy it into the array continentArray
   continentArray[continentCt]=new Continent(countryName,continentName);
   System.out.format("%3d %-72s%n",continentCt,continentArray[continentCt].toString());
   continentCt++;
   } while (!continentReader.endOfFile());
System.out.format("%d continent datasets read%n",continentCt);
continentReader.close();
System.out.format("%n");

CountryContinentQuery countryContinentQuery 
      = new CountryContinentQuery(countryArray,continentArray,countryCt);

System.out.format("\n%s\n",countryContinentQuery.toString());

System.out.format("Query 1: %s\n",
       countryContinentQuery.getCountriesOnContinent("Asia"));
System.out.format("Query 2: %s\n",
       countryContinentQuery.getCountriesOnContinent("North-America"));
System.out.format("Query 3: %s\n",
       countryContinentQuery.getCountriesOnContinent("Africa"));

System.out.format("Query 4: %s",
       countryContinentQuery.getPopulationOfContinent("South-America"));
System.out.format("Query 5: %s",
       countryContinentQuery.getPopulationOfContinent("Europe"));
System.out.format("Query 6: %s\n",
       countryContinentQuery.getPopulationOfContinent("Africa"));

Country country=countryArray[6]; // wonder what country that is?
System.out.format("Query 7: Population Density of %s is %s\n",
                   country.getName(),country.getPopulationDensity());
country=countryArray[4]; // wonder what country that is?
System.out.format("Query 8: Population Density of %s is %s\n",
                   country.getName(),country.getPopulationDensity());
country=countryArray[1]; // wonder what country that is?
System.out.format("Query 9: Population Density of %s is %s\n",
                   country.getName(),country.getPopulationDensity());
}
}
