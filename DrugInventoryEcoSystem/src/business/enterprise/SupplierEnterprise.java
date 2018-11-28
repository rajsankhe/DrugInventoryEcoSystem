/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.enterprise;

import business.role.Role;
import java.util.List;

/**
 *
 * @author vivekdalal
 */
public class SupplierEnterprise extends Enterprise {

    public SupplierEnterprise(String name, EnterpriseType type) {
        super(name, type);
    }

    @Override
    public List<Role> getSupportedRole() {
        return null;
    }

}
