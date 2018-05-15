/**
 * ESB_GYD_GYD_InquiryHasCaptchaSrvServiceagentCallbackHandler.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.3  Built on : Jun 27, 2015 (11:17:49 BST)
 */
package com.tcl.csot.www.esb_gyd_gyd_inquiryhascaptchasrv._1_0;


/**
 *  ESB_GYD_GYD_InquiryHasCaptchaSrvServiceagentCallbackHandler Callback class, Users can extend this class and implement
 *  their own receiveResult and receiveError methods.
 */
public abstract class ESB_GYD_GYD_InquiryHasCaptchaSrvServiceagentCallbackHandler {
    protected Object clientData;

    /**
     * User can pass in any object that needs to be accessed once the NonBlocking
     * Web service call is finished and appropriate method of this CallBack is called.
     * @param clientData Object mechanism by which the user can pass in user data
     * that will be avilable at the time this callback is called.
     */
    public ESB_GYD_GYD_InquiryHasCaptchaSrvServiceagentCallbackHandler(
        Object clientData) {
        this.clientData = clientData;
    }

    /**
     * Please use this constructor if you don't want to set any clientData
     */
    public ESB_GYD_GYD_InquiryHasCaptchaSrvServiceagentCallbackHandler() {
        this.clientData = null;
    }

    /**
     * Get the client data
     */
    public Object getClientData() {
        return clientData;
    }

    /**
     * auto generated Axis2 call back method for process method
     * override this method for handling normal response from process operation
     */
    public void receiveResultprocess(
        com.tcl.csot.www.esb_gyd_gyd_inquiryhascaptchasrv._1_0.ESB_GYD_GYD_InquiryHasCaptchaSrvServiceagentStub.ESB_GYD_GYD_InquiryHasCaptchaSrvResponseE result) {
    }

    /**
     * auto generated Axis2 Error handler
     * override this method for handling error response from process operation
     */
    public void receiveErrorprocess(java.lang.Exception e) {
    }
}
