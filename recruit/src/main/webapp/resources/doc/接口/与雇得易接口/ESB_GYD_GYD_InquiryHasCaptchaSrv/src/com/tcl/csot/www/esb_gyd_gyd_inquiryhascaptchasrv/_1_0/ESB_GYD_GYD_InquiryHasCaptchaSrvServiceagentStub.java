/**
 * ESB_GYD_GYD_InquiryHasCaptchaSrvServiceagentStub.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.3  Built on : Jun 27, 2015 (11:17:49 BST)
 */
package com.tcl.csot.www.esb_gyd_gyd_inquiryhascaptchasrv._1_0;


/*
 *  ESB_GYD_GYD_InquiryHasCaptchaSrvServiceagentStub java implementation
 */
public class ESB_GYD_GYD_InquiryHasCaptchaSrvServiceagentStub extends org.apache.axis2.client.Stub {
    private static int counter = 0;
    protected org.apache.axis2.description.AxisOperation[] _operations;

    //hashmaps to keep the fault mapping
    private java.util.HashMap faultExceptionNameMap = new java.util.HashMap();
    private java.util.HashMap faultExceptionClassNameMap = new java.util.HashMap();
    private java.util.HashMap faultMessageMap = new java.util.HashMap();
    private javax.xml.namespace.QName[] opNameArray = null;

    /**
     *Constructor that takes in a configContext
     */
    public ESB_GYD_GYD_InquiryHasCaptchaSrvServiceagentStub(
        org.apache.axis2.context.ConfigurationContext configurationContext,
        java.lang.String targetEndpoint) throws org.apache.axis2.AxisFault {
        this(configurationContext, targetEndpoint, false);
    }

    /**
     * Constructor that takes in a configContext  and useseperate listner
     */
    public ESB_GYD_GYD_InquiryHasCaptchaSrvServiceagentStub(
        org.apache.axis2.context.ConfigurationContext configurationContext,
        java.lang.String targetEndpoint, boolean useSeparateListener)
        throws org.apache.axis2.AxisFault {
        //To populate AxisService
        populateAxisService();
        populateFaults();

        _serviceClient = new org.apache.axis2.client.ServiceClient(configurationContext,
                _service);

        _serviceClient.getOptions()
                      .setTo(new org.apache.axis2.addressing.EndpointReference(
                targetEndpoint));
        _serviceClient.getOptions().setUseSeparateListener(useSeparateListener);
    }

    /**
     * Default Constructor
     */
    public ESB_GYD_GYD_InquiryHasCaptchaSrvServiceagentStub(
        org.apache.axis2.context.ConfigurationContext configurationContext)
        throws org.apache.axis2.AxisFault {
        this(configurationContext,
            "http://localhost:9001/Services/ESB_GYD_GYD_InquiryHasCaptchaSrv/v1.0.0");
    }

    /**
     * Default Constructor
     */
    public ESB_GYD_GYD_InquiryHasCaptchaSrvServiceagentStub()
        throws org.apache.axis2.AxisFault {
        this(
            "http://localhost:9001/Services/ESB_GYD_GYD_InquiryHasCaptchaSrv/v1.0.0");
    }

    /**
     * Constructor taking the target endpoint
     */
    public ESB_GYD_GYD_InquiryHasCaptchaSrvServiceagentStub(
        java.lang.String targetEndpoint) throws org.apache.axis2.AxisFault {
        this(null, targetEndpoint);
    }

    private static synchronized java.lang.String getUniqueSuffix() {
        // reset the counter if it is greater than 99999
        if (counter > 99999) {
            counter = 0;
        }

        counter = counter + 1;

        return java.lang.Long.toString(java.lang.System.currentTimeMillis()) +
        "_" + counter;
    }

    private void populateAxisService() throws org.apache.axis2.AxisFault {
        //creating the Service with a unique name
        _service = new org.apache.axis2.description.AxisService(
                "ESB_GYD_GYD_InquiryHasCaptchaSrvServiceagent" +
                getUniqueSuffix());
        addAnonymousOperations();

        //creating the operations
        org.apache.axis2.description.AxisOperation __operation;

        _operations = new org.apache.axis2.description.AxisOperation[1];

        __operation = new org.apache.axis2.description.OutInAxisOperation();

        __operation.setName(new javax.xml.namespace.QName(
                "http://www.csot.tcl.com/ESB_GYD_GYD_InquiryHasCaptchaSrv/1.0",
                "process"));
        _service.addOperation(__operation);

        _operations[0] = __operation;
    }

    //populates the faults
    private void populateFaults() {
    }

    /**
     * Auto generated method signature
     *
     * @see com.tcl.csot.www.esb_gyd_gyd_inquiryhascaptchasrv._1_0.ESB_GYD_GYD_InquiryHasCaptchaSrvServiceagent#process
     * @param eSB_GYD_GYD_InquiryHasCaptchaSrvRequest0
     */
    public com.tcl.csot.www.esb_gyd_gyd_inquiryhascaptchasrv._1_0.ESB_GYD_GYD_InquiryHasCaptchaSrvServiceagentStub.ESB_GYD_GYD_InquiryHasCaptchaSrvResponseE process(
        com.tcl.csot.www.esb_gyd_gyd_inquiryhascaptchasrv._1_0.ESB_GYD_GYD_InquiryHasCaptchaSrvServiceagentStub.ESB_GYD_GYD_InquiryHasCaptchaSrvRequestE eSB_GYD_GYD_InquiryHasCaptchaSrvRequest0)
        throws java.rmi.RemoteException {
        org.apache.axis2.context.MessageContext _messageContext = null;

        try {
            org.apache.axis2.client.OperationClient _operationClient = _serviceClient.createClient(_operations[0].getName());
            _operationClient.getOptions()
                            .setAction("/ESB_GYD_GYD_InquiryHasCaptchaSrv/v1/process");
            _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);

            addPropertyToOperationClient(_operationClient,
                org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR,
                "&");

            // create a message context
            _messageContext = new org.apache.axis2.context.MessageContext();

            // create SOAP envelope with that payload
            org.apache.axiom.soap.SOAPEnvelope env = null;

            env = toEnvelope(getFactory(_operationClient.getOptions()
                                                        .getSoapVersionURI()),
                    eSB_GYD_GYD_InquiryHasCaptchaSrvRequest0,
                    optimizeContent(
                        new javax.xml.namespace.QName(
                            "http://www.csot.tcl.com/ESB_GYD_GYD_InquiryHasCaptchaSrv/1.0",
                            "process")),
                    new javax.xml.namespace.QName(
                        "http://www.csot.tcl.com/ESB_GYD_GYD_InquiryHasCaptchaSrv/1.0",
                        "process"));

            //adding SOAP soap_headers
            _serviceClient.addHeadersToEnvelope(env);
            // set the message context with that soap envelope
            _messageContext.setEnvelope(env);

            // add the message contxt to the operation client
            _operationClient.addMessageContext(_messageContext);

            //execute the operation client
            _operationClient.execute(true);

            org.apache.axis2.context.MessageContext _returnMessageContext = _operationClient.getMessageContext(org.apache.axis2.wsdl.WSDLConstants.MESSAGE_LABEL_IN_VALUE);
            org.apache.axiom.soap.SOAPEnvelope _returnEnv = _returnMessageContext.getEnvelope();

            java.lang.Object object = fromOM(_returnEnv.getBody()
                                                       .getFirstElement(),
                    com.tcl.csot.www.esb_gyd_gyd_inquiryhascaptchasrv._1_0.ESB_GYD_GYD_InquiryHasCaptchaSrvServiceagentStub.ESB_GYD_GYD_InquiryHasCaptchaSrvResponseE.class,
                    getEnvelopeNamespaces(_returnEnv));

            return (com.tcl.csot.www.esb_gyd_gyd_inquiryhascaptchasrv._1_0.ESB_GYD_GYD_InquiryHasCaptchaSrvServiceagentStub.ESB_GYD_GYD_InquiryHasCaptchaSrvResponseE) object;
        } catch (org.apache.axis2.AxisFault f) {
            org.apache.axiom.om.OMElement faultElt = f.getDetail();

            if (faultElt != null) {
                if (faultExceptionNameMap.containsKey(
                            new org.apache.axis2.client.FaultMapKey(
                                faultElt.getQName(), "process"))) {
                    //make the fault by reflection
                    try {
                        java.lang.String exceptionClassName = (java.lang.String) faultExceptionClassNameMap.get(new org.apache.axis2.client.FaultMapKey(
                                    faultElt.getQName(), "process"));
                        java.lang.Class exceptionClass = java.lang.Class.forName(exceptionClassName);
                        java.lang.reflect.Constructor constructor = exceptionClass.getConstructor(java.lang.String.class);
                        java.lang.Exception ex = (java.lang.Exception) constructor.newInstance(f.getMessage());

                        //message class
                        java.lang.String messageClassName = (java.lang.String) faultMessageMap.get(new org.apache.axis2.client.FaultMapKey(
                                    faultElt.getQName(), "process"));
                        java.lang.Class messageClass = java.lang.Class.forName(messageClassName);
                        java.lang.Object messageObject = fromOM(faultElt,
                                messageClass, null);
                        java.lang.reflect.Method m = exceptionClass.getMethod("setFaultMessage",
                                new java.lang.Class[] { messageClass });
                        m.invoke(ex, new java.lang.Object[] { messageObject });

                        throw new java.rmi.RemoteException(ex.getMessage(), ex);
                    } catch (java.lang.ClassCastException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (java.lang.ClassNotFoundException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (java.lang.NoSuchMethodException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (java.lang.reflect.InvocationTargetException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (java.lang.IllegalAccessException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (java.lang.InstantiationException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }
                } else {
                    throw f;
                }
            } else {
                throw f;
            }
        } finally {
            if (_messageContext.getTransportOut() != null) {
                _messageContext.getTransportOut().getSender()
                               .cleanup(_messageContext);
            }
        }
    }

    /**
     * Auto generated method signature for Asynchronous Invocations
     *
     * @see com.tcl.csot.www.esb_gyd_gyd_inquiryhascaptchasrv._1_0.ESB_GYD_GYD_InquiryHasCaptchaSrvServiceagent#startprocess
     * @param eSB_GYD_GYD_InquiryHasCaptchaSrvRequest0
     */
    public void startprocess(
        com.tcl.csot.www.esb_gyd_gyd_inquiryhascaptchasrv._1_0.ESB_GYD_GYD_InquiryHasCaptchaSrvServiceagentStub.ESB_GYD_GYD_InquiryHasCaptchaSrvRequestE eSB_GYD_GYD_InquiryHasCaptchaSrvRequest0,
        final com.tcl.csot.www.esb_gyd_gyd_inquiryhascaptchasrv._1_0.ESB_GYD_GYD_InquiryHasCaptchaSrvServiceagentCallbackHandler callback)
        throws java.rmi.RemoteException {
        org.apache.axis2.client.OperationClient _operationClient = _serviceClient.createClient(_operations[0].getName());
        _operationClient.getOptions()
                        .setAction("/ESB_GYD_GYD_InquiryHasCaptchaSrv/v1/process");
        _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);

        addPropertyToOperationClient(_operationClient,
            org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR,
            "&");

        // create SOAP envelope with that payload
        org.apache.axiom.soap.SOAPEnvelope env = null;
        final org.apache.axis2.context.MessageContext _messageContext = new org.apache.axis2.context.MessageContext();

        //Style is Doc.
        env = toEnvelope(getFactory(_operationClient.getOptions()
                                                    .getSoapVersionURI()),
                eSB_GYD_GYD_InquiryHasCaptchaSrvRequest0,
                optimizeContent(
                    new javax.xml.namespace.QName(
                        "http://www.csot.tcl.com/ESB_GYD_GYD_InquiryHasCaptchaSrv/1.0",
                        "process")),
                new javax.xml.namespace.QName(
                    "http://www.csot.tcl.com/ESB_GYD_GYD_InquiryHasCaptchaSrv/1.0",
                    "process"));

        // adding SOAP soap_headers
        _serviceClient.addHeadersToEnvelope(env);
        // create message context with that soap envelope
        _messageContext.setEnvelope(env);

        // add the message context to the operation client
        _operationClient.addMessageContext(_messageContext);

        _operationClient.setCallback(new org.apache.axis2.client.async.AxisCallback() {
                public void onMessage(
                    org.apache.axis2.context.MessageContext resultContext) {
                    try {
                        org.apache.axiom.soap.SOAPEnvelope resultEnv = resultContext.getEnvelope();

                        java.lang.Object object = fromOM(resultEnv.getBody()
                                                                  .getFirstElement(),
                                com.tcl.csot.www.esb_gyd_gyd_inquiryhascaptchasrv._1_0.ESB_GYD_GYD_InquiryHasCaptchaSrvServiceagentStub.ESB_GYD_GYD_InquiryHasCaptchaSrvResponseE.class,
                                getEnvelopeNamespaces(resultEnv));
                        callback.receiveResultprocess((com.tcl.csot.www.esb_gyd_gyd_inquiryhascaptchasrv._1_0.ESB_GYD_GYD_InquiryHasCaptchaSrvServiceagentStub.ESB_GYD_GYD_InquiryHasCaptchaSrvResponseE) object);
                    } catch (org.apache.axis2.AxisFault e) {
                        callback.receiveErrorprocess(e);
                    }
                }

                public void onError(java.lang.Exception error) {
                    if (error instanceof org.apache.axis2.AxisFault) {
                        org.apache.axis2.AxisFault f = (org.apache.axis2.AxisFault) error;
                        org.apache.axiom.om.OMElement faultElt = f.getDetail();

                        if (faultElt != null) {
                            if (faultExceptionNameMap.containsKey(
                                        new org.apache.axis2.client.FaultMapKey(
                                            faultElt.getQName(), "process"))) {
                                //make the fault by reflection
                                try {
                                    java.lang.String exceptionClassName = (java.lang.String) faultExceptionClassNameMap.get(new org.apache.axis2.client.FaultMapKey(
                                                faultElt.getQName(), "process"));
                                    java.lang.Class exceptionClass = java.lang.Class.forName(exceptionClassName);
                                    java.lang.reflect.Constructor constructor = exceptionClass.getConstructor(java.lang.String.class);
                                    java.lang.Exception ex = (java.lang.Exception) constructor.newInstance(f.getMessage());

                                    //message class
                                    java.lang.String messageClassName = (java.lang.String) faultMessageMap.get(new org.apache.axis2.client.FaultMapKey(
                                                faultElt.getQName(), "process"));
                                    java.lang.Class messageClass = java.lang.Class.forName(messageClassName);
                                    java.lang.Object messageObject = fromOM(faultElt,
                                            messageClass, null);
                                    java.lang.reflect.Method m = exceptionClass.getMethod("setFaultMessage",
                                            new java.lang.Class[] { messageClass });
                                    m.invoke(ex,
                                        new java.lang.Object[] { messageObject });

                                    callback.receiveErrorprocess(new java.rmi.RemoteException(
                                            ex.getMessage(), ex));
                                } catch (java.lang.ClassCastException e) {
                                    // we cannot intantiate the class - throw the original Axis fault
                                    callback.receiveErrorprocess(f);
                                } catch (java.lang.ClassNotFoundException e) {
                                    // we cannot intantiate the class - throw the original Axis fault
                                    callback.receiveErrorprocess(f);
                                } catch (java.lang.NoSuchMethodException e) {
                                    // we cannot intantiate the class - throw the original Axis fault
                                    callback.receiveErrorprocess(f);
                                } catch (java.lang.reflect.InvocationTargetException e) {
                                    // we cannot intantiate the class - throw the original Axis fault
                                    callback.receiveErrorprocess(f);
                                } catch (java.lang.IllegalAccessException e) {
                                    // we cannot intantiate the class - throw the original Axis fault
                                    callback.receiveErrorprocess(f);
                                } catch (java.lang.InstantiationException e) {
                                    // we cannot intantiate the class - throw the original Axis fault
                                    callback.receiveErrorprocess(f);
                                } catch (org.apache.axis2.AxisFault e) {
                                    // we cannot intantiate the class - throw the original Axis fault
                                    callback.receiveErrorprocess(f);
                                }
                            } else {
                                callback.receiveErrorprocess(f);
                            }
                        } else {
                            callback.receiveErrorprocess(f);
                        }
                    } else {
                        callback.receiveErrorprocess(error);
                    }
                }

                public void onFault(
                    org.apache.axis2.context.MessageContext faultContext) {
                    org.apache.axis2.AxisFault fault = org.apache.axis2.util.Utils.getInboundFaultFromMessageContext(faultContext);
                    onError(fault);
                }

                public void onComplete() {
                    try {
                        _messageContext.getTransportOut().getSender()
                                       .cleanup(_messageContext);
                    } catch (org.apache.axis2.AxisFault axisFault) {
                        callback.receiveErrorprocess(axisFault);
                    }
                }
            });

        org.apache.axis2.util.CallbackReceiver _callbackReceiver = null;

        if ((_operations[0].getMessageReceiver() == null) &&
                _operationClient.getOptions().isUseSeparateListener()) {
            _callbackReceiver = new org.apache.axis2.util.CallbackReceiver();
            _operations[0].setMessageReceiver(_callbackReceiver);
        }

        //execute the operation client
        _operationClient.execute(false);
    }

    /**
     *  A utility method that copies the namepaces from the SOAPEnvelope
     */
    private java.util.Map getEnvelopeNamespaces(
        org.apache.axiom.soap.SOAPEnvelope env) {
        java.util.Map returnMap = new java.util.HashMap();
        java.util.Iterator namespaceIterator = env.getAllDeclaredNamespaces();

        while (namespaceIterator.hasNext()) {
            org.apache.axiom.om.OMNamespace ns = (org.apache.axiom.om.OMNamespace) namespaceIterator.next();
            returnMap.put(ns.getPrefix(), ns.getNamespaceURI());
        }

        return returnMap;
    }

    private boolean optimizeContent(javax.xml.namespace.QName opName) {
        if (opNameArray == null) {
            return false;
        }

        for (int i = 0; i < opNameArray.length; i++) {
            if (opName.equals(opNameArray[i])) {
                return true;
            }
        }

        return false;
    }

    private org.apache.axiom.om.OMElement toOM(
        com.tcl.csot.www.esb_gyd_gyd_inquiryhascaptchasrv._1_0.ESB_GYD_GYD_InquiryHasCaptchaSrvServiceagentStub.ESB_GYD_GYD_InquiryHasCaptchaSrvRequestE param,
        boolean optimizeContent) throws org.apache.axis2.AxisFault {
        try {
            return param.getOMElement(com.tcl.csot.www.esb_gyd_gyd_inquiryhascaptchasrv._1_0.ESB_GYD_GYD_InquiryHasCaptchaSrvServiceagentStub.ESB_GYD_GYD_InquiryHasCaptchaSrvRequestE.MY_QNAME,
                org.apache.axiom.om.OMAbstractFactory.getOMFactory());
        } catch (org.apache.axis2.databinding.ADBException e) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }
    }

    private org.apache.axiom.om.OMElement toOM(
        com.tcl.csot.www.esb_gyd_gyd_inquiryhascaptchasrv._1_0.ESB_GYD_GYD_InquiryHasCaptchaSrvServiceagentStub.ESB_GYD_GYD_InquiryHasCaptchaSrvResponseE param,
        boolean optimizeContent) throws org.apache.axis2.AxisFault {
        try {
            return param.getOMElement(com.tcl.csot.www.esb_gyd_gyd_inquiryhascaptchasrv._1_0.ESB_GYD_GYD_InquiryHasCaptchaSrvServiceagentStub.ESB_GYD_GYD_InquiryHasCaptchaSrvResponseE.MY_QNAME,
                org.apache.axiom.om.OMAbstractFactory.getOMFactory());
        } catch (org.apache.axis2.databinding.ADBException e) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }
    }

    private org.apache.axiom.soap.SOAPEnvelope toEnvelope(
        org.apache.axiom.soap.SOAPFactory factory,
        com.tcl.csot.www.esb_gyd_gyd_inquiryhascaptchasrv._1_0.ESB_GYD_GYD_InquiryHasCaptchaSrvServiceagentStub.ESB_GYD_GYD_InquiryHasCaptchaSrvRequestE param,
        boolean optimizeContent, javax.xml.namespace.QName methodQName)
        throws org.apache.axis2.AxisFault {
        try {
            org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
            emptyEnvelope.getBody()
                         .addChild(param.getOMElement(
                    com.tcl.csot.www.esb_gyd_gyd_inquiryhascaptchasrv._1_0.ESB_GYD_GYD_InquiryHasCaptchaSrvServiceagentStub.ESB_GYD_GYD_InquiryHasCaptchaSrvRequestE.MY_QNAME,
                    factory));

            return emptyEnvelope;
        } catch (org.apache.axis2.databinding.ADBException e) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }
    }

    /* methods to provide back word compatibility */

    /**
     *  get the default envelope
     */
    private org.apache.axiom.soap.SOAPEnvelope toEnvelope(
        org.apache.axiom.soap.SOAPFactory factory) {
        return factory.getDefaultEnvelope();
    }

    private java.lang.Object fromOM(org.apache.axiom.om.OMElement param,
        java.lang.Class type, java.util.Map extraNamespaces)
        throws org.apache.axis2.AxisFault {
        try {
            if (com.tcl.csot.www.esb_gyd_gyd_inquiryhascaptchasrv._1_0.ESB_GYD_GYD_InquiryHasCaptchaSrvServiceagentStub.ESB_GYD_GYD_InquiryHasCaptchaSrvRequestE.class.equals(
                        type)) {
                return com.tcl.csot.www.esb_gyd_gyd_inquiryhascaptchasrv._1_0.ESB_GYD_GYD_InquiryHasCaptchaSrvServiceagentStub.ESB_GYD_GYD_InquiryHasCaptchaSrvRequestE.Factory.parse(param.getXMLStreamReaderWithoutCaching());
            }

            if (com.tcl.csot.www.esb_gyd_gyd_inquiryhascaptchasrv._1_0.ESB_GYD_GYD_InquiryHasCaptchaSrvServiceagentStub.ESB_GYD_GYD_InquiryHasCaptchaSrvResponseE.class.equals(
                        type)) {
                return com.tcl.csot.www.esb_gyd_gyd_inquiryhascaptchasrv._1_0.ESB_GYD_GYD_InquiryHasCaptchaSrvServiceagentStub.ESB_GYD_GYD_InquiryHasCaptchaSrvResponseE.Factory.parse(param.getXMLStreamReaderWithoutCaching());
            }
        } catch (java.lang.Exception e) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }

