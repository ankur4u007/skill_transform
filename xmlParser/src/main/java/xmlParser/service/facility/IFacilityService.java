/**
 *
 */
package xmlParser.service.facility;

import java.util.List;

import xmlParser.bo.FacilityBO;
import xmlParser.domainobject.Facility;

/**
 * @author CHANDRAYAN
 *
 */
public interface IFacilityService {

    void createFacility(FacilityBO facilityBoToCreate);

    void createFacility(Facility facilityToCreate);

    List<FacilityBO> getAllFacility();

}
