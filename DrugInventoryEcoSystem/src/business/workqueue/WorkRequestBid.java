/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.workqueue;

import business.bid.Bid;

/**
 *
 * @author Tej Sankhe
 */
public class WorkRequestBid extends WorkRequest {

    Bid bidRequest;

    public WorkRequestBid(String size) {
        super(size);
        this.bidRequest = new Bid();
    }

    public Bid getBidRequest() {
        return bidRequest;
    }

    public void setBidRequest(Bid bidRequest) {
        this.bidRequest = bidRequest;
    }

}
