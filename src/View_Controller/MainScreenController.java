/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View_Controller;

import java.awt.event.ActionEvent;
import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

import Model.Inventory;
import Model.Part;
import Model.Product;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author michaelmarvive
 */
@SuppressWarnings("ALL")
public class MainScreenController implements Initializable {

    @FXML
    private Button mainScreenPartAddButton;
    @FXML
    private Button mainScreenPartModifyButton;
    @FXML
    private Button mainScreenPartDeleteButton;
    @FXML
    private Button mainScreenProductAddButton;
    @FXML
    private Button mainScreenProductModifyButton;
    @FXML
    private Button mainScreenProductDeleteButton;
    @FXML
    private Button mainScreenExitButton;
    @FXML
    private Button mainScreenPartSearchButton;
    @FXML
    private Button mainScreenProductSearchButton;
    @FXML
    private TextField mainScreenProductSearchTextField;
    @FXML
    private TextField mainScreenPartSearchTextField;
    @FXML
    private TableView<Part> partTableView;
    @FXML
    private TableView<Part> modifyTableView;
    @FXML
    private TableColumn<Part, Integer> partIDColumn;
    @FXML
    private TableColumn<Part, String> partNameColumn;
    @FXML
    private TableColumn<Part, Integer> partInventoryLevelColumn;
    @FXML
    private TableColumn<Part, String> partPricePerUnitColumn;
    @FXML
    private TableColumn<Part, Integer> productIDColumn;
    @FXML
    private TableColumn<Part, String> productNameColumn;
    @FXML
    private TableColumn<Part, Integer> productInventoryLevelColumn;
    @FXML
    private TableColumn<Part, String> productPricePerUnitColumn;

    // Other Variables
    private static Part modifyPart;
    private static int modifyPartIndex;
    private static Product modifyProduct;
    private static int modifyProductIndex;

    // Methods for the screen
    /**
     * When this method is called, it will change the scene to Part Add Screen
     */



    public void mainScreenPartAddButtonPushed(javafx.event.ActionEvent actionEvent) throws IOException {
//        Go to Add Part Screen
//        In order to get these working, I had to add a "getClassLoader()" method
        Parent tableViewParent = FXMLLoader.load(getClass().getClassLoader().getResource("View_Controller/AddParts.fxml"));
        Scene tableViewScene = new Scene(tableViewParent);

        Stage window = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();

        window.setScene(tableViewScene);
        window.show();
    }

    public void mainScreenPartModifyButtonPushed(javafx.event.ActionEvent actionEvent) throws IOException {
//        Go to Add Modify Screen
        Parent tableViewParent = FXMLLoader.load(getClass().getClassLoader().getResource("View_Controller/ModifyParts.fxml"));
        Scene tableViewScene = new Scene(tableViewParent);

        Stage window = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();

        window.setScene(tableViewScene);
        window.show();
    }

    @FXML
    public void mainScreenPartDeleteButtonPushed() throws IOException {
//        Delete Line Item
        Part part = partTableView.getSelectionModel().getSelectedItem();

    }

    @FXML
    public void mainScreenProductAddButtonPushed(javafx.event.ActionEvent actionEvent) throws IOException {
//        Go to Add Product Screen
        Parent tableViewParent = FXMLLoader.load(getClass().getClassLoader().getResource("View_Controller/AddProducts.fxml"));
        Scene tableViewScene = new Scene(tableViewParent);

        Stage window = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();

        window.setScene(tableViewScene);
        window.show();
    }

    @FXML
    public void mainScreenProductModifyButtonPushed(javafx.event.ActionEvent actionEvent) throws IOException {
//        Go to Modify Product Screen
        Parent tableViewParent = FXMLLoader.load(getClass().getClassLoader().getResource("View_Controller/ModifyProducts.fxml"));
        Scene tableViewScene = new Scene(tableViewParent);

        Stage window = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();

        window.setScene(tableViewScene);
        window.show();
    }

    @FXML
    public void mainScreenProductDeleteButtonPushed(){
//        Delete Line Item
    }

    @FXML
    public void mainScreenPartSearchButtonButtonPushed(){
//        Searches the items added??
    }

    @FXML
    public void mainScreenProductSearchButtonPushed(){
//        Searches the items added??
        String productSearch = mainScreenProductSearchTextField.getText();
        int productIndex = -1;
        if (Inventory.lookupProduct() == -1 ){

        }
    }

    @FXML
    void mainScreenExitButtonPushed(){
//        Exits program
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.initModality(Modality.NONE);
        alert.setTitle("Exit");
        alert.setHeaderText("Exiting Program!");
        alert.setContentText("Press OK to exit the Program");
        Optional<ButtonType> result = alert.showAndWait();

        if (result.get() == ButtonType.OK) {
            System.exit(0);
        } else {
            System.out.println("Cancelled Exit");
        }
    }




    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        // This section sets up the columns for the part tableview
        partIDColumn.setCellValueFactory(new PropertyValueFactory<Part, Integer>("partID"));
        partNameColumn.setCellValueFactory(new PropertyValueFactory<Part, String>("partID"));
        partInventoryLevelColumn.setCellValueFactory(new PropertyValueFactory<Part, Integer>("partID"));
        partPricePerUnitColumn.setCellValueFactory(new PropertyValueFactory<Part, String>("partID"));



    }














    //  This section is to create the getPart method. Change people?
    public ObservableList<Part> getPart() {
        ObservableList<Part> people = FXCollections.observableArrayList();
//        Test Data
//        people.add(new Part("1", "2","2","1"));
//        people.add(new Part("1", "Part", "1", "$5"));
//        people.add(new Part("1", "Bob", "1", "$5"));

        return people;
    }

}
