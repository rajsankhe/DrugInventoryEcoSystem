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
public class ManufacturerEnterprise extends Enterprise {

    private Inventory inventory;

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public ManufacturerEnterprise(String name, EnterpriseType type, String id) {
        super(name, type, id);
    }

    @Override
    public List<Role> getSupportedRole() {
        return null;
    }
}
