/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.supplier.approverrole;

import business.EcoSystem;
import business.enterprise.Enterprise;
import business.enterprise.ManufacturerEnterprise;
import business.network.Network;
import business.organization.Organization;
import business.organization.manufacturer.ProducerOrganization;
import business.workqueue.WorkRequestDrugs;
import commonutils.Constants;
import java.awt.CardLayout;
import java.awt.Component;
import java.util.List;
import java.util.stream.Collectors;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Raj Sankhe
 */
public class AssignToManufacturer extends javax.swing.JPanel {

    /**
     * Creates new form AssignToManufacturer
     */
    private JPanel userProcessContainer;
    private EcoSystem ecosystem;
    private WorkRequestDrugs request;

    public AssignToManufacturer(JPanel userProcessContainer, EcoSystem ecosystem, WorkRequestDrugs request) {
        initComponents();
        networkDropdown.removeAllItems();
        enterpriseDropdown.removeAllItems();
        this.userProcessContainer = userProcessContainer;
        this.ecosystem = ecosystem;
        this.request = request;
        List<Network> networkList = ecosystem.getNetworkDirectory().getNetworkList();
        networkList.stream().forEach(network -> networkDropdown.addItem(network.getName()));
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
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        networkDropdown = new javax.swing.JComboBox<>();
        enterpriseDropdown = new javax.swing.JComboBox<>();
        back = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        workRequestJTable = new javax.swing.JTable();

        setPreferredSize(new java.awt.Dimension(1200, 750));

        kGradientPanel1.setkEndColor(new java.awt.Color(102, 204, 255));
        kGradientPanel1.setkStartColor(new java.awt.Color(183, 248, 230));
        kGradientPanel1.setPreferredSize(new java.awt.Dimension(1200, 750));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("     Choose Manufacturer");
        jLabel1.setAlignmentX(740.0F);
        jLabel1.setAlignmentY(245.0F);

        jLabel2.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel2.setText("Enterprise:");
        jLabel2.setAlignmentX(740.0F);
        jLabel2.setAlignmentY(245.0F);

        jLabel3.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel3.setText("Network:");
        jLabel3.setAlignmentX(740.0F);
        jLabel3.setAlignmentY(245.0F);

        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton1.setText("Submit");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        networkDropdown.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        networkDropdown.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                networkDropdownItemStateChanged(evt);
            }
        });
        networkDropdown.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                networkDropdownActionPerformed(evt);
            }
        });

        enterpriseDropdown.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        enterpriseDropdown.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                enterpriseDropdownItemStateChanged(evt);
            }
        });
        enterpriseDropdown.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                enterpriseDropdownActionPerformed(evt);
            }
        });

        back.setText("<< Back");
        back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backActionPerformed(evt);
            }
        });

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
                false, false, false, true
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

        javax.swing.GroupLayout kGradientPanel1Layout = new javax.swing.GroupLayout(kGradientPanel1);
        kGradientPanel1.setLayout(kGradientPanel1Layout);
        kGradientPanel1Layout.setHorizontalGroup(
            kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(kGradientPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(back)
                        .addGap(108, 108, 108)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 322, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(kGradientPanel1Layout.createSequentialGroup()
                        .addGap(157, 157, 157)
                        .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(networkDropdown, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(enterpriseDropdown, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                                .addGap(112, 112, 112)
                                .addComponent(jButton1))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 669, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(374, Short.MAX_VALUE))
        );
        kGradientPanel1Layout.setVerticalGroup(
            kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(back))
                .addGap(54, 54, 54)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47)
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(networkDropdown, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(enterpriseDropdown, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addContainerGap(198, Short.MAX_VALUE))
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
        // Removing the current screen from the stack
        userProcessContainer.remove(this);
        // Removing the RequestBidOrSendSupplier screen from the stack
        Component[] componentArray = userProcessContainer.getComponents();
        Component component = componentArray[componentArray.length - 2]; //Taking two as we will skip a screen in between
        ApproverWorkAreaJPanel approverWorkAreaJPanel = (ApproverWorkAreaJPanel) component;
        approverWorkAreaJPanel.populateRequestTable();
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_backActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        List<Network> networkList = ecosystem.getNetworkDirectory().getNetworkList();
        String networkName = networkDropdown.getSelectedItem().toString();
        Network networkSelected = networkList.stream()
                .filter(network -> networkName.equals(network.getName()))
                .findAny()
                .orElse(null);
        if (networkDropdown.getSelectedItem() != null && enterpriseDropdown.getSelectedItem() != null) {
            String enterpriseName = enterpriseDropdown.getSelectedItem().toString();
            List<Enterprise> enterpriseList = networkSelected.getEnterpriseDirectory().getEnterpriseList().stream().
                    filter(enterprise -> enterprise instanceof ManufacturerEnterprise).collect(Collectors.toList());
            Enterprise enterpriseSelected = enterpriseList.stream()
                    .filter(enterprise -> enterpriseName.equals(enterprise.getName()))
                    .findAny()
                    .orElse(null);
            Organization org = null;
            for (Organization organization : enterpriseSelected.getOrganizationDirectory().getOrganizationList()) {
                if (organization instanceof ProducerOrganization) {
                    org = organization;
                    org.getWorkQueue().getWorkRequestList().add(request);
                }
            }
            request.setStatus(Constants.sentToManufacturer);
            request.setSender(request.getReceiver());
            request.setReceiver(null);
            JOptionPane.showMessageDialog(null, "Request send to manufacturer");
        } else {
            JOptionPane.showMessageDialog(null, "Request cannot be fulfilled");
        }

        // Removing the current screen from the stack
        userProcessContainer.remove(this);
        // Removing the RequestBidOrSendSupplier screen from the stack
        Component[] componentArray = userProcessContainer.getComponents();
        Component component = componentArray[componentArray.length - 2]; //Taking two as we will skip a screen in between
        ApproverWorkAreaJPanel approverWorkAreaJPanel = (ApproverWorkAreaJPanel) component;
        approverWorkAreaJPanel.populateRequestTable();
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void networkDropdownItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_networkDropdownItemStateChanged
        // TODO add your handling code here:
        Network networkSelected = null;
        enterpriseDropdown.removeAllItems();
        if (ecosystem != null) {
            List<Network> networkList = ecosystem.getNetworkDirectory().getNetworkList();
            String networkName = networkDropdown.getSelectedItem().toString();
            networkSelected = networkList.stream()
                    .filter(network -> networkName.equals(network.getName()))
                    .findAny()
                    .orElse(null);
        }
        List<Enterprise> enterpriseList = null;
        if (networkSelected != null) {
            enterpriseList = networkSelected.getEnterpriseDirectory().getEnterpriseList().stream().
                    filter(enterprise -> enterprise instanceof ManufacturerEnterprise).collect(Collectors.toList());
        }
        if (enterpriseList != null) {
            enterpriseList.stream().forEach(enterprise -> enterpriseDropdown.addItem(enterprise.getName()));
        }
    }//GEN-LAST:event_networkDropdownItemStateChanged

    private void networkDropdownActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_networkDropdownActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_networkDropdownActionPerformed

    private void enterpriseDropdownActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_enterpriseDropdownActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_enterpriseDropdownActionPerformed

    private void enterpriseDropdownItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_enterpriseDropdownItemStateChanged

    }//GEN-LAST:event_enterpriseDropdownItemStateChanged

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton back;
    private javax.swing.JComboBox<String> enterpriseDropdown;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private keeptoo.KGradientPanel kGradientPanel1;
    private javax.swing.JComboBox<String> networkDropdown;
    private javax.swing.JTable workRequestJTable;
    // End of variables declaration//GEN-END:variables

}
