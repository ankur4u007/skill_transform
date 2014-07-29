/**
 *
 */
package spingBank.bo.departmentBOs;

import java.util.List;

import spingBank.bo.employeeBOs.AbstractEmployeeBO;

/**
 * @author CHANDRAYAN
 *
 */
public class Department2BO extends AbstractDepartmentBO {

    private boolean isworkFromHome;

    /**
     * @param name
     * @param employees
     * @param type
     * @param otherInfo
     * @param isworkFromHome
     */
    public Department2BO(final String name, final List<AbstractEmployeeBO> employees, final String type,
	    final String otherInfo, final boolean isworkFromHome) {
	super(name, employees, type, otherInfo);
	this.isworkFromHome = isworkFromHome;
    }

    /**
     * @return the isworkFromHome
     */
    public final boolean isIsworkFromHome() {
	return isworkFromHome;
    }

    /**
     * @param isworkFromHome
     *            the isworkFromHome to set
     */
    public final void setIsworkFromHome(final boolean isworkFromHome) {
	this.isworkFromHome = isworkFromHome;
    }

}
