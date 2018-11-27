/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import business.network.NetworkDirectory;

/**
 *
 * @author vivekdalal
 */
public class EcoSystem {

    private static EcoSystem business;
    NetworkDirectory networkDirectory;

    public static EcoSystem getInstance() {
        if (business == null) {
            business = new EcoSystem();
        }
        return business;
    }

    private EcoSystem() {
        //super(null); Do we need this?
        networkDirectory = new NetworkDirectory();
    }

//    public boolean checkIfUserIsUnique(String userName) {
//        if (!this.getUserAccountDirectory().checkIfUsernameIsUnique(userName)) {
//            return false;
//        }
//        for (Network network : networkList) {
//
//        }
//        return true;
//    }
    public NetworkDirectory getNetworkDirectory() {
        return networkDirectory;
    }

//    public void setNetworkDirectory(NetworkDirectory networkDirectory) {
//        this.networkDirectory = networkDirectory;
//    }
}
