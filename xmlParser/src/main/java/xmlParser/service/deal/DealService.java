package xmlParser.service.deal;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import xmlParser.bo.DealBO;
import xmlParser.builders.BOBuilder;
import xmlParser.builders.DOBuilder;
import xmlParser.dao.impl.deal.IDealDao;
import xmlParser.domainobject.Deal;
import xmlParser.domainobject.Facility;
import xmlParser.service.facility.IFacilityService;

@Component("dealservice")
@Transactional(readOnly = true)
public class DealService implements IDealService {

    @Autowired
    private IDealDao dealDao;
    @Autowired
    private IFacilityService facilityService;

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void createDeals(final List<xmlParser.jaxbobjects.Deal> dealListToCreate) {
	if (dealListToCreate != null) {
	    for (final xmlParser.jaxbobjects.Deal dealToCreate : dealListToCreate) {
		final Deal deal = DOBuilder.getDealDomainObjectFromJAXBO(dealToCreate);
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

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void createDealsByBOList(final List<DealBO> dealListToCreate) {
	if (dealListToCreate != null) {
	    for (final DealBO dealToCreate : dealListToCreate) {
		final Deal deal = DOBuilder.getDealDomainObjectFromBO(dealToCreate);
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

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void createDealsByBO(final DealBO dealBO) {
	final Deal deal = DOBuilder.getDealDomainObjectFromBO(dealBO);
	final Deal existingDeal = dealDao.findById(deal.getId());
	if (existingDeal != null) {
	    dealDao.update(deal);
	} else {
	    dealDao.create(deal);
	}
	if (deal.getFacilityList() != null) {
	    for (final Facility facility : deal.getFacilityList()) {
		facility.setDeal(deal);
		facilityService.createFacility(facility);
	    }
	}
    }

    public DealBO getDealByFacilityId(final int facilityId) {
	return BOBuilder.buildDealBOFromDomainObject(dealDao.findByFacilityId(facilityId));
    }

    public DealBO getDealByDrawdownId(final int drawdownId) {
	return BOBuilder.buildDealBOFromDomainObject(dealDao.findByDrawDownId(drawdownId));
    }

    public List<DealBO> getAllDeals() {
	return BOBuilder.buildDealBOListFromDomainObjectList(dealDao.findAll());
    }

    public List<DealBO> getDealsByMaturityDate(final Date maturityDate) {
	return BOBuilder.buildDealBOListFromDomainObjectList(dealDao.findByMaturityDate(maturityDate));
    }

    public List<DealBO> getDealsByParameters(final Integer facilityId, final Integer drawDownId, final Date maturityDate) {
	return BOBuilder.buildDealBOListFromDomainObjectList(dealDao.findByParameters(facilityId, drawDownId,
		maturityDate));
    }
}
