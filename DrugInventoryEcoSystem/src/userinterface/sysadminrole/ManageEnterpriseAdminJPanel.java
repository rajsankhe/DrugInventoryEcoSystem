/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.sysadminrole;

import business.EcoSystem;
import business.employee.Employee;
import business.enterprise.Enterprise;
import business.network.Network;
import business.role.AdminRole;
import business.role.Role;
import business.useraccount.UserAccount;
import commonutils.Email;
import commonutils.PasswordUtility;
import commonutils.Validator;
import java.awt.CardLayout;
import java.awt.Component;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author vivekdalal
 */
public class ManageEnterpriseAdminJPanel extends javax.swing.JPanel {

    private JPanel userProcessContainer;
    private EcoSystem system;

    /**
     * Creates new form ManageEnterpriseJPanel
     */
    public ManageEnterpriseAdminJPanel(JPanel userProcessContainer, EcoSystem system) {
        initComponents();
        this.setSize(1200, 750);
        this.userProcessContainer = userProcessContainer;
        this.system = system;
        ((DefaultTableCellRenderer) enterpriseJTable.getDefaultRenderer(Object.class)).setOpaque(false);
        jScrollPane1.setOpaque(false);
        jScrollPane1.getViewport().setOpaque(false);
        enterpriseJTable.setShowGrid(true);

        populateTable();
        populateNetworkComboBox();
    }

    private void populateTable() {
        DefaultTableModel model = (DefaultTableModel) enterpriseJTable.getModel();

        model.setRowCount(0);
        for (Network network : system.getNetworkDirectory().getNetworkList()) {
            for (Enterprise enterprise : network.getEnterpriseDirectory().getEnterpriseList()) {

                for (UserAccount userAccount : enterprise.getUserAccountDirectory().getUserAccountListValues()) {
                    Object[] row = new Object[3];
                    row[0] = enterprise.getName();
                    row[1] = network.getName();
                    row[2] = userAccount.getUsername();

                    model.addRow(row);
                }

            }
        }
    }

    private void populateNetworkComboBox() {
        networkJComboBox.removeAllItems();

        for (Network network : system.getNetworkDirectory().getNetworkList()) {
            networkJComboBox.addItem(network);
        }
    }

