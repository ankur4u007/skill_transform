/**
 *
 */
package spingBank.bo.employeeBOs;

import java.util.List;

import spingBank.bo.customerBOs.AbstractCustomerBO;
import spingBank.bo.departmentBOs.AbstractDepartmentBO;

/**
 * @author CHANDRAYAN
 *
 */
public class Employee1BO extends AbstractEmployeeBO {

    private List<AbstractCustomerBO> customers;

    /**
     * @param name
     * @param address
     * @param typeOfEmployee
     * @param departments
     * @param otherInfo
     * @param customers
     */
    public Employee1BO(final String name, final String address, final String typeOfEmployee,
	    final List<AbstractDepartmentBO> departments, final String otherInfo,
	    final List<AbstractCustomerBO> customers) {
	super(name, address, typeOfEmployee, departments, otherInfo);
	this.customers = customers;
    }

    /**
     * @return the customers
     */
    public final List<AbstractCustomerBO> getCustomers() {
	return customers;
    }

    /**
     * @param customers
     *            the customers to set
     */
    public final void setCustomers(final List<AbstractCustomerBO> customers) {
	this.customers = customers;
    }
}
