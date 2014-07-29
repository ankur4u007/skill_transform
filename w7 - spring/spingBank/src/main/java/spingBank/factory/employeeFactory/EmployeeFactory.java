package spingBank.factory.employeeFactory;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import spingBank.bo.customerBOs.AbstractCustomerBO;
import spingBank.bo.departmentBOs.AbstractDepartmentBO;
import spingBank.bo.departmentBOs.Department1BO;
import spingBank.bo.employeeBOs.AbstractEmployeeBO;
import spingBank.bo.employeeBOs.Employee1BO;
import spingBank.factory.customerFactory.ICustomerFactory;

@Component("employeeFactory")
public class EmployeeFactory implements IEmployeeFactory {

    @Autowired
    private ICustomerFactory customerFactory;

    public List<AbstractEmployeeBO> getEmployeeList() {
	return getEmployeeFromDb();
    }

    private List<AbstractEmployeeBO> getEmployeeFromDb() {
	// since there is no db here, we are getting dummy Employee list
	final List<AbstractEmployeeBO> boList = new ArrayList<AbstractEmployeeBO>();
	final List<AbstractCustomerBO> customerList = getPriviledgedCustomerList();
	final List<AbstractDepartmentBO> departmentBoList = new ArrayList<AbstractDepartmentBO>();
	departmentBoList.add(new Department1BO("dep1", null, "PNL", null, "MIDDLE_OFFCIE", false));

	final Employee1BO e1 = new Employee1BO("e1", "e1_address", "MIDDLE_OFFICE", departmentBoList, null,
		customerList);
	final Employee1BO e2 = new Employee1BO("e2", "e2_address", "FRONT_OFFICE", departmentBoList, null, customerList);
	boList.add(e1);
	boList.add(e2);
	return boList;
    }

    private List<AbstractCustomerBO> getPriviledgedCustomerList() {
	final List<AbstractCustomerBO> custList = customerFactory.getCustomerList();
	if (custList != null) {
	    for (final AbstractCustomerBO bo : custList) {
		if (!bo.isPrivileged()) {
		    custList.remove(bo);
		}
	    }
	}
	return custList;
    }
}
