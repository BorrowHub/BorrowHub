package Finals;

import java.io.File;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.swing.plaf.basic.BasicInternalFrameUI;

public class Borrow extends javax.swing.JInternalFrame {

    private final String INVENTORY_PATH_FULL = "C:\\BorrowHub\\BorrowHub\\src\\data\\inventory.txt";
    private final String BORROWED_PATH_FULL = "C:\\BorrowHub\\BorrowHub\\src\\data\\borrowed.txt";

 

    public Borrow() {
        initComponents();
        this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        BasicInternalFrameUI user = (BasicInternalFrameUI) this.getUI();
        user.setNorthPane(null);

        loadItemsToComboBox(); //Automatic Ibutang tanan items 
    }
    
   // Load items from inventory file into comboBox
    private void loadItemsToComboBox() {
             jComboBox2.removeAllItems();
        File f = new File(INVENTORY_PATH_FULL);
        if (!f.exists()) f = new File("inventory.txt");
        if (!f.exists()) return;

        try (BufferedReader br = new BufferedReader(new FileReader(f))) {
            String line;
            while ((line = br.readLine()) != null) {
                // Expect "Item | available | total"
                String[] parts = line.split("\\s*\\|\\s*");
                if (parts.length >= 1) {
                    String itemName = parts[0].trim();
                    // Optionally check available > 0
                    int available = parts.length >= 2 ? Integer.parseInt(parts[1].trim()) : 0;
                    if (available > 0) jComboBox2.addItem(itemName);
                    else {
                        // still add so user can borrow? we choose to add only available
                    }
                }
            }
        } catch (Exception ex) {
            javax.swing.JOptionPane.showMessageDialog(this, "Error loading inventory: " + ex.getMessage());
        }
    }
    
     // write borrow record to borrowed.txt and update inventory
    private void saveBorrowRecord(String studentID, String fullName, String item, int qty, String purpose, String borrowDate) {
        File file = new File(BORROWED_PATH_FULL);
        try {
            if (!file.exists()) file = new File("borrowed.txt");

            String record = studentID + " | " + fullName + " | " + item + " | " + qty + " | " + purpose + " | " + borrowDate;
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(file, true))) {
                bw.write(record);
                bw.newLine();
            }

            // decrement inventory available
            decrementInventory(item, qty);

