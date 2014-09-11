/**
 *
 */
package xmlParser.dao.impl.drawdown;

import org.springframework.stereotype.Component;

import xmlParser.dao.AbstractDao;
import xmlParser.domainobject.DrawDown;

/**
 * @author CHANDRAYAN
 *
 */
@Component("drawDownDao")
public class DrawDownDao extends AbstractDao<Integer, DrawDown> implements IDrawDownDao {

}
