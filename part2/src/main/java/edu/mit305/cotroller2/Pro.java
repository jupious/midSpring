package edu.mit305.cotroller2;

public class Pro {
	private String name;
	private Integer price;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Pro [name=" + name + ", price=" + price + "]";
	}
	
}
