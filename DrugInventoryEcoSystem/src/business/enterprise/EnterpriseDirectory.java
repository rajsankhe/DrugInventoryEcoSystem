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

        for (Enterprise e : enterpriseList) {
            if (e.getName().equalsIgnoreCase(name)) {
                //Enerprise with the name passed already exists
                return null;

            }
        }

        if (type == Enterprise.EnterpriseType.Chemist) {
            enterprise = new ChemistEnterprise(name, type);
        } else if (type == Enterprise.EnterpriseType.Legal) {
            enterprise = new LegalEnterprise(name, type);
        } else if (type == Enterprise.EnterpriseType.Manufacturer) {
            enterprise = new ManufacturerEnterprise(name, type);
        } else if (type == Enterprise.EnterpriseType.Transporter) {
            enterprise = new TransportationEnterprise(name, type);
        } else if (type == Enterprise.EnterpriseType.Supplier) {
            enterprise = new SupplierEnterprise(name, type);
        }

        enterpriseList.add(enterprise);
        return enterprise;
    }

}
