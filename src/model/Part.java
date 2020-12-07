package model;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.ReadOnlyDoubleProperty;
import javafx.beans.property.ReadOnlyStringProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;


public class Part {
	private StringProperty type;	
	private StringProperty name;
	private DoubleProperty price;
	
	public Part(String name, String type, double price) {
		this.name = new SimpleStringProperty();
		this.name.set(name);
		this.type = new SimpleStringProperty();
		this.type.set(type.toUpperCase());
		this.price = new SimpleDoubleProperty();
		this.price.set(price);
	}
	
	public String getName() {
		return name.getValue();
	}
	
	public ReadOnlyStringProperty nameProperty() {
		return this.name;
	}
	
	public String getType() {
		return type.getValue();
	}
	
	public ReadOnlyStringProperty typeProperty() {
		return this.type;
	}
	
	public double getPrice() {
		return price.doubleValue();
	}
	
	public ReadOnlyDoubleProperty priceProperty() {
		return this.price;
	}
	
	public void showPart() {
		System.out.println(this.toString());
	}

	public boolean hasType(String type) {
		return getType().equals(type.toUpperCase());
	}

	public boolean costsAtLeast(double price) {
		return this.price.doubleValue() >= price;
	}

	public boolean costsAtMost(double price) {
		return this.price.doubleValue() <= price;
	}

}
