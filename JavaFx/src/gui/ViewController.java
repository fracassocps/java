package gui;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import Model.Person;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.util.Callback;
import util.Alerts;

public class ViewController implements Initializable {

	@FXML
	private Button btn;
	
	@FXML
	private TextField tx1;
	
	@FXML
	private TextField tx2;
	
	@FXML
	private ComboBox<Person> cbx1;
	
	private ObservableList<Person> obsList;
	
	@FXML
	public void onComboBoxPersonAction() {
		Person person = cbx1.getSelectionModel().getSelectedItem();
		System.out.println(person);
	}
	
	@FXML
	public void onBtnAllAction() {
		Person nome = cbx1.getValue();
		//Person nome = cbx1.valueProperty().get();
		System.out.println(nome);
	}
	
	
	
	public void onBtnSoma() {
		try {
		double value1 = Double.parseDouble(tx1.getText());
		double value2 = Double.parseDouble(tx2.getText());
		
		double result = value1 + value2;
		String format = String.format("%.2f", result); 
		Alerts.showAlert("Result", null,format, AlertType.INFORMATION);
		}catch(NumberFormatException e) {
			Alerts.showAlert("Error", null, e.getMessage(), AlertType.ERROR);
		}
	}
	
	public void onBtnAction() {{
			System.out.println("CLICKED");
			Alerts.showAlert("INFO", null," That's an info", AlertType.INFORMATION);
		}
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		//Constraints.setTextFieldDouble(tx1);
		//Constraints.setTextFieldDouble(tx2);
		
		List<Person> listP = new ArrayList<>();
		listP.add(new Person("Rafael", 1, "rafael@icloud.com"));
		
		obsList = FXCollections.observableArrayList(listP);
		cbx1.setItems(obsList);
		
		Callback<ListView<Person>, ListCell<Person>> factory = lv -> new ListCell<Person>() {
			@Override
			protected void updateItem(Person item, boolean empty) {
				super.updateItem(item, empty);
				setText( empty ? "" : item.getName());
			}
		};
		cbx1.setCellFactory(factory);
		cbx1.setButtonCell(factory.call(null));
		
	}
	
	
}
