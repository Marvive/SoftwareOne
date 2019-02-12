/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View_Controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author michaelmarvive
 */
public class ModifyPartsController implements Initializable {
    @FXML
    private Button modifyPartSaveButton;
    @FXML
    private Button modifyPartCancelButton;
    @FXML
    private RadioButton modifyPartInHouseRadioButton;
    @FXML
    private RadioButton modifyPartOutsourcedRadioButton;
    @FXML
    private TextField modifyPartID;
    @FXML
    private TextField modifyPartName;
    @FXML
    private TextField modifyPartInv;
    @FXML
    private TextField modifyPartPrice;
    @FXML
    private TextField modifyPartMax;
    @FXML
    private TextField modifyPartCompanyName;
    @FXML
    private TextField modifyPartMin;

    private ToggleGroup inOutToggleGroup;



    public void radioButtonChanged(){
        if (this.inOutToggleGroup.getSelectedToggle().equals(modifyPartInHouseRadioButton))
//
            ;
        if (this.inOutToggleGroup.getSelectedToggle().equals(modifyPartOutsourcedRadioButton))
//
            ;
    }

    public void modifyPartCancelButtonPushed(javafx.event.ActionEvent actionEvent) throws IOException {
//      Goes back to the main screen
        Parent tableViewParent = FXMLLoader.load(getClass().getClassLoader().getResource("View_Controller/MainScreen.fxml"));
        Scene tableViewScene = new Scene(tableViewParent);

        Stage window = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();

        window.setScene(tableViewScene);
        window.show();

    }




    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        inOutToggleGroup = new ToggleGroup();
        this.modifyPartInHouseRadioButton.setToggleGroup(inOutToggleGroup);
        this.modifyPartOutsourcedRadioButton.setToggleGroup(inOutToggleGroup);
        
        
        
    }

}
