
package com.csot.recruit.common.webservice.outside.getCaptcha;

import javax.xml.ws.Endpoint;

/**
 * This class was generated by Apache CXF 2.7.12
 * 2015-10-14T20:29:05.643+08:00
 * Generated source version: 2.7.12
 * 
 */
 
public class ESBGYDGYDInquiryCaptchaSrv_ESBGYDGYDInquiryCaptchaSrv_Server{

    protected ESBGYDGYDInquiryCaptchaSrv_ESBGYDGYDInquiryCaptchaSrv_Server() throws java.lang.Exception {
        System.out.println("Starting Server");
        Object implementor = new ESBGYDGYDInquiryCaptchaSrvImpl();
        String address = "http://t2eaesbapp01.csot.tcl.com:9016/Services/ESB_GYD_GYD_InquiryCaptchaSrv/v1.0.0";
        Endpoint.publish(address, implementor);
    }
    
    public static void main(String args[]) throws java.lang.Exception { 
        new ESBGYDGYDInquiryCaptchaSrv_ESBGYDGYDInquiryCaptchaSrv_Server();
        System.out.println("Server ready..."); 
        
        Thread.sleep(5 * 60 * 1000); 
        System.out.println("Server exiting");
        System.exit(0);
    }
}
