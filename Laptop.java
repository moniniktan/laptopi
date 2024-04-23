public class Laptop {
	private int year;
	private String brand;
	private int price;
	private String clientCity;
	private String ownerName;

	public Laptop() {
	}

	public Laptop(int year, String brand, int price, String clientCity, String ownerName) {
		this.year = year;
		this.brand = brand;
		this.price = price;
		this.clientCity = clientCity;
		this.ownerName = ownerName;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getClientCity() {
		return clientCity;
	}

	public void setClientCity(String clientCity) {
		this.clientCity = clientCity;
	}

	public String getOwnerName() {
		return ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}
}
