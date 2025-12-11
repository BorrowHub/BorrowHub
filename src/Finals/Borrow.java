
package Finals;

import javax.swing.plaf.basic.BasicInternalFrameUI;

public class Borrow extends javax.swing.JInternalFrame {


    public Borrow() {
        initComponents();
        this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        BasicInternalFrameUI user = (BasicInternalFrameUI)this.getUI();
        user.setNorthPane(null);
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
                .addGap(18, 18, 18)
                .addComponent(Lusername)
                .addGap(12, 12, 12)
                .addGroup(panelmainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Lusername8)
                    .addComponent(Lusername4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelmainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(Textusername5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addGroup(panelmainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelmainLayout.createSequentialGroup()
                        .addComponent(Lusername6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Textusername4, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelmainLayout.createSequentialGroup()
                        .addComponent(Lusername5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Textusername3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(37, 37, 37)
                .addComponent(bttnConfirm, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33))
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
};

private void borrowItem() {
    String borrower = txtBorrower.getText();  
    String item = txtItem.getText();          

    try {
        Connection con = DBConnection.getConnection();

        String sql = "INSERT INTO transactions (borrower, item, date_borrowed, status) VALUES (?, ?, NOW(), 'Borrowed')";
        PreparedStatement pst = con.prepareStatement(sql);

        pst.setString(1, borrower);
        pst.setString(2, item);

        pst.executeUpdate();

        javax.swing.JOptionPane.showMessageDialog(null, "Borrowed Successfully!");

    } catch (Exception e) {
        e.printStackTrace();
    }
}

