/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.workqueue;


import java.util.ArrayList;

/**
 *
 * @author Tej Sankhe
 */
public class WorkQueue {
    private ArrayList<WorkRequest> workRequestList;

    public WorkQueue() {
        workRequestList = new ArrayList();
    }

    public ArrayList<WorkRequest> getWorkRequestList() {
        return workRequestList;
    }
    
    public WorkRequest addWorkRequest(WorkRequest.workRequestType wRequestType){
        WorkRequest workRequest = null;
        if(wRequestType == WorkRequest.workRequestType.Bid){
            workRequest = new WorkRequestBid(workRequestList.size());
        }
        else if(wRequestType == WorkRequest.workRequestType.Drugs){
            workRequest = new WorkRequestDrugs(workRequestList.size());
        }
        else if(wRequestType == WorkRequest.workRequestType.Quotation){
            workRequest = new WorkRequestQuotation(workRequestList.size());
        }
        this.workRequestList.add(workRequest);
        return workRequest;
    }
    
    public void deleteWorkRequest(WorkRequest workRequest){
        this.workRequestList.remove(workRequest);
    }
}
