package Model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;


public class InhousePart extends Part {

    private final IntegerProperty inhouseMachineID;
    public InhousePart(int partID, String partName, int inStock, double pricePerUnit) {
        super(partID, partName, inStock, pricePerUnit);
        inhouseMachineID = new SimpleIntegerProperty();
    }

    public void setMachineID(int inhouseMachineID) {
        this.inhouseMachineID.set(inhouseMachineID);
    }

    public int getPartMachineID() {
        return this.inhouseMachineID.get();
    }

}


//DONE
