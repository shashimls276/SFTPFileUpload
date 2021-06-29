package in.javakids.SFTPExample;

import in.javakids.SFTPExample.model.Employee;
import in.javakids.SFTPExample.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.List;

@Configuration
@EnableScheduling

public class EmployeeScheduler {
    @Autowired
    private EmployeeService employeeService;
    @Scheduled(fixedDelay = 30000)
    public void processXmlFiles(){
        employeeService.processXmlFiles();
    }
    @Scheduled(fixedRate = 20000)
    public void getEmployees(){
        List<Employee> list = employeeService.getAllEmployees();
        System.out.println(list.size());

        for(Employee e : list){
            System.out.println("Scheduler .........Status is :: "+e.getStatus());
        }
    }
}
