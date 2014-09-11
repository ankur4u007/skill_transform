/**
 *
 */
package xmlParser.bofactory;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import xmlParser.bo.DealBO;
import xmlParser.bo.DrawDownBO;
import xmlParser.bo.FacilityBO;

/**
 * @author CHANDRAYAN
 *
 */
public class BOFactory {

    private BOFactory() {

    }

    public static List<DealBO> createDealBOList(final int size) {
	List<DealBO> boListToReturn = null;
	if (size > 0) {
	    boListToReturn = new ArrayList<DealBO>();
	    for (int i = 0; i < size; i++) {
		boListToReturn.add(new DealBO(null, "Desc:" + i + ":" + Math.random() * 100, new Date(), new Date(),
			createFacilityBOList(2)));
	    }
	}
	return boListToReturn;
    }

    public static List<FacilityBO> createFacilityBOList(final int size) {
	List<FacilityBO> boListToReturn = null;
	if (size > 0) {
	    boListToReturn = new ArrayList<FacilityBO>();
	    for (int i = 0; i < size; i++) {
		boListToReturn.add(new FacilityBO(null, Math.random() * 100, new Date(), new Date(),
			createDrawDownBOList(2)));
	    }
	}
	return boListToReturn;
    }

    public static List<DrawDownBO> createDrawDownBOList(final int size) {
	List<DrawDownBO> boListToReturn = null;
	if (size > 0) {
	    boListToReturn = new ArrayList<DrawDownBO>();
	    for (int i = 0; i < size; i++) {
		boListToReturn.add(new DrawDownBO(null, "Desc:" + i + ":" + Math.random() * 100, Math.random() * 100));
	    }
	}
	return boListToReturn;
    }
}
