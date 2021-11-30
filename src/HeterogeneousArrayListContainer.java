import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * stores hashmap with Classes as keys an Arraylist of instances of those classes as values
 */
public class HeterogeneousArrayListContainer implements Serializable {
	private final HashMap<Class<?>, ArrayList<?>> hM;

	/**
	 * constructs an empty HeterogeneousArrayListContainer with the default initial capacity of 16 (same as Hashmap)
	 */
	public HeterogeneousArrayListContainer() {
		hM = new HashMap<>();
	}

	/**
	 * constructs an empty HeterogeneousArrayListContainer with the default initial capacity of 16 (same as Hashmap)
	 * @param  initialCapacity the initial capacity.
	 * @throws IllegalArgumentException if the initial capacity is negative.
	 */
	public HeterogeneousArrayListContainer(int initialCapacity) {
		hM = new HashMap<>(initialCapacity);
	}

	public <T> void putArrayList(Class<T> type, ArrayList<T> list) throws NullPointerException {
		if (type == null) {
			throw new NullPointerException("Type is null");
		}
		hM.put(type, list);
	}

	public <T> void removeArrayList(Class<T> type) throws NullPointerException {
		if (type == null) {
			throw new NullPointerException("Type is null");
		}
		hM.remove(type);
	}

	@SuppressWarnings("unchecked")
	public <T> ArrayList<T> getArrayList(Class<T> type) throws NullPointerException{
		if (type == null) {
			throw new NullPointerException("Type is null");
		}
		return (ArrayList<T>) hM.get(type);
	}

	public <T> boolean containsClass(Class<T> type) throws NullPointerException {
		if (type == null) {
			throw new NullPointerException("Type is null");
		}
		return hM.containsKey(type);
	}

}
