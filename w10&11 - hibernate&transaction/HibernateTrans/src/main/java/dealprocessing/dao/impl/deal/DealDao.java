/**
 *
 */
package dealprocessing.dao.impl.deal;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Component;

import dealprocessing.dao.AbstractDao;
import dealprocessing.domainobject.Deal;

/**
 * @author CHANDRAYAN
 *
 */
@Component("daelDao")
public class DealDao extends AbstractDao<Integer, Deal> implements IDealDao {

    public Deal findByFacilityId(final int facilityId) {
	final Criteria criteria = getSessionFactory().getCurrentSession().createCriteria(Deal.class);
	criteria.createAlias("facilityList", "facility").add(Restrictions.eq("facility.id", facilityId));
	return (Deal) criteria.uniqueResult();
    }

    public Deal findByDrawDownId(final int drawDownId) {
	final Criteria criteria = getSessionFactory().getCurrentSession().createCriteria(Deal.class);
	criteria.createAlias("facilityList", "facility").createAlias("facility.drawDownList", "drawDown")
	.add(Restrictions.eq("drawDown.id", drawDownId));
	return (Deal) criteria.uniqueResult();
    }

}
