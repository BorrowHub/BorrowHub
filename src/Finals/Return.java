
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
        BasicInternalFrameUI user = (BasicInternalFrameUI)this.getUI();
        user.setNorthPane(null);
        
        loadBorrowedItems();
    }
    
   //====================== LOAD BORROWED ITEMS ======================
    private void loadBorrowedItems() {
        borrowedList.clear();
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0);

        File file = new File("borrowed_records.txt");
        if (!file.exists()) return;

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;

            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length >= 6) {
                    String studentID = data[0].trim();
                    String fullName = data[1].trim();
                    String itemName = data[2].trim();
                    int quantity = Integer.parseInt(data[3].trim());
                    String purpose = data[4].trim();
                    String borrowDate = data[5].trim();

                    BorrowedItem b = new BorrowedItem(studentID, fullName, itemName, quantity, purpose, borrowDate);
                    borrowedList.add(b);

                    model.addRow(new Object[]{
                            studentID,
                            fullName,
                            itemName,
                            quantity,
                            purpose,
                            borrowDate
                    });
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error loading borrowed items: " + e.getMessage());
        }
    }

    //====================== WRITE UPDATED BORROWED FILE ======================
    private void saveBorrowedList() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("borrow_records.txt"))) {
            for (BorrowedItem b : borrowedList) {
                bw.write(b.getStudentID() + " | " + b.getFullName() + " | " + b.getItem() + " | "
                        + b.getQuantity() + " | " + b.getPurpose() + " | " + b.getBorrowDate());
                bw.newLine();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error saving borrowed list!");
        }
    }

    //====================== RESTOCK TO INVENTORY ======================
    private void returnToInventory(String itemName, int quantity) {

        ArrayList<InventoryItem> inventory = new ArrayList<>();
        File file = new File("inventory.txt");

        try {
            // Load inventory
            if (file.exists()) {
                BufferedReader br = new BufferedReader(new FileReader(file));
                String line;

                while ((line = br.readLine()) != null) {
                    String[] data = line.split(",");
                    if (data.length >= 3) {
                        inventory.add(new InventoryItem(data[0], Integer.parseInt(data[1]), data[2]));
                    }
                }
                br.close();
            }

            // Find item and restock
            boolean found = false;
            for (InventoryItem inv : inventory) {
                if (inv.getName().equals(itemName)) {
                    inv.setQuantity(inv.getQuantity() + quantity);
                    found = true;
                }
            }

            // If not found, add as new item
            if (!found) {
                inventory.add(new InventoryItem(itemName, quantity, "Decoration"));
            }

            // Write inventory back
            PrintWriter pw = new PrintWriter(new FileWriter("inventory.txt"));
            for (InventoryItem inv : inventory) {
                pw.println(inv.getName() + "," + inv.getQuantity() + "," + inv.getCategory());
            }
            pw.close();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error returning to inventory!");
        }
    }

    //====================== DELETE BORROWED ENTRY ======================
    private void deleteBorrowed(int index) {
        if (index >= 0) {
            borrowedList.remove(index);
            saveBorrowedList();
            loadBorrowedItems();
        }
    }

    //====================== SEARCH ======================
    private void searchBorrowed(String keyword) {
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0);

        for (BorrowedItem b : borrowedList) {
            if (b.getBorrower().toLowerCase().contains(keyword.toLowerCase()) ||
                b.getItem().toLowerCase().contains(keyword.toLowerCase())) {

                model.addRow(new Object[]{
                    b.getBorrower(),
                    b.getItem(),
                    b.getQuantity()
                });
            }
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
        jTable1 = new javax.swing.JTable();
        jButtonexit = new javax.swing.JButton();

        jTextField1.setText("jTextField1");

        setBorder(null);
        setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setVisible(true);

        panelmain.setBackground(new java.awt.Color(240, 255, 255));
        panelmain.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel2.setFont(new java.awt.Font("Segoe UI Black", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Return an Item");

        jLabel5.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(102, 102, 102));
        jLabel5.setText("Search for and select the item you wish to return");

        Lusername7.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
        Lusername7.setForeground(new java.awt.Color(0, 0, 0));
        Lusername7.setText("Borrowed Items");

        jTable1.setBackground(new java.awt.Color(240, 255, 255));
        jTable1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jTable1.setForeground(new java.awt.Color(0, 0, 0));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Item Name", "Student Name", "Borrow Date"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jButtonexit.setBackground(new java.awt.Color(250, 217, 51));
        jButtonexit.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButtonexit.setForeground(new java.awt.Color(0, 0, 0));
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
         int selected = jTable1.getSelectedRow();
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
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JPanel panelmain;
    // End of variables declaration//GEN-END:variables
}
