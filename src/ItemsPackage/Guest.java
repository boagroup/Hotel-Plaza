package ItemsPackage;

import java.io.Serializable;
import java.util.Scanner;

public class Guest extends Item implements Serializable {

	protected String name;
	protected boolean hasPaid = false;
	protected String phoneNumber;
	protected String address;
	protected String paymentDetails;


	public Guest(String name) {
		this.name = name;
		generateTags();
	}

	public Guest(String name, boolean hasPaid) {
		this.name = name;
		this.hasPaid = hasPaid;
		generateTags();
	}

	public Guest(String name, boolean hasPaid, String phoneNumber, String address, String paymentDetails) {
		this.name = name;
		this.hasPaid = hasPaid;
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.paymentDetails = paymentDetails;
		generateTags();
	}

	public boolean search() {
		return false;
	}

	public void generateTags() {
		this.tag =
			name + " "
		    + hasPaid + " "
		    + phoneNumber + " "
		    + address + " "
		    + paymentDetails;
	}

	@Override
	public String toString() {
		return "Guest{" +
				"name='" + name + '\'' +
				", phoneNumber='" + phoneNumber + '\'' +
				", hasPaid=" + hasPaid +
				", address='" + address + '\'' +
				", paymentDetails='" + paymentDetails + '\'' +
				'}';
	}

	public boolean edit(Scanner sc) {
		System.out.println("1. Name: " + name);
		System.out.println("2. Paid: " + hasPaid);
		System.out.println("3. Phone Number: " + phoneNumber);
		System.out.println("4. Address: " + address);
		System.out.println("5. Payment Details: " + paymentDetails);
		System.out.println("0. Go back");
		String answer = sc.nextLine();
		switch (answer) {
			case "1":
				System.out.println("Please enter the new Name: ");
				name = sc.nextLine();
				break;
			case "2":
				hasPaid ^= true;
				break;
			case "3":
				System.out.println("Please enter the new Phone Number: ");
				phoneNumber = sc.nextLine();
				break;
			case "4":
				System.out.println("Please enter the new Address: ");
				address = sc.nextLine();
				break;
			case "5":
				System.out.println("Please enter the new Payment Details: ");
				paymentDetails = sc.nextLine();
				break;
			default:
				generateTags();
				return false;
		}
		generateTags();
		return true;
	}

//* Getters

	public String getName() {
		return name;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public boolean isHasPaid() {
		return hasPaid;
	}

	public String getAddress() {
		return address;
	}

	public String getPaymentDetails() {
		return paymentDetails;
	}

//* Setters

	public void setName(String name) {
		this.name = name;
		generateTags();
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
		generateTags();
	}

	public void setHasPaid(boolean hasPaid) {
		this.hasPaid = hasPaid;
		generateTags();
	}

	public void setAddress(String address) {
		this.address = address;
		generateTags();
	}

	public void setPaymentDetails(String paymentDetails) {
		this.paymentDetails = paymentDetails;
		generateTags();
	}
}
