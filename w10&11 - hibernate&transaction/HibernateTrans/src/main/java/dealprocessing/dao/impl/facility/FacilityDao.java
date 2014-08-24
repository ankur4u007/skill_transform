/**
 *
 */
package dealprocessing.dao.impl.facility;

import org.springframework.stereotype.Component;

import dealprocessing.dao.AbstractDao;
import dealprocessing.domainobject.Facility;

/**
 * @author CHANDRAYAN
 *
 */
@Component("facilityDao")
public class FacilityDao extends AbstractDao<Integer, Facility> implements IFacilityDao {

}
