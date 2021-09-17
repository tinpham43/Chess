public class Pair<T, E> {

	private T getKey;
	private E getValue;
	
	public Pair() {
		// TODO Auto-generated constructor stub
	}

	public Pair(T t, E e) {
		getKey = t;
		getValue = e;
	}
	
	public T getKey()
	{
		return getKey;
	}
	
	public E getValue()
	{
		return getValue;
	}
}
