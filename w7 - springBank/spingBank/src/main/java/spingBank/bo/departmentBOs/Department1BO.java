package spingBank.bo.departmentBOs;

import java.util.List;

import spingBank.bo.employeeBOs.AbstractEmployeeBO;

/**
 * @author CHANDRAYAN
 *
 */
public class Department1BO extends AbstractDepartmentBO {

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
    public Department1BO(final String name, final List<AbstractEmployeeBO> employees, final String type,
	    final String otherInfo, final String typeOfWork, final boolean cabService) {
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

}
