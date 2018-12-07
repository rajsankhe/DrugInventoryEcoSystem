/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.chemist.managerrole;

import business.EcoSystem;
import business.enterprise.Enterprise;
import business.organization.chemist.ManagerOrganization;
import business.useraccount.UserAccount;
import business.workqueue.WorkRequest;
import business.workqueue.WorkRequestDrugs;
import commonutils.Constants;
import java.awt.CardLayout;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author vivekdalal
 */
public class ManagerWorkAreaJPanel extends javax.swing.JPanel {

    /**
     * Creates new form ManagerWorkAreaJPanel
     */
    private JPanel userProcessContainer;
    private ManagerOrganization organization;
    private Enterprise enterprise;
    private UserAccount userAccount;
    private EcoSystem ecosystem;

    public ManagerWorkAreaJPanel(JPanel userProcessContainer, UserAccount account, ManagerOrganization organization, Enterprise enterprise, EcoSystem ecosystem) {
        initComponents();
        this.setSize(1200, 750);
        ((DefaultTableCellRenderer) workRequestJTable.getDefaultRenderer(Object.class)).setOpaque(false);
        jScrollPane1.setOpaque(false);
        jScrollPane1.getViewport().setOpaque(false);
        this.userProcessContainer = userProcessContainer;
        this.organization = organization;
        this.enterprise = enterprise;
        this.userAccount = account;
        this.ecosystem = ecosystem;
        title.setText("Chemist Manager: " + userAccount.getUsername());
        populateRequestTable();
    }

