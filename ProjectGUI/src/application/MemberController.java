package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MemberController {

	public void  switchToShowItem(ActionEvent item) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("ViewItemM.fxml"));
        Stage stage = (Stage)((Node)item.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
	}
	public void  switchToSearch(ActionEvent search) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("SearchForM.fxml"));
        Stage stage = (Stage)((Node)search.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
	}
	public void  switchToHome(ActionEvent home) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("Home.fxml"));
        Stage stage = (Stage)((Node)home.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
	}
	public void switchToCheckOut(ActionEvent co) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("checkutM.fxml"));
		Stage stage = (Stage) ((Node) co.getSource()).getScene().getWindow();
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
}
