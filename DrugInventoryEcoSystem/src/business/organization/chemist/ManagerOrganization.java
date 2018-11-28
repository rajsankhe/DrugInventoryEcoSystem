/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.organization.chemist;

import business.organization.Organization;
import business.role.Role;
import business.role.Role.RoleType;
import business.role.chemist.ManagerRole;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author vivekdalal
 */
public class ManagerOrganization extends Organization {

    public ManagerOrganization(String name, OrganizationType type) {
        super(name);
    }

    @Override
    public List<Role> getSupportedRole() {
        List<Role> roles = new ArrayList();
        roles.add(new ManagerRole(RoleType.Manager));
        return roles;
    }
}
