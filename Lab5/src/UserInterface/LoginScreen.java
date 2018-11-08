/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface;

import Business.Abstract.User;
import java.awt.CardLayout;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author harshalneelkamal
 */
public class LoginScreen extends javax.swing.JPanel {

    /**
     * Creates new form LoginScreen
     */
    List<User> list;
    JPanel panelRight;
    public LoginScreen(JPanel panelRight, List<User> list) {
        initComponents();
        this.list = list;
        this.panelRight = panelRight;
        initialize();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtPword = new javax.swing.JTextField();
        btnSubmit = new javax.swing.JButton();
        comboUser = new javax.swing.JComboBox<>();
        txtTitle = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        add(txtPword, new org.netbeans.lib.awtextra.AbsoluteConstraints(63, 96, 166, -1));

        btnSubmit.setText("Login");
        btnSubmit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSubmitActionPerformed(evt);
            }
        });
        add(btnSubmit, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 140, -1, -1));

        comboUser.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        comboUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboUserActionPerformed(evt);
            }
        });
        add(comboUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(63, 57, 166, -1));

        txtTitle.setText("Supplier Login Screen");
        add(txtTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(63, 23, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void btnSubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubmitActionPerformed
        String password = txtPword.getText();
        String username = comboUser.getSelectedItem().toString();
        int login = 0;
        for (User u : list) {
            if (username.equals(u.getUserName())) {
                if ((password.trim()).equals(u.getPassword())) {
                    CardLayout layout = (CardLayout) panelRight.getLayout();
                    panelRight.add(new SuccessScreen(u));
                    layout.next(panelRight);
                    login = 1;
                    break;
                }
            }
        }
        if (login == 0) {
            JOptionPane.showMessageDialog(null, "Password didn't match");
        }
    }//GEN-LAST:event_btnSubmitActionPerformed

    private void comboUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboUserActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboUserActionPerformed

    private void initialize() {
        //text should either be "Supplier Login Screen" OR "Customer Login Screen"
        //Based on the selection
        //Checking the list of Users passed for the type of User viz. Customer or Supplier
        if (list.size() > 0) {
            if (list.get(0).getRole().equalsIgnoreCase("SUPPLIER")) {
                txtTitle.setText("SUPPLIER Login Screen");
            } else if (list.get(0).getRole().equalsIgnoreCase("CUSTOMER")) {
                txtTitle.setText("CUSTOMER Login Screen");
            } else {
                //Unknown role. Showing generic Title
                txtTitle.setText("Login Screen");
            }
        }

        comboUser.removeAllItems();
        for (User u : list) {
            comboUser.addItem(u.getUserName());
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSubmit;
    private javax.swing.JComboBox<Object> comboUser;
    private javax.swing.JTextField txtPword;
    private javax.swing.JLabel txtTitle;
    // End of variables declaration//GEN-END:variables
}
