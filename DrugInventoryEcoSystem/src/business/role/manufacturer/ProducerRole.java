/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.role.manufacturer;

import business.EcoSystem;
import business.enterprise.Enterprise;
import business.organization.Organization;
import business.organization.manufacturer.ProducerOrganization;
import business.role.Role;
import business.useraccount.UserAccount;
import javax.swing.JPanel;
import userinterface.manufacturer.producerrole.ProducerWorkAreaJPanel;

/**
 *
 * @author vivekdalal
 */
public class ProducerRole extends Role {

    public ProducerRole(RoleType type) {
        super(type);
    }

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, EcoSystem business) {
        return new ProducerWorkAreaJPanel(userProcessContainer, account, (ProducerOrganization) organization, enterprise, business);
    }

}
