package model;

import java.util.ArrayList;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;

public class Catalogue {

	private ObservableList<Part> parts;
	private ObservableList<Part> currentView;
	private final Build build;

	public Catalogue(Build build) {

		this.build = build;

		parts = FXCollections.<Part>observableArrayList();
		currentView = FXCollections.<Part>observableArrayList();

		parts.add(new Part("evo 860", "storage", 155.00));
		parts.add(new Part("daskeyboard", "keyboard", 239.00));
		parts.add(new Part("i5", "cpu", 365.00));
		parts.add(new Part("corsair 16G", "memory", 299.00));
		parts.add(new Part("ASUS ROG", "motherboard", 159.00));
		parts.add(new Part("sheetmetal box", "case", 39.00));
		parts.add(new Part("Ryzen 7", "cpu", 299.00));

		currentView.addAll(parts);
		parts.addListener(new ListChangeListener<Part>() {
			@Override
			public void onChanged(javafx.collections.ListChangeListener.Change<? extends Part> c) {
				currentView.clear();
				currentView.addAll(parts);
			}

		});
	}

	public void addPart(String name, String type, double price) {
		parts.add(new Part(name, type, price));
	}

	public ObservableList<Part> getCurrentView() {
		return currentView;
	}

	public void filterList(String type, String min, String max) {

		List<Part> temp = new ArrayList<Part>();

		for (Part p : parts) {
			try {
				if ((type.equals("") || p.hasType(type)) && (min.equals("") || p.costsAtLeast(Double.parseDouble(min)))
						&& (max.equals("") || p.costsAtMost(Double.parseDouble(max)))) {
					temp.add(p);
				}
			} catch (NumberFormatException e) {
			}
		}

		this.currentView.clear();
		this.currentView.addAll(temp);
	}

	public void addToBuild(Part p) {
		build.addPart(p);
	}

	public void addToBuild(List<Part> selectedItems) {
		build.addParts(selectedItems);
	}

	public void remove(Part p) {
		parts.remove(p);
	}

	public void remove(List<Part> selectedItems) {
		parts.removeAll(selectedItems);
	}

}
