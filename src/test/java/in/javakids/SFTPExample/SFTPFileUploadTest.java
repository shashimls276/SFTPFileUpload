package in.javakids.SFTPExample;

import in.javakids.SFTPExample.service.EmployeeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class SFTPFileUploadTest {
    @Autowired
    private EmployeeService employeeService;

    @Test
    void contextLoads() {
    }
    @Test
    public void fileUpload(){
        employeeService.uploadFilesToSFTP();
    }
}
