/**
 *
 */
package spingBank.factory.employeeFactory;

import java.util.List;

import spingBank.bo.employeeBOs.AbstractEmployeeBO;

/**
 * @author CHANDRAYAN
 *
 */
public interface IEmployeeFactory {

    List<AbstractEmployeeBO> getEmployeeList();
}
