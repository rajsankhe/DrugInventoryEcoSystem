/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.organization.transport;

import business.organization.Organization;
import business.role.Role;
import business.role.Role.RoleType;
import business.role.transport.TransporterRole;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author vivekdalal
 */
public class TransporterOrganization extends Organization {

    public TransporterOrganization(String name, OrganizationType type) {
        super(name);
    }

    @Override
    public List<Role> getSupportedRole() {
        List<Role> roles = new ArrayList();
        roles.add(new TransporterRole(RoleType.Transporter));
        return roles;
    }

}
