package ItemsPackage;

public class Room extends Item {
	protected int number;
	protected String type;
	protected boolean isOccupied = false;
	protected double standardPrice;
	protected int numberOfBeds;
	protected boolean isClean = true;
	protected boolean isOutOfOrder = false;

	public Room(int number) {
		this.number = number;
		generateTags();
	}

	public Room(int number, boolean isClean, boolean isOccupied) {
		this.number = number;
		this.isClean = isClean;
		this.isOccupied = isOccupied;
		generateTags();
	}

	public Room(int number, String type, boolean isOccupied, double standardPrice, int numberOfBeds, boolean isClean, boolean isOutOfOrder) {
		this.number = number;
		this.type = type;
		this.isOccupied = isOccupied;
		this.standardPrice = standardPrice;
		this.numberOfBeds = numberOfBeds;
		this.isClean = isClean;
		this.isOutOfOrder = isOutOfOrder;
		generateTags();
	}

	public boolean search() {
		return false;
	}

	public void generateTags() {
		this.tag =
			number + " "
			+ type + " "
			+ isOccupied + " "
			+ standardPrice + " "
			+ numberOfBeds + " "
	        + isClean + " "
			+ isOutOfOrder;

	}

	@Override
	public String toString() {
		return "Room{" +
				"number=" + number +
				", type='" + type + '\'' +
				", isOccupied=" + isOccupied +
				", standardPrice=" + standardPrice +
				", numberOfBeds=" + numberOfBeds +
				", isClean=" + isClean +
				", isOutOfOrder=" + isOutOfOrder +
				'}';
	}


	//* Getters

	public int getNumber() {
		return number;
	}

	public String getType() {
		return type;
	}

	public boolean isOccupied() {
		return isOccupied;
	}

	public double getStandardPrice() {
		return standardPrice;
	}

	public int getNumberOfBeds() {
		return numberOfBeds;
	}

	public boolean isClean() {
		return isClean;
	}

	public boolean isOutOfOrder() {
		return isOutOfOrder;
	}

//* Setters

	public void setNumber(int number) {
		this.number = number;
		generateTags();
	}

	public void setType(String type) {
		this.type = type;
		generateTags();
	}

	public void setOccupied(boolean occupied) {
		isOccupied = occupied;
	}

	public void setStandardPrice(double standardPrice) {
		this.standardPrice = standardPrice;
		generateTags();
	}

	public void setNumberOfBeds(int numberOfBeds) {
		this.numberOfBeds = numberOfBeds;
		generateTags();
	}

	public void setClean(boolean clean) {
		isClean = clean;
		generateTags();
	}

	public void setOutOfOrder(boolean outOfOrder) {
		isOutOfOrder = outOfOrder;
		generateTags();
	}
}
