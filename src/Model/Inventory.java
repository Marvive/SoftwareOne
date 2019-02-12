package Model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Inventory {

    private static ObservableList<Part> partInventory = FXCollections.observableArrayList();
    private static ObservableList<Product> productInventory = FXCollections.observableArrayList();
    private static int partIDCount = 0;
    private static int productIDCount = 0;

    public static int lookupProduct() {
        return 0;
    }

    public Inventory() {

    }

    public static void addPart(Part part) {
        partInventory.add(part);
    }
    public static void removePart(Part part) {
        partInventory.remove(part);
    }

    public static void updatePart(int index, Part part) {
        partInventory.set(index, part);
    }

    public static int getPartIDCount() {
        partIDCount++;
        return partIDCount;
    }
}
