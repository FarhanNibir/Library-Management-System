package application;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AddMController {
	@FXML
	TextField mIdtf;
	@FXML
	TextField mNametf;
	@FXML
	Label msg;


	public void switchToHome(ActionEvent home) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("Home.fxml"));
		Stage stage = (Stage) ((Node) home.getSource()).getScene().getWindow();
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.show();

	}

	public void switchToLibrarian(ActionEvent librarian) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("LibrarianPage.fxml"));
		Stage stage = (Stage) ((Node) librarian.getSource()).getScene().getWindow();
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}

	public void addMember(ActionEvent action) {
		String mn = mNametf.getText();
		String mid = mIdtf.getText();
		Main.library.addMember(mid, mn);
		Main.library.saveData();
		mNametf.clear();
		mIdtf.clear();
		msg.setText("Member Added");
	}
}