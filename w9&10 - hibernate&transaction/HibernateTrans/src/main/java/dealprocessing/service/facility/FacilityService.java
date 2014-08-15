package dealprocessing.service.facility;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import dealprocessing.bo.DrawDownBO;
import dealprocessing.bo.FacilityBO;
import dealprocessing.builders.BOBuilders;
import dealprocessing.builders.DOBuilders;
import dealprocessing.dao.impl.facility.IFacilityDao;
import dealprocessing.domainobject.DrawDown;
import dealprocessing.domainobject.Facility;
import dealprocessing.service.drawdown.IDrawDownService;

@Component("facilityService")
@Transactional(readOnly = true)
public class FacilityService implements IFacilityService {

    @Autowired
    private IFacilityDao facilityDao;
    @Autowired
    private IDrawDownService drawDownService;

    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void createFacility(final FacilityBO facilityBoToCreate) {
	final Facility facility = DOBuilders.getFacilityDomainObjectFromBO(facilityBoToCreate);
	facilityDao.create(facility);
	if (facilityBoToCreate.getDrawDownBOList() != null) {
	    for (final DrawDownBO drawDownBO : facilityBoToCreate.getDrawDownBOList()) {
		drawDownService.createDrawDown(drawDownBO);
	    }
	}
    }

    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void createFacility(final Facility facilityToCreate) {
	facilityDao.create(facilityToCreate);
	if (facilityToCreate.getDrawDownList() != null) {
	    for (final DrawDown drawDown : facilityToCreate.getDrawDownList()) {
		drawDown.setFacility(facilityToCreate);
		drawDownService.createDrawDown(drawDown);
	    }
	}
    }

    @Override
    public List<FacilityBO> getAllFacility() {
	return BOBuilders.buildFacilityBOListFromDomainObjectList(facilityDao.findAll());
    }

}
