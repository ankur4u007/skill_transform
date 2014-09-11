package xmlParser.dao.impl.deal;

import java.util.Date;
import java.util.List;

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

    List<Deal> findByMaturityDate(final Date maturityDate);

}
