package xmlParser.service.drawdown;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import xmlParser.bo.DrawDownBO;
import xmlParser.builders.BOBuilders;
import xmlParser.builders.DOBuilders;
import xmlParser.dao.impl.drawdown.IDrawDownDao;
import xmlParser.domainobject.DrawDown;

@Component("drawdownservice")
@Transactional(readOnly = true)
public class DrawDownService implements IDrawDownService {

    @Autowired
    private IDrawDownDao drawDownDao;

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void createDrawDown(final DrawDownBO drawDownBoToCreate) {
	final DrawDown drawDown = DOBuilders.getDrawDownDomainObjectFromBO(drawDownBoToCreate);
	drawDownDao.create(drawDown);
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void createDrawDown(final DrawDown drawDownToCreate) {
	drawDownDao.create(drawDownToCreate);
    }

    public List<DrawDownBO> getAllDrawDowns() {
	return BOBuilders.buildDrawDownBOListFromDomainObjectList(drawDownDao.findAll());
    }

}
