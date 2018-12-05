/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.chemist.workerrole;

import business.enterprise.Enterprise;
import business.organization.Organization;
import business.organization.chemist.ManagerOrganization;
import business.organization.chemist.WorkerOrganization;
import business.useraccount.UserAccount;
import business.workqueue.WorkRequest;
import business.workqueue.WorkRequestDrugs;
import commonutils.Constants;
import java.awt.CardLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author vivekdalal
 */
public class WorkerWorkAreaJPanel extends javax.swing.JPanel {

    /**
     * Creates new form WorkerWorkAreaJPanel
     */
    private JPanel userProcessContainer;
    private WorkerOrganization organization;
    private Enterprise enterprise;
    private UserAccount userAccount;

    public WorkerWorkAreaJPanel(JPanel userProcessContainer, UserAccount account, WorkerOrganization organization, Enterprise enterprise) {
        initComponents();
        this.setSize(1200, 750);
        ((DefaultTableCellRenderer) workRequestJTable.getDefaultRenderer(Object.class)).setOpaque(false);
        jScrollPane1.setOpaque(false);
        jScrollPane1.getViewport().setOpaque(false);
        this.userProcessContainer = userProcessContainer;
        this.organization = organization;
        this.enterprise = enterprise;
        this.userAccount = account;
        title.setText("Chemist Worker: " + userAccount.getUsername());
        workRequestJTable.setSize(300, 64);
        populateRequestTable();
    }

    public void populateRequestTable() {
        DefaultTableModel model = (DefaultTableModel) workRequestJTable.getModel();

        model.setRowCount(0);
        for (WorkRequest request : userAccount.getWorkQueue().getWorkRequestList()) {
            WorkRequestDrugs workRequestDrugs = (WorkRequestDrugs) request;
            Object[] row = new Object[4];
            row[0] = request;
            row[1] = request.getStatus();
            row[2] = request.getReceiver();
            row[3] = request.getMessage();
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
        viewRequest = new javax.swing.JButton();
        orderRequest = new javax.swing.JButton();
        send = new javax.swing.JButton();
        title = new javax.swing.JLabel();
        jButtonDelete = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(1200, 750));

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
                "Request ID", "Status", "Manager", "Message"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.String.class
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

        viewRequest.setText("View Request");
        viewRequest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewRequestActionPerformed(evt);
            }
        });

        orderRequest.setText("Order Request");
        orderRequest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                orderRequestActionPerformed(evt);
            }
        });

        send.setText("Send for Approval");
        send.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sendActionPerformed(evt);
            }
        });

        title.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        title.setText("title");
        title.setAlignmentX(740.0F);
        title.setAlignmentY(245.0F);

        jButtonDelete.setText("Delete Row");
        jButtonDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDeleteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout kGradientPanel1Layout = new javax.swing.GroupLayout(kGradientPanel1);
        kGradientPanel1.setLayout(kGradientPanel1Layout);
        kGradientPanel1Layout.setHorizontalGroup(
            kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(title, javax.swing.GroupLayout.PREFERRED_SIZE, 570, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(kGradientPanel1Layout.createSequentialGroup()
                            .addComponent(orderRequest)
                            .addGap(66, 66, 66)
                            .addComponent(viewRequest)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButtonDelete)
                            .addGap(58, 58, 58)
                            .addComponent(send))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 744, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(392, Short.MAX_VALUE))
        );
        kGradientPanel1Layout.setVerticalGroup(
            kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, kGradientPanel1Layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addComponent(title)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(orderRequest)
                    .addComponent(viewRequest)
                    .addComponent(send)
                    .addComponent(jButtonDelete))
                .addContainerGap(320, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(kGradientPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(kGradientPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void sendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sendActionPerformed
        // TODO add your handling code here:
        int selectedRow = workRequestJTable.getSelectedRow();

        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(null, "Please select row");
            return;
        }

        WorkRequestDrugs request = (WorkRequestDrugs) workRequestJTable.getValueAt(selectedRow, 0);
        if (!(request.getStatus().equals(Constants.Approve) || request.getStatus().equals(Constants.chemistCoworkerSendForApproval))) {
            Organization org = null;
            for (Organization organization : enterprise.getOrganizationDirectory().getOrganizationList()) {
                if (organization instanceof ManagerOrganization) {
                    org = organization;
                    org.getWorkQueue().getWorkRequestList().add(request);
                }
            }
            request.setStatus(Constants.chemistCoworkerSendForApproval);
            populateRequestTable();
        } else {
            JOptionPane.showMessageDialog(null, "Already request send");
            return;
        }

    }//GEN-LAST:event_sendActionPerformed

    private void viewRequestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewRequestActionPerformed
        int selectedRow = workRequestJTable.getSelectedRow();

        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(null, "Please select row");
            return;
        }

        WorkRequestDrugs request = (WorkRequestDrugs) workRequestJTable.getValueAt(selectedRow, 0);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        userProcessContainer.add("viewEditDrug", new ViewEditDrugsOrderJpanel(userProcessContainer, request));
        layout.next(userProcessContainer);
    }//GEN-LAST:event_viewRequestActionPerformed

    private void orderRequestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_orderRequestActionPerformed
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        userProcessContainer.add("OrderDrugs", new OrderDrugsJpanel(userProcessContainer, userAccount, enterprise));
        layout.next(userProcessContainer);
    }//GEN-LAST:event_orderRequestActionPerformed

    private void jButtonDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDeleteActionPerformed
        // TODO add your handling code here:
        int selectedRow = workRequestJTable.getSelectedRow();

        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(null, "Please select row");
            return;
        }

        WorkRequestDrugs request = (WorkRequestDrugs) workRequestJTable.getValueAt(selectedRow, 0);
        if (request.getStatus() == Constants.chemistCoworkerRequestCreated) {
            userAccount.getWorkQueue().deleteWorkRequest(request);
            populateRequestTable();
        } else {
            JOptionPane.showMessageDialog(null, "Request is already proceeded can't be delete.");
            return;
        }
    }//GEN-LAST:event_jButtonDeleteActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonDelete;
    private javax.swing.JScrollPane jScrollPane1;
    private keeptoo.KGradientPanel kGradientPanel1;
    private javax.swing.JButton orderRequest;
    private javax.swing.JButton send;
    private javax.swing.JLabel title;
    private javax.swing.JButton viewRequest;
    private javax.swing.JTable workRequestJTable;
    // End of variables declaration//GEN-END:variables
}
