// Mogowane Tlaleng Tshepo - 25003052 - COM 1321
// BRIGHT FUTURE TECHNOLOGIES APPLICATION - FINAL CORRECTED VERSION FROM VIDEO

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Products app = new Products();
        System.out.println("\nBRIGHT FUTURE TECHNOLOGIES APPLICATION");
        System.out.println("****************************************");
        System.out.println("Student: Mogowane Tlaleng Tshepo - 25003052");
        while(!app.quit()) {
            app.menu();
        }
        System.out.println("Application Exited. Goodbye!");
    }
}

class ReportData {
    private String productID;
    private String productTitle;
    private String productType;
    private String productVendor;
    private String warrantyGuarantee;
    private double productCost;
    private int stockQuantity;

    public ReportData(String id, String title, String type, String vendor, String guarantee, double cost, int quantity) {
        this.productID = id;
        this.productTitle = title;
        this.productType = type;
        this.productVendor = vendor;
        this.warrantyGuarantee = guarantee;
        this.productCost = cost;
        this.stockQuantity = quantity;
    }

    public void setGuarantee(String guarantee) { this.warrantyGuarantee = guarantee; }
    public void setCost(double cost) { this.productCost = cost; }
    public void setQuantity(int quantity) { this.stockQuantity = quantity; }

    public String getID() { return productID; }
    public String getTitle() { return productTitle; }
    public String getType() { return productType; }
    public String getVendor() { return productVendor; }
    public String getGuarantee() { return warrantyGuarantee; }
    public double getCost() { return productCost; }
    public int getQuantity() { return stockQuantity; }
}

class Products {
    private Scanner scanner = new Scanner(System.in);
    private ReportData[] items = new ReportData[100];
    private static int totalItems = 0;
    private boolean quitFlag = false;

    public boolean quit() { return quitFlag; }

    public void menu() {
        System.out.println("\nPlease select one of the following menu items:");
        System.out.println("(1) Capture a new product.");
        System.out.println("(2) Search for a product.");
        System.out.println("(3) Update a product.");
        System.out.println("(4) Delete a product.");
        System.out.println("(5) Print Report.");
        System.out.println("(6) Exit Application");
        System.out.print(">> ");
        String option = scanner.nextLine();

        if(option.equals("1")) create();
        else if(option.equals("2")) search();
        else if(option.equals("3")) update();
        else if(option.equals("4")) delete();
        else if(option.equals("5")) report();
        else if(option.equals("6")) quitFlag = true;
        else System.out.println("Invalid option!");
    }

    private void create() {
        System.out.print("Enter Product ID: "); String id = scanner.nextLine();
        System.out.print("Enter Title: "); String title = scanner.nextLine();
        System.out.print("Enter Type: "); String type = scanner.nextLine();
        System.out.print("Enter Vendor: "); String vendor = scanner.nextLine();
        System.out.print("Enter Guarantee: "); String guarantee = scanner.nextLine();
        System.out.print("Enter Cost: "); double cost = Double.parseDouble(scanner.nextLine());
        System.out.print("Enter Quantity: "); int qty = Integer.parseInt(scanner.nextLine());

        items[totalItems] = new ReportData(id, title, type, vendor, guarantee, cost, qty);
        totalItems++;
        System.out.println("Product captured successfully!");
    }

    private void search() {
        System.out.print("Enter Product ID to search: "); String id = scanner.nextLine();
        for(int i=0; i<totalItems; i++){
            if(items[i].getID().equalsIgnoreCase(id)){
                System.out.println("Found: " + items[i].getTitle() + " | Cost: " + items[i].getCost() + " | Qty: " + items[i].getQuantity());
                return;
            }
        }
        System.out.println("Product not found!");
    }

    private void update() {
        System.out.print("Enter Product ID to update: "); String id = scanner.nextLine();
        for(int i=0; i<totalItems; i++){
            if(items[i].getID().equalsIgnoreCase(id)){
                System.out.print("New Guarantee: "); items[i].setGuarantee(scanner.nextLine());
                System.out.print("New Cost: "); items[i].setCost(Double.parseDouble(scanner.nextLine()));
                System.out.print("New Quantity: "); items[i].setQuantity(Integer.parseInt(scanner.nextLine()));
                System.out.println("Updated!");
                return;
            }
        }
        System.out.println("Product not found!");
    }

    private void delete() {
        System.out.print("Enter Product ID to delete: "); String id = scanner.nextLine();
        for(int i=0; i<totalItems; i++){
            if(items[i].getID().equalsIgnoreCase(id)){
                for(int j=i; j<totalItems-1; j++) items[j] = items[j+1];
                totalItems--;
                System.out.println("Deleted!");
                return;
            }
        }
        System.out.println("Product not found!");
    }

    private void report() {
        System.out.println("\n--- BRIGHT FUTURE TECHNOLOGIES REPORT ---");
        if(totalItems == 0) System.out.println("No products captured yet.");
        for(int i=0; i<totalItems; i++){
            ReportData r = items[i];
            System.out.println(r.getID() + " | " + r.getTitle() + " | " + r.getType() + " | " + r.getVendor() + " | " + r.getGuarantee() + " | " + r.getCost() + " | " + r.getQuantity());
        }
    }
}
