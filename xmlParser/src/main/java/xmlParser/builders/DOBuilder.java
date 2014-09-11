/**
 *
 */
package xmlParser.builders;

import java.util.ArrayList;
import java.util.List;

import xmlParser.bo.DealBO;
import xmlParser.bo.DrawDownBO;
import xmlParser.bo.FacilityBO;
import xmlParser.domainobject.Deal;
import xmlParser.domainobject.DrawDown;
import xmlParser.domainobject.Facility;

/**
 * @author CHANDRAYAN
 *
 */
public class DOBuilder {

    private DOBuilder() {

    }

    public static Deal getDealDomainObjectFromJAXBO(final xmlParser.jaxbobjects.Deal deal) {
	Deal dealToReturn = null;
	if (deal != null) {

	    dealToReturn = new Deal(deal.getId(), deal.getDescrption(), deal.getStartDate().toGregorianCalendar()
		    .getTime(), deal.getMaturityDate().toGregorianCalendar().getTime(),
		    getFacilityDomainObjectListFromJAXBOList(deal.getFacilityList()));

	}
	return dealToReturn;
    }

    public static List<Deal> getDealDomainObjectListFromJAXBOList(final List<xmlParser.jaxbobjects.Deal> dealList) {
	List<Deal> dealListToreturn = null;
	if (dealList != null) {
	    dealListToreturn = new ArrayList<Deal>();
	    for (final xmlParser.jaxbobjects.Deal deal : dealList) {
		dealListToreturn.add(getDealDomainObjectFromJAXBO(deal));
	    }
	}
	return dealListToreturn;
    }

    public static Facility getFacilityDomainObjectFromJAXBO(final xmlParser.jaxbobjects.Facility facility) {
	Facility facilityToReturn = null;
	if (facility != null) {
	    facilityToReturn = new Facility(facility.getId(), facility.getAmount(), facility.getStartDate()
		    .toGregorianCalendar().getTime(), facility.getMaturityDate().toGregorianCalendar().getTime(), null,
		    getDrawDownDomainObjectListFromJAXBOList(facility.getDrawDownList()));
	}
	return facilityToReturn;
    }

    public static List<Facility> getFacilityDomainObjectListFromJAXBOList(
	    final List<xmlParser.jaxbobjects.Facility> facilityList) {
	List<Facility> facilityListToreturn = null;
	if (facilityList != null) {
	    facilityListToreturn = new ArrayList<Facility>();
	    for (final xmlParser.jaxbobjects.Facility facility : facilityList) {
		facilityListToreturn.add(getFacilityDomainObjectFromJAXBO(facility));
	    }
	}
	return facilityListToreturn;
    }

    public static DrawDown getDrawDownDomainObjectFromJAXBO(final xmlParser.jaxbobjects.DrawDown drawDown) {
	DrawDown drawDownToReturn = null;
	if (drawDown != null) {
	    drawDownToReturn = new DrawDown(drawDown.getId(), drawDown.getDescription(), drawDown.getAmount(), null);
	}
	return drawDownToReturn;
    }

    public static List<DrawDown> getDrawDownDomainObjectListFromJAXBOList(
	    final List<xmlParser.jaxbobjects.DrawDown> drawDownList) {
	List<DrawDown> drawDownListToreturn = null;
	if (drawDownList != null) {
	    drawDownListToreturn = new ArrayList<DrawDown>();
	    for (final xmlParser.jaxbobjects.DrawDown bo : drawDownList) {
		drawDownListToreturn.add(getDrawDownDomainObjectFromJAXBO(bo));
	    }
	}
	return drawDownListToreturn;
    }

    public static Deal getDealDomainObjectFromBO(final DealBO dealBO) {
	Deal dealToReturn = null;
	if (dealBO != null) {

	    dealToReturn = new Deal(dealBO.getId(), dealBO.getDescrption(), dealBO.getStartDate(),
		    dealBO.getMaturityDate(), getFacilityDomainObjectListFromBOList(dealBO.getFacilityBOList()));

	}
	return dealToReturn;
    }

    public static List<Deal> getDealDomainObjectListFromBOList(final List<DealBO> dealBOList) {
	List<Deal> dealListToreturn = null;
	if (dealBOList != null) {
	    dealListToreturn = new ArrayList<Deal>();
	    for (final DealBO bo : dealBOList) {
		dealListToreturn.add(getDealDomainObjectFromBO(bo));
	    }
	}
	return dealListToreturn;
    }

    public static Facility getFacilityDomainObjectFromBO(final FacilityBO facilityBO) {
	Facility facilityToReturn = null;
	if (facilityBO != null) {
	    facilityToReturn = new Facility(facilityBO.getId(), facilityBO.getAmount(), facilityBO.getStartDate(),
		    facilityBO.getMaturityDate(), null,
		    getDrawDownDomainObjectListFromBOList(facilityBO.getDrawDownBOList()));
	}
	return facilityToReturn;
    }

    public static List<Facility> getFacilityDomainObjectListFromBOList(final List<FacilityBO> facilityBOList) {
	List<Facility> facilityListToreturn = null;
	if (facilityBOList != null) {
	    facilityListToreturn = new ArrayList<Facility>();
	    for (final FacilityBO bo : facilityBOList) {
		facilityListToreturn.add(getFacilityDomainObjectFromBO(bo));
	    }
	}
	return facilityListToreturn;
    }

    public static DrawDown getDrawDownDomainObjectFromBO(final DrawDownBO drawDownBO) {
	DrawDown drawDownToReturn = null;
	if (drawDownBO != null) {
	    drawDownToReturn = new DrawDown(drawDownBO.getId(), drawDownBO.getDescription(), drawDownBO.getAmount(),
		    null);
	}
	return drawDownToReturn;
    }

    public static List<DrawDown> getDrawDownDomainObjectListFromBOList(final List<DrawDownBO> drawDownBOList) {
	List<DrawDown> drawDownListToreturn = null;
	if (drawDownBOList != null) {
	    drawDownListToreturn = new ArrayList<DrawDown>();
	    for (final DrawDownBO bo : drawDownBOList) {
		drawDownListToreturn.add(getDrawDownDomainObjectFromBO(bo));
	    }
	}
	return drawDownListToreturn;
    }
}
