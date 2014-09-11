package xmlParser.dao.impl.deal;

import xmlParser.dao.IAbstractDao;
import xmlParser.domainobject.Deal;

/**
 *
 * @author CHANDRAYAN
 *
 */
public interface IDealDao extends IAbstractDao<Integer, Deal> {

    Deal findByFacilityId(int facilityId);

    Deal findByDrawDownId(int drawDownId);

}
