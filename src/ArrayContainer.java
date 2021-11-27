import interfaces.iDatabase;
import java.util.ArrayList;
import java.util.HashMap;

public abstract class ArrayContainer {
	private static final HashMap<Class<?>, ArrayList<?>> db = new HashMap<>();

	public static <T> void addArrayList(Class<T> type, ArrayList<T> list) {
		if (type == null) {
			throw new NullPointerException("Type is null");
		}
		db.put(type, list);
	}

	@SuppressWarnings("unchecked")
	public static <T> ArrayList<T> getArrayList(Class<T> type) {
		return (ArrayList<T>) db.get(type);
	}
}
