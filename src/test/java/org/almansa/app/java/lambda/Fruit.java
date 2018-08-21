package org.almansa.app.java.lambda;

public class Fruit {
	private String name;
	private Long price;
	private Boolean isOrganic;

	public Fruit() {
		super();
	}

	public Fruit(String name) {		
		super();
		this.name = name;
	}

	public Fruit(String name, Long price) {
		this(name);
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getPrice() {
		return price;
	}

	public void setPrice(Long price) {
		this.price = price;
	}

	public Boolean getIsOrganic() {
		return isOrganic;
	}

	public void setIsOrganic(Boolean isOrganic) {
		this.isOrganic = isOrganic;
	}

	@Override
	public String toString() {
		return "Fruit [name=" + name + ", price=" + price + ", getName()=" + getName() + ", getPrice()=" + getPrice()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}

}
