/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.administrativerole;

import business.employee.Employee;
import business.enterprise.Enterprise;
import business.organization.Organization;
import business.role.Role;
import business.useraccount.UserAccount;
import commonutils.PasswordUtility;
import commonutils.Validator;
import commonutils.email.SendEmail;
import java.awt.CardLayout;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author vivekdalal
 */
public class ManageUserAccountJPanel extends javax.swing.JPanel {

    private JPanel container;
    private Enterprise enterprise;

    /**
     * Creates new form ManageUserAccountJPanel
     */
    public ManageUserAccountJPanel(JPanel container, Enterprise enterprise) {
        initComponents();
        this.setSize(1200, 750);
        this.enterprise = enterprise;
        this.container = container;
        ((DefaultTableCellRenderer) userJTable.getDefaultRenderer(Object.class)).setOpaque(false);
        jScrollPane1.setOpaque(false);
        jScrollPane1.getViewport().setOpaque(false);
        userJTable.setShowGrid(true);
        userJTable.setSize(300, 64);
        popOrganizationComboBox();
        // employeeJComboBox.removeAllItems();
        popData();
    }

    public void populateEmployeeComboBox(Organization organization) {
        employeeJComboBox.removeAllItems();

        for (Employee employee : organization.getEmployeeDirectory().getEmployeeList()) {
            employeeJComboBox.addItem(employee);
        }
    }

    private void populateRoleComboBox(Organization organization) {
        roleJComboBox.removeAllItems();
        for (Role role : organization.getSupportedRole()) {
            roleJComboBox.addItem(role);
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
        createUserJButton = new javax.swing.JButton();
        nameJTextField = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        userJTable = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        employeeJComboBox = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();
        organizationJComboBox = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        roleJComboBox = new javax.swing.JComboBox();
        emailIdJTextField = new javax.swing.JTextField();
        backJButton2 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        deleteOrgjButton = new javax.swing.JButton();

        setBackground(new java.awt.Color(204, 204, 204));
        setMaximumSize(new java.awt.Dimension(1200, 750));
        setMinimumSize(new java.awt.Dimension(1200, 750));
        setPreferredSize(new java.awt.Dimension(1200, 750));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        kGradientPanel1.setkEndColor(new java.awt.Color(102, 255, 204));
        kGradientPanel1.setkStartColor(new java.awt.Color(204, 255, 204));
        kGradientPanel1.setMaximumSize(new java.awt.Dimension(1200, 750));
        kGradientPanel1.setMinimumSize(new java.awt.Dimension(1200, 750));
        kGradientPanel1.setPreferredSize(new java.awt.Dimension(1200, 750));
        kGradientPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        createUserJButton.setText("Create");
        createUserJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createUserJButtonActionPerformed(evt);
            }
        });
        kGradientPanel1.add(createUserJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 610, -1, 60));
        kGradientPanel1.add(nameJTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 550, 250, -1));

        jLabel1.setText("User Name");
        kGradientPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 550, -1, -1));

        userJTable.setBackground(new java.awt.Color(102, 255, 204));
        userJTable.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        userJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "User Name", "Role"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        userJTable.setSelectionBackground(new java.awt.Color(102, 255, 204));
        userJTable.setSelectionForeground(new java.awt.Color(0, 0, 0));
        jScrollPane1.setViewportView(userJTable);

        kGradientPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 160, 750, 220));

        jLabel2.setText("Email ID");
        kGradientPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 590, -1, -1));

        jLabel3.setText("Employee");
        kGradientPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 480, -1, -1));

        kGradientPanel1.add(employeeJComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 470, 250, -1));

        jLabel5.setText("Organization");
        kGradientPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 440, -1, -1));

        organizationJComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                organizationJComboBoxActionPerformed(evt);
            }
        });
        kGradientPanel1.add(organizationJComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 430, 250, -1));

        jLabel4.setText("Role");
        kGradientPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 520, -1, -1));

        kGradientPanel1.add(roleJComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 510, 250, -1));
        kGradientPanel1.add(emailIdJTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 580, 250, -1));

        backJButton2.setText("<< Back");
        backJButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backJButton2ActionPerformed(evt);
            }
        });
        kGradientPanel1.add(backJButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, -1, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 51, 255));
        jLabel6.setText("Manage User Account");
        kGradientPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 80, 280, 50));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/icons/admin-internal.png"))); // NOI18N
        kGradientPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 90, 100));

        deleteOrgjButton.setText("Delete");
        kGradientPanel1.add(deleteOrgjButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 390, -1, -1));

        add(kGradientPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1200, 750));
    }// </editor-fold>//GEN-END:initComponents

    private void createUserJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createUserJButtonActionPerformed
        String userName = nameJTextField.getText();
        //String password = passwordJTextField.getText();
        String emailID = emailIdJTextField.getText();

        //Validations remaining
        if (!Validator.isValidUsername(userName)) {
            JOptionPane.showMessageDialog(null, "Username in incorrect format. Should be 2 to 25 characters "
                    + "and characters, numbers and the ., -, _ symbols");
            return;
        }

        String password = PasswordUtility.createPassword(userName);

        Organization organization = (Organization) organizationJComboBox.getSelectedItem();
        Employee employee = (Employee) employeeJComboBox.getSelectedItem();
        Role role = (Role) roleJComboBox.getSelectedItem();

        if (employee == null || role == null) {
            JOptionPane.showMessageDialog(null, "Please fill correct information in employee and role fields");
            return;
        }

        UserAccount userAccount = organization.getUserAccountDirectory().createUserAccount(userName, password, emailID, employee, role);

        if (userAccount == null) {
            JOptionPane.showMessageDialog(null, "Username already exists in this organization! Please check");
            return;
        }
        //Send email to user with password.
        ExecutorService executor = Executors.newSingleThreadExecutor();

        Runnable runnableTask = () -> {
            try {
                System.out.println("Executor task started");
                SendEmail sendEmail = new SendEmail();
                sendEmail.sendMail(userName, emailID, password);

            } catch (Exception exception) {
                //JOptionPane.showMessageDialog(null, "We were unable to send mail to the desired recepient! Please contact system administrator");
                exception.printStackTrace();
            }
        };

        executor.execute(runnableTask);

        executor.shutdown();

