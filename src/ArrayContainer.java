import interfaces.iDatabase;
import java.util.ArrayList;
import java.util.HashMap;

public abstract class ArrayContainer {
	private final HashMap<Class<?>, ArrayList<?>> db = new HashMap<>();

	public <T> void putArrayList(Class<T> type, ArrayList<T> list) {
		if (type == null) {
			throw new NullPointerException("Type is null");
		}
		db.put(type, list);
	}

	public <T> void removeArrayList(Class<T> type) {
		if (type == null) {
			throw new NullPointerException("Type is null");
		}
		db.remove(type);
	}

	@SuppressWarnings("unchecked")
	public <T> ArrayList<T> getArrayList(Class<T> type) {
		return (ArrayList<T>) db.get(type);
	}

	public <T> boolean containsClass(Class<T> type) {
		return db.containsKey(type);
	}

}
