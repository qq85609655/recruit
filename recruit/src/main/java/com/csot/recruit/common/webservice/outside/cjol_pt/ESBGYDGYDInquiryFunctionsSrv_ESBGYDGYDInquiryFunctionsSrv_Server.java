
package com.csot.recruit.common.webservice.outside.cjol_pt;

import javax.xml.ws.Endpoint;

/**
 * This class was generated by Apache CXF 2.7.12
 * 2015-10-22T16:06:51.948+08:00
 * Generated source version: 2.7.12
 * 
 */
 
public class ESBGYDGYDInquiryFunctionsSrv_ESBGYDGYDInquiryFunctionsSrv_Server{

    protected ESBGYDGYDInquiryFunctionsSrv_ESBGYDGYDInquiryFunctionsSrv_Server() throws java.lang.Exception {
        System.out.println("Starting Server");
        Object implementor = new ESBGYDGYDInquiryFunctionsSrvImpl();
        String address = "http://t2eaesbapp01.csot.tcl.com:9016/Services/ESB_GYD_GYD_InquiryFunctionsSrv/v1.0.0";
        Endpoint.publish(address, implementor);
    }
    
    public static void main(String args[]) throws java.lang.Exception { 
        new ESBGYDGYDInquiryFunctionsSrv_ESBGYDGYDInquiryFunctionsSrv_Server();
        System.out.println("Server ready..."); 
        
        Thread.sleep(5 * 60 * 1000); 
        System.out.println("Server exiting");
        System.exit(0);
    }
}
