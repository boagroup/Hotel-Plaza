package ItemsPackage;

public class Guest extends Item {

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
