/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.organization.chemist;

import business.organization.Organization;
import business.role.Role;
import business.role.Role.RoleType;
import business.role.chemist.WorkerRole;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author vivekdalal
 */
public class WorkerOrganization extends Organization {

    public WorkerOrganization(String name, OrganizationType type) {
        super(name);
    }

    @Override
    public List<Role> getSupportedRole() {
        List<Role> roles = new ArrayList();
        roles.add(new WorkerRole(RoleType.Worker));
        return roles;
    }

}
