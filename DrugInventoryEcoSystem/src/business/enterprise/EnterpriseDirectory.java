/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.enterprise;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author vivekdalal
 */
public class EnterpriseDirectory {

    List<Enterprise> enterpriseDirectory;

    public EnterpriseDirectory() {
        enterpriseDirectory = new ArrayList();
    }

    public List<Enterprise> getEnterpriseDirectory() {
        return enterpriseDirectory;
    }

    public void setEnterpriseDirectory(List<Enterprise> enterpriseDirectory) {
        this.enterpriseDirectory = enterpriseDirectory;
    }

    //Create enterprise
    public Enterprise createAndAddEnterprise(String name, Enterprise.EnterpriseType type) {
        Enterprise enterprise = null;
        if (type == Enterprise.EnterpriseType.Chemist) {
            enterpriseDirectory.add(new ChemistEnterprise(name, type));
        } else if (type == Enterprise.EnterpriseType.Legal) {
            enterpriseDirectory.add(new LegalEnterprise(name, type));
        } else if (type == Enterprise.EnterpriseType.Manufacturer) {
            enterpriseDirectory.add(new ManufacturerEnterprise(name, type));
        } else if (type == Enterprise.EnterpriseType.Transporter) {
            enterpriseDirectory.add(new TransportationEnterprise(name, type));
        } else if (type == Enterprise.EnterpriseType.Supplier) {
            enterpriseDirectory.add(new SupplierEnterprise(name, type));
        }
        return enterprise;
    }

}
