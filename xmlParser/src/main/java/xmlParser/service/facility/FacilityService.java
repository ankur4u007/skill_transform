package xmlParser.service.facility;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import xmlParser.bo.FacilityBO;
import xmlParser.builders.BOBuilder;
import xmlParser.builders.DOBuilder;
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
    public void createFacility(final xmlParser.jaxbobjects.Facility facilityToCreate) {
	final Facility facility = DOBuilder.getFacilityDomainObjectFromJAXBO(facilityToCreate);
	facilityDao.create(facility);
	if (facilityToCreate.getDrawDownList() != null) {
	    for (final xmlParser.jaxbobjects.DrawDown drawDown : facilityToCreate.getDrawDownList()) {
		drawDownService.createDrawDown(drawDown);
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
	return BOBuilder.buildFacilityBOListFromDomainObjectList(facilityDao.findAll());
    }

}
