//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.1-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2014.10.01 at 10:47:24 AM IST 
//


package webservices.beans.getdeals;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="facilityId" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="drawDownId" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="maturityDate" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "facilityId",
    "drawDownId",
    "maturityDate"
})
@XmlRootElement(name = "GetDealsRequest")
public class GetDealsRequest {

    protected int facilityId;
    protected int drawDownId;
    @XmlElement(required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar maturityDate;

    /**
     * Gets the value of the facilityId property.
     * 
     */
    public int getFacilityId() {
        return facilityId;
    }

    /**
     * Sets the value of the facilityId property.
     * 
     */
    public void setFacilityId(int value) {
        this.facilityId = value;
    }

    /**
     * Gets the value of the drawDownId property.
     * 
     */
    public int getDrawDownId() {
        return drawDownId;
    }

    /**
     * Sets the value of the drawDownId property.
     * 
     */
    public void setDrawDownId(int value) {
        this.drawDownId = value;
    }

    /**
     * Gets the value of the maturityDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getMaturityDate() {
        return maturityDate;
    }

    /**
     * Sets the value of the maturityDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setMaturityDate(XMLGregorianCalendar value) {
        this.maturityDate = value;
    }

}
