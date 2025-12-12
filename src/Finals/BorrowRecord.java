package Finals;

public class BorrowRecord {

    private String studentID;
    private String studentName;
    private String itemName;
    private int quantity;
    private String purpose;
    private String borrowDate;
    private String returnDate; // null until returned

    public BorrowRecord(String studentID, String studentName, String itemName,
                        int quantity, String purpose, String borrowDate) {
        this.studentID = studentID;
        this.studentName = studentName;
        this.itemName = itemName;
        this.quantity = quantity;
        this.purpose = purpose;
        this.borrowDate = borrowDate;
        this.returnDate = "";
    }

    // FULL constructor (used when loading returned history)
    public BorrowRecord(String studentID, String studentName, String itemName,
                        int quantity, String purpose, String borrowDate, String returnDate) {
        this.studentID = studentID;
        this.studentName = studentName;
        this.itemName = itemName;
        this.quantity = quantity;
        this.purpose = purpose;
        this.borrowDate = borrowDate;
        this.returnDate = returnDate;
    }

    // GETTERS
    public String getStudentID() { return studentID; }
    public String getStudentName() { return studentName; }
    public String getItemName() { return itemName; }
    public int getQuantity() { return quantity; }
    public String getPurpose() { return purpose; }
    public String getBorrowDate() { return borrowDate; }
    public String getReturnDate() { return returnDate; }

    // SETTERS
    public void setReturnDate(String returnDate) {
        this.returnDate = returnDate;
    }

    // Convert to CSV format for saving
    public String toCSV() {
        return studentID + "," + studentName + "," + itemName + "," + quantity + "," +
                purpose + "," + borrowDate + "," + returnDate;
    }

    // Parse CSV line into BorrowRecord
    public static BorrowRecord fromCSV(String line) {
        String[] d = line.split(",");
        if (d.length < 6) return null;

        if (d.length == 6) {
            // no return date yet → still borrowed
            return new BorrowRecord(d[0], d[1], d[2], Integer.parseInt(d[3]), d[4], d[5]);
        }
        return new BorrowRecord(d[0], d[1], d[2], Integer.parseInt(d[3]), d[4], d[5], d[6]);
    }
}
