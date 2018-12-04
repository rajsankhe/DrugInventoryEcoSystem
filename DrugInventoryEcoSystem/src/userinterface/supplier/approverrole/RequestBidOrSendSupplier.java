/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.supplier.approverrole;

import business.EcoSystem;
import business.enterprise.Enterprise;
import business.organization.supplier.ApproverOrganization;
import business.useraccount.UserAccount;
import business.workqueue.WorkRequest;
import business.workqueue.WorkRequestDrugs;
import java.awt.CardLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Raj Sankhe
 */
public class RequestBidOrSendSupplier extends javax.swing.JPanel {

    /**
     * Creates new form RequestBidOrSendSupplier
     */
    private JPanel userProcessContainer;
    private ApproverOrganization organization;
    private Enterprise enterprise;
    private UserAccount userAccount;
    private EcoSystem ecosystem;
   public RequestBidOrSendSupplier(JPanel userProcessContainer, EcoSystem ecosystem, WorkRequestDrugs request) {
       initComponents(); 
       requestBid.setEnabled(false);
       
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
        requestBid = new javax.swing.JButton();
        title = new javax.swing.JLabel();
        sendToSupplier = new javax.swing.JButton();
        messageLabel = new javax.swing.JLabel();

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
                "Drug Name", "Inventory Count", "Order Count", "Request Count"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class
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

        requestBid.setText("Request Bid");
        requestBid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                requestBidActionPerformed(evt);
            }
        });

        title.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        title.setText("Decision Screen");
        title.setAlignmentX(740.0F);
        title.setAlignmentY(245.0F);

        sendToSupplier.setText("Send To Supplier");
        sendToSupplier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sendToSupplierActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout kGradientPanel1Layout = new javax.swing.GroupLayout(kGradientPanel1);
        kGradientPanel1.setLayout(kGradientPanel1Layout);
        kGradientPanel1Layout.setHorizontalGroup(
            kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(kGradientPanel1Layout.createSequentialGroup()
                        .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                                .addGap(33, 33, 33)
                                .addComponent(requestBid)
                                .addGap(399, 399, 399)
                                .addComponent(sendToSupplier))
                            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                                .addGap(89, 89, 89)
                                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(title, javax.swing.GroupLayout.PREFERRED_SIZE, 553, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(messageLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 415, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, kGradientPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 669, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        kGradientPanel1Layout.setVerticalGroup(
            kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(title)
                .addGap(10, 10, 10)
                .addComponent(messageLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(requestBid)
                    .addComponent(sendToSupplier))
                .addContainerGap(52, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 717, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(kGradientPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 717, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 424, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(kGradientPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 424, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void requestBidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_requestBidActionPerformed
        // TODO add your handling code here:
        int selectedRow = workRequestJTable.getSelectedRow();
        if (selectedRow < 0){
            JOptionPane.showMessageDialog(null, "Please select row");
            return;
        }

        WorkRequestDrugs request = (WorkRequestDrugs)workRequestJTable.getValueAt(selectedRow, 0);
        if(request.getReceiver()==null){
            request.setReceiver(userAccount);
            populateRequestTable();
        }
        else{
            JOptionPane.showMessageDialog(null, "Already assinged to "+request.getReceiver());
            return;
        }
    }//GEN-LAST:event_requestBidActionPerformed

    private void sendToSupplierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sendToSupplierActionPerformed
        // TODO add your handling code here:
        int selectedRow = workRequestJTable.getSelectedRow();

        if (selectedRow < 0){
            JOptionPane.showMessageDialog(null, "Please select row");
            return;
        }
        WorkRequestDrugs request = (WorkRequestDrugs)workRequestJTable.getValueAt(selectedRow, 0);
        if(request.getReceiver()== userAccount){
            CardLayout layout = (CardLayout) userProcessContainer.getLayout();
            userProcessContainer.add("RequestBid", new RequestBidOrSendSupplier(userProcessContainer,ecosystem, request ));
            layout.next(userProcessContainer);
        }
        else{
            JOptionPane.showMessageDialog(null, "Assign request to you.");
        }

    }//GEN-LAST:event_sendToSupplierActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private keeptoo.KGradientPanel kGradientPanel1;
    private javax.swing.JLabel messageLabel;
    private javax.swing.JButton requestBid;
    private javax.swing.JButton sendToSupplier;
    private javax.swing.JLabel title;
    private javax.swing.JTable workRequestJTable;
    // End of variables declaration//GEN-END:variables

    private void populateRequestTable() {
        DefaultTableModel model = (DefaultTableModel) workRequestJTable.getModel();  
        model.setRowCount(0);
        for (WorkRequest request : organization.getWorkQueue().getWorkRequestList()){
            WorkRequestDrugs workRequestDrugs = (WorkRequestDrugs)request;            
            Object[] row = new Object[4];
            row[0] = request;
            row[1] = request.getStatus();
            row[2] = request.getSender();
            row[3] = request.getReceiver();
            model.addRow(row);
    }
    }   
}

