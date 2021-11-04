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
import library.CheckedOutException;
import library.InvalidItemException;
import library.InvalidMemberException;

public class CheckOutController {

	@FXML
	TextField itemIdtf;
	@FXML
	TextField memIdtf;
	@FXML
	Label label;
	

	public void switchToHome(ActionEvent home) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("Home.fxml"));
		Stage stage = (Stage) ((Node) home.getSource()).getScene().getWindow();
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
	public void CheckOut(ActionEvent checkOut) {
		String itemId = itemIdtf.getText();
		String memId = memIdtf.getText();
		try {
			Main.library.checkOut(itemId, memId);
			label.setText("Checked-out");
		} catch (CheckedOutException e) {
			
			label.setText("Already Checked-Out");
		} catch (InvalidItemException e) {
			label.setText("Item not Available");
		} catch (InvalidMemberException e) {
			label.setText("Member not Available");
		}
		itemIdtf.clear();
		memIdtf.clear();
	}

	public void extendCheckoutTime(ActionEvent action) throws InvalidItemException, InvalidMemberException {
		String t = itemIdtf.getText();
		String m = memIdtf.getText();
		try {
			Main.library.extendCheckOut(t, m);
			Main.library.saveData();
			label.setText("Time Extended.");
		} catch (CheckedOutException | InvalidItemException e) {
			e.printStackTrace();
			label.setText("Already Extended.");
		}
		itemIdtf.clear();
		memIdtf.clear();
	}
}
