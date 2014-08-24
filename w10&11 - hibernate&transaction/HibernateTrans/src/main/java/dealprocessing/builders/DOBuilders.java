/**
 *
 */
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
 * @author CHANDRAYAN
 *
 */
public class DOBuilders {

    private DOBuilders() {

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
