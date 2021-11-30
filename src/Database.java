import java.io.*;
import java.util.ArrayList;

public final class Database implements Serializable {
	private static ArrayContainer db = new ArrayContainer();
	private static final String DIR = System.getProperty("user.dir") + File.separator + "database";

	private Database() {
		throw new RuntimeException("Instantation of Database is not allowed");
	}

	public static boolean saveDatabase() {
		File folder = new File(DIR);
		try {
			if (!folder.mkdir() || !folder.exists()) {
				throw new IOException("Creating or finding folder failed");
			}
			FileOutputStream fos = new FileOutputStream(DIR + File.separator + "db");
			ObjectOutputStream out = new ObjectOutputStream(fos);
			out.writeObject(db);
			out.close();
			fos.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
		return true;
	}

	public static boolean loadDatabase() {
		File folder = new File(DIR);
		try {
			if (!folder.isDirectory() || !folder.exists()) {
				throw new IOException("finding folder failed");
			}
			FileInputStream fis = new FileInputStream(DIR + File.separator + "db");
			ObjectInputStream in = new ObjectInputStream(fis);
			db = (ArrayContainer) in.readObject();
			in.close();
			fis.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
		return true;
	}

	public static <T> ArrayList<T> getList(Class<T> type) {
		return db.getArrayList(type);
	}

	public static void main(String[] args) {
		if (Database.saveDatabase()) {
			System.out.println("TRUE");
		} else {
			System.out.println("FALSE");
		}
	}

}
