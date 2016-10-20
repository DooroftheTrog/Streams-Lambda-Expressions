
import java.util.function.Function;

public class ComparatorExample {

	public static void main(String args[])
	{
		//compares the ages of the person variables
		Comparator<Person> cmpAge = (p1, p2) -> p2.getAge() - p1.getAge() ;
		
		//compares them by their first names
		Comparator<Person> cmpfName = (p1, p2) ->p1.getFirstName().compareTo(p2.getFirstName());
		
		Function<Person, Integer> f1 = p -> p.getAge();
		//compares the ages of the person variables
		//Comparator<Person> cmpAgeFunction = Comparator.comparing(f1) ;
		// or it can be written as 
		
		//used to compare person objects by their age can be used in Array.sort() or other sort methods
		Comparator<Person> cmpAgeFunction1 = Comparator.comparing(Person::getAge) ;
		
		//used to compare person objects based on their last name
		Comparator<Person> cmpAgeFunction2 = Comparator.comparing(Person::getLastName) ;
		
		Comparator<Person> cmp = cmpAgeFunction1.thenComparing(cmpAgeFunction2);
		
		Comparator<Person> cmp2 = Comparator.comparing(Person::getLastName).thenComparing(Person::getFirstName);
	}
}
