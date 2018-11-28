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

    List<Enterprise> enterpriseList;

    public EnterpriseDirectory() {
        enterpriseList = new ArrayList();
    }

    public List<Enterprise> getEnterpriseList() {
        return enterpriseList;
    }

    public void setEnterpriseList(List<Enterprise> enterpriseList) {
        this.enterpriseList = enterpriseList;
    }

    //Create enterprise
    public Enterprise createAndAddEnterprise(String name, Enterprise.EnterpriseType type) {
        Enterprise enterprise = null;
        if (type == Enterprise.EnterpriseType.Chemist) {
            enterpriseList.add(new ChemistEnterprise(name, type));
        } else if (type == Enterprise.EnterpriseType.Legal) {
            enterpriseList.add(new LegalEnterprise(name, type));
        } else if (type == Enterprise.EnterpriseType.Manufacturer) {
            enterpriseList.add(new ManufacturerEnterprise(name, type));
        } else if (type == Enterprise.EnterpriseType.Transporter) {
            enterpriseList.add(new TransportationEnterprise(name, type));
        } else if (type == Enterprise.EnterpriseType.Supplier) {
            enterpriseList.add(new SupplierEnterprise(name, type));
        }
        return enterprise;
    }

}
