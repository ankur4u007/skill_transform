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
public class Department1 extends AbstractDepartment implements IDepartment {

    private String typeOfWork;
    private boolean cabService;

    /**
     * @param name
     * @param employees
     * @param type
     * @param otherInfo
     * @param typeOfWork
     * @param cabService
     */
    public Department1(final String name, final List<IEmployee> employees, final String type, final String otherInfo,
	    final String typeOfWork, final boolean cabService) {
	super(name, employees, type, otherInfo);
	this.typeOfWork = typeOfWork;
	this.cabService = cabService;
    }

    /**
     * @return the typeOfWork
     */
    public final String getTypeOfWork() {
	return typeOfWork;
    }

    /**
     * @param typeOfWork
     *            the typeOfWork to set
     */
    public final void setTypeOfWork(final String typeOfWork) {
	this.typeOfWork = typeOfWork;
    }

    /**
     * @return the cabService
     */
    public final boolean isCabService() {
	return cabService;
    }

    /**
     * @param cabService
     *            the cabService to set
     */
    public final void setCabService(final boolean cabService) {
	this.cabService = cabService;
    }

    public void addEmployee() {
	// TODO Auto-generated method stub

    }

    public void removeEmployee() {
	// TODO Auto-generated method stub

    }

}
