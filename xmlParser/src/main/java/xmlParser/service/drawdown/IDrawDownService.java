/**
 *
 */
package xmlParser.service.drawdown;

import java.util.List;

import xmlParser.bo.DrawDownBO;
import xmlParser.domainobject.DrawDown;

/**
 * @author CHANDRAYAN
 *
 */
public interface IDrawDownService {

    void createDrawDown(DrawDownBO drawDownBoToCreate);

    void createDrawDown(DrawDown drawDownToCreate);

    List<DrawDownBO> getAllDrawDowns();

}
