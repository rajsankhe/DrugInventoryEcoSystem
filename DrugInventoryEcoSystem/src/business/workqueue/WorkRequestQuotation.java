/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.workqueue;

import business.quotation.Quotation;

/**
 *
 * @author Tej Sankhe
 */
public class WorkRequestQuotation extends WorkRequest{
    Quotation quotationRequest;

    public WorkRequestQuotation(int size) {
        super(size);
        quotationRequest = new Quotation();
    }

    public Quotation getQuotationRequest() {
        return quotationRequest;
    }

    public void setQuotationRequest(Quotation quotationRequest) {
        this.quotationRequest = quotationRequest;
    }
    
    
}
