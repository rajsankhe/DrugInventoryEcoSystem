/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.enterprise;

import business.inventory.Inventory;
import business.role.Role;
import java.util.List;

/**
 *
 * @author vivekdalal
 */
public class SupplierEnterprise extends Enterprise {

    private Inventory inventory;

    public SupplierEnterprise(String name, EnterpriseType type, int id) {
        super(name, type, id);
        inventory = new Inventory();
    }

    @Override
    public List<Role> getSupportedRole() {
        return null;
    }

}
