/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.manufacturer.producerrole;

import business.EcoSystem;
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

/**
 *
 * @author Tej Sankhe
 */
public class ViewAndUpdateBidProducerjpanel extends javax.swing.JPanel {

    /**
     * Creates new form ViewOrderjpanel
     */
    private JPanel userProcessContainer;
    private WorkRequestDrugs workRequestDrugs;
    private EcoSystem ecoSystem;

    public ViewAndUpdateBidProducerjpanel(JPanel userProcessContainer, WorkRequestDrugs request, EcoSystem system) {
        initComponents();
        this.setSize(1200, 750);
        ((DefaultTableCellRenderer) drugquantity.getDefaultRenderer(Object.class)).setOpaque(false);
        jScrollPane1.setOpaque(false);
        jScrollPane1.getViewport().setOpaque(false);
        this.userProcessContainer = userProcessContainer;
        this.workRequestDrugs = request;
        this.ecoSystem = system;
        populateRequestTable();
    }

    public void populateRequestTable() {
        DefaultTableModel model = (DefaultTableModel) drugquantity.getModel();

        model.setRowCount(0);
        for (Drug drug : workRequestDrugs.getDrugsOrderList()) {
            Object[] row = new Object[3];
            row[0] = drug;
            row[1] = drug.getRequestCountFromMan();
            //row[2] = drug.getManufacturerPrice();
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
        drugquantity = new javax.swing.JTable();
        back = new javax.swing.JButton();
        title = new javax.swing.JLabel();
        jButtonCheckInventory = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(1200, 750));

        kGradientPanel1.setkEndColor(new java.awt.Color(102, 204, 255));
        kGradientPanel1.setkStartColor(new java.awt.Color(183, 248, 230));
        kGradientPanel1.setPreferredSize(new java.awt.Dimension(1200, 750));

        drugquantity.setBackground(new java.awt.Color(153, 255, 255));
        drugquantity.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        drugquantity.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Drug", "Quantity", "Price"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class, java.lang.Double.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        drugquantity.setGridColor(new java.awt.Color(0, 0, 0));
        drugquantity.setSelectionBackground(new java.awt.Color(153, 255, 255));
        drugquantity.setSelectionForeground(new java.awt.Color(0, 0, 0));
        jScrollPane1.setViewportView(drugquantity);

        back.setText("<< Back");
        back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backActionPerformed(evt);
            }
        });

        title.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        title.setText("Order Drugs");
        title.setAlignmentX(740.0F);
        title.setAlignmentY(245.0F);

        jButtonCheckInventory.setText("Submit");
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
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(kGradientPanel1Layout.createSequentialGroup()
                        .addComponent(back)
                        .addGap(294, 294, 294)
                        .addComponent(title, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(kGradientPanel1Layout.createSequentialGroup()
                        .addGap(144, 144, 144)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 612, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(kGradientPanel1Layout.createSequentialGroup()
                        .addGap(413, 413, 413)
                        .addComponent(jButtonCheckInventory)))
                .addContainerGap(444, Short.MAX_VALUE))
        );
        kGradientPanel1Layout.setVerticalGroup(
            kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(back)
                    .addComponent(title))
                .addGap(41, 41, 41)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButtonCheckInventory)
                .addContainerGap(383, Short.MAX_VALUE))
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
        userProcessContainer.remove(this);
        Component[] componentArray = userProcessContainer.getComponents();
        Component component = componentArray[componentArray.length - 1];
        ProducerWorkAreaJPanel producerWorkAreaJPanel = (ProducerWorkAreaJPanel) component;
        producerWorkAreaJPanel.populateRequestTable();

        // Taking the user back to the previous screen
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);

    }//GEN-LAST:event_backActionPerformed

    private void jButtonCheckInventoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCheckInventoryActionPerformed

        List<Drug> orderList = new ArrayList<>();
        try {
            DefaultTableModel model = (DefaultTableModel) drugquantity.getModel();
            int nRow = model.getRowCount();
            for (int i = 0; i < nRow; i++) {
                if (model.getValueAt(i, 0) != null && model.getValueAt(i, 1) != null) {
                    String drugName = String.valueOf(model.getValueAt(i, 0));
                    //int drugRequested = (Integer) model.getValueAt(i, 1);
                    double manufacturerPrice = (Double) model.getValueAt(i, 2);

                    for (Drug drug : workRequestDrugs.getDrugsOrderList()) {
                        if (drug.getName().equalsIgnoreCase(drugName)) {
                            drug.setManufacturerPrice(manufacturerPrice);
                            break;
                        }
                    }

                }

            }
            workRequestDrugs.setStatus(Constants.priceUpdatedByManufacturer);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Please enter decimal value in price field.");
            e.printStackTrace();
            return;
        }

        workRequestDrugs.setDrugsOrderList(orderList);

        JOptionPane.showMessageDialog(null, "Price updated successfully");
        userProcessContainer.remove(this);
        Component[] componentArray = userProcessContainer.getComponents();
        Component component = componentArray[componentArray.length - 1];
        ProducerWorkAreaJPanel producerWorkAreaJPanel = (ProducerWorkAreaJPanel) component;
        producerWorkAreaJPanel.populateRequestTable();

        // Taking the user back to the previous screen
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);

    }//GEN-LAST:event_jButtonCheckInventoryActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton back;
    private javax.swing.JTable drugquantity;
    private javax.swing.JButton jButtonCheckInventory;
    private javax.swing.JScrollPane jScrollPane1;
    private keeptoo.KGradientPanel kGradientPanel1;
    private javax.swing.JLabel title;
    // End of variables declaration//GEN-END:variables
}