        return null;
    }

    //http://localhost:9001/Services/ESB_GYD_GYD_InquiryHasCaptchaSrv/v1.0.0
    public static class ESB_GYD_GYD_InquiryHasCaptchaSrvRequest implements org.apache.axis2.databinding.ADBBean {
        /* This type was generated from the piece of schema that had
           name = ESB_GYD_GYD_InquiryHasCaptchaSrvRequest
           Namespace URI = http://www.csot.tcl.com/ESB_GYD_GYD_InquiryHasCaptchaSrv/1.0
           Namespace Prefix = ns2
         */

        /**
         * field for MsgHeader
         */
        protected MsgHeader localMsgHeader;

        /**
         * field for PARAMATERS
         */
        protected java.lang.String localPARAMATERS;

        /**
         * field for POST_DATA
         */
        protected java.lang.String localPOST_DATA;

        /**
         * field for RESULT_TYPE
         */
        protected java.lang.String localRESULT_TYPE;

        /**
         * field for RESERVED_1
         */
        protected java.lang.String localRESERVED_1;

        /**
         * field for RESERVED_2
         */
        protected java.lang.String localRESERVED_2;

        /**
         * field for RESERVED_3
         */
        protected java.lang.String localRESERVED_3;

        /**
         * field for RESERVED_4
         */
        protected java.lang.String localRESERVED_4;

        /**
         * field for RESERVED_5
         */
        protected java.lang.String localRESERVED_5;

        /**
         * field for RESERVED_6
         */
        protected java.lang.String localRESERVED_6;

        /**
         * field for RESERVED_7
         */
        protected java.lang.String localRESERVED_7;

        /**
         * field for RESERVED_8
         */
        protected java.lang.String localRESERVED_8;

        /**
         * field for RESERVED_9
         */
        protected java.lang.String localRESERVED_9;

        /**
         * field for RESERVED_10
         */
        protected java.lang.String localRESERVED_10;

        /**
         * Auto generated getter method
         * @return MsgHeader
         */
        public MsgHeader getMsgHeader() {
            return localMsgHeader;
        }

        /**
         * Auto generated setter method
         * @param param MsgHeader
         */
        public void setMsgHeader(MsgHeader param) {
            this.localMsgHeader = param;
        }

        /**
         * Auto generated getter method
         * @return java.lang.String
         */
        public java.lang.String getPARAMATERS() {
            return localPARAMATERS;
        }

        /**
         * Auto generated setter method
         * @param param PARAMATERS
         */
        public void setPARAMATERS(java.lang.String param) {
            this.localPARAMATERS = param;
        }

        /**
         * Auto generated getter method
         * @return java.lang.String
         */
        public java.lang.String getPOST_DATA() {
            return localPOST_DATA;
        }

        /**
         * Auto generated setter method
         * @param param POST_DATA
         */
        public void setPOST_DATA(java.lang.String param) {
            this.localPOST_DATA = param;
        }

        /**
         * Auto generated getter method
         * @return java.lang.String
         */
        public java.lang.String getRESULT_TYPE() {
            return localRESULT_TYPE;
        }

        /**
         * Auto generated setter method
         * @param param RESULT_TYPE
         */
        public void setRESULT_TYPE(java.lang.String param) {
            this.localRESULT_TYPE = param;
        }

        /**
         * Auto generated getter method
         * @return java.lang.String
         */
        public java.lang.String getRESERVED_1() {
            return localRESERVED_1;
        }

        /**
         * Auto generated setter method
         * @param param RESERVED_1
         */
        public void setRESERVED_1(java.lang.String param) {
            this.localRESERVED_1 = param;
        }

        /**
         * Auto generated getter method
         * @return java.lang.String
         */
        public java.lang.String getRESERVED_2() {
            return localRESERVED_2;
        }

        /**
         * Auto generated setter method
         * @param param RESERVED_2
         */
        public void setRESERVED_2(java.lang.String param) {
            this.localRESERVED_2 = param;
        }

        /**
         * Auto generated getter method
         * @return java.lang.String
         */
        public java.lang.String getRESERVED_3() {
            return localRESERVED_3;
        }

        /**
         * Auto generated setter method
         * @param param RESERVED_3
         */
        public void setRESERVED_3(java.lang.String param) {
            this.localRESERVED_3 = param;
        }

        /**
         * Auto generated getter method
         * @return java.lang.String
         */
        public java.lang.String getRESERVED_4() {
            return localRESERVED_4;
        }

        /**
         * Auto generated setter method
         * @param param RESERVED_4
         */
        public void setRESERVED_4(java.lang.String param) {
            this.localRESERVED_4 = param;
        }

        /**
         * Auto generated getter method
         * @return java.lang.String
         */
        public java.lang.String getRESERVED_5() {
            return localRESERVED_5;
        }

        /**
         * Auto generated setter method
         * @param param RESERVED_5
         */
        public void setRESERVED_5(java.lang.String param) {
            this.localRESERVED_5 = param;
        }

        /**
         * Auto generated getter method
         * @return java.lang.String
         */
        public java.lang.String getRESERVED_6() {
            return localRESERVED_6;
        }

        /**
         * Auto generated setter method
         * @param param RESERVED_6
         */
        public void setRESERVED_6(java.lang.String param) {
            this.localRESERVED_6 = param;
        }

        /**
         * Auto generated getter method
         * @return java.lang.String
         */
        public java.lang.String getRESERVED_7() {
            return localRESERVED_7;
        }

        /**
         * Auto generated setter method
         * @param param RESERVED_7
         */
        public void setRESERVED_7(java.lang.String param) {
            this.localRESERVED_7 = param;
        }

        /**
         * Auto generated getter method
         * @return java.lang.String
         */
        public java.lang.String getRESERVED_8() {
            return localRESERVED_8;
        }

        /**
         * Auto generated setter method
         * @param param RESERVED_8
         */
        public void setRESERVED_8(java.lang.String param) {
            this.localRESERVED_8 = param;
        }

        /**
         * Auto generated getter method
         * @return java.lang.String
         */
        public java.lang.String getRESERVED_9() {
            return localRESERVED_9;
        }

        /**
         * Auto generated setter method
         * @param param RESERVED_9
         */
        public void setRESERVED_9(java.lang.String param) {
            this.localRESERVED_9 = param;
        }

        /**
         * Auto generated getter method
         * @return java.lang.String
         */
        public java.lang.String getRESERVED_10() {
            return localRESERVED_10;
        }

        /**
         * Auto generated setter method
         * @param param RESERVED_10
         */
        public void setRESERVED_10(java.lang.String param) {
            this.localRESERVED_10 = param;
        }

        /**
         *
         * @param parentQName
         * @param factory
         * @return org.apache.axiom.om.OMElement
         */
        public org.apache.axiom.om.OMElement getOMElement(
            final javax.xml.namespace.QName parentQName,
            final org.apache.axiom.om.OMFactory factory)
            throws org.apache.axis2.databinding.ADBException {
            org.apache.axiom.om.OMDataSource dataSource = new org.apache.axis2.databinding.ADBDataSource(this,
                    parentQName);

            return factory.createOMElement(dataSource, parentQName);
        }

        public void serialize(final javax.xml.namespace.QName parentQName,
            javax.xml.stream.XMLStreamWriter xmlWriter)
            throws javax.xml.stream.XMLStreamException,
                org.apache.axis2.databinding.ADBException {
            serialize(parentQName, xmlWriter, false);
        }

        public void serialize(final javax.xml.namespace.QName parentQName,
            javax.xml.stream.XMLStreamWriter xmlWriter, boolean serializeType)
            throws javax.xml.stream.XMLStreamException,
                org.apache.axis2.databinding.ADBException {
            java.lang.String prefix = null;
            java.lang.String namespace = null;

            prefix = parentQName.getPrefix();
            namespace = parentQName.getNamespaceURI();
            writeStartElement(prefix, namespace, parentQName.getLocalPart(),
                xmlWriter);

            if (serializeType) {
                java.lang.String namespacePrefix = registerPrefix(xmlWriter,
                        "http://www.csot.tcl.com/ESB_GYD_GYD_InquiryHasCaptchaSrv/1.0");

                if ((namespacePrefix != null) &&
                        (namespacePrefix.trim().length() > 0)) {
                    writeAttribute("xsi",
                        "http://www.w3.org/2001/XMLSchema-instance", "type",
                        namespacePrefix +
                        ":ESB_GYD_GYD_InquiryHasCaptchaSrvRequest", xmlWriter);
                } else {
                    writeAttribute("xsi",
                        "http://www.w3.org/2001/XMLSchema-instance", "type",
                        "ESB_GYD_GYD_InquiryHasCaptchaSrvRequest", xmlWriter);
                }
            }

            if (localMsgHeader == null) {
                throw new org.apache.axis2.databinding.ADBException(
                    "MsgHeader cannot be null!!");
            }

            localMsgHeader.serialize(new javax.xml.namespace.QName(
                    "http://www.csot.tcl.com/ESB_GYD_GYD_InquiryHasCaptchaSrv/1.0",
                    "MsgHeader"), xmlWriter);

            namespace = "http://www.csot.tcl.com/ESB_GYD_GYD_InquiryHasCaptchaSrv/1.0";
            writeStartElement(null, namespace, "PARAMATERS", xmlWriter);

            if (localPARAMATERS == null) {
                // write the nil attribute
                writeAttribute("xsi",
                    "http://www.w3.org/2001/XMLSchema-instance", "nil", "1",
                    xmlWriter);
            } else {
                xmlWriter.writeCharacters(localPARAMATERS);
            }

            xmlWriter.writeEndElement();

            namespace = "http://www.csot.tcl.com/ESB_GYD_GYD_InquiryHasCaptchaSrv/1.0";
            writeStartElement(null, namespace, "POST_DATA", xmlWriter);

            if (localPOST_DATA == null) {
                // write the nil attribute
                writeAttribute("xsi",
                    "http://www.w3.org/2001/XMLSchema-instance", "nil", "1",
                    xmlWriter);
            } else {
                xmlWriter.writeCharacters(localPOST_DATA);
            }

            xmlWriter.writeEndElement();

            namespace = "http://www.csot.tcl.com/ESB_GYD_GYD_InquiryHasCaptchaSrv/1.0";
            writeStartElement(null, namespace, "RESULT_TYPE", xmlWriter);

            if (localRESULT_TYPE == null) {
                // write the nil attribute
                writeAttribute("xsi",
                    "http://www.w3.org/2001/XMLSchema-instance", "nil", "1",
                    xmlWriter);
            } else {
                xmlWriter.writeCharacters(localRESULT_TYPE);
            }

            xmlWriter.writeEndElement();

            namespace = "http://www.csot.tcl.com/ESB_GYD_GYD_InquiryHasCaptchaSrv/1.0";
            writeStartElement(null, namespace, "RESERVED_1", xmlWriter);

            if (localRESERVED_1 == null) {
                // write the nil attribute
                writeAttribute("xsi",
                    "http://www.w3.org/2001/XMLSchema-instance", "nil", "1",
                    xmlWriter);
            } else {
                xmlWriter.writeCharacters(localRESERVED_1);
            }

            xmlWriter.writeEndElement();

            namespace = "http://www.csot.tcl.com/ESB_GYD_GYD_InquiryHasCaptchaSrv/1.0";
            writeStartElement(null, namespace, "RESERVED_2", xmlWriter);

            if (localRESERVED_2 == null) {
                // write the nil attribute
                writeAttribute("xsi",
                    "http://www.w3.org/2001/XMLSchema-instance", "nil", "1",
                    xmlWriter);
            } else {
                xmlWriter.writeCharacters(localRESERVED_2);
            }

            xmlWriter.writeEndElement();

            namespace = "http://www.csot.tcl.com/ESB_GYD_GYD_InquiryHasCaptchaSrv/1.0";
            writeStartElement(null, namespace, "RESERVED_3", xmlWriter);

            if (localRESERVED_3 == null) {
                // write the nil attribute
                writeAttribute("xsi",
                    "http://www.w3.org/2001/XMLSchema-instance", "nil", "1",
                    xmlWriter);
            } else {
                xmlWriter.writeCharacters(localRESERVED_3);
            }

            xmlWriter.writeEndElement();

            namespace = "http://www.csot.tcl.com/ESB_GYD_GYD_InquiryHasCaptchaSrv/1.0";
            writeStartElement(null, namespace, "RESERVED_4", xmlWriter);

            if (localRESERVED_4 == null) {
                // write the nil attribute
                writeAttribute("xsi",
                    "http://www.w3.org/2001/XMLSchema-instance", "nil", "1",
                    xmlWriter);
            } else {
                xmlWriter.writeCharacters(localRESERVED_4);
            }

            xmlWriter.writeEndElement();

            namespace = "http://www.csot.tcl.com/ESB_GYD_GYD_InquiryHasCaptchaSrv/1.0";
            writeStartElement(null, namespace, "RESERVED_5", xmlWriter);

            if (localRESERVED_5 == null) {
                // write the nil attribute
                writeAttribute("xsi",
                    "http://www.w3.org/2001/XMLSchema-instance", "nil", "1",
                    xmlWriter);
            } else {
                xmlWriter.writeCharacters(localRESERVED_5);
            }

            xmlWriter.writeEndElement();

            namespace = "http://www.csot.tcl.com/ESB_GYD_GYD_InquiryHasCaptchaSrv/1.0";
            writeStartElement(null, namespace, "RESERVED_6", xmlWriter);

            if (localRESERVED_6 == null) {
                // write the nil attribute
                writeAttribute("xsi",
                    "http://www.w3.org/2001/XMLSchema-instance", "nil", "1",
                    xmlWriter);
            } else {
                xmlWriter.writeCharacters(localRESERVED_6);
            }

            xmlWriter.writeEndElement();

            namespace = "http://www.csot.tcl.com/ESB_GYD_GYD_InquiryHasCaptchaSrv/1.0";
            writeStartElement(null, namespace, "RESERVED_7", xmlWriter);

            if (localRESERVED_7 == null) {
                // write the nil attribute
                writeAttribute("xsi",
                    "http://www.w3.org/2001/XMLSchema-instance", "nil", "1",
                    xmlWriter);
            } else {
                xmlWriter.writeCharacters(localRESERVED_7);
            }

            xmlWriter.writeEndElement();

            namespace = "http://www.csot.tcl.com/ESB_GYD_GYD_InquiryHasCaptchaSrv/1.0";
            writeStartElement(null, namespace, "RESERVED_8", xmlWriter);

            if (localRESERVED_8 == null) {
                // write the nil attribute
                writeAttribute("xsi",
                    "http://www.w3.org/2001/XMLSchema-instance", "nil", "1",
                    xmlWriter);
            } else {
                xmlWriter.writeCharacters(localRESERVED_8);
            }

            xmlWriter.writeEndElement();

            namespace = "http://www.csot.tcl.com/ESB_GYD_GYD_InquiryHasCaptchaSrv/1.0";
            writeStartElement(null, namespace, "RESERVED_9", xmlWriter);

            if (localRESERVED_9 == null) {
                // write the nil attribute
                writeAttribute("xsi",
                    "http://www.w3.org/2001/XMLSchema-instance", "nil", "1",
                    xmlWriter);
            } else {
                xmlWriter.writeCharacters(localRESERVED_9);
            }

            xmlWriter.writeEndElement();

            namespace = "http://www.csot.tcl.com/ESB_GYD_GYD_InquiryHasCaptchaSrv/1.0";
            writeStartElement(null, namespace, "RESERVED_10", xmlWriter);

            if (localRESERVED_10 == null) {
                // write the nil attribute
                writeAttribute("xsi",
                    "http://www.w3.org/2001/XMLSchema-instance", "nil", "1",
                    xmlWriter);
            } else {
                xmlWriter.writeCharacters(localRESERVED_10);
            }

            xmlWriter.writeEndElement();

            xmlWriter.writeEndElement();
        }

        private static java.lang.String generatePrefix(
            java.lang.String namespace) {
            if (namespace.equals(
                        "http://www.csot.tcl.com/ESB_GYD_GYD_InquiryHasCaptchaSrv/1.0")) {
                return "ns2";
            }

            return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
        }

        /**
         * Utility method to write an element start tag.
         */
        private void writeStartElement(java.lang.String prefix,
            java.lang.String namespace, java.lang.String localPart,
            javax.xml.stream.XMLStreamWriter xmlWriter)
            throws javax.xml.stream.XMLStreamException {
            java.lang.String writerPrefix = xmlWriter.getPrefix(namespace);

            if (writerPrefix != null) {
                xmlWriter.writeStartElement(namespace, localPart);
            } else {
                if (namespace.length() == 0) {
                    prefix = "";
                } else if (prefix == null) {
                    prefix = generatePrefix(namespace);
                }

                xmlWriter.writeStartElement(prefix, localPart, namespace);
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }
        }

        /**
         * Util method to write an attribute with the ns prefix
         */
        private void writeAttribute(java.lang.String prefix,
            java.lang.String namespace, java.lang.String attName,
            java.lang.String attValue,
            javax.xml.stream.XMLStreamWriter xmlWriter)
            throws javax.xml.stream.XMLStreamException {
            if (xmlWriter.getPrefix(namespace) == null) {
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }

            xmlWriter.writeAttribute(namespace, attName, attValue);
        }

        /**
         * Util method to write an attribute without the ns prefix
         */
        private void writeAttribute(java.lang.String namespace,
            java.lang.String attName, java.lang.String attValue,
            javax.xml.stream.XMLStreamWriter xmlWriter)
            throws javax.xml.stream.XMLStreamException {
            if (namespace.equals("")) {
                xmlWriter.writeAttribute(attName, attValue);
            } else {
                registerPrefix(xmlWriter, namespace);
                xmlWriter.writeAttribute(namespace, attName, attValue);
            }
        }

        /**
         * Util method to write an attribute without the ns prefix
         */
        private void writeQNameAttribute(java.lang.String namespace,
            java.lang.String attName, javax.xml.namespace.QName qname,
            javax.xml.stream.XMLStreamWriter xmlWriter)
            throws javax.xml.stream.XMLStreamException {
            java.lang.String attributeNamespace = qname.getNamespaceURI();
            java.lang.String attributePrefix = xmlWriter.getPrefix(attributeNamespace);

            if (attributePrefix == null) {
                attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
            }

            java.lang.String attributeValue;

            if (attributePrefix.trim().length() > 0) {
                attributeValue = attributePrefix + ":" + qname.getLocalPart();
            } else {
                attributeValue = qname.getLocalPart();
            }

            if (namespace.equals("")) {
                xmlWriter.writeAttribute(attName, attributeValue);
            } else {
                registerPrefix(xmlWriter, namespace);
                xmlWriter.writeAttribute(namespace, attName, attributeValue);
            }
        }

        /**
         *  method to handle Qnames
         */
        private void writeQName(javax.xml.namespace.QName qname,
            javax.xml.stream.XMLStreamWriter xmlWriter)
            throws javax.xml.stream.XMLStreamException {
            java.lang.String namespaceURI = qname.getNamespaceURI();

            if (namespaceURI != null) {
                java.lang.String prefix = xmlWriter.getPrefix(namespaceURI);

                if (prefix == null) {
                    prefix = generatePrefix(namespaceURI);
                    xmlWriter.writeNamespace(prefix, namespaceURI);
                    xmlWriter.setPrefix(prefix, namespaceURI);
                }

                if (prefix.trim().length() > 0) {
                    xmlWriter.writeCharacters(prefix + ":" +
                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                            qname));
                } else {
                    // i.e this is the default namespace
                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                            qname));
                }
            } else {
                xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                        qname));
            }
        }

        private void writeQNames(javax.xml.namespace.QName[] qnames,
            javax.xml.stream.XMLStreamWriter xmlWriter)
            throws javax.xml.stream.XMLStreamException {
            if (qnames != null) {
                // we have to store this data until last moment since it is not possible to write any
                // namespace data after writing the charactor data
                java.lang.StringBuffer stringToWrite = new java.lang.StringBuffer();
                java.lang.String namespaceURI = null;
                java.lang.String prefix = null;

                for (int i = 0; i < qnames.length; i++) {
                    if (i > 0) {
                        stringToWrite.append(" ");
                    }

                    namespaceURI = qnames[i].getNamespaceURI();

                    if (namespaceURI != null) {
                        prefix = xmlWriter.getPrefix(namespaceURI);

                        if ((prefix == null) || (prefix.length() == 0)) {
                            prefix = generatePrefix(namespaceURI);
                            xmlWriter.writeNamespace(prefix, namespaceURI);
                            xmlWriter.setPrefix(prefix, namespaceURI);
                        }

                        if (prefix.trim().length() > 0) {
                            stringToWrite.append(prefix).append(":")
                                         .append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                                    qnames[i]));
                        } else {
                            stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                                    qnames[i]));
                        }
                    } else {
                        stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                                qnames[i]));
                    }
                }

                xmlWriter.writeCharacters(stringToWrite.toString());
            }
        }

        /**
         * Register a namespace prefix
         */
        private java.lang.String registerPrefix(
            javax.xml.stream.XMLStreamWriter xmlWriter,
            java.lang.String namespace)
            throws javax.xml.stream.XMLStreamException {
            java.lang.String prefix = xmlWriter.getPrefix(namespace);

            if (prefix == null) {
                prefix = generatePrefix(namespace);

                javax.xml.namespace.NamespaceContext nsContext = xmlWriter.getNamespaceContext();

                while (true) {
                    java.lang.String uri = nsContext.getNamespaceURI(prefix);

                    if ((uri == null) || (uri.length() == 0)) {
                        break;
                    }

                    prefix = org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
                }

                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }

            return prefix;
        }

        /**
         * databinding method to get an XML representation of this object
         *
         */
        public javax.xml.stream.XMLStreamReader getPullParser(
            javax.xml.namespace.QName qName)
            throws org.apache.axis2.databinding.ADBException {
            java.util.ArrayList elementList = new java.util.ArrayList();
            java.util.ArrayList attribList = new java.util.ArrayList();

            elementList.add(new javax.xml.namespace.QName(
                    "http://www.csot.tcl.com/ESB_GYD_GYD_InquiryHasCaptchaSrv/1.0",
                    "MsgHeader"));

            if (localMsgHeader == null) {
                throw new org.apache.axis2.databinding.ADBException(
                    "MsgHeader cannot be null!!");
            }

            elementList.add(localMsgHeader);

            elementList.add(new javax.xml.namespace.QName(
                    "http://www.csot.tcl.com/ESB_GYD_GYD_InquiryHasCaptchaSrv/1.0",
                    "PARAMATERS"));

            elementList.add((localPARAMATERS == null) ? null
                                                      : org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                    localPARAMATERS));

            elementList.add(new javax.xml.namespace.QName(
                    "http://www.csot.tcl.com/ESB_GYD_GYD_InquiryHasCaptchaSrv/1.0",
                    "POST_DATA"));

            elementList.add((localPOST_DATA == null) ? null
                                                     : org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                    localPOST_DATA));

            elementList.add(new javax.xml.namespace.QName(
                    "http://www.csot.tcl.com/ESB_GYD_GYD_InquiryHasCaptchaSrv/1.0",
                    "RESULT_TYPE"));

            elementList.add((localRESULT_TYPE == null) ? null
                                                       : org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                    localRESULT_TYPE));

            elementList.add(new javax.xml.namespace.QName(
                    "http://www.csot.tcl.com/ESB_GYD_GYD_InquiryHasCaptchaSrv/1.0",
                    "RESERVED_1"));

            elementList.add((localRESERVED_1 == null) ? null
                                                      : org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                    localRESERVED_1));

            elementList.add(new javax.xml.namespace.QName(
                    "http://www.csot.tcl.com/ESB_GYD_GYD_InquiryHasCaptchaSrv/1.0",
                    "RESERVED_2"));

            elementList.add((localRESERVED_2 == null) ? null
                                                      : org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                    localRESERVED_2));

            elementList.add(new javax.xml.namespace.QName(
                    "http://www.csot.tcl.com/ESB_GYD_GYD_InquiryHasCaptchaSrv/1.0",
                    "RESERVED_3"));

            elementList.add((localRESERVED_3 == null) ? null
                                                      : org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                    localRESERVED_3));

            elementList.add(new javax.xml.namespace.QName(
                    "http://www.csot.tcl.com/ESB_GYD_GYD_InquiryHasCaptchaSrv/1.0",
                    "RESERVED_4"));

            elementList.add((localRESERVED_4 == null) ? null
                                                      : org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                    localRESERVED_4));

            elementList.add(new javax.xml.namespace.QName(
                    "http://www.csot.tcl.com/ESB_GYD_GYD_InquiryHasCaptchaSrv/1.0",
                    "RESERVED_5"));

            elementList.add((localRESERVED_5 == null) ? null
                                                      : org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                    localRESERVED_5));

            elementList.add(new javax.xml.namespace.QName(
                    "http://www.csot.tcl.com/ESB_GYD_GYD_InquiryHasCaptchaSrv/1.0",
                    "RESERVED_6"));

            elementList.add((localRESERVED_6 == null) ? null
                                                      : org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                    localRESERVED_6));

            elementList.add(new javax.xml.namespace.QName(
                    "http://www.csot.tcl.com/ESB_GYD_GYD_InquiryHasCaptchaSrv/1.0",
                    "RESERVED_7"));

            elementList.add((localRESERVED_7 == null) ? null
                                                      : org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                    localRESERVED_7));

            elementList.add(new javax.xml.namespace.QName(
                    "http://www.csot.tcl.com/ESB_GYD_GYD_InquiryHasCaptchaSrv/1.0",
                    "RESERVED_8"));

            elementList.add((localRESERVED_8 == null) ? null
                                                      : org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                    localRESERVED_8));

            elementList.add(new javax.xml.namespace.QName(
                    "http://www.csot.tcl.com/ESB_GYD_GYD_InquiryHasCaptchaSrv/1.0",
                    "RESERVED_9"));

            elementList.add((localRESERVED_9 == null) ? null
                                                      : org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                    localRESERVED_9));

            elementList.add(new javax.xml.namespace.QName(
                    "http://www.csot.tcl.com/ESB_GYD_GYD_InquiryHasCaptchaSrv/1.0",
                    "RESERVED_10"));

            elementList.add((localRESERVED_10 == null) ? null
                                                       : org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                    localRESERVED_10));

            return new org.apache.axis2.databinding.utils.reader.ADBXMLStreamReaderImpl(qName,
                elementList.toArray(), attribList.toArray());
        }

        /**
         *  Factory class that keeps the parse method
         */
        public static class Factory {
            /**
             * static method to create the object
             * Precondition:  If this object is an element, the current or next start element starts this object and any intervening reader events are ignorable
             *                If this object is not an element, it is a complex type and the reader is at the event just after the outer start element
             * Postcondition: If this object is an element, the reader is positioned at its end element
             *                If this object is a complex type, the reader is positioned at the end element of its outer element
             */
            public static ESB_GYD_GYD_InquiryHasCaptchaSrvRequest parse(
                javax.xml.stream.XMLStreamReader reader)
                throws java.lang.Exception {
                ESB_GYD_GYD_InquiryHasCaptchaSrvRequest object = new ESB_GYD_GYD_InquiryHasCaptchaSrvRequest();

                int event;
                java.lang.String nillableValue = null;
                java.lang.String prefix = "";
                java.lang.String namespaceuri = "";

                try {
                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();

                    if (reader.getAttributeValue(
                                "http://www.w3.org/2001/XMLSchema-instance",
                                "type") != null) {
                        java.lang.String fullTypeName = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                                "type");

                        if (fullTypeName != null) {
                            java.lang.String nsPrefix = null;

                            if (fullTypeName.indexOf(":") > -1) {
                                nsPrefix = fullTypeName.substring(0,
                                        fullTypeName.indexOf(":"));
                            }

                            nsPrefix = (nsPrefix == null) ? "" : nsPrefix;

                            java.lang.String type = fullTypeName.substring(fullTypeName.indexOf(
                                        ":") + 1);

                            if (!"ESB_GYD_GYD_InquiryHasCaptchaSrvRequest".equals(
                                        type)) {
                                //find namespace for the prefix
                                java.lang.String nsUri = reader.getNamespaceContext()
                                                               .getNamespaceURI(nsPrefix);

                                return (ESB_GYD_GYD_InquiryHasCaptchaSrvRequest) ExtensionMapper.getTypeObject(nsUri,
                                    type, reader);
                            }
                        }
                    }

                    // Note all attributes that were handled. Used to differ normal attributes
                    // from anyAttributes.
                    java.util.Vector handledAttributes = new java.util.Vector();

                    reader.next();

                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();

                    if (reader.isStartElement() &&
                            new javax.xml.namespace.QName(
                                "http://www.csot.tcl.com/ESB_GYD_GYD_InquiryHasCaptchaSrv/1.0",
                                "MsgHeader").equals(reader.getName())) {
                        object.setMsgHeader(MsgHeader.Factory.parse(reader));

                        reader.next();
                    } // End of if for expected property start element

                    else {
                        // A start element we are not expecting indicates an invalid parameter was passed
                        throw new org.apache.axis2.databinding.ADBException(
                            "Unexpected subelement " + reader.getName());
                    }

                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();

                    if (reader.isStartElement() &&
                            new javax.xml.namespace.QName(
                                "http://www.csot.tcl.com/ESB_GYD_GYD_InquiryHasCaptchaSrv/1.0",
                                "PARAMATERS").equals(reader.getName())) {
                        nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                                "nil");

                        if (!"true".equals(nillableValue) &&
                                !"1".equals(nillableValue)) {
                            java.lang.String content = reader.getElementText();

                            object.setPARAMATERS(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                                    content));
                        } else {
                            reader.getElementText(); // throw away text nodes if any.
                        }

                        reader.next();
                    } // End of if for expected property start element

                    else {
                        // A start element we are not expecting indicates an invalid parameter was passed
                        throw new org.apache.axis2.databinding.ADBException(
                            "Unexpected subelement " + reader.getName());
                    }

                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();

                    if (reader.isStartElement() &&
                            new javax.xml.namespace.QName(
                                "http://www.csot.tcl.com/ESB_GYD_GYD_InquiryHasCaptchaSrv/1.0",
                                "POST_DATA").equals(reader.getName())) {
                        nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                                "nil");

                        if (!"true".equals(nillableValue) &&
                                !"1".equals(nillableValue)) {
                            java.lang.String content = reader.getElementText();

                            object.setPOST_DATA(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                                    content));
                        } else {
                            reader.getElementText(); // throw away text nodes if any.
                        }

                        reader.next();
                    } // End of if for expected property start element

                    else {
                        // A start element we are not expecting indicates an invalid parameter was passed
                        throw new org.apache.axis2.databinding.ADBException(
                            "Unexpected subelement " + reader.getName());
                    }

                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();

                    if (reader.isStartElement() &&
                            new javax.xml.namespace.QName(
                                "http://www.csot.tcl.com/ESB_GYD_GYD_InquiryHasCaptchaSrv/1.0",
                                "RESULT_TYPE").equals(reader.getName())) {
                        nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                                "nil");

                        if (!"true".equals(nillableValue) &&
                                !"1".equals(nillableValue)) {
                            java.lang.String content = reader.getElementText();

                            object.setRESULT_TYPE(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                                    content));
                        } else {
                            reader.getElementText(); // throw away text nodes if any.
                        }

                        reader.next();
                    } // End of if for expected property start element

                    else {
                        // A start element we are not expecting indicates an invalid parameter was passed
                        throw new org.apache.axis2.databinding.ADBException(
                            "Unexpected subelement " + reader.getName());
                    }

                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();

                    if (reader.isStartElement() &&
                            new javax.xml.namespace.QName(
                                "http://www.csot.tcl.com/ESB_GYD_GYD_InquiryHasCaptchaSrv/1.0",
                                "RESERVED_1").equals(reader.getName())) {
                        nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                                "nil");

                        if (!"true".equals(nillableValue) &&
                                !"1".equals(nillableValue)) {
                            java.lang.String content = reader.getElementText();

                            object.setRESERVED_1(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                                    content));
                        } else {
                            reader.getElementText(); // throw away text nodes if any.
                        }

                        reader.next();
                    } // End of if for expected property start element

                    else {
                        // A start element we are not expecting indicates an invalid parameter was passed
                        throw new org.apache.axis2.databinding.ADBException(
                            "Unexpected subelement " + reader.getName());
                    }

                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();

                    if (reader.isStartElement() &&
                            new javax.xml.namespace.QName(
                                "http://www.csot.tcl.com/ESB_GYD_GYD_InquiryHasCaptchaSrv/1.0",
                                "RESERVED_2").equals(reader.getName())) {
                        nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                                "nil");

                        if (!"true".equals(nillableValue) &&
                                !"1".equals(nillableValue)) {
                            java.lang.String content = reader.getElementText();

                            object.setRESERVED_2(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                                    content));
                        } else {
                            reader.getElementText(); // throw away text nodes if any.
                        }

                        reader.next();
                    } // End of if for expected property start element

                    else {
                        // A start element we are not expecting indicates an invalid parameter was passed
                        throw new org.apache.axis2.databinding.ADBException(
                            "Unexpected subelement " + reader.getName());
                    }

                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();

                    if (reader.isStartElement() &&
                            new javax.xml.namespace.QName(
                                "http://www.csot.tcl.com/ESB_GYD_GYD_InquiryHasCaptchaSrv/1.0",
                                "RESERVED_3").equals(reader.getName())) {
                        nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                                "nil");

                        if (!"true".equals(nillableValue) &&
                                !"1".equals(nillableValue)) {
                            java.lang.String content = reader.getElementText();

                            object.setRESERVED_3(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                                    content));
                        } else {
                            reader.getElementText(); // throw away text nodes if any.
                        }

                        reader.next();
                    } // End of if for expected property start element

                    else {
                        // A start element we are not expecting indicates an invalid parameter was passed
                        throw new org.apache.axis2.databinding.ADBException(
                            "Unexpected subelement " + reader.getName());
                    }

                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();

                    if (reader.isStartElement() &&
                            new javax.xml.namespace.QName(
                                "http://www.csot.tcl.com/ESB_GYD_GYD_InquiryHasCaptchaSrv/1.0",
                                "RESERVED_4").equals(reader.getName())) {
                        nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                                "nil");

                        if (!"true".equals(nillableValue) &&
                                !"1".equals(nillableValue)) {
                            java.lang.String content = reader.getElementText();

                            object.setRESERVED_4(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                                    content));
                        } else {
                            reader.getElementText(); // throw away text nodes if any.
                        }

                        reader.next();
                    } // End of if for expected property start element

                    else {
                        // A start element we are not expecting indicates an invalid parameter was passed
                        throw new org.apache.axis2.databinding.ADBException(
                            "Unexpected subelement " + reader.getName());
                    }

                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();

                    if (reader.isStartElement() &&
                            new javax.xml.namespace.QName(
                                "http://www.csot.tcl.com/ESB_GYD_GYD_InquiryHasCaptchaSrv/1.0",
                                "RESERVED_5").equals(reader.getName())) {
                        nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                                "nil");

                        if (!"true".equals(nillableValue) &&
                                !"1".equals(nillableValue)) {
                            java.lang.String content = reader.getElementText();

                            object.setRESERVED_5(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                                    content));
                        } else {
                            reader.getElementText(); // throw away text nodes if any.
                        }

                        reader.next();
                    } // End of if for expected property start element

                    else {
                        // A start element we are not expecting indicates an invalid parameter was passed
                        throw new org.apache.axis2.databinding.ADBException(
                            "Unexpected subelement " + reader.getName());
                    }

                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();

                    if (reader.isStartElement() &&
                            new javax.xml.namespace.QName(
                                "http://www.csot.tcl.com/ESB_GYD_GYD_InquiryHasCaptchaSrv/1.0",
                                "RESERVED_6").equals(reader.getName())) {
                        nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                                "nil");

                        if (!"true".equals(nillableValue) &&
                                !"1".equals(nillableValue)) {
                            java.lang.String content = reader.getElementText();

                            object.setRESERVED_6(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                                    content));
                        } else {
                            reader.getElementText(); // throw away text nodes if any.
                        }

                        reader.next();
                    } // End of if for expected property start element

                    else {
                        // A start element we are not expecting indicates an invalid parameter was passed
                        throw new org.apache.axis2.databinding.ADBException(
                            "Unexpected subelement " + reader.getName());
                    }

                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();

                    if (reader.isStartElement() &&
                            new javax.xml.namespace.QName(
                                "http://www.csot.tcl.com/ESB_GYD_GYD_InquiryHasCaptchaSrv/1.0",
                                "RESERVED_7").equals(reader.getName())) {
                        nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                                "nil");

                        if (!"true".equals(nillableValue) &&
                                !"1".equals(nillableValue)) {
                            java.lang.String content = reader.getElementText();

                            object.setRESERVED_7(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                                    content));
                        } else {
                            reader.getElementText(); // throw away text nodes if any.
                        }

                        reader.next();
                    } // End of if for expected property start element

                    else {
                        // A start element we are not expecting indicates an invalid parameter was passed
                        throw new org.apache.axis2.databinding.ADBException(
                            "Unexpected subelement " + reader.getName());
                    }

                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();

                    if (reader.isStartElement() &&
                            new javax.xml.namespace.QName(
                                "http://www.csot.tcl.com/ESB_GYD_GYD_InquiryHasCaptchaSrv/1.0",
                                "RESERVED_8").equals(reader.getName())) {
                        nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                                "nil");

                        if (!"true".equals(nillableValue) &&
                                !"1".equals(nillableValue)) {
                            java.lang.String content = reader.getElementText();

                            object.setRESERVED_8(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                                    content));
                        } else {
                            reader.getElementText(); // throw away text nodes if any.
                        }

                        reader.next();
                    } // End of if for expected property start element

                    else {
                        // A start element we are not expecting indicates an invalid parameter was passed
                        throw new org.apache.axis2.databinding.ADBException(
                            "Unexpected subelement " + reader.getName());
                    }

                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();

                    if (reader.isStartElement() &&
                            new javax.xml.namespace.QName(
                                "http://www.csot.tcl.com/ESB_GYD_GYD_InquiryHasCaptchaSrv/1.0",
                                "RESERVED_9").equals(reader.getName())) {
                        nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                                "nil");

                        if (!"true".equals(nillableValue) &&
                                !"1".equals(nillableValue)) {
                            java.lang.String content = reader.getElementText();

                            object.setRESERVED_9(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                                    content));
                        } else {
                            reader.getElementText(); // throw away text nodes if any.
                        }

                        reader.next();
                    } // End of if for expected property start element

                    else {
                        // A start element we are not expecting indicates an invalid parameter was passed
                        throw new org.apache.axis2.databinding.ADBException(
                            "Unexpected subelement " + reader.getName());
                    }

                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();

                    if (reader.isStartElement() &&
                            new javax.xml.namespace.QName(
                                "http://www.csot.tcl.com/ESB_GYD_GYD_InquiryHasCaptchaSrv/1.0",
                                "RESERVED_10").equals(reader.getName())) {
                        nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                                "nil");

                        if (!"true".equals(nillableValue) &&
                                !"1".equals(nillableValue)) {
                            java.lang.String content = reader.getElementText();

                            object.setRESERVED_10(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                                    content));
                        } else {
                            reader.getElementText(); // throw away text nodes if any.
                        }

                        reader.next();
                    } // End of if for expected property start element

                    else {
                        // A start element we are not expecting indicates an invalid parameter was passed
                        throw new org.apache.axis2.databinding.ADBException(
                            "Unexpected subelement " + reader.getName());
                    }

                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();

                    if (reader.isStartElement()) {
                        // A start element we are not expecting indicates a trailing invalid property
                        throw new org.apache.axis2.databinding.ADBException(
                            "Unexpected subelement " + reader.getName());
                    }
                } catch (javax.xml.stream.XMLStreamException e) {
                    throw new java.lang.Exception(e);
                }

                return object;
            }
        } //end of factory class
    }

    public static class MsgHeader implements org.apache.axis2.databinding.ADBBean {
        /* This type was generated from the piece of schema that had
           name = MsgHeader
           Namespace URI = http://www.csot.tcl.com/MsgHeader/1.0
           Namespace Prefix = ns1
         */

        /**
         * field for APP_ID
         */
        protected java.lang.String localAPP_ID;

        /**
         * field for APP_NAME
         */
        protected java.lang.String localAPP_NAME;

        /**
         * field for MOD_ID
         */
        protected java.lang.String localMOD_ID;

        /**
         * field for MOD_NAME
         */
        protected java.lang.String localMOD_NAME;

        /**
         * field for TOKEN
         */
        protected java.lang.String localTOKEN;

        /**
         * field for USERID
         */
        protected java.math.BigDecimal localUSERID;

        /**
         * field for USERNAME
         */
        protected java.lang.String localUSERNAME;

        /**
         * field for SUBMITDATE
         */
        protected java.util.Calendar localSUBMITDATE;

        /**
         * field for PAGE_SIZE
         */
        protected java.math.BigDecimal localPAGE_SIZE;

        /**
         * field for CURRENT_PAGE
         */
        protected java.math.BigDecimal localCURRENT_PAGE;

        /**
         * field for TOTAL_RECORD
         */
        protected java.math.BigDecimal localTOTAL_RECORD;

        /**
         * field for ROUTE_CODE1
         */
        protected java.lang.String localROUTE_CODE1;

        /**
         * field for ROUTE_CODE2
         */
        protected java.lang.String localROUTE_CODE2;

        /**
         * Auto generated getter method
         * @return java.lang.String
         */
        public java.lang.String getAPP_ID() {
            return localAPP_ID;
        }

        /**
         * Auto generated setter method
         * @param param APP_ID
         */
        public void setAPP_ID(java.lang.String param) {
            this.localAPP_ID = param;
        }

        /**
         * Auto generated getter method
         * @return java.lang.String
         */
        public java.lang.String getAPP_NAME() {
            return localAPP_NAME;
        }

        /**
         * Auto generated setter method
         * @param param APP_NAME
         */
        public void setAPP_NAME(java.lang.String param) {
            this.localAPP_NAME = param;
        }

        /**
         * Auto generated getter method
         * @return java.lang.String
         */
        public java.lang.String getMOD_ID() {
            return localMOD_ID;
        }

        /**
         * Auto generated setter method
         * @param param MOD_ID
         */
        public void setMOD_ID(java.lang.String param) {
            this.localMOD_ID = param;
        }

        /**
         * Auto generated getter method
         * @return java.lang.String
         */
        public java.lang.String getMOD_NAME() {
            return localMOD_NAME;
        }

        /**
         * Auto generated setter method
         * @param param MOD_NAME
         */
        public void setMOD_NAME(java.lang.String param) {
            this.localMOD_NAME = param;
        }

        /**
         * Auto generated getter method
         * @return java.lang.String
         */
        public java.lang.String getTOKEN() {
            return localTOKEN;
        }

        /**
         * Auto generated setter method
         * @param param TOKEN
         */
        public void setTOKEN(java.lang.String param) {
            this.localTOKEN = param;
        }

        /**
         * Auto generated getter method
         * @return java.math.BigDecimal
         */
        public java.math.BigDecimal getUSERID() {
            return localUSERID;
        }

        /**
         * Auto generated setter method
         * @param param USERID
         */
        public void setUSERID(java.math.BigDecimal param) {
            this.localUSERID = param;
        }

        /**
         * Auto generated getter method
         * @return java.lang.String
         */
        public java.lang.String getUSERNAME() {
            return localUSERNAME;
        }

        /**
         * Auto generated setter method
         * @param param USERNAME
         */
        public void setUSERNAME(java.lang.String param) {
            this.localUSERNAME = param;
        }

        /**
         * Auto generated getter method
         * @return java.util.Calendar
         */
        public java.util.Calendar getSUBMITDATE() {
            return localSUBMITDATE;
        }

        /**
         * Auto generated setter method
         * @param param SUBMITDATE
         */
        public void setSUBMITDATE(java.util.Calendar param) {
            this.localSUBMITDATE = param;
        }

        /**
         * Auto generated getter method
         * @return java.math.BigDecimal
         */
        public java.math.BigDecimal getPAGE_SIZE() {
            return localPAGE_SIZE;
        }

        /**
         * Auto generated setter method
         * @param param PAGE_SIZE
         */
        public void setPAGE_SIZE(java.math.BigDecimal param) {
            this.localPAGE_SIZE = param;
        }

        /**
         * Auto generated getter method
         * @return java.math.BigDecimal
         */
        public java.math.BigDecimal getCURRENT_PAGE() {
            return localCURRENT_PAGE;
        }

        /**
         * Auto generated setter method
         * @param param CURRENT_PAGE
         */
        public void setCURRENT_PAGE(java.math.BigDecimal param) {
            this.localCURRENT_PAGE = param;
        }

        /**
         * Auto generated getter method
         * @return java.math.BigDecimal
         */
        public java.math.BigDecimal getTOTAL_RECORD() {
            return localTOTAL_RECORD;
        }

        /**
         * Auto generated setter method
         * @param param TOTAL_RECORD
         */
        public void setTOTAL_RECORD(java.math.BigDecimal param) {
            this.localTOTAL_RECORD = param;
        }

        /**
         * Auto generated getter method
         * @return java.lang.String
         */
        public java.lang.String getROUTE_CODE1() {
            return localROUTE_CODE1;
        }

        /**
         * Auto generated setter method
         * @param param ROUTE_CODE1
         */
        public void setROUTE_CODE1(java.lang.String param) {
            this.localROUTE_CODE1 = param;
        }

        /**
         * Auto generated getter method
         * @return java.lang.String
         */
        public java.lang.String getROUTE_CODE2() {
            return localROUTE_CODE2;
        }

        /**
         * Auto generated setter method
         * @param param ROUTE_CODE2
         */
        public void setROUTE_CODE2(java.lang.String param) {
            this.localROUTE_CODE2 = param;
        }

        /**
         *
         * @param parentQName
         * @param factory
         * @return org.apache.axiom.om.OMElement
         */
        public org.apache.axiom.om.OMElement getOMElement(
            final javax.xml.namespace.QName parentQName,
            final org.apache.axiom.om.OMFactory factory)
            throws org.apache.axis2.databinding.ADBException {
            org.apache.axiom.om.OMDataSource dataSource = new org.apache.axis2.databinding.ADBDataSource(this,
                    parentQName);

            return factory.createOMElement(dataSource, parentQName);
        }

        public void serialize(final javax.xml.namespace.QName parentQName,
            javax.xml.stream.XMLStreamWriter xmlWriter)
            throws javax.xml.stream.XMLStreamException,
                org.apache.axis2.databinding.ADBException {
            serialize(parentQName, xmlWriter, false);
        }

        public void serialize(final javax.xml.namespace.QName parentQName,
            javax.xml.stream.XMLStreamWriter xmlWriter, boolean serializeType)
            throws javax.xml.stream.XMLStreamException,
                org.apache.axis2.databinding.ADBException {
            java.lang.String prefix = null;
            java.lang.String namespace = null;

            prefix = parentQName.getPrefix();
            namespace = parentQName.getNamespaceURI();
            writeStartElement(prefix, namespace, parentQName.getLocalPart(),
                xmlWriter);

            if (serializeType) {
                java.lang.String namespacePrefix = registerPrefix(xmlWriter,
                        "http://www.csot.tcl.com/MsgHeader/1.0");

                if ((namespacePrefix != null) &&
                        (namespacePrefix.trim().length() > 0)) {
                    writeAttribute("xsi",
                        "http://www.w3.org/2001/XMLSchema-instance", "type",
                        namespacePrefix + ":MsgHeader", xmlWriter);
                } else {
                    writeAttribute("xsi",
                        "http://www.w3.org/2001/XMLSchema-instance", "type",
                        "MsgHeader", xmlWriter);
                }
            }

            namespace = "http://www.csot.tcl.com/MsgHeader/1.0";
            writeStartElement(null, namespace, "APP_ID", xmlWriter);

            if (localAPP_ID == null) {
                // write the nil attribute
                writeAttribute("xsi",
                    "http://www.w3.org/2001/XMLSchema-instance", "nil", "1",
                    xmlWriter);
            } else {
                xmlWriter.writeCharacters(localAPP_ID);
            }

            xmlWriter.writeEndElement();

            namespace = "http://www.csot.tcl.com/MsgHeader/1.0";
            writeStartElement(null, namespace, "APP_NAME", xmlWriter);

            if (localAPP_NAME == null) {
                // write the nil attribute
                writeAttribute("xsi",
                    "http://www.w3.org/2001/XMLSchema-instance", "nil", "1",
                    xmlWriter);
            } else {
                xmlWriter.writeCharacters(localAPP_NAME);
            }

            xmlWriter.writeEndElement();

            namespace = "http://www.csot.tcl.com/MsgHeader/1.0";
            writeStartElement(null, namespace, "MOD_ID", xmlWriter);

            if (localMOD_ID == null) {
                // write the nil attribute
                writeAttribute("xsi",
                    "http://www.w3.org/2001/XMLSchema-instance", "nil", "1",
                    xmlWriter);
            } else {
                xmlWriter.writeCharacters(localMOD_ID);
            }

            xmlWriter.writeEndElement();

            namespace = "http://www.csot.tcl.com/MsgHeader/1.0";
            writeStartElement(null, namespace, "MOD_NAME", xmlWriter);

            if (localMOD_NAME == null) {
                // write the nil attribute
                writeAttribute("xsi",
                    "http://www.w3.org/2001/XMLSchema-instance", "nil", "1",
                    xmlWriter);
            } else {
                xmlWriter.writeCharacters(localMOD_NAME);
            }

            xmlWriter.writeEndElement();

            namespace = "http://www.csot.tcl.com/MsgHeader/1.0";
            writeStartElement(null, namespace, "TOKEN", xmlWriter);

            if (localTOKEN == null) {
                // write the nil attribute
                writeAttribute("xsi",
                    "http://www.w3.org/2001/XMLSchema-instance", "nil", "1",
                    xmlWriter);
            } else {
                xmlWriter.writeCharacters(localTOKEN);
            }

            xmlWriter.writeEndElement();

            namespace = "http://www.csot.tcl.com/MsgHeader/1.0";
            writeStartElement(null, namespace, "USERID", xmlWriter);

            if (localUSERID == null) {
                // write the nil attribute
                writeAttribute("xsi",
                    "http://www.w3.org/2001/XMLSchema-instance", "nil", "1",
                    xmlWriter);
            } else {
                xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                        localUSERID));
            }

            xmlWriter.writeEndElement();

            namespace = "http://www.csot.tcl.com/MsgHeader/1.0";
            writeStartElement(null, namespace, "USERNAME", xmlWriter);

            if (localUSERNAME == null) {
                // write the nil attribute
                writeAttribute("xsi",
                    "http://www.w3.org/2001/XMLSchema-instance", "nil", "1",
                    xmlWriter);
            } else {
                xmlWriter.writeCharacters(localUSERNAME);
            }

            xmlWriter.writeEndElement();

            namespace = "http://www.csot.tcl.com/MsgHeader/1.0";
            writeStartElement(null, namespace, "SUBMITDATE", xmlWriter);

            if (localSUBMITDATE == null) {
                // write the nil attribute
                writeAttribute("xsi",
                    "http://www.w3.org/2001/XMLSchema-instance", "nil", "1",
                    xmlWriter);
            } else {
                xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                        localSUBMITDATE));
            }

            xmlWriter.writeEndElement();

            namespace = "http://www.csot.tcl.com/MsgHeader/1.0";
            writeStartElement(null, namespace, "PAGE_SIZE", xmlWriter);

            if (localPAGE_SIZE == null) {
                // write the nil attribute
                writeAttribute("xsi",
                    "http://www.w3.org/2001/XMLSchema-instance", "nil", "1",
                    xmlWriter);
            } else {
                xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                        localPAGE_SIZE));
            }

            xmlWriter.writeEndElement();

            namespace = "http://www.csot.tcl.com/MsgHeader/1.0";
            writeStartElement(null, namespace, "CURRENT_PAGE", xmlWriter);

            if (localCURRENT_PAGE == null) {
                // write the nil attribute
                writeAttribute("xsi",
                    "http://www.w3.org/2001/XMLSchema-instance", "nil", "1",
                    xmlWriter);
            } else {
                xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                        localCURRENT_PAGE));
            }

            xmlWriter.writeEndElement();

            namespace = "http://www.csot.tcl.com/MsgHeader/1.0";
            writeStartElement(null, namespace, "TOTAL_RECORD", xmlWriter);

            if (localTOTAL_RECORD == null) {
                // write the nil attribute
                writeAttribute("xsi",
                    "http://www.w3.org/2001/XMLSchema-instance", "nil", "1",
                    xmlWriter);
            } else {
                xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                        localTOTAL_RECORD));
            }

            xmlWriter.writeEndElement();

            namespace = "http://www.csot.tcl.com/MsgHeader/1.0";
            writeStartElement(null, namespace, "ROUTE_CODE1", xmlWriter);

            if (localROUTE_CODE1 == null) {
                // write the nil attribute
                writeAttribute("xsi",
                    "http://www.w3.org/2001/XMLSchema-instance", "nil", "1",
                    xmlWriter);
            } else {
                xmlWriter.writeCharacters(localROUTE_CODE1);
            }

            xmlWriter.writeEndElement();

            namespace = "http://www.csot.tcl.com/MsgHeader/1.0";
            writeStartElement(null, namespace, "ROUTE_CODE2", xmlWriter);

            if (localROUTE_CODE2 == null) {
                // write the nil attribute
                writeAttribute("xsi",
                    "http://www.w3.org/2001/XMLSchema-instance", "nil", "1",
                    xmlWriter);
            } else {
                xmlWriter.writeCharacters(localROUTE_CODE2);
            }

            xmlWriter.writeEndElement();

            xmlWriter.writeEndElement();
        }

        private static java.lang.String generatePrefix(
            java.lang.String namespace) {
            if (namespace.equals("http://www.csot.tcl.com/MsgHeader/1.0")) {
                return "ns1";
            }

            return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
        }

        /**
         * Utility method to write an element start tag.
         */
        private void writeStartElement(java.lang.String prefix,
            java.lang.String namespace, java.lang.String localPart,
            javax.xml.stream.XMLStreamWriter xmlWriter)
            throws javax.xml.stream.XMLStreamException {
            java.lang.String writerPrefix = xmlWriter.getPrefix(namespace);

            if (writerPrefix != null) {
                xmlWriter.writeStartElement(namespace, localPart);
            } else {
                if (namespace.length() == 0) {
                    prefix = "";
                } else if (prefix == null) {
                    prefix = generatePrefix(namespace);
                }

                xmlWriter.writeStartElement(prefix, localPart, namespace);
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }
        }

        /**
         * Util method to write an attribute with the ns prefix
         */
        private void writeAttribute(java.lang.String prefix,
            java.lang.String namespace, java.lang.String attName,
            java.lang.String attValue,
            javax.xml.stream.XMLStreamWriter xmlWriter)
            throws javax.xml.stream.XMLStreamException {
            if (xmlWriter.getPrefix(namespace) == null) {
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }

            xmlWriter.writeAttribute(namespace, attName, attValue);
        }

        /**
         * Util method to write an attribute without the ns prefix
         */
        private void writeAttribute(java.lang.String namespace,
            java.lang.String attName, java.lang.String attValue,
            javax.xml.stream.XMLStreamWriter xmlWriter)
            throws javax.xml.stream.XMLStreamException {
            if (namespace.equals("")) {
                xmlWriter.writeAttribute(attName, attValue);
            } else {
                registerPrefix(xmlWriter, namespace);
                xmlWriter.writeAttribute(namespace, attName, attValue);
            }
        }

        /**
         * Util method to write an attribute without the ns prefix
         */
        private void writeQNameAttribute(java.lang.String namespace,
            java.lang.String attName, javax.xml.namespace.QName qname,
            javax.xml.stream.XMLStreamWriter xmlWriter)
            throws javax.xml.stream.XMLStreamException {
            java.lang.String attributeNamespace = qname.getNamespaceURI();
            java.lang.String attributePrefix = xmlWriter.getPrefix(attributeNamespace);

            if (attributePrefix == null) {
                attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
            }

            java.lang.String attributeValue;

            if (attributePrefix.trim().length() > 0) {
                attributeValue = attributePrefix + ":" + qname.getLocalPart();
            } else {
                attributeValue = qname.getLocalPart();
            }

            if (namespace.equals("")) {
                xmlWriter.writeAttribute(attName, attributeValue);
            } else {
                registerPrefix(xmlWriter, namespace);
                xmlWriter.writeAttribute(namespace, attName, attributeValue);
            }
        }

        /**
         *  method to handle Qnames
         */
        private void writeQName(javax.xml.namespace.QName qname,
            javax.xml.stream.XMLStreamWriter xmlWriter)
            throws javax.xml.stream.XMLStreamException {
            java.lang.String namespaceURI = qname.getNamespaceURI();

            if (namespaceURI != null) {
                java.lang.String prefix = xmlWriter.getPrefix(namespaceURI);

                if (prefix == null) {
                    prefix = generatePrefix(namespaceURI);
                    xmlWriter.writeNamespace(prefix, namespaceURI);
                    xmlWriter.setPrefix(prefix, namespaceURI);
                }

                if (prefix.trim().length() > 0) {
                    xmlWriter.writeCharacters(prefix + ":" +
                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                            qname));
                } else {
                    // i.e this is the default namespace
                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                            qname));
                }
            } else {
                xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                        qname));
            }
        }

        private void writeQNames(javax.xml.namespace.QName[] qnames,
            javax.xml.stream.XMLStreamWriter xmlWriter)
            throws javax.xml.stream.XMLStreamException {
            if (qnames != null) {
                // we have to store this data until last moment since it is not possible to write any
                // namespace data after writing the charactor data
                java.lang.StringBuffer stringToWrite = new java.lang.StringBuffer();
                java.lang.String namespaceURI = null;
                java.lang.String prefix = null;

                for (int i = 0; i < qnames.length; i++) {
                    if (i > 0) {
                        stringToWrite.append(" ");
                    }

                    namespaceURI = qnames[i].getNamespaceURI();

                    if (namespaceURI != null) {
                        prefix = xmlWriter.getPrefix(namespaceURI);

                        if ((prefix == null) || (prefix.length() == 0)) {
                            prefix = generatePrefix(namespaceURI);
                            xmlWriter.writeNamespace(prefix, namespaceURI);
                            xmlWriter.setPrefix(prefix, namespaceURI);
                        }

                        if (prefix.trim().length() > 0) {
                            stringToWrite.append(prefix).append(":")
                                         .append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                                    qnames[i]));
                        } else {
                            stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                                    qnames[i]));
                        }
                    } else {
                        stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                                qnames[i]));
                    }
                }

                xmlWriter.writeCharacters(stringToWrite.toString());
            }
        }

        /**
         * Register a namespace prefix
         */
        private java.lang.String registerPrefix(
            javax.xml.stream.XMLStreamWriter xmlWriter,
            java.lang.String namespace)
            throws javax.xml.stream.XMLStreamException {
            java.lang.String prefix = xmlWriter.getPrefix(namespace);

            if (prefix == null) {
                prefix = generatePrefix(namespace);

                javax.xml.namespace.NamespaceContext nsContext = xmlWriter.getNamespaceContext();

                while (true) {
                    java.lang.String uri = nsContext.getNamespaceURI(prefix);

                    if ((uri == null) || (uri.length() == 0)) {
                        break;
                    }

                    prefix = org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
                }

                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }

            return prefix;
        }

        /**
         * databinding method to get an XML representation of this object
         *
         */
        public javax.xml.stream.XMLStreamReader getPullParser(
            javax.xml.namespace.QName qName)
            throws org.apache.axis2.databinding.ADBException {
            java.util.ArrayList elementList = new java.util.ArrayList();
            java.util.ArrayList attribList = new java.util.ArrayList();

            elementList.add(new javax.xml.namespace.QName(
                    "http://www.csot.tcl.com/MsgHeader/1.0", "APP_ID"));

            elementList.add((localAPP_ID == null) ? null
                                                  : org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                    localAPP_ID));

            elementList.add(new javax.xml.namespace.QName(
                    "http://www.csot.tcl.com/MsgHeader/1.0", "APP_NAME"));

            elementList.add((localAPP_NAME == null) ? null
                                                    : org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                    localAPP_NAME));

            elementList.add(new javax.xml.namespace.QName(
                    "http://www.csot.tcl.com/MsgHeader/1.0", "MOD_ID"));

            elementList.add((localMOD_ID == null) ? null
                                                  : org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                    localMOD_ID));

            elementList.add(new javax.xml.namespace.QName(
                    "http://www.csot.tcl.com/MsgHeader/1.0", "MOD_NAME"));

            elementList.add((localMOD_NAME == null) ? null
                                                    : org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                    localMOD_NAME));

            elementList.add(new javax.xml.namespace.QName(
                    "http://www.csot.tcl.com/MsgHeader/1.0", "TOKEN"));

            elementList.add((localTOKEN == null) ? null
                                                 : org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                    localTOKEN));

            elementList.add(new javax.xml.namespace.QName(
                    "http://www.csot.tcl.com/MsgHeader/1.0", "USERID"));

            elementList.add((localUSERID == null) ? null
                                                  : org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                    localUSERID));

            elementList.add(new javax.xml.namespace.QName(
                    "http://www.csot.tcl.com/MsgHeader/1.0", "USERNAME"));

            elementList.add((localUSERNAME == null) ? null
                                                    : org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                    localUSERNAME));

            elementList.add(new javax.xml.namespace.QName(
                    "http://www.csot.tcl.com/MsgHeader/1.0", "SUBMITDATE"));

            elementList.add((localSUBMITDATE == null) ? null
                                                      : org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                    localSUBMITDATE));

            elementList.add(new javax.xml.namespace.QName(
                    "http://www.csot.tcl.com/MsgHeader/1.0", "PAGE_SIZE"));

            elementList.add((localPAGE_SIZE == null) ? null
                                                     : org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                    localPAGE_SIZE));

            elementList.add(new javax.xml.namespace.QName(
                    "http://www.csot.tcl.com/MsgHeader/1.0", "CURRENT_PAGE"));

            elementList.add((localCURRENT_PAGE == null) ? null
                                                        : org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                    localCURRENT_PAGE));

            elementList.add(new javax.xml.namespace.QName(
                    "http://www.csot.tcl.com/MsgHeader/1.0", "TOTAL_RECORD"));

            elementList.add((localTOTAL_RECORD == null) ? null
                                                        : org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                    localTOTAL_RECORD));

            elementList.add(new javax.xml.namespace.QName(
                    "http://www.csot.tcl.com/MsgHeader/1.0", "ROUTE_CODE1"));

            elementList.add((localROUTE_CODE1 == null) ? null
                                                       : org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                    localROUTE_CODE1));

            elementList.add(new javax.xml.namespace.QName(
                    "http://www.csot.tcl.com/MsgHeader/1.0", "ROUTE_CODE2"));

            elementList.add((localROUTE_CODE2 == null) ? null
                                                       : org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                    localROUTE_CODE2));

            return new org.apache.axis2.databinding.utils.reader.ADBXMLStreamReaderImpl(qName,
                elementList.toArray(), attribList.toArray());
        }

        /**
         *  Factory class that keeps the parse method
         */
        public static class Factory {
            /**
             * static method to create the object
             * Precondition:  If this object is an element, the current or next start element starts this object and any intervening reader events are ignorable
             *                If this object is not an element, it is a complex type and the reader is at the event just after the outer start element
             * Postcondition: If this object is an element, the reader is positioned at its end element
             *                If this object is a complex type, the reader is positioned at the end element of its outer element
             */
            public static MsgHeader parse(
                javax.xml.stream.XMLStreamReader reader)
                throws java.lang.Exception {
                MsgHeader object = new MsgHeader();

                int event;
                java.lang.String nillableValue = null;
                java.lang.String prefix = "";
                java.lang.String namespaceuri = "";

                try {
                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();

                    if (reader.getAttributeValue(
                                "http://www.w3.org/2001/XMLSchema-instance",
                                "type") != null) {
                        java.lang.String fullTypeName = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                                "type");

                        if (fullTypeName != null) {
                            java.lang.String nsPrefix = null;

                            if (fullTypeName.indexOf(":") > -1) {
                                nsPrefix = fullTypeName.substring(0,
                                        fullTypeName.indexOf(":"));
                            }

                            nsPrefix = (nsPrefix == null) ? "" : nsPrefix;

                            java.lang.String type = fullTypeName.substring(fullTypeName.indexOf(
                                        ":") + 1);

                            if (!"MsgHeader".equals(type)) {
                                //find namespace for the prefix
                                java.lang.String nsUri = reader.getNamespaceContext()
                                                               .getNamespaceURI(nsPrefix);

                                return (MsgHeader) ExtensionMapper.getTypeObject(nsUri,
                                    type, reader);
                            }
                        }
                    }

                    // Note all attributes that were handled. Used to differ normal attributes
                    // from anyAttributes.
                    java.util.Vector handledAttributes = new java.util.Vector();

                    reader.next();

                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();

                    if (reader.isStartElement() &&
                            new javax.xml.namespace.QName(
                                "http://www.csot.tcl.com/MsgHeader/1.0",
                                "APP_ID").equals(reader.getName())) {
                        nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                                "nil");

                        if (!"true".equals(nillableValue) &&
                                !"1".equals(nillableValue)) {
                            java.lang.String content = reader.getElementText();

                            object.setAPP_ID(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                                    content));
                        } else {
                            reader.getElementText(); // throw away text nodes if any.
                        }

                        reader.next();
                    } // End of if for expected property start element

                    else {
                        // A start element we are not expecting indicates an invalid parameter was passed
                        throw new org.apache.axis2.databinding.ADBException(
                            "Unexpected subelement " + reader.getName());
                    }

                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();

                    if (reader.isStartElement() &&
                            new javax.xml.namespace.QName(
                                "http://www.csot.tcl.com/MsgHeader/1.0",
                                "APP_NAME").equals(reader.getName())) {
                        nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                                "nil");

                        if (!"true".equals(nillableValue) &&
                                !"1".equals(nillableValue)) {
                            java.lang.String content = reader.getElementText();

                            object.setAPP_NAME(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                                    content));
                        } else {
                            reader.getElementText(); // throw away text nodes if any.
                        }

                        reader.next();
                    } // End of if for expected property start element

                    else {
                        // A start element we are not expecting indicates an invalid parameter was passed
                        throw new org.apache.axis2.databinding.ADBException(
                            "Unexpected subelement " + reader.getName());
                    }

                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();

                    if (reader.isStartElement() &&
                            new javax.xml.namespace.QName(
                                "http://www.csot.tcl.com/MsgHeader/1.0",
                                "MOD_ID").equals(reader.getName())) {
                        nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                                "nil");

                        if (!"true".equals(nillableValue) &&
                                !"1".equals(nillableValue)) {
                            java.lang.String content = reader.getElementText();

                            object.setMOD_ID(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                                    content));
                        } else {
                            reader.getElementText(); // throw away text nodes if any.
                        }

                        reader.next();
                    } // End of if for expected property start element

                    else {
                        // A start element we are not expecting indicates an invalid parameter was passed
                        throw new org.apache.axis2.databinding.ADBException(
                            "Unexpected subelement " + reader.getName());
                    }

                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();

                    if (reader.isStartElement() &&
                            new javax.xml.namespace.QName(
                                "http://www.csot.tcl.com/MsgHeader/1.0",
                                "MOD_NAME").equals(reader.getName())) {
                        nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                                "nil");

                        if (!"true".equals(nillableValue) &&
                                !"1".equals(nillableValue)) {
                            java.lang.String content = reader.getElementText();

                            object.setMOD_NAME(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                                    content));
                        } else {
                            reader.getElementText(); // throw away text nodes if any.
                        }

                        reader.next();
                    } // End of if for expected property start element

                    else {
                        // A start element we are not expecting indicates an invalid parameter was passed
                        throw new org.apache.axis2.databinding.ADBException(
                            "Unexpected subelement " + reader.getName());
                    }

                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();

                    if (reader.isStartElement() &&
                            new javax.xml.namespace.QName(
                                "http://www.csot.tcl.com/MsgHeader/1.0", "TOKEN").equals(
                                reader.getName())) {
                        nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                                "nil");

                        if (!"true".equals(nillableValue) &&
                                !"1".equals(nillableValue)) {
                            java.lang.String content = reader.getElementText();

                            object.setTOKEN(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                                    content));
                        } else {
                            reader.getElementText(); // throw away text nodes if any.
                        }

                        reader.next();
                    } // End of if for expected property start element

                    else {
                        // A start element we are not expecting indicates an invalid parameter was passed
                        throw new org.apache.axis2.databinding.ADBException(
                            "Unexpected subelement " + reader.getName());
                    }

                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();

                    if (reader.isStartElement() &&
                            new javax.xml.namespace.QName(
                                "http://www.csot.tcl.com/MsgHeader/1.0",
                                "USERID").equals(reader.getName())) {
                        nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                                "nil");

                        if (!"true".equals(nillableValue) &&
                                !"1".equals(nillableValue)) {
                            java.lang.String content = reader.getElementText();

                            object.setUSERID(org.apache.axis2.databinding.utils.ConverterUtil.convertToDecimal(
                                    content));
                        } else {
                            reader.getElementText(); // throw away text nodes if any.
                        }

                        reader.next();
                    } // End of if for expected property start element

                    else {
                        // A start element we are not expecting indicates an invalid parameter was passed
                        throw new org.apache.axis2.databinding.ADBException(
                            "Unexpected subelement " + reader.getName());
                    }

                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();

                    if (reader.isStartElement() &&
                            new javax.xml.namespace.QName(
                                "http://www.csot.tcl.com/MsgHeader/1.0",
                                "USERNAME").equals(reader.getName())) {
                        nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                                "nil");

                        if (!"true".equals(nillableValue) &&
                                !"1".equals(nillableValue)) {
                            java.lang.String content = reader.getElementText();

                            object.setUSERNAME(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                                    content));
                        } else {
                            reader.getElementText(); // throw away text nodes if any.
                        }

                        reader.next();
                    } // End of if for expected property start element

                    else {
                        // A start element we are not expecting indicates an invalid parameter was passed
                        throw new org.apache.axis2.databinding.ADBException(
                            "Unexpected subelement " + reader.getName());
                    }

                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();

                    if (reader.isStartElement() &&
                            new javax.xml.namespace.QName(
                                "http://www.csot.tcl.com/MsgHeader/1.0",
                                "SUBMITDATE").equals(reader.getName())) {
                        nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                                "nil");

                        if (!"true".equals(nillableValue) &&
                                !"1".equals(nillableValue)) {
                            java.lang.String content = reader.getElementText();

                            object.setSUBMITDATE(org.apache.axis2.databinding.utils.ConverterUtil.convertToDateTime(
                                    content));
                        } else {
                            reader.getElementText(); // throw away text nodes if any.
                        }

                        reader.next();
                    } // End of if for expected property start element

                    else {
                        // A start element we are not expecting indicates an invalid parameter was passed
                        throw new org.apache.axis2.databinding.ADBException(
                            "Unexpected subelement " + reader.getName());
                    }

                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();

                    if (reader.isStartElement() &&
                            new javax.xml.namespace.QName(
                                "http://www.csot.tcl.com/MsgHeader/1.0",
                                "PAGE_SIZE").equals(reader.getName())) {
                        nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                                "nil");

                        if (!"true".equals(nillableValue) &&
                                !"1".equals(nillableValue)) {
                            java.lang.String content = reader.getElementText();

                            object.setPAGE_SIZE(org.apache.axis2.databinding.utils.ConverterUtil.convertToDecimal(
                                    content));
                        } else {
                            reader.getElementText(); // throw away text nodes if any.
                        }

                        reader.next();
                    } // End of if for expected property start element

                    else {
                        // A start element we are not expecting indicates an invalid parameter was passed
                        throw new org.apache.axis2.databinding.ADBException(
                            "Unexpected subelement " + reader.getName());
                    }

                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();

                    if (reader.isStartElement() &&
                            new javax.xml.namespace.QName(
                                "http://www.csot.tcl.com/MsgHeader/1.0",
                                "CURRENT_PAGE").equals(reader.getName())) {
                        nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                                "nil");

                        if (!"true".equals(nillableValue) &&
                                !"1".equals(nillableValue)) {
                            java.lang.String content = reader.getElementText();

                            object.setCURRENT_PAGE(org.apache.axis2.databinding.utils.ConverterUtil.convertToDecimal(
                                    content));
                        } else {
                            reader.getElementText(); // throw away text nodes if any.
                        }

                        reader.next();
                    } // End of if for expected property start element

                    else {
                        // A start element we are not expecting indicates an invalid parameter was passed
                        throw new org.apache.axis2.databinding.ADBException(
                            "Unexpected subelement " + reader.getName());
                    }

                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();

                    if (reader.isStartElement() &&
                            new javax.xml.namespace.QName(
                                "http://www.csot.tcl.com/MsgHeader/1.0",
                                "TOTAL_RECORD").equals(reader.getName())) {
                        nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                                "nil");

                        if (!"true".equals(nillableValue) &&
                                !"1".equals(nillableValue)) {
                            java.lang.String content = reader.getElementText();

                            object.setTOTAL_RECORD(org.apache.axis2.databinding.utils.ConverterUtil.convertToDecimal(
                                    content));
                        } else {
                            reader.getElementText(); // throw away text nodes if any.
                        }

                        reader.next();
                    } // End of if for expected property start element

                    else {
                        // A start element we are not expecting indicates an invalid parameter was passed
                        throw new org.apache.axis2.databinding.ADBException(
                            "Unexpected subelement " + reader.getName());
                    }

                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();

                    if (reader.isStartElement() &&
                            new javax.xml.namespace.QName(
                                "http://www.csot.tcl.com/MsgHeader/1.0",
                                "ROUTE_CODE1").equals(reader.getName())) {
                        nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                                "nil");

                        if (!"true".equals(nillableValue) &&
                                !"1".equals(nillableValue)) {
                            java.lang.String content = reader.getElementText();

                            object.setROUTE_CODE1(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                                    content));
                        } else {
                            reader.getElementText(); // throw away text nodes if any.
                        }

                        reader.next();
                    } // End of if for expected property start element

                    else {
                        // A start element we are not expecting indicates an invalid parameter was passed
                        throw new org.apache.axis2.databinding.ADBException(
                            "Unexpected subelement " + reader.getName());
                    }

                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();

                    if (reader.isStartElement() &&
                            new javax.xml.namespace.QName(
                                "http://www.csot.tcl.com/MsgHeader/1.0",
                                "ROUTE_CODE2").equals(reader.getName())) {
                        nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                                "nil");

                        if (!"true".equals(nillableValue) &&
                                !"1".equals(nillableValue)) {
                            java.lang.String content = reader.getElementText();

                            object.setROUTE_CODE2(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                                    content));
                        } else {
                            reader.getElementText(); // throw away text nodes if any.
                        }

                        reader.next();
                    } // End of if for expected property start element

                    else {
                        // A start element we are not expecting indicates an invalid parameter was passed
                        throw new org.apache.axis2.databinding.ADBException(
                            "Unexpected subelement " + reader.getName());
                    }

                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();

                    if (reader.isStartElement()) {
                        // A start element we are not expecting indicates a trailing invalid property
                        throw new org.apache.axis2.databinding.ADBException(
                            "Unexpected subelement " + reader.getName());
                    }
                } catch (javax.xml.stream.XMLStreamException e) {
                    throw new java.lang.Exception(e);
                }

                return object;
            }
        } //end of factory class
    }

    public static class ESB_GYD_GYD_InquiryHasCaptchaSrvResponse implements org.apache.axis2.databinding.ADBBean {
        /* This type was generated from the piece of schema that had
           name = ESB_GYD_GYD_InquiryHasCaptchaSrvResponse
           Namespace URI = http://www.csot.tcl.com/ESB_GYD_GYD_InquiryHasCaptchaSrv/1.0
           Namespace Prefix = ns2
         */

        /**
         * field for SERVICE_FLAG
         */
        protected java.lang.String localSERVICE_FLAG;

        /**
         * field for SERVICE_MESSAGE
         */
        protected java.lang.String localSERVICE_MESSAGE;

        /**
         * field for INSTANCE_ID
         */
        protected java.lang.String localINSTANCE_ID;

        /**
         * field for TOTAL_RECORD
         */
        protected java.math.BigDecimal localTOTAL_RECORD;

        /**
         * field for TOTAL_PAGE
         */
        protected java.math.BigDecimal localTOTAL_PAGE;

        /**
         * field for PAGE_SIZE
         */
        protected java.math.BigDecimal localPAGE_SIZE;

        /**
         * field for CURRENT_PAGE
         */
        protected java.math.BigDecimal localCURRENT_PAGE;

        /**
         * field for ESB_GYD_GYD_InquiryHasCaptchaSrvOutputCollection
         */
        protected ESB_GYD_GYD_InquiryHasCaptchaSrvOutputCollection localESB_GYD_GYD_InquiryHasCaptchaSrvOutputCollection;

        /**
         * Auto generated getter method
         * @return java.lang.String
         */
        public java.lang.String getSERVICE_FLAG() {
            return localSERVICE_FLAG;
        }

        /**
         * Auto generated setter method
         * @param param SERVICE_FLAG
         */
        public void setSERVICE_FLAG(java.lang.String param) {
            this.localSERVICE_FLAG = param;
        }

        /**
         * Auto generated getter method
         * @return java.lang.String
         */
        public java.lang.String getSERVICE_MESSAGE() {
            return localSERVICE_MESSAGE;
        }

        /**
         * Auto generated setter method
         * @param param SERVICE_MESSAGE
         */
        public void setSERVICE_MESSAGE(java.lang.String param) {
            this.localSERVICE_MESSAGE = param;
        }

        /**
         * Auto generated getter method
         * @return java.lang.String
         */
        public java.lang.String getINSTANCE_ID() {
            return localINSTANCE_ID;
        }

        /**
         * Auto generated setter method
         * @param param INSTANCE_ID
         */
        public void setINSTANCE_ID(java.lang.String param) {
            this.localINSTANCE_ID = param;
        }

        /**
         * Auto generated getter method
         * @return java.math.BigDecimal
         */
        public java.math.BigDecimal getTOTAL_RECORD() {
            return localTOTAL_RECORD;
        }

        /**
         * Auto generated setter method
         * @param param TOTAL_RECORD
         */
        public void setTOTAL_RECORD(java.math.BigDecimal param) {
            this.localTOTAL_RECORD = param;
        }

        /**
         * Auto generated getter method
         * @return java.math.BigDecimal
         */
        public java.math.BigDecimal getTOTAL_PAGE() {
            return localTOTAL_PAGE;
        }

        /**
         * Auto generated setter method
         * @param param TOTAL_PAGE
         */
        public void setTOTAL_PAGE(java.math.BigDecimal param) {
            this.localTOTAL_PAGE = param;
        }

        /**
         * Auto generated getter method
         * @return java.math.BigDecimal
         */
        public java.math.BigDecimal getPAGE_SIZE() {
            return localPAGE_SIZE;
        }

        /**
         * Auto generated setter method
         * @param param PAGE_SIZE
         */
        public void setPAGE_SIZE(java.math.BigDecimal param) {
            this.localPAGE_SIZE = param;
        }

        /**
         * Auto generated getter method
         * @return java.math.BigDecimal
         */
        public java.math.BigDecimal getCURRENT_PAGE() {
            return localCURRENT_PAGE;
        }

        /**
         * Auto generated setter method
         * @param param CURRENT_PAGE
         */
        public void setCURRENT_PAGE(java.math.BigDecimal param) {
            this.localCURRENT_PAGE = param;
        }

        /**
         * Auto generated getter method
         * @return ESB_GYD_GYD_InquiryHasCaptchaSrvOutputCollection
         */
        public ESB_GYD_GYD_InquiryHasCaptchaSrvOutputCollection getESB_GYD_GYD_InquiryHasCaptchaSrvOutputCollection() {
            return localESB_GYD_GYD_InquiryHasCaptchaSrvOutputCollection;
        }

        /**
         * Auto generated setter method
         * @param param ESB_GYD_GYD_InquiryHasCaptchaSrvOutputCollection
         */
        public void setESB_GYD_GYD_InquiryHasCaptchaSrvOutputCollection(
            ESB_GYD_GYD_InquiryHasCaptchaSrvOutputCollection param) {
            this.localESB_GYD_GYD_InquiryHasCaptchaSrvOutputCollection = param;
        }

        /**
         *
         * @param parentQName
         * @param factory
         * @return org.apache.axiom.om.OMElement
         */
        public org.apache.axiom.om.OMElement getOMElement(
            final javax.xml.namespace.QName parentQName,
            final org.apache.axiom.om.OMFactory factory)
            throws org.apache.axis2.databinding.ADBException {
            org.apache.axiom.om.OMDataSource dataSource = new org.apache.axis2.databinding.ADBDataSource(this,
                    parentQName);

            return factory.createOMElement(dataSource, parentQName);
        }

        public void serialize(final javax.xml.namespace.QName parentQName,
            javax.xml.stream.XMLStreamWriter xmlWriter)
            throws javax.xml.stream.XMLStreamException,
                org.apache.axis2.databinding.ADBException {
            serialize(parentQName, xmlWriter, false);
        }

        public void serialize(final javax.xml.namespace.QName parentQName,
            javax.xml.stream.XMLStreamWriter xmlWriter, boolean serializeType)
            throws javax.xml.stream.XMLStreamException,
                org.apache.axis2.databinding.ADBException {
            java.lang.String prefix = null;
            java.lang.String namespace = null;

            prefix = parentQName.getPrefix();
            namespace = parentQName.getNamespaceURI();
            writeStartElement(prefix, namespace, parentQName.getLocalPart(),
                xmlWriter);

            if (serializeType) {
                java.lang.String namespacePrefix = registerPrefix(xmlWriter,
                        "http://www.csot.tcl.com/ESB_GYD_GYD_InquiryHasCaptchaSrv/1.0");

                if ((namespacePrefix != null) &&
                        (namespacePrefix.trim().length() > 0)) {
                    writeAttribute("xsi",
                        "http://www.w3.org/2001/XMLSchema-instance", "type",
                        namespacePrefix +
                        ":ESB_GYD_GYD_InquiryHasCaptchaSrvResponse", xmlWriter);
                } else {
                    writeAttribute("xsi",
                        "http://www.w3.org/2001/XMLSchema-instance", "type",
                        "ESB_GYD_GYD_InquiryHasCaptchaSrvResponse", xmlWriter);
                }
            }

            namespace = "http://www.csot.tcl.com/ESB_GYD_GYD_InquiryHasCaptchaSrv/1.0";
            writeStartElement(null, namespace, "SERVICE_FLAG", xmlWriter);

            if (localSERVICE_FLAG == null) {
                // write the nil attribute
                writeAttribute("xsi",
                    "http://www.w3.org/2001/XMLSchema-instance", "nil", "1",
                    xmlWriter);
            } else {
                xmlWriter.writeCharacters(localSERVICE_FLAG);
            }

            xmlWriter.writeEndElement();

            namespace = "http://www.csot.tcl.com/ESB_GYD_GYD_InquiryHasCaptchaSrv/1.0";
            writeStartElement(null, namespace, "SERVICE_MESSAGE", xmlWriter);

            if (localSERVICE_MESSAGE == null) {
                // write the nil attribute
                writeAttribute("xsi",
                    "http://www.w3.org/2001/XMLSchema-instance", "nil", "1",
                    xmlWriter);
            } else {
                xmlWriter.writeCharacters(localSERVICE_MESSAGE);
            }

            xmlWriter.writeEndElement();

            namespace = "http://www.csot.tcl.com/ESB_GYD_GYD_InquiryHasCaptchaSrv/1.0";
            writeStartElement(null, namespace, "INSTANCE_ID", xmlWriter);

            if (localINSTANCE_ID == null) {
                // write the nil attribute
                writeAttribute("xsi",
                    "http://www.w3.org/2001/XMLSchema-instance", "nil", "1",
                    xmlWriter);
            } else {
                xmlWriter.writeCharacters(localINSTANCE_ID);
            }

            xmlWriter.writeEndElement();

            namespace = "http://www.csot.tcl.com/ESB_GYD_GYD_InquiryHasCaptchaSrv/1.0";
            writeStartElement(null, namespace, "TOTAL_RECORD", xmlWriter);

            if (localTOTAL_RECORD == null) {
                // write the nil attribute
                writeAttribute("xsi",
                    "http://www.w3.org/2001/XMLSchema-instance", "nil", "1",
                    xmlWriter);
            } else {
                xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                        localTOTAL_RECORD));
            }

            xmlWriter.writeEndElement();

            namespace = "http://www.csot.tcl.com/ESB_GYD_GYD_InquiryHasCaptchaSrv/1.0";
            writeStartElement(null, namespace, "TOTAL_PAGE", xmlWriter);

            if (localTOTAL_PAGE == null) {
                // write the nil attribute
                writeAttribute("xsi",
                    "http://www.w3.org/2001/XMLSchema-instance", "nil", "1",
                    xmlWriter);
            } else {
                xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                        localTOTAL_PAGE));
            }

            xmlWriter.writeEndElement();

            namespace = "http://www.csot.tcl.com/ESB_GYD_GYD_InquiryHasCaptchaSrv/1.0";
            writeStartElement(null, namespace, "PAGE_SIZE", xmlWriter);

            if (localPAGE_SIZE == null) {
                // write the nil attribute
                writeAttribute("xsi",
                    "http://www.w3.org/2001/XMLSchema-instance", "nil", "1",
                    xmlWriter);
            } else {
                xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                        localPAGE_SIZE));
            }

            xmlWriter.writeEndElement();

            namespace = "http://www.csot.tcl.com/ESB_GYD_GYD_InquiryHasCaptchaSrv/1.0";
            writeStartElement(null, namespace, "CURRENT_PAGE", xmlWriter);

            if (localCURRENT_PAGE == null) {
                // write the nil attribute
                writeAttribute("xsi",
                    "http://www.w3.org/2001/XMLSchema-instance", "nil", "1",
                    xmlWriter);
            } else {
                xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                        localCURRENT_PAGE));
            }

            xmlWriter.writeEndElement();

            if (localESB_GYD_GYD_InquiryHasCaptchaSrvOutputCollection == null) {
                throw new org.apache.axis2.databinding.ADBException(
                    "ESB_GYD_GYD_InquiryHasCaptchaSrvOutputCollection cannot be null!!");
            }

            localESB_GYD_GYD_InquiryHasCaptchaSrvOutputCollection.serialize(new javax.xml.namespace.QName(
                    "http://www.csot.tcl.com/ESB_GYD_GYD_InquiryHasCaptchaSrv/1.0",
                    "ESB_GYD_GYD_InquiryHasCaptchaSrvOutputCollection"),
                xmlWriter);

            xmlWriter.writeEndElement();
        }

        private static java.lang.String generatePrefix(
            java.lang.String namespace) {
            if (namespace.equals(
                        "http://www.csot.tcl.com/ESB_GYD_GYD_InquiryHasCaptchaSrv/1.0")) {
                return "ns2";
            }

            return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
        }

        /**
         * Utility method to write an element start tag.
         */
        private void writeStartElement(java.lang.String prefix,
            java.lang.String namespace, java.lang.String localPart,
            javax.xml.stream.XMLStreamWriter xmlWriter)
            throws javax.xml.stream.XMLStreamException {
            java.lang.String writerPrefix = xmlWriter.getPrefix(namespace);

            if (writerPrefix != null) {
                xmlWriter.writeStartElement(namespace, localPart);
            } else {
                if (namespace.length() == 0) {
                    prefix = "";
                } else if (prefix == null) {
                    prefix = generatePrefix(namespace);
                }

                xmlWriter.writeStartElement(prefix, localPart, namespace);
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }
        }

        /**
         * Util method to write an attribute with the ns prefix
         */
        private void writeAttribute(java.lang.String prefix,
            java.lang.String namespace, java.lang.String attName,
            java.lang.String attValue,
            javax.xml.stream.XMLStreamWriter xmlWriter)
            throws javax.xml.stream.XMLStreamException {
            if (xmlWriter.getPrefix(namespace) == null) {
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }

            xmlWriter.writeAttribute(namespace, attName, attValue);
        }

        /**
         * Util method to write an attribute without the ns prefix
         */
        private void writeAttribute(java.lang.String namespace,
            java.lang.String attName, java.lang.String attValue,
            javax.xml.stream.XMLStreamWriter xmlWriter)
            throws javax.xml.stream.XMLStreamException {
            if (namespace.equals("")) {
                xmlWriter.writeAttribute(attName, attValue);
            } else {
                registerPrefix(xmlWriter, namespace);
                xmlWriter.writeAttribute(namespace, attName, attValue);
            }
        }

        /**
         * Util method to write an attribute without the ns prefix
         */
        private void writeQNameAttribute(java.lang.String namespace,
            java.lang.String attName, javax.xml.namespace.QName qname,
            javax.xml.stream.XMLStreamWriter xmlWriter)
            throws javax.xml.stream.XMLStreamException {
            java.lang.String attributeNamespace = qname.getNamespaceURI();
            java.lang.String attributePrefix = xmlWriter.getPrefix(attributeNamespace);

            if (attributePrefix == null) {
                attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
            }

            java.lang.String attributeValue;

            if (attributePrefix.trim().length() > 0) {
                attributeValue = attributePrefix + ":" + qname.getLocalPart();
            } else {
                attributeValue = qname.getLocalPart();
            }

            if (namespace.equals("")) {
                xmlWriter.writeAttribute(attName, attributeValue);
            } else {
                registerPrefix(xmlWriter, namespace);
                xmlWriter.writeAttribute(namespace, attName, attributeValue);
            }
        }

        /**
         *  method to handle Qnames
         */
        private void writeQName(javax.xml.namespace.QName qname,
            javax.xml.stream.XMLStreamWriter xmlWriter)
            throws javax.xml.stream.XMLStreamException {
            java.lang.String namespaceURI = qname.getNamespaceURI();

            if (namespaceURI != null) {
                java.lang.String prefix = xmlWriter.getPrefix(namespaceURI);

                if (prefix == null) {
                    prefix = generatePrefix(namespaceURI);
                    xmlWriter.writeNamespace(prefix, namespaceURI);
                    xmlWriter.setPrefix(prefix, namespaceURI);
                }

                if (prefix.trim().length() > 0) {
                    xmlWriter.writeCharacters(prefix + ":" +
                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                            qname));
                } else {
                    // i.e this is the default namespace
                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                            qname));
                }
            } else {
                xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                        qname));
            }
        }

        private void writeQNames(javax.xml.namespace.QName[] qnames,
            javax.xml.stream.XMLStreamWriter xmlWriter)
            throws javax.xml.stream.XMLStreamException {
            if (qnames != null) {
                // we have to store this data until last moment since it is not possible to write any
                // namespace data after writing the charactor data
                java.lang.StringBuffer stringToWrite = new java.lang.StringBuffer();
                java.lang.String namespaceURI = null;
                java.lang.String prefix = null;

                for (int i = 0; i < qnames.length; i++) {
                    if (i > 0) {
                        stringToWrite.append(" ");
                    }

                    namespaceURI = qnames[i].getNamespaceURI();

                    if (namespaceURI != null) {
                        prefix = xmlWriter.getPrefix(namespaceURI);

                        if ((prefix == null) || (prefix.length() == 0)) {
                            prefix = generatePrefix(namespaceURI);
                            xmlWriter.writeNamespace(prefix, namespaceURI);
                            xmlWriter.setPrefix(prefix, namespaceURI);
                        }

                        if (prefix.trim().length() > 0) {
                            stringToWrite.append(prefix).append(":")
                                         .append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                                    qnames[i]));
                        } else {
                            stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                                    qnames[i]));
                        }
                    } else {
                        stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                                qnames[i]));
                    }
                }

                xmlWriter.writeCharacters(stringToWrite.toString());
            }
        }

        /**
         * Register a namespace prefix
         */
        private java.lang.String registerPrefix(
            javax.xml.stream.XMLStreamWriter xmlWriter,
            java.lang.String namespace)
            throws javax.xml.stream.XMLStreamException {
            java.lang.String prefix = xmlWriter.getPrefix(namespace);

            if (prefix == null) {
                prefix = generatePrefix(namespace);

                javax.xml.namespace.NamespaceContext nsContext = xmlWriter.getNamespaceContext();

                while (true) {
                    java.lang.String uri = nsContext.getNamespaceURI(prefix);

                    if ((uri == null) || (uri.length() == 0)) {
                        break;
                    }

                    prefix = org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
                }

                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }

            return prefix;
        }

        /**
         * databinding method to get an XML representation of this object
         *
         */
        public javax.xml.stream.XMLStreamReader getPullParser(
            javax.xml.namespace.QName qName)
            throws org.apache.axis2.databinding.ADBException {
            java.util.ArrayList elementList = new java.util.ArrayList();
            java.util.ArrayList attribList = new java.util.ArrayList();

            elementList.add(new javax.xml.namespace.QName(
                    "http://www.csot.tcl.com/ESB_GYD_GYD_InquiryHasCaptchaSrv/1.0",
                    "SERVICE_FLAG"));

            elementList.add((localSERVICE_FLAG == null) ? null
                                                        : org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                    localSERVICE_FLAG));

            elementList.add(new javax.xml.namespace.QName(
                    "http://www.csot.tcl.com/ESB_GYD_GYD_InquiryHasCaptchaSrv/1.0",
                    "SERVICE_MESSAGE"));

            elementList.add((localSERVICE_MESSAGE == null) ? null
                                                           : org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                    localSERVICE_MESSAGE));

            elementList.add(new javax.xml.namespace.QName(
                    "http://www.csot.tcl.com/ESB_GYD_GYD_InquiryHasCaptchaSrv/1.0",
                    "INSTANCE_ID"));

            elementList.add((localINSTANCE_ID == null) ? null
                                                       : org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                    localINSTANCE_ID));

            elementList.add(new javax.xml.namespace.QName(
                    "http://www.csot.tcl.com/ESB_GYD_GYD_InquiryHasCaptchaSrv/1.0",
                    "TOTAL_RECORD"));

            elementList.add((localTOTAL_RECORD == null) ? null
                                                        : org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                    localTOTAL_RECORD));

            elementList.add(new javax.xml.namespace.QName(
                    "http://www.csot.tcl.com/ESB_GYD_GYD_InquiryHasCaptchaSrv/1.0",
                    "TOTAL_PAGE"));

            elementList.add((localTOTAL_PAGE == null) ? null
                                                      : org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                    localTOTAL_PAGE));

            elementList.add(new javax.xml.namespace.QName(
                    "http://www.csot.tcl.com/ESB_GYD_GYD_InquiryHasCaptchaSrv/1.0",
                    "PAGE_SIZE"));

            elementList.add((localPAGE_SIZE == null) ? null
                                                     : org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                    localPAGE_SIZE));

            elementList.add(new javax.xml.namespace.QName(
                    "http://www.csot.tcl.com/ESB_GYD_GYD_InquiryHasCaptchaSrv/1.0",
                    "CURRENT_PAGE"));

            elementList.add((localCURRENT_PAGE == null) ? null
                                                        : org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                    localCURRENT_PAGE));

            elementList.add(new javax.xml.namespace.QName(
                    "http://www.csot.tcl.com/ESB_GYD_GYD_InquiryHasCaptchaSrv/1.0",
                    "ESB_GYD_GYD_InquiryHasCaptchaSrvOutputCollection"));

            if (localESB_GYD_GYD_InquiryHasCaptchaSrvOutputCollection == null) {
                throw new org.apache.axis2.databinding.ADBException(
                    "ESB_GYD_GYD_InquiryHasCaptchaSrvOutputCollection cannot be null!!");
            }

            elementList.add(localESB_GYD_GYD_InquiryHasCaptchaSrvOutputCollection);

            return new org.apache.axis2.databinding.utils.reader.ADBXMLStreamReaderImpl(qName,
                elementList.toArray(), attribList.toArray());
        }

        /**
         *  Factory class that keeps the parse method
         */
        public static class Factory {
            /**
             * static method to create the object
             * Precondition:  If this object is an element, the current or next start element starts this object and any intervening reader events are ignorable
             *                If this object is not an element, it is a complex type and the reader is at the event just after the outer start element
             * Postcondition: If this object is an element, the reader is positioned at its end element
             *                If this object is a complex type, the reader is positioned at the end element of its outer element
             */
            public static ESB_GYD_GYD_InquiryHasCaptchaSrvResponse parse(
                javax.xml.stream.XMLStreamReader reader)
                throws java.lang.Exception {
                ESB_GYD_GYD_InquiryHasCaptchaSrvResponse object = new ESB_GYD_GYD_InquiryHasCaptchaSrvResponse();

                int event;
                java.lang.String nillableValue = null;
                java.lang.String prefix = "";
                java.lang.String namespaceuri = "";

                try {
                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();

                    if (reader.getAttributeValue(
                                "http://www.w3.org/2001/XMLSchema-instance",
                                "type") != null) {
                        java.lang.String fullTypeName = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                                "type");

                        if (fullTypeName != null) {
                            java.lang.String nsPrefix = null;

                            if (fullTypeName.indexOf(":") > -1) {
                                nsPrefix = fullTypeName.substring(0,
                                        fullTypeName.indexOf(":"));
                            }

                            nsPrefix = (nsPrefix == null) ? "" : nsPrefix;

                            java.lang.String type = fullTypeName.substring(fullTypeName.indexOf(
                                        ":") + 1);

                            if (!"ESB_GYD_GYD_InquiryHasCaptchaSrvResponse".equals(
                                        type)) {
                                //find namespace for the prefix
                                java.lang.String nsUri = reader.getNamespaceContext()
                                                               .getNamespaceURI(nsPrefix);

                                return (ESB_GYD_GYD_InquiryHasCaptchaSrvResponse) ExtensionMapper.getTypeObject(nsUri,
                                    type, reader);
                            }
                        }
                    }

                    // Note all attributes that were handled. Used to differ normal attributes
                    // from anyAttributes.
                    java.util.Vector handledAttributes = new java.util.Vector();

                    reader.next();

                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();

                    if (reader.isStartElement() &&
                            new javax.xml.namespace.QName(
                                "http://www.csot.tcl.com/ESB_GYD_GYD_InquiryHasCaptchaSrv/1.0",
                                "SERVICE_FLAG").equals(reader.getName())) {
                        nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                                "nil");

                        if (!"true".equals(nillableValue) &&
                                !"1".equals(nillableValue)) {
                            java.lang.String content = reader.getElementText();

                            object.setSERVICE_FLAG(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                                    content));
                        } else {
                            reader.getElementText(); // throw away text nodes if any.
                        }

                        reader.next();
                    } // End of if for expected property start element

                    else {
                        // A start element we are not expecting indicates an invalid parameter was passed
                        throw new org.apache.axis2.databinding.ADBException(
                            "Unexpected subelement " + reader.getName());
                    }

                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();

                    if (reader.isStartElement() &&
                            new javax.xml.namespace.QName(
                                "http://www.csot.tcl.com/ESB_GYD_GYD_InquiryHasCaptchaSrv/1.0",
                                "SERVICE_MESSAGE").equals(reader.getName())) {
                        nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                                "nil");

                        if (!"true".equals(nillableValue) &&
                                !"1".equals(nillableValue)) {
                            java.lang.String content = reader.getElementText();

                            object.setSERVICE_MESSAGE(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                                    content));
                        } else {
                            reader.getElementText(); // throw away text nodes if any.
                        }

                        reader.next();
                    } // End of if for expected property start element

                    else {
                        // A start element we are not expecting indicates an invalid parameter was passed
                        throw new org.apache.axis2.databinding.ADBException(
                            "Unexpected subelement " + reader.getName());
                    }

                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();

                    if (reader.isStartElement() &&
                            new javax.xml.namespace.QName(
                                "http://www.csot.tcl.com/ESB_GYD_GYD_InquiryHasCaptchaSrv/1.0",
                                "INSTANCE_ID").equals(reader.getName())) {
                        nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                                "nil");

                        if (!"true".equals(nillableValue) &&
                                !"1".equals(nillableValue)) {
                            java.lang.String content = reader.getElementText();

                            object.setINSTANCE_ID(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                                    content));
                        } else {
                            reader.getElementText(); // throw away text nodes if any.
                        }

                        reader.next();
                    } // End of if for expected property start element

                    else {
                        // A start element we are not expecting indicates an invalid parameter was passed
                        throw new org.apache.axis2.databinding.ADBException(
                            "Unexpected subelement " + reader.getName());
                    }

                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();

                    if (reader.isStartElement() &&
                            new javax.xml.namespace.QName(
                                "http://www.csot.tcl.com/ESB_GYD_GYD_InquiryHasCaptchaSrv/1.0",
                                "TOTAL_RECORD").equals(reader.getName())) {
                        nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                                "nil");

                        if (!"true".equals(nillableValue) &&
                                !"1".equals(nillableValue)) {
                            java.lang.String content = reader.getElementText();

                            object.setTOTAL_RECORD(org.apache.axis2.databinding.utils.ConverterUtil.convertToDecimal(
                                    content));
                        } else {
                            reader.getElementText(); // throw away text nodes if any.
                        }

                        reader.next();
                    } // End of if for expected property start element

                    else {
                        // A start element we are not expecting indicates an invalid parameter was passed
                        throw new org.apache.axis2.databinding.ADBException(
                            "Unexpected subelement " + reader.getName());
                    }

                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();

                    if (reader.isStartElement() &&
                            new javax.xml.namespace.QName(
                                "http://www.csot.tcl.com/ESB_GYD_GYD_InquiryHasCaptchaSrv/1.0",
                                "TOTAL_PAGE").equals(reader.getName())) {
                        nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                                "nil");

                        if (!"true".equals(nillableValue) &&
                                !"1".equals(nillableValue)) {
                            java.lang.String content = reader.getElementText();

                            object.setTOTAL_PAGE(org.apache.axis2.databinding.utils.ConverterUtil.convertToDecimal(
                                    content));
                        } else {
                            reader.getElementText(); // throw away text nodes if any.
                        }

                        reader.next();
                    } // End of if for expected property start element

                    else {
                        // A start element we are not expecting indicates an invalid parameter was passed
                        throw new org.apache.axis2.databinding.ADBException(
                            "Unexpected subelement " + reader.getName());
                    }

                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();

                    if (reader.isStartElement() &&
                            new javax.xml.namespace.QName(
                                "http://www.csot.tcl.com/ESB_GYD_GYD_InquiryHasCaptchaSrv/1.0",
                                "PAGE_SIZE").equals(reader.getName())) {
                        nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                                "nil");

                        if (!"true".equals(nillableValue) &&
                                !"1".equals(nillableValue)) {
                            java.lang.String content = reader.getElementText();

                            object.setPAGE_SIZE(org.apache.axis2.databinding.utils.ConverterUtil.convertToDecimal(
                                    content));
                        } else {
                            reader.getElementText(); // throw away text nodes if any.
                        }

                        reader.next();
                    } // End of if for expected property start element

                    else {
                        // A start element we are not expecting indicates an invalid parameter was passed
                        throw new org.apache.axis2.databinding.ADBException(
                            "Unexpected subelement " + reader.getName());
                    }

                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();

                    if (reader.isStartElement() &&
                            new javax.xml.namespace.QName(
                                "http://www.csot.tcl.com/ESB_GYD_GYD_InquiryHasCaptchaSrv/1.0",
                                "CURRENT_PAGE").equals(reader.getName())) {
                        nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                                "nil");

                        if (!"true".equals(nillableValue) &&
                                !"1".equals(nillableValue)) {
                            java.lang.String content = reader.getElementText();

                            object.setCURRENT_PAGE(org.apache.axis2.databinding.utils.ConverterUtil.convertToDecimal(
                                    content));
                        } else {
                            reader.getElementText(); // throw away text nodes if any.
                        }

                        reader.next();
                    } // End of if for expected property start element

                    else {
                        // A start element we are not expecting indicates an invalid parameter was passed
                        throw new org.apache.axis2.databinding.ADBException(
                            "Unexpected subelement " + reader.getName());
                    }

                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();

                    if (reader.isStartElement() &&
                            new javax.xml.namespace.QName(
                                "http://www.csot.tcl.com/ESB_GYD_GYD_InquiryHasCaptchaSrv/1.0",
                                "ESB_GYD_GYD_InquiryHasCaptchaSrvOutputCollection").equals(
                                reader.getName())) {
                        object.setESB_GYD_GYD_InquiryHasCaptchaSrvOutputCollection(ESB_GYD_GYD_InquiryHasCaptchaSrvOutputCollection.Factory.parse(
                                reader));

                        reader.next();
                    } // End of if for expected property start element

                    else {
                        // A start element we are not expecting indicates an invalid parameter was passed
                        throw new org.apache.axis2.databinding.ADBException(
                            "Unexpected subelement " + reader.getName());
                    }

                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();

                    if (reader.isStartElement()) {
                        // A start element we are not expecting indicates a trailing invalid property
                        throw new org.apache.axis2.databinding.ADBException(
                            "Unexpected subelement " + reader.getName());
                    }
                } catch (javax.xml.stream.XMLStreamException e) {
                    throw new java.lang.Exception(e);
                }

                return object;
            }
        } //end of factory class
    }

    public static class ESB_GYD_GYD_InquiryHasCaptchaSrvOutputItem implements org.apache.axis2.databinding.ADBBean {
        /* This type was generated from the piece of schema that had
           name = ESB_GYD_GYD_InquiryHasCaptchaSrvOutputItem
           Namespace URI = http://www.csot.tcl.com/ESB_GYD_GYD_InquiryHasCaptchaSrv/1.0
           Namespace Prefix = ns2
         */

        /**
         * field for CONTENT_TYPE
         */
        protected java.lang.String localCONTENT_TYPE;

        /**
         * field for CONTENT_LENGTH
         */
        protected java.math.BigDecimal localCONTENT_LENGTH;

        /**
         * field for BINARY_CONTENT
         */
        protected javax.activation.DataHandler localBINARY_CONTENT;

        /**
         * field for ASCII_CONTENT
         */
        protected java.lang.String localASCII_CONTENT;

        /**
         * field for RESERVED_1
         */
        protected java.lang.String localRESERVED_1;

        /**
         * field for RESERVED_2
         */
        protected java.lang.String localRESERVED_2;

        /**
         * field for RESERVED_3
         */
        protected java.lang.String localRESERVED_3;

        /**
         * field for RESERVED_4
         */
        protected java.lang.String localRESERVED_4;

        /**
         * field for RESERVED_5
         */
        protected java.lang.String localRESERVED_5;

        /**
         * field for RESERVED_6
         */
        protected java.lang.String localRESERVED_6;

        /**
         * field for RESERVED_7
         */
        protected java.lang.String localRESERVED_7;

        /**
         * field for RESERVED_8
         */
        protected java.lang.String localRESERVED_8;

        /**
         * field for RESERVED_9
         */
        protected java.lang.String localRESERVED_9;

        /**
         * field for RESERVED_10
         */
        protected java.lang.String localRESERVED_10;

        /**
         * Auto generated getter method
         * @return java.lang.String
         */
        public java.lang.String getCONTENT_TYPE() {
            return localCONTENT_TYPE;
        }

        /**
         * Auto generated setter method
         * @param param CONTENT_TYPE
         */
        public void setCONTENT_TYPE(java.lang.String param) {
            this.localCONTENT_TYPE = param;
        }

        /**
         * Auto generated getter method
         * @return java.math.BigDecimal
         */
        public java.math.BigDecimal getCONTENT_LENGTH() {
            return localCONTENT_LENGTH;
        }

        /**
         * Auto generated setter method
         * @param param CONTENT_LENGTH
         */
        public void setCONTENT_LENGTH(java.math.BigDecimal param) {
            this.localCONTENT_LENGTH = param;
        }

        /**
         * Auto generated getter method
         * @return javax.activation.DataHandler
         */
        public javax.activation.DataHandler getBINARY_CONTENT() {
            return localBINARY_CONTENT;
        }

        /**
         * Auto generated setter method
         * @param param BINARY_CONTENT
         */
        public void setBINARY_CONTENT(javax.activation.DataHandler param) {
            this.localBINARY_CONTENT = param;
        }

        /**
         * Auto generated getter method
         * @return java.lang.String
         */
        public java.lang.String getASCII_CONTENT() {
            return localASCII_CONTENT;
        }

        /**
         * Auto generated setter method
         * @param param ASCII_CONTENT
         */
        public void setASCII_CONTENT(java.lang.String param) {
            this.localASCII_CONTENT = param;
        }

        /**
         * Auto generated getter method
         * @return java.lang.String
         */
        public java.lang.String getRESERVED_1() {
            return localRESERVED_1;
        }

        /**
         * Auto generated setter method
         * @param param RESERVED_1
         */
        public void setRESERVED_1(java.lang.String param) {
            this.localRESERVED_1 = param;
        }

        /**
         * Auto generated getter method
         * @return java.lang.String
         */
        public java.lang.String getRESERVED_2() {
            return localRESERVED_2;
        }

        /**
         * Auto generated setter method
         * @param param RESERVED_2
         */
        public void setRESERVED_2(java.lang.String param) {
            this.localRESERVED_2 = param;
        }

        /**
         * Auto generated getter method
         * @return java.lang.String
         */
        public java.lang.String getRESERVED_3() {
            return localRESERVED_3;
        }

        /**
         * Auto generated setter method
         * @param param RESERVED_3
         */
        public void setRESERVED_3(java.lang.String param) {
            this.localRESERVED_3 = param;
        }

        /**
         * Auto generated getter method
         * @return java.lang.String
         */
        public java.lang.String getRESERVED_4() {
            return localRESERVED_4;
        }

        /**
         * Auto generated setter method
         * @param param RESERVED_4
         */
        public void setRESERVED_4(java.lang.String param) {
            this.localRESERVED_4 = param;
        }

        /**
         * Auto generated getter method
         * @return java.lang.String
         */
        public java.lang.String getRESERVED_5() {
            return localRESERVED_5;
        }

        /**
         * Auto generated setter method
         * @param param RESERVED_5
         */
        public void setRESERVED_5(java.lang.String param) {
            this.localRESERVED_5 = param;
        }

        /**
         * Auto generated getter method
         * @return java.lang.String
         */
        public java.lang.String getRESERVED_6() {
            return localRESERVED_6;
        }

        /**
         * Auto generated setter method
         * @param param RESERVED_6
         */
        public void setRESERVED_6(java.lang.String param) {
            this.localRESERVED_6 = param;
        }

        /**
         * Auto generated getter method
         * @return java.lang.String
         */
        public java.lang.String getRESERVED_7() {
            return localRESERVED_7;
        }

        /**
         * Auto generated setter method
         * @param param RESERVED_7
         */
        public void setRESERVED_7(java.lang.String param) {
            this.localRESERVED_7 = param;
        }

        /**
         * Auto generated getter method
         * @return java.lang.String
         */
        public java.lang.String getRESERVED_8() {
            return localRESERVED_8;
        }

        /**
         * Auto generated setter method
         * @param param RESERVED_8
         */
        public void setRESERVED_8(java.lang.String param) {
            this.localRESERVED_8 = param;
        }

        /**
         * Auto generated getter method
         * @return java.lang.String
         */
        public java.lang.String getRESERVED_9() {
            return localRESERVED_9;
        }

        /**
         * Auto generated setter method
         * @param param RESERVED_9
         */
        public void setRESERVED_9(java.lang.String param) {
            this.localRESERVED_9 = param;
        }

        /**
         * Auto generated getter method
         * @return java.lang.String
         */
        public java.lang.String getRESERVED_10() {
            return localRESERVED_10;
        }

        /**
         * Auto generated setter method
         * @param param RESERVED_10
         */
        public void setRESERVED_10(java.lang.String param) {
            this.localRESERVED_10 = param;
        }

        /**
         *
         * @param parentQName
         * @param factory
         * @return org.apache.axiom.om.OMElement
         */
        public org.apache.axiom.om.OMElement getOMElement(
            final javax.xml.namespace.QName parentQName,
            final org.apache.axiom.om.OMFactory factory)
            throws org.apache.axis2.databinding.ADBException {
            org.apache.axiom.om.OMDataSource dataSource = new org.apache.axis2.databinding.ADBDataSource(this,
                    parentQName);

            return factory.createOMElement(dataSource, parentQName);
        }

        public void serialize(final javax.xml.namespace.QName parentQName,
            javax.xml.stream.XMLStreamWriter xmlWriter)
            throws javax.xml.stream.XMLStreamException,
                org.apache.axis2.databinding.ADBException {
            serialize(parentQName, xmlWriter, false);
        }

        public void serialize(final javax.xml.namespace.QName parentQName,
            javax.xml.stream.XMLStreamWriter xmlWriter, boolean serializeType)
            throws javax.xml.stream.XMLStreamException,
                org.apache.axis2.databinding.ADBException {
            java.lang.String prefix = null;
            java.lang.String namespace = null;

            prefix = parentQName.getPrefix();
            namespace = parentQName.getNamespaceURI();
            writeStartElement(prefix, namespace, parentQName.getLocalPart(),
                xmlWriter);

            if (serializeType) {
                java.lang.String namespacePrefix = registerPrefix(xmlWriter,
                        "http://www.csot.tcl.com/ESB_GYD_GYD_InquiryHasCaptchaSrv/1.0");

                if ((namespacePrefix != null) &&
                        (namespacePrefix.trim().length() > 0)) {
                    writeAttribute("xsi",
                        "http://www.w3.org/2001/XMLSchema-instance", "type",
                        namespacePrefix +
                        ":ESB_GYD_GYD_InquiryHasCaptchaSrvOutputItem", xmlWriter);
                } else {
                    writeAttribute("xsi",
                        "http://www.w3.org/2001/XMLSchema-instance", "type",
                        "ESB_GYD_GYD_InquiryHasCaptchaSrvOutputItem", xmlWriter);
                }
            }

            namespace = "http://www.csot.tcl.com/ESB_GYD_GYD_InquiryHasCaptchaSrv/1.0";
            writeStartElement(null, namespace, "CONTENT_TYPE", xmlWriter);

            if (localCONTENT_TYPE == null) {
                // write the nil attribute
                writeAttribute("xsi",
                    "http://www.w3.org/2001/XMLSchema-instance", "nil", "1",
                    xmlWriter);
            } else {
                xmlWriter.writeCharacters(localCONTENT_TYPE);
            }

            xmlWriter.writeEndElement();

            namespace = "http://www.csot.tcl.com/ESB_GYD_GYD_InquiryHasCaptchaSrv/1.0";
            writeStartElement(null, namespace, "CONTENT_LENGTH", xmlWriter);

            if (localCONTENT_LENGTH == null) {
                // write the nil attribute
                writeAttribute("xsi",
                    "http://www.w3.org/2001/XMLSchema-instance", "nil", "1",
                    xmlWriter);
            } else {
                xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                        localCONTENT_LENGTH));
            }

            xmlWriter.writeEndElement();

            namespace = "http://www.csot.tcl.com/ESB_GYD_GYD_InquiryHasCaptchaSrv/1.0";
            writeStartElement(null, namespace, "BINARY_CONTENT", xmlWriter);

            if (localBINARY_CONTENT != null) {
                try {
                    org.apache.axiom.util.stax.XMLStreamWriterUtils.writeDataHandler(xmlWriter,
                        localBINARY_CONTENT, null, true);
                } catch (java.io.IOException ex) {
                    throw new javax.xml.stream.XMLStreamException("Unable to read data handler for BINARY_CONTENT",
                        ex);
                }
            } else {
                writeAttribute("xsi",
                    "http://www.w3.org/2001/XMLSchema-instance", "nil", "1",
                    xmlWriter);
            }

            xmlWriter.writeEndElement();

            namespace = "http://www.csot.tcl.com/ESB_GYD_GYD_InquiryHasCaptchaSrv/1.0";
            writeStartElement(null, namespace, "ASCII_CONTENT", xmlWriter);

            if (localASCII_CONTENT == null) {
                // write the nil attribute
                writeAttribute("xsi",
                    "http://www.w3.org/2001/XMLSchema-instance", "nil", "1",
                    xmlWriter);
            } else {
                xmlWriter.writeCharacters(localASCII_CONTENT);
            }

            xmlWriter.writeEndElement();

            namespace = "http://www.csot.tcl.com/ESB_GYD_GYD_InquiryHasCaptchaSrv/1.0";
            writeStartElement(null, namespace, "RESERVED_1", xmlWriter);

            if (localRESERVED_1 == null) {
                // write the nil attribute
                writeAttribute("xsi",
                    "http://www.w3.org/2001/XMLSchema-instance", "nil", "1",
                    xmlWriter);
            } else {
                xmlWriter.writeCharacters(localRESERVED_1);
            }

            xmlWriter.writeEndElement();

            namespace = "http://www.csot.tcl.com/ESB_GYD_GYD_InquiryHasCaptchaSrv/1.0";
            writeStartElement(null, namespace, "RESERVED_2", xmlWriter);

            if (localRESERVED_2 == null) {
                // write the nil attribute
                writeAttribute("xsi",
                    "http://www.w3.org/2001/XMLSchema-instance", "nil", "1",
                    xmlWriter);
            } else {
                xmlWriter.writeCharacters(localRESERVED_2);
            }

            xmlWriter.writeEndElement();

            namespace = "http://www.csot.tcl.com/ESB_GYD_GYD_InquiryHasCaptchaSrv/1.0";
            writeStartElement(null, namespace, "RESERVED_3", xmlWriter);

            if (localRESERVED_3 == null) {
                // write the nil attribute
                writeAttribute("xsi",
                    "http://www.w3.org/2001/XMLSchema-instance", "nil", "1",
                    xmlWriter);
            } else {
                xmlWriter.writeCharacters(localRESERVED_3);
            }

            xmlWriter.writeEndElement();

            namespace = "http://www.csot.tcl.com/ESB_GYD_GYD_InquiryHasCaptchaSrv/1.0";
            writeStartElement(null, namespace, "RESERVED_4", xmlWriter);

            if (localRESERVED_4 == null) {
                // write the nil attribute
                writeAttribute("xsi",
                    "http://www.w3.org/2001/XMLSchema-instance", "nil", "1",
                    xmlWriter);
            } else {
                xmlWriter.writeCharacters(localRESERVED_4);
            }

            xmlWriter.writeEndElement();

            namespace = "http://www.csot.tcl.com/ESB_GYD_GYD_InquiryHasCaptchaSrv/1.0";
            writeStartElement(null, namespace, "RESERVED_5", xmlWriter);

            if (localRESERVED_5 == null) {
                // write the nil attribute
                writeAttribute("xsi",
                    "http://www.w3.org/2001/XMLSchema-instance", "nil", "1",
                    xmlWriter);
            } else {
                xmlWriter.writeCharacters(localRESERVED_5);
            }

            xmlWriter.writeEndElement();

            namespace = "http://www.csot.tcl.com/ESB_GYD_GYD_InquiryHasCaptchaSrv/1.0";
            writeStartElement(null, namespace, "RESERVED_6", xmlWriter);

            if (localRESERVED_6 == null) {
                // write the nil attribute
                writeAttribute("xsi",
                    "http://www.w3.org/2001/XMLSchema-instance", "nil", "1",
                    xmlWriter);
            } else {
                xmlWriter.writeCharacters(localRESERVED_6);
            }

            xmlWriter.writeEndElement();

            namespace = "http://www.csot.tcl.com/ESB_GYD_GYD_InquiryHasCaptchaSrv/1.0";
            writeStartElement(null, namespace, "RESERVED_7", xmlWriter);

            if (localRESERVED_7 == null) {
                // write the nil attribute
                writeAttribute("xsi",
                    "http://www.w3.org/2001/XMLSchema-instance", "nil", "1",
                    xmlWriter);
            } else {
                xmlWriter.writeCharacters(localRESERVED_7);
            }

            xmlWriter.writeEndElement();

            namespace = "http://www.csot.tcl.com/ESB_GYD_GYD_InquiryHasCaptchaSrv/1.0";
            writeStartElement(null, namespace, "RESERVED_8", xmlWriter);

            if (localRESERVED_8 == null) {
                // write the nil attribute
                writeAttribute("xsi",
                    "http://www.w3.org/2001/XMLSchema-instance", "nil", "1",
                    xmlWriter);
            } else {
                xmlWriter.writeCharacters(localRESERVED_8);
            }

            xmlWriter.writeEndElement();

            namespace = "http://www.csot.tcl.com/ESB_GYD_GYD_InquiryHasCaptchaSrv/1.0";
            writeStartElement(null, namespace, "RESERVED_9", xmlWriter);

            if (localRESERVED_9 == null) {
                // write the nil attribute
                writeAttribute("xsi",
                    "http://www.w3.org/2001/XMLSchema-instance", "nil", "1",
                    xmlWriter);
            } else {
                xmlWriter.writeCharacters(localRESERVED_9);
            }

            xmlWriter.writeEndElement();

            namespace = "http://www.csot.tcl.com/ESB_GYD_GYD_InquiryHasCaptchaSrv/1.0";
            writeStartElement(null, namespace, "RESERVED_10", xmlWriter);

            if (localRESERVED_10 == null) {
                // write the nil attribute
                writeAttribute("xsi",
                    "http://www.w3.org/2001/XMLSchema-instance", "nil", "1",
                    xmlWriter);
            } else {
                xmlWriter.writeCharacters(localRESERVED_10);
            }

            xmlWriter.writeEndElement();

            xmlWriter.writeEndElement();
        }

        private static java.lang.String generatePrefix(
            java.lang.String namespace) {
            if (namespace.equals(
                        "http://www.csot.tcl.com/ESB_GYD_GYD_InquiryHasCaptchaSrv/1.0")) {
                return "ns2";
            }

            return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
        }

        /**
         * Utility method to write an element start tag.
         */
        private void writeStartElement(java.lang.String prefix,
            java.lang.String namespace, java.lang.String localPart,
            javax.xml.stream.XMLStreamWriter xmlWriter)
            throws javax.xml.stream.XMLStreamException {
            java.lang.String writerPrefix = xmlWriter.getPrefix(namespace);

            if (writerPrefix != null) {
                xmlWriter.writeStartElement(namespace, localPart);
            } else {
                if (namespace.length() == 0) {
                    prefix = "";
                } else if (prefix == null) {
                    prefix = generatePrefix(namespace);
                }

                xmlWriter.writeStartElement(prefix, localPart, namespace);
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }
        }

        /**
         * Util method to write an attribute with the ns prefix
         */
        private void writeAttribute(java.lang.String prefix,
            java.lang.String namespace, java.lang.String attName,
            java.lang.String attValue,
            javax.xml.stream.XMLStreamWriter xmlWriter)
            throws javax.xml.stream.XMLStreamException {
            if (xmlWriter.getPrefix(namespace) == null) {
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }

            xmlWriter.writeAttribute(namespace, attName, attValue);
        }

        /**
         * Util method to write an attribute without the ns prefix
         */
        private void writeAttribute(java.lang.String namespace,
            java.lang.String attName, java.lang.String attValue,
            javax.xml.stream.XMLStreamWriter xmlWriter)
            throws javax.xml.stream.XMLStreamException {
            if (namespace.equals("")) {
                xmlWriter.writeAttribute(attName, attValue);
            } else {
                registerPrefix(xmlWriter, namespace);
                xmlWriter.writeAttribute(namespace, attName, attValue);
            }
        }

        /**
         * Util method to write an attribute without the ns prefix
         */
        private void writeQNameAttribute(java.lang.String namespace,
            java.lang.String attName, javax.xml.namespace.QName qname,
            javax.xml.stream.XMLStreamWriter xmlWriter)
            throws javax.xml.stream.XMLStreamException {
            java.lang.String attributeNamespace = qname.getNamespaceURI();
            java.lang.String attributePrefix = xmlWriter.getPrefix(attributeNamespace);

            if (attributePrefix == null) {
                attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
            }

            java.lang.String attributeValue;

            if (attributePrefix.trim().length() > 0) {
                attributeValue = attributePrefix + ":" + qname.getLocalPart();
            } else {
                attributeValue = qname.getLocalPart();
            }

            if (namespace.equals("")) {
                xmlWriter.writeAttribute(attName, attributeValue);
            } else {
                registerPrefix(xmlWriter, namespace);
                xmlWriter.writeAttribute(namespace, attName, attributeValue);
            }
        }

        /**
         *  method to handle Qnames
         */
        private void writeQName(javax.xml.namespace.QName qname,
            javax.xml.stream.XMLStreamWriter xmlWriter)
            throws javax.xml.stream.XMLStreamException {
            java.lang.String namespaceURI = qname.getNamespaceURI();

            if (namespaceURI != null) {
                java.lang.String prefix = xmlWriter.getPrefix(namespaceURI);

                if (prefix == null) {
                    prefix = generatePrefix(namespaceURI);
                    xmlWriter.writeNamespace(prefix, namespaceURI);
                    xmlWriter.setPrefix(prefix, namespaceURI);
                }

                if (prefix.trim().length() > 0) {
                    xmlWriter.writeCharacters(prefix + ":" +
                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                            qname));
                } else {
                    // i.e this is the default namespace
                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                            qname));
                }
            } else {
                xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                        qname));
            }
        }

        private void writeQNames(javax.xml.namespace.QName[] qnames,
            javax.xml.stream.XMLStreamWriter xmlWriter)
            throws javax.xml.stream.XMLStreamException {
            if (qnames != null) {
                // we have to store this data until last moment since it is not possible to write any
                // namespace data after writing the charactor data
                java.lang.StringBuffer stringToWrite = new java.lang.StringBuffer();
                java.lang.String namespaceURI = null;
                java.lang.String prefix = null;

                for (int i = 0; i < qnames.length; i++) {
                    if (i > 0) {
                        stringToWrite.append(" ");
                    }

                    namespaceURI = qnames[i].getNamespaceURI();

                    if (namespaceURI != null) {
                        prefix = xmlWriter.getPrefix(namespaceURI);

                        if ((prefix == null) || (prefix.length() == 0)) {
                            prefix = generatePrefix(namespaceURI);
                            xmlWriter.writeNamespace(prefix, namespaceURI);
                            xmlWriter.setPrefix(prefix, namespaceURI);
                        }

                        if (prefix.trim().length() > 0) {
                            stringToWrite.append(prefix).append(":")
                                         .append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                                    qnames[i]));
                        } else {
                            stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                                    qnames[i]));
                        }
                    } else {
                        stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                                qnames[i]));
                    }
                }

                xmlWriter.writeCharacters(stringToWrite.toString());
            }
        }

        /**
         * Register a namespace prefix
         */
        private java.lang.String registerPrefix(
            javax.xml.stream.XMLStreamWriter xmlWriter,
            java.lang.String namespace)
            throws javax.xml.stream.XMLStreamException {
            java.lang.String prefix = xmlWriter.getPrefix(namespace);

            if (prefix == null) {
                prefix = generatePrefix(namespace);

                javax.xml.namespace.NamespaceContext nsContext = xmlWriter.getNamespaceContext();

                while (true) {
                    java.lang.String uri = nsContext.getNamespaceURI(prefix);

                    if ((uri == null) || (uri.length() == 0)) {
                        break;
                    }

                    prefix = org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
                }

                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }

            return prefix;
        }

        /**
         * databinding method to get an XML representation of this object
         *
         */
        public javax.xml.stream.XMLStreamReader getPullParser(
            javax.xml.namespace.QName qName)
            throws org.apache.axis2.databinding.ADBException {
            java.util.ArrayList elementList = new java.util.ArrayList();
            java.util.ArrayList attribList = new java.util.ArrayList();

            elementList.add(new javax.xml.namespace.QName(
                    "http://www.csot.tcl.com/ESB_GYD_GYD_InquiryHasCaptchaSrv/1.0",
                    "CONTENT_TYPE"));

            elementList.add((localCONTENT_TYPE == null) ? null
                                                        : org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                    localCONTENT_TYPE));

            elementList.add(new javax.xml.namespace.QName(
                    "http://www.csot.tcl.com/ESB_GYD_GYD_InquiryHasCaptchaSrv/1.0",
                    "CONTENT_LENGTH"));

            elementList.add((localCONTENT_LENGTH == null) ? null
                                                          : org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                    localCONTENT_LENGTH));

            elementList.add(new javax.xml.namespace.QName(
                    "http://www.csot.tcl.com/ESB_GYD_GYD_InquiryHasCaptchaSrv/1.0",
                    "BINARY_CONTENT"));

            elementList.add(localBINARY_CONTENT);

            elementList.add(new javax.xml.namespace.QName(
                    "http://www.csot.tcl.com/ESB_GYD_GYD_InquiryHasCaptchaSrv/1.0",
                    "ASCII_CONTENT"));

            elementList.add((localASCII_CONTENT == null) ? null
                                                         : org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                    localASCII_CONTENT));

            elementList.add(new javax.xml.namespace.QName(
                    "http://www.csot.tcl.com/ESB_GYD_GYD_InquiryHasCaptchaSrv/1.0",
                    "RESERVED_1"));

            elementList.add((localRESERVED_1 == null) ? null
                                                      : org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                    localRESERVED_1));

            elementList.add(new javax.xml.namespace.QName(
                    "http://www.csot.tcl.com/ESB_GYD_GYD_InquiryHasCaptchaSrv/1.0",
                    "RESERVED_2"));

            elementList.add((localRESERVED_2 == null) ? null
                                                      : org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                    localRESERVED_2));

            elementList.add(new javax.xml.namespace.QName(
                    "http://www.csot.tcl.com/ESB_GYD_GYD_InquiryHasCaptchaSrv/1.0",
                    "RESERVED_3"));

            elementList.add((localRESERVED_3 == null) ? null
                                                      : org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                    localRESERVED_3));

            elementList.add(new javax.xml.namespace.QName(
                    "http://www.csot.tcl.com/ESB_GYD_GYD_InquiryHasCaptchaSrv/1.0",
                    "RESERVED_4"));

            elementList.add((localRESERVED_4 == null) ? null
                                                      : org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                    localRESERVED_4));

            elementList.add(new javax.xml.namespace.QName(
                    "http://www.csot.tcl.com/ESB_GYD_GYD_InquiryHasCaptchaSrv/1.0",
                    "RESERVED_5"));

            elementList.add((localRESERVED_5 == null) ? null
                                                      : org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                    localRESERVED_5));

            elementList.add(new javax.xml.namespace.QName(
                    "http://www.csot.tcl.com/ESB_GYD_GYD_InquiryHasCaptchaSrv/1.0",
                    "RESERVED_6"));

            elementList.add((localRESERVED_6 == null) ? null
                                                      : org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                    localRESERVED_6));

            elementList.add(new javax.xml.namespace.QName(
                    "http://www.csot.tcl.com/ESB_GYD_GYD_InquiryHasCaptchaSrv/1.0",
                    "RESERVED_7"));

            elementList.add((localRESERVED_7 == null) ? null
                                                      : org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                    localRESERVED_7));

            elementList.add(new javax.xml.namespace.QName(
                    "http://www.csot.tcl.com/ESB_GYD_GYD_InquiryHasCaptchaSrv/1.0",
                    "RESERVED_8"));

            elementList.add((localRESERVED_8 == null) ? null
                                                      : org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                    localRESERVED_8));

            elementList.add(new javax.xml.namespace.QName(
                    "http://www.csot.tcl.com/ESB_GYD_GYD_InquiryHasCaptchaSrv/1.0",
                    "RESERVED_9"));

            elementList.add((localRESERVED_9 == null) ? null
                                                      : org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                    localRESERVED_9));

            elementList.add(new javax.xml.namespace.QName(
                    "http://www.csot.tcl.com/ESB_GYD_GYD_InquiryHasCaptchaSrv/1.0",
                    "RESERVED_10"));

            elementList.add((localRESERVED_10 == null) ? null
                                                       : org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                    localRESERVED_10));

            return new org.apache.axis2.databinding.utils.reader.ADBXMLStreamReaderImpl(qName,
                elementList.toArray(), attribList.toArray());
        }

        /**
         *  Factory class that keeps the parse method
         */
        public static class Factory {
            /**
             * static method to create the object
             * Precondition:  If this object is an element, the current or next start element starts this object and any intervening reader events are ignorable
             *                If this object is not an element, it is a complex type and the reader is at the event just after the outer start element
             * Postcondition: If this object is an element, the reader is positioned at its end element
             *                If this object is a complex type, the reader is positioned at the end element of its outer element
             */
            public static ESB_GYD_GYD_InquiryHasCaptchaSrvOutputItem parse(
                javax.xml.stream.XMLStreamReader reader)
                throws java.lang.Exception {
                ESB_GYD_GYD_InquiryHasCaptchaSrvOutputItem object = new ESB_GYD_GYD_InquiryHasCaptchaSrvOutputItem();

                int event;
                java.lang.String nillableValue = null;
                java.lang.String prefix = "";
                java.lang.String namespaceuri = "";

                try {
                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();

                    if (reader.getAttributeValue(
                                "http://www.w3.org/2001/XMLSchema-instance",
                                "type") != null) {
                        java.lang.String fullTypeName = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                                "type");

                        if (fullTypeName != null) {
                            java.lang.String nsPrefix = null;

                            if (fullTypeName.indexOf(":") > -1) {
                                nsPrefix = fullTypeName.substring(0,
                                        fullTypeName.indexOf(":"));
                            }

                            nsPrefix = (nsPrefix == null) ? "" : nsPrefix;

                            java.lang.String type = fullTypeName.substring(fullTypeName.indexOf(
                                        ":") + 1);

                            if (!"ESB_GYD_GYD_InquiryHasCaptchaSrvOutputItem".equals(
                                        type)) {
                                //find namespace for the prefix
                                java.lang.String nsUri = reader.getNamespaceContext()
                                                               .getNamespaceURI(nsPrefix);

                                return (ESB_GYD_GYD_InquiryHasCaptchaSrvOutputItem) ExtensionMapper.getTypeObject(nsUri,
                                    type, reader);
                            }
                        }
                    }

                    // Note all attributes that were handled. Used to differ normal attributes
                    // from anyAttributes.
                    java.util.Vector handledAttributes = new java.util.Vector();

                    reader.next();

                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();

                    if (reader.isStartElement() &&
                            new javax.xml.namespace.QName(
                                "http://www.csot.tcl.com/ESB_GYD_GYD_InquiryHasCaptchaSrv/1.0",
                                "CONTENT_TYPE").equals(reader.getName())) {
                        nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                                "nil");

                        if (!"true".equals(nillableValue) &&
                                !"1".equals(nillableValue)) {
                            java.lang.String content = reader.getElementText();

                            object.setCONTENT_TYPE(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                                    content));
                        } else {
                            reader.getElementText(); // throw away text nodes if any.
                        }

                        reader.next();
                    } // End of if for expected property start element

                    else {
                        // A start element we are not expecting indicates an invalid parameter was passed
                        throw new org.apache.axis2.databinding.ADBException(
                            "Unexpected subelement " + reader.getName());
                    }

                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();

                    if (reader.isStartElement() &&
                            new javax.xml.namespace.QName(
                                "http://www.csot.tcl.com/ESB_GYD_GYD_InquiryHasCaptchaSrv/1.0",
                                "CONTENT_LENGTH").equals(reader.getName())) {
                        nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                                "nil");

                        if (!"true".equals(nillableValue) &&
                                !"1".equals(nillableValue)) {
                            java.lang.String content = reader.getElementText();

                            object.setCONTENT_LENGTH(org.apache.axis2.databinding.utils.ConverterUtil.convertToDecimal(
                                    content));
                        } else {
                            reader.getElementText(); // throw away text nodes if any.
                        }

                        reader.next();
                    } // End of if for expected property start element

                    else {
                        // A start element we are not expecting indicates an invalid parameter was passed
                        throw new org.apache.axis2.databinding.ADBException(
                            "Unexpected subelement " + reader.getName());
                    }

                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();

                    if (reader.isStartElement() &&
                            new javax.xml.namespace.QName(
                                "http://www.csot.tcl.com/ESB_GYD_GYD_InquiryHasCaptchaSrv/1.0",
                                "BINARY_CONTENT").equals(reader.getName())) {
                        nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                                "nil");

                        if ("true".equals(nillableValue) ||
                                "1".equals(nillableValue)) {
                            object.setBINARY_CONTENT(null);
                            reader.next();
                        } else {
                            object.setBINARY_CONTENT(org.apache.axiom.util.stax.XMLStreamReaderUtils.getDataHandlerFromElement(
                                    reader));
                        }

                        reader.next();
                    } // End of if for expected property start element

                    else {
                        // A start element we are not expecting indicates an invalid parameter was passed
                        throw new org.apache.axis2.databinding.ADBException(
                            "Unexpected subelement " + reader.getName());
                    }

                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();

                    if (reader.isStartElement() &&
                            new javax.xml.namespace.QName(
                                "http://www.csot.tcl.com/ESB_GYD_GYD_InquiryHasCaptchaSrv/1.0",
                                "ASCII_CONTENT").equals(reader.getName())) {
                        nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                                "nil");

                        if (!"true".equals(nillableValue) &&
                                !"1".equals(nillableValue)) {
                            java.lang.String content = reader.getElementText();

                            object.setASCII_CONTENT(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                                    content));
                        } else {
                            reader.getElementText(); // throw away text nodes if any.
                        }

                        reader.next();
                    } // End of if for expected property start element

                    else {
                        // A start element we are not expecting indicates an invalid parameter was passed
                        throw new org.apache.axis2.databinding.ADBException(
                            "Unexpected subelement " + reader.getName());
                    }

                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();

                    if (reader.isStartElement() &&
                            new javax.xml.namespace.QName(
                                "http://www.csot.tcl.com/ESB_GYD_GYD_InquiryHasCaptchaSrv/1.0",
                                "RESERVED_1").equals(reader.getName())) {
                        nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                                "nil");

                        if (!"true".equals(nillableValue) &&
                                !"1".equals(nillableValue)) {
                            java.lang.String content = reader.getElementText();

                            object.setRESERVED_1(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                                    content));
                        } else {
                            reader.getElementText(); // throw away text nodes if any.
                        }

                        reader.next();
                    } // End of if for expected property start element

                    else {
                        // A start element we are not expecting indicates an invalid parameter was passed
                        throw new org.apache.axis2.databinding.ADBException(
                            "Unexpected subelement " + reader.getName());
                    }

                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();

                    if (reader.isStartElement() &&
                            new javax.xml.namespace.QName(
                                "http://www.csot.tcl.com/ESB_GYD_GYD_InquiryHasCaptchaSrv/1.0",
                                "RESERVED_2").equals(reader.getName())) {
                        nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                                "nil");

                        if (!"true".equals(nillableValue) &&
                                !"1".equals(nillableValue)) {
                            java.lang.String content = reader.getElementText();

                            object.setRESERVED_2(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                                    content));
                        } else {
                            reader.getElementText(); // throw away text nodes if any.
                        }

                        reader.next();
                    } // End of if for expected property start element

                    else {
                        // A start element we are not expecting indicates an invalid parameter was passed
                        throw new org.apache.axis2.databinding.ADBException(
                            "Unexpected subelement " + reader.getName());
                    }

                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();

                    if (reader.isStartElement() &&
                            new javax.xml.namespace.QName(
                                "http://www.csot.tcl.com/ESB_GYD_GYD_InquiryHasCaptchaSrv/1.0",
                                "RESERVED_3").equals(reader.getName())) {
                        nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                                "nil");

                        if (!"true".equals(nillableValue) &&
                                !"1".equals(nillableValue)) {
                            java.lang.String content = reader.getElementText();

                            object.setRESERVED_3(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                                    content));
                        } else {
                            reader.getElementText(); // throw away text nodes if any.
                        }

                        reader.next();
                    } // End of if for expected property start element

                    else {
                        // A start element we are not expecting indicates an invalid parameter was passed
                        throw new org.apache.axis2.databinding.ADBException(
                            "Unexpected subelement " + reader.getName());
                    }

                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();

                    if (reader.isStartElement() &&
                            new javax.xml.namespace.QName(
                                "http://www.csot.tcl.com/ESB_GYD_GYD_InquiryHasCaptchaSrv/1.0",
                                "RESERVED_4").equals(reader.getName())) {
                        nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                                "nil");

                        if (!"true".equals(nillableValue) &&
                                !"1".equals(nillableValue)) {
                            java.lang.String content = reader.getElementText();

                            object.setRESERVED_4(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                                    content));
                        } else {
                            reader.getElementText(); // throw away text nodes if any.
                        }

                        reader.next();
                    } // End of if for expected property start element

                    else {
                        // A start element we are not expecting indicates an invalid parameter was passed
                        throw new org.apache.axis2.databinding.ADBException(
                            "Unexpected subelement " + reader.getName());
                    }

                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();

                    if (reader.isStartElement() &&
                            new javax.xml.namespace.QName(
                                "http://www.csot.tcl.com/ESB_GYD_GYD_InquiryHasCaptchaSrv/1.0",
                                "RESERVED_5").equals(reader.getName())) {
                        nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                                "nil");

                        if (!"true".equals(nillableValue) &&
                                !"1".equals(nillableValue)) {
                            java.lang.String content = reader.getElementText();

                            object.setRESERVED_5(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                                    content));
                        } else {
                            reader.getElementText(); // throw away text nodes if any.
                        }

                        reader.next();
                    } // End of if for expected property start element

                    else {
                        // A start element we are not expecting indicates an invalid parameter was passed
                        throw new org.apache.axis2.databinding.ADBException(
                            "Unexpected subelement " + reader.getName());
                    }

                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();

                    if (reader.isStartElement() &&
                            new javax.xml.namespace.QName(
                                "http://www.csot.tcl.com/ESB_GYD_GYD_InquiryHasCaptchaSrv/1.0",
                                "RESERVED_6").equals(reader.getName())) {
                        nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                                "nil");

                        if (!"true".equals(nillableValue) &&
                                !"1".equals(nillableValue)) {
                            java.lang.String content = reader.getElementText();

                            object.setRESERVED_6(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                                    content));
                        } else {
                            reader.getElementText(); // throw away text nodes if any.
                        }

                        reader.next();
                    } // End of if for expected property start element

                    else {
                        // A start element we are not expecting indicates an invalid parameter was passed
                        throw new org.apache.axis2.databinding.ADBException(
                            "Unexpected subelement " + reader.getName());
                    }

                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();

                    if (reader.isStartElement() &&
                            new javax.xml.namespace.QName(
                                "http://www.csot.tcl.com/ESB_GYD_GYD_InquiryHasCaptchaSrv/1.0",
                                "RESERVED_7").equals(reader.getName())) {
                        nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                                "nil");

                        if (!"true".equals(nillableValue) &&
                                !"1".equals(nillableValue)) {
                            java.lang.String content = reader.getElementText();

                            object.setRESERVED_7(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                                    content));
                        } else {
                            reader.getElementText(); // throw away text nodes if any.
                        }

                        reader.next();
                    } // End of if for expected property start element

                    else {
                        // A start element we are not expecting indicates an invalid parameter was passed
                        throw new org.apache.axis2.databinding.ADBException(
                            "Unexpected subelement " + reader.getName());
                    }

                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();

                    if (reader.isStartElement() &&
                            new javax.xml.namespace.QName(
                                "http://www.csot.tcl.com/ESB_GYD_GYD_InquiryHasCaptchaSrv/1.0",
                                "RESERVED_8").equals(reader.getName())) {
                        nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                                "nil");

                        if (!"true".equals(nillableValue) &&
                                !"1".equals(nillableValue)) {
                            java.lang.String content = reader.getElementText();

                            object.setRESERVED_8(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                                    content));
                        } else {
                            reader.getElementText(); // throw away text nodes if any.
                        }

                        reader.next();
                    } // End of if for expected property start element

                    else {
                        // A start element we are not expecting indicates an invalid parameter was passed
                        throw new org.apache.axis2.databinding.ADBException(
                            "Unexpected subelement " + reader.getName());
                    }

                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();

                    if (reader.isStartElement() &&
                            new javax.xml.namespace.QName(
                                "http://www.csot.tcl.com/ESB_GYD_GYD_InquiryHasCaptchaSrv/1.0",
                                "RESERVED_9").equals(reader.getName())) {
                        nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                                "nil");

                        if (!"true".equals(nillableValue) &&
                                !"1".equals(nillableValue)) {
                            java.lang.String content = reader.getElementText();

                            object.setRESERVED_9(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                                    content));
                        } else {
                            reader.getElementText(); // throw away text nodes if any.
                        }

                        reader.next();
                    } // End of if for expected property start element

                    else {
                        // A start element we are not expecting indicates an invalid parameter was passed
                        throw new org.apache.axis2.databinding.ADBException(
                            "Unexpected subelement " + reader.getName());
                    }

                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();

                    if (reader.isStartElement() &&
                            new javax.xml.namespace.QName(
                                "http://www.csot.tcl.com/ESB_GYD_GYD_InquiryHasCaptchaSrv/1.0",
                                "RESERVED_10").equals(reader.getName())) {
                        nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                                "nil");

                        if (!"true".equals(nillableValue) &&
                                !"1".equals(nillableValue)) {
                            java.lang.String content = reader.getElementText();

                            object.setRESERVED_10(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                                    content));
                        } else {
                            reader.getElementText(); // throw away text nodes if any.
                        }

                        reader.next();
                    } // End of if for expected property start element

                    else {
                        // A start element we are not expecting indicates an invalid parameter was passed
                        throw new org.apache.axis2.databinding.ADBException(
                            "Unexpected subelement " + reader.getName());
                    }

                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();

                    if (reader.isStartElement()) {
                        // A start element we are not expecting indicates a trailing invalid property
                        throw new org.apache.axis2.databinding.ADBException(
                            "Unexpected subelement " + reader.getName());
                    }
                } catch (javax.xml.stream.XMLStreamException e) {
                    throw new java.lang.Exception(e);
                }

                return object;
            }
        } //end of factory class
    }

    public static class ESB_GYD_GYD_InquiryHasCaptchaSrvOutputCollection
        implements org.apache.axis2.databinding.ADBBean {
        /* This type was generated from the piece of schema that had
           name = ESB_GYD_GYD_InquiryHasCaptchaSrvOutputCollection
           Namespace URI = http://www.csot.tcl.com/ESB_GYD_GYD_InquiryHasCaptchaSrv/1.0
           Namespace Prefix = ns2
         */

        /**
         * field for ESB_GYD_GYD_InquiryHasCaptchaSrvOutputItem
         * This was an Array!
         */
        protected ESB_GYD_GYD_InquiryHasCaptchaSrvOutputItem[] localESB_GYD_GYD_InquiryHasCaptchaSrvOutputItem;

        /*  This tracker boolean wil be used to detect whether the user called the set method
         *   for this attribute. It will be used to determine whether to include this field
         *   in the serialized XML
         */
        protected boolean localESB_GYD_GYD_InquiryHasCaptchaSrvOutputItemTracker =
            false;

        public boolean isESB_GYD_GYD_InquiryHasCaptchaSrvOutputItemSpecified() {
            return localESB_GYD_GYD_InquiryHasCaptchaSrvOutputItemTracker;
        }

        /**
         * Auto generated getter method
         * @return ESB_GYD_GYD_InquiryHasCaptchaSrvOutputItem[]
         */
        public ESB_GYD_GYD_InquiryHasCaptchaSrvOutputItem[] getESB_GYD_GYD_InquiryHasCaptchaSrvOutputItem() {
            return localESB_GYD_GYD_InquiryHasCaptchaSrvOutputItem;
        }

        /**
         * validate the array for ESB_GYD_GYD_InquiryHasCaptchaSrvOutputItem
         */
        protected void validateESB_GYD_GYD_InquiryHasCaptchaSrvOutputItem(
            ESB_GYD_GYD_InquiryHasCaptchaSrvOutputItem[] param) {
        }

        /**
         * Auto generated setter method
         * @param param ESB_GYD_GYD_InquiryHasCaptchaSrvOutputItem
         */
        public void setESB_GYD_GYD_InquiryHasCaptchaSrvOutputItem(
            ESB_GYD_GYD_InquiryHasCaptchaSrvOutputItem[] param) {
            validateESB_GYD_GYD_InquiryHasCaptchaSrvOutputItem(param);

            localESB_GYD_GYD_InquiryHasCaptchaSrvOutputItemTracker = param != null;

            this.localESB_GYD_GYD_InquiryHasCaptchaSrvOutputItem = param;
        }

        /**
         * Auto generated add method for the array for convenience
         * @param param ESB_GYD_GYD_InquiryHasCaptchaSrvOutputItem
         */
        public void addESB_GYD_GYD_InquiryHasCaptchaSrvOutputItem(
            ESB_GYD_GYD_InquiryHasCaptchaSrvOutputItem param) {
            if (localESB_GYD_GYD_InquiryHasCaptchaSrvOutputItem == null) {
                localESB_GYD_GYD_InquiryHasCaptchaSrvOutputItem = new ESB_GYD_GYD_InquiryHasCaptchaSrvOutputItem[] {
                        
                    };
            }

            //update the setting tracker
            localESB_GYD_GYD_InquiryHasCaptchaSrvOutputItemTracker = true;

            java.util.List list = org.apache.axis2.databinding.utils.ConverterUtil.toList(localESB_GYD_GYD_InquiryHasCaptchaSrvOutputItem);
            list.add(param);
            this.localESB_GYD_GYD_InquiryHasCaptchaSrvOutputItem = (ESB_GYD_GYD_InquiryHasCaptchaSrvOutputItem[]) list.toArray(new ESB_GYD_GYD_InquiryHasCaptchaSrvOutputItem[list.size()]);
        }

        /**
         *
         * @param parentQName
         * @param factory
         * @return org.apache.axiom.om.OMElement
         */
        public org.apache.axiom.om.OMElement getOMElement(
            final javax.xml.namespace.QName parentQName,
            final org.apache.axiom.om.OMFactory factory)
            throws org.apache.axis2.databinding.ADBException {
            org.apache.axiom.om.OMDataSource dataSource = new org.apache.axis2.databinding.ADBDataSource(this,
                    parentQName);

            return factory.createOMElement(dataSource, parentQName);
        }

        public void serialize(final javax.xml.namespace.QName parentQName,
            javax.xml.stream.XMLStreamWriter xmlWriter)
            throws javax.xml.stream.XMLStreamException,
                org.apache.axis2.databinding.ADBException {
            serialize(parentQName, xmlWriter, false);
        }

        public void serialize(final javax.xml.namespace.QName parentQName,
            javax.xml.stream.XMLStreamWriter xmlWriter, boolean serializeType)
            throws javax.xml.stream.XMLStreamException,
                org.apache.axis2.databinding.ADBException {
            java.lang.String prefix = null;
            java.lang.String namespace = null;

            prefix = parentQName.getPrefix();
            namespace = parentQName.getNamespaceURI();
            writeStartElement(prefix, namespace, parentQName.getLocalPart(),
                xmlWriter);

            if (serializeType) {
                java.lang.String namespacePrefix = registerPrefix(xmlWriter,
                        "http://www.csot.tcl.com/ESB_GYD_GYD_InquiryHasCaptchaSrv/1.0");

                if ((namespacePrefix != null) &&
                        (namespacePrefix.trim().length() > 0)) {
                    writeAttribute("xsi",
                        "http://www.w3.org/2001/XMLSchema-instance", "type",
                        namespacePrefix +
                        ":ESB_GYD_GYD_InquiryHasCaptchaSrvOutputCollection",
                        xmlWriter);
                } else {
                    writeAttribute("xsi",
                        "http://www.w3.org/2001/XMLSchema-instance", "type",
                        "ESB_GYD_GYD_InquiryHasCaptchaSrvOutputCollection",
                        xmlWriter);
                }
            }

            if (localESB_GYD_GYD_InquiryHasCaptchaSrvOutputItemTracker) {
                if (localESB_GYD_GYD_InquiryHasCaptchaSrvOutputItem != null) {
                    for (int i = 0;
                            i < localESB_GYD_GYD_InquiryHasCaptchaSrvOutputItem.length;
                            i++) {
                        if (localESB_GYD_GYD_InquiryHasCaptchaSrvOutputItem[i] != null) {
                            localESB_GYD_GYD_InquiryHasCaptchaSrvOutputItem[i].serialize(new javax.xml.namespace.QName(
                                    "http://www.csot.tcl.com/ESB_GYD_GYD_InquiryHasCaptchaSrv/1.0",
                                    "ESB_GYD_GYD_InquiryHasCaptchaSrvOutputItem"),
                                xmlWriter);
                        } else {
                            // we don't have to do any thing since minOccures is zero
                        }
                    }
                } else {
                    throw new org.apache.axis2.databinding.ADBException(
                        "ESB_GYD_GYD_InquiryHasCaptchaSrvOutputItem cannot be null!!");
                }
            }

            xmlWriter.writeEndElement();
        }

        private static java.lang.String generatePrefix(
            java.lang.String namespace) {
            if (namespace.equals(
                        "http://www.csot.tcl.com/ESB_GYD_GYD_InquiryHasCaptchaSrv/1.0")) {
                return "ns2";
            }

            return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
        }

        /**
         * Utility method to write an element start tag.
         */
        private void writeStartElement(java.lang.String prefix,
            java.lang.String namespace, java.lang.String localPart,
            javax.xml.stream.XMLStreamWriter xmlWriter)
            throws javax.xml.stream.XMLStreamException {
            java.lang.String writerPrefix = xmlWriter.getPrefix(namespace);

            if (writerPrefix != null) {
                xmlWriter.writeStartElement(namespace, localPart);
            } else {
                if (namespace.length() == 0) {
                    prefix = "";
                } else if (prefix == null) {
                    prefix = generatePrefix(namespace);
                }

                xmlWriter.writeStartElement(prefix, localPart, namespace);
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }
        }

        /**
         * Util method to write an attribute with the ns prefix
         */
        private void writeAttribute(java.lang.String prefix,
            java.lang.String namespace, java.lang.String attName,
            java.lang.String attValue,
            javax.xml.stream.XMLStreamWriter xmlWriter)
            throws javax.xml.stream.XMLStreamException {
            if (xmlWriter.getPrefix(namespace) == null) {
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }

            xmlWriter.writeAttribute(namespace, attName, attValue);
        }

        /**
         * Util method to write an attribute without the ns prefix
         */
        private void writeAttribute(java.lang.String namespace,
            java.lang.String attName, java.lang.String attValue,
            javax.xml.stream.XMLStreamWriter xmlWriter)
            throws javax.xml.stream.XMLStreamException {
            if (namespace.equals("")) {
                xmlWriter.writeAttribute(attName, attValue);
            } else {
                registerPrefix(xmlWriter, namespace);
                xmlWriter.writeAttribute(namespace, attName, attValue);
            }
        }

        /**
         * Util method to write an attribute without the ns prefix
         */
        private void writeQNameAttribute(java.lang.String namespace,
            java.lang.String attName, javax.xml.namespace.QName qname,
            javax.xml.stream.XMLStreamWriter xmlWriter)
            throws javax.xml.stream.XMLStreamException {
            java.lang.String attributeNamespace = qname.getNamespaceURI();
            java.lang.String attributePrefix = xmlWriter.getPrefix(attributeNamespace);

            if (attributePrefix == null) {
                attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
            }

            java.lang.String attributeValue;

            if (attributePrefix.trim().length() > 0) {
                attributeValue = attributePrefix + ":" + qname.getLocalPart();
            } else {
                attributeValue = qname.getLocalPart();
            }

            if (namespace.equals("")) {
                xmlWriter.writeAttribute(attName, attributeValue);
            } else {
                registerPrefix(xmlWriter, namespace);
                xmlWriter.writeAttribute(namespace, attName, attributeValue);
            }
        }

        /**
         *  method to handle Qnames
         */
        private void writeQName(javax.xml.namespace.QName qname,
            javax.xml.stream.XMLStreamWriter xmlWriter)
            throws javax.xml.stream.XMLStreamException {
            java.lang.String namespaceURI = qname.getNamespaceURI();

            if (namespaceURI != null) {
                java.lang.String prefix = xmlWriter.getPrefix(namespaceURI);

                if (prefix == null) {
                    prefix = generatePrefix(namespaceURI);
                    xmlWriter.writeNamespace(prefix, namespaceURI);
                    xmlWriter.setPrefix(prefix, namespaceURI);
                }

                if (prefix.trim().length() > 0) {
                    xmlWriter.writeCharacters(prefix + ":" +
                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                            qname));
                } else {
                    // i.e this is the default namespace
                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                            qname));
                }
            } else {
                xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                        qname));
            }
        }

        private void writeQNames(javax.xml.namespace.QName[] qnames,
            javax.xml.stream.XMLStreamWriter xmlWriter)
            throws javax.xml.stream.XMLStreamException {
            if (qnames != null) {
                // we have to store this data until last moment since it is not possible to write any
                // namespace data after writing the charactor data
                java.lang.StringBuffer stringToWrite = new java.lang.StringBuffer();
                java.lang.String namespaceURI = null;
                java.lang.String prefix = null;

                for (int i = 0; i < qnames.length; i++) {
                    if (i > 0) {
                        stringToWrite.append(" ");
                    }

                    namespaceURI = qnames[i].getNamespaceURI();

                    if (namespaceURI != null) {
                        prefix = xmlWriter.getPrefix(namespaceURI);

                        if ((prefix == null) || (prefix.length() == 0)) {
                            prefix = generatePrefix(namespaceURI);
                            xmlWriter.writeNamespace(prefix, namespaceURI);
                            xmlWriter.setPrefix(prefix, namespaceURI);
                        }

                        if (prefix.trim().length() > 0) {
                            stringToWrite.append(prefix).append(":")
                                         .append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                                    qnames[i]));
                        } else {
                            stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                                    qnames[i]));
                        }
                    } else {
                        stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                                qnames[i]));
                    }
                }

                xmlWriter.writeCharacters(stringToWrite.toString());
            }
        }

        /**
         * Register a namespace prefix
         */
        private java.lang.String registerPrefix(
            javax.xml.stream.XMLStreamWriter xmlWriter,
            java.lang.String namespace)
            throws javax.xml.stream.XMLStreamException {
            java.lang.String prefix = xmlWriter.getPrefix(namespace);

            if (prefix == null) {
                prefix = generatePrefix(namespace);

                javax.xml.namespace.NamespaceContext nsContext = xmlWriter.getNamespaceContext();

                while (true) {
                    java.lang.String uri = nsContext.getNamespaceURI(prefix);

                    if ((uri == null) || (uri.length() == 0)) {
                        break;
                    }

                    prefix = org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
                }

                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }

            return prefix;
        }

        /**
         * databinding method to get an XML representation of this object
         *
         */
        public javax.xml.stream.XMLStreamReader getPullParser(
            javax.xml.namespace.QName qName)
            throws org.apache.axis2.databinding.ADBException {
            java.util.ArrayList elementList = new java.util.ArrayList();
            java.util.ArrayList attribList = new java.util.ArrayList();

            if (localESB_GYD_GYD_InquiryHasCaptchaSrvOutputItemTracker) {
                if (localESB_GYD_GYD_InquiryHasCaptchaSrvOutputItem != null) {
                    for (int i = 0;
                            i < localESB_GYD_GYD_InquiryHasCaptchaSrvOutputItem.length;
                            i++) {
                        if (localESB_GYD_GYD_InquiryHasCaptchaSrvOutputItem[i] != null) {
                            elementList.add(new javax.xml.namespace.QName(
                                    "http://www.csot.tcl.com/ESB_GYD_GYD_InquiryHasCaptchaSrv/1.0",
                                    "ESB_GYD_GYD_InquiryHasCaptchaSrvOutputItem"));
                            elementList.add(localESB_GYD_GYD_InquiryHasCaptchaSrvOutputItem[i]);
                        } else {
                            // nothing to do
                        }
                    }
                } else {
                    throw new org.apache.axis2.databinding.ADBException(
                        "ESB_GYD_GYD_InquiryHasCaptchaSrvOutputItem cannot be null!!");
                }
            }

            return new org.apache.axis2.databinding.utils.reader.ADBXMLStreamReaderImpl(qName,
                elementList.toArray(), attribList.toArray());
        }

        /**
         *  Factory class that keeps the parse method
         */
        public static class Factory {
            /**
             * static method to create the object
             * Precondition:  If this object is an element, the current or next start element starts this object and any intervening reader events are ignorable
             *                If this object is not an element, it is a complex type and the reader is at the event just after the outer start element
             * Postcondition: If this object is an element, the reader is positioned at its end element
             *                If this object is a complex type, the reader is positioned at the end element of its outer element
             */
            public static ESB_GYD_GYD_InquiryHasCaptchaSrvOutputCollection parse(
                javax.xml.stream.XMLStreamReader reader)
                throws java.lang.Exception {
                ESB_GYD_GYD_InquiryHasCaptchaSrvOutputCollection object = new ESB_GYD_GYD_InquiryHasCaptchaSrvOutputCollection();

                int event;
                java.lang.String nillableValue = null;
                java.lang.String prefix = "";
                java.lang.String namespaceuri = "";

                try {
                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();

                    if (reader.getAttributeValue(
                                "http://www.w3.org/2001/XMLSchema-instance",
                                "type") != null) {
                        java.lang.String fullTypeName = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                                "type");

                        if (fullTypeName != null) {
                            java.lang.String nsPrefix = null;

                            if (fullTypeName.indexOf(":") > -1) {
                                nsPrefix = fullTypeName.substring(0,
                                        fullTypeName.indexOf(":"));
                            }

                            nsPrefix = (nsPrefix == null) ? "" : nsPrefix;

                            java.lang.String type = fullTypeName.substring(fullTypeName.indexOf(
                                        ":") + 1);

                            if (!"ESB_GYD_GYD_InquiryHasCaptchaSrvOutputCollection".equals(
                                        type)) {
                                //find namespace for the prefix
                                java.lang.String nsUri = reader.getNamespaceContext()
                                                               .getNamespaceURI(nsPrefix);

                                return (ESB_GYD_GYD_InquiryHasCaptchaSrvOutputCollection) ExtensionMapper.getTypeObject(nsUri,
                                    type, reader);
                            }
                        }
                    }

                    // Note all attributes that were handled. Used to differ normal attributes
                    // from anyAttributes.
                    java.util.Vector handledAttributes = new java.util.Vector();

                    reader.next();

                    java.util.ArrayList list1 = new java.util.ArrayList();

                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();

                    if (reader.isStartElement() &&
                            new javax.xml.namespace.QName(
                                "http://www.csot.tcl.com/ESB_GYD_GYD_InquiryHasCaptchaSrv/1.0",
                                "ESB_GYD_GYD_InquiryHasCaptchaSrvOutputItem").equals(
                                reader.getName())) {
                        // Process the array and step past its final element's end.
                        list1.add(ESB_GYD_GYD_InquiryHasCaptchaSrvOutputItem.Factory.parse(
                                reader));

                        //loop until we find a start element that is not part of this array
                        boolean loopDone1 = false;

                        while (!loopDone1) {
                            // We should be at the end element, but make sure
                            while (!reader.isEndElement())
                                reader.next();

                            // Step out of this element
                            reader.next();

                            // Step to next element event.
                            while (!reader.isStartElement() &&
                                    !reader.isEndElement())
                                reader.next();

                            if (reader.isEndElement()) {
                                //two continuous end elements means we are exiting the xml structure
                                loopDone1 = true;
                            } else {
                                if (new javax.xml.namespace.QName(
                                            "http://www.csot.tcl.com/ESB_GYD_GYD_InquiryHasCaptchaSrv/1.0",
                                            "ESB_GYD_GYD_InquiryHasCaptchaSrvOutputItem").equals(
                                            reader.getName())) {
                                    list1.add(ESB_GYD_GYD_InquiryHasCaptchaSrvOutputItem.Factory.parse(
                                            reader));
                                } else {
                                    loopDone1 = true;
                                }
                            }
                        }

                        // call the converter utility  to convert and set the array
                        object.setESB_GYD_GYD_InquiryHasCaptchaSrvOutputItem((ESB_GYD_GYD_InquiryHasCaptchaSrvOutputItem[]) org.apache.axis2.databinding.utils.ConverterUtil.convertToArray(
                                ESB_GYD_GYD_InquiryHasCaptchaSrvOutputItem.class,
                                list1));
                    } // End of if for expected property start element

                    else {
                    }

                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();

                    if (reader.isStartElement()) {
                        // A start element we are not expecting indicates a trailing invalid property
                        throw new org.apache.axis2.databinding.ADBException(
                            "Unexpected subelement " + reader.getName());
                    }
                } catch (javax.xml.stream.XMLStreamException e) {
                    throw new java.lang.Exception(e);
                }

                return object;
            }
        } //end of factory class
    }

    public static class ESB_GYD_GYD_InquiryHasCaptchaSrvResponseE implements org.apache.axis2.databinding.ADBBean {
        public static final javax.xml.namespace.QName MY_QNAME = new javax.xml.namespace.QName("http://www.csot.tcl.com/ESB_GYD_GYD_InquiryHasCaptchaSrv/1.0",
                "ESB_GYD_GYD_InquiryHasCaptchaSrvResponse", "ns2");

        /**
         * field for ESB_GYD_GYD_InquiryHasCaptchaSrvResponse
         */
        protected ESB_GYD_GYD_InquiryHasCaptchaSrvResponse localESB_GYD_GYD_InquiryHasCaptchaSrvResponse;

        /**
         * Auto generated getter method
         * @return ESB_GYD_GYD_InquiryHasCaptchaSrvResponse
         */
        public ESB_GYD_GYD_InquiryHasCaptchaSrvResponse getESB_GYD_GYD_InquiryHasCaptchaSrvResponse() {
            return localESB_GYD_GYD_InquiryHasCaptchaSrvResponse;
        }

        /**
         * Auto generated setter method
         * @param param ESB_GYD_GYD_InquiryHasCaptchaSrvResponse
         */
        public void setESB_GYD_GYD_InquiryHasCaptchaSrvResponse(
            ESB_GYD_GYD_InquiryHasCaptchaSrvResponse param) {
            this.localESB_GYD_GYD_InquiryHasCaptchaSrvResponse = param;
        }

        /**
         *
         * @param parentQName
         * @param factory
         * @return org.apache.axiom.om.OMElement
         */
        public org.apache.axiom.om.OMElement getOMElement(
            final javax.xml.namespace.QName parentQName,
            final org.apache.axiom.om.OMFactory factory)
            throws org.apache.axis2.databinding.ADBException {
            org.apache.axiom.om.OMDataSource dataSource = new org.apache.axis2.databinding.ADBDataSource(this,
                    MY_QNAME);

            return factory.createOMElement(dataSource, MY_QNAME);
        }

        public void serialize(final javax.xml.namespace.QName parentQName,
            javax.xml.stream.XMLStreamWriter xmlWriter)
            throws javax.xml.stream.XMLStreamException,
                org.apache.axis2.databinding.ADBException {
            serialize(parentQName, xmlWriter, false);
        }

        public void serialize(final javax.xml.namespace.QName parentQName,
            javax.xml.stream.XMLStreamWriter xmlWriter, boolean serializeType)
            throws javax.xml.stream.XMLStreamException,
                org.apache.axis2.databinding.ADBException {
            //We can safely assume an element has only one type associated with it
            if (localESB_GYD_GYD_InquiryHasCaptchaSrvResponse == null) {
                throw new org.apache.axis2.databinding.ADBException(
                    "ESB_GYD_GYD_InquiryHasCaptchaSrvResponse cannot be null!");
            }

            localESB_GYD_GYD_InquiryHasCaptchaSrvResponse.serialize(MY_QNAME,
                xmlWriter);
        }

        private static java.lang.String generatePrefix(
            java.lang.String namespace) {
            if (namespace.equals(
                        "http://www.csot.tcl.com/ESB_GYD_GYD_InquiryHasCaptchaSrv/1.0")) {
                return "ns2";
            }

            return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
        }

        /**
         * Utility method to write an element start tag.
         */
        private void writeStartElement(java.lang.String prefix,
            java.lang.String namespace, java.lang.String localPart,
            javax.xml.stream.XMLStreamWriter xmlWriter)
            throws javax.xml.stream.XMLStreamException {
            java.lang.String writerPrefix = xmlWriter.getPrefix(namespace);

            if (writerPrefix != null) {
                xmlWriter.writeStartElement(namespace, localPart);
            } else {
                if (namespace.length() == 0) {
                    prefix = "";
                } else if (prefix == null) {
                    prefix = generatePrefix(namespace);
                }

                xmlWriter.writeStartElement(prefix, localPart, namespace);
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }
        }

        /**
         * Util method to write an attribute with the ns prefix
         */
        private void writeAttribute(java.lang.String prefix,
            java.lang.String namespace, java.lang.String attName,
            java.lang.String attValue,
            javax.xml.stream.XMLStreamWriter xmlWriter)
            throws javax.xml.stream.XMLStreamException {
            if (xmlWriter.getPrefix(namespace) == null) {
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }

            xmlWriter.writeAttribute(namespace, attName, attValue);
        }

        /**
         * Util method to write an attribute without the ns prefix
         */
        private void writeAttribute(java.lang.String namespace,
            java.lang.String attName, java.lang.String attValue,
            javax.xml.stream.XMLStreamWriter xmlWriter)
            throws javax.xml.stream.XMLStreamException {
            if (namespace.equals("")) {
                xmlWriter.writeAttribute(attName, attValue);
            } else {
                registerPrefix(xmlWriter, namespace);
                xmlWriter.writeAttribute(namespace, attName, attValue);
            }
        }

        /**
         * Util method to write an attribute without the ns prefix
         */
        private void writeQNameAttribute(java.lang.String namespace,
            java.lang.String attName, javax.xml.namespace.QName qname,
            javax.xml.stream.XMLStreamWriter xmlWriter)
            throws javax.xml.stream.XMLStreamException {
            java.lang.String attributeNamespace = qname.getNamespaceURI();
            java.lang.String attributePrefix = xmlWriter.getPrefix(attributeNamespace);

            if (attributePrefix == null) {
                attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
            }

            java.lang.String attributeValue;

            if (attributePrefix.trim().length() > 0) {
                attributeValue = attributePrefix + ":" + qname.getLocalPart();
            } else {
                attributeValue = qname.getLocalPart();
            }

            if (namespace.equals("")) {
                xmlWriter.writeAttribute(attName, attributeValue);
            } else {
                registerPrefix(xmlWriter, namespace);
                xmlWriter.writeAttribute(namespace, attName, attributeValue);
            }
        }

        /**
         *  method to handle Qnames
         */
        private void writeQName(javax.xml.namespace.QName qname,
            javax.xml.stream.XMLStreamWriter xmlWriter)
            throws javax.xml.stream.XMLStreamException {
            java.lang.String namespaceURI = qname.getNamespaceURI();

            if (namespaceURI != null) {
                java.lang.String prefix = xmlWriter.getPrefix(namespaceURI);

                if (prefix == null) {
                    prefix = generatePrefix(namespaceURI);
                    xmlWriter.writeNamespace(prefix, namespaceURI);
                    xmlWriter.setPrefix(prefix, namespaceURI);
                }

                if (prefix.trim().length() > 0) {
                    xmlWriter.writeCharacters(prefix + ":" +
                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                            qname));
                } else {
                    // i.e this is the default namespace
                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                            qname));
                }
            } else {
                xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                        qname));
            }
        }

        private void writeQNames(javax.xml.namespace.QName[] qnames,
            javax.xml.stream.XMLStreamWriter xmlWriter)
            throws javax.xml.stream.XMLStreamException {
            if (qnames != null) {
                // we have to store this data until last moment since it is not possible to write any
                // namespace data after writing the charactor data
                java.lang.StringBuffer stringToWrite = new java.lang.StringBuffer();
                java.lang.String namespaceURI = null;
                java.lang.String prefix = null;

                for (int i = 0; i < qnames.length; i++) {
                    if (i > 0) {
                        stringToWrite.append(" ");
                    }

                    namespaceURI = qnames[i].getNamespaceURI();

                    if (namespaceURI != null) {
                        prefix = xmlWriter.getPrefix(namespaceURI);

                        if ((prefix == null) || (prefix.length() == 0)) {
                            prefix = generatePrefix(namespaceURI);
                            xmlWriter.writeNamespace(prefix, namespaceURI);
                            xmlWriter.setPrefix(prefix, namespaceURI);
                        }

                        if (prefix.trim().length() > 0) {
                            stringToWrite.append(prefix).append(":")
                                         .append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                                    qnames[i]));
                        } else {
                            stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                                    qnames[i]));
                        }
                    } else {
                        stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                                qnames[i]));
                    }
                }

                xmlWriter.writeCharacters(stringToWrite.toString());
            }
        }

        /**
         * Register a namespace prefix
         */
        private java.lang.String registerPrefix(
            javax.xml.stream.XMLStreamWriter xmlWriter,
            java.lang.String namespace)
            throws javax.xml.stream.XMLStreamException {
            java.lang.String prefix = xmlWriter.getPrefix(namespace);

            if (prefix == null) {
                prefix = generatePrefix(namespace);

                javax.xml.namespace.NamespaceContext nsContext = xmlWriter.getNamespaceContext();

                while (true) {
                    java.lang.String uri = nsContext.getNamespaceURI(prefix);

                    if ((uri == null) || (uri.length() == 0)) {
                        break;
                    }

                    prefix = org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
                }

                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }

            return prefix;
        }

        /**
         * databinding method to get an XML representation of this object
         *
         */
        public javax.xml.stream.XMLStreamReader getPullParser(
            javax.xml.namespace.QName qName)
            throws org.apache.axis2.databinding.ADBException {
            //We can safely assume an element has only one type associated with it
            return localESB_GYD_GYD_InquiryHasCaptchaSrvResponse.getPullParser(MY_QNAME);
        }

        /**
         *  Factory class that keeps the parse method
         */
        public static class Factory {
            /**
             * static method to create the object
             * Precondition:  If this object is an element, the current or next start element starts this object and any intervening reader events are ignorable
             *                If this object is not an element, it is a complex type and the reader is at the event just after the outer start element
             * Postcondition: If this object is an element, the reader is positioned at its end element
             *                If this object is a complex type, the reader is positioned at the end element of its outer element
             */
            public static ESB_GYD_GYD_InquiryHasCaptchaSrvResponseE parse(
                javax.xml.stream.XMLStreamReader reader)
                throws java.lang.Exception {
                ESB_GYD_GYD_InquiryHasCaptchaSrvResponseE object = new ESB_GYD_GYD_InquiryHasCaptchaSrvResponseE();

                int event;
                java.lang.String nillableValue = null;
                java.lang.String prefix = "";
                java.lang.String namespaceuri = "";

                try {
                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();

                    // Note all attributes that were handled. Used to differ normal attributes
                    // from anyAttributes.
                    java.util.Vector handledAttributes = new java.util.Vector();

                    while (!reader.isEndElement()) {
                        if (reader.isStartElement()) {
                            if (reader.isStartElement() &&
                                    new javax.xml.namespace.QName(
                                        "http://www.csot.tcl.com/ESB_GYD_GYD_InquiryHasCaptchaSrv/1.0",
                                        "ESB_GYD_GYD_InquiryHasCaptchaSrvResponse").equals(
                                        reader.getName())) {
                                object.setESB_GYD_GYD_InquiryHasCaptchaSrvResponse(ESB_GYD_GYD_InquiryHasCaptchaSrvResponse.Factory.parse(
                                        reader));
                            } // End of if for expected property start element

                            else {
                                // A start element we are not expecting indicates an invalid parameter was passed
                                throw new org.apache.axis2.databinding.ADBException(
                                    "Unexpected subelement " +
                                    reader.getName());
                            }
                        } else {
                            reader.next();
                        }
                    } // end of while loop
                } catch (javax.xml.stream.XMLStreamException e) {
                    throw new java.lang.Exception(e);
                }

                return object;
            }
        } //end of factory class
    }

    public static class ExtensionMapper {
        public static java.lang.Object getTypeObject(
            java.lang.String namespaceURI, java.lang.String typeName,
            javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception {
            if ("http://www.csot.tcl.com/ESB_GYD_GYD_InquiryHasCaptchaSrv/1.0".equals(
                        namespaceURI) &&
                    "ESB_GYD_GYD_InquiryHasCaptchaSrvRequest".equals(typeName)) {
                return ESB_GYD_GYD_InquiryHasCaptchaSrvRequest.Factory.parse(reader);
            }

            if ("http://www.csot.tcl.com/ESB_GYD_GYD_InquiryHasCaptchaSrv/1.0".equals(
                        namespaceURI) &&
                    "ESB_GYD_GYD_InquiryHasCaptchaSrvResponse".equals(typeName)) {
                return ESB_GYD_GYD_InquiryHasCaptchaSrvResponse.Factory.parse(reader);
            }

            if ("http://www.csot.tcl.com/MsgHeader/1.0".equals(namespaceURI) &&
                    "MsgHeader".equals(typeName)) {
                return MsgHeader.Factory.parse(reader);
            }

            if ("http://www.csot.tcl.com/ESB_GYD_GYD_InquiryHasCaptchaSrv/1.0".equals(
                        namespaceURI) &&
                    "ESB_GYD_GYD_InquiryHasCaptchaSrvOutputCollection".equals(
                        typeName)) {
                return ESB_GYD_GYD_InquiryHasCaptchaSrvOutputCollection.Factory.parse(reader);
            }

            if ("http://www.csot.tcl.com/ESB_GYD_GYD_InquiryHasCaptchaSrv/1.0".equals(
                        namespaceURI) &&
                    "ESB_GYD_GYD_InquiryHasCaptchaSrvOutputItem".equals(
                        typeName)) {
                return ESB_GYD_GYD_InquiryHasCaptchaSrvOutputItem.Factory.parse(reader);
            }

            throw new org.apache.axis2.databinding.ADBException(
                "Unsupported type " + namespaceURI + " " + typeName);
        }
    }

    public static class ESB_GYD_GYD_InquiryHasCaptchaSrvRequestE implements org.apache.axis2.databinding.ADBBean {
        public static final javax.xml.namespace.QName MY_QNAME = new javax.xml.namespace.QName("http://www.csot.tcl.com/ESB_GYD_GYD_InquiryHasCaptchaSrv/1.0",
                "ESB_GYD_GYD_InquiryHasCaptchaSrvRequest", "ns2");

        /**
         * field for ESB_GYD_GYD_InquiryHasCaptchaSrvRequest
         */
        protected ESB_GYD_GYD_InquiryHasCaptchaSrvRequest localESB_GYD_GYD_InquiryHasCaptchaSrvRequest;

        /**
         * Auto generated getter method
         * @return ESB_GYD_GYD_InquiryHasCaptchaSrvRequest
         */
        public ESB_GYD_GYD_InquiryHasCaptchaSrvRequest getESB_GYD_GYD_InquiryHasCaptchaSrvRequest() {
            return localESB_GYD_GYD_InquiryHasCaptchaSrvRequest;
        }

        /**
         * Auto generated setter method
         * @param param ESB_GYD_GYD_InquiryHasCaptchaSrvRequest
         */
        public void setESB_GYD_GYD_InquiryHasCaptchaSrvRequest(
            ESB_GYD_GYD_InquiryHasCaptchaSrvRequest param) {
            this.localESB_GYD_GYD_InquiryHasCaptchaSrvRequest = param;
        }

        /**
         *
         * @param parentQName
         * @param factory
         * @return org.apache.axiom.om.OMElement
         */
        public org.apache.axiom.om.OMElement getOMElement(
            final javax.xml.namespace.QName parentQName,
            final org.apache.axiom.om.OMFactory factory)
            throws org.apache.axis2.databinding.ADBException {
            org.apache.axiom.om.OMDataSource dataSource = new org.apache.axis2.databinding.ADBDataSource(this,
                    MY_QNAME);

            return factory.createOMElement(dataSource, MY_QNAME);
        }

        public void serialize(final javax.xml.namespace.QName parentQName,
            javax.xml.stream.XMLStreamWriter xmlWriter)
            throws javax.xml.stream.XMLStreamException,
                org.apache.axis2.databinding.ADBException {
            serialize(parentQName, xmlWriter, false);
        }

        public void serialize(final javax.xml.namespace.QName parentQName,
            javax.xml.stream.XMLStreamWriter xmlWriter, boolean serializeType)
            throws javax.xml.stream.XMLStreamException,
                org.apache.axis2.databinding.ADBException {
            //We can safely assume an element has only one type associated with it
            if (localESB_GYD_GYD_InquiryHasCaptchaSrvRequest == null) {
                throw new org.apache.axis2.databinding.ADBException(
                    "ESB_GYD_GYD_InquiryHasCaptchaSrvRequest cannot be null!");
            }

            localESB_GYD_GYD_InquiryHasCaptchaSrvRequest.serialize(MY_QNAME,
                xmlWriter);
        }

        private static java.lang.String generatePrefix(
            java.lang.String namespace) {
            if (namespace.equals(
                        "http://www.csot.tcl.com/ESB_GYD_GYD_InquiryHasCaptchaSrv/1.0")) {
                return "ns2";
            }

            return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
        }

        /**
         * Utility method to write an element start tag.
         */
        private void writeStartElement(java.lang.String prefix,
            java.lang.String namespace, java.lang.String localPart,
            javax.xml.stream.XMLStreamWriter xmlWriter)
            throws javax.xml.stream.XMLStreamException {
            java.lang.String writerPrefix = xmlWriter.getPrefix(namespace);

            if (writerPrefix != null) {
                xmlWriter.writeStartElement(namespace, localPart);
            } else {
                if (namespace.length() == 0) {
                    prefix = "";
                } else if (prefix == null) {
                    prefix = generatePrefix(namespace);
                }

                xmlWriter.writeStartElement(prefix, localPart, namespace);
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }
        }

        /**
         * Util method to write an attribute with the ns prefix
         */
        private void writeAttribute(java.lang.String prefix,
            java.lang.String namespace, java.lang.String attName,
            java.lang.String attValue,
            javax.xml.stream.XMLStreamWriter xmlWriter)
            throws javax.xml.stream.XMLStreamException {
            if (xmlWriter.getPrefix(namespace) == null) {
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }

            xmlWriter.writeAttribute(namespace, attName, attValue);
        }

        /**
         * Util method to write an attribute without the ns prefix
         */
        private void writeAttribute(java.lang.String namespace,
            java.lang.String attName, java.lang.String attValue,
            javax.xml.stream.XMLStreamWriter xmlWriter)
            throws javax.xml.stream.XMLStreamException {
            if (namespace.equals("")) {
                xmlWriter.writeAttribute(attName, attValue);
            } else {
                registerPrefix(xmlWriter, namespace);
                xmlWriter.writeAttribute(namespace, attName, attValue);
            }
        }

        /**
         * Util method to write an attribute without the ns prefix
         */
        private void writeQNameAttribute(java.lang.String namespace,
            java.lang.String attName, javax.xml.namespace.QName qname,
            javax.xml.stream.XMLStreamWriter xmlWriter)
            throws javax.xml.stream.XMLStreamException {
            java.lang.String attributeNamespace = qname.getNamespaceURI();
            java.lang.String attributePrefix = xmlWriter.getPrefix(attributeNamespace);

            if (attributePrefix == null) {
                attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
            }

            java.lang.String attributeValue;

            if (attributePrefix.trim().length() > 0) {
                attributeValue = attributePrefix + ":" + qname.getLocalPart();
            } else {
                attributeValue = qname.getLocalPart();
            }

            if (namespace.equals("")) {
                xmlWriter.writeAttribute(attName, attributeValue);
            } else {
                registerPrefix(xmlWriter, namespace);
                xmlWriter.writeAttribute(namespace, attName, attributeValue);
            }
        }

        /**
         *  method to handle Qnames
         */
        private void writeQName(javax.xml.namespace.QName qname,
            javax.xml.stream.XMLStreamWriter xmlWriter)
            throws javax.xml.stream.XMLStreamException {
            java.lang.String namespaceURI = qname.getNamespaceURI();

            if (namespaceURI != null) {
                java.lang.String prefix = xmlWriter.getPrefix(namespaceURI);

                if (prefix == null) {
                    prefix = generatePrefix(namespaceURI);
                    xmlWriter.writeNamespace(prefix, namespaceURI);
                    xmlWriter.setPrefix(prefix, namespaceURI);
                }

                if (prefix.trim().length() > 0) {
                    xmlWriter.writeCharacters(prefix + ":" +
                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                            qname));
                } else {
                    // i.e this is the default namespace
                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                            qname));
                }
            } else {
                xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                        qname));
            }
        }

        private void writeQNames(javax.xml.namespace.QName[] qnames,
            javax.xml.stream.XMLStreamWriter xmlWriter)
            throws javax.xml.stream.XMLStreamException {
            if (qnames != null) {
                // we have to store this data until last moment since it is not possible to write any
                // namespace data after writing the charactor data
                java.lang.StringBuffer stringToWrite = new java.lang.StringBuffer();
                java.lang.String namespaceURI = null;
                java.lang.String prefix = null;

                for (int i = 0; i < qnames.length; i++) {
                    if (i > 0) {
                        stringToWrite.append(" ");
                    }

                    namespaceURI = qnames[i].getNamespaceURI();

                    if (namespaceURI != null) {
                        prefix = xmlWriter.getPrefix(namespaceURI);

                        if ((prefix == null) || (prefix.length() == 0)) {
                            prefix = generatePrefix(namespaceURI);
                            xmlWriter.writeNamespace(prefix, namespaceURI);
                            xmlWriter.setPrefix(prefix, namespaceURI);
                        }

                        if (prefix.trim().length() > 0) {
                            stringToWrite.append(prefix).append(":")
                                         .append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                                    qnames[i]));
                        } else {
                            stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                                    qnames[i]));
                        }
                    } else {
                        stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                                qnames[i]));
                    }
                }

                xmlWriter.writeCharacters(stringToWrite.toString());
            }
        }

        /**
         * Register a namespace prefix
         */
        private java.lang.String registerPrefix(
            javax.xml.stream.XMLStreamWriter xmlWriter,
            java.lang.String namespace)
            throws javax.xml.stream.XMLStreamException {
            java.lang.String prefix = xmlWriter.getPrefix(namespace);

            if (prefix == null) {
                prefix = generatePrefix(namespace);

                javax.xml.namespace.NamespaceContext nsContext = xmlWriter.getNamespaceContext();

                while (true) {
                    java.lang.String uri = nsContext.getNamespaceURI(prefix);

                    if ((uri == null) || (uri.length() == 0)) {
                        break;
                    }

                    prefix = org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
                }

                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }

            return prefix;
        }

        /**
         * databinding method to get an XML representation of this object
         *
         */
        public javax.xml.stream.XMLStreamReader getPullParser(
            javax.xml.namespace.QName qName)
            throws org.apache.axis2.databinding.ADBException {
            //We can safely assume an element has only one type associated with it
            return localESB_GYD_GYD_InquiryHasCaptchaSrvRequest.getPullParser(MY_QNAME);
        }

        /**
         *  Factory class that keeps the parse method
         */
        public static class Factory {
            /**
             * static method to create the object
             * Precondition:  If this object is an element, the current or next start element starts this object and any intervening reader events are ignorable
             *                If this object is not an element, it is a complex type and the reader is at the event just after the outer start element
             * Postcondition: If this object is an element, the reader is positioned at its end element
             *                If this object is a complex type, the reader is positioned at the end element of its outer element
             */
            public static ESB_GYD_GYD_InquiryHasCaptchaSrvRequestE parse(
                javax.xml.stream.XMLStreamReader reader)
                throws java.lang.Exception {
                ESB_GYD_GYD_InquiryHasCaptchaSrvRequestE object = new ESB_GYD_GYD_InquiryHasCaptchaSrvRequestE();

                int event;
                java.lang.String nillableValue = null;
                java.lang.String prefix = "";
                java.lang.String namespaceuri = "";

                try {
                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();

                    // Note all attributes that were handled. Used to differ normal attributes
                    // from anyAttributes.
                    java.util.Vector handledAttributes = new java.util.Vector();

                    while (!reader.isEndElement()) {
                        if (reader.isStartElement()) {
                            if (reader.isStartElement() &&
                                    new javax.xml.namespace.QName(
                                        "http://www.csot.tcl.com/ESB_GYD_GYD_InquiryHasCaptchaSrv/1.0",
                                        "ESB_GYD_GYD_InquiryHasCaptchaSrvRequest").equals(
                                        reader.getName())) {
                                object.setESB_GYD_GYD_InquiryHasCaptchaSrvRequest(ESB_GYD_GYD_InquiryHasCaptchaSrvRequest.Factory.parse(
                                        reader));
                            } // End of if for expected property start element

                            else {
                                // A start element we are not expecting indicates an invalid parameter was passed
                                throw new org.apache.axis2.databinding.ADBException(
                                    "Unexpected subelement " +
                                    reader.getName());
                            }
                        } else {
                            reader.next();
                        }
                    } // end of while loop
                } catch (javax.xml.stream.XMLStreamException e) {
                    throw new java.lang.Exception(e);
                }

                return object;
            }
        } //end of factory class
    }
}
