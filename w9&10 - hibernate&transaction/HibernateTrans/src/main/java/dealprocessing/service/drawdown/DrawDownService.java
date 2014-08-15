package dealprocessing.service.drawdown;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import dealprocessing.bo.DrawDownBO;
import dealprocessing.builders.BOBuilders;
import dealprocessing.builders.DOBuilders;
import dealprocessing.dao.impl.drawdown.IDrawDownDao;
import dealprocessing.domainobject.DrawDown;

@Component("drawdownservice")
@Transactional(readOnly = true)
public class DrawDownService implements IDrawDownService {

    @Autowired
    private IDrawDownDao drawDownDao;

    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void createDrawDown(final DrawDownBO drawDownBoToCreate) {
	final DrawDown drawDown = DOBuilders.getDrawDownDomainObjectFromBO(drawDownBoToCreate);
	drawDownDao.create(drawDown);
    }

    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void createDrawDown(final DrawDown drawDownToCreate) {
	drawDownDao.create(drawDownToCreate);
    }

    @Override
    public List<DrawDownBO> getAllDrawDowns() {
	return BOBuilders.buildDrawDownBOListFromDomainObjectList(drawDownDao.findAll());
    }

}
