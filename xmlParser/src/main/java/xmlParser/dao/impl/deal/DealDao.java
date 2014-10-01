/**
 *
 */
package xmlParser.dao.impl.deal;

import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Component;

import xmlParser.dao.AbstractDao;
import xmlParser.domainobject.Deal;

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

    @SuppressWarnings("unchecked")
    public List<Deal> findByMaturityDate(final Date maturityDate) {
	final Criteria criteria = getSessionFactory().getCurrentSession().createCriteria(Deal.class);
	criteria.add(Restrictions.eq("maturityDate", maturityDate));
	return criteria.list();
    }

    @SuppressWarnings("unchecked")
    public List<Deal> findByParameters(final Integer facilityId, final Integer drawDownId, final Date maturityDate) {
	final Criteria criteria = getSessionFactory().getCurrentSession().createCriteria(Deal.class);
	criteria.createAlias("facilityList", "facility");
	if (facilityId != null && facilityId != 0) {
	    criteria.add(Restrictions.eq("facility.id", facilityId));
	}
	if (drawDownId != null && drawDownId != 0) {
	    criteria.createAlias("facility.drawDownList", "drawDown").add(Restrictions.eq("drawDown.id", drawDownId));
	}
	if (maturityDate != null) {
	    criteria.add(Restrictions.eq("maturityDate", maturityDate));
	}
	return criteria.list();
    }
}
