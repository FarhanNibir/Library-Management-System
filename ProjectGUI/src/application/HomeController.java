package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class HomeController {
	
	
	public void  switchToLibrarian(ActionEvent librarian) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("LibrarianPage.fxml"));
        Stage stage = (Stage)((Node)librarian.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
	}
	 
	public void  switchToMember (ActionEvent member) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("MemberPage.fxml"));
		Stage stage = (Stage)((Node)member.getSource()).getScene().getWindow();
		Scene scene =new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	public void exit(ActionEvent action) {
        System.exit(0);
    }
}
 