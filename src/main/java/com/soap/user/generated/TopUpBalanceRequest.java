//
// Este archivo ha sido generado por Eclipse Implementation of JAXB v3.0.2 
// Visite https://eclipse-ee4j.github.io/jaxb-ri 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: 2025.08.22 a las 09:50:56 PM COT 
//


package com.soap.user.generated;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para anonymous complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="recharge" type="{http://soap.com/user/schemas}rechargeBalance"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "recharge"
})
@XmlRootElement(name = "topUpBalanceRequest")
public class TopUpBalanceRequest {

    @XmlElement(required = true)
    protected RechargeBalance recharge;

    /**
     * Obtiene el valor de la propiedad recharge.
     * 
     * @return
     *     possible object is
     *     {@link RechargeBalance }
     *     
     */
    public RechargeBalance getRecharge() {
        return recharge;
    }

    /**
     * Define el valor de la propiedad recharge.
     * 
     * @param value
     *     allowed object is
     *     {@link RechargeBalance }
     *     
     */
    public void setRecharge(RechargeBalance value) {
        this.recharge = value;
    }

}
