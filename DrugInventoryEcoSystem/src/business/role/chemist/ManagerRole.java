/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.role.chemist;

import business.EcoSystem;
import business.enterprise.Enterprise;
import business.organization.Organization;
import business.organization.chemist.ManagerOrganization;
import business.role.Role;
import business.useraccount.UserAccount;
import javax.swing.JPanel;
import userinterface.chemist.managerrole.ManagerWorkAreaJPanel;
import userinterface.chemist.workerrole.WorkerWorkAreaJPanel;

/**
 *
 * @author vivekdalal
 */
public class ManagerRole extends Role {

    public ManagerRole(RoleType type) {
        super(type);
    }

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, EcoSystem business) {
        return new ManagerWorkAreaJPanel(userProcessContainer,account,(ManagerOrganization)organization,enterprise);
    }

}
