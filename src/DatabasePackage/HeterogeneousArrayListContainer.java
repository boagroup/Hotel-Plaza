package DatabasePackage;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * stores hashmap with Classes as keys and Arraylists of instances of those classes as values
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
	 * constructs an empty HeterogeneousArrayListContainer with the specified initial capacity
	 *
	 * @param  initialCapacity the initial capacity.
	 * @throws IllegalArgumentException if the initial capacity is negative.
	 */
	public HeterogeneousArrayListContainer(int initialCapacity) {
		hM = new HashMap<>(initialCapacity);
	}

	/**
	 * Associates the specified ArrayList with the specified Class in this map.
	 * If the map previously contained a mapping for the Class, the old
	 * ArrayList is replaced.
	 *
	 * @param type Class with which the specified ArrayLIst is to be associated
	 * @param list ArrayList to be associated with the specified Class
	 * @throws NullPointerException if the type is null
	 */
	public <T> void putArrayList(Class<T> type, ArrayList<T> list) throws NullPointerException {
		if (type == null) {
			throw new NullPointerException("Type is null");
		}
		hM.put(type, list);
	}

	/**
	 * Removes the mapping for the specified Class from this map if present.
	 *
	 * @param  type Class whose mapping is to be removed from the map
	 * @throws NullPointerException if the type is null
	 */
	public <T> void removeArrayList(Class<T> type) throws NullPointerException {
		if (type == null) {
			throw new NullPointerException("Type is null");
		}
		hM.remove(type);
	}

	/**
	 * Returns the value to which the specified Class is mapped,
	 * or {@code null} if this map contains no mapping for the Class.
	 * @throws NullPointerException if the type is null
	 */
	@SuppressWarnings("unchecked")
	public <T> ArrayList<T> getArrayList(Class<T> type) throws NullPointerException{
		if (type == null) {
			throw new NullPointerException("Type is null");
		}
		return (ArrayList<T>) hM.get(type);
	}

	/**
	 * Returns <tt>true</tt> if this map contains a mapping for the
	 * specified Class.
	 *
	 * @param   type   The Class whose presence in this map is to be tested
	 * @return <tt>true</tt> if this map contains a mapping for the specified Class.
	 * @throws NullPointerException if the type is null
	 */
	public <T> boolean containsClass(Class<T> type) throws NullPointerException {
		if (type == null) {
			throw new NullPointerException("Type is null");
		}
		return hM.containsKey(type);
	}

}
