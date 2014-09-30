package springbatch.model;

import java.util.Date;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("employee")
@Scope("prototype")
public class Employee {

    private Integer empId;
    private String empName;
    private Date dateOfBirth;
    private String designation;
    private String manager;
    private Date dateOfJoin;
    private String department;
    private Double salary;

    /**
     * @return the empId
     */
    public final Integer getEmpId() {
	return empId;
    }

    /**
     * @return the empName
     */
    public final String getEmpName() {
	return empName;
    }

    /**
     * @return the dateOfBirth
     */
    public final Date getDateOfBirth() {
	return dateOfBirth;
    }

    /**
     * @return the designation
     */
    public final String getDesignation() {
	return designation;
    }

    /**
     * @return the manager
     */
    public final String getManager() {
	return manager;
    }

    /**
     * @return the dateOfJoin
     */
    public final Date getDateOfJoin() {
	return dateOfJoin;
    }

    /**
     * @return the department
     */
    public final String getDepartment() {
	return department;
    }

    /**
     * @return the salary
     */
    public final Double getSalary() {
	return salary;
    }

    /**
     * @param empId
     *            the empId to set
     */
    public final void setEmpId(final Integer empId) {
	this.empId = empId;
    }

    /**
     * @param empName
     *            the empName to set
     */
    public final void setEmpName(final String empName) {
	this.empName = empName;
    }

    /**
     * @param dateOfBirth
     *            the dateOfBirth to set
     */
    public final void setDateOfBirth(final Date dateOfBirth) {
	this.dateOfBirth = dateOfBirth;
    }

    /**
     * @param designation
     *            the designation to set
     */
    public final void setDesignation(final String designation) {
	this.designation = designation;
    }

    /**
     * @param manager
     *            the manager to set
     */
    public final void setManager(final String manager) {
	this.manager = manager;
    }

    /**
     * @param dateOfJoin
     *            the dateOfJoin to set
     */
    public final void setDateOfJoin(final Date dateOfJoin) {
	this.dateOfJoin = dateOfJoin;
    }

    /**
     * @param department
     *            the department to set
     */
    public final void setDepartment(final String department) {
	this.department = department;
    }

    /**
     * @param salary
     *            the salary to set
     */
    public final void setSalary(final Double salary) {
	this.salary = salary;
    }

}
