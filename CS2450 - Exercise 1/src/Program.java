import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Program {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		List<Double> numbers = new ArrayList<Double>();
		double max = 0.0;
		double min = 0.0;
		String path = ""; 
		String stringInput;
		Scanner input = new Scanner(System.in);
		Boolean repeat = true;
		
		while(repeat){
			System.out.println("Please enter the filepath of the file\r\nor type in rootDir for default path");
			path = input.nextLine();
			if (path.equalsIgnoreCase("rootdir")){
				path = System.getProperty("user.dir") + "/test.txt";
			}
			try
			{
				Scanner tempInput = new Scanner(new File(path));
				stringInput = tempInput.useDelimiter("\\Z").next();
				String[] numberArray = stringInput.split("\r\n");
				
				for(int i = 0; i < numberArray.length; i++){
					numbers.add(Double.parseDouble(numberArray[i]));
				}
				repeat = false;
			}
			catch (FileNotFoundException e){ }
			catch (NoSuchElementException e){
				System.out.println("The entered file was empty.");
			}
		}
		
		
		max = FindMax(numbers);
		min = FindMin(numbers);
		
		System.out.println("The Max Value:" + max + "\tThe Min Value:" + min);
	}
	
	private static double FindMin(List<Double> input){
		double temp = Double.MAX_VALUE;
		for(int i = 0; i < input.size(); i++){
			if(input.get(i) < temp)
				temp = input.get(i);
		}
		return temp;
	}
	private static double FindMax(List<Double> input){
		double temp = Double.MIN_VALUE;
		for(int i = 0; i < input.size(); i++){
			if(input.get(i) > temp)
				temp = input.get(i);
		}
		return temp;
	}
}
