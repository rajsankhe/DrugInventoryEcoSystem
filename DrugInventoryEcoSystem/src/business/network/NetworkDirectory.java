/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.network;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 *
 * @author vivekdalal
 */
public class NetworkDirectory {

    Map<String, Network> networkList;

    public NetworkDirectory() {
        this.networkList = new HashMap<>();
    }
    
    

    public Network createAndAddNetwork() {
        Network network = new Network();
        //left
        //Check if netwrok already exists
        networkList.put(network.getName(), network);
        return network;
    }
    public List<Network> getNetworkList() {
        
        return networkList.values().stream().collect(Collectors.toList());
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
