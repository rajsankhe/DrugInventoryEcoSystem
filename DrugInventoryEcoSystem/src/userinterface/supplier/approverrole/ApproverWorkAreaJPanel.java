/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.supplier.approverrole;

import business.EcoSystem;
import business.drug.Drug;
import business.enterprise.Enterprise;
import business.enterprise.SupplierEnterprise;
import business.inventory.Inventory;
import business.network.Network;
import business.organization.Organization;
import business.organization.legal.ValidatorOrganization;
import business.organization.supplier.ApproverOrganization;
import business.useraccount.UserAccount;
import business.workqueue.WorkRequest;
import business.workqueue.WorkRequestDrugs;
import commonutils.Constants;
import java.awt.CardLayout;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author vivekdalal
 */
public class ApproverWorkAreaJPanel extends javax.swing.JPanel {

    /**
     * Creates new form ApproverWorkAreaJPanel
     */
    private JPanel userProcessContainer;
    private ApproverOrganization organization;
    private SupplierEnterprise enterprise;
    private UserAccount userAccount;
    private Network network;
    private EcoSystem ecosystem;

    public ApproverWorkAreaJPanel(JPanel userProcessContainer, UserAccount account, ApproverOrganization organization, Enterprise enterprise, EcoSystem ecosystem, Network network) {
        initComponents();
        this.setSize(1680, 1050);
        ((DefaultTableCellRenderer) workRequestJTable.getDefaultRenderer(Object.class)).setOpaque(false);
        jScrollPane1.setOpaque(false);
        jScrollPane1.getViewport().setOpaque(false);
        this.userProcessContainer = userProcessContainer;
        this.organization = organization;
        this.enterprise = (SupplierEnterprise) enterprise;
        this.userAccount = account;
        this.ecosystem = ecosystem;
        this.network = network;
        title.setText("Supplier Approver: " + userAccount.getUsername());
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

        jPanel1 = new javax.swing.JPanel();
        kGradientPanel1 = new keeptoo.KGradientPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        workRequestJTable = new javax.swing.JTable();
        assignToMe = new javax.swing.JButton();
        viewRequest = new javax.swing.JButton();
        title = new javax.swing.JLabel();
        sendToLegal = new javax.swing.JButton();
        requestOrSend = new javax.swing.JButton();
        checkInventory = new javax.swing.JButton();

        jPanel1.setPreferredSize(new java.awt.Dimension(1200, 750));

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

        title.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        title.setText("Approver Workarea");
        title.setAlignmentX(740.0F);
        title.setAlignmentY(245.0F);

        sendToLegal.setText("Send For Legal Check");
        sendToLegal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sendToLegalActionPerformed(evt);
            }
        });

        requestOrSend.setText("Request Bid OR Send To Chemist");
        requestOrSend.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                requestOrSendActionPerformed(evt);
            }
        });

        checkInventory.setText("Check Inventory");
        checkInventory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkInventoryActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout kGradientPanel1Layout = new javax.swing.GroupLayout(kGradientPanel1);
        kGradientPanel1.setLayout(kGradientPanel1Layout);
        kGradientPanel1Layout.setHorizontalGroup(
            kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(kGradientPanel1Layout.createSequentialGroup()
                        .addGap(89, 89, 89)
                        .addComponent(title, javax.swing.GroupLayout.PREFERRED_SIZE, 553, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(kGradientPanel1Layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 669, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, kGradientPanel1Layout.createSequentialGroup()
                                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(kGradientPanel1Layout.createSequentialGroup()
                                        .addComponent(assignToMe)
                                        .addGap(152, 152, 152)
                                        .addComponent(viewRequest))
                                    .addComponent(requestOrSend))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 136, Short.MAX_VALUE)
                                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(sendToLegal, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(checkInventory, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(498, Short.MAX_VALUE))
        );
        kGradientPanel1Layout.setVerticalGroup(
            kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(title)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(assignToMe)
                    .addComponent(viewRequest)
                    .addComponent(sendToLegal))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(requestOrSend)
                    .addComponent(checkInventory))
                .addContainerGap(342, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1200, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(kGradientPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 750, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(kGradientPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
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
        userProcessContainer.add("viewEditDrug", new ViewApproverOrderjpanel(userProcessContainer, request));
        layout.next(userProcessContainer);
    }//GEN-LAST:event_viewRequestActionPerformed

    private void sendToLegalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sendToLegalActionPerformed
        // TODO add your handling code here:
        int selectedRow = workRequestJTable.getSelectedRow();

        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(null, "Please select row");
            return;
        }
        WorkRequestDrugs request = (WorkRequestDrugs) workRequestJTable.getValueAt(selectedRow, 0);
        Organization org = null;
        //request.getEnterpriseStack().add(this.enterprise);
        if (!(request.getStatus().equals(Constants.sentToLegal) || request.getStatus().equals(Constants.rejectedByLegal) || request.getStatus().equals(Constants.acceptedByLegal))) {
            if (request.getReceiver() == userAccount) {
                for (Enterprise e : network.getEnterpriseDirectory().getEnterpriseList()) {
                    if (e.getEnterpriseType().equals(Enterprise.EnterpriseType.Legal)) {
                        for (Organization organization : e.getOrganizationDirectory().getOrganizationList()) {
                            if (organization instanceof ValidatorOrganization) {
                                org = organization;
                                org.getWorkQueue().getWorkRequestList().add(request);
                            }
                        }
                    }
                }

                request.setStatus(Constants.sentToLegal);
                JOptionPane.showMessageDialog(null, "Request send to Legal");
                populateRequestTable();
                /* CardLayout layout = (CardLayout) userProcessContainer.getLayout();
                 userProcessContainer.add("ChooseSupplier", new AssignToSupplier(userProcessContainer,ecosystem, request ));
                 layout.next(userProcessContainer);*/
            } else {
                JOptionPane.showMessageDialog(null, "Assign request to you.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Request already send to legal.");
        }
    }//GEN-LAST:event_sendToLegalActionPerformed

    private void requestOrSendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_requestOrSendActionPerformed
        // TODO add your handling code here:
        int selectedRow = workRequestJTable.getSelectedRow();
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(null, "Please select row");
            return;
        }
        WorkRequestDrugs request = (WorkRequestDrugs) workRequestJTable.getValueAt(selectedRow, 0);
        if (request.getReceiver() == userAccount) {

            if (!Constants.resentToChemist.equals(request.getStatus())) {
                if (Constants.acceptedByLegal.equals(request.getStatus())) {
                    SupplierEnterprise supplierEnterprise = (SupplierEnterprise) enterprise;
                    Inventory inventorySupp = supplierEnterprise.getInventory();
                    List<Drug> inventory = inventorySupp.getDrugStock();
                    List<Drug> drugsOrderList = request.getDrugsOrderList();
                    Map<String, int[]> requestOrSend = new HashMap<>();
                    Boolean bidFlag = false;
                    drugsOrderList.stream().forEach(drug -> requestOrSend.put(drug.getName(), new int[]{0, drug.getQuantity(), 0}));
                    for (Map.Entry<String, int[]> entry : requestOrSend.entrySet()) {
                        int[] countArray = entry.getValue();
                        Drug drug = inventory.stream()
                                .filter(drugIn -> entry.getKey().equals(drugIn.getName()))
                                .findAny()
                                .orElse(null);
                        if (drug != null) {
                            countArray[0] = drug.getQuantity();
                        }
                        countArray[2] = countArray[1] - countArray[0];
                        if (countArray[2] < 0) {
                            countArray[2] = 0;
                        } else if (countArray[2] > 0) {
                            bidFlag = true;
                        }

                    }

                    CardLayout layout = (CardLayout) userProcessContainer.getLayout();
                    userProcessContainer.add("RequestBid", new RequestBidOrSendSupplier(userProcessContainer, request, requestOrSend, bidFlag,
                            ecosystem, network,enterprise));
                    layout.next(userProcessContainer);
                } else {
                    JOptionPane.showMessageDialog(null, "Request Not authorized by legal");
                    return;
                }
            } else {
                JOptionPane.showMessageDialog(null, "Order Completed");
                return;
            }
        } else {
            JOptionPane.showMessageDialog(null, "Assign request to you.");
            return;
        }

    }//GEN-LAST:event_requestOrSendActionPerformed

    private void checkInventoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkInventoryActionPerformed
        // TODO add your handling code here:
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        userProcessContainer.add("viewInventory", new ViewInventoryJpanel(userProcessContainer, enterprise.getInventory()));
        layout.next(userProcessContainer);
    }//GEN-LAST:event_checkInventoryActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton assignToMe;
    private javax.swing.JButton checkInventory;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private keeptoo.KGradientPanel kGradientPanel1;
    private javax.swing.JButton requestOrSend;
    private javax.swing.JButton sendToLegal;
    private javax.swing.JLabel title;
    private javax.swing.JButton viewRequest;
    private javax.swing.JTable workRequestJTable;
    // End of variables declaration//GEN-END:variables
}
