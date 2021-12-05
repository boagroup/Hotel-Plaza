package ItemsPackage;

import java.io.Serializable;
import java.util.Scanner;

public abstract class Item implements Serializable {
	public abstract boolean search();
	public abstract void generateTags();
	public abstract boolean edit();
	protected String tag;
}
