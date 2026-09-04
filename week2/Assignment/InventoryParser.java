public class InventoryParser {
    public void parseInventoryRecord(String csvLine) {
        String[] fields = csvLine.split(",");
        
        if (fields.length != 3) {
            System.out.println("Invalid Record");
        } else {
            System.out.println("Product: " + fields[0].trim() + 
                               " | SKU: " + fields[1].trim() + 
                               " | Qty: " + fields[2].trim());
        }
    }
}