    public void populateRequestTable() {
        DefaultTableModel model = (DefaultTableModel) workRequestJTable.getModel();

        model.setRowCount(0);
        for (WorkRequest request : organization.getWorkQueue().getWorkRequestList()) {
            WorkRequestDrugs workRequestDrugs = (WorkRequestDrugs) request;
            Object[] row = new Object[4];
            row[0] = request;
            row[1] = request.getStatus();
            row[2] = request.getSender();
            row[3] = request.getReceiver();
            model.addRow(row);
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
        workRequestJTable = new javax.swing.JTable();
        assignToMe = new javax.swing.JButton();
        viewRequest = new javax.swing.JButton();
        reject = new javax.swing.JButton();
        title = new javax.swing.JLabel();
        sendToSupplier = new javax.swing.JButton();
        approve = new javax.swing.JButton();

        kGradientPanel1.setkEndColor(new java.awt.Color(102, 204, 255));
        kGradientPanel1.setkStartColor(new java.awt.Color(183, 248, 230));
        kGradientPanel1.setPreferredSize(new java.awt.Dimension(1200, 750));

        workRequestJTable.setBackground(new java.awt.Color(153, 255, 255));
        workRequestJTable.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        workRequestJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Request ID", "Status", "Sender", "Receiver"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        workRequestJTable.setGridColor(new java.awt.Color(0, 0, 0));
        workRequestJTable.setSelectionBackground(new java.awt.Color(153, 255, 255));
        workRequestJTable.setSelectionForeground(new java.awt.Color(0, 0, 0));
        jScrollPane1.setViewportView(workRequestJTable);
        if (workRequestJTable.getColumnModel().getColumnCount() > 0) {
            workRequestJTable.getColumnModel().getColumn(0).setResizable(false);
            workRequestJTable.getColumnModel().getColumn(1).setResizable(false);
            workRequestJTable.getColumnModel().getColumn(2).setResizable(false);
            workRequestJTable.getColumnModel().getColumn(3).setResizable(false);
        }

        assignToMe.setText("Assign To Me");
        assignToMe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                assignToMeActionPerformed(evt);
            }
        });

        viewRequest.setText("View");
        viewRequest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewRequestActionPerformed(evt);
            }
        });

        reject.setText("Reject");
        reject.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rejectActionPerformed(evt);
            }
        });

        title.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        title.setText("Title");
        title.setAlignmentX(740.0F);
        title.setAlignmentY(245.0F);

        sendToSupplier.setText("Send To Supplier");
        sendToSupplier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sendToSupplierActionPerformed(evt);
            }
        });

        approve.setText("Approve");
        approve.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                approveActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout kGradientPanel1Layout = new javax.swing.GroupLayout(kGradientPanel1);
        kGradientPanel1.setLayout(kGradientPanel1Layout);
        kGradientPanel1Layout.setHorizontalGroup(
            kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(kGradientPanel1Layout.createSequentialGroup()
                        .addComponent(assignToMe)
                        .addGap(41, 41, 41)
                        .addComponent(viewRequest)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(approve)
                        .addGap(51, 51, 51)
                        .addComponent(sendToSupplier)
                        .addGap(55, 55, 55)
                        .addComponent(reject))
                    .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(title, javax.swing.GroupLayout.PREFERRED_SIZE, 554, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 669, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(462, Short.MAX_VALUE))
        );
        kGradientPanel1Layout.setVerticalGroup(
            kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(title)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(assignToMe)
                    .addComponent(viewRequest)
                    .addComponent(reject)
                    .addComponent(sendToSupplier)
                    .addComponent(approve))
                .addContainerGap(351, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(kGradientPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1170, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(kGradientPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 718, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void assignToMeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_assignToMeActionPerformed
        // TODO add your handling code here:
        int selectedRow = workRequestJTable.getSelectedRow();
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(null, "Please select row");
            return;
        }

        WorkRequestDrugs request = (WorkRequestDrugs) workRequestJTable.getValueAt(selectedRow, 0);
        if (request.getReceiver() == null) {
            request.setReceiver(userAccount);
            populateRequestTable();
        } else {
            JOptionPane.showMessageDialog(null, "Already assinged to " + request.getReceiver());
            return;
        }
    }//GEN-LAST:event_assignToMeActionPerformed

    private void viewRequestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewRequestActionPerformed
        // TODO add your handling code here:
        int selectedRow = workRequestJTable.getSelectedRow();

        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(null, "Please select row");
            return;
        }

        WorkRequestDrugs request = (WorkRequestDrugs) workRequestJTable.getValueAt(selectedRow, 0);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        userProcessContainer.add("viewEditDrug", new ViewOrderjpanel(userProcessContainer, request, enterprise));
        layout.next(userProcessContainer);
    }//GEN-LAST:event_viewRequestActionPerformed

    private void sendToSupplierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sendToSupplierActionPerformed
        // TODO add your handling code here:
        int selectedRow = workRequestJTable.getSelectedRow();

        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(null, "Please select row");
            return;
        }

        WorkRequestDrugs request = (WorkRequestDrugs) workRequestJTable.getValueAt(selectedRow, 0);
        if (!(Constants.sentToSupplier).equalsIgnoreCase(request.getStatus())) {
            if (!(Constants.Approve).equalsIgnoreCase(request.getStatus())) {
                JOptionPane.showMessageDialog(null, "Request Approved can only be send to Supplier");
                return;
            } else {

                CardLayout layout = (CardLayout) userProcessContainer.getLayout();
                userProcessContainer.add("ChooseSupplier", new AssignToSupplier(userProcessContainer, ecosystem, request, this.enterprise));
                layout.next(userProcessContainer);
            }

        } else {
            JOptionPane.showMessageDialog(null, "Request already send to Supplier");
        }

    }//GEN-LAST:event_sendToSupplierActionPerformed

    private void rejectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rejectActionPerformed
        // TODO add your handling code here:
        int selectedRow = workRequestJTable.getSelectedRow();

        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(null, "Please select row");
            return;
        }

        WorkRequestDrugs request = (WorkRequestDrugs) workRequestJTable.getValueAt(selectedRow, 0);
        if (request.getReceiver() == userAccount) {
            request.setStatus(Constants.Reject);
            JFrame frame = new JFrame();
            String message = (String) JOptionPane.showInputDialog(frame,
                    "Enter the message",
                    Constants.Reject + " message",
                    JOptionPane.OK_CANCEL_OPTION);
            request.setMessage(message);

            organization.getWorkQueue().getWorkRequestList().remove(request);
            populateRequestTable();
        } else {
            JOptionPane.showMessageDialog(null, "Assign request to you.");
        }

        //WorkRequestDrugs wr= request.getSender().getWorkQueue().getWorkRequestList().stream().filter(x -> x==request).findFirst().get();
    }//GEN-LAST:event_rejectActionPerformed

    private void approveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_approveActionPerformed
        // TODO add your handling code here:
        int selectedRow = workRequestJTable.getSelectedRow();

        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(null, "Please select row");
            return;
        }

        WorkRequestDrugs request = (WorkRequestDrugs) workRequestJTable.getValueAt(selectedRow, 0);
        if (request.getReceiver() == userAccount) {
            request.setStatus(Constants.Approve);
            JFrame frame = new JFrame();
            String message = (String) JOptionPane.showInputDialog(frame,
                    "Enter the message",
                    Constants.Approve + " message",
                    JOptionPane.OK_CANCEL_OPTION);
            request.setMessage(message);
            populateRequestTable();
        } else {
            JOptionPane.showMessageDialog(null, "Assign request to you.");
        }
    }//GEN-LAST:event_approveActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton approve;
    private javax.swing.JButton assignToMe;
    private javax.swing.JScrollPane jScrollPane1;
    private keeptoo.KGradientPanel kGradientPanel1;
    private javax.swing.JButton reject;
    private javax.swing.JButton sendToSupplier;
    private javax.swing.JLabel title;
    private javax.swing.JButton viewRequest;
    private javax.swing.JTable workRequestJTable;
    // End of variables declaration//GEN-END:variables
}
