package application;
import library.*;
import java.io.IOException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class ViewItemController {

	@FXML
	TextField itemTypetf;
	@FXML
	ListView<String> listView;

	public void  switchToHome(ActionEvent home) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("Home.fxml"));
        Stage stage = (Stage)((Node)home.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
	}
	public void  switchToCheckOut(ActionEvent checkIn) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("CheckOut.fxml"));
        Stage stage = (Stage)((Node)checkIn.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
	}
	public void switchToLibrarian(ActionEvent h) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("LibrarianPage.fxml"));
		Stage stage = (Stage) ((Node) h.getSource()).getScene().getWindow();
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	public void showSpecificTypeItem(ActionEvent show) {
		String type = itemTypetf.getText();
		ObservableList<Item>list = FXCollections.observableArrayList(Main.library.findItems(type));
		listView.getItems().clear();
		for(int i=0; i < list.size();i++) {
            listView.getItems().addAll(list.get(i).toString());
         }
		itemTypetf.clear();
	}

	public void showAllItem(ActionEvent showAll) {
		listView.getItems().clear();
		String display = "";
		for (Item data : Main.library.getItems()) {
			display = display + data.toString() + "\n";
		}
		listView.getItems().addAll(display);
	}
}
