package Finals;

import java.io.*;
import java.util.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.plaf.basic.BasicInternalFrameUI;

public class Return extends javax.swing.JInternalFrame {

    private final String BORROWED_PATH_FULL = "C:\\BorrowHub\\BorrowHub\\src\\data\\borrowed.txt";
    private final String RETURNED_PATH_FULL = "C:\\BorrowHub\\BorrowHub\\src\\data\\returned.txt";
    private final String INVENTORY_PATH_FULL = "C:\\BorrowHub\\BorrowHub\\src\\data\\inventory.txt";

    LinkedList<BorrowedItem> borrowedList = new LinkedList<>();

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

        File file = new File(BORROWED_PATH_FULL);
        if (!file.exists()) {
            file = new File("borrowed.txt");
            if (!file.exists()) {
                return;
            }
        }

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                // Expecting "studentID | fullName | item | qty | purpose | borrowDate"
                String[] parts = line.split("\\s*\\|\\s*");
                if (parts.length >= 6) {
                    BorrowedItem b = new BorrowedItem(
                            parts[0].trim(),
                            parts[1].trim(),
                            parts[2].trim(),
                            parseIntSafe(parts[3].trim(), 1),
                            parts[4].trim(),
                            parts[5].trim()
                    );
                    borrowedList.add(b);
                }
            }

            // Use bubble sort (as requested) by item name (case-insensitive)
            bubbleSortByItem(borrowedList);

            // populate table in the order you requested:
            // Student ID | Student Name | Item Name | Quantity | Borrow Date
            for (BorrowedItem b : borrowedList) {
                model.addRow(new Object[]{
                    b.getStudentID(),
                    b.getFullName(),
                    b.getItem(),
                    b.getQuantity(),
                    b.getBorrowDate()
                });
            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error loading borrowed items: " + ex.getMessage());
        }
    }

    // Bubble sort for LinkedList by item (small lists OK)
    private void bubbleSortByItem(LinkedList<BorrowedItem> list) {
        if (list == null || list.size() < 2) {
            return;
        }
        boolean swapped;
        int n = list.size();
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - 1 - i; j++) {
                BorrowedItem a = list.get(j);
                BorrowedItem b = list.get(j + 1);
                if (a.getItem().compareToIgnoreCase(b.getItem()) > 0) {
                    // swap
                    BorrowedItem tmp = list.get(j);
                    list.set(j, list.get(j + 1));
                    list.set(j + 1, tmp);
                    swapped = true;
                }
            }
            if (!swapped) {
                break;
            }
        }
    }

    private int parseIntSafe(String s, int fallback) {
        try {
            return Integer.parseInt(s);
        } catch (Exception e) {
            return fallback;
        }
    }

    // SAVE UPDATED BORROWED LIST BACK TO FILE
    private void saveBorrowedList() {
        File file = new File(BORROWED_PATH_FULL);
        try {
            // if full path missing use local file
            if (!file.exists()) {
                file = new File("borrowed.txt");
            }

            try (PrintWriter pw = new PrintWriter(new FileWriter(file, false))) {
                for (BorrowedItem b : borrowedList) {
                    pw.println(b.getStudentID() + " | " + b.getFullName()
                            + " | " + b.getItem()
                            + " | " + b.getQuantity()
                            + " | " + b.getPurpose()
                            + " | " + b.getBorrowDate());
                }
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error saving borrowed list: " + ex.getMessage());
        }
    }

    private void appendReturnedRecord(BorrowedItem b) {
        File file = new File(RETURNED_PATH_FULL);
        try {
            if (!file.exists()) {
                file = new File("returned.txt");
            }

            String returnDate = java.time.LocalDate.now().toString();
            try (PrintWriter pw = new PrintWriter(new FileWriter(file, true))) {
                // store: studentID | fullName | item | qty | purpose | borrowDate | returnDate
                pw.println(b.getStudentID() + " | " + b.getFullName() + " | " + b.getItem()
                        + " | " + b.getQuantity() + " | " + b.getPurpose()
                        + " | " + b.getBorrowDate() + " | " + returnDate);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error appending returned record: " + ex.getMessage());
        }
    }

    private void updateInventoryAdd(String itemName, int qtyToAdd) {
        File file = new File(INVENTORY_PATH_FULL);
        if (!file.exists()) {
            file = new File("inventory.txt"); // fallback
        }
        ArrayList<String> lines = new ArrayList<>();
        boolean found = false;

        try {
            if (file.exists()) {
                try (BufferedReader br = new BufferedReader(new FileReader(file))) {
                    String line;
                    while ((line = br.readLine()) != null) {
                        lines.add(line);
                    }
                }
                // parse and update
                for (int i = 0; i < lines.size(); i++) {
                    String line = lines.get(i);
                    String[] parts = line.split("\\s*\\|\\s*");
                    if (parts.length >= 3) {
                        String name = parts[0].trim();
                        String available = parts[1].trim();
                        String total = parts[2].trim();
                        if (name.equalsIgnoreCase(itemName)) {
                            int availInt = parseIntSafe(available, 0) + qtyToAdd;
                            int totalInt = parseIntSafe(total, 0);
                            lines.set(i, name + " | " + availInt + " | " + totalInt);
                            found = true;
                            break;
                        }
                    }
                }
            }
            if (!found) {
                // append new item line
                lines.add(itemName + " | " + qtyToAdd + " | " + qtyToAdd);
            }

            // write back
            try (PrintWriter pw = new PrintWriter(new FileWriter(file, false))) {
                for (String l : lines) {
                    pw.println(l);
                }
            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error updating inventory: " + ex.getMessage());
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

        public BorrowedItem(String studentID, String fullName, String item, int quantity, String purpose, String borrowDate) {
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
        jButtonreturn = new javax.swing.JButton();
        searchtext = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();

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
                "Student ID", "Student Name", "Item Name", "Quantity", "Borrow Date"
            }
        ));
        jScrollPane1.setViewportView(jTablereturn);

        jButtonreturn.setBackground(new java.awt.Color(250, 217, 51));
        jButtonreturn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButtonreturn.setText("Return");
        jButtonreturn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonreturnActionPerformed(evt);
            }
        });

        searchtext.setBackground(new java.awt.Color(240, 255, 255));
        searchtext.setForeground(new java.awt.Color(0, 0, 0));
        searchtext.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        searchtext.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchtextKeyReleased(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(102, 102, 102));
        jLabel6.setText("Search Data");

        javax.swing.GroupLayout panelmainLayout = new javax.swing.GroupLayout(panelmain);
        panelmain.setLayout(panelmainLayout);
        panelmainLayout.setHorizontalGroup(
            panelmainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelmainLayout.createSequentialGroup()
                .addGroup(panelmainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelmainLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1))
                    .addGroup(panelmainLayout.createSequentialGroup()
                        .addGroup(panelmainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelmainLayout.createSequentialGroup()
                                .addGap(429, 429, 429)
                                .addComponent(jButtonreturn, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelmainLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(Lusername7)))
                        .addGap(0, 39, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(panelmainLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelmainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelmainLayout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(searchtext, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel2)
                    .addComponent(jLabel5))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelmainLayout.setVerticalGroup(
            panelmainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelmainLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addGroup(panelmainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchtext, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(Lusername7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonreturn, javax.swing.GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE)
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

    private void searchtextKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchtextKeyReleased
        String text = searchtext.getText().trim().toLowerCase();
        DefaultTableModel model = (DefaultTableModel) jTablereturn.getModel();
        model.setRowCount(0);

        for (BorrowedItem b : borrowedList) {
            CharSequence q = null;
            if (b.getStudentID().toLowerCase().contains(q)
                    || b.getFullName().toLowerCase().contains(q)
                    || b.getItem().toLowerCase().contains(q)
                    || b.getBorrowDate().toLowerCase().contains(q)
                    || String.valueOf(b.getQuantity()).contains(q)) {

                model.addRow(new Object[]{
                        b.getStudentID(),
                        b.getFullName(),
                        b.getItem(),
                        b.getQuantity(),
                        b.getBorrowDate()
                });
            }
        }
    }//GEN-LAST:event_searchtextKeyReleased

    private void jButtonreturnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonreturnActionPerformed
          int sel = jTablereturn.getSelectedRow();
        if (sel < 0) {
            JOptionPane.showMessageDialog(this, "Please select a row to return.");
            return;
        }

        String studentID = jTablereturn.getValueAt(sel, 0).toString();
        String studentName = jTablereturn.getValueAt(sel, 1).toString();
        String itemName = jTablereturn.getValueAt(sel, 2).toString();
        int qty = parseIntSafe(jTablereturn.getValueAt(sel, 3).toString(), 1);

        // find the BorrowedItem in list (match by studentID + item)
        BorrowedItem found = null;
        for (BorrowedItem b : borrowedList) {
            if (b.getStudentID().equalsIgnoreCase(studentID) && b.getItem().equalsIgnoreCase(itemName)) {
                found = b;
                break;
            }
        }

        if (found == null) {
            JOptionPane.showMessageDialog(this, "Selected record not found.");
            return;
        }

        int confirm = JOptionPane.showConfirmDialog(this,
                "Return (" + found.getQuantity() + ") " + found.getItem() + " from " + found.getFullName() + "?",
                "Confirm Return", JOptionPane.YES_NO_OPTION);

        if (confirm != JOptionPane.YES_OPTION) {
            return;
        }

        // append to returned.txt, update inventory, remove from borrowed.txt, refresh UI
        appendReturnedRecord(found);
        updateInventoryAdd(found.getItem(), found.getQuantity());
        borrowedList.remove(found);
        saveBorrowedList();
        loadBorrowedItems();

        JOptionPane.showMessageDialog(this, "Item returned successfully.");
    
    
//        private void (String text) {
    }//GEN-LAST:event_jButtonreturnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Lusername7;
    private javax.swing.JButton jButtonreturn;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTablereturn;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JPanel panelmain;
    private javax.swing.JTextField searchtext;
    // End of variables declaration//GEN-END:variables
}
