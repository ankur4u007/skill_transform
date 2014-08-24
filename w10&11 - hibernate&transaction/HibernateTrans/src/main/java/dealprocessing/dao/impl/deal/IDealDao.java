package dealprocessing.dao.impl.deal;

import dealprocessing.dao.IAbstractDao;
import dealprocessing.domainobject.Deal;

/**
 *
 * @author CHANDRAYAN
 *
 */
public interface IDealDao extends IAbstractDao<Integer, Deal> {

    Deal findByFacilityId(int facilityId);

    Deal findByDrawDownId(int drawDownId);

}
