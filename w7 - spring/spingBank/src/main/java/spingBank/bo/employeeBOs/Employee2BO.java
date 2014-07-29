/**
 *
 */
package spingBank.bo.employeeBOs;

import java.util.List;

import spingBank.bo.departmentBOs.AbstractDepartmentBO;

/**
 * @author CHANDRAYAN
 *
 */
public class Employee2BO extends AbstractEmployeeBO {

    private List<AbstractEmployeeBO> serveToOtherEmp;

    /**
     * @param name
     * @param address
     * @param typeOfEmployee
     * @param departments
     * @param otherInfo
     * @param serveToOtherEmp
     */
    public Employee2BO(final String name, final String address, final String typeOfEmployee,
	    final List<AbstractDepartmentBO> departments, final String otherInfo,
	    final List<AbstractEmployeeBO> serveToOtherEmp) {
	super(name, address, typeOfEmployee, departments, otherInfo);
	this.serveToOtherEmp = serveToOtherEmp;
    }

    /**
     * @return the serveToOtherEmp
     */
    public final List<AbstractEmployeeBO> getServeToOtherEmp() {
	return serveToOtherEmp;
    }

    /**
     * @param serveToOtherEmp
     *            the serveToOtherEmp to set
     */
    public final void setServeToOtherEmp(final List<AbstractEmployeeBO> serveToOtherEmp) {
	this.serveToOtherEmp = serveToOtherEmp;
    }

}
