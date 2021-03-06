package dealprocessing.service.deal;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import dealprocessing.bo.DealBO;
import dealprocessing.builders.BOBuilders;
import dealprocessing.builders.DOBuilders;
import dealprocessing.dao.impl.deal.IDealDao;
import dealprocessing.domainobject.Deal;
import dealprocessing.domainobject.Facility;
import dealprocessing.service.facility.IFacilityService;

@Component("dealservice")
@Transactional(readOnly = true)
public class DealService implements IDealService {

    @Autowired
    private IDealDao dealDao;
    @Autowired
    private IFacilityService facilityService;

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void createDeals(final List<DealBO> dealListToCreate) {
	if (dealListToCreate != null) {
	    for (final DealBO dealToCreate : dealListToCreate) {
		final Deal deal = DOBuilders.getDealDomainObjectFromBO(dealToCreate);
		dealDao.create(deal);
		if (deal.getFacilityList() != null) {
		    for (final Facility facility : deal.getFacilityList()) {
			facility.setDeal(deal);
			facilityService.createFacility(facility);
		    }
		}
	    }
	}
    }

    public DealBO getDealByFacilityId(final int facilityId) {
	return BOBuilders.buildDealBOFromDomainObject(dealDao.findByFacilityId(facilityId));
    }

    public DealBO getDealByDrawdownId(final int drawdownId) {
	return BOBuilders.buildDealBOFromDomainObject(dealDao.findByDrawDownId(drawdownId));
    }

    public List<DealBO> getAllDeals() {
	return BOBuilders.buildDealBOListFromDomainObjectList(dealDao.findAll());
    }

}
