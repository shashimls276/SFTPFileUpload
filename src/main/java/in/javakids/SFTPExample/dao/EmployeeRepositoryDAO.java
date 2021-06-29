/**
 * 
 */
package in.javakids.SFTPExample.dao;

import java.util.List;

import in.javakids.SFTPExample.model.Employee;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;



/**
 * @author Shashidhara ML
 *
 */
@Repository
public interface EmployeeRepositoryDAO extends CrudRepository<Employee, Long> {
	
	public List<Employee> findByName(String name);

	public List<Employee> findByAge(@Param("age") int age);
	@Query("SELECT e FROM Employee e WHERE e.status = 'Not processed' or e.status IS NULL or e.status='' ")
	public List<Employee> findEmployeesByStatus();
	@Modifying
	@Query("update Employee e set e.status = :status where e.id = :id")
	void updateStatus(@Param(value = "id") long id, @Param(value = "status") String status);
}
