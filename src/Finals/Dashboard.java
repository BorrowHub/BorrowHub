
package Finals;

public class Dashboard extends javax.swing.JFrame {

    public Dashboard() {
       initComponents();
        setLocationRelativeTo(null); // para mag pop up ni nga jframe sa tunga kung I run
    
        // Set alignment + icon gap for all buttons
        javax.swing.JButton[] buttons = {
            borrowbttn1, borrowbttn, returnbttn,
            inventorybttn, recordsbttn, logoutbttn
        };

        for (javax.swing.JButton b : buttons) {
            b.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
            b.setIconTextGap(15); // distance between icon and text
        }
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jInternalFrame1 = new javax.swing.JInternalFrame();
        main = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        borrowbttn = new javax.swing.JButton();
        returnbttn = new javax.swing.JButton();
        inventorybttn = new javax.swing.JButton();
        recordsbttn = new javax.swing.JButton();
        logoutbttn = new javax.swing.JButton();
        borrowbttn1 = new javax.swing.JButton();
        desktopleft = new javax.swing.JDesktopPane();
        jPanel2 = new javax.swing.JPanel();

        jInternalFrame1.setVisible(true);

        javax.swing.GroupLayout jInternalFrame1Layout = new javax.swing.GroupLayout(jInternalFrame1.getContentPane());
        jInternalFrame1.getContentPane().setLayout(jInternalFrame1Layout);
        jInternalFrame1Layout.setHorizontalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jInternalFrame1Layout.setVerticalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        main.setBackground(new java.awt.Color(240, 255, 255));
        main.setPreferredSize(new java.awt.Dimension(700, 500));

        jPanel1.setBackground(new java.awt.Color(21, 54, 188));
        jPanel1.setPreferredSize(new java.awt.Dimension(270, 397));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(204, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("BorrowHub");

        borrowbttn.setBackground(new java.awt.Color(255, 242, 242));
        borrowbttn.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        borrowbttn.setForeground(new java.awt.Color(45, 51, 107));
        borrowbttn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/addnew.png"))); // NOI18N
        borrowbttn.setText("Borrow Item");
        borrowbttn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                borrowbttnMouseClicked(evt);
            }
        });

        returnbttn.setBackground(new java.awt.Color(255, 242, 242));
        returnbttn.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        returnbttn.setForeground(new java.awt.Color(45, 51, 107));
        returnbttn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/return.png"))); // NOI18N
        returnbttn.setText("Return Item");
        returnbttn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                returnbttnMouseClicked(evt);
            }
        });

        inventorybttn.setBackground(new java.awt.Color(255, 242, 242));
        inventorybttn.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        inventorybttn.setForeground(new java.awt.Color(45, 51, 107));
        inventorybttn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/inventory.png"))); // NOI18N
        inventorybttn.setText("Inventory");
        inventorybttn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                inventorybttnMouseClicked(evt);
            }
        });

        recordsbttn.setBackground(new java.awt.Color(255, 242, 242));
        recordsbttn.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        recordsbttn.setForeground(new java.awt.Color(45, 51, 107));
        recordsbttn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/history.png"))); // NOI18N
        recordsbttn.setText("Records");

        logoutbttn.setBackground(new java.awt.Color(255, 242, 242));
        logoutbttn.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        logoutbttn.setForeground(new java.awt.Color(45, 51, 107));
        logoutbttn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/logout.png"))); // NOI18N
        logoutbttn.setText("Log Out");

        borrowbttn1.setBackground(new java.awt.Color(255, 242, 242));
        borrowbttn1.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        borrowbttn1.setForeground(new java.awt.Color(45, 51, 107));
        borrowbttn1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/Untitled design.png"))); // NOI18N
        borrowbttn1.setText("Dashboard");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(borrowbttn, javax.swing.GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE)
                            .addComponent(returnbttn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE)
                            .addComponent(inventorybttn, javax.swing.GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE)
                            .addComponent(recordsbttn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE)
                            .addComponent(logoutbttn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE)
                            .addComponent(borrowbttn1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(jLabel1)))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1)
                .addGap(53, 53, 53)
                .addComponent(borrowbttn1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(borrowbttn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(returnbttn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(inventorybttn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(recordsbttn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 115, Short.MAX_VALUE)
                .addComponent(logoutbttn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
        );

        desktopleft.setBackground(new java.awt.Color(102, 102, 102));
        desktopleft.setPreferredSize(new java.awt.Dimension(500, 500));

        jPanel2.setBackground(new java.awt.Color(255, 242, 242));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 586, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        desktopleft.setLayer(jPanel2, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout desktopleftLayout = new javax.swing.GroupLayout(desktopleft);
        desktopleft.setLayout(desktopleftLayout);
        desktopleftLayout.setHorizontalGroup(
            desktopleftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        desktopleftLayout.setVerticalGroup(
            desktopleftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout mainLayout = new javax.swing.GroupLayout(main);
        main.setLayout(mainLayout);
        mainLayout.setHorizontalGroup(
            mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainLayout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(desktopleft, javax.swing.GroupLayout.DEFAULT_SIZE, 586, Short.MAX_VALUE))
        );
        mainLayout.setVerticalGroup(
            mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 500, Short.MAX_VALUE)
            .addComponent(desktopleft, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(main, javax.swing.GroupLayout.DEFAULT_SIZE, 796, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(main, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        main.getAccessibleContext().setAccessibleName("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void borrowbttnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_borrowbttnMouseClicked
        Borrow borrow = new Borrow();
        borrow.setVisible(true);
        desktopleft.removeAll();
        desktopleft.add(borrow).setVisible(true);
    }//GEN-LAST:event_borrowbttnMouseClicked

    private void returnbttnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_returnbttnMouseClicked
       
    }//GEN-LAST:event_returnbttnMouseClicked

    private void inventorybttnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_inventorybttnMouseClicked
       
    }//GEN-LAST:event_inventorybttnMouseClicked

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Dashboard().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton borrowbttn;
    private javax.swing.JButton borrowbttn1;
    private javax.swing.JDesktopPane desktopleft;
    private javax.swing.JButton inventorybttn;
    private javax.swing.JInternalFrame jInternalFrame1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JButton logoutbttn;
    private javax.swing.JPanel main;
    private javax.swing.JButton recordsbttn;
    private javax.swing.JButton returnbttn;
    // End of variables declaration//GEN-END:variables
}