//        try {
//            SendEmail sendEmail = new SendEmail();
//
//            sendEmail.sendMail(userName, emailID, password);
//        } catch (Exception exception) {
//            JOptionPane.showMessageDialog(null, "We were unable to send mail to the desired recepient! Please contact system administrator");
//            exception.printStackTrace();
//        }
        JOptionPane.showMessageDialog(null, "User created successfully. Please check email for login credentials.");
        organizationJComboBox.setSelectedIndex(0);
        employeeJComboBox.setSelectedIndex(0);
        roleJComboBox.setSelectedIndex(0);
        nameJTextField.setText("");
        emailIdJTextField.setText("");
        popData();
    }//GEN-LAST:event_createUserJButtonActionPerformed

    private void organizationJComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_organizationJComboBoxActionPerformed
        Organization organization = (Organization) organizationJComboBox.getSelectedItem();
        if (organization != null) {
            populateEmployeeComboBox(organization);
            populateRoleComboBox(organization);
        }
    }//GEN-LAST:event_organizationJComboBoxActionPerformed

    private void backJButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backJButton2ActionPerformed

        container.remove(this);
        CardLayout layout = (CardLayout) container.getLayout();
        layout.previous(container);
    }//GEN-LAST:event_backJButton2ActionPerformed

    public void popOrganizationComboBox() {
        organizationJComboBox.removeAllItems();

        for (Organization organization : enterprise.getOrganizationDirectory().getOrganizationList()) {
            organizationJComboBox.addItem(organization);
        }
    }

    public void popData() {

        DefaultTableModel model = (DefaultTableModel) userJTable.getModel();

        model.setRowCount(0);

        for (Organization organization : enterprise.getOrganizationDirectory().getOrganizationList()) {

            for (UserAccount userAccount : organization.getUserAccountDirectory().getUserAccountListValues()) {
                Object row[] = new Object[2];
                row[0] = userAccount;
                row[1] = userAccount.getRole();
                ((DefaultTableModel) userJTable.getModel()).addRow(row);
            }

        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backJButton2;
    private javax.swing.JButton createUserJButton;
    private javax.swing.JButton deleteOrgjButton;
    private javax.swing.JTextField emailIdJTextField;
    private javax.swing.JComboBox employeeJComboBox;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private keeptoo.KGradientPanel kGradientPanel1;
    private javax.swing.JTextField nameJTextField;
    private javax.swing.JComboBox organizationJComboBox;
    private javax.swing.JComboBox roleJComboBox;
    private javax.swing.JTable userJTable;
    // End of variables declaration//GEN-END:variables
}
