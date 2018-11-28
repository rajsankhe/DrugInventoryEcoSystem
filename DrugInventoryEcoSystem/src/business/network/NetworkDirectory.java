/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.network;

import java.util.Map;

/**
 *
 * @author vivekdalal
 */
public class NetworkDirectory {

    Map<String, Network> networkList;

    public Network createAndAddNetwork() {
        Network network = new Network();
        //left
        //Check if netwrok already exists
        networkList.put(network.getName(), network);
        return network;
    }

    public Map<String, Network> getNetworkList() {
        return networkList;
    }

    public void setNetworkList(Map<String, Network> networkList) {
        this.networkList = networkList;
    }

    //left
    public void deleteNetwork(Network network) {
//        Network network = new Network();
//        networkDirectory.put(network.getName(), network);
//        return network;
    }
}
