/**
 *
 */
package xmlParser.dao.impl.facility;

import org.springframework.stereotype.Component;

import xmlParser.dao.AbstractDao;
import xmlParser.domainobject.Facility;

/**
 * @author CHANDRAYAN
 *
 */
@Component("facilityDao")
public class FacilityDao extends AbstractDao<Integer, Facility> implements IFacilityDao {

}
