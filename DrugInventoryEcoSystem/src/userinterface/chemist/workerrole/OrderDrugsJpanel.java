/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.chemist.workerrole;

import business.drug.Drug;
import business.enterprise.ChemistEnterprise;
import business.enterprise.Enterprise;
import business.useraccount.UserAccount;
import business.workqueue.WorkRequest;
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

/**
 *
 * @author Tej Sankhe
 */
public class OrderDrugsJpanel extends javax.swing.JPanel {

    /**
     * Creates new form OrderDrugsJpanel
     */
    private JPanel userProcessContainer;
    private UserAccount userAccount;
    private ChemistEnterprise enterprise;

    public OrderDrugsJpanel(JPanel userProcessContainer, UserAccount account, Enterprise enterprise) {
        initComponents();
        this.setSize(1200, 750);
        ((DefaultTableCellRenderer)drugquantity.getDefaultRenderer(Object.class)).setOpaque(false);
        jScrollPane1.setOpaque(false);
        jScrollPane1.getViewport().setOpaque(false);
        this.userProcessContainer = userProcessContainer;
        this.userAccount = account;
        this.enterprise = (ChemistEnterprise) enterprise;
        drugquantity.setSize(300, 64);
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
        drugquantity = new javax.swing.JTable();
        addRow = new javax.swing.JButton();
        submit = new javax.swing.JButton();
        back = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButtonCheckInventory = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(1200, 750));

        kGradientPanel1.setkEndColor(new java.awt.Color(102, 204, 255));
        kGradientPanel1.setkStartColor(new java.awt.Color(183, 248, 230));
        kGradientPanel1.setPreferredSize(new java.awt.Dimension(1200, 750));

        drugquantity.setBackground(new java.awt.Color(153, 255, 255));
        drugquantity.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
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
        drugquantity.setGridColor(new java.awt.Color(0, 0, 0));
        drugquantity.setSelectionBackground(new java.awt.Color(153, 255, 255));
        drugquantity.setSelectionForeground(new java.awt.Color(0, 0, 0));
        jScrollPane1.setViewportView(drugquantity);

        addRow.setText("Add Row");
        addRow.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addRowActionPerformed(evt);
            }
        });

        submit.setText("Submit");
        submit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitActionPerformed(evt);
            }
        });

        back.setText("<< Back");
        back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setAlignmentX(740.0F);
        jLabel1.setAlignmentY(245.0F);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel2.setText("Order Drugs");
        jLabel2.setAlignmentX(740.0F);
        jLabel2.setAlignmentY(245.0F);

        jButtonCheckInventory.setText("Check Inventory");
        jButtonCheckInventory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCheckInventoryActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout kGradientPanel1Layout = new javax.swing.GroupLayout(kGradientPanel1);
        kGradientPanel1.setLayout(kGradientPanel1Layout);
        kGradientPanel1Layout.setHorizontalGroup(
            kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                .addContainerGap(1017, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(183, 183, 183))
            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(kGradientPanel1Layout.createSequentialGroup()
                        .addComponent(back)
                        .addGap(300, 300, 300)
                        .addComponent(jLabel2))
                    .addGroup(kGradientPanel1Layout.createSequentialGroup()
                        .addGap(230, 230, 230)
                        .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                                .addComponent(submit)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButtonCheckInventory)
                                .addGap(75, 75, 75)
                                .addComponent(addRow))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 519, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(0, 20, Short.MAX_VALUE))
        );
        kGradientPanel1Layout.setVerticalGroup(
            kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(back))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(submit)
                    .addComponent(addRow)
                    .addComponent(jButtonCheckInventory))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(359, 359, 359))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(kGradientPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(kGradientPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void submitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitActionPerformed

        List<Drug> orderList = new ArrayList<>();
        DefaultTableModel model = (DefaultTableModel) drugquantity.getModel();
        int nRow = model.getRowCount();
        try{
            for (int i = 0; i < nRow; i++) {
            if (model.getValueAt(i, 0) != null && model.getValueAt(i, 1) != null) {
                Drug newDrug = new Drug();
                newDrug.setName(String.valueOf(model.getValueAt(i, 0)));
                newDrug.setQuantity(Integer.parseInt((String) model.getValueAt(i, 1)));
                orderList.add(newDrug);
            }
        }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, "Please enter integer value in quantity field.");
            return;
        }
        if(!orderList.isEmpty()){
        WorkRequestDrugs workRequestDrugs = (WorkRequestDrugs) userAccount.getWorkQueue().addWorkRequest(WorkRequest.workRequestType.Drugs);
        workRequestDrugs.setSender(userAccount);    
        workRequestDrugs.setStatus(Constants.chemistCoworkerRequestCreated);
        workRequestDrugs.setDrugsOrderList(orderList);
        userProcessContainer.remove(this);
        Component[] componentArray = userProcessContainer.getComponents();
        Component component = componentArray[componentArray.length - 1];
        WorkerWorkAreaJPanel workAreaJPanel = (WorkerWorkAreaJPanel) component;
        workAreaJPanel.populateRequestTable();
        CardLayout layout = (CardLayout)userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
        }
        else{
            JOptionPane.showMessageDialog(null, "Order list can't be empty.");
            return;
        }
    }//GEN-LAST:event_submitActionPerformed

    private void addRowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addRowActionPerformed
        DefaultTableModel model = (DefaultTableModel) drugquantity.getModel();
        model.addRow(new Object[]{"", ""});
    }//GEN-LAST:event_addRowActionPerformed

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

    private void jButtonCheckInventoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCheckInventoryActionPerformed
        // TODO add your handling code here:
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        userProcessContainer.add("viewInventory", new ViewInventoryJpanel(userProcessContainer, enterprise.getInventory()));
        layout.next(userProcessContainer);
    }//GEN-LAST:event_jButtonCheckInventoryActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addRow;
    private javax.swing.JButton back;
    private javax.swing.JTable drugquantity;
    private javax.swing.JButton jButtonCheckInventory;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private keeptoo.KGradientPanel kGradientPanel1;
    private javax.swing.JButton submit;
    // End of variables declaration//GEN-END:variables
}
