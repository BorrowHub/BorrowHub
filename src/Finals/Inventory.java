package Finals;

import java.io.*;
import javax.swing.JOptionPane;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableModel;

public class Inventory extends javax.swing.JInternalFrame {

    private final String INVENTORY_PATH = "C:\\BorrowHub\\BorrowHub\\src\\data\\inventory.txt";

    public Inventory() {
        initComponents();

        this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        BasicInternalFrameUI user = (BasicInternalFrameUI) this.getUI();
        user.setNorthPane(null);

        loadInventoryTable();
        setupAddButton();       // I Add ang item handler

    }

    //  ⭐ LOAD INVENTORY INTO TABLE
    private void loadInventoryTable() {
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0);

        File invent = new File(INVENTORY_PATH);
        if (!invent.exists()) {
            invent = new File("inventory.txt");
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(invent))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split("\\s*\\|\\s*");
                if (data.length >= 3) {
                    String itemName = data[0].trim();
                    String available = data[1].trim();
                    String total = data[2].trim();
                    model.addRow(new Object[]{itemName, available, total});
                }
            }
        } catch (Exception e) {
            // if file not found show empty table (no popup)
        }
    }

    //  ⭐ SAVE NEW ITEM INTO FILE
    private void saveNewItem(String itemName, int totalQty) {
        File file = new File(INVENTORY_PATH);
        try {
            if (!file.exists()) {
                file = new File("inventory.txt");
            }

            // check if exists
            boolean exists = false;
            if (file.exists()) {
                try (BufferedReader br = new BufferedReader(new FileReader(file))) {
                    String line;
                    while ((line = br.readLine()) != null) {
                        String[] parts = line.split("\\s*\\|\\s*");
                        if (parts.length >= 1 && parts[0].trim().equalsIgnoreCase(itemName)) {
                            exists = true;
                            break;
                        }
                    }
                }
            }

            if (exists) {
                JOptionPane.showMessageDialog(this, "Item already exists in inventory!", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            try (BufferedWriter writer = new BufferedWriter(new FileWriter(file, true))) {
                writer.write(itemName + " | " + totalQty + " | " + totalQty);
                writer.newLine();
            }
            loadInventoryTable();
            JOptionPane.showMessageDialog(this, "Item added successfully!");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error saving item: " + ex.getMessage());
        }
    }

    //  ⭐ ADD BUTTON HANDLER
    private void setupAddButton() {
        jButtonexit.addActionListener(e -> {
            String itemName = Textusername2.getText().trim();
            String qtyStr = Textusername3.getText().trim();

            if (itemName.isEmpty() || qtyStr.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please enter item name and quantity.");
                return;
            }

            try {
                int totalQty = Integer.parseInt(qtyStr);
                if (totalQty <= 0) {
                    JOptionPane.showMessageDialog(this, "Quantity must be greater than 0.");
                    return;
                }
                saveNewItem(itemName, totalQty);
                Textusername2.setText("");
                Textusername3.setText("");
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Please enter a valid number.");
            }
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelmain = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        Lusername7 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        Lusername1 = new javax.swing.JLabel();
        Textusername2 = new javax.swing.JTextField();
        Lusername2 = new javax.swing.JLabel();
        Textusername3 = new javax.swing.JTextField();
        jButtonexit = new javax.swing.JButton();

        setBorder(null);
        setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setVisible(true);

        panelmain.setBackground(new java.awt.Color(240, 255, 255));
        panelmain.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel2.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Add New Decoration Item");

        Lusername7.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
        Lusername7.setForeground(new java.awt.Color(0, 0, 0));
        Lusername7.setText("Current Inventory");

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
                "Item name", "Available  ", "Total"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        Lusername1.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        Lusername1.setForeground(new java.awt.Color(0, 0, 0));
        Lusername1.setText("Item Name");

        Textusername2.setBackground(new java.awt.Color(240, 255, 255));
        Textusername2.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        Textusername2.setForeground(new java.awt.Color(0, 0, 0));
        Textusername2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        Lusername2.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        Lusername2.setForeground(new java.awt.Color(0, 0, 0));
        Lusername2.setText("Total Quantity");

        Textusername3.setBackground(new java.awt.Color(240, 255, 255));
        Textusername3.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        Textusername3.setForeground(new java.awt.Color(0, 0, 0));
        Textusername3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        jButtonexit.setBackground(new java.awt.Color(250, 217, 51));
        jButtonexit.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButtonexit.setForeground(new java.awt.Color(0, 0, 204));
        jButtonexit.setText("Add Item");

        javax.swing.GroupLayout panelmainLayout = new javax.swing.GroupLayout(panelmain);
        panelmain.setLayout(panelmainLayout);
        panelmainLayout.setHorizontalGroup(
            panelmainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelmainLayout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(panelmainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addGroup(panelmainLayout.createSequentialGroup()
                        .addGroup(panelmainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Textusername2, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Lusername1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelmainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Lusername2)
                            .addGroup(panelmainLayout.createSequentialGroup()
                                .addComponent(Textusername3, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButtonexit, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 496, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Lusername7))
                .addContainerGap(45, Short.MAX_VALUE))
        );
        panelmainLayout.setVerticalGroup(
            panelmainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelmainLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelmainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Lusername1)
                    .addComponent(Lusername2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelmainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(Textusername3, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                    .addComponent(Textusername2, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                    .addComponent(jButtonexit, javax.swing.GroupLayout.PREFERRED_SIZE, 30, Short.MAX_VALUE))
                .addGap(29, 29, 29)
                .addComponent(Lusername7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(133, Short.MAX_VALUE))
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


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Lusername1;
    private javax.swing.JLabel Lusername2;
    private javax.swing.JLabel Lusername7;
    private javax.swing.JTextField Textusername2;
    private javax.swing.JTextField Textusername3;
    private javax.swing.JButton jButtonexit;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JPanel panelmain;
    // End of variables declaration//GEN-END:variables
}
