/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import business.employee.Employee;
import business.enterprise.ChemistEnterprise;
import business.enterprise.Enterprise;
import business.enterprise.EnterpriseDirectory;
import business.enterprise.LegalEnterprise;
import business.enterprise.ManufacturerEnterprise;
import business.enterprise.SupplierEnterprise;
import business.enterprise.TransportationEnterprise;
import business.network.Network;
import business.network.NetworkDirectory;
import business.organization.Organization;
import business.organization.OrganizationDirectory;
import business.role.AdminRole;
import business.role.Role;
import business.role.SystemAdminRole;
import business.role.chemist.WorkerRole;
import business.useraccount.UserAccount;
import commonutils.PasswordUtility;

/**
 *
 * @author vivekdalal
 */
public class ConfigureASystem {

    public static EcoSystem configure() {

        EcoSystem system = EcoSystem.getInstance();

        //Create a network
        NetworkDirectory networkDirectory = new NetworkDirectory();
        networkDirectory.createAndAddNetwork("Boston");
        networkDirectory.createAndAddNetwork("NewYorkCity");

        for (Network network : networkDirectory.getNetworkList()) {

            EnterpriseDirectory enterpriseDirectory = new EnterpriseDirectory();
            for (int entepriseCounter = 0; entepriseCounter < 2; entepriseCounter++) {
                addEnterpriseToDirectory(network, enterpriseDirectory, entepriseCounter + 1);
            }
            network.setEnterpriseDirectory(enterpriseDirectory);

            //Add organizations and
        }

        system.networkDirectory = networkDirectory;

        //create an enterprise
        //initialize some organizations
        //have some employees
        //create user account
        Employee employee = system.getEmployeeDirectory().createEmployee("BROCODERS");

        UserAccount ua = system.getUserAccountDirectory().createUserAccount("admin", "admin", "admin@brocoders.com", employee, new SystemAdminRole(Role.RoleType.Admin));

        return system;
    }

    public static void addEnterpriseToDirectory(Network network, EnterpriseDirectory enterpriseDirectory, int i) {
        //Add enterprisedirectory and create enterprises

        Enterprise chemistEnterprise = enterpriseDirectory.createAndAddEnterprise(network.getName().substring(0, i) + "Chemist" + i, Enterprise.EnterpriseType.Chemist);
        Employee chemistAdminEmployee = chemistEnterprise.getEmployeeDirectory().createEmployee("chemadminemp" + i);
        chemistEnterprise.getUserAccountDirectory().createUserAccount("chementadmin" + i, PasswordUtility.createPassword("chementadmin" + i), "dalal.vi@husky.neu.edu", chemistAdminEmployee, new AdminRole(Role.RoleType.Admin));

        enterpriseDirectory.createAndAddEnterprise(network.getName().substring(0, i) + "Supplier" + i, Enterprise.EnterpriseType.Supplier);
        Employee supplierAdminEmployee = chemistEnterprise.getEmployeeDirectory().createEmployee("suppadminemp" + i);
        chemistEnterprise.getUserAccountDirectory().createUserAccount("suppentadmin" + i, PasswordUtility.createPassword("suppentadmin" + i), "dalal.vi@husky.neu.edu", supplierAdminEmployee, new AdminRole(Role.RoleType.Admin));

        enterpriseDirectory.createAndAddEnterprise(network.getName().substring(0, i) + "Legal" + i, Enterprise.EnterpriseType.Legal);
        Employee legalAdminEmployee = chemistEnterprise.getEmployeeDirectory().createEmployee("legaladminemp" + i);
        chemistEnterprise.getUserAccountDirectory().createUserAccount("legalentadmin" + i, PasswordUtility.createPassword("legalentadmin" + i), "dalal.vi@husky.neu.edu", legalAdminEmployee, new AdminRole(Role.RoleType.Admin));

        enterpriseDirectory.createAndAddEnterprise(network.getName().substring(0, i) + "Manufacturer" + i, Enterprise.EnterpriseType.Manufacturer);
        Employee manufacturerAdminEmployee = chemistEnterprise.getEmployeeDirectory().createEmployee("manuadminemp" + i);
        chemistEnterprise.getUserAccountDirectory().createUserAccount("manuentadmin" + i, PasswordUtility.createPassword("manuentadmin" + i), "dalal.vi@husky.neu.edu", manufacturerAdminEmployee, new AdminRole(Role.RoleType.Admin));

        enterpriseDirectory.createAndAddEnterprise(network.getName().substring(0, i) + "Transporter" + i, Enterprise.EnterpriseType.Transporter);
        Employee transporterAdminEmployee = chemistEnterprise.getEmployeeDirectory().createEmployee("tranadminemp" + i);
        chemistEnterprise.getUserAccountDirectory().createUserAccount("tranentadmin" + i, PasswordUtility.createPassword("tranentadmin" + i), "dalal.vi@husky.neu.edu", transporterAdminEmployee, new AdminRole(Role.RoleType.Admin));

        //Enterprises have been added now. Let's populate Organizations in the Enterprise
        for (Enterprise enterprise : enterpriseDirectory.getEnterpriseList()) {
            int j = 1;
            OrganizationDirectory organizationDirectory = new OrganizationDirectory();
            //Adding organizations to the different enterprises
            for (int organizationCounter = 0; organizationCounter < 2; organizationCounter++) {
                addOrganizationToDirectory(organizationDirectory, enterprise, j);
                j++;
            }

            enterprise.setOrganizationDirectory(organizationDirectory);

        }

    }

