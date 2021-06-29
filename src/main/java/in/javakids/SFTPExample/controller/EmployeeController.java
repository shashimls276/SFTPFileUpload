/**
 * 
 */
package in.javakids.SFTPExample.controller;

import java.util.List;
import java.util.Optional;

import in.javakids.SFTPExample.model.Employee;
import in.javakids.SFTPExample.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author Shashidhara ML
 *
 */
@RestController
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
	@RequestMapping(value = "/findAll")
	public List<Employee> getEmployees() {
		return employeeService.getAllEmployees();
	}
	
	@RequestMapping(value = "/findById/{id}")
	public Optional<Employee> getEmployee(@PathVariable("id") long id) {
		System.out.println("Id is ................................."+id);
		return employeeService.getEmployeeById(id);
	}
	
	@RequestMapping(value = "/save",method = RequestMethod.POST)
	public void saveEmployees(@RequestBody Employee employee) {
		employeeService.saveEmployee(employee);
	}

}
