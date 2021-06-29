/**
 * 
 */
package in.javakids.SFTPExample;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import in.javakids.SFTPExample.dao.EmployeeRepositoryDAO;
import in.javakids.SFTPExample.model.Address;
import in.javakids.SFTPExample.model.Employee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;




/**
 * @author Shashidhara ML
 *
 */
@Component
public class EmployeeRepositoryTest implements CommandLineRunner{
	
	private static final Logger log = 
			LoggerFactory.getLogger(EmployeeRepositoryTest.class);
	
	@Autowired
	private EmployeeRepositoryDAO employeeRepositoryDAO;

	@Override
	public void run(String... args) throws Exception {
		
		Employee e = new Employee();
		e.setAge("20");
		e.setName("shashi");
		e.setStatus("");

		
		Address address = new Address();
		
		address.setAddressline1("Bangalore");
		address.setCity("Bangalore");
		address.setEmployee(e);
		
		Set<Address> addr = new HashSet<Address>();
		addr.add(address);
		e.setAddress(addr);
		
		employeeRepositoryDAO.save(e);
		
		List<Employee> employees = (List<Employee>) employeeRepositoryDAO.findAll();
		
		log.info("Employees Size : "+employees.size());
		
	}

}
