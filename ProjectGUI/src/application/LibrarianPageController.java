package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import library.InvalidItemException;

public class LibrarianPageController {
	
	@FXML
	TextField itemIdTF;
	@FXML
	Label msg;

	

	public void  switchToHome(ActionEvent home) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("Home.fxml"));
        Stage stage = (Stage)((Node)home.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
	}
	
	public void  switchToSearch(ActionEvent search) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("Search.fxml"));
        Stage stage = (Stage)((Node)search.getSource()).getScene().getWindow();
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
	
	public void  switchToViewItem(ActionEvent items) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("ViewItem.fxml"));
        Stage stage = (Stage)((Node)items.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
	}

	public void  switchToCheckOutRecord(ActionEvent CORecord) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("CheckOutRecord.fxml"));
        Stage stage = (Stage)((Node)CORecord.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
	}

	public void  switchToAddItem(ActionEvent AddI) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("AddItem.fxml"));
        Stage stage = (Stage)((Node)AddI.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
	}
	
	public void  switchToAddMember(ActionEvent AddM) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("AddMember.fxml"));
        Stage stage = (Stage)((Node)AddM.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
	}
	public void  CheckIn(ActionEvent checkIn) {
		String itemId =itemIdTF.getText();
		try {
			Main.library.checkIn(itemId);
			Main.library.saveData();
			itemIdTF.clear();
			String t= "Checked In.";
			msg.setText(t);
		} catch (InvalidItemException e) {
			e.printStackTrace();
		}
	}
}
