package com.gs.bank.department;

import java.util.List;

import com.gs.bank.employee.IEmployee;

public abstract class AbstractDepartment {

    private String name;
    private List<IEmployee> employees;
    private String type;
    private String otherInfo;

    /**
     * @param name
     * @param employees
     * @param type
     * @param otherInfo
     */
    public AbstractDepartment(final String name, final List<IEmployee> employees, final String type,
	    final String otherInfo) {
	super();
	this.name = name;
	this.employees = employees;
	this.type = type;
	this.otherInfo = otherInfo;
    }

    /**
     * @return the name
     */
    public final String getName() {
	return name;
    }

    /**
     * @param name
     *            the name to set
     */
    public final void setName(final String name) {
	this.name = name;
    }

    /**
     * @return the employees
     */
    public final List<IEmployee> getEmployees() {
	return employees;
    }

    /**
     * @param employees
     *            the employees to set
     */
    public final void setEmployees(final List<IEmployee> employees) {
	this.employees = employees;
    }

    /**
     * @return the type
     */
    public final String getType() {
	return type;
    }

    /**
     * @param type
     *            the type to set
     */
    public final void setType(final String type) {
	this.type = type;
    }

    /**
     * @return the otherInfo
     */
    public final String getOtherInfo() {
	return otherInfo;
    }

    /**
     * @param otherInfo
     *            the otherInfo to set
     */
    public final void setOtherInfo(final String otherInfo) {
	this.otherInfo = otherInfo;
    }

}
