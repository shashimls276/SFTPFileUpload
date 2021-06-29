package in.javakids.SFTPExample;

import in.javakids.SFTPExample.model.Employee;
import in.javakids.SFTPExample.service.EmployeeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class SftpExampleApplicationTests {

	@Autowired
	private EmployeeService employeeService;

	@Test
	void contextLoads() {
	}
	@Test
	public void testing(){
		List<Employee> list = employeeService.getNotProcessedEmployees();
		System.out.println("Not Processed Employee List :: "+list.size());

		for(Employee e : list){
			System.out.println("Status is :: "+e.getStatus());
		}
	}

}
