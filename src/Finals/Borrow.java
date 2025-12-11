package Finals;

import java.io.File;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.FileReader;
import javax.swing.plaf.basic.BasicInternalFrameUI;


public class Borrow extends javax.swing.JInternalFrame {

    // Load items from inventory file into comboBox
private void loadItemsToComboBox() {
    jComboBox2.removeAllItems(); // Clear old items

    try (BufferedReader reader = new BufferedReader(new FileReader("inventory.txt"))) {

        String line;
        while ((line = reader.readLine()) != null) {
            String[] parts = line.split("\\|");

            if (parts.length >= 2) {
                String itemName = parts[0].trim();
                String quantity = parts[1].trim();

                // Only show items with available stock
                if (!quantity.equals("0")) {
                    jComboBox2.addItem(itemName);
                }
            }
        }

    } catch (Exception e) {
        javax.swing.JOptionPane.showMessageDialog(this, 
            "Error loading inventory: " + e.getMessage());
    }
}

    public Borrow() {
        initComponents();
        this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        BasicInternalFrameUI user = (BasicInternalFrameUI)this.getUI();
        user.setNorthPane(null);
        
        loadItemsToComboBox(); //Automatic Ibutang tanan items 
    }
    
    private void updateInventoryStock(String itemName, int qtyBorrowed) {
    try {
        File file = new File("inventory.txt");
        java.util.List<String> updatedLines = new java.util.ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;

            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("\\|");
                
                if (parts.length >= 2) {
                    String name = parts[0].trim();
                    int stock = Integer.parseInt(parts[1].trim());

                    if (name.equals(itemName)) {
                        stock = Math.max(0, stock - qtyBorrowed); // avoid negative
                        line = name + " | " + stock + " | " + parts[2].trim();
                    }
                }
                updatedLines.add(line);
            }
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            for (String updatedLine : updatedLines) {
                writer.write(updatedLine);
                writer.newLine();
            }
        }

        loadItemsToComboBox(); // refresh comboBox after reducing stock

    } catch (Exception e) {
        javax.swing.JOptionPane.showMessageDialog(this, 
            "Error updating inventory: " + e.getMessage());
    }
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
        Textusername1 = new javax.swing.JTextField();
        Lusername2 = new javax.swing.JLabel();
        Textusername2 = new javax.swing.JTextField();
        Lusername4 = new javax.swing.JLabel();
        Lusername5 = new javax.swing.JLabel();
        Textusername3 = new javax.swing.JTextField();
        Lusername6 = new javax.swing.JLabel();
        Textusername4 = new javax.swing.JTextField();
        jComboBox2 = new javax.swing.JComboBox<>();
        Lusername7 = new javax.swing.JLabel();
        Lusername8 = new javax.swing.JLabel();
        Textusername5 = new javax.swing.JTextField();
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

        Textusername1.setBackground(new java.awt.Color(240, 255, 255));
        Textusername1.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        Textusername1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        Lusername2.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        Lusername2.setText("Student Full Name");

        Textusername2.setBackground(new java.awt.Color(240, 255, 255));
        Textusername2.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        Textusername2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        Lusername4.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        Lusername4.setText("Item");

        Lusername5.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        Lusername5.setText("Borrow Date");

        Textusername3.setBackground(new java.awt.Color(240, 255, 255));
        Textusername3.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        Textusername3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        Lusername6.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        Lusername6.setText("Purpose");

        Textusername4.setBackground(new java.awt.Color(240, 255, 255));
        Textusername4.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        Textusername4.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        jComboBox2.setBackground(new java.awt.Color(240, 255, 255));
        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        Lusername7.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
        Lusername7.setText("Student Information ");

        Lusername8.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        Lusername8.setText("Quantity");

        Textusername5.setBackground(new java.awt.Color(240, 255, 255));
        Textusername5.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        Textusername5.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

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
                            .addComponent(Textusername5, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(panelmainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(panelmainLayout.createSequentialGroup()
                            .addComponent(Textusername4, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Textusername3, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(panelmainLayout.createSequentialGroup()
                            .addGroup(panelmainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(Lusername1)
                                .addComponent(Textusername2, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(Lusername6))
                            .addGap(21, 21, 21)
                            .addGroup(panelmainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(Lusername2)
                                .addGroup(panelmainLayout.createSequentialGroup()
                                    .addGap(24, 24, 24)
                                    .addGroup(panelmainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(Textusername1, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(Lusername5))))))
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
                    .addComponent(Textusername2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelmainLayout.createSequentialGroup()
                        .addGroup(panelmainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Lusername2)
                            .addComponent(Lusername1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Textusername1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addComponent(Lusername)
                .addGap(12, 12, 12)
                .addGroup(panelmainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Lusername8)
                    .addComponent(Lusername4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelmainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(Textusername5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelmainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelmainLayout.createSequentialGroup()
                        .addComponent(Lusername6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Textusername4, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelmainLayout.createSequentialGroup()
                        .addComponent(Lusername5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Textusername3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
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
    String studentID = Textusername1.getText();
    String fullName = Textusername2.getText();
    String item = jComboBox2.getSelectedItem().toString();
    String quantity = Textusername5.getText();
    String purpose = Textusername4.getText();
    String borrowDate = Textusername3.getText();

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
    Textusername1.setText("");
    Textusername2.setText("");
    Textusername5.setText("");
    Textusername4.setText("");
    Textusername3.setText("");
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
    private javax.swing.JTextField Textusername1;
    private javax.swing.JTextField Textusername2;
    private javax.swing.JTextField Textusername3;
    private javax.swing.JTextField Textusername4;
    private javax.swing.JTextField Textusername5;
    private javax.swing.JButton bttnConfirm;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JPanel panelmain;
    // End of variables declaration//GEN-END:variables
}
