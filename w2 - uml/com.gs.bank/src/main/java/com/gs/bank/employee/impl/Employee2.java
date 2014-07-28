/**
 *
 */
package com.gs.bank.employee.impl;

import java.util.List;

import com.gs.bank.department.IDepartment;
import com.gs.bank.employee.AbstractEmployee;
import com.gs.bank.employee.IEmployee;

/**
 * @author CHANDRAYAN
 *
 */
public class Employee2 extends AbstractEmployee implements IEmployee {

    private List<IEmployee> serveToOtherEmp;

    /**
     * @param name
     * @param address
     * @param typeOfEmployee
     * @param departments
     * @param otherInfo
     * @param serveToOtherEmp
     */
    public Employee2(final String name, final String address, final String typeOfEmployee,
	    final List<IDepartment> departments, final String otherInfo, final List<IEmployee> serveToOtherEmp) {
	super(name, address, typeOfEmployee, departments, otherInfo);
	this.serveToOtherEmp = serveToOtherEmp;
    }

    /**
     * @return the serveToOtherEmp
     */
    public final List<IEmployee> getServeToOtherEmp() {
	return serveToOtherEmp;
    }

    /**
     * @param serveToOtherEmp
     *            the serveToOtherEmp to set
     */
    public final void setServeToOtherEmp(final List<IEmployee> serveToOtherEmp) {
	this.serveToOtherEmp = serveToOtherEmp;
    }

    public void doRoutineWork() {
	// TODO Auto-generated method stub

    }

}
