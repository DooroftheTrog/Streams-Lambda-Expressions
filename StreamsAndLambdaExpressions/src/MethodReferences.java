import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;

public class MethodReferences {

	static class Person{
		static int age;
		String name;
		
		public int getAge()
		{
			return age;
		}
	}
	
	Function<Person, Integer> f = person -> person.getAge();
	Function<Person, Integer> f1 = Person::getAge ;
	
	BinaryOperator<Integer> sum = (i1, i2) -> i1 + i2;
	BinaryOperator<Integer> sum1 = Integer::sum ;
	
	Consumer<String> printer = s-> System.out.print("printer");
	Consumer<String> printer1 = System.out::println ;
}
