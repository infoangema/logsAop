package angema.base.logsAop.app.registros;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import angema.base.logsAop.core.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Employee Service
 * @author Ramesh
 *
 */
@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    public List < Employee > getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Optional < Employee > getEmployeeById(Long employeeId)
            throws ResourceNotFoundException {
        return employeeRepository.findById(employeeId);
    }

    public Employee createEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public Employee updateEmployee(Long employeeId,
                                   Employee employeeDetails) throws ResourceNotFoundException {
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + employeeId));

        employee.setEmailId(employeeDetails.getEmailId());
        employee.setLastName(employeeDetails.getLastName());
        employee.setFirstName(employeeDetails.getFirstName());
        final Employee updatedEmployee = employeeRepository.save(employee);
        return updatedEmployee;
    }

    public Map < String, Boolean > deleteEmployee(Long employeeId)
            throws ResourceNotFoundException {
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + employeeId));

        employeeRepository.delete(employee);
        Map < String, Boolean > response = new HashMap < > ();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}
