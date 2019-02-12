package Model;

import javafx.beans.property.*;

public abstract class Part {

//     Instance variables
    private SimpleStringProperty  partName;
    private SimpleIntegerProperty partID, min, max, inStock;
    private SimpleDoubleProperty pricePerUnit;
//    Constructor
    public Part(int partID, String partName, int inStock, double pricePerUnit) {

        this.partID = new SimpleIntegerProperty(partID);
        this.partName = new SimpleStringProperty(partName);
        this.inStock = new SimpleIntegerProperty(inStock);
        this.pricePerUnit = new SimpleDoubleProperty(pricePerUnit);
        this.min = new SimpleIntegerProperty();
        this.max = new SimpleIntegerProperty();
    }




//    Setters and Getters
    public int getPartID() {
        return partID.get();
    }

    public IntegerProperty partIDProperty() {
        return partID;
    }

    public void setPartID(int partID) {
        this.partID.set(partID);
    }

    public String getPartName() {
        return partName.get();
    }

    public SimpleStringProperty partNameProperty() {
        return partName;
    }

    public void setPartName(String partName) {
        this.partName.set(partName);
    }

    public int getInStockLevel() {
        return inStock.get();
    }

    public SimpleIntegerProperty inStockProperty() {
        return inStock;
    }

    public void setInStock(int inStock) {
        this.inStock.set(inStock);
    }

    public double getPricePerUnit() {
        return pricePerUnit.get();
    }

    public SimpleDoubleProperty pricePerUnitProperty() {
        return pricePerUnit;
    }

    public void setPricePerUnit(double pricePerUnit) {
        this.pricePerUnit.set(pricePerUnit);
    }

    public int getMin() {
        return min.get();
    }

    public int getMax() {
        return max.get();
    }

    public void setMin(int min) {
        this.min.set(min);
    }

    public void setMax(int max) {
        this.max.set(max);
    }



    //    Method for validating Part. We use a += here to append to the errorMsg in case there are more than one errors
    public static String isPartValid(String name, int inventory, int min, int max, double price, String errorMsg) {
        if (name == null) {
            errorMsg += " Please enter a Name. ";
        }
        if (inventory < 1) {
            errorMsg += " Inventory must be greater than 0. ";
        }
        if (price < 1) {
            errorMsg += " Price must be greater than 0. ";
        }
        if (min > max) {
            errorMsg += " Min cannot be greater than Max ";
        }
        if (inventory < min || inventory > max) {
            errorMsg = "Inventory must be in between Min and Max";
        }
        System.out.println(errorMsg);
        return errorMsg;
    }




}
