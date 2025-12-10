
package Finals;

public class Borrow extends javax.swing.JInternalFrame {


    public Borrow() {
        initComponents();
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelmain = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        Lusername = new javax.swing.JLabel();
        Lusername1 = new javax.swing.JLabel();
        Textusername1 = new javax.swing.JTextField();
        Lusername2 = new javax.swing.JLabel();
        Textusername2 = new javax.swing.JTextField();
        Lusername3 = new javax.swing.JLabel();
        Lusername4 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        Lusername5 = new javax.swing.JLabel();
        Textusername3 = new javax.swing.JTextField();
        Lusername6 = new javax.swing.JLabel();
        Textusername4 = new javax.swing.JTextField();

        setMaximizable(true);
        setPreferredSize(new java.awt.Dimension(590, 500));
        setVisible(true);

        panelmain.setBackground(new java.awt.Color(240, 255, 255));

        jLabel2.setFont(new java.awt.Font("Swis721 Blk BT", 1, 27)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Borrow a Decoration Item");

        jLabel5.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(102, 102, 102));
        jLabel5.setText("Please fill out the form to borrow an item for your event.");

        Lusername.setFont(new java.awt.Font("Swis721 Blk BT", 0, 18)); // NOI18N
        Lusername.setForeground(new java.awt.Color(0, 0, 0));
        Lusername.setText("Student Information ");

        Lusername1.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        Lusername1.setForeground(new java.awt.Color(0, 0, 0));
        Lusername1.setText("Student ID");

        Textusername1.setBackground(new java.awt.Color(240, 255, 255));
        Textusername1.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        Textusername1.setForeground(new java.awt.Color(0, 0, 0));
        Textusername1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        Lusername2.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        Lusername2.setForeground(new java.awt.Color(0, 0, 0));
        Lusername2.setText("Student Full Name");

        Textusername2.setBackground(new java.awt.Color(240, 255, 255));
        Textusername2.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        Textusername2.setForeground(new java.awt.Color(0, 0, 0));
        Textusername2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        Lusername3.setFont(new java.awt.Font("Swis721 Blk BT", 0, 18)); // NOI18N
        Lusername3.setForeground(new java.awt.Color(0, 0, 0));
        Lusername3.setText("Borrow Details");

        Lusername4.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        Lusername4.setForeground(new java.awt.Color(0, 0, 0));
        Lusername4.setText("Item");

        jComboBox1.setBackground(new java.awt.Color(240, 255, 255));
        jComboBox1.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jComboBox1.setForeground(new java.awt.Color(0, 0, 0));
        jComboBox1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        Lusername5.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        Lusername5.setForeground(new java.awt.Color(0, 0, 0));
        Lusername5.setText("Borrow Date");

        Textusername3.setBackground(new java.awt.Color(240, 255, 255));
        Textusername3.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        Textusername3.setForeground(new java.awt.Color(0, 0, 0));
        Textusername3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        Lusername6.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        Lusername6.setForeground(new java.awt.Color(0, 0, 0));
        Lusername6.setText("Purpose");

        Textusername4.setBackground(new java.awt.Color(240, 255, 255));
        Textusername4.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        Textusername4.setForeground(new java.awt.Color(0, 0, 0));
        Textusername4.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        javax.swing.GroupLayout panelmainLayout = new javax.swing.GroupLayout(panelmain);
        panelmain.setLayout(panelmainLayout);
        panelmainLayout.setHorizontalGroup(
            panelmainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelmainLayout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(panelmainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelmainLayout.createSequentialGroup()
                        .addComponent(Lusername6)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelmainLayout.createSequentialGroup()
                        .addGroup(panelmainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(Textusername4, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelmainLayout.createSequentialGroup()
                                .addGroup(panelmainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(panelmainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(panelmainLayout.createSequentialGroup()
                                            .addGroup(panelmainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(Lusername1)
                                                .addComponent(Lusername4))
                                            .addGap(160, 160, 160))
                                        .addGroup(panelmainLayout.createSequentialGroup()
                                            .addComponent(Textusername2)
                                            .addGap(32, 32, 32)))
                                    .addGroup(panelmainLayout.createSequentialGroup()
                                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(23, 23, 23)))
                                .addGroup(panelmainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(Textusername3)
                                    .addComponent(Lusername5)
                                    .addComponent(Lusername2)
                                    .addComponent(Textusername1, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelmainLayout.createSequentialGroup()
                                .addGroup(panelmainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(Lusername3, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(Lusername, javax.swing.GroupLayout.Alignment.LEADING))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(57, 57, 57))))
        );
        panelmainLayout.setVerticalGroup(
            panelmainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelmainLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(Lusername)
                .addGap(18, 18, 18)
                .addGroup(panelmainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelmainLayout.createSequentialGroup()
                        .addComponent(Lusername1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Textusername2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelmainLayout.createSequentialGroup()
                        .addComponent(Lusername2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Textusername1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(26, 26, 26)
                .addComponent(Lusername3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelmainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Lusername4)
                    .addComponent(Lusername5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelmainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(Textusername3)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(Lusername6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Textusername4, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(213, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelmain, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelmain, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Lusername;
    private javax.swing.JLabel Lusername1;
    private javax.swing.JLabel Lusername2;
    private javax.swing.JLabel Lusername3;
    private javax.swing.JLabel Lusername4;
    private javax.swing.JLabel Lusername5;
    private javax.swing.JLabel Lusername6;
    private javax.swing.JTextField Textusername1;
    private javax.swing.JTextField Textusername2;
    private javax.swing.JTextField Textusername3;
    private javax.swing.JTextField Textusername4;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel panelmain;
    // End of variables declaration//GEN-END:variables
}
