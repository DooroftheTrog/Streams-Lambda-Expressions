import java.util.Arrays;
import java.util.Comparator;
import java.util.concurrent.Executors;

public class LambdaExpressions {

	//modifiers can be added to the parameters of a lambda expression
	// the final keyword can be added
	// and annotations are allowed
	//It is NOT possible to specify the return type of a lambda expression but you CAN specify what variable is returned
	
	//Lambda Expressions are only used for methods that already exist and are basically overrides of those methods
	
	public static void ComparatorExample()
	{
		//Example 1
				//basic comparator: this can be used to in a sort function to override the normal .compareTo function used with the sort function
				Comparator<String> comparator = new Comparator<String>()
				{
					//instead of the normal compare function of string this comparator uses the length of the strings to compare them
					public int compare(String s1, String s2)
					{
						//integer.compare will return the lower number as the first value and the larger one as the second value
						return Integer.compare(s1.length(), s2.length());
					}
				};
				
				//Lambda Expression version
				//(the conditions for a function are passed here) -> the execution of the method are passed here this is the return statement without the return statement
				comparator = (String s1, String s2) -> Integer.compare(s1.length(), s2.length());
				//can also be :::::: comparator = (String s1, String s2) -> return Integer.compare(s1.length(), s2.length());
				// if you need to speficy what line of code to be returned
				
				//parameter types can be omitted as well if you know what they are and can be written as such
				comparator = (s1, s2) -> Integer.compare(s1.length(), s2.length());
				
				String[] words = {"b", "ab", "a", "bc"};
				Arrays.sort(words,comparator);
				 
				for(int i = 0; i < words.length; i++)
				{
					System.out.print(words[i]+" ");
				}
	}
	
	public static void RunnableExample()
	{
		//can be passed to an executor service to run a single method or group of instructions
		//Runnable is a piece of code that can be executed later by an executor or another thread this is executed in another context(aka a thread)
		Runnable r = new Runnable()
		{
			@Override
			public void run() {
				int i = 0;
				
				//when i is incremented in this fashion it runs the test and then increments the i after the test is run but before the inner loop code executes.
				while(i++ < 10)
				{
					System.out.println("It Works : i = "+ i);
				}
			}
		};
		
		//Lambda Expression version
		//the run method in Runnable does not take any parameters so there are blank parameters for this expression.
		//rather than a return statement it runs effects that ode based on the executed code
		r = () ->{
			int i = 0;
			while(i++ < 10)
			{
				System.out.println("It Works : i = "+ i);
			}
		};
		
		//executes a runnable a single time
		Executors.newSingleThreadExecutor().execute(r);
	}
	
	public static void main(String args[])
	{
		ComparatorExample();
		//RunnableExample();
		
	}
}
