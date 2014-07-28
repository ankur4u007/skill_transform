/**
 *
 */
package com.gs.bank.employee.impl;

import java.util.List;

import com.gs.bank.customer.ICustomer;
import com.gs.bank.department.IDepartment;
import com.gs.bank.employee.AbstractEmployee;
import com.gs.bank.employee.IEmployee;

/**
 * @author CHANDRAYAN
 *
 */
public class Employee1 extends AbstractEmployee implements IEmployee {

    private List<ICustomer> customers;

    /**
     * @param name
     * @param address
     * @param typeOfEmployee
     * @param departments
     * @param otherInfo
     * @param customers
     */
    public Employee1(final String name, final String address, final String typeOfEmployee,
	    final List<IDepartment> departments, final String otherInfo, final List<ICustomer> customers) {
	super(name, address, typeOfEmployee, departments, otherInfo);
	this.customers = customers;
    }

    /**
     * @return the customers
     */
    public final List<ICustomer> getCustomers() {
	return customers;
    }

    /**
     * @param customers
     *            the customers to set
     */
    public final void setCustomers(final List<ICustomer> customers) {
	this.customers = customers;
    }

    public void doRoutineWork() {
	// TODO Auto-generated method stub

    }
}
