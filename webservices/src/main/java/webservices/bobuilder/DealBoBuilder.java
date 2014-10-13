/**
 *
 */
package webservices.bobuilder;

import java.util.ArrayList;
import java.util.List;

import webservices.beans.createdeals.Deal;
import webservices.beans.createdeals.DrawDown;
import webservices.beans.createdeals.Facility;
import xmlParser.bo.DealBO;
import xmlParser.bo.DrawDownBO;
import xmlParser.bo.FacilityBO;

/**
 * @author CHANDRAYAN
 *
 */
public class DealBoBuilder {

    public static DealBO buildDealBOFromDomainObject(final Deal deal) {
	DealBO dealBOToReturn = null;
	if (deal != null) {
	    dealBOToReturn = new DealBO(deal.getId(), (deal.getDescrption() == null ? null : deal.getDescrption()
		    .getValue()), deal.getStartDate().toGregorianCalendar().getTime(), deal.getMaturityDate()
		    .toGregorianCalendar().getTime(), buildFacilityBOFromJaxbObjectList(deal.getFacilityList()));
	}
	return dealBOToReturn;
    }

    public static List<FacilityBO> buildFacilityBOFromJaxbObjectList(final List<Facility> facilityList) {
	List<FacilityBO> boListToReturn = null;
	if (facilityList != null) {
	    boListToReturn = new ArrayList<FacilityBO>();
	    for (final Facility facility : facilityList) {
		boListToReturn.add(buildFacilityBOFromJaxbObject(facility));
	    }
	}
	return boListToReturn;
    }

    public static FacilityBO buildFacilityBOFromJaxbObject(final Facility facility) {
	FacilityBO facilityBOToReturn = null;
	if (facility != null) {
	    facilityBOToReturn = new FacilityBO(facility.getId(), (facility.getAmount() == null ? null : facility
		    .getAmount().getValue()), facility.getStartDate().toGregorianCalendar().getTime(), facility
		    .getMaturityDate().toGregorianCalendar().getTime(),
		    buildDrawDownBOListFromJaxbObjectList(facility.getDrawDownList()));
	}
	return facilityBOToReturn;
    }

    public static List<DrawDownBO> buildDrawDownBOListFromJaxbObjectList(final List<DrawDown> drawDownList) {
	List<DrawDownBO> boListToReturn = null;
	if (drawDownList != null) {
	    boListToReturn = new ArrayList<DrawDownBO>();
	    for (final DrawDown drawDown : drawDownList) {
		boListToReturn.add(buildDrawDownBOFromJaxbObject(drawDown));
	    }
	}
	return boListToReturn;
    }

    public static DrawDownBO buildDrawDownBOFromJaxbObject(final DrawDown drawDown) {
	DrawDownBO drawDownBOToReturn = null;
	if (drawDown != null) {
	    drawDownBOToReturn = new DrawDownBO(drawDown.getId(), (drawDown.getDescription() == null ? null : drawDown
		    .getDescription().getValue()), (drawDown.getAmount() == null ? null : drawDown.getAmount()
		    .getValue()));
	}
	return drawDownBOToReturn;
    }
}
