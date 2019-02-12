/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View_Controller;

import java.awt.*;
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
public class ModifyProductsController implements Initializable {
    @FXML
    private TextField modifyProductsID;
    @FXML
    private TextField modifyProductsName;
    @FXML
    private TextField modifyProductsInv;
    @FXML
    private TextField modifyProductsPrice;
    @FXML
    private TextField modifyProductsMax;
    @FXML
    private TextField modifyProductsMin;
    @FXML
    private TextField modifyProductsSearch;
    @FXML
    private Button modifyProductsSearchButton;
    @FXML
    private Button modifyProductsAddButton;
    @FXML
    private Button modifyProductsSaveButton;
    @FXML
    private Button modifyProductsDeleteButton;
    @FXML
    private Button modifyProductsCancelButton;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    public void modifyProductsCancelButtonIsPushed(ActionEvent actionEvent) throws IOException {
//        Goes back to Main Screen
        Parent tableViewParent = FXMLLoader.load(getClass().getClassLoader().getResource("View_Controller/MainScreen.fxml"));
        Scene tableViewScene = new Scene(tableViewParent);

        Stage window = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();

        window.setScene(tableViewScene);
        window.show();
    }

}
