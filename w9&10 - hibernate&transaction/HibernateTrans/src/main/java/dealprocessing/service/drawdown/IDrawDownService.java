/**
 *
 */
package dealprocessing.service.drawdown;

import java.util.List;

import dealprocessing.bo.DrawDownBO;
import dealprocessing.domainobject.DrawDown;

/**
 * @author CHANDRAYAN
 *
 */
public interface IDrawDownService {

    void createDrawDown(DrawDownBO drawDownBoToCreate);

    void createDrawDown(DrawDown drawDownToCreate);

    List<DrawDownBO> getAllDrawDowns();

}
