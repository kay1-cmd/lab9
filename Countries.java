/* 
    **
 * This program reads data about countries and returns a report of the countries with 
 * the highest density and life expectancy.
 * Section 200
 * Created April 6, 2022
 * @author Nia Jordan
 */
import java.util.Scanner;
import java.util.ArrayList;
import java.io.*;

public class Countries 
{
	public static void main(String[] args)throws IOException 
	{
		//Scanner and file instances
		File userFile = new File("CountriesData.csv");
		Scanner infile = new Scanner(userFile);
		Scanner kbd = new Scanner(System.in);
		
		//variables
		String str;
		int highDIndex = 0;
		int highLIndex = 0;
		
		
		//ArrayList Instances
		ArrayList<String> name = new ArrayList<String>(193);
		ArrayList<String> population = new ArrayList<String>(193);
		ArrayList<String> density = new ArrayList<String>(193);
		ArrayList<String> lifeExp = new ArrayList<String>(193);
		
		
		
		infile.nextLine();
		
		//Read data from the file, tokenize the string, and insert tokens into respective array.
		
		while(infile.hasNextLine()) 
		{
			
			str = infile.nextLine();
			String[] tokens = str.split("[,]");			
			
			
			
			
			name.add(tokens[0]);
			population.add(tokens[2]);
			density.add(tokens[3]);
			lifeExp.add(tokens[5]);
			
			

		
			
		}
		
		
				
		//For loops discern the highest density and highest life expectancy. 
		for(int i = 0; i < density.size(); i++)
		{
			
			
			double testInt = Double.parseDouble(density.get(i));
			double currentHigh = Double.parseDouble(density.get(highDIndex));
			
			
			if(testInt > currentHigh)
			{
				highDIndex = i;
				
			}
			
			
			
		}
		
		
		for(int i = 0; i < lifeExp.size(); i++)
		{
			
			double testInt = Double.parseDouble(lifeExp.get(i));
			double currentHigh = Double.parseDouble(lifeExp.get(highLIndex));
				
				
			if(testInt > currentHigh)
			{
					highLIndex = i;
					
			}
			
		} 
				
		infile.close();
		
		
		//Display a report of the information gathered.
		System.out.printf("The country with the highest density is %S. "
				+ "It has a population of %S million people, with a density of %S people per square kilometer.\n\n", name.get(highDIndex), population.get(highDIndex), density.get(highDIndex));
		
		System.out.printf("The country with the highest life expectancy is %S. "
				+ "It has a population of %S million people, with a life expectancy of %S years. ", 
				name.get(highLIndex), population.get(highLIndex), lifeExp.get(highLIndex)); 
		kbd.close();
		
		
		
	}
}

