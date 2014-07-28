/**
 *
 */
package com.gs.bank.department.impl;

import java.util.List;

import com.gs.bank.department.AbstractDepartment;
import com.gs.bank.department.IDepartment;
import com.gs.bank.employee.IEmployee;

/**
 * @author CHANDRAYAN
 *
 */
public class Department2 extends AbstractDepartment implements IDepartment {

    private boolean isworkFromHome;

    /**
     * @param name
     * @param employees
     * @param type
     * @param otherInfo
     * @param isworkFromHome
     */
    public Department2(final String name, final List<IEmployee> employees, final String type, final String otherInfo,
	    final boolean isworkFromHome) {
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

    public void addEmployee() {
	// TODO Auto-generated method stub

    }

    public void removeEmployee() {
	// TODO Auto-generated method stub

    }

}
