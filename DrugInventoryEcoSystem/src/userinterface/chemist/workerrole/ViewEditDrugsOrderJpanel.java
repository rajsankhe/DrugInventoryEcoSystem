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
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

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
    private static final Logger log = LogManager.getLogger(ViewEditDrugsOrderJpanel.class);

    public ViewEditDrugsOrderJpanel(JPanel userProcessContainer, WorkRequestDrugs workRequestDrugs, boolean orderPros) {
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
        update.setEnabled(false);
        drugquantity.setEnabled(false);
        drugquantity.setSize(300, 64);
        this.userProcessContainer = userProcessContainer;
        this.workRequestDrugs = workRequestDrugs;
        if (workRequestDrugs.getStatus().equals(Constants.ManagerReject) || workRequestDrugs.getStatus().equals(Constants.chemistCoworkerRequestCreated) || 
                workRequestDrugs.getStatus().equals(Constants.rejectedByLegal) || workRequestDrugs.getStatus().equals(Constants.orderCannotBeFullfilled)){
            update.setEnabled(true);
        }
        drugquantity.setShowGrid(true);
        //drugquantity.getTableHeader().setOpaque(false);
        // drugquantity.getTableHeader().setBackground(Color.BLUE);
        //drugquantity.getTableHeader().setForeground(Color.BLACK);

        //JTableHeader tableHeader = drugquantity.getTableHeader();
        //tableHeader.setBackground(Color.red);
        this.setSize(1200, 750);
        this.userProcessContainer = userProcessContainer;
        this.workRequestDrugs = workRequestDrugs;
        if (orderPros == true) {
            update.setEnabled(false);
        }
        populateRequestTable();
    }

    public void populateRequestTable() {
        DefaultTableModel model = (DefaultTableModel) drugquantity.getModel();

        model.setRowCount(0);
        for (Drug drug : workRequestDrugs.getDrugsOrderList()) {
            Object[] row = new Object[2];
            row[0] = drug;
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
        jLabel2 = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(1200, 750));

        kGradientPanel1.setkEndColor(new java.awt.Color(102, 204, 255));
        kGradientPanel1.setkStartColor(new java.awt.Color(183, 248, 230));
        kGradientPanel1.setPreferredSize(new java.awt.Dimension(1200, 750));

        jScrollPane1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        drugquantity.setBackground(new java.awt.Color(153, 255, 255));
        drugquantity.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        drugquantity.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        drugquantity.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Drug", "Quantity"
            }
        ));
        drugquantity.setAlignmentX(740.0F);
        drugquantity.setAlignmentY(245.0F);
        drugquantity.setGridColor(new java.awt.Color(0, 0, 0));
        drugquantity.setOpaque(false);
        drugquantity.setPreferredSize(new java.awt.Dimension(300, 64));
        drugquantity.setSelectionBackground(new java.awt.Color(153, 255, 255));
        drugquantity.setSelectionForeground(new java.awt.Color(0, 0, 0));
        jScrollPane1.setViewportView(drugquantity);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("View and Update Order Details");
        jLabel1.setAlignmentX(740.0F);
        jLabel1.setAlignmentY(245.0F);

        update.setText("Update");
        update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateActionPerformed(evt);
            }
        });

        addRow.setText("Add Row");
        addRow.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addRowActionPerformed(evt);
            }
        });

        save.setText("Save");
        save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveActionPerformed(evt);
            }
        });

        back.setText("<< Back");
        back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backActionPerformed(evt);
            }
        });

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/icons/edit.png"))); // NOI18N

        javax.swing.GroupLayout kGradientPanel1Layout = new javax.swing.GroupLayout(kGradientPanel1);
        kGradientPanel1.setLayout(kGradientPanel1Layout);
        kGradientPanel1Layout.setHorizontalGroup(
            kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(kGradientPanel1Layout.createSequentialGroup()
                        .addGap(80, 80, 80)
                        .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                                .addComponent(update)
                                .addGap(226, 226, 226)
                                .addComponent(addRow)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(save))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 700, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(kGradientPanel1Layout.createSequentialGroup()
                        .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2)
                            .addComponent(back))
                        .addGap(184, 184, 184)
                        .addComponent(jLabel1)))
                .addContainerGap(414, Short.MAX_VALUE))
        );
        kGradientPanel1Layout.setVerticalGroup(
            kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(back))
                .addGap(43, 43, 43)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(update)
                    .addComponent(addRow)
                    .addComponent(save))
                .addContainerGap(314, Short.MAX_VALUE))
        );

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
        List<Drug> orderList = new ArrayList<>();
        try {
            DefaultTableModel model = (DefaultTableModel) drugquantity.getModel();
            int nRow = model.getRowCount();
            for (int i = 0; i < nRow; i++) {
                if (!(model.getValueAt(i, 0).equals("") || model.getValueAt(i, 1).equals(""))) {
                    String drugName = String.valueOf(model.getValueAt(i, 0));
                    if (orderList.stream().noneMatch(d -> d.getName().equalsIgnoreCase(drugName))) {
                        Drug newDrug = new Drug();
                        newDrug.setName(String.valueOf(model.getValueAt(i, 0)));
                        newDrug.setQuantity(Integer.parseInt((String) model.getValueAt(i, 1)));
                        orderList.add(newDrug);
                    } else {
                        JOptionPane.showMessageDialog(null, "Double entries of " + drugName + " is not allowed.");
                        return;
                    }
                } else {
                    if (!(model.getValueAt(i, 0).equals("") && model.getValueAt(i, 1).equals(""))) {
                        if (model.getValueAt(i, 0).equals("")) {
                            JOptionPane.showMessageDialog(null, "Enter drug name");
                            return;
                        } else {
                            JOptionPane.showMessageDialog(null, "Enter quantity of drug");
                            return;
                        }
                    }
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Please enter integer value in quantity field.");
            return;
        }
        if (!orderList.isEmpty()) {
            workRequestDrugs.setDrugsOrderList(orderList);
            drugquantity.setEnabled(false);
            addRow.setEnabled(false);
            save.setEnabled(false);
            update.setEnabled(true);
            JOptionPane.showMessageDialog(null, "Order list updated.");
            log.info("Order Updated");
        } else {
            JOptionPane.showMessageDialog(null, "Order list can't be empty.");
            return;
        }

        // TODO add your handling code here:
    }//GEN-LAST:event_saveActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addRow;
    private javax.swing.JButton back;
    private javax.swing.JTable drugquantity;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private keeptoo.KGradientPanel kGradientPanel1;
    private javax.swing.JButton save;
    private javax.swing.JButton update;
    // End of variables declaration//GEN-END:variables
}
