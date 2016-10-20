import java.util.function.Function;

@FunctionalInterface
public interface Comparator<T> {

	public int compare(T t1, T t2);
	
	//will compare a generic object or variable that is comparable
	public static <U> Comparator<U> comparing(Function<U,Comparable> f)
	{
		return (p1 , p2) -> f.apply(p1).compareTo(f.apply(p2));	
	}
	
	//will compare a generic object or variable that is comparable
		public default Comparator<T> thenComparing(Function<T,Comparable> f)
		{
			Comparator<T> cmp = comparing(f);
			return thenComparing(cmp);	
		}
		
	
	public default Comparator<T> thenComparing(Comparator<T> cmp)
	{
		return (p1, p2) -> compare(p1, p2) == 0 ? cmp.compare(p1, p2) : compare(p1, p2);
	}
	
}
