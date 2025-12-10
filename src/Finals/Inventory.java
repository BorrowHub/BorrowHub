
package Finals;

import javax.swing.plaf.basic.BasicInternalFrameUI;

public class Inventory extends javax.swing.JInternalFrame {


    public Inventory() {
        initComponents();
        this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        BasicInternalFrameUI user = (BasicInternalFrameUI)this.getUI();
        user.setNorthPane(null);
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
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Item name", "Available  ", "Total", "Action"
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
        jButtonexit.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButtonexit.setForeground(new java.awt.Color(0, 0, 0));
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
                                .addComponent(jButtonexit, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))))
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
                    .addComponent(jButtonexit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Textusername3)
                    .addComponent(Textusername2, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(41, 41, 41)
                .addComponent(Lusername7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(121, Short.MAX_VALUE))
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
