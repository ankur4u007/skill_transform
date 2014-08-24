package dealprocessing.builders;

import java.util.ArrayList;
import java.util.List;

import dealprocessing.bo.DealBO;
import dealprocessing.bo.DrawDownBO;
import dealprocessing.bo.FacilityBO;
import dealprocessing.domainobject.Deal;
import dealprocessing.domainobject.DrawDown;
import dealprocessing.domainobject.Facility;

/**
 *
 * @author CHANDRAYAN
 *
 */
public class BOBuilders {

    private BOBuilders() {

    }

    public static List<DealBO> buildDealBOListFromDomainObjectList(final List<Deal> dealList) {
	List<DealBO> boListToReturn = null;
	if (dealList != null) {
	    boListToReturn = new ArrayList<DealBO>();
	    for (final Deal deal : dealList) {
		boListToReturn.add(buildDealBOFromDomainObject(deal));
	    }
	}
	return boListToReturn;
    }

    public static DealBO buildDealBOFromDomainObject(final Deal deal) {
	DealBO dealBOToReturn = null;
	if (deal != null) {
	    dealBOToReturn = new DealBO(deal.getId(), deal.getDescrption(), deal.getStartDate(),
		    deal.getMaturityDate(), buildFacilityBOListFromDomainObjectList(deal.getFacilityList()));
	}
	return dealBOToReturn;
    }

    public static List<FacilityBO> buildFacilityBOListFromDomainObjectList(final List<Facility> facilityList) {
	List<FacilityBO> boListToReturn = null;
	if (facilityList != null) {
	    boListToReturn = new ArrayList<FacilityBO>();
	    for (final Facility facility : facilityList) {
		boListToReturn.add(buildFacilityBOFromDomainObject(facility));
	    }
	}
	return boListToReturn;
    }

    public static FacilityBO buildFacilityBOFromDomainObject(final Facility facility) {
	FacilityBO facilityBOToReturn = null;
	if (facility != null) {
	    facilityBOToReturn = new FacilityBO(facility.getId(), facility.getAmount(), facility.getStartDate(),
		    facility.getMaturityDate(), buildDrawDownBOListFromDomainObjectList(facility.getDrawDownList()));
	}
	return facilityBOToReturn;
    }

    public static List<DrawDownBO> buildDrawDownBOListFromDomainObjectList(final List<DrawDown> drawDownList) {
	List<DrawDownBO> boListToReturn = null;
	if (drawDownList != null) {
	    boListToReturn = new ArrayList<DrawDownBO>();
	    for (final DrawDown drawDown : drawDownList) {
		boListToReturn.add(buildDrawDownBOFromDomainObject(drawDown));
	    }
	}
	return boListToReturn;
    }

    public static DrawDownBO buildDrawDownBOFromDomainObject(final DrawDown drawDown) {
	DrawDownBO drawDownBOToReturn = null;
	if (drawDown != null) {
	    drawDownBOToReturn = new DrawDownBO(drawDown.getId(), drawDown.getDescription(), drawDown.getAmount());
	}
	return drawDownBOToReturn;
    }
}
