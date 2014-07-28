package com.gs.bank;

import java.util.List;

import com.gs.bank.customer.ICustomer;
import com.gs.bank.department.IDepartment;
import com.gs.bank.employee.IEmployee;

public class GsBank {

    private List<ICustomer> customers;
    private List<IEmployee> employess;
    private List<IDepartment> departments;

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

    /**
     * @return the employess
     */
    public final List<IEmployee> getEmployess() {
	return employess;
    }

    /**
     * @param employess
     *            the employess to set
     */
    public final void setEmployess(final List<IEmployee> employess) {
	this.employess = employess;
    }

    /**
     * @return the departments
     */
    public final List<IDepartment> getDepartments() {
	return departments;
    }

    /**
     * @param departments
     *            the departments to set
     */
    public final void setDepartments(final List<IDepartment> departments) {
	this.departments = departments;
    }

}
