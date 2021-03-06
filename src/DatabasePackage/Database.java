package DatabasePackage;

import java.io.*;
import java.util.ArrayList;
/**
 * non-instantiatable class used for interacting with saved and loaded files
 */
public final class Database implements Serializable {
	private static HeterogeneousArrayListContainer db = new HeterogeneousArrayListContainer();
	private static final String DIR = System.getProperty("user.dir") + File.separator + "database"; // "database" folder

	/**
	 * private constructor of Database class; instantiation of this class is not allowed
	 * @throws RuntimeException always
	 */
	private Database() {
		throw new RuntimeException("Instantiation of Database is not allowed");
	}

	public static boolean fileExists() {
		File folder = new File(DIR);
		File file = new File(DIR + File.separator + "db.ser");
		if (!folder.exists() || !folder.isDirectory()) { // checks if folder exists and is directory
			return false;
		}
		return file.exists() && !file.isDirectory();

	}

	/**
	 * function handling serializing the database into single file
	 * @return <tt>true</tt> if serialization went successful, <tt>false</tt> otherwise
	 */
	public static boolean saveDatabase() {
		File folder = new File(DIR);
		try {
			if (!folder.mkdir() && !folder.exists()) { // tries to create a folder and checks if folder is exists
				throw new IOException("Creating or finding folder failed");
			}
			FileOutputStream fos = new FileOutputStream(DIR + File.separator + "db.ser");
			ObjectOutputStream out = new ObjectOutputStream(fos);
			out.writeObject(db); // writes the container to the file
			out.close();
			fos.close();
		} catch (Exception e) {
			System.out.println();
			System.out.println(e instanceof FileNotFoundException ? "File not found" : e.getMessage());
			return false;
		}
		return true;
	}

	/**
	 * function handling deserializing the database from files
	 * @return <tt>true</tt> if deserialization went successful, <tt>false</tt> otherwise
	 */
	public static boolean loadDatabase() {
		File folder = new File(DIR);
		try {
			if (!folder.isDirectory() || !folder.exists()) { // checks if folder exists and if it is a directory
				throw new IOException("finding folder failed");
			}
			FileInputStream fis = new FileInputStream(DIR + File.separator + "db.ser");
			ObjectInputStream in = new ObjectInputStream(fis);
			db = (HeterogeneousArrayListContainer) in.readObject(); // reads the container inside the file
			in.close();
			fis.close();
		} catch (Exception e) {
			System.out.println();
			System.out.println(e instanceof FileNotFoundException ? "File not found" : e.getMessage());
			return false;
		}
		return true;
	}

	/**
	 * Returns the ArrayList of the specified Class or null if there is no list for the Class.
	 * @throws NullPointerException if the type is {@code null}
	 */
	public static <T> ArrayList<T> getList(Class<T> type) throws NullPointerException {
		if (type == null) {
			throw new NullPointerException("Type is null");
		}
		return db.getArrayList(type);
	}

	/**
	 * Associates the specified ArrayList with the specified Class in this map.
	 * @param type Class with which the specified ArrayLIst is to be associated
	 * @throws NullPointerException if the type is null
	 */
	public static <T> boolean putList(Class<T> type) throws NullPointerException {
		if (type == null) {
			throw new NullPointerException("Type is null");
		}
		if (!db.containsClass(type)) {
			db.putArrayList(type, new ArrayList<>());
			return true;
		}
		return false;
	}

	/**
	 * Returns <tt>true</tt> if Database contains an ArrayList for the
	 * specified Class.
	 *
	 * @param type The Class whose presence in Database is to be tested
	 * @return <tt>true</tt> if this Database contains a mapping for the specified Class.
	 * @throws NullPointerException if the type is null
	 */
	public static <T> boolean containsList(Class<T> type) throws NullPointerException {
		if (type == null) {
			throw new NullPointerException("Type is null");
		}
		return db.containsClass(type);
	}

}
