package xmlParser.service.facility;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import xmlParser.bo.DrawDownBO;
import xmlParser.bo.FacilityBO;
import xmlParser.builders.BOBuilders;
import xmlParser.builders.DOBuilders;
import xmlParser.dao.impl.facility.IFacilityDao;
import xmlParser.domainobject.DrawDown;
import xmlParser.domainobject.Facility;
import xmlParser.service.drawdown.IDrawDownService;

@Component("facilityService")
@Transactional(readOnly = true)
public class FacilityService implements IFacilityService {

    @Autowired
    private IFacilityDao facilityDao;
    @Autowired
    private IDrawDownService drawDownService;

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

    public List<FacilityBO> getAllFacility() {
	return BOBuilders.buildFacilityBOListFromDomainObjectList(facilityDao.findAll());
    }

}
