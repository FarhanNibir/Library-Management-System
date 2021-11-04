package application;

import library.*;
import java.io.IOException;
import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;

public class SearchForMController {
	ArrayList<Member> members = new ArrayList<>();
	Library item1 = new Library(null, members);
	@FXML
	RadioButton checkbox1;
	@FXML
	RadioButton checkbox2;
	@FXML
	TextField itemIdTF;
	@FXML
	TextField titleTF;
	@FXML
	TextField authorTF;
	@FXML
	ToggleGroup test;

    @FXML
    ListView<String> listView;

	public void Search(ActionEvent event) {
		if(checkbox1.isSelected()) {
			String id = itemIdTF.getText();
			listView.getItems().clear();
			try {
	    		ObservableList<Item>list = FXCollections.observableArrayList(Main.library.findItem(id));
	    		for(int i=0; i < list.size();i++) {
	                listView.getItems().addAll(list.get(i).toString());
	             }
			} catch (InvalidItemException e) {
				
				String a = "Enter Valid Id";
				listView.getItems().addAll(a);
			}
	    	itemIdTF.clear();
	    }
		
	else if (checkbox2.isSelected()) {
		String ti = titleTF.getText();
    	String au = authorTF.getText();
    	ArrayList<Item> item = new ArrayList<>();
    	listView.getItems().clear();
    	item = Main.library.findItems(ti,au);
    	ObservableList<Item>list = FXCollections.observableArrayList(item);
		for(int i=0; i < list.size();i++) {
            listView.getItems().addAll(list.get(i).toString());
         }
    	titleTF.clear();
    	authorTF.clear();
		}
	}
		
	public void switchToHome(ActionEvent h) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("Home.fxml"));
		Stage stage = (Stage) ((Node) h.getSource()).getScene().getWindow();
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	public void switchToMember(ActionEvent h) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("MemberPage.fxml"));
		Stage stage = (Stage) ((Node) h.getSource()).getScene().getWindow();
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
