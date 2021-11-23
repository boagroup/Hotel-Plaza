package interfaces;
import java.util.ArrayList;

public interface iDatabase {
	boolean saveFile();
	boolean loadFile();
	boolean saveDatabase();
	boolean readDatabase();
	<T> ArrayList<T> getList();
}
