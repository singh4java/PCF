package Docker.Service;

public class Employee {
	private int ssn;
	private String name;
	private String address;
	public Employee(int ssn, String name, String address) {
		super();
		this.ssn = ssn;
		this.name = name;
		this.address = address;
	}
	@Override
	public String toString() {
		return "Employee [ssn=" + ssn + ", name=" + name + ", address=" + address + "]";
	}
	public int getSsn() {
		return ssn;
	}
	public void setSsn(int ssn) {
		this.ssn = ssn;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}

}
