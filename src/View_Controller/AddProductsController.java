/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View_Controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author michaelmarvive
 */
public class AddProductsController implements Initializable {
    @FXML
    private TextField addProductsID;
    @FXML
    private TextField addProductsName;
    @FXML
    private TextField addProductsInv;
    @FXML
    private TextField addProductsPrice;
    @FXML
    private TextField addProductsMax;
    @FXML
    private TextField addProductsMin;
    @FXML
    private TextField addProductsSearch;
    @FXML
    private Button addProductsSearchButton;
    @FXML
    private Button addProductsAddButton;
    @FXML
    private Button addProductsSaveButton;
    @FXML
    private Button addProductsDeleteButton;
    @FXML
    private Button addProductsCancelButton;





    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    public void addProductsAddButton(ActionEvent actionEvent) {
    }

    public void addProductsSaveButton(ActionEvent actionEvent) {
    }

    public void addProductsCancelButtonisPushed(ActionEvent actionEvent) throws IOException {
//        Goes back to Main Screen
        Parent tableViewParent = FXMLLoader.load(getClass().getClassLoader().getResource("View_Controller/MainScreen.fxml"));
        Scene tableViewScene = new Scene(tableViewParent);

        Stage window = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();

        window.setScene(tableViewScene);
        window.show();
    }

    public void addProductsDeleteButton(ActionEvent actionEvent) {
    }
}