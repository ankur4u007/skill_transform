package webservices.responsebuilder;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;

import webservices.beans.getdeals.Deal;
import webservices.beans.getdeals.DrawDown;
import webservices.beans.getdeals.Facility;
import xmlParser.bo.DealBO;
import xmlParser.bo.DrawDownBO;
import xmlParser.bo.FacilityBO;

public class ResponseBuilder {

    public static List<Deal> builldResponseFromBOList(final List<DealBO> boList) throws DatatypeConfigurationException {
	List<Deal> dealsList = null;
	if (boList != null) {
	    dealsList = new ArrayList<Deal>();
	    for (final DealBO bo : boList) {
		dealsList.add((getDealFromBO(bo)));
	    }
	}
	return dealsList;
    }

    public static Deal getDealFromBO(final DealBO bo) throws DatatypeConfigurationException {
	Deal dealToReturn = null;
	if (bo != null) {
	    dealToReturn = new Deal();
	    dealToReturn.setId(bo.getId());
	    dealToReturn.setDescrption(bo.getDescrption());
	    final GregorianCalendar matCal = new GregorianCalendar();
	    matCal.setTime(bo.getMaturityDate());
	    dealToReturn.setMaturityDate(DatatypeFactory.newInstance().newXMLGregorianCalendar(matCal));
	    final GregorianCalendar startCal = new GregorianCalendar();
	    startCal.setTime(bo.getStartDate());
	    dealToReturn.setStartDate(DatatypeFactory.newInstance().newXMLGregorianCalendar(startCal));
	    dealToReturn.getFacilityList().addAll(getFacilityListFromBOList(bo.getFacilityBOList()));
	}
	return dealToReturn;
    }

    public static List<Facility> getFacilityListFromBOList(final List<FacilityBO> facilityBOList)
	    throws DatatypeConfigurationException {
	List<Facility> facilityListToReturn = null;
	if (facilityBOList != null) {
	    facilityListToReturn = new ArrayList<Facility>();
	    for (final FacilityBO bo : facilityBOList) {
		final Facility facility = new Facility();
		facility.setId(bo.getId());
		facility.setAmount(bo.getAmount());
		final GregorianCalendar matCal = new GregorianCalendar();
		matCal.setTime(bo.getMaturityDate());
		facility.setMaturityDate(DatatypeFactory.newInstance().newXMLGregorianCalendar(matCal));
		final GregorianCalendar startCal = new GregorianCalendar();
		startCal.setTime(bo.getMaturityDate());
		facility.setStartDate(DatatypeFactory.newInstance().newXMLGregorianCalendar(startCal));
		facility.getDrawDownList().addAll(getDrawDownListFromBO(bo.getDrawDownBOList()));
		facilityListToReturn.add(facility);
	    }
	}
	return facilityListToReturn;
    }

    public static List<DrawDown> getDrawDownListFromBO(final List<DrawDownBO> drawDownBOList) {
	List<DrawDown> drawDownListToReturn = null;
	if (drawDownBOList != null) {
	    drawDownListToReturn = new ArrayList<DrawDown>();
	    for (final DrawDownBO bo : drawDownBOList) {
		final DrawDown drawDown = new DrawDown();
		drawDown.setId(bo.getId());
		drawDown.setAmount(bo.getAmount());
		drawDown.setDescription(bo.getDescription());
		drawDownListToReturn.add(drawDown);
	    }
	}
	return drawDownListToReturn;
    }

}
