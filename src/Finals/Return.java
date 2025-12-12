package Finals;

import java.io.*;
import java.util.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.plaf.basic.BasicInternalFrameUI;

public class Return extends javax.swing.JInternalFrame {

    ArrayList<BorrowedItem> borrowedList = new ArrayList<>();

    public Return() {
        initComponents();
        this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        BasicInternalFrameUI ui = (BasicInternalFrameUI) this.getUI();
        ui.setNorthPane(null);
        loadBorrowedItems();
    }

    // LOAD BORROWED ITEMS FROM FILE
    private void loadBorrowedItems() {

        borrowedList.clear();
        DefaultTableModel model = (DefaultTableModel) jTablereturn.getModel();
        model.setRowCount(0);

        File file = new File("borrow_records.txt");
        if (!file.exists()) file = new File("borrowed.txt");
        if (!file.exists()) return;

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {

            String line;
            while ((line = br.readLine()) != null) {

                String[] data = line.split("\\s*\\|\\s*|\\s*,\\s*");

                if (data.length >= 6) {
                    // Ang Format: studentID | fullName | item | qty | purpose | date
                    BorrowedItem b = new BorrowedItem(
                            data[0].trim(),
                            data[1].trim(),
                            data[2].trim(),
                            parseIntSafe(data[3].trim(), 1),
                            data[4].trim(),
                            data[5].trim()
                    );

                    borrowedList.add(b);

                    model.addRow(new Object[]{
                        b.getItem(), // Item Name
                        b.getqty(),
                        b.getStudentID(), // Student ID
                        b.getFullName(), // Student Name
                        b.getBorrowDate() // Borrow Date
                    });

                } else if (data.length >= 3) {
                    // fallback: name, item, qty
                    BorrowedItem b = new BorrowedItem(
                            "",
                            data[0].trim(),
                            data[1].trim(),
                            parseIntSafe(data[2].trim(), 1),
                            "",
                            ""
                    );

                    borrowedList.add(b);

                    model.addRow(new Object[]{
                        b.getItem(), // Item Name
                        b.getStudentID(), // Student ID
                        b.getFullName(), // Student Name
                        b.getBorrowDate() // Borrow Date
                    });
                }
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error loading records: " + e.getMessage());
        }
    }

    private int parseIntSafe(String s, int fallback) {
        try { return Integer.parseInt(s); }
        catch (Exception e) { return fallback; }
    }


    // SAVE UPDATED BORROWED LIST BACK TO FILE
    private void saveBorrowedList() {
        String path = "C:\\BorrowHub\\BorrowHub\\src\\data\\borrow_records.txt";
        File ret = new File(path);//gi named nato ang path to ret

        try (PrintWriter pw = new PrintWriter(new FileWriter(ret))) {

            for (BorrowedItem b : borrowedList) {
                pw.println(b.getStudentID() + " | " + b.getFullName()
                        + " | " + b.getItem()
                        + " | " + b.getQuantity()
                        + " | " + b.getPurpose()
                        + " | " + b.getBorrowDate());
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(
                    this, "Error saving borrowed list: " + e.getMessage());
        }
    }

    // RETURN ITEM — ADD BACK TO INVENTORY
    private void returnToInventory(String itemName, int qty) {

        File file = new File("inventory.txt");
        ArrayList<InventoryItem> items = new ArrayList<>();

        try {

            if (file.exists()) {
                BufferedReader br = new BufferedReader(new FileReader(file));
                String line;

                while ((line = br.readLine()) != null) {
                    String[] p = line.split("\\s*\\|\\s*|\\s*,\\s*");

                    if (p.length >= 3) {
                        items.add(new InventoryItem(
                                p[0].trim(),
                                parseIntSafe(p[1].trim(), 0),
                                p[2].trim()));
                    }
                }

                br.close();
            }

            boolean found = false;

            for (InventoryItem it : items) {
                if (it.getName().equalsIgnoreCase(itemName)) {
                    it.setQuantity(it.getQuantity() + qty);
                    found = true;
                }
            }

            if (!found) {
                items.add(new InventoryItem(itemName, qty, "Returned"));
            }

            PrintWriter pw = new PrintWriter(new FileWriter(file));

            for (InventoryItem it : items) {
                pw.println(it.getName() + "," + it.getQuantity() + "," + it.getCategory());
            }

            pw.close();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error updating inventory: " + e.getMessage());
        }
    }

    // DELETE BORROWED ENTRY
    private void deleteBorrowed(int index) {
        if (index >= 0 && index < borrowedList.size()) {
            borrowedList.remove(index);
            saveBorrowedList();
            loadBorrowedItems();
        }
    }

    // INNER CLASSES 
    private class BorrowedItem {
        private final String studentID;
        private final String fullName;
        private final String item;
        private final int quantity;
        private final String purpose;
        private final String borrowDate;

        public BorrowedItem(String studentID, String fullName,
                String item, int quantity, String purpose, String borrowDate) {

            this.studentID = studentID;
            this.fullName = fullName;
            this.item = item;
            this.quantity = quantity;
            this.purpose = purpose;
            this.borrowDate = borrowDate;
        }

        public String getStudentID() { return studentID; }
        public String getFullName() { return fullName; }
        public String getItem() { return item; }
        public int getQuantity() { return quantity; }
        public String getPurpose() { return purpose; }
        public String getBorrowDate() { return borrowDate; }
    }

    private class InventoryItem {
        private final String name;
        private int quantity;
        private final String category;

        public InventoryItem(String name, int quantity, String category) {
            this.name = name;
            this.quantity = quantity;
            this.category = category;
        }

        public String getName() { return name; }
        public int getQuantity() { return quantity; }
        public String getCategory() { return category; }

        public void setQuantity(int q) { this.quantity = q; }
    }
    
    // SAVE RETURN RECORD (APPEND TO borrow_records.txt)
private void saveReturnRecord(BorrowedItem b) {

    String path = "C:\\BorrowHub\\BorrowHub\\src\\data\\borrow_records.txt";
    File file = new File(path);

    String returnDate = java.time.LocalDate.now().toString();

    try (PrintWriter pw = new PrintWriter(new FileWriter(file, true))) {

        pw.println(
                b.getStudentID() + " | "
                + b.getFullName() + " | "
                + b.getItem() + " | "
                + b.getQuantity() + " | "
                + b.getPurpose() + " | "
                + b.getBorrowDate() + " | "
                + returnDate
        );

    } catch (Exception e) {
        JOptionPane.showMessageDialog(
                this, "Error saving return record: " + e.getMessage());
    }
}


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField1 = new javax.swing.JTextField();
        panelmain = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        Lusername7 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTablereturn = new javax.swing.JTable();
        jButtonexit = new javax.swing.JButton();

        jTextField1.setText("jTextField1");

        setBorder(null);
        setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setVisible(true);

        panelmain.setBackground(new java.awt.Color(240, 255, 255));
        panelmain.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel2.setFont(new java.awt.Font("Segoe UI Black", 1, 24)); // NOI18N
        jLabel2.setText("Return an Item");

        jLabel5.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(102, 102, 102));
        jLabel5.setText("Search for and select the item you wish to return");

        Lusername7.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
        Lusername7.setText("Borrowed Items");

        jTablereturn.setBackground(new java.awt.Color(240, 255, 255));
        jTablereturn.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jTablereturn.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Item Name", "Quantity", "Student ID", "Student Name", "Borrow Date"
            }
        ));
        jScrollPane1.setViewportView(jTablereturn);

        jButtonexit.setBackground(new java.awt.Color(250, 217, 51));
        jButtonexit.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButtonexit.setText("Return");
        jButtonexit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonexitActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelmainLayout = new javax.swing.GroupLayout(panelmain);
        panelmain.setLayout(panelmainLayout);
        panelmainLayout.setHorizontalGroup(
            panelmainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelmainLayout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(panelmainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelmainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(panelmainLayout.createSequentialGroup()
                            .addComponent(Lusername7)
                            .addGap(353, 353, 353))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 496, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelmainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel2)
                        .addComponent(jLabel5)
                        .addGroup(panelmainLayout.createSequentialGroup()
                            .addGap(384, 384, 384)
                            .addComponent(jButtonexit, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(45, Short.MAX_VALUE))
        );
        panelmainLayout.setVerticalGroup(
            panelmainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelmainLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47)
                .addComponent(Lusername7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButtonexit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(26, 26, 26))
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

    private void jButtonexitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonexitActionPerformed
         int selected = jTablereturn.getSelectedRow();
        if (selected < 0) {
            JOptionPane.showMessageDialog(this, "Select an item to return!");
            return;
        }

        BorrowedItem b = borrowedList.get(selected);

        int confirm = JOptionPane.showConfirmDialog(this,
                "Return (" + b.getQuantity() + ") " + b.getItem() + "?",
                "Confirm",
                JOptionPane.YES_NO_OPTION);

        if (confirm == JOptionPane.YES_OPTION) {
            saveReturnRecord(b);
            returnToInventory(b.getItem(), b.getQuantity());
            deleteBorrowed(selected);
            JOptionPane.showMessageDialog(this, "Item returned successfully!");
        }
    

    }//GEN-LAST:event_jButtonexitActionPerformed

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Lusername7;
    private javax.swing.JButton jButtonexit;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTablereturn;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JPanel panelmain;
    // End of variables declaration//GEN-END:variables
}
