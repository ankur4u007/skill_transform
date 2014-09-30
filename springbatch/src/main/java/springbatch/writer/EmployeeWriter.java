package springbatch.writer;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import springbatch.model.Employee;

/**
 * Writes products to a database
 */
@Component("employeeWriter")
public class EmployeeWriter implements ItemWriter<Employee> {
    private static final String GET_PRODUCT = "select * from EMPLOYEE where empId = ?";
    private static final String INSERT_PRODUCT = "insert into EMPLOYEE(empId,empName,dateOfBirth,designation,manager,dateOfJoin,department,salary) "
	    + "values (?,?,?,?,?,?,?,?)";
    private static final String UPDATE_PRODUCT = "update EMPLOYEE set empName = ?, dateOfBirth = ?, designation = ?, "
	    + "manager = ?, dateOfJoin = ?, department = ?, salary= ? where empId = ?";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void write(final List<? extends Employee> employees) throws Exception {
	for (final Employee employee : employees) {
	    final List<Employee> employeeList = jdbcTemplate.query(GET_PRODUCT, new Object[] { employee.getEmpId() },
		    new RowMapper<Employee>() {
		public Employee mapRow(final ResultSet resultSet, final int rowNum) throws SQLException {
		    final Employee emp = new Employee();
		    emp.setEmpId(resultSet.getInt(1));
		    emp.setEmpName(resultSet.getString(2));
			    emp.setDateOfBirth(resultSet.getDate(3));
		    emp.setDesignation(resultSet.getString(4));
		    emp.setManager(resultSet.getString(5));
		    emp.setDateOfJoin(resultSet.getDate(6));
		    emp.setDepartment(resultSet.getString(7));
		    emp.setSalary(resultSet.getDouble(8));
		    return emp;
		}
	    });

	    if (employeeList.size() > 0) {
		jdbcTemplate.update(UPDATE_PRODUCT, employee.getEmpName(), employee.getDateOfBirth(),
			employee.getDesignation(), employee.getManager(), employee.getDateOfJoin(),
			employee.getDepartment(), employee.getSalary(), employee.getEmpId());
	    } else {
		jdbcTemplate.update(INSERT_PRODUCT, employee.getEmpId(), employee.getEmpName(),
			employee.getDateOfBirth(), employee.getDesignation(), employee.getManager(),
			employee.getDateOfJoin(), employee.getDepartment(), employee.getSalary());
	    }
	}
    }
}
