//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.1-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2014.09.25 at 09:25:13 AM IST 
//


package webservices.beans.getdeals;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the webservices.beans.getdeals package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: webservices.beans.getdeals
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Facility }
     * 
     */
    public Facility createFacility() {
        return new Facility();
    }

    /**
     * Create an instance of {@link DrawDown }
     * 
     */
    public DrawDown createDrawDown() {
        return new DrawDown();
    }

    /**
     * Create an instance of {@link GetDealsResponse }
     * 
     */
    public GetDealsResponse createGetDealsResponse() {
        return new GetDealsResponse();
    }

    /**
     * Create an instance of {@link Deal }
     * 
     */
    public Deal createDeal() {
        return new Deal();
    }

    /**
     * Create an instance of {@link Deals }
     * 
     */
    public Deals createDeals() {
        return new Deals();
    }

    /**
     * Create an instance of {@link GetDealsRequest }
     * 
     */
    public GetDealsRequest createGetDealsRequest() {
        return new GetDealsRequest();
    }

}