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

    Map<String, Network> networkDirectory;

    public Network createAndAddNetwork() {
        Network network = new Network();
        networkDirectory.put(network.getName(), network);
        return network;
    }

    //left
    public void deleteNetwork(Network network) {
//        Network network = new Network();
//        networkDirectory.put(network.getName(), network);
//        return network;
    }
}
