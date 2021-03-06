package ItemsPackage;
import java.io.Serializable;
import java.util.Scanner;

public class Room extends Item implements Serializable {
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
		return "Room nr " + number +
				"  |  " + type  +
				"  |  " + (isOccupied? "Occupied":"Free") +
				"  |  " + standardPrice + " dkk" +
				"  |  " + numberOfBeds +
				"  |  " + (isClean? "Clean":"Dirty") +
				"  |  " + (isOutOfOrder? "Out of Order":"in Order") + " ]";
	}

	public boolean edit(Scanner sc) {
		System.out.println("Room Number: " + number);
		System.out.println("1. Room Type: " + type);
		System.out.println("2. Occupied: " + (isOccupied? "Occupied":"Free"));
		System.out.println("3. Price: " + standardPrice);
		System.out.println("4. Number of beds: " + numberOfBeds);
		System.out.println("5. Clean: " + (isClean? "Clean":"Dirty"));
		System.out.println("6. Out of order: " + (isOutOfOrder? "Out of Order":"in Order"));
		System.out.println("0. Go back");
		String answer = sc.nextLine();
		switch (answer) {
			case "1":
				System.out.println("Please enter the Room Type: ");
				type = sc.nextLine();
				break;
			case "2":
					isOccupied ^= true;
				break;
			case "3":
				System.out.println("Please enter the new Price: ");
				try {
					standardPrice = Double.parseDouble(sc.nextLine());
				} catch (Exception e) {
					System.out.println(e instanceof NumberFormatException? "You need to put in a number!" : e.getMessage());
				}
				break;
			case "4":
				System.out.println("Please enter the Number of beds: ");
				try {
					numberOfBeds = Integer.parseInt(sc.nextLine());
				} catch (Exception e) {
					System.out.println(e instanceof NumberFormatException? "You need to put in an integer!" : e.getMessage());
				}
				break;
			case "5":
				isClean ^= true;
				break;
			case "6":
				isOutOfOrder ^= true;
				break;
			default:
				generateTags();
				return false;
		}
		generateTags();
		return true;
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
