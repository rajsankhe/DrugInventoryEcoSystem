/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.enterprise;

import business.organization.OrganizationDirectory;

/**
 *
 * @author vivekdalal
 */
public class Enterprise {

    //left
    private int id; //Generate UUID.
    private String name;
    private EnterpriseType enterpriseType;
    private OrganizationDirectory organizationDirectory;

    public OrganizationDirectory getOrganizationDirectory() {
        return organizationDirectory;
    }

    public enum EnterpriseType {
        Chemist("Chemist"), Supplier("Supplier"), Transporter("Transporter"), Legal("Legal"), Manufacturer("Manufacturer");

        private String value;

        private EnterpriseType(String value) {
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

    public EnterpriseType getEnterpriseType() {
        return enterpriseType;
    }

    public void setEnterpriseType(EnterpriseType enterpriseType) {
        this.enterpriseType = enterpriseType;
    }

    public Enterprise(String name, EnterpriseType type) {
        //super(name); Do we need this?
        this.name = name;
        this.enterpriseType = type;
        organizationDirectory = new OrganizationDirectory();
    }
}
