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
        if (type.getValue().equals(OrganizationType.Admin.getValue())) {
            organization = new AdminOrganization(name, type);
        } else if (type.getValue().equals(OrganizationType.Worker.getValue())) {
            organization = new WorkerOrganization(name, type);
        } else if (type.getValue().equals(OrganizationType.Manager.getValue())) {
            organization = new ManagerOrganization(name, type);
        } else if (type.getValue().equals(OrganizationType.Coordinator.getValue())) {
            organization = new CoordinatorOrganization(name, type);
        } else if (type.getValue().equals(OrganizationType.Approver.getValue())) {
            organization = new ApproverOrganization(name, type);
        } else if (type.getValue().equals(OrganizationType.Validator.getValue())) {
            organization = new ValidatorOrganization(name, type);
        } else if (type.getValue().equals(OrganizationType.Transporter.getValue())) {
            organization = new TransporterOrganization(name, type);
        } else if (type.getValue().equals(OrganizationType.Producer.getValue())) {
            organization = new ProducerOrganization(name, type);
        }
        organizationList.add(organization);
        return organization;
    }
}
