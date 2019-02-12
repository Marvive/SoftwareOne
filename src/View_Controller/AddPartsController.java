/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View_Controller;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import Model.InhousePart;
import Model.Inventory;
import Model.OutsourcedPart;
import Model.Part;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import View_Controller.MainScreenController;

/**
 * FXML Controller class
 *
 * @author michaelmarvive
 */
public class AddPartsController implements Initializable {
    @FXML
    private Button addPartSaveButton;
    @FXML
    private Button addPartCancelButton;


//    These instance variables are for adding parts
    @FXML
    private TextField addPartID;
    @FXML
    private TextField addPartName;
    @FXML
    private TextField addPartInv;
    @FXML
    private TextField addPartPrice;
    @FXML
    private TextField addPartMax;
    @FXML
    private TextField addPartDynamicField;
    @FXML
    private TextField addPartMin;
    @FXML
    private Label dynamicLabel;
    private int partID;





//    This is for the radio buttons
    @FXML
    private ToggleGroup inOutToggleGroup = new ToggleGroup();
    @FXML
    private RadioButton addPartInHouseRadioButton = new RadioButton();
    @FXML
    private RadioButton addPartOutsourcedRadioButton = new RadioButton();


//    This is for validating the part and determining whether In or Out
    private String exceptionMsg;
    private boolean isInHouse;


//    Buttons
    /**
     * This method will create a new Part object and add it to the table.
     * This may need to be added to the Add Part Class
     *
     *
     *
     *
     *
     * @return
     */


//    Creates new Part Objects
    public void addPartSaveButtonPushed(javafx.event.ActionEvent event) throws IOException{
//        Creates variables to be passed into the try and catch
        String partName = addPartName.getText();
        String partInv = addPartInv.getText();
        String pricePerUnit = addPartPrice.getText();
        String partMax = addPartMax.getText();
        String partMin = addPartMin.getText();
        String partDynamic = addPartDynamicField.getText();

        try {
//            This uses the error message found in Part.Java to determine what shows up on the screen when an error is thrown. We use the .length() to be able to determine if an error is present or not.
            exceptionMsg = Part.isPartValid(partName, Integer.parseInt(partInv), Integer.parseInt(partMin), Integer.parseInt(partMax), Double.parseDouble(pricePerUnit), exceptionMsg );
            if (exceptionMsg.length() > 0) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Error");
                alert.setHeaderText("Error");
                alert.setContentText(exceptionMsg);
                alert.showAndWait();
                exceptionMsg = "";
            } else {
                if (isInHouse) {
                    InhousePart inPart = new InhousePart(partID, partName, Integer.parseInt(partInv), Double.parseDouble(pricePerUnit));
                    inPart.setPartID(partID);
                    inPart.setPartName(partName);
                    inPart.setPricePerUnit(Double.parseDouble(pricePerUnit));
                    inPart.setInStock(Integer.parseInt(partInv));
                    inPart.setMin(Integer.parseInt(partMin));
                    inPart.setMax(Integer.parseInt(partMax));
                    inPart.setMachineID(Integer.parseInt(partDynamic));
                    Inventory.addPart(inPart);

                } else {
                    OutsourcedPart outPart = new OutsourcedPart(partID, partName, Integer.parseInt(partInv), Double.parseDouble(pricePerUnit));
                    outPart.setPartID(partID);
                    outPart.setPartName(partName);
                    outPart.setPricePerUnit(Double.parseDouble(pricePerUnit));
                    outPart.setInStock(Integer.parseInt(partInv));
                    outPart.setMin(Integer.parseInt(partMin));
                    outPart.setMax(Integer.parseInt(partMax));
                    outPart.setCompanyName(partDynamic);
                    Inventory.addPart(outPart);
                }
//                Adjust Here
                Parent saveToMain = FXMLLoader.load(getClass().getResource("MainScreen.fxml"));
                Scene scene = new Scene(saveToMain);
                Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
                window.setScene(scene);
                window.show();
            }
        } catch (NumberFormatException e) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Error Adding Part");
            alert.setHeaderText("Error");
            alert.setContentText("All fields Required");
            alert.showAndWait();
        }
    }




    public void addPartCancelButtonPushed(javafx.event.ActionEvent actionEvent) throws IOException {
//      Goes back to the main screen
        Parent tableViewParent = FXMLLoader.load(getClass().getClassLoader().getResource("View_Controller/MainScreen.fxml"));
        Scene tableViewScene = new Scene(tableViewParent);

        Stage window = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();

        window.setScene(tableViewScene);
        window.show();

    }

//    Radio Buttons

    public void addPartInHouseRadioButtonPushed(ActionEvent event){
        isInHouse = true;
        dynamicLabel.setText("Company Name");
    }

    public void addPartOutsourceRadioButtonPushed(ActionEvent event){
        isInHouse = false;
        dynamicLabel.setText("Machine ID");
    }

//    public void radioButtonChanged(){
//        if (this.inOutToggleGroup.getSelectedToggle().equals(addPartInHouseRadioButton))
////
//            ;
//        if (this.inOutToggleGroup.getSelectedToggle().equals(addPartOutsourcedRadioButton))
////
//            ;
//    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO

        inOutToggleGroup = new ToggleGroup();
        this.addPartInHouseRadioButton.setToggleGroup(inOutToggleGroup);
        this.addPartOutsourcedRadioButton.setToggleGroup(inOutToggleGroup);
        addPartInHouseRadioButton.setSelected(true);


    }

}
