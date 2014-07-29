package spingBank.bo.employeeBOs;

import java.util.List;

import spingBank.bo.departmentBOs.AbstractDepartmentBO;

public abstract class AbstractEmployeeBO {

    private String name;
    private String address;
    private String typeOfEmployee;
    private List<AbstractDepartmentBO> departments;
    private String otherInfo;

    /**
     * @param name
     * @param address
     * @param typeOfEmployee
     * @param departments
     * @param otherInfo
     */
    public AbstractEmployeeBO(final String name, final String address, final String typeOfEmployee,
	    final List<AbstractDepartmentBO> departments, final String otherInfo) {
	super();
	this.name = name;
	this.address = address;
	this.typeOfEmployee = typeOfEmployee;
	this.departments = departments;
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
     * @return the address
     */
    public final String getAddress() {
	return address;
    }

    /**
     * @param address
     *            the address to set
     */
    public final void setAddress(final String address) {
	this.address = address;
    }

    /**
     * @return the typeOfEmployee
     */
    public final String getTypeOfEmployee() {
	return typeOfEmployee;
    }

    /**
     * @param typeOfEmployee
     *            the typeOfEmployee to set
     */
    public final void setTypeOfEmployee(final String typeOfEmployee) {
	this.typeOfEmployee = typeOfEmployee;
    }

    /**
     * @return the departments
     */
    public final List<AbstractDepartmentBO> getDepartments() {
	return departments;
    }

    /**
     * @param departments
     *            the departments to set
     */
    public final void setDepartments(final List<AbstractDepartmentBO> departments) {
	this.departments = departments;
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
	return "AbstractEmployeeBO [name=" + name + ", address=" + address + ", typeOfEmployee=" + typeOfEmployee
		+ ", departments=" + departments + ", otherInfo=" + otherInfo + "]";
    }

}
