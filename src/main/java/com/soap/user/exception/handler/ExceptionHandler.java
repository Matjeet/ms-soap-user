package com.soap.user.exception.handler;

import jakarta.xml.soap.*;
import jakarta.xml.ws.handler.MessageContext;
import jakarta.xml.ws.handler.soap.SOAPHandler;
import jakarta.xml.ws.handler.soap.SOAPMessageContext;

import javax.xml.namespace.QName;
import java.util.Collections;
import java.util.Set;

public class ExceptionHandler implements SOAPHandler<SOAPMessageContext> {
    @Override
    public Set<QName> getHeaders() {
        return Collections.emptySet();
    }

    @Override
    public boolean handleMessage(SOAPMessageContext soapMessageContext) {
        return true;
    }

    @Override
    public boolean handleFault(SOAPMessageContext soapMessageContext) {
        Exception e = (Exception) soapMessageContext.get("javax.xml.ws.soap.http.fault");
        handleException(soapMessageContext, e);
        return true;
    }

    @Override
    public void close(MessageContext messageContext) {

    }

    public void handleException(SOAPMessageContext context, Exception e){
        System.err.println("Error en el handle SOAP: " + e.getMessage());

        try{
            SOAPMessage msg = context.getMessage();
            SOAPPart sp = msg.getSOAPPart();
            SOAPEnvelope se = sp.getEnvelope();
            SOAPBody sb = se.getBody();

            if(!sb.hasFault()) {
                SOAPFault fault = sb.addFault();
                fault.setFaultString("Error procesando la solicitud: " + e.getMessage());
                fault.setFaultCode(new QName("http://schemas.xmlsoap.org/soap/envelope/" , "Server"));
            }
        } catch (SOAPException ex) {
            System.err.println("Error al crear SOAP Fault: " + ex.getMessage());
        }
    }
}