    private void populateEnterpriseComboBox(Network network) {
        enterpriseJComboBox.removeAllItems();

        for (Enterprise enterprise : network.getEnterpriseDirectory().getEnterpriseList()) {
            enterpriseJComboBox.addItem(enterprise);
        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        kGradientPanel1 = new keeptoo.KGradientPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        enterpriseJTable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        networkJComboBox = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        enterpriseJComboBox = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        usernameJTextField = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        emailIDJTextField = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        nameJTextField = new javax.swing.JTextField();
        backJButton = new javax.swing.JButton();
        submitJButton = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(204, 204, 204));
        setMaximumSize(new java.awt.Dimension(1200, 750));
        setMinimumSize(new java.awt.Dimension(1200, 750));
        setPreferredSize(new java.awt.Dimension(1200, 750));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        kGradientPanel1.setkEndColor(new java.awt.Color(0, 153, 153));
        kGradientPanel1.setkStartColor(new java.awt.Color(153, 255, 255));
        kGradientPanel1.setMaximumSize(new java.awt.Dimension(1200, 750));
        kGradientPanel1.setMinimumSize(new java.awt.Dimension(1200, 750));
        kGradientPanel1.setName(""); // NOI18N
        kGradientPanel1.setPreferredSize(new java.awt.Dimension(1200, 750));
        kGradientPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        enterpriseJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Enterprise Name", "Network", "Username"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(enterpriseJTable);

        kGradientPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 60, 550, 220));

        jLabel1.setText("Network");
        kGradientPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 350, -1, -1));

        networkJComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        networkJComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                networkJComboBoxActionPerformed(evt);
            }
        });
        kGradientPanel1.add(networkJComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 350, 136, -1));

        jLabel3.setText("Enterprise");
        kGradientPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 410, -1, -1));

        enterpriseJComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        kGradientPanel1.add(enterpriseJComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 410, 136, -1));

        jLabel2.setText("Username");
        kGradientPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 460, -1, -1));
        kGradientPanel1.add(usernameJTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 450, 136, -1));

        jLabel4.setText("Email ID");
        kGradientPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 500, -1, -1));
        kGradientPanel1.add(emailIDJTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 500, 136, -1));

        jLabel5.setText("Name");
        kGradientPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 550, -1, -1));
        kGradientPanel1.add(nameJTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 540, 136, -1));

        backJButton.setBackground(new java.awt.Color(255, 255, 255));
        backJButton.setText("<< Back");
        backJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backJButtonActionPerformed(evt);
            }
        });
        kGradientPanel1.add(backJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 590, -1, -1));

        submitJButton.setBackground(new java.awt.Color(255, 255, 255));
        submitJButton.setText("Submit");
        submitJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitJButtonActionPerformed(evt);
            }
        });
        kGradientPanel1.add(submitJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 590, -1, -1));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/icons/admin.png"))); // NOI18N
        kGradientPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 10, -1, -1));

        add(kGradientPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1200, 750));
    }// </editor-fold>//GEN-END:initComponents

    private void networkJComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_networkJComboBoxActionPerformed

        Network network = (Network) networkJComboBox.getSelectedItem();
        if (network != null) {
            populateEnterpriseComboBox(network);
        }
    }//GEN-LAST:event_networkJComboBoxActionPerformed

    private void backJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backJButtonActionPerformed
        userProcessContainer.remove(this);
        Component[] componentArray = userProcessContainer.getComponents();
        Component component = componentArray[componentArray.length - 1];
        SystemAdminWorkAreaJPanel sysAdminwjp = (SystemAdminWorkAreaJPanel) component;
        sysAdminwjp.populateTree();
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_backJButtonActionPerformed

    private void submitJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitJButtonActionPerformed

        Enterprise enterprise = (Enterprise) enterpriseJComboBox.getSelectedItem();

        String username = usernameJTextField.getText();
        //String password = String.valueOf(passwordJPasswordField.getPassword());
        String emailID = String.valueOf(emailIDJTextField.getText());
        String name = nameJTextField.getText();

        if (enterprise == null) {
            JOptionPane.showMessageDialog(null, "Please select a valid Enterprise and then proceed");
            return;
        }

        usernameJTextField.setText("");
        emailIDJTextField.setText("");
        nameJTextField.setText("");

        if (!Validator.isValidString(username)) {
            JOptionPane.showMessageDialog(null, "User name can contain only alphabets. Please check.");
            return;
        }

        if (!Validator.isValidEmail(emailID)) {
            JOptionPane.showMessageDialog(null, "Email ID is in incorrect format. Please check.");
            return;
        }

        if (!Validator.isValidStringWithSpaces(name)) {
            JOptionPane.showMessageDialog(null, "Name can contain only alphabets. Please check.");
            return;
        }

        Employee employee = enterprise.getEmployeeDirectory().createEmployee(name);

        if (enterprise.getUserAccountDirectory().isUserExists(username)) {
            JOptionPane.showMessageDialog(null, "Account with the username passed already exists in the system! Please check");
            return;
        }

        //Calling the password generator utility
        String password = PasswordUtility.createPassword(username);

        UserAccount account = enterprise.getUserAccountDirectory().createUserAccount(username, password, emailID, employee, new AdminRole(Role.RoleType.Admin));

        //        if (account == null) {
        //            JOptionPane.showMessageDialog(null, "Account with the username passed already exists in the system! Please check");
        //            return;
        //        }
        //Send email to user with password.
        try {
            Email.sendMail(username, emailID, password);
        } catch (Exception exception) {
            JOptionPane.showMessageDialog(null, "We were unable to send mail to the desired recepient! Please contact system administrator");
            exception.printStackTrace();
        }

        JOptionPane.showMessageDialog(null, "User created successfully. Please check email for login credentials.");

        populateTable();
    }//GEN-LAST:event_submitJButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backJButton;
    private javax.swing.JTextField emailIDJTextField;
    private javax.swing.JComboBox enterpriseJComboBox;
    private javax.swing.JTable enterpriseJTable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private keeptoo.KGradientPanel kGradientPanel1;
    private javax.swing.JTextField nameJTextField;
    private javax.swing.JComboBox networkJComboBox;
    private javax.swing.JButton submitJButton;
    private javax.swing.JTextField usernameJTextField;
    // End of variables declaration//GEN-END:variables
}
