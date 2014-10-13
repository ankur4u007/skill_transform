package xmlParser.service.drawdown;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import xmlParser.bo.DrawDownBO;
import xmlParser.builders.BOBuilder;
import xmlParser.builders.DOBuilder;
import xmlParser.dao.impl.drawdown.IDrawDownDao;
import xmlParser.domainobject.DrawDown;

@Component("drawdownservice")
@Transactional(readOnly = true)
public class DrawDownService implements IDrawDownService {

    @Autowired
    private IDrawDownDao drawDownDao;

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void createDrawDown(final xmlParser.jaxbobjects.DrawDown drawDownBoToCreate) {
	final DrawDown drawDown = DOBuilder.getDrawDownDomainObjectFromJAXBO(drawDownBoToCreate);
	drawDownDao.create(drawDown);
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void createDrawDown(final DrawDown drawDownToCreate) {
	final DrawDown existingDrawDown = drawDownDao.findById(drawDownToCreate.getId());
	if (existingDrawDown != null) {
	    drawDownDao.update(drawDownToCreate);
	} else {
	    drawDownDao.create(drawDownToCreate);
	}
    }

    public List<DrawDownBO> getAllDrawDowns() {
	return BOBuilder.buildDrawDownBOListFromDomainObjectList(drawDownDao.findAll());
    }

}
