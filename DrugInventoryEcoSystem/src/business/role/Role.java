/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.role;

import business.EcoSystem;
import business.enterprise.Enterprise;
import business.organization.Organization;
import business.useraccount.UserAccount;
import javax.swing.JPanel;

/**
 *
 * @author vivekdalal
 */
public abstract class Role {

    private RoleType roleType;

    public Role(RoleType type) {
        this.roleType = type;
    }

    public enum RoleType {
        Admin("Admin"),
        Worker("Worker"),
        Manager("Manager"),
        Coordinator("Coordinator"),
        Approver("Approver"),
        Validator("Validator"),
        Transporter("Transporter"),
        Producer("Prod");

        private String value;

        private RoleType(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return value;
        }
    }

    public abstract JPanel createWorkArea(JPanel userProcessContainer,
            UserAccount account,
            Organization organization,
            Enterprise enterprise,
            EcoSystem business);

    @Override
    public String toString() {
        return this.getClass().getName();
    }
}
