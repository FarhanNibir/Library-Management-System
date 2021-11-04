package application;

import library.*;
import java.io.IOException;
import java.time.LocalDateTime;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class COutController  {

	@FXML
    private TableColumn<CheckOutRecord, LocalDateTime> checkInTime;

    @FXML
    private TableColumn<CheckOutRecord, LocalDateTime>checkOutTime;

    @FXML
    private TableColumn<CheckOutRecord, String> itemId;

    @FXML
    private TextField itemidtf;

    @FXML
    private TableColumn<CheckOutRecord, String> memberId;

    @FXML
    private TextField memberidtf;

    @FXML
    private TableView<CheckOutRecord> table;
	@FXML
	ListView<String> listView;
//CheckOutRecord cor=new CheckOutRecord(null, null);
//	@Override
//    public void initialize(URL url, ResourceBundle resourceBundle) {
//        TableColumn itemId = new TableColumn("Item Id");
//        TableColumn memberId = new TableColumn("Member Id");
//        TableColumn checkOutTime = new TableColumn("checkOut Date/Time");
//        TableColumn checkInTime = new TableColumn("checkIn Date/Time");
//    
//        table.getColumns().addAll(itemId,memberId,checkOutTime,checkInTime);
//        ObservableList<CheckOutRecord> data = null;
//		try {
//			data = (ObservableList<CheckOutRecord>) Main.items.getCheckOutRecords(null, null);
//		} catch (InvalidMemberException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//        table.setItems(data);
//	}

//        cat.setCellValueFactory(new PropertyValueFactory<Product, String>("category"));
//        id.setCellValueFactory(new PropertyValueFactory<Product, String>("id"));
//        name.setCellValueFactory(new PropertyValueFactory<Product, String>("name"));
//        price.setCellValueFactory(new PropertyValueFactory<Product, String>("price"));
//        quantity.setCellValueFactory(new PropertyValueFactory<Product, String>("quantity"));


       
	public void switchToLibrarian(ActionEvent backlib) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("LibrarianPage.fxml"));
		Stage stage = (Stage) ((Node) backlib.getSource()).getScene().getWindow();
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}

	public void checkoutRecordmemberId(ActionEvent action) {
		listView.getItems().clear();
		String m = memberidtf.getText();
		Member member;
		try {
			member = Main.library.findMember(m);
			ObservableList<CheckOutRecord> list = FXCollections.observableArrayList(member.getChekOutRecords());
			for (int i = 0; i < list.size(); i++) {
				Main.library.getCheckOutRecords(m, m);
				listView.getItems().addAll(list.get(i).toString());
//				initialize(null, null);
//				String iId=cor.getItemId();
//				String mId=cor.getMemberId();
//				LocalDateTime cot=cor.getCheckOutTime();
//				LocalDateTime cit=cor.getCheckInTime();
//				itemId.setCellValueFactory(new PropertyValueFactory<CheckOutRecord, String> (iId));
//			    memberId.setCellValueFactory(new PropertyValueFactory<CheckOutRecord, String> (mId));
//			    checkOutTime.setCellValueFactory(new PropertyValueFactory<CheckOutRecord, LocalDateTime> ("cot"));
//			    checkInTime.setCellValueFactory(new PropertyValueFactory<CheckOutRecord, LocalDateTime> ("cit"));
			}
		} catch (InvalidMemberException e) {
			listView.getItems().addAll("Enter Valid Data");
		}
		memberidtf.clear();
	}

	public void checkoutRecordItemId(ActionEvent action) throws InvalidMemberException {
		listView.getItems().clear();
		String t = itemidtf.getText();
		Item item = null;
		try {
			try {
				item = Main.library.findItem(t);
			} catch (InvalidItemException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			ObservableList<CheckOutRecord> list = FXCollections.observableArrayList(item.getChekOutRecords());
			for (int i = 0; i < list.size(); i++) {
				Main.library.getCheckOutRecords(t, t);
				listView.getItems().addAll(list.get(i).toString());
			}
		} catch (InvalidMemberException e) {
			listView.getItems().addAll("Enter Valid Data");
		}
		itemidtf.clear();
	}
}
