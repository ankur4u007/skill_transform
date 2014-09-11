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

    void createFacility(xmlParser.jaxbobjects.Facility facilityToCreate);

    void createFacility(Facility facilityToCreate);

    List<FacilityBO> getAllFacility();

}
