/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.supplier.approverrole;

import business.EcoSystem;
import business.drug.Drug;
import business.enterprise.ChemistEnterprise;
import business.enterprise.Enterprise;
import business.enterprise.SupplierEnterprise;
import business.network.Network;
import business.organization.Organization;
import business.organization.supplier.ApproverOrganization;
import business.useraccount.UserAccount;
import business.workqueue.WorkRequestDrugs;
import commonutils.Constants;
import commonutils.email.SendEmail;
import java.awt.CardLayout;
import java.awt.Component;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
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
    private SupplierEnterprise enterprise;
    private UserAccount userAccount;
    private EcoSystem ecosystem;
    private WorkRequestDrugs request;
    private Network network;
    private Map<String, int[]> requestOrSend;

    public RequestBidOrSendSupplier(JPanel userProcessContainer, WorkRequestDrugs request, Map<String, int[]> requestOrSend, Boolean bidFlag,
            EcoSystem system, Network network, SupplierEnterprise enterprise) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.request = request;
        this.ecosystem = system;
        this.network = network;
        this.enterprise = enterprise;
        if (bidFlag == Boolean.TRUE) {
            messageLabel.setText("Inventory is low, please request bid");
            requestBid.setEnabled(true);
            sendToChemist.setEnabled(false);
        } else {
            messageLabel.setText("Request can be full filled");
            requestBid.setEnabled(false);
            sendToChemist.setEnabled(true);
        }
        this.requestOrSend = requestOrSend;
        populateRequestTable(this.requestOrSend);
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
        sendToChemist = new javax.swing.JButton();
        messageLabel = new javax.swing.JLabel();
        back = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

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

        sendToChemist.setText("Send To Chemist");
        sendToChemist.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sendToChemistActionPerformed(evt);
            }
        });

        messageLabel.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        messageLabel.setForeground(new java.awt.Color(51, 51, 255));

        back.setText("<< Back");
        back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backActionPerformed(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/icons/supplier.png"))); // NOI18N

        javax.swing.GroupLayout kGradientPanel1Layout = new javax.swing.GroupLayout(kGradientPanel1);
        kGradientPanel1.setLayout(kGradientPanel1Layout);
        kGradientPanel1Layout.setHorizontalGroup(
            kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(kGradientPanel1Layout.createSequentialGroup()
                        .addGap(144, 144, 144)
                        .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(title, javax.swing.GroupLayout.PREFERRED_SIZE, 553, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(messageLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 415, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 669, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                                .addComponent(requestBid)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(sendToChemist)
                                .addGap(14, 14, 14))))
                    .addGroup(kGradientPanel1Layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1)
                            .addComponent(back))))
                .addContainerGap(171, Short.MAX_VALUE))
        );
        kGradientPanel1Layout.setVerticalGroup(
            kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(back)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(title)
                .addGap(10, 10, 10)
                .addComponent(messageLabel)
                .addGap(35, 35, 35)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sendToChemist)
                    .addComponent(requestBid))
                .addContainerGap(311, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 984, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(kGradientPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 984, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 807, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(kGradientPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 807, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void requestBidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_requestBidActionPerformed
        // Send bid request to Manufacturer
        request.getEnterpriseStack().add(this.enterprise);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        userProcessContainer.add("ChooseManufacturer", new AssignToManufacturer(userProcessContainer, ecosystem, request, enterprise, requestOrSend));
        layout.next(userProcessContainer);

    }//GEN-LAST:event_requestBidActionPerformed

    private void sendToChemistActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sendToChemistActionPerformed
        //Update inventory of chemist
        ChemistEnterprise chemistEnterprise = null;
        SupplierEnterprise supplierEnterprise = enterprise;
        for (Enterprise enterprise : request.getEnterpriseStack()) {
            if (enterprise instanceof ChemistEnterprise) {
                chemistEnterprise = (ChemistEnterprise) enterprise;
            }
        }
        if (chemistEnterprise != null) {
            List<Drug> drugInventoryStock = chemistEnterprise.getInventory().getDrugStock();
            List<Drug> drugInventoryStockSupplier = supplierEnterprise.getInventory().getDrugStock();
            List<Drug> drugOrder = request.getDrugsOrderList();
            for (Drug drug : drugOrder) {
                Drug drugInv = drugInventoryStock.stream().filter(drugIn -> (drug.getName()).equals(drugIn.getName()))
                        .findAny()
                        .orElse(null);

                Drug drugInvSupp = drugInventoryStockSupplier.stream().filter(drugInsup -> (drug.getName()).equals(drugInsup.getName()))
                        .findAny()
                        .orElse(null);
                if (drugInv != null) {
                    drugInv.setQuantity(drugInv.getQuantity() + drug.getQuantity());
                } else {
                    drugInventoryStock.add(drug);
                }
                if (drugInvSupp != null) {
                    drugInvSupp.setQuantity(drugInvSupp.getQuantity() - drug.getQuantity());
                }
            }
            //Delete this order from all queues.
            for (Organization organization : enterprise.getOrganizationDirectory().getOrganizationList()) {
                if (organization instanceof ApproverOrganization) {
                    //Remove the workrequest from this queue
                    organization.getWorkQueue().deleteWorkRequest(request);
                }
            }
            request.setStatus(Constants.resentToChemist);
            JOptionPane.showMessageDialog(null, "Order is completed");
            userProcessContainer.remove(this);
            Component[] componentArray = userProcessContainer.getComponents();
            Component component = componentArray[componentArray.length - 1];
            ApproverWorkAreaJPanel approverworkAreaJPanel = (ApproverWorkAreaJPanel) component;
            approverworkAreaJPanel.populateRequestTable();
            CardLayout layout = (CardLayout) userProcessContainer.getLayout();
            layout.previous(userProcessContainer);

            List<String> emailIDList = new ArrayList<>();
            for (Organization organization : chemistEnterprise.getOrganizationDirectory().getOrganizationList()) {
                for (UserAccount userAccount : organization.getUserAccountDirectory().getUserAccountListValues()) {
                    emailIDList.add(userAccount.getEmailID());
                }
            }

            //Send email to user with password.
            ExecutorService executor = Executors.newSingleThreadExecutor();

            Runnable runnableTask = () -> {
                try {
                    System.out.println("Executor task started");
                    SendEmail sendEmail = new SendEmail();
                    sendEmail.sendMailMulti(request, emailIDList);

                } catch (Exception exception) {
                    //JOptionPane.showMessageDialog(null, "We were unable to send mail to the desired recepient! Please contact system administrator");
                    exception.printStackTrace();
                }
            };

            executor.execute(runnableTask);

            executor.shutdown();

        } else {
            request.setStatus(Constants.orderCannotBeFullfilled);
            JOptionPane.showMessageDialog(null, "Order Cannot be fulfilled");
            userProcessContainer.remove(this);
            Component[] componentArray = userProcessContainer.getComponents();
            Component component = componentArray[componentArray.length - 1];
            ApproverWorkAreaJPanel approverworkAreaJPanel = (ApproverWorkAreaJPanel) component;
            approverworkAreaJPanel.populateRequestTable();
            CardLayout layout = (CardLayout) userProcessContainer.getLayout();
            layout.previous(userProcessContainer);
        }

    }//GEN-LAST:event_sendToChemistActionPerformed

    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed
        // TODO add your handling code here:
        userProcessContainer.remove(this);
        Component[] componentArray = userProcessContainer.getComponents();
        Component component = componentArray[componentArray.length - 1];
        ApproverWorkAreaJPanel approverworkAreaJPanel = (ApproverWorkAreaJPanel) component;
        approverworkAreaJPanel.populateRequestTable();
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_backActionPerformed

    public void disableButton() {
        requestBid.setEnabled(false);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton back;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private keeptoo.KGradientPanel kGradientPanel1;
    private javax.swing.JLabel messageLabel;
    private javax.swing.JButton requestBid;
    private javax.swing.JButton sendToChemist;
    private javax.swing.JLabel title;
    private javax.swing.JTable workRequestJTable;
    // End of variables declaration//GEN-END:variables

    private void populateRequestTable(Map<String, int[]> requestOrSend) {
        DefaultTableModel model = (DefaultTableModel) workRequestJTable.getModel();
        model.setRowCount(0);
        for (Map.Entry<String, int[]> entry : requestOrSend.entrySet()) {
            Object[] row = new Object[4];
            row[0] = entry.getKey();
            int[] countArray = entry.getValue();
            row[1] = countArray[0];
            row[2] = countArray[1];
            row[3] = countArray[2];
            model.addRow(row);
        }
    }
}
