/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.chemist.workerrole;

import business.drug.Drug;
import business.workqueue.WorkRequestDrugs;
import commonutils.Constants;
import java.awt.CardLayout;
import java.awt.Component;
import java.util.List;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Tej Sankhe
 */
public class ViewEditDrugsOrderJpanel extends javax.swing.JPanel {

    /**
     * Creates new form OrderDrugsJpanel
     */
    private JPanel userProcessContainer;
    private WorkRequestDrugs workRequestDrugs;

    public ViewEditDrugsOrderJpanel(JPanel userProcessContainer, WorkRequestDrugs workRequestDrugs) {
        initComponents();
        //drugquantity.setEnabled(false);
        //drugquantity.setOpaque(false);
        ((DefaultTableCellRenderer) drugquantity.getDefaultRenderer(Object.class)).setOpaque(false);
        //((DefaultTableCellRenderer) drugquantity.getDefaultRenderer(Object.class)).setBackground(Color.red);
        //headerRenderer
        jScrollPane1.setOpaque(false);
        jScrollPane1.getViewport().setOpaque(false);
        save.setEnabled(false);
        addRow.setEnabled(false);
        update.setEnabled(true);
        this.userProcessContainer = userProcessContainer;
        this.workRequestDrugs = workRequestDrugs;
        if (workRequestDrugs.getStatus() == Constants.Approve || workRequestDrugs.getStatus() == Constants.chemistCoworkerSendForApproval) {
            update.setEnabled(false);
        }
        drugquantity.setShowGrid(true);
        //drugquantity.getTableHeader().setOpaque(false);
        // drugquantity.getTableHeader().setBackground(Color.BLUE);
        //drugquantity.getTableHeader().setForeground(Color.BLACK);

        //JTableHeader tableHeader = drugquantity.getTableHeader();
        //tableHeader.setBackground(Color.red);
        this.setSize(1480, 1050);
        this.userProcessContainer = userProcessContainer;
        this.workRequestDrugs = workRequestDrugs;

        populateRequestTable();
    }

    public void populateRequestTable() {
        DefaultTableModel model = (DefaultTableModel) drugquantity.getModel();

        model.setRowCount(0);
        for (Drug drug : workRequestDrugs.getDrugsOrderList()) {
            Object[] row = new Object[2];
            row[0] = drug.getName();
            row[1] = Integer.toString(drug.getQuantity());
            model.addRow(row);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        kGradientPanel1 = new keeptoo.KGradientPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        drugquantity = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        update = new javax.swing.JButton();
        addRow = new javax.swing.JButton();
        save = new javax.swing.JButton();
        back = new javax.swing.JButton();

        kGradientPanel1.setkEndColor(new java.awt.Color(102, 204, 255));
        kGradientPanel1.setkStartColor(new java.awt.Color(183, 248, 230));
        kGradientPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        drugquantity.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        drugquantity.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Drug", "Quantity"
            }
        ));
        drugquantity.setAlignmentX(740.0F);
        drugquantity.setAlignmentY(245.0F);
        drugquantity.setOpaque(false);
        jScrollPane1.setViewportView(drugquantity);

        kGradientPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 130, 580, 230));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("View and Update Order Details");
        jLabel1.setAlignmentX(740.0F);
        jLabel1.setAlignmentY(245.0F);
        kGradientPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 60, -1, -1));

        update.setText("Update");
        update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateActionPerformed(evt);
            }
        });
        kGradientPanel1.add(update, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 400, -1, -1));

        addRow.setText("Add Row");
        addRow.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addRowActionPerformed(evt);
            }
        });
        kGradientPanel1.add(addRow, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 370, -1, -1));

        save.setText("Save");
        save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveActionPerformed(evt);
            }
        });
        kGradientPanel1.add(save, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 400, -1, -1));

        back.setText("Back");
        back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backActionPerformed(evt);
            }
        });
        kGradientPanel1.add(back, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(kGradientPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(kGradientPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed
        // TODO add your handling code here:
        userProcessContainer.remove(this);
        Component[] componentArray = userProcessContainer.getComponents();
        Component component = componentArray[componentArray.length - 1];
        WorkerWorkAreaJPanel workAreaJPanel = (WorkerWorkAreaJPanel) component;
        workAreaJPanel.populateRequestTable();
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_backActionPerformed

    private void updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateActionPerformed
        // TODO add your handling code here:
        drugquantity.setEnabled(true);
        addRow.setEnabled(true);
        save.setEnabled(true);
        update.setEnabled(false);
    }//GEN-LAST:event_updateActionPerformed

    private void addRowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addRowActionPerformed
        DefaultTableModel model = (DefaultTableModel) drugquantity.getModel();
        model.addRow(new Object[]{"", ""});
    }//GEN-LAST:event_addRowActionPerformed

    private void saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveActionPerformed
        List<Drug> orderList = workRequestDrugs.getDrugsOrderList();
        orderList.removeAll(orderList);
        DefaultTableModel model = (DefaultTableModel) drugquantity.getModel();
        int nRow = model.getRowCount();
        for (int i = 0; i < nRow; i++) {
            if (model.getValueAt(i, 0) != null && model.getValueAt(i, 1) != null) {
                Drug newDrug = new Drug();
                newDrug.setName(String.valueOf(model.getValueAt(i, 0)));
                newDrug.setQuantity(Integer.parseInt((String) model.getValueAt(i, 1)));
                orderList.add(newDrug);
            }
        }
        drugquantity.setEnabled(false);
        addRow.setEnabled(false);
        save.setEnabled(false);
        update.setEnabled(true);
        // TODO add your handling code here:
    }//GEN-LAST:event_saveActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addRow;
    private javax.swing.JButton back;
    private javax.swing.JTable drugquantity;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private keeptoo.KGradientPanel kGradientPanel1;
    private javax.swing.JButton save;
    private javax.swing.JButton update;
    // End of variables declaration//GEN-END:variables
}
