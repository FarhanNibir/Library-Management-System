package application;

import java.io.IOException;
import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;
import library.*;

public class AddIController {
	ArrayList<Item> items = new ArrayList<>();
	@FXML
	Label mylabel;
	@FXML
	RadioButton Book;
	@FXML
	RadioButton Publication;
	@FXML
	RadioButton Movie;
	@FXML
	TextField itemId;
	@FXML
	TextField title;
	@FXML
	TextField authors;
	@FXML
	TextField category;
	@FXML
	TextField publishYear;
	@FXML
	TextField publisherName;
	@FXML
	ToggleGroup singel;

	public void clear() {
		itemId.clear();
		title.clear();
		authors.clear();
		category.clear();
		publishYear.clear();
		publisherName.clear();
	}

	public void AddItems(ActionEvent Event) {
		if (Book.isSelected()) {
			String Id = itemId.getText();
			String Ti = title.getText();
			ArrayList<String> Au = new ArrayList<>();
			Au.add(authors.getText());
			String Ca = category.getText();
			String Pu = publishYear.getText();
			int year = Integer.parseInt(Pu);
			String Pub = publisherName.getText();
			String type = ("Book");
			try {
				Main.library.addItem(type,Id, Ti, Ca, Au, year, Pub);
				Main.library.saveData();
			} catch (Exception e) {
				e.printStackTrace();
			}
			clear();
		}
		 if (Publication.isSelected()) {
			String Id = itemId.getText();
			String Ti = title.getText();
			ArrayList<String> Au = new ArrayList<>();
			Au.add(authors.getText());
			String Ca = category.getText();
			String Pu = publishYear.getText();
			int year = Integer.parseInt(Pu);
			String Pub = publisherName.getText();
			String type = ("Publication");
			try {
				Main.library.addItem(type,Id, Ti, Ca,  Au, year, Pub);
				Main.library.saveData();
			} catch (Exception e) {
				e.printStackTrace();
			}
			clear();
		}

		 if (Movie.isSelected()) {
			publisherName.isDisable();
			String Id = itemId.getText();
			String Ti = title.getText();
			ArrayList<String> Au = new ArrayList<>();
			Au.add(authors.getText());
			String Ca = category.getText();
			String Pu = publishYear.getText();
			//String type = ("Movie");
			int year = Integer.parseInt(Pu);
			try {
				Main.library.addItem(Id, Ti, Ca, Au, year);
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			clear();
		}
	}

	public void okay(ActionEvent okay) {
		if (Movie.isSelected()) {
			mylabel.setVisible(false);
			publisherName.setVisible(false);
		} else {
			mylabel.setVisible(true);
			publisherName.setVisible(true);
		}
	}

	public void switchToMenu(ActionEvent menu) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("LibrarianPage.fxml"));
		Stage stage = (Stage) ((Node) menu.getSource()).getScene().getWindow();
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
}