            javax.swing.JOptionPane.showMessageDialog(this, "Borrow record saved.");
            loadItemsToComboBox(); // refresh combo box to reflect updated stock

        } catch (Exception ex) {
            javax.swing.JOptionPane.showMessageDialog(this, "Error saving borrow record: " + ex.getMessage());
        }
    }
    
        // decrement inventory available quantity
    private void decrementInventory(String itemName, int qtyBorrowed) {
        File file = new File(INVENTORY_PATH_FULL);
        if (!file.exists()) file = new File("inventory.txt");
        if (!file.exists()) return;

        ArrayList<String> lines = new ArrayList<>();
        
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) lines.add(line);
        } catch (Exception ex) {
            javax.swing.JOptionPane.showMessageDialog(this, "Error reading inventory: " + ex.getMessage());
            return;
        }

        boolean updated = false;
        for (int i = 0; i < lines.size(); i++) {
            String[] parts = lines.get(i).split("\\s*\\|\\s*");
            if (parts.length >= 3) {
                String name = parts[0].trim();
                int available = parseIntSafe(parts[1].trim(), 0);
                int total = parseIntSafe(parts[2].trim(), 0);
                if (name.equalsIgnoreCase(itemName)) {
                    available = Math.max(0, available - qtyBorrowed);
                    lines.set(i, name + " | " + available + " | " + total);
                    updated = true;
                    break;
                }
            }
        }
        if (!updated) {
            // If item not found, append (with negative effect avoided)
            lines.add(itemName + " | " + Math.max(0, -qtyBorrowed) + " | 0");
        }

        try (PrintWriter pw = new PrintWriter(new FileWriter(file, false))) {
            for (String l : lines) pw.println(l);
        } catch (Exception ex) {
            javax.swing.JOptionPane.showMessageDialog(this, "Error writing inventory: " + ex.getMessage());
        }
    }
    
        private int parseIntSafe(String s, int fallback) {
        try { return Integer.parseInt(s); } catch (Exception e) { return fallback; }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPasswordField1 = new javax.swing.JPasswordField();
        panelmain = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        Lusername = new javax.swing.JLabel();
        Lusername1 = new javax.swing.JLabel();
        TextFullname = new javax.swing.JTextField();
        Lusername2 = new javax.swing.JLabel();
        textStudentID = new javax.swing.JTextField();
        Lusername4 = new javax.swing.JLabel();
        Lusername5 = new javax.swing.JLabel();
        Textborrowdate = new javax.swing.JTextField();
        Lusername6 = new javax.swing.JLabel();
        Textpurpose = new javax.swing.JTextField();
        jComboBox2 = new javax.swing.JComboBox<>();
        Lusername7 = new javax.swing.JLabel();
        Lusername8 = new javax.swing.JLabel();
        Textquantity = new javax.swing.JTextField();
        bttnConfirm = new javax.swing.JButton();

        jPasswordField1.setText("jPasswordField1");

        setBorder(null);
        setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setVisible(true);

        panelmain.setBackground(new java.awt.Color(240, 255, 255));
        panelmain.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel2.setFont(new java.awt.Font("Segoe UI Black", 1, 24)); // NOI18N
        jLabel2.setText("Borrow Decoration Items");

        jLabel5.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(102, 102, 102));
        jLabel5.setText("Please fill out the form to borrow an item for your event.");

        Lusername.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
        Lusername.setText("Borrow Details");

        Lusername1.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        Lusername1.setText("Student ID");

        TextFullname.setBackground(new java.awt.Color(240, 255, 255));
        TextFullname.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        TextFullname.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        Lusername2.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        Lusername2.setText("Student Full Name");

        textStudentID.setBackground(new java.awt.Color(240, 255, 255));
        textStudentID.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        textStudentID.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        Lusername4.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        Lusername4.setText("Item");

        Lusername5.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        Lusername5.setText("Borrow Date");

        Textborrowdate.setBackground(new java.awt.Color(240, 255, 255));
        Textborrowdate.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        Textborrowdate.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        Lusername6.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        Lusername6.setText("Purpose");

        Textpurpose.setBackground(new java.awt.Color(240, 255, 255));
        Textpurpose.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        Textpurpose.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        jComboBox2.setBackground(new java.awt.Color(240, 255, 255));
        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        Lusername7.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
        Lusername7.setText("Student Information ");

        Lusername8.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        Lusername8.setText("Quantity");

        Textquantity.setBackground(new java.awt.Color(240, 255, 255));
        Textquantity.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        Textquantity.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        bttnConfirm.setBackground(new java.awt.Color(250, 217, 51));
        bttnConfirm.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        bttnConfirm.setText("Confirm");
        bttnConfirm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bttnConfirmActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelmainLayout = new javax.swing.GroupLayout(panelmain);
        panelmain.setLayout(panelmainLayout);
        panelmainLayout.setHorizontalGroup(
            panelmainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelmainLayout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(panelmainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Lusername7)
                    .addComponent(Lusername)
                    .addComponent(jLabel2)
                    .addComponent(jLabel5)
                    .addGroup(panelmainLayout.createSequentialGroup()
                        .addGroup(panelmainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Lusername4))
                        .addGap(32, 32, 32)
                        .addGroup(panelmainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Lusername8)
                            .addComponent(Textquantity, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(panelmainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(panelmainLayout.createSequentialGroup()
                            .addComponent(Textpurpose, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Textborrowdate, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(panelmainLayout.createSequentialGroup()
                            .addGroup(panelmainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(Lusername1)
                                .addComponent(textStudentID, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(Lusername6))
                            .addGap(45, 45, 45)
                            .addGroup(panelmainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(Lusername2)
                                .addComponent(TextFullname, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(Lusername5))))
                    .addComponent(bttnConfirm, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(55, Short.MAX_VALUE))
        );
        panelmainLayout.setVerticalGroup(
            panelmainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelmainLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(Lusername7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelmainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(textStudentID, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelmainLayout.createSequentialGroup()
                        .addGroup(panelmainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Lusername2)
                            .addComponent(Lusername1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TextFullname, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addComponent(Lusername)
                .addGap(12, 12, 12)
                .addGroup(panelmainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Lusername8)
                    .addComponent(Lusername4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelmainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(Textquantity, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelmainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelmainLayout.createSequentialGroup()
                        .addComponent(Lusername6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Textpurpose, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelmainLayout.createSequentialGroup()
                        .addComponent(Lusername5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Textborrowdate, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(31, 31, 31)
                .addComponent(bttnConfirm, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelmain, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelmain, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bttnConfirmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttnConfirmActionPerformed
        String studentID = TextFullname.getText();
        String fullName = textStudentID.getText();
        String item = jComboBox2.getSelectedItem().toString();
        String quantity = Textquantity.getText();
        String purpose = Textpurpose.getText();
        String borrowDate = Textborrowdate.getText();

        // Validate
        if (studentID.isEmpty() || fullName.isEmpty() || quantity.isEmpty() || purpose.isEmpty() || borrowDate.isEmpty()) {
            javax.swing.JOptionPane.showMessageDialog(this, "Please complete all fields!");
            return;
        }

        // Format record
        String record = studentID + " | "
                + fullName + " | "
                + item + " | "
                + quantity + " | "
                + purpose + " | "
                + borrowDate;

        // Save using file handling
        try (java.io.BufferedWriter writer = new java.io.BufferedWriter(new java.io.FileWriter("borrow_records.txt", true))) {
            writer.write(record);
            writer.newLine();
            javax.swing.JOptionPane.showMessageDialog(this, "Borrow request saved!");
        } catch (Exception e) {
            javax.swing.JOptionPane.showMessageDialog(this, "Error saving file: " + e.getMessage());
        }

        // Clear fields after saving  
        TextFullname.setText("");
        textStudentID.setText("");
        Textquantity.setText("");
        Textpurpose.setText("");
        Textborrowdate.setText("");
    }//GEN-LAST:event_bttnConfirmActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Lusername;
    private javax.swing.JLabel Lusername1;
    private javax.swing.JLabel Lusername2;
    private javax.swing.JLabel Lusername4;
    private javax.swing.JLabel Lusername5;
    private javax.swing.JLabel Lusername6;
    private javax.swing.JLabel Lusername7;
    private javax.swing.JLabel Lusername8;
    private javax.swing.JTextField TextFullname;
    private javax.swing.JTextField Textborrowdate;
    private javax.swing.JTextField Textpurpose;
    private javax.swing.JTextField Textquantity;
    private javax.swing.JButton bttnConfirm;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JPanel panelmain;
    private javax.swing.JTextField textStudentID;
    // End of variables declaration//GEN-END:variables
}
