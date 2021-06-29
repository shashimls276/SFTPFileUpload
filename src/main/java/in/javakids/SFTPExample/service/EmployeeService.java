/**
 * 
 */
package in.javakids.SFTPExample.service;

import java.util.List;
import java.util.Optional;

import in.javakids.SFTPExample.XmlGenerator;
import in.javakids.SFTPExample.dao.EmployeeRepositoryDAO;
import in.javakids.SFTPExample.model.Employee;
import in.javakids.SFTPExample.utility.SFTPUpload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;


/**
 * @author Shashidhara ML
 *
 */
@Service
@Transactional
public class EmployeeService {

	@Autowired
	private EmployeeRepositoryDAO employeeRepositoryDAO;
	@Autowired
	private SFTPUpload sftpUpload;

	public void saveEmployee(Employee employee) {
		employeeRepositoryDAO.save(employee);
	}

	public Optional<Employee> getEmployeeById(long id) {
		return  employeeRepositoryDAO.findById(id);
	}

	public List<Employee> getAllEmployees() {

		return (List<Employee>) employeeRepositoryDAO.findAll();
	}

	public List<Employee> getNotProcessedEmployees(){

		List<Employee>  employee = employeeRepositoryDAO.findEmployeesByStatus();

		return employee;
	}

	public void processXmlFiles(){
		List<Employee>  employees = employeeRepositoryDAO.findEmployeesByStatus();

		for(Employee e : employees){
			//uploadFilesToSFTP(e);
			updateStatus(e.getId(),"Processed");
		}

	}

	public void uploadFilesToSFTP(){
		sftpUpload.uploadFile();
	}

	private void updateStatus(long id,String status){
		employeeRepositoryDAO.updateStatus(id,status);
	}

}
