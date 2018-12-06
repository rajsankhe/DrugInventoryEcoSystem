/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.organization;

import business.organization.Organization.OrganizationType;
import business.organization.chemist.ManagerOrganization;
import business.organization.chemist.WorkerOrganization;
import business.organization.legal.ValidatorOrganization;
import business.organization.manufacturer.ProducerOrganization;
import business.organization.supplier.ApproverOrganization;
import business.organization.supplier.CoordinatorOrganization;
import business.organization.transport.TransporterOrganization;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 *
 * @author vivekdalal
 */
public class OrganizationDirectory {

    private List<Organization> organizationList;

    public OrganizationDirectory() {
        organizationList = new ArrayList();
    }

    public List<Organization> getOrganizationList() {
        return organizationList;
    }

    public Organization createOrganization(String name, OrganizationType type) {
        Organization organization = null;
        UUID uuid = UUID.randomUUID();
        if (type.getValue().equals(OrganizationType.Admin.getValue())) {
            organization = new AdminOrganization(name, type, uuid.toString());
        } else if (type.getValue().equals(OrganizationType.Worker.getValue())) {
            organization = new WorkerOrganization(name, type, uuid.toString());
        } else if (type.getValue().equals(OrganizationType.Manager.getValue())) {
            organization = new ManagerOrganization(name, type, uuid.toString());
        } else if (type.getValue().equals(OrganizationType.Coordinator.getValue())) {
            organization = new CoordinatorOrganization(name, type, uuid.toString());
        } else if (type.getValue().equals(OrganizationType.Approver.getValue())) {
            organization = new ApproverOrganization(name, type, uuid.toString());
        } else if (type.getValue().equals(OrganizationType.Validator.getValue())) {
            organization = new ValidatorOrganization(name, type, uuid.toString());
        } else if (type.getValue().equals(OrganizationType.Transporter.getValue())) {
            organization = new TransporterOrganization(name, type, uuid.toString());
        } else if (type.getValue().equals(OrganizationType.Producer.getValue())) {
            organization = new ProducerOrganization(name, type, uuid.toString());
        }
        organizationList.add(organization);
        return organization;
    }

    public void removeOrganization(Organization organization) {
        organizationList.remove(organization);
    }
}
