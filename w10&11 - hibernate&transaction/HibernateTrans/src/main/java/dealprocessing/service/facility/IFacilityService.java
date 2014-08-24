/**
 *
 */
package dealprocessing.service.facility;

import java.util.List;

import dealprocessing.bo.FacilityBO;
import dealprocessing.domainobject.Facility;

/**
 * @author CHANDRAYAN
 *
 */
public interface IFacilityService {

    void createFacility(FacilityBO facilityBoToCreate);

    void createFacility(Facility facilityToCreate);

    List<FacilityBO> getAllFacility();

}
