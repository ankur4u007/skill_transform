package spingBank.factory.departmentFactory;

import java.util.List;

import spingBank.bo.departmentBOs.AbstractDepartmentBO;

public interface IDepartmentFactory {

    List<AbstractDepartmentBO> getDepartmentList();
}
