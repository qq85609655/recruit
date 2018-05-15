/**
 * ESB_GYD_GYD_InquiryHasCaptchaSrvServiceagentTest.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.3  Built on : Jun 27, 2015 (11:17:49 BST)
 */
package com.tcl.csot.www.esb_gyd_gyd_inquiryhascaptchasrv._1_0;


/*
 *  ESB_GYD_GYD_InquiryHasCaptchaSrvServiceagentTest Junit test case
 */
public class ESB_GYD_GYD_InquiryHasCaptchaSrvServiceagentTest extends junit.framework.TestCase {
    /**
     * Auto generated test method
     */
    public void testprocess() throws java.lang.Exception {
        com.tcl.csot.www.esb_gyd_gyd_inquiryhascaptchasrv._1_0.ESB_GYD_GYD_InquiryHasCaptchaSrvServiceagentStub stub =
            new com.tcl.csot.www.esb_gyd_gyd_inquiryhascaptchasrv._1_0.ESB_GYD_GYD_InquiryHasCaptchaSrvServiceagentStub(); //the default implementation should point to the right endpoint

        com.tcl.csot.www.esb_gyd_gyd_inquiryhascaptchasrv._1_0.ESB_GYD_GYD_InquiryHasCaptchaSrvServiceagentStub.ESB_GYD_GYD_InquiryHasCaptchaSrvRequestE eSB_GYD_GYD_InquiryHasCaptchaSrvRequest4 =
            (com.tcl.csot.www.esb_gyd_gyd_inquiryhascaptchasrv._1_0.ESB_GYD_GYD_InquiryHasCaptchaSrvServiceagentStub.ESB_GYD_GYD_InquiryHasCaptchaSrvRequestE) getTestObject(com.tcl.csot.www.esb_gyd_gyd_inquiryhascaptchasrv._1_0.ESB_GYD_GYD_InquiryHasCaptchaSrvServiceagentStub.ESB_GYD_GYD_InquiryHasCaptchaSrvRequestE.class);
        // TODO : Fill in the eSB_GYD_GYD_InquiryHasCaptchaSrvRequest4 here
        assertNotNull(stub.process(eSB_GYD_GYD_InquiryHasCaptchaSrvRequest4));
    }

    /**
     * Auto generated test method
     */
    public void testStartprocess() throws java.lang.Exception {
        com.tcl.csot.www.esb_gyd_gyd_inquiryhascaptchasrv._1_0.ESB_GYD_GYD_InquiryHasCaptchaSrvServiceagentStub stub =
            new com.tcl.csot.www.esb_gyd_gyd_inquiryhascaptchasrv._1_0.ESB_GYD_GYD_InquiryHasCaptchaSrvServiceagentStub();
        com.tcl.csot.www.esb_gyd_gyd_inquiryhascaptchasrv._1_0.ESB_GYD_GYD_InquiryHasCaptchaSrvServiceagentStub.ESB_GYD_GYD_InquiryHasCaptchaSrvRequestE eSB_GYD_GYD_InquiryHasCaptchaSrvRequest4 =
            (com.tcl.csot.www.esb_gyd_gyd_inquiryhascaptchasrv._1_0.ESB_GYD_GYD_InquiryHasCaptchaSrvServiceagentStub.ESB_GYD_GYD_InquiryHasCaptchaSrvRequestE) getTestObject(com.tcl.csot.www.esb_gyd_gyd_inquiryhascaptchasrv._1_0.ESB_GYD_GYD_InquiryHasCaptchaSrvServiceagentStub.ESB_GYD_GYD_InquiryHasCaptchaSrvRequestE.class);
        // TODO : Fill in the eSB_GYD_GYD_InquiryHasCaptchaSrvRequest4 here
        stub.startprocess(eSB_GYD_GYD_InquiryHasCaptchaSrvRequest4,
            new tempCallbackN1000C());
    }

    //Create an ADBBean and provide it as the test object
    public org.apache.axis2.databinding.ADBBean getTestObject(
        java.lang.Class type) throws java.lang.Exception {
        return (org.apache.axis2.databinding.ADBBean) type.newInstance();
    }

    private class tempCallbackN1000C extends com.tcl.csot.www.esb_gyd_gyd_inquiryhascaptchasrv._1_0.ESB_GYD_GYD_InquiryHasCaptchaSrvServiceagentCallbackHandler {
        public tempCallbackN1000C() {
            super(null);
        }

        public void receiveResultprocess(
            com.tcl.csot.www.esb_gyd_gyd_inquiryhascaptchasrv._1_0.ESB_GYD_GYD_InquiryHasCaptchaSrvServiceagentStub.ESB_GYD_GYD_InquiryHasCaptchaSrvResponseE result) {
        }

        public void receiveErrorprocess(java.lang.Exception e) {
            fail();
        }
    }
}
