package GuestBook;

public class Contact implements Comparable<Contact>{

	private String firstName, lastName, address, phone;
	
	public Contact(String firstName, String lastName, String address, String phone) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.phone = phone;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getContact() {
		return "Contact:"+ System.lineSeparator() + "First Name: " + firstName + System.lineSeparator() + "Last Name: " + lastName + System.lineSeparator() + "Address: " + address + System.lineSeparator() + "Phone: " + phone + System.lineSeparator() + System.lineSeparator();
	}

	@Override
	public int compareTo(Contact o) {
		int result = this.firstName.compareTo(o.firstName);
	    if (result == 0) {
	      return this.firstName.compareTo(o.firstName);
	    }
	    return result;
	}
}
