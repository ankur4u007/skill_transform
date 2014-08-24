package spingBank.bo.departmentBOs;

import java.util.List;

import spingBank.bo.employeeBOs.AbstractEmployeeBO;

public abstract class AbstractDepartmentBO {

    private String name;
    private List<AbstractEmployeeBO> employees;
    private String type;
    private String otherInfo;

    /**
     * @param name
     * @param employees
     * @param type
     * @param otherInfo
     */
    public AbstractDepartmentBO(final String name, final List<AbstractEmployeeBO> employees, final String type,
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
    public final List<AbstractEmployeeBO> getEmployees() {
	return employees;
    }

    /**
     * @param employees
     *            the employees to set
     */
    public final void setEmployees(final List<AbstractEmployeeBO> employees) {
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

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
	return "AbstractDepartmentBO [name=" + name + ", employees=" + employees + ", type=" + type + ", otherInfo="
		+ otherInfo + "]";
    }

}
