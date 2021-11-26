import interfaces.iDatabase;
import java.util.ArrayList;
import java.util.HashMap;

public abstract class Database implements iDatabase {
	private final HashMap<Class<?>, ArrayList<?>> db = new HashMap<>();

	public <T> void addArrayList(Class<T> type, ArrayList<T> list) {
		if (type == null) {
			throw new NullPointerException("Type is null");
		}
		db.put(type, list);
	}

	@SuppressWarnings("unchecked")
	public <T> ArrayList<T> getList(Class<T> type) {
		return (ArrayList<T>) db.get(type);
	}
}
