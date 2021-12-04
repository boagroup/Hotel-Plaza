package ItemsPackage;

import java.io.Serializable;

public abstract class Item implements Serializable {
	public abstract boolean search();
	public abstract void generateTags();
//	public abstract void edit();
	protected String tag;
}
