/**
 *
 */
package xmlParser.jaxbObjfactory;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;

import xmlParser.jaxbobjects.Deal;
import xmlParser.jaxbobjects.Deals;
import xmlParser.jaxbobjects.DrawDown;
import xmlParser.jaxbobjects.Facility;

/**
 * @author CHANDRAYAN
 *
 */
public class JaxbObjFactory {

    private JaxbObjFactory() {

    }

    public static Deals createDummyDeals(final int size) throws DatatypeConfigurationException {
	Deals deals = null;
	if (size > 0) {
	    deals = new Deals();
	    deals.getDeal().addAll((createDealList(size)));
	}
	return deals;
    }

    public static List<Deal> createDealList(final int size) throws DatatypeConfigurationException {
	List<Deal> dealListToReturn = null;
	if (size > 0) {
	    dealListToReturn = new ArrayList<Deal>();
	    for (int i = 0; i < size; i++) {
		final Deal deal = new Deal();
		deal.setDescrption("Desc:" + i + ":" + Math.random() * 100);
		final GregorianCalendar cal = (GregorianCalendar) GregorianCalendar.getInstance();
		deal.setMaturityDate(DatatypeFactory.newInstance().newXMLGregorianCalendar(cal));
		deal.setStartDate(DatatypeFactory.newInstance().newXMLGregorianCalendar(cal));
		deal.getFacilityList().addAll(createFacilityList(2));
		dealListToReturn.add(deal);
	    }
	}
	return dealListToReturn;
    }

    public static List<Facility> createFacilityList(final int size) throws DatatypeConfigurationException {
	List<Facility> facilityListToReturn = null;
	if (size > 0) {
	    facilityListToReturn = new ArrayList<Facility>();
	    for (int i = 0; i < size; i++) {
		final Facility facility = new Facility();
		facility.setAmount(Math.random() * 100);
		final GregorianCalendar cal = (GregorianCalendar) GregorianCalendar.getInstance();
		facility.setMaturityDate(DatatypeFactory.newInstance().newXMLGregorianCalendar(cal));
		facility.setStartDate(DatatypeFactory.newInstance().newXMLGregorianCalendar(cal));
		facility.getDrawDownList().addAll(createDrawDownList(2));
		facilityListToReturn.add(facility);
	    }
	}
	return facilityListToReturn;
    }

    public static List<DrawDown> createDrawDownList(final int size) {
	List<DrawDown> drawDownListToReturn = null;
	if (size > 0) {
	    drawDownListToReturn = new ArrayList<DrawDown>();
	    for (int i = 0; i < size; i++) {
		final DrawDown drawDown = new DrawDown();
		drawDown.setAmount(Math.random() * 100);
		drawDown.setDescription("Desc:" + i + ":" + Math.random() * 100);
		drawDownListToReturn.add(drawDown);
	    }
	}
	return drawDownListToReturn;
    }
}
