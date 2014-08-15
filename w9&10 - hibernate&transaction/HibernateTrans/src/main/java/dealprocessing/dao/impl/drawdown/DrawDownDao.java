/**
 *
 */
package dealprocessing.dao.impl.drawdown;

import org.springframework.stereotype.Component;

import dealprocessing.dao.AbstractDao;
import dealprocessing.domainobject.DrawDown;

/**
 * @author CHANDRAYAN
 *
 */
@Component("drawDownDao")
public class DrawDownDao extends AbstractDao<Integer, DrawDown> implements IDrawDownDao {

}
