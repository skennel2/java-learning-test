package org.almansa.app.java.lambda;

public class Fruit {
	private String name;
	private Long price;

	public Fruit() {
		super();
	}
	
	public Fruit(String name) {
		this.name = name;
	}

	public Fruit(String name, Long price) {
		this.name = name;
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

	@Override
	public String toString() {
		return "Fruit [name=" + name + ", price=" + price + ", getName()=" + getName() + ", getPrice()=" + getPrice()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}
	
}
