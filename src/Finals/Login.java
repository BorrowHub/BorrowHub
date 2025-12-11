
package Finals;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JOptionPane;


public class Login extends javax.swing.JFrame {

    static final int Shift = 3;
    
    public Login() {
       initComponents();
        setLocationRelativeTo(null); // para mag pop up ni nga jframe sa tunga kung I run
    }
  // Encryption method (same as in SignUp)
    private String encrypt(String message, int key) {
        char[] chars = message.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            chars[i] += key;
        }
        return new String(chars);
    }

    // Decryption method (reverse of encryption)
    private String decrypt(String message, int key) {
        char[] chars = message.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            chars[i] -= key;
        }
        return new String(chars);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jInternalFrame1 = new javax.swing.JInternalFrame();
        main = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        Lusername = new javax.swing.JLabel();
        Lpassword = new javax.swing.JLabel();
        Textusername = new javax.swing.JTextField();
        jPassword = new javax.swing.JPasswordField();
        jButtonlogin = new javax.swing.JButton();
        jCheckShowPass = new javax.swing.JCheckBox();
        jButtonexit = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        CreateAccBttn = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();

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

        jLabel2.setFont(new java.awt.Font("Swis721 Blk BT", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText(" Log in to Your Account ");

        Lusername.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        Lusername.setForeground(new java.awt.Color(51, 51, 51));
        Lusername.setText("Username");

        Lpassword.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        Lpassword.setForeground(new java.awt.Color(51, 51, 51));
        Lpassword.setText("Password");

        Textusername.setBackground(new java.awt.Color(240, 255, 255));
        Textusername.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        Textusername.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        jPassword.setBackground(new java.awt.Color(240, 255, 255));
        jPassword.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jPassword.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        jButtonlogin.setBackground(new java.awt.Color(250, 217, 51));
        jButtonlogin.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButtonlogin.setForeground(new java.awt.Color(0, 0, 153));
        jButtonlogin.setText("Login");
        jButtonlogin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonloginMouseClicked(evt);
            }
        });
        jButtonlogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonloginActionPerformed(evt);
            }
        });

        jCheckShowPass.setBackground(new java.awt.Color(255, 255, 255));
        jCheckShowPass.setFont(new java.awt.Font("SansSerif", 0, 10)); // NOI18N
        jCheckShowPass.setForeground(new java.awt.Color(51, 51, 51));
        jCheckShowPass.setText("Show Password");
        jCheckShowPass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckShowPassActionPerformed(evt);
            }
        });

        jButtonexit.setBackground(new java.awt.Color(250, 217, 51));
        jButtonexit.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButtonexit.setForeground(new java.awt.Color(0, 0, 153));
        jButtonexit.setText("Exit");

        jLabel3.setText("Dont have an account?");

        CreateAccBttn.setBackground(new java.awt.Color(240, 255, 255));
        CreateAccBttn.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        CreateAccBttn.setForeground(new java.awt.Color(0, 0, 204));
        CreateAccBttn.setText("Create Account");
        CreateAccBttn.setMargin(new java.awt.Insets(2, 0, 3, 0));
        CreateAccBttn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CreateAccBttnMouseClicked(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(102, 102, 102));
        jLabel5.setText("Welcome! Please enter your details.");

        jPanel1.setBackground(new java.awt.Color(21, 54, 188));
        jPanel1.setPreferredSize(new java.awt.Dimension(270, 397));

        jLabel6.setBackground(new java.awt.Color(0, 0, 0));
        jLabel6.setForeground(new java.awt.Color(153, 0, 153));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 30)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("BorrowHub");

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setForeground(new java.awt.Color(255, 255, 255));
        jPanel4.setPreferredSize(new java.awt.Dimension(194, 2));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 172, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 3, Short.MAX_VALUE)
        );

        jLabel4.setForeground(new java.awt.Color(204, 255, 255));
        jLabel4.setText("Decorate Smarter. Borrow Easier");

        jLabel9.setForeground(new java.awt.Color(204, 255, 255));
        jLabel9.setText(" © 2025 BorrowHub - All Rights Reserved");

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/logo.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel6)
                        .addGap(0, 0, 0)
                        .addComponent(jLabel8)
                        .addGap(45, 45, 45)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1)
                            .addComponent(jLabel4)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jLabel9)))
                .addGap(0, 30, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(211, 211, 211))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 3, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addGap(156, 156, 156)
                .addComponent(jLabel9)
                .addContainerGap())
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(33, 33, 33)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGap(257, 257, 257)))
        );

        javax.swing.GroupLayout mainLayout = new javax.swing.GroupLayout(main);
        main.setLayout(mainLayout);
        mainLayout.setHorizontalGroup(
            mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainLayout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(mainLayout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addGroup(mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jCheckShowPass)
                                    .addComponent(Lusername, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(Textusername, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(Lpassword, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jPassword, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButtonlogin, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jButtonexit, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainLayout.createSequentialGroup()
                                    .addComponent(jLabel3)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(CreateAccBttn)
                                    .addGap(43, 43, 43)))
                            .addComponent(jLabel2)))
                    .addGroup(mainLayout.createSequentialGroup()
                        .addGap(115, 115, 115)
                        .addComponent(jLabel5)))
                .addContainerGap(54, Short.MAX_VALUE))
        );
        mainLayout.setVerticalGroup(
            mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainLayout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Lusername)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Textusername, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Lpassword)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCheckShowPass)
                .addGap(27, 27, 27)
                .addComponent(jButtonlogin, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonexit, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addGroup(mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(CreateAccBttn))
                .addGap(39, 39, 39))
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 500, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(main, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(main, javax.swing.GroupLayout.PREFERRED_SIZE, 512, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        main.getAccessibleContext().setAccessibleName("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonloginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonloginActionPerformed
                String username = Textusername.getText().trim();
        String password = new String(jPassword.getPassword()).trim();

        if (username.isEmpty() || password.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please input your Username and Password", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String encryptedPassword = password;
        boolean usernameExist = false;
        boolean passMatched = false;

        try {
            BufferedReader read = new BufferedReader(new FileReader("users.txt"));
            String line;

            while ((line = read.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 2) {
                    String dataUsername = parts[0].trim();
                    String encryptedStoredPass = parts[1].trim();

                    if (username.equals(dataUsername)) {
                        usernameExist = true;

                        // Decrypt the stored password
                        String decryptedPass = decrypt(encryptedStoredPass, Shift);

                        // Check if the entered password matches the decrypted password
                        if (encryptedPassword.equals(decryptedPass)) {
                            passMatched = true;
                            break;
                        }
                    }
                }
            }

            read.close();

            // Check results and display appropriate messages
            if (!usernameExist) {
                JOptionPane.showMessageDialog(this, "Username not found", "Login Failed", JOptionPane.ERROR_MESSAGE);
                Textusername.setText("");
                jPassword.setText("");
            } else if (!passMatched) {
                JOptionPane.showMessageDialog(this, "Incorrect password", "Login Failed", JOptionPane.ERROR_MESSAGE);
                jPassword.setText("");
            } else {
                JOptionPane.showMessageDialog(this, "Login Successful", "Welcome", JOptionPane.INFORMATION_MESSAGE);
                // Transition to the Dashboard (You need to create the Dashboard class)
                Dashboard dash = new Dashboard();
                dash.setVisible(true);
                dispose();
            }

        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error reading users file", "Error", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_jButtonloginActionPerformed

    private void jCheckShowPassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckShowPassActionPerformed
       if (jCheckShowPass.isSelected()){
            jPassword.setEchoChar((char) 0); // ma visible ang password
        }else{
            jPassword.setEchoChar('*');//ma tago ang password
        }
    }//GEN-LAST:event_jCheckShowPassActionPerformed

    private void CreateAccBttnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CreateAccBttnMouseClicked
        SignUp sign = new SignUp();
        sign.setVisible(true);
        dispose();
    }//GEN-LAST:event_CreateAccBttnMouseClicked

    private void jButtonloginMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonloginMouseClicked
//        String username = Textusername.getText();
//        String password = new String(jPassword.getPassword());
//        
//        //if ever nga natuplok ni user ang button unya walay sulod ang username ug password
//        if (username.isEmpty() || password.isEmpty()){
//            JOptionPane.showMessageDialog(this, "Please input Your Username and Password", "Error", JOptionPane.ERROR_MESSAGE);
//            return; //maputol ang execution kung walay sulod ang username ug password
//        }
//        
//        String encryptPassword = password;
//        boolean usernameExist = false;
//        boolean passmatched = false;
//        
//        try{
//            BufferedReader read = new BufferedReader(new FileReader(""));
//            String line;
//            
//            while ((line = read.readLine()) != null){
//                String[] parts = line.split(",");
//                if (parts.length == 2){
//                    String dataUsername = parts[0].trim();
//                    String encryptedPassword = parts[1].trim();
//                    
//                    //kung ang gi input ni username nakita sa datausername
//                    if (username.equals(dataUsername)){
//                        usernameExist = true;
//                        
//                        //gi call nato ang decryptedpass nga method
//                        String decryptedPass = decrypt(encryptedPassword, Shift);
//                        
//                        //kung ang password kay nag matched pud pag decrypt
//                        if(encryptPassword.equals(decryptedPass)){
//                            passmatched = true;
//                            break;
//                            }
//                        }  
//                    }
//                }
//            
//            read.close(); //muondang na siya ug basa
//            
//            //kung wala nag exist ang username
//            if(!usernameExist){
//                JOptionPane.showMessageDialog(this, "username not found", "loginFailed", JOptionPane.ERROR_MESSAGE);
//                Textusername.setText(""); //Mahawan ang username textfeild
//                jPassword.setText(""); //Mahawan ang password feild
//            
//            //kung wala nag matched ang password
//            }else if(!passmatched){
//                JOptionPane.showMessageDialog(this, "Incorrect password", "Login Failed", JOptionPane.ERROR_MESSAGE);
//                jPassword.setText(""); //Mahawan ang password feild
//            
//            }else{
//                JOptionPane.showMessageDialog(this, "login Successful", "Welcome", JOptionPane.INFORMATION_MESSAGE);
//                //Mapadulong sa Dashboard nga Jframe
//                Dashboard dash = new Dashboard();
//                dash.setVisible(true);
//                dispose();
//            }
//                        
//        }catch(IOException e){
//         JOptionPane.showMessageDialog(this, "Error reading eser file", "Error", JOptionPane.ERROR_MESSAGE);
//           }
        
    }//GEN-LAST:event_jButtonloginMouseClicked

//    //decryption ni siya nga method
//    private String decrypt(String message, int key) {
//        char[] chars = message.toCharArray();
//        for (int i = 0; i < chars.length; i++){
//            chars[i] -= key; //kung decrypt kay minus and equal
//        }
//        return new String(chars);   
//    }
//    
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CreateAccBttn;
    private javax.swing.JLabel Lpassword;
    private javax.swing.JLabel Lusername;
    private javax.swing.JTextField Textusername;
    private javax.swing.JButton jButtonexit;
    private javax.swing.JButton jButtonlogin;
    private javax.swing.JCheckBox jCheckShowPass;
    private javax.swing.JInternalFrame jInternalFrame1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPasswordField jPassword;
    private javax.swing.JPanel main;
    // End of variables declaration//GEN-END:variables
}