    public static void addOrganizationToDirectory(OrganizationDirectory organizationDirectory, Enterprise enterprise, int j) {
        //Adding Admin in all the enterprises by default
        Organization admin = organizationDirectory.createOrganization("OrgAdmin" + j, Organization.OrganizationType.Admin);
        //Withing organization we have roles. For eg: AdminOrganization has admin role. We will add that now
        Employee adminEmp = admin.getEmployeeDirectory().createEmployee("orgadmin");
        Role adminRole = new AdminRole(Role.RoleType.Admin);
        admin.getUserAccountDirectory().createUserAccount("orgadmin", PasswordUtility.createPassword("orgadmin"), "dalal.vi@husky.neu.edu", adminEmp, adminRole);

        int k = 1;
        if (enterprise instanceof ChemistEnterprise) {
            //Adding Worker and Manager in Chemist Enterprise
            Organization worker = organizationDirectory.createOrganization("Worker" + j, Organization.OrganizationType.Worker);
            for (int employeeCounter = 0; employeeCounter < 2; employeeCounter++) {
                Employee workerEmp = worker.getEmployeeDirectory().createEmployee("worker" + employeeCounter);
                Role workerRole = new WorkerRole(Role.RoleType.Worker);
                worker.getUserAccountDirectory().createUserAccount("worker" + j, PasswordUtility.createPassword("worker" + j), "dalal.vi@husky.neu.edu", workerEmp, workerRole);

            }
            Organization manager = organizationDirectory.createOrganization("Manager" + j, Organization.OrganizationType.Manager);
            for (int employeeCounter = 0; employeeCounter < 2; employeeCounter++) {
                Employee managerEmp = manager.getEmployeeDirectory().createEmployee("manager" + employeeCounter);
                Role managerRole = new WorkerRole(Role.RoleType.Manager);
                manager.getUserAccountDirectory().createUserAccount("manager" + j, PasswordUtility.createPassword("manager" + j), "dalal.vi@husky.neu.edu", managerEmp, managerRole);
            }

        } else if (enterprise instanceof SupplierEnterprise) {
            //Adding Approver and Manager in Supplier Enterprise
            Organization approver = organizationDirectory.createOrganization("Approver" + j, Organization.OrganizationType.Approver);

            for (int employeeCounter = 0; employeeCounter < 2; employeeCounter++) {

                Employee approverEmp = approver.getEmployeeDirectory().createEmployee("approver" + employeeCounter);
                Role approverRole = new WorkerRole(Role.RoleType.Approver);
                approver.getUserAccountDirectory().createUserAccount("approver" + j, PasswordUtility.createPassword("approver" + j), "dalal.vi@husky.neu.edu", approverEmp, approverRole);
            }
        } else if (enterprise instanceof LegalEnterprise) {
            //Adding Validator in Legal Enterprise

            Organization validator = organizationDirectory.createOrganization("Validator" + j, Organization.OrganizationType.Validator);
            for (int employeeCounter = 0; employeeCounter < 2; employeeCounter++) {
                Employee validatorEmp = validator.getEmployeeDirectory().createEmployee("validator" + employeeCounter);
                Role validatorRole = new WorkerRole(Role.RoleType.Validator);
                validator.getUserAccountDirectory().createUserAccount("validator" + j, PasswordUtility.createPassword("validator" + j), "dalal.vi@husky.neu.edu", validatorEmp, validatorRole);
            }
        } else if (enterprise instanceof ManufacturerEnterprise) {
            //Adding Producer in Manufacturer Enterprise
            Organization producer = organizationDirectory.createOrganization("Producer" + j, Organization.OrganizationType.Producer);
            for (int employeeCounter = 0; employeeCounter < 2; employeeCounter++) {
                Employee producerEmp = producer.getEmployeeDirectory().createEmployee("producer" + employeeCounter);
                Role producerRole = new WorkerRole(Role.RoleType.Producer);
                producer.getUserAccountDirectory().createUserAccount("producer" + j, PasswordUtility.createPassword("producer" + j), "dalal.vi@husky.neu.edu", producerEmp, producerRole);

            }
        } else if (enterprise instanceof TransportationEnterprise) {
            //Adding Transporter in Transportation Enterprise
            Organization transporter = organizationDirectory.createOrganization("Transporter" + j, Organization.OrganizationType.Transporter);
            for (int employeeCounter = 0; employeeCounter < 2; employeeCounter++) {
                Employee transporterEmp = transporter.getEmployeeDirectory().createEmployee("transporter" + employeeCounter);
                Role transporterRole = new WorkerRole(Role.RoleType.Transporter);
                transporter.getUserAccountDirectory().createUserAccount("transporter" + j, PasswordUtility.createPassword("transporter" + j), "dalal.vi@husky.neu.edu", transporterEmp, transporterRole);

            }
        }
    }

}
