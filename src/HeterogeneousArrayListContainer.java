import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

public class HeterogeneousArrayListContainer implements Serializable {
	private final HashMap<Class<?>, ArrayList<?>> hM = new HashMap<>();

	public HeterogeneousArrayListContainer() {}

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
