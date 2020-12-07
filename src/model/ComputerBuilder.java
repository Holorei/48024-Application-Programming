package model;

import java.awt.event.MouseEvent;
import static javafx.application.ConditionalFeature.FXML;
import javafx.fxml.FXML;
import javafx.stage.Stage;

public class ComputerBuilder {
	
	private final Catalogue catalogue;
	private final Build build;
	
	public ComputerBuilder() {
		
		build = new Build();
		catalogue = new Catalogue(build);

	}
	
	public Catalogue getCatalogue() {
		return this.catalogue;
	}
	
	public Build getBuild() {
		return this.build;
	}
	
	




}